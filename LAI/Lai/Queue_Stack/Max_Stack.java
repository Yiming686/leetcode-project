package Lai.Queue_Stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class Max_Stack {

//	["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
//			[[],[5],[1],[5],[],[],[],[],[],[]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max_Stack ms = new Max_Stack();
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

	private final Node first;
	private final Node last;
	private TreeMap<Integer, LinkedList<Node>> map;

	public Max_Stack() {
		first = new Node(-1);
		last = new Node(-1);
		first.next = last;
		last.prev = first;

		map = new TreeMap<>();
	}

	public void push(int val) {
		Node node = new Node(val);
		if (!map.containsKey(val)) {
			map.put(val, new LinkedList<Node>());
		}
		map.get(val).addLast(node);
		addLast(node);
	}

	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int lastVal = remove(last.prev).val;
		LinkedList<Node> list = map.get(lastVal);
		list.removeLast();
		if (list.isEmpty()) {
			map.remove(lastVal);
		}
		return lastVal;
	}

	public int top() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return last.prev.val;
	}

	public int peekMax() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return map.lastKey();
	}

	public int popMax() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int max = map.lastKey();
		LinkedList<Node> list = map.get(max);
		remove(list.removeLast());

		if (list.isEmpty()) {
			map.remove(max);
		}

		return max;
	}
	
	public boolean isEmpty() {
		return first == last;
	}
	
	private void addLast(Node node) {
		node.prev = last.prev;
		node.prev.next = node;

		node.next = last;
		last.prev = node;
	}

//	MUST return the Node
//	private void remove(Node node) {
//		node.prev.next = node.next;
//		node.next.prev = node.prev;
//		node.next = null;
//		node.prev = null;
////		return node;
//	}

	private Node remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
		return node;
	}


}
