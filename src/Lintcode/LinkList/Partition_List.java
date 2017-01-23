package Lintcode.LinkList;

/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.

Tags 
Two Pointers Linked List
Related Problems 
Medium Partition Array 28 %

 *
 */
public class Partition_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        ListNode curr = head;
        ListNode next = new ListNode(4);
        curr.next = next;
        curr = curr.next;

        next = new ListNode(3);
        curr.next = next;
        curr = curr.next;

        next = new ListNode(2);
        curr.next = next;
        curr = curr.next;

        next = new ListNode(5);
        curr.next = next;
        curr = curr.next;

        next = new ListNode(2);
        curr.next = next;
        curr = curr.next;

        next =partition(head, 3);
        System.out.println(""+next);
        

	}

    //worked
    public static ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null) return null;
        ListNode curr = head;
        ListNode lessDummy = new ListNode(0);
        ListNode moreDummy = new ListNode(0);
        ListNode less = lessDummy;
        ListNode more = moreDummy;
        while(curr != null){
            if(curr.val <x){
                less.next = curr;
                less = less.next;
            }else{
                more.next = curr;
                more = more.next;
            }
            curr = curr.next;
        }
        //more最终指向哪里不要紧，重要的时它的next必须设为null
        //【考察点】这是重要考点
        more.next = null;
        less.next = moreDummy.next;
        
        return lessDummy.next;
    }

    
}
