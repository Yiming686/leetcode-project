package Lintcode.LinkList;

/**
Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.



 *
 */
public class Nth_to_Last_Node_in_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //  me, worked,
    ListNode nthToLast(ListNode head, int n) {
        if(head == null || n < 1) return null;
        ListNode node = head;
        while(n > 1){
            head = head.next;
            if(head == null){
                return null;
            }
            n--;
        }
        while(head.next != null ){
            head = head.next;
            node = node.next;
        }
        return node;        
    }    


    //  me, worked,
    ListNode nthToLast2(ListNode head, int n) {
        if(head == null || n < 1) return null;
        ListNode node = head;
        while(--n > 0){
            head = head.next;
            if(head == null){
                return null;
            }
            // n--;
        }
        while(head.next != null ){
            head = head.next;
            node = node.next;
        }
        return node;        
    }    

    
}
