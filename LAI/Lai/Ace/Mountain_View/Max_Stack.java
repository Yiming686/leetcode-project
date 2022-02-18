package Lai.Ace.Mountain_View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Max_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private TreeMap<Integer, List<ListNode>> map;
//	private Map<Integer, List<ListNode>> map;

	private ListNode stack;

	public Max_Stack() {
		map = new TreeMap<>();
		stack = new ListNode();
	}

//	push ¸üÐÂlistºÍmap
	public void push(int x) {
		ListNode node = stack.addLast(x);
		if (!map.containsKey(x)) {
			map.put(x, new ArrayList<ListNode>());
		}
		map.get(x).add(node);
	}

//	remove node from list and map, if empty remove key
	public int pop() {
		int val = stack.removeLast();
		List<ListNode> listOfNodes = map.get(val);
		listOfNodes.remove(listOfNodes.size() - 1);
		if (listOfNodes.isEmpty()) {
			map.remove(val);
		}
		return val;
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return map.lastKey();
	}

	public int popMax() {
		int max = peekMax();
		List<ListNode> L = map.get(max);
		ListNode node = L.remove(L.size() - 1);
		stack.unlink(node);
		if (L.isEmpty()) {
			map.remove(max);
		}
		return max;
	}

	private static class ListNode {

		public Integer val;
		public ListNode head;
		public ListNode tail;

		ListNode() {

		}

		public ListNode addLast(int x) {
			return null;
		}

		public int peek() {
			return 0;
		}

		public int removeLast() {
			return 0;
		}

		public void unlink(ListNode node) {

		}

	}

}
