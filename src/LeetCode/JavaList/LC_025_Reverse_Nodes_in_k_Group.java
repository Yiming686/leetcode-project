package LeetCode.JavaList;

public class LC_025_Reverse_Nodes_in_k_Group {
	/*
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 */

	public ListNode reverseKGroup(ListNode head, int k) {
		if (null == head || null == head.next)
			return head;
		if (k < 1)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		int i = -1;
		ListNode curr = head;
		ListNode first = head;
		ListNode last = head;

		ListNode pre = dummy;
		ListNode pre2 = dummy;
		ListNode post = head.next;

		while (curr != null) {
			i++;
			if (i % k == 0) {
				first = curr;
			}
			if (i % k == k - 1) {
				last = curr;
				post = last.next;
				pre2 = pre.next;
//				ListNode subHead = reverseList(head, pre, first, last, post);
				ListNode subHead = reverseBetween(first, 1,k);

				pre = pre2; 
			}
			curr = curr.next;
		}
		return dummy.next;
	}

	private ListNode reverseList(ListNode head, ListNode pre, ListNode first,
			ListNode last, ListNode post) {
		// TODO Auto-generated method stub
		return null;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode curr = dummy.next;
		ListNode start = dummy;

		for (int i = 1; i <= n; i++) {
			if (i == m) {
				start = pre;
			}
			if (i > m && i <= n) {
				ListNode next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			} else {
				pre = pre.next;
				curr = curr.next;
			}
		}

		start.next.next = curr;
		start.next = pre;

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
