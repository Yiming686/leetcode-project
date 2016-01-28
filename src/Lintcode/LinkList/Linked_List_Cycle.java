package Lintcode.LinkList;

import java.util.Arrays;

/**
Linked List Cycle

Given a linked list, determine if it has a cycle in it.



Have you met this question in a real interview? Yes
Example
Given -21->10->4->5, tail connects to node index 1, return true

Challenge
Follow up:
Can you solve it without using extra space?

Tags Expand 
Two Pointers Linked List


Related Problems Expand 
Medium Intersection of Two Linked Lists
 *
 */
public class Linked_List_Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ooajosklfoweuo";
		String[] arr = str.split("o",-1);
		System.out.println(""+Arrays.toString(arr));
		
		String str2="a|bcd|efg|higk";  
		String[] strs= str2.split("|");
		System.out.println(""+Arrays.toString(strs));
		System.out.println(""+Arrays.toString(str2.toCharArray()));
	}
	
    //worked, easy to understand and looks like find middle     
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        //初始化令他们不相等，然后在后面看看相等不，一旦相等，就是true
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    //worked, not best
    public Boolean hasCycle4(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }


}
