package Lai.DB18.JQ_I;

import java.util.HashMap;
import java.util.Map;

public class Deep_Copy_Linked_List_With_Random_Pointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	O(N), O(1)
	public static RandomListNode copy(RandomListNode head) {
		// Write your solution here.
		if (head == null) {
			return null;
		}
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode newCurr = new RandomListNode(curr.value);
			newCurr.next = curr.next;
			curr.next = newCurr;
			curr = newCurr.next;
		}
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				RandomListNode newCurr = curr.next;
				newCurr.random = curr.random.next;
			}
			curr = curr.next.next;
		}
		curr = head;
		RandomListNode newHead = head.next;
		while (curr != null) {
			RandomListNode newCurr = curr.next;
			curr.next = newCurr.next;
			if (newCurr.next != null) {
				newCurr.next = newCurr.next.next;
			}
			curr = curr.next;
		}
		return newHead;
	}

	//O(N), O(N)
	public static RandomListNode copy_ON(RandomListNode head) {
		// Write your solution here.
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode copyOfCurr = map.get(curr);
			if (copyOfCurr == null) {
				copyOfCurr = new RandomListNode(curr.value);
				map.put(curr, copyOfCurr);
			}
			if (curr.next != null) {
				if (map.get(curr.next) == null) {
					copyOfCurr.next = new RandomListNode(curr.next.value);
					map.put(curr.next, copyOfCurr.next);
				} else {
					copyOfCurr.next = map.get(curr.next);
				}
			}
			if (curr.random != null) {
				if (map.get(curr.random) == null) {
					copyOfCurr.random = new RandomListNode(curr.random.value);
					map.put(curr.random, copyOfCurr.random);
				} else {
					copyOfCurr.random = map.get(curr.random);
				}
			}
			curr = curr.next;
		}
		return map.get(head);
	}

	static class RandomListNode {
		public int value;
		public RandomListNode next;
		public RandomListNode random;

		public RandomListNode(int value) {
			this.value = value;
		}
	}

}
