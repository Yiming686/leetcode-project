package Leet.LinkedList;

import static Utils.ListNodeUtils.printList;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Remove_Duplicates_from_Sorted_List_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode head = ListNodeUtils.buildIntegerLinkedList(new int[] {0,1,2,2,2,2,2,2,4,4,4,4,4,6,8,8,8,9});
//		printList(head);
		int k = 3;
//		printList(deleteDuplicatesKeepKValues(head, k));
//		
//		head = ListNodeUtils.buildIntegerLinkedList(new int[] {0,1,2,2,2,2,2,2,4,4,4,4,4,6,8,8,8,9});
//		printList(deleteDuplicatesKeepKValues_00(head, k));
		
		ListNode head2 = ListNodeUtils.buildIntegerLinkedList(   new int[] {1,1,1,1,1,1,2,2,2,3,6,6,6,6,6,6,6,6,6,9,9});
		printList(head2);
		printList(deleteDuplicatesKeepKValues(head2, k));
//		
		head2 = ListNodeUtils.buildIntegerLinkedList(   new int[] {1,1,1,1,1,1,2,2,2,3,6,6,6,6,6,6,6,6,6,9,9});
		printList(deleteDuplicatesKeepKValues_00(head2, k));
		
	}

	public static ListNode deleteDuplicatesKeepKValues(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {//use fast to traverse list and count the number of current value
			int count = 1;
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				fast = fast.next;
				count++;//表明fast指向的是第几个val
				if(count <= k) {
//					slow = fast;//both OK
					slow = slow.next;
				}
			}
			//fast points to last pos for curr val
			if (fast != slow) {//only one node of this val
//				slow = slow.next;
//			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			slow = slow.next;
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}

	public static ListNode deleteDuplicatesKeepKValues_00(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = head;
		ListNode fast = head;
//		ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value
			int count = 1;
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				count++;//指明：fast 的下一个的val，是第几个。
				if(count <= k) {
					slow = slow.next;
				}
				fast = fast.next;
			}
			//fast points to last pos for curr val
			if (fast != slow) {//only one node of this val
//				slow = slow.next;
//			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			slow = slow.next;
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}

}
