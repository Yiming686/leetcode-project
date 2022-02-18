package Lai.Linked_List;

import Utils.ListNodeUtils.ListNode;

public class Leet_25_Reverse_Nodes_in_K_Group {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	=== 1/2 Solution =========================================================================================
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode start = dummy;
		ListNode end = dummy;
		int n = k;
		while (--n >= 0) {
			if (end.next != null) {
				head = head.next;
			} else {

			}
		}

		return dummy.next;
	}

//	=== 2/2 Solution =========================================================================================	
//	public ListNode reverseKGroup(ListNode head, int k) {
	public ListNode reverseKGroup_rec(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode newHead = head;
		int n = k;
		while (--n > 0) {
			if (newHead.next == null) {
				return head;
			}
			newHead = newHead.next;
		}
		ListNode nextHead = reverseKGroup(newHead.next, k);
		newHead.next = null;
		reverse(head);
		head.next = nextHead;
		return newHead;
	}

	ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
