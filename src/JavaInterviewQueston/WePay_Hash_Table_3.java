package JavaInterviewQueston;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class WePay_Hash_Table_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable3<String, String> m = new MyHashTable3<String, String>();
		
		m.put("abc", "eee");
//		m.put(null, "eee");
//		m.put("ddss", null);
		m.put("abc", "bbb");
		m.put("abc", "ccc");
		System.out.println(m.get("abc"));
		m.put("abc", "ireurue");
		System.out.println(m.get("abc"));

	}

}

class MyHashTable3<K, V> {
	private Entry<K, V> [] table;
	private int count;
	private float loadFactor;
	private int threshold;
	
	MyHashTable3(){
		this.loadFactor = 0.75f;
		this.threshold = 16;
		this.table = new Entry[threshold];
		this.count = 0;
	}
	
	
    public synchronized V get(K key) {
        Entry<K, V> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

	
	public synchronized V put(K key, V value){
        // Make sure the value is not null
        if (key == null) {
            throw new NullPointerException("Key can not be null!");
        }
        if ( value == null) {
            throw new NullPointerException("Value can not be null!");
        }

        // Makes sure the key is not already in the hashtable.
        Entry<K, V> tab[] = table;
//        int hash = hash(key);
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        //traverse the entry list in the index bucket
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
        	//if found, update value,  return old value 
            if ((e.hash == hash) && e.key.equals(key)) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }
        //if not found, if count reach the threshold, resize, rehash, might  creat a new one
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();
            tab = table;
//            hash = hash(key);
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        Entry<K,V> e = tab[index];
        tab[index] = new Entry<K, V>(key, value, e, hash);
        count++;
        return null;

	}
	
    private void rehash() {
        int oldCapacity = table.length;
        Entry<K,V>[] oldMap = table;

        // overflow-conscious code
//        int newCapacity = (oldCapacity << 1) + 1;
        int newCapacity = oldCapacity << 1;
//        if (newCapacity - MAX_ARRAY_SIZE > 0) {
//            if (oldCapacity == MAX_ARRAY_SIZE)
//                // Keep running with MAX_ARRAY_SIZE buckets
//                return;
//            newCapacity = MAX_ARRAY_SIZE;
//        }
        Entry<K,V>[] newMap = new Entry[newCapacity];

//        threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        threshold = (int)(newCapacity * loadFactor);

        table = newMap;

        for (int i = oldCapacity ; i > 0 ; i--) {
            for (Entry<K,V> old = oldMap[i] ; old != null ; ) {
                Entry<K,V> e = old;
                old = old.next;
//                e.hash = e.key.hashCode();
                
                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }

	
	
	class Entry<K, V>{
		K key;
		V value;
		Entry<K, V> next;
		int hash;
		
		Entry(K key, V value, Entry<K, V> next, int hash){
			this.key = key;
			this.value = value;
			this.next = next;
			this.hash = hash;
		}
	}
}