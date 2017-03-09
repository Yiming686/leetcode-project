package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
//import java.util.HashMap.Entry;
//import java.util.HashMap.Holder;

import JavaInterviewQueston.MyHashMap2.Entry;

public class WePay_Hash_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyHashMap2<String, String> m = new MyHashMap2<String, String>();
		
		MyHashMap2<String, String> map = new MyHashMap2<String, String>();
		map.put(null, null);
		map.put(null, null);
		map.put(null, null);
		System.out.println(""+map.get(null));
		myHashTable<String, String> m = new myHashTable<String, String>(100);
		
		m.put("abc", "eee");
		m.put("abc", "bbb");
		System.out.println(m.get("abc"));
		m.put(null, null);
		System.out.println(m.get(null));
//		m.put(null, null);
//		System.out.println(m.get(null));
		
	}

}

class MyHashMap2<K, V> {
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	static final int MAXIMUM_CAPACITY = 1 << 30;
	transient int hashSeed = 0;

	transient int size;
	int threshold;
	final float loadFactor = 0.75f;

	transient Entry<K, V>[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

	public MyHashMap2() {

	}

//	final boolean initHashSeedAsNeeded(int capacity) {
//		boolean currentAltHashing = hashSeed != 0;
//        boolean useAltHashing = sun.misc.VM.isBooted() &&
//                (capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
//        boolean switching = currentAltHashing ^ useAltHashing;
//        if (switching) {
//            hashSeed = useAltHashing
//                ? sun.misc.Hashing.randomHashSeed(this)
//                : 0;
//        }
//        return switching;
//	}

	/**
	 * Returns index for hash code h.
	 */
	static int indexFor(int h, int length) {
		// assert Integer.bitCount(length) == 1 : "length must be a non-zero
		// power of 2";
		return h & (length - 1);
	}

	/**
	 * Transfers all entries from current table to newTable.
	 */
	void transfer(Entry[] newTable, boolean rehash) {
		int newCapacity = newTable.length;
		for (Entry<K, V> e : table) {
			while (null != e) {
				Entry<K, V> next = e.next;
				if (rehash) {
					e.hash = null == e.key ? 0 : hash(e.key);
				}
				int i = indexFor(e.hash, newCapacity);
				e.next = newTable[i];
				newTable[i] = e;
				e = next;
			}
		}
	}

	void resize(int newCapacity) {
		Entry[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return;
		}

		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable, true);
		table = newTable;
		threshold = (int) Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
	}

	void createEntry(int hash, K key, V value, int bucketIndex) {
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
		size++;
	}

	void addEntry(int hash, K key, V value, int bucketIndex) {
		if ((size >= threshold) && (null != table[bucketIndex])) {
			resize(2 * table.length);
			hash = (null != key) ? hash(key) : 0;
			bucketIndex = indexFor(hash, table.length);
		}

		createEntry(hash, key, value, bucketIndex);
	}

	private V putForNullKey(V value) {
		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
			if (e.key == null) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		addEntry(0, null, value, 0);
		return null;
	}

	final int hash(Object k) {
		int h = hashSeed;
		if (0 != h && k instanceof String) {
			return 88888888;
//			return HashMap.((String) k);
		}

		h ^= k.hashCode();

		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public V put(K key, V value) {
		if (key == null)
			return putForNullKey(value);
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		for (Entry<K, V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}

		addEntry(hash, key, value, i);
		return null;
	}

	public V get(Object key) {
		if (key == null)
			return getForNullKey();
		Entry<K, V> entry = getEntry(key);

		return null == entry ? null : entry.getValue();
	}

	private V getForNullKey() {
		if (size == 0) {
			return null;
		}
		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
			if (e.key == null)
				return e.value;
		}
		return null;
	}

	final Entry<K, V> getEntry(Object key) {
		if (size == 0) {
			return null;
		}

		int hash = (key == null) ? 0 : hash(key);
		for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
				return e;
		}
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
class myHashTable<K, V> {
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

	public myHashTable(int size) {
		this.size = size;
		for (int i = 0; i < size; i++) {
			ary.add(i, null);
		}
	}


	public void put(K key, V value) {
		if (key == null ){
		}
			
//			throw new NullPointerException("null of key is not allowed");
		if (ary.get(key.hashCode() % size) == null)
			ary.add(key.hashCode() % size, new LinkedList<Entry<K, V>>());
		ary.get(key.hashCode() % size).add(new Entry<K, V>(key, value));
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