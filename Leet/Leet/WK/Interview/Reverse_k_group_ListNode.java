package Leet.WK.Interview;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Reverse_k_group_ListNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//          2,1,5,   3,4,7,  4,1,9, 4,0,7,  0,7,3,
		//if k = 3, 5,1,2,   7,4,3,  9,1,4, 7,0,4,  0,7,3,
		//if k = 3, 5,1,2,   7,4,3,  9,1,4, 7,0,4,  3,7,0,
		//          2,1,5,3, 4,7,4,1, 9,4,0,7, 0,7,3,
		//if k = 4, 3,5,1,2, 1,4,7,4, 7,0,4,9, 0,7,3,
		//if k = 4, 3,5,1,2, 1,4,7,4, 7,0,4,9, 3,7,0,
		int[] arr = {2,1,5,3, 4,7,4,1, 9,4,0,7, 0,7,3};
		ListNode<Integer> head = ListNodeUtils.buildIntegerLinkedList(arr);
		ListNodeUtils.printList(head);
		int k = 3;
		ListNodeUtils.printList(reverseKGroup(head, k));
		k = 4;
		ListNodeUtils.printList(reverseKGroup(head, k));
		
	}
	private static ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode dummy = new ListNode<Integer>(0);
		dummy.next = head;
		ListNode curr = head;
		return head;
		
	}
	
	

}
