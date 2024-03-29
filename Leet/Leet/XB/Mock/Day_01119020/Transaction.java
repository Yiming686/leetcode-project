package Leet.XB.Mock.Day_01119020;
public class Transaction {

    /**
     * The status of a closed transaction (committed or rolled back).
     */
    public static final int STATUS_CLOSED = 0;

    /**
     * The status of an open transaction.
     */
    public static final int STATUS_OPEN = 1;

    /**
     * The status of a prepared transaction.
     */
    public static final int STATUS_PREPARED = 2;

    /**
     * The status of a transaction that has been logically committed or rather
     * marked as committed, because it might be still listed among prepared,
     * if it was prepared for commit. Undo log entries might still exists for it
     * and not all of it's changes within map's are re-written as committed yet.
     * Nevertheless, those changes should be already viewed by other
     * transactions as committed.
     * This transaction's id can not be re-used until all of the above is completed
     * and transaction is closed.
     * A transactions can be observed in this state when the store was
     * closed while the transaction was not closed yet.
     * When opening a store, such transactions will automatically
     * be processed and closed as committed.
     */
    public static final int STATUS_COMMITTED = 3;

    /**
     * The status of a transaction that currently in a process of rolling back
     * to a savepoint.
     */
    private static final int STATUS_ROLLING_BACK = 4;

    /**
     * The status of a transaction that has been rolled back completely,
     * but undo operations are not finished yet.
     */
    private static final int STATUS_ROLLED_BACK  = 5;

    private static final String[] STATUS_NAMES = {
            "CLOSED", "OPEN", "PREPARED", "COMMITTED", "ROLLING_BACK", "ROLLED_BACK"
    };
    /**
     * How many bits of the "operation id" we store in the transaction belong to the
     * log id (the rest belong to the transaction id).
     */
    static final int LOG_ID_BITS = 40;
    private static final int LOG_ID_BITS1 = LOG_ID_BITS + 1;
    private static final long LOG_ID_LIMIT = 1L << LOG_ID_BITS;
    private static final long LOG_ID_MASK = (1L << LOG_ID_BITS1) - 1;
    private static final int STATUS_BITS = 4;
    private static final int STATUS_MASK = (1 << STATUS_BITS) - 1;


    /**
     * The transaction store.
     */
    final TransactionStore store;

    /**
     * Listener for this transaction's rollback changes.
     */
    final TransactionStore.RollbackListener listener;

    /**
     * The transaction id.
     * More appropriate name for this field would be "slotId"
     */
    final int transactionId;

    /**
     * This is really a transaction identity, because it's not re-used.
     */
    final long sequenceNum;

    /*
     * Transaction state is an atomic composite field:
     * bit  45      : flag whether transaction had rollback(s)
     * bits 44-41   : status
     * bits 40      : overflow control bit, 1 indicates overflow
     * bits 39-0    : log id of the last entry in the undo log map
     */
    private final AtomicLong statusAndLogId;

    /**
     * Reference to a counter for an earliest store version used by this transaction.
     * Referenced version and all newer ones can not be discarded
     * at least until this transaction ends.
     */
    private MVStore.TxCounter txCounter;

    /**
     * Transaction name.
     */
    private String name;

    /**
     * Indicates whether this transaction was stored in preparedTransactions map
     */
    boolean wasStored;

    /**
     * How long to wait for blocking transaction to commit or rollback.
     */
    int timeoutMillis;

    /**
     * Identification of the owner of this transaction,
     * usually the owner is a database session.
     */
    private final int ownerId;

    /**
     * Blocking transaction, if any
     */
    private volatile Transaction blockingTransaction;

    /**
     * Map on which this transaction is blocked.
     */
    private String blockingMapName;

    /**
     * Key in blockingMap on which this transaction is blocked.
     */
    private Object blockingKey;

    /**
     * Whether other transaction(s) are waiting for this to close.
     */
    private volatile boolean notificationRequested;

    /**
     * RootReferences for undo log snapshots
     */
    private RootReference<Long,Record<?,?>>[] undoLogRootReferences;

    /**
     * Map of transactional maps for this transaction
     */
    private final Map<Integer, TransactionMap<?,?>> transactionMaps = new HashMap<>();

    /**
     * The current isolation level.
     */
    IsolationLevel isolationLevel = IsolationLevel.READ_COMMITTED;


    Transaction(TransactionStore store, int transactionId, long sequenceNum, int status,
                String name, long logId, int timeoutMillis, int ownerId,
                TransactionStore.RollbackListener listener) {
        this.store = store;
        this.transactionId = transactionId;
        this.sequenceNum = sequenceNum;
        this.statusAndLogId = new AtomicLong(composeState(status, logId, false));
        this.name = name;
        setTimeoutMillis(timeoutMillis);
        this.ownerId = ownerId;
        this.listener = listener;
    }

    public int getId() {
        return transactionId;
    }

    public long getSequenceNum() {
        return sequenceNum;
    }

    public int getStatus() {
        return getStatus(statusAndLogId.get());
    }

    /**
     * Create a snapshot for the given map id.
     *
     * @param mapId the map id
     * @return the root reference
     */
    <K,V> Snapshot<K,VersionedValue<V>> createSnapshot(int mapId) {
        // The purpose of the following loop is to get a coherent picture
        // of a state of two independent volatile / atomic variables,
        // which they had at some recent moment in time.
        // In order to get such a "snapshot", we wait for a moment of silence,
        // when neither of the variables concurrently changes it's value.
        BitSet committingTransactions;
        RootReference<K,VersionedValue<V>> root;
        do {
            committingTransactions = store.committingTransactions.get();
            MVMap<K,VersionedValue<V>> map = store.getMap(mapId);
            root = map.flushAndGetRoot();
        } while (committingTransactions != store.committingTransactions.get());
        return new Snapshot<>(root, committingTransactions);
    }

    RootReference<Long,Record<?,?>>[] getUndoLogRootReferences() {
        return undoLogRootReferences;
    }

    /**
     * Changes transaction status to a specified value
     * @param status to be set
     * @return transaction state as it was before status change
     */
    private long setStatus(int status) {
        while (true) {
            long currentState = statusAndLogId.get();
            long logId = getLogId(currentState);
            int currentStatus = getStatus(currentState);
            boolean valid;
            switch (status) {
                case STATUS_ROLLING_BACK:
                    valid = currentStatus == STATUS_OPEN;
                    break;
                case STATUS_PREPARED:
                    valid = currentStatus == STATUS_OPEN;
                    break;
                case STATUS_COMMITTED:
                    valid = currentStatus == STATUS_OPEN ||
                            currentStatus == STATUS_PREPARED ||
                            // this case is only possible if called
                            // from endLeftoverTransactions()
                            currentStatus == STATUS_COMMITTED;
                    break;
                case STATUS_ROLLED_BACK:
                    valid = currentStatus == STATUS_OPEN ||
                            currentStatus == STATUS_PREPARED;
                    break;
                case STATUS_CLOSED:
                    valid = currentStatus == STATUS_COMMITTED ||
                            currentStatus == STATUS_ROLLED_BACK;
                    break;
                case STATUS_OPEN:
                default:
                    valid = false;
                    break;
            }
            if (!valid) {
                throw DataUtils.newIllegalStateException(
                        DataUtils.ERROR_TRANSACTION_ILLEGAL_STATE,
                        "Transaction was illegally transitioned from {0} to {1}",
                        STATUS_NAMES[currentStatus], STATUS_NAMES[status]);
            }
            long newState = composeState(status, logId, hasRollback(currentState));
            if (statusAndLogId.compareAndSet(currentState, newState)) {
                return currentState;
            }
        }
    }

    /**
     * Determine if any database changes were made as part of this transaction.
     *
     * @return true if there are changes to commit, false otherwise
     */
    public boolean hasChanges() {
        return hasChanges(statusAndLogId.get());
    }

    public void setName(String name) {
        checkNotClosed();
        this.name = name;
        store.storeTransaction(this);
    }

    public String getName() {
        return name;
    }

    public int getBlockerId() {
        Transaction blocker = this.blockingTransaction;
        return blocker == null ? 0 : blocker.ownerId;
    }

    /**
     * Create a new savepoint.
     *
     * @return the savepoint id
     */
    public long setSavepoint() {
        return getLogId();
    }

    /**
     * Returns whether statement dependencies are currently set.
     *
     * @return whether statement dependencies are currently set
     */
    public boolean hasStatementDependencies() {
        return !transactionMaps.isEmpty();
    }

    /**
     * Sets the new isolation level. May be called only after creation of the
     * transaction.
     *
     * @param isolationLevel the new isolation level
     */
    public void setIsolationLevel(IsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    /**
     * Returns the isolation level of this transaction.
     *
     * @return the isolation level of this transaction
     */
    public IsolationLevel getIsolationLevel() {
        return isolationLevel;
    }

    /**
     * Mark an entry into a new SQL statement execution within this transaction.
     *
     * @param maps
     *            set of maps used by transaction or statement is about to be executed
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public void markStatementStart(HashSet<MVMap<Object,VersionedValue<Object>>> maps) {
        markStatementEnd();
        if (txCounter == null) {
            txCounter = store.store.registerVersionUsage();
        }

        if (maps != null && !maps.isEmpty()) {
            // The purpose of the following loop is to get a coherent picture
            // In order to get such a "snapshot", we wait for a moment of silence,
            // when no new transaction were committed / closed.
            BitSet committingTransactions;
            do {
                committingTransactions = store.committingTransactions.get();
                for (MVMap<Object,VersionedValue<Object>> map : maps) {
                    TransactionMap<?,?> txMap = openMapX(map);
                    txMap.setStatementSnapshot(new Snapshot(map.flushAndGetRoot(), committingTransactions));
                }
                if (isolationLevel == IsolationLevel.READ_COMMITTED) {
                    undoLogRootReferences = store.collectUndoLogRootReferences();
                }
            } while (committingTransactions != store.committingTransactions.get());
            // Now we have a snapshot, where each map RootReference point to state of the map,
            // undoLogRootReferences captures the state of undo logs
            // and committingTransactions mask tells us which of seemingly uncommitted changes
            // should be considered as committed.
            // Subsequent processing uses this snapshot info only.
            for (MVMap<Object,VersionedValue<Object>> map : maps) {
                TransactionMap<?,?> txMap = openMapX(map);
                txMap.promoteSnapshot();
            }
        }
    }

    /**
     * Mark an exit from SQL statement execution within this transaction.
     */
    public void markStatementEnd() {
        if (isolationLevel.allowNonRepeatableRead()) {
            releaseSnapshot();
        }
        for (TransactionMap<?, ?> transactionMap : transactionMaps.values()) {
            transactionMap.setStatementSnapshot(null);
        }
    }

    private void markTransactionEnd() {
        if (!isolationLevel.allowNonRepeatableRead()) {
            releaseSnapshot();
        }
    }

    private void releaseSnapshot() {
        transactionMaps.clear();
        undoLogRootReferences = null;
        MVStore.TxCounter counter = txCounter;
        if (counter != null) {
            txCounter = null;
            store.store.deregisterVersionUsage(counter);
        }
    }

    /**
     * Add a log entry.
     *
     * @param logRecord to append
     *
     * @return key for the newly added undo log entry
     */
    long log(Record<?,?> logRecord) {
        long currentState = statusAndLogId.getAndIncrement();
        long logId = getLogId(currentState);
        if (logId >= LOG_ID_LIMIT) {
            throw DataUtils.newIllegalStateException(
                    DataUtils.ERROR_TRANSACTION_TOO_BIG,
                    "Transaction {0} has too many changes",
                    transactionId);
        }
        int currentStatus = getStatus(currentState);
        checkOpen(currentStatus);
        long undoKey = store.addUndoLogRecord(transactionId, logId, logRecord);
        return undoKey;
    }

    /**
     * Remove the last log entry.
     */
    void logUndo() {
        long currentState = statusAndLogId.decrementAndGet();
        long logId = getLogId(currentState);
        if (logId >= LOG_ID_LIMIT) {
            throw DataUtils.newIllegalStateException(
                    DataUtils.ERROR_TRANSACTION_CORRUPT,
                    "Transaction {0} has internal error",
                    transactionId);
        }
        int currentStatus = getStatus(currentState);
        checkOpen(currentStatus);
        store.removeUndoLogRecord(transactionId);
    }

    /**
     * Open a data map.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param name the name of the map
     * @return the transaction map
     */
    public <K, V> TransactionMap<K, V> openMap(String name) {
        return openMap(name, null, null);
    }

    /**
     * Open the map to store the data.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param name the name of the map
     * @param keyType the key data type
     * @param valueType the value data type
     * @return the transaction map
     */
    public <K, V> TransactionMap<K, V> openMap(String name,
                                                DataType<K> keyType,
                                                DataType<V> valueType) {
        MVMap<K, VersionedValue<V>> map = store.openMap(name, keyType, valueType);
        return openMapX(map);
    }

    /**
     * Open the transactional version of the given map.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param map the base map
     * @return the transactional map
     */
    @SuppressWarnings("unchecked")
    public <K, V> TransactionMap<K,V> openMapX(MVMap<K,VersionedValue<V>> map) {
        checkNotClosed();
        int id = map.getId();
        TransactionMap<K,V> transactionMap = (TransactionMap<K,V>)transactionMaps.get(id);
        if (transactionMap == null) {
            transactionMap = new TransactionMap<>(this, map);
            transactionMaps.put(id, transactionMap);
        }
        return transactionMap;
    }

    /**
     * Prepare the transaction. Afterwards, the transaction can only be
     * committed or completely rolled back.
     */
    public void prepare() {
        setStatus(STATUS_PREPARED);
        store.storeTransaction(this);
    }

    /**
     * Commit the transaction. Afterwards, this transaction is closed.
     */
    public void commit() {
        assert store.openTransactions.get().get(transactionId);
        markTransactionEnd();
        Throwable ex = null;
        boolean hasChanges = false;
        int previousStatus = STATUS_OPEN;
        try {
            long state = setStatus(STATUS_COMMITTED);
            hasChanges = hasChanges(state);
            previousStatus = getStatus(state);
            if (hasChanges) {
                store.commit(this, previousStatus == STATUS_COMMITTED);
            }
        } catch (Throwable e) {
            ex = e;
            throw e;
        } finally {
            if (isActive(previousStatus)) {
                try {
                    store.endTransaction(this, hasChanges);
                } catch (Throwable e) {
                    if (ex == null) {
                        throw e;
                    } else {
                        ex.addSuppressed(e);
                    }
                }
            }
        }
    }

    /**
     * Roll back to the given savepoint. This is only allowed if the
     * transaction is open.
     *
     * @param savepointId the savepoint id
     */
    public void rollbackToSavepoint(long savepointId) {
        long lastState = setStatus(STATUS_ROLLING_BACK);
        long logId = getLogId(lastState);
        boolean success;
        try {
            store.rollbackTo(this, logId, savepointId);
        } finally {
            if (notificationRequested) {
                notifyAllWaitingTransactions();
            }
            long expectedState = composeState(STATUS_ROLLING_BACK, logId, hasRollback(lastState));
            long newState = composeState(STATUS_OPEN, savepointId, true);
            do {
                success = statusAndLogId.compareAndSet(expectedState, newState);
            } while (!success && statusAndLogId.get() == expectedState);
        }
        // this is moved outside of finally block to avert masking original exception, if any
        if (!success) {
            throw DataUtils.newIllegalStateException(
                    DataUtils.ERROR_TRANSACTION_ILLEGAL_STATE,
                    "Transaction {0} concurrently modified while rollback to savepoint was in progress",
                    transactionId);
        }
    }

    /**
     * Roll the transaction back. Afterwards, this transaction is closed.
     */
    public void rollback() {
        markTransactionEnd();
        Throwable ex = null;
        int status = STATUS_OPEN;
        try {
            long lastState = setStatus(STATUS_ROLLED_BACK);
            status = getStatus(lastState);
            long logId = getLogId(lastState);
            if (logId > 0) {
                store.rollbackTo(this, logId, 0);
            }
        } catch (Throwable e) {
            status = getStatus();
            if (isActive(status)) {
                ex = e;
                throw e;
            }
        } finally {
            try {
                if (isActive(status)) {
                    store.endTransaction(this, true);
                }
            } catch (Throwable e) {
                if (ex == null) {
                    throw e;
                } else {
                    ex.addSuppressed(e);
                }
            }
        }
    }

    private static boolean isActive(int status) {
        return status != STATUS_CLOSED
            && status != STATUS_COMMITTED
            && status != STATUS_ROLLED_BACK;
    }

    /**
     * Get the list of changes, starting with the latest change, up to the
     * given savepoint (in reverse order than they occurred). The value of
     * the change is the value before the change was applied.
     *
     * @param savepointId the savepoint id, 0 meaning the beginning of the
     *            transaction
     * @return the changes
     */
    public Iterator<TransactionStore.Change> getChanges(long savepointId) {
        return store.getChanges(this, getLogId(), savepointId);
    }

    /**
     * Sets the new lock timeout.
     *
     * @param timeoutMillis the new lock timeout in milliseconds
     */
    public void setTimeoutMillis(int timeoutMillis) {
        this.timeoutMillis = timeoutMillis > 0 ? timeoutMillis : store.timeoutMillis;
    }

    private long getLogId() {
        return getLogId(statusAndLogId.get());
    }

    /**
     * Check whether this transaction is open.
     */
    private void checkOpen(int status) {
        if (status != STATUS_OPEN) {
            throw DataUtils.newIllegalStateException(
                    DataUtils.ERROR_TRANSACTION_ILLEGAL_STATE,
                    "Transaction {0} has status {1}, not OPEN", transactionId, STATUS_NAMES[status]);
        }
    }

    /**
     * Check whether this transaction is open or prepared.
     */
    private void checkNotClosed() {
        if (getStatus() == STATUS_CLOSED) {
            throw DataUtils.newIllegalStateException(
                    DataUtils.ERROR_CLOSED, "Transaction {0} is closed", transactionId);
        }
    }

    /**
     * Transition this transaction into a closed state.
     */
    void closeIt() {
        transactionMaps.clear();
        long lastState = setStatus(STATUS_CLOSED);
        store.store.deregisterVersionUsage(txCounter);
        if((hasChanges(lastState) || hasRollback(lastState)) && notificationRequested) {
            notifyAllWaitingTransactions();
        }
    }

    private synchronized void notifyAllWaitingTransactions() {
        notifyAll();
    }

    /**
     * Make this transaction to wait for the specified transaction to be closed,
     * because both of them try to modify the same map entry.
     *
     * @param toWaitFor transaction to wait for
     * @param mapName name of the map containing blocking entry
     * @param key of the blocking entry
     * @return true if other transaction was closed and this one can proceed, false if timed out
     */
    public boolean waitFor(Transaction toWaitFor, String mapName, Object key) {
        blockingTransaction = toWaitFor;
        blockingMapName = mapName;
        blockingKey = key;
        if (isDeadlocked(toWaitFor)) {
            StringBuilder details = new StringBuilder(
                    String.format("Transaction %d has been chosen as a deadlock victim. Details:%n", transactionId));
            for (Transaction tx = toWaitFor, nextTx; (nextTx = tx.blockingTransaction) != null; tx = nextTx) {
                details.append(String.format(
                        "Transaction %d attempts to update map <%s> entry with key <%s> modified by transaction %s%n",
                        tx.transactionId, tx.blockingMapName, tx.blockingKey, tx.blockingTransaction));
                if (nextTx == this) {
                    details.append(String.format(
                            "Transaction %d attempts to update map <%s> entry with key <%s>"
                                    + " modified by transaction %s%n",
                            transactionId, blockingMapName, blockingKey, toWaitFor));
                    if (isDeadlocked(toWaitFor)) {
                        throw DataUtils.newIllegalStateException(DataUtils.ERROR_TRANSACTIONS_DEADLOCK, "{0}",
                                details.toString());
                    }
                }
            }
        }

        try {
            return toWaitFor.waitForThisToEnd(timeoutMillis);
        } finally {
            blockingMapName = null;
            blockingKey = null;
            blockingTransaction = null;
        }
    }

    private boolean isDeadlocked(Transaction toWaitFor) {
        for(Transaction tx = toWaitFor, nextTx;
            (nextTx = tx.blockingTransaction) != null && tx.getStatus() == Transaction.STATUS_OPEN;
            tx = nextTx) {
            if (nextTx == this) {
                return true;
            }
        }
        return false;
    }

    private synchronized boolean waitForThisToEnd(int millis) {
        long until = System.currentTimeMillis() + millis;
        notificationRequested = true;
        long state;
        int status;
        while((status = getStatus(state = statusAndLogId.get())) != STATUS_CLOSED
                && status != STATUS_ROLLED_BACK && !hasRollback(state)) {
            long dur = until - System.currentTimeMillis();
            if(dur <= 0) {
                return false;
            }
            try {
                wait(dur);
            } catch (InterruptedException ex) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove the map.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param map the map
     */
    public <K, V> void removeMap(TransactionMap<K, V> map) {
        store.removeMap(map);
    }

    @Override
    public String toString() {
        return transactionId + "(" + sequenceNum + ") " + stateToString();
    }

    private String stateToString() {
        return stateToString(statusAndLogId.get());
    }

    private static String stateToString(long state) {
        return STATUS_NAMES[getStatus(state)] + (hasRollback(state) ? "<" : "") + " " + getLogId(state);
    }


    private static int getStatus(long state) {
        return (int)(state >>> LOG_ID_BITS1) & STATUS_MASK;
    }

    private static long getLogId(long state) {
        return state & LOG_ID_MASK;
    }

    private static boolean hasRollback(long state) {
        return (state & (1L << (STATUS_BITS + LOG_ID_BITS1))) != 0;
    }

    private static boolean hasChanges(long state) {
        return getLogId(state) != 0;
    }

    private static long composeState(int status, long logId, boolean hasRollback) {
        assert logId < LOG_ID_LIMIT : logId;
        assert (status & ~STATUS_MASK) == 0 : status;

        if (hasRollback) {
            status |= 1 << STATUS_BITS;
        }
        return ((long)status << LOG_ID_BITS1) | logId;
    }
}