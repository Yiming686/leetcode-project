package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
//import java.util.HashMap.Entry;
//import java.util.HashMap.Holder;

public class WePay_Hash_Table_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyHashTable2<String, String> m = new MyHashTable2<String, String>();
		myHashTable1<String, String> m = new myHashTable1<String, String>(100);
		
		m.put("abc", "eee");
		m.put("abc", "bbb");
		m.put("abc", "ccc");
		System.out.println(m.get("abc"));
	}

}

class MyHashTable2<K, V> {
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	static final int MAXIMUM_CAPACITY = 1 << 30;
	
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	transient int hashSeed = 0;

	transient int size;
    private int count;

	int threshold;
	final float loadFactor;

	private Entry<K, V>[] table = new Entry[16];
	
    public MyHashTable2(int initialCapacity, float loadFactor) {
    	this.loadFactor = loadFactor;
    	this.table = new Entry[initialCapacity];
    }


	public MyHashTable2() {
    	this.loadFactor = 0.75f;
    	this.table = new Entry[16];

	}

    protected void rehash() {
        int oldCapacity = table.length;
        Entry<K,V>[] oldMap = table;

        // overflow-conscious code
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<K,V>[] newMap = new Entry[newCapacity];

        threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
//        boolean rehash = initHashSeedAsNeeded(newCapacity);
        boolean rehash = true;

        table = newMap;

        for (int i = oldCapacity ; i-- > 0 ;) {
            for (Entry<K,V> old = oldMap[i] ; old != null ; ) {
                Entry<K,V> e = old;
                old = old.next;

                if (rehash) {
                    e.hash = hash(e.key);
                }
                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }


    private int hash(Object k) {
        return 0 ^ k.hashCode();
    }

    public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<K,V> tab[] = table;
        int hash = hash(key);
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            hash = hash(key);
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        Entry<K,V> e = tab[index];
        tab[index] = new Entry<K,V>(hash, key, value, e);
        count++;
        return null;
    }


	static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;
		int hash;

		Entry(int h, K k, V v, Entry<K, V> n) {
			value = v;
			next = n;
			key = k;
			hash = h;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (!(o instanceof Entry))
				return false;
			Entry<K, V> e = (Entry<K, V>) o;
			Object k1 = getKey();
			Object k2 = e.getKey();
			if (k1 == k2 || (k1 != null && k1.equals(k2))) {
				Object v1 = getValue();
				Object v2 = e.getValue();
				if (v1 == v2 || (v1 != null && v1.equals(v2)))
					return true;
			}
			return false;
		}

		public final int hashCode() {
			return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
		}

		public final String toString() {
			return getKey() + "=" + getValue();
		}

	}
}

//================================================================================================================
//from internet, might work, but not good
class myHashTable1<K, V> {
	class Entry<K, V> {
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		K key;
		V value;
	}

	private int size = 1000;
	private ArrayList<LinkedList<Entry<K, V>>> ary = new ArrayList<LinkedList<Entry<K, V>>>(size);

	public myHashTable1(int size) {
		this.size = size;
		for (int i = 0; i < size; i++) {
			ary.add(i, null);
		}
	}

//	public void put(K key, V value) {
//		if (key == null)
//			throw new NullPointerException("null of key is not allowed");
//		if (ary.get(key.hashCode() % size) == null)
//			ary.add(key.hashCode() % size, new LinkedList<Entry<K, V>>());
//		ary.get(key.hashCode() % size).add(new Entry<K, V>(key, value));
//	}
	public void put(K key, V value) {
        if (key == null)
            throw new NullPointerException("null of key is not allowed");
        if (ary.get(key.hashCode() % size) == null)
            ary.set(key.hashCode() % size, new LinkedList<Entry<K, V>>());
        ary.get(key.hashCode() % size).addFirst(new Entry<K, V>(key, value));
    }


	public V get(K key) {
		if (key == null)
			throw new NullPointerException("null of key is not allowed");
		if (ary.get(key.hashCode() % size) == null)
			return null;
		else {
			LinkedList<Entry<K, V>> res = ary.get(key.hashCode() % size);
			Iterator<Entry<K, V>> iterator = res.iterator();
			while (iterator.hasNext()) {
				Entry<K, V> e = iterator.next();
				if (e.key.equals(key))
					return e.value;
			}
			return null;
		}
	}

//	public static void main(String[] args) {
//		myHashTable<String, String> m = new myHashTable<String, String>(1000);
//		m.put("abc", "eee");
//		m.put("abc", "bbb");
//		System.out.println(m.get("abc"));
//	}
}