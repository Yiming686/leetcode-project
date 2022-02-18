package Leet.LinkedList;

import static Utils.ListNodeUtils.printList;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Reverse_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNodeUtils.buildIntegerLinkedList(   new int[] {1,1,2,2,2,3,6,6,6,6,9,9});
		printList(head);
		printList(reverse_ite(head));

	}

	public static ListNode reverse_ite(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public ListNode reverse_rec(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode curr = head;
		ListNode newHead = reverse_rec(curr.next);	
		curr.next.next = curr;
		curr.next = null;
		return newHead;
	}

}
