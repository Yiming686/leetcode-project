package Lintcode.LinkList;

import java.util.List;

/**
 * @author yiming
 *
 */
public class Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

//worked,	best solution, code looks good
    public static ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);
        ListNode head1 = head;
        ListNode head2 = mid.next;
        mid.next = null;//core, not missing
        
        head1 = sortList(head1);
        head2 = sortList(head2);
        
        return merge(head1, head2);
    }
    
//    worked,
    public ListNode sortList22(ListNode head) {  
        if(head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);
        ListNode head2 = sortList(mid.next);
        mid.next = null;//core, not missing
        ListNode head1 = sortList(head);
        return merge(head1, head2);
  }


    private static ListNode findMiddle(ListNode head) {
        //mid  go over: 0, 1, 2, 3, 4,  5,  6,  7,
        //head go over: 0, 2, 4, 6, 8, 10, 12, 14,
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        //先判断，再跳比较好
        while(fast !=null && fast.next != null){
        // while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // because of two sorted list, ... , return sorted list.
    private static ListNode merge(ListNode head1, ListNode head2) {
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }
        return dummy.next;
    }

	
}
