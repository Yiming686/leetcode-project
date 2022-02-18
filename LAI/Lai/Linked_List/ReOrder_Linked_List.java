package Lai.Linked_List;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;
import Utils.ListNodeUtils.CycleList;

public class ReOrder_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNodeUtils.buildLinkedList(1, 11);
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(reorder(head));

	}

	static  public ListNode reorder(ListNode head) {
		// Write your solution here
		if (head == null || head.next == null) {
			return head;
		}
		ListNode one = head;
		ListNode mid = findMidle(head);
		System.out.println("mid: "+ mid.val);
		ListNode two = reverse(mid.next);
		mid.next = null;
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(two);
		ListNode curr = one;
		while (one != null && two != null) {
			one = one.next;
			curr.next = two;
			curr = curr.next;

			two = two.next;
			curr.next = one;
			curr = curr.next;
		}
		if (one != null) {
			curr.next = null;
//		      curr = curr.next; 
		}

		// curr.next = null;
		return head;
	}

	static ListNode findMidle(ListNode head) {
		// 12345,
		// 13579,
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
//		while (fast != null && fast.next != null) {//µ‰–Õ¥ÌŒÛ
		while (fast.next != null && fast.next.next != null) {
			System.out.printf("slow:fast %d:%d   ", slow.val, fast.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("slow:"+ slow.val);

		return slow;
	}

	 static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
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
