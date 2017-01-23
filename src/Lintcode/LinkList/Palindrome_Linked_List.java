package Lintcode.LinkList;

/**
Implement a function to check if a linked list is a palindrome.

Example
Given 1->2->1, return true

Challenge 
Could you do it in O(n) time and O(1) space?

Tags 
Linked List
Related Problems 
Easy Valid Palindrome 23 %
Easy Reverse Linked List 41 %

 *
 *
 */
public class Palindrome_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.buildList(new int[]{2,6,8,1,9,6});
		System.out.println(""+ListNode.convertToString(head));
		System.out.println(""+isPalindrome(head));
		System.out.println(""+ListNode.convertToString(head));
	}

	
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode head1 = head;
        ListNode mid = findMiddle4(head);
        System.out.println("head1: "+ListNode.convertToString(head1));
        ListNode head2 = reverse4(mid.next);
        System.out.println("head1: "+ListNode.convertToString(head1));
		System.out.println("head2: "+ListNode.convertToString(head2));

        while(head1 != null && head2 != null && head1.val == head2.val){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head2 == null;
    } 
    
    private static ListNode findMiddle4(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private static ListNode reverse4(ListNode head){
        if(head == null){
            return null;
        }
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    

}
