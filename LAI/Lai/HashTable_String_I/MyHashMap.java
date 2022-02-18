package Lai.HashTable_String_I;


interface MyMap<K, V>{
	V get(K key);
	V put(K key, V val);
	boolean remove(K key);
	int size();
	boolean isEmpty();
}


//put(K, V), hashcode to hash, to index, find pos, put or update Entry<>
//get(K, V), hashcode to hash, to index, find pos, get Entry<>
public class MyHashMap<K, V> implements MyMap<K, V>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class Node<K, V>{
		private final K key;
		private V value;
		private Node<K, V> next;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	private Node<K, V> [] table;
	private int size;
	private float loadFactor;
	private static final int INITIAL_CAPACITY = 10;
	private static final float DEFAULT_LOAD_FACTOR = 0.75F;
	
	
	
	
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		int index = findIndex(key);
		Node< K, V> node = table[index];
		while( node != null) {
			if(node.key.equals(key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}

	private int findIndex(K key) {
		// TODO Auto-generated method stub
		if(key == null) {
			return 0;
		}
		int hash  = hash(key);
		
		return hash % table.length;
	}

	private int hash(K key) {
		if(key == null) {
			return 0;
		}
		int hashCode = key.hashCode();
				
		return hashCode & 0x7FFFFFFF;
	}

	@Override
	public V put(K key, V val) {
		int index = findIndex(key);
		Node< K, V> node = table[index];
		Node< K, V> prev = null;
		while( node != null) {
//			if(node.key.equals(key)) {
			if(key.equals(node.key)) {
				V oldValue = node.value;
				node.value = val;
				return oldValue;
			}
			prev = node;
			node = node.next;
		}
		prev.next = new Node<K, V>(key, val);
		size++;
		
		return null;

	}

	@Override
	public boolean remove(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}


	
}
