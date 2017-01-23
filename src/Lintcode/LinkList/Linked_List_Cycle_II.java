package Lintcode.LinkList;

/**
Linked List Cycle II

Given a linked list, return the node where the cycle begins.

If there is no cycle, return null.

Have you met this question in a real interview? Yes
Example
Given -21->10->4->5, tail connects to node index 1£¬return 10

Challenge
Follow up:

Can you solve it without using extra space?

Tags Expand 
Two Pointers Linked List


Related Problems Expand 
Medium Intersection of Two Linked Lists

 *
 */
public class Linked_List_Cycle_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//best, based on find middle and Linked_List_Cycle
    public ListNode detectCycle(ListNode head) {
        ListNode node = null;
        if(head == null) return node;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            if(slow == fast){
                slow = slow.next;
                node = head;
                while(node != slow){
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return node;
    }
    
    //worked
    public ListNode detectCycle3(ListNode head) {
        if(head == null || head.next == null){ return null;}
    
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow!=fast){
            if(fast==null|| fast.next==null) return null;
            slow = slow.next;
            fast= fast.next.next;
        }
        while(head!=slow.next){
            head= head.next;
            slow = slow.next;
        }
        return head;        
    }


}
