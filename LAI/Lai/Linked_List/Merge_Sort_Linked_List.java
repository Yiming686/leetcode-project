package Lai.Linked_List;

import Utils.ArrayUtils;
import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Merge_Sort_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode<Integer> head = ListNodeUtils.buildIntegerLinkedList(7, 2, 20);
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(mergeSort(head));

	}

	public static ListNode mergeSort(ListNode<Integer> head) {
		// Write your solution here
		if (head == null || head.next == null) {
			return head;
		}
		ListNode head1 = head;
		ListNode mid = findMiddle(head);
		ListNode head2 = mid.next;
		mid.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1, head2);
	}

	static ListNode  findMiddle(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	static ListNode merge(ListNode<Integer> head1, ListNode<Integer> head2) {
		if (head1 == null && head2 == null) {
			return null;
		}
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				curr.next = head1;
				head1 = head1.next;
			} else {
				curr.next = head2;
				head2 = head2.next;
			}
			curr = curr.next;
		}
		if (head1 != null) {
			curr.next = head1;
		}
		if (head2 != null) {
			curr.next = head2;
		}
		return dummy.next;
	}

}
