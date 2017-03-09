package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WePay_Hash_Table_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public class MyHashMap<K, V> {
	    
	    class Entry<K, V> {
	        K key;
	        V value;
	        Entry (K key, V value) {
	            this.key = key;
	            this.value = value;
	        }
	    }

	    private int capacity = 16;
	    private List<LinkedList<Entry<K, V>>> buckets;

	    public MyHashMap() {
	        buckets = new ArrayList<>();
	        for (int i = 0; i < capacity; ++i) {
	            buckets.add(i, null);
	        }
	    }

	    public void put (K key, V value) {
	        if (key == null) {
	            throw new NullPointerException("Key cannot be null!");
	        }
	        int index = key.hashCode() % capacity;
	        if (buckets.get(index) == null) {
	            buckets.set(index, new LinkedList<Entry<K, V>>());
	        }
	        LinkedList<Entry<K, V>> bucket = buckets.get(index);
	        Iterator<Entry<K, V>> iterator = bucket.iterator();
	        while (iterator.hasNext()) {
	            Entry<K, V> entry = iterator.next();
	            //key already exists, value is updated
	            if (entry.key.equals(key)) {
	                entry.value = value;
	                return;
	            }
	        }

	       //key doesn't exist yet
	        bucket.add(new Entry<>(key, value));

	    }

	    public V get (K key) {
	        if (key == null) {
	            throw new NullPointerException("key cannot be null!");
	        }

	        int index = key.hashCode() % capacity;
	        if (buckets.get(index) == null) {
	            return null;
	        }
	        LinkedList<Entry<K, V>> bucket = buckets.get(index);
	        Iterator<Entry<K, V>> iterator = bucket.iterator();
	        while (iterator.hasNext()) {
	            Entry<K, V> entry = iterator.next();
	            if (entry.key.equals(key)) {
	                return entry.value;
	            }
	        }
	        return null;
	    }
	}

}
