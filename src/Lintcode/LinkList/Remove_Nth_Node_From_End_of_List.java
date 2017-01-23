package Lintcode.LinkList;

/**
Given a linked list, remove the nth node from the end of list and return its head.

 Notice

The minimum number of nodes in list is n.

Example
Given linked list: 1->2->3->4->5->null, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5->null.

Challenge 
Can you do it without getting the length of the linked list?

Tags 
Two Pointers Linked List
Related Problems 
Easy Delete Node in the Middle of Singly Linked List 45 %


 *
 */
public class Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) {
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode prev = dummy;
    	
//    	根据curr和head的相对位置，n==1时，head不动，n==2时，head向后移动一位。
    	while(--n > 0){
    		if(head == null){
    			return null;
    		}
    		head = head.next;
    	}
    	head = prev.next;
    	while(head.next != null){
    		prev = prev.next;
    		head = head.next;
    	}
    	prev.next = prev.next.next;
    	return dummy.next;
    }

}
