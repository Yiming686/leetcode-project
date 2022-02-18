package Leet.LinkedList;

import static Utils.ListNodeUtils.printList;
import Utils.ListNodeUtils.ListNode;

public class Leet_82_Remove_Duplicates_from_Sorted_List_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode curr = head;
		curr.next = new ListNode(1);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		printList(head);
		printList(deleteDuplicates(head));
		
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value 
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				fast = fast.next;
			}
			//fast points to last pos for curr val
			if (fast == slow.next) {//only one node of this val
				slow = slow.next;
			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}
}
