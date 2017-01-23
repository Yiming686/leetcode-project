package Lintcode.LinkList;

/**
Given a linked list, swap every two adjacent nodes and return its head.

Example
Given 1->2->3->4, you should return the list as 2->1->4->3.

Challenge 
Tags 
Linked List
Related Problems 
Medium Swap Two Nodes in Linked List 19 %
Hard Reverse Nodes in k-Group


 *
 *
 */
public class Swap_Nodes_in_Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
//    	递推非常清晰，一旦标记，指向它的连接就可断开，指向新的地方
    	while(head.next!= null && head.next.next != null){
    		ListNode node = head.next.next.next;
    		head.next.next.next = head.next;
    		head.next = head.next.next;
    		head.next.next.next = node;
    		
    		head = head.next.next;
    	}
    	return dummy.next;
    }

}
