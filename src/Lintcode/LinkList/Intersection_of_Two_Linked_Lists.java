package Lintcode.LinkList;

/**
 * 
Write a program to find the node at which the intersection of two singly linked lists begins.

 Notice

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.

Example
The following two linked lists:

A:          a1 ¡ú a2
                   ¨K
                     c1 ¡ú c2 ¡ú c3
                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.

Challenge 
Your code should preferably run in O(n) time and use only O(1) memory.

Tags 

Linked List

Related Problems 
Hard Linked List Cycle II 37 %
Medium Linked List Cycle 47 %

 *
 */
public class Intersection_of_Two_Linked_Lists {

    // Best, Reasonable
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //count size and check if two last elements are the same
        ListNode pa = headA;
        ListNode pb = headB;
        int sizeA = 1;
        int sizeB = 1;
        while(pa.next != null){
            sizeA++;
            pa = pa.next;
        }
        while(pb.next != null){
            sizeB++;
            pb = pb.next;
        }
        if(pa != pb){//two last elements, no intersection
            return null;
        }
        
        pa = headA;
        pb = headB;
        
        if(sizeA > sizeB){
            int count = sizeA - sizeB;
            while(count > 0){
                pa = pa.next;
                count--;
            }
        }else{
            int count = sizeB - sizeA;
            while(count > 0){
                pb = pb.next;
                count--;
            }
        }
        while(pa != pb){//correct solution here
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }

    //jiuzhang solution
    public ListNode getIntersectionNode33(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
        
        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        
        node.next = headB;
        
        return listCycleII(headA);
    }

    private ListNode listCycleII(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
}
