package Lintcode.LinkList;

/**
Given a list, rotate the list to the right by k places, where k is non-negative.

Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.

Tags 
Basic Implementation Linked List
Related Problems 
Hard Reverse Nodes in k-Group 32 %
Easy Rotate String 20 %

 *
 */
public class Rotate_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//  My solution, better than jiuzhang
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int size = getSize(head);
        int n = k % size;
        if(n == 0) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        // n = n + 1;
        while( --n >= 0){//n=1, one step; n=2, two steps
            right = right.next;
        }
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        right.next = head;//right.next == null
        head = left.next;
        left.next = null;
        return head;
    }

    
    public int getSize(ListNode head) {
        // Write your code here
        if(head == null) return 0;
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    
	
}
