package Lai.HashMap;

/*
 * 
Implemente a MyHashMap

size();
isEmpty();
clear();
put(String key, Integer val);
put(String key);

Steps:
1. class structure
2. API definition
3. fields
4. Constructor
5. API implementation 

View
entrySet, keySet, values

 * 
 * */

public class MyHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		throw new IllegalArgumentException("Invalid Path!");
	}

	private int size = 0;
	public static final int DEFAULT_CAPACITY = 16;
	private Node[] entries;

	public MyHashMap() {
		this(DEFAULT_CAPACITY);
	}

	public MyHashMap(int capacity) {
		this.size = 0;
		this.entries = new Node[capacity];
	}

//	class Entry<String, Integer>{
//		
//	}

	// return old value
	// return void, boolean ??? why not? why return previous value?
	public Integer put(String key, Integer val) {
		int index = getIndex(key);
//		int hash = key.hashCode();
//		int index = hash(hash) % entries.length;
		Node curr = entries[index];
		if (curr == null) {
			entries[index] = new Node(key, val);
			return null;
		}
		while (curr != null && curr.key.equals(key)) {
			curr = curr.next;
		}
		curr.next = new Node(key, val);
		return curr.val; 
	}

	private int hash(int hash) {
		return hash;
	}

//	public Integer get(String key) {
//		int index = getIndex(key);
//	}
	

	private int getIndex(String key) {
		// TODO Auto-generated method stub
		return hash(key) % entries.length;
	}

	private int hash(String key) {
		// TODO Auto-generated method stub
		if(key == null) {
			return 0;
		}
		return key.hashCode() & 0x7FFFFFFF;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		for (int i = 0; i < entries.length; i++) {
			entries[i] = null;
		}
		size = 0;
	}

	class Node {

		final String key;
		Integer val;
		Node next;
		// int hash;

		public Node(String key, Integer val) {
			this.key = key;
			this.val = val;
		}

		public Integer getVal() {
			return val;
		}

		public void setVal(Integer val) {
			this.val = val;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getKey() {
			return key;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

		private MyHashMap getOuterType() {
			return MyHashMap.this;
		}

	}
}
