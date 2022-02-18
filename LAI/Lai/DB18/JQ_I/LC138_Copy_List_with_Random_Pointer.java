package Lai.DB18.JQ_I;

import java.util.HashMap;
import java.util.Map;

public class LC138_Copy_List_with_Random_Pointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node copyRandomList_ON(Node head) {
		// Write your solution here.
		if (head == null) {
			return null;
		}
		Map<Node, Node> map = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			Node copyOfCurr = map.get(curr);
			if (copyOfCurr == null) {
				copyOfCurr = new Node(curr.val);
				map.put(curr, copyOfCurr);
			}
			if (curr.next != null) {
				if (map.get(curr.next) == null) {
					copyOfCurr.next = new Node(curr.next.val);
					map.put(curr.next, copyOfCurr.next);
				} else {
					copyOfCurr.next = map.get(curr.next);
				}
			}
			if (curr.random != null) {
				if (map.get(curr.random) == null) {
					copyOfCurr.random = new Node(curr.random.val);
					map.put(curr.random, copyOfCurr.random);
				} else {
					copyOfCurr.random = map.get(curr.random);
				}
			}
			curr = curr.next;
		}
		return map.get(head);
	}

	//	O(N), O(1)
	public Node copyRandomList(Node head) {
		// public static Node copy(Node head) {
		// Write your solution here.
		if (head == null) {
			return null;
		}
		Node curr = head;
		while (curr != null) {
			Node newCurr = new Node(curr.val);
			newCurr.next = curr.next;
			curr.next = newCurr;
			curr = newCurr.next;
		}
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				Node newCurr = curr.next;
				newCurr.random = curr.random.next;
			}
			curr = curr.next.next;
		}
		curr = head;
		Node newHead = head.next;
		while (curr != null) {
			Node newCurr = curr.next;
			curr.next = newCurr.next;
			if (newCurr.next != null) {
				newCurr.next = newCurr.next.next;
			}
			curr = curr.next;
		}
		return newHead;
	}

	static class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next, Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};

}
