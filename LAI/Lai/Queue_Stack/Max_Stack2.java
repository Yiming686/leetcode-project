package Lai.Queue_Stack;

import java.util.TreeMap;

public class Max_Stack2 {

//	["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
//			[[],[5],[1],[5],[],[],[],[],[],[]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max_Stack2 ms = new Max_Stack2();
		ms.push(5);
		ms.push(1);
		ms.push(5);
		ms.top();
		ms.popMax();
		ms.top();
		ms.peekMax();
		ms.pop();
		ms.pop();
	}

	/** initialize your data structure here. */
	class Node {
		public Node next;
		public Node prev;
		public int val;

		public Node(int val) {
			this.val = val;
			next = null;
			prev = null;
		}
	}

	class DoublyLinkedList {
		private final Node first;
		private final Node last;

		public DoublyLinkedList() {
			first = new Node(0);
			last = new Node(0);
			first.next = last;
			last.prev = first;
		}

		public void addLast(Node node) {
			node.prev = last.prev;
			node.prev.next = node;

			node.next = last;
			last.prev = node;
		}

		public Node remove(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
			return node;
		}

//	        public int getLast() {
//	            return last.prev.val;
//	        }

		public Node getLast() {
			return last.prev;
		}

		public Node removeLast() {
			return remove(last.prev);
		}

//	        public int removeLast() {
//	            int tmp = getLast();
//	            remove(last.prev);
//	             
//	            return tmp;
//	        }

		public boolean isEmpty() {
			return first == last;
		}

	}

	private DoublyLinkedList dll;
	private TreeMap<Integer, DoublyLinkedList> map;

	/** initialize your data structure here. */
	    public Max_Stack2() {
	        dll = new DoublyLinkedList();
	        map = new TreeMap<>();
	    }

	public void push(int val) {
		Node node = new Node(val);
		if (!map.containsKey(val)) {
			map.put(val, new DoublyLinkedList());
		}
		map.get(val).addLast(node);
		dll.addLast(node);
	}

	public int pop() {
		int last = dll.removeLast().val;
		DoublyLinkedList list = map.get(last);
		list.removeLast();
		if (list.isEmpty()) {
			map.remove(last);
		}
		return last;
	}

	public int top() {
		return dll.getLast().val;
	}

	public int peekMax() {
		return map.lastKey();
	}

	public int popMax() {
		int max = map.lastKey();
		DoublyLinkedList list = map.get(max);
		dll.remove(list.removeLast());

		if (list.isEmpty()) {
			map.remove(max);
		}

		return max;
	}

}
