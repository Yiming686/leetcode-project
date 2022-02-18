package Lai.Linked_List;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Remove_Linked_List_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {3, 11, 11, 11,  2,  2, 11};
		int[] arr = {};
		ListNode<Integer> head = ListNodeUtils.buildIntegerLinkedList(arr);
//		ListNode<Integer> head = ListNodeUtils.buildIntegerLinkedListWithDup(7, 2, 20);
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(removeElements(head, 11));

	}
	
	  public static ListNode removeElements(ListNode<Integer> head, int val) {
		  if(head == null) {
			  return head;
		  }
		  ListNode dummy = new ListNode(0);
		  dummy.next = head;
		  head = dummy;
		  while(head.next != null) {
			  if(head.next.val == val) {
				  head.next = head.next.next;
			  }else {
				  head = head.next;
			  }
		  }
		  return dummy.next;
	  }

}
