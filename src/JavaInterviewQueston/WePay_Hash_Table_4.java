package JavaInterviewQueston;

public class WePay_Hash_Table_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable4<String, String> m = new MyHashTable4<String, String>();
		
		m.put("abc", "eee");
//		m.put(null, "eee");
//		m.put("ddss", null);
		m.put("abc", "bbb");
		m.put("k333", "v333");
		m.put("k444", "v444");
		m.put("k555", "v555");
		m.put("k6", "v6");
		m.put("k7", "v6");
		m.put("k8", "v6");
		m.put("k9", "v6");
		m.put("k6", "v10");
		m.put("abc", "ccc");
		System.out.println(m.get("abc"));
		m.put("abc", "ireurue");
		System.out.println(m.get("abc"));
		System.out.println(m.get("k6"));
		
		MyHashTable4<String, Integer> map = new MyHashTable4<String, Integer>();
		System.out.println(""+map.get(null));
		map.put(null, 4);System.out.println(""+map.get(null));
		map.put(null, 5);System.out.println(""+map.get(null));
		map.put(null, 6);System.out.println(""+map.get(null));

	}

}

class MyHashTable4<K, V> {
	
	private Entry<K, V> [] table;
	private int size;//size
	private float loadFactor;
	private int threshold;//if map reaches it, resize the table
	
	MyHashTable4(){
		this.loadFactor = 0.75f;
		this.threshold = 1;
		this.table = new Entry[threshold];
		this.size = 0;
	}
	
	
    public synchronized V get(K key) {
    	if(key == null){
	        if (size == 0) {
	            return null;
	        }
	        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
	            if (e.key == null)
	                return e.value;
	        }
	        return null;
        }else{
        	int hash = key.hashCode();
        	int index = (hash & 0x7FFFFFFF) % table.length;
        	for (Entry<K,V> e = table[index] ; e != null ; e = e.next) {
        		if ((e.hash == hash) && e.key.equals(key)) {
        			return e.value;
        		}
        	}
        	return null;
        }
    }

	
	public synchronized V put(K key, V value){
        if (key == null) {
            throw new NullPointerException("Key can not be null!");
        }
        if ( value == null) {
            throw new NullPointerException("Value can not be null!");
        }

        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        for (Entry<K,V> e = table[index] ; e != null ; e = e.next) {
//            if ((e.hash == hash) && e.key.equals(key)) {
        	if (e.hash == hash && (e.key == key || key.equals(e.key))) {//performance
                V old = e.value;
                e.value = value;
                return old;
            }
        }
        if (size >= threshold) {
            resize();
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % table.length;
        }

        Entry<K,V> e = table[index];
        table[index] = new Entry<K, V>(key, value, e, hash);
        size++;
        return null;

	}

	
    private void resize() {
        int oldCapacity = table.length;
        Entry<K,V>[] oldTable = table;

        int newCapacity = oldCapacity * 2;
        Entry<K,V>[] newTable = new Entry[newCapacity];

        threshold = (int)(newCapacity * loadFactor);

        table = newTable;

        for (int i = oldCapacity-1 ; i > 0 ; i--) {
            for (Entry<K,V> oldElement = oldTable[i] ; oldElement != null ; ) {
                Entry<K,V> e = oldElement;
                oldElement = oldElement.next;
                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = newTable[index];
                newTable[index] = e;
            }
        }
    }

	
	
	class Entry<K, V>{
		final K key;
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