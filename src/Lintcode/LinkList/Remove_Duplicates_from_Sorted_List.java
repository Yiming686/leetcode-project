package Lintcode.LinkList;

/**
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Tags 
Linked List
Related Problems 
Naive Remove Linked List Elements

 *
 */
public class Remove_Duplicates_from_Sorted_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //worked, 牢记，Best solution
    //前提:已经排序了，此类去除重复问题，相等时不跳跃，循环变量不变，很重要，这才是此问题的精髓
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null) return null;
        ListNode curr = head;//记得要返回ListNode的话，必须建立一个新的变量
        //循环体只比较当前和当前下一个值
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                    curr.next = curr.next.next;//【考点】不更新循环变量
                    // curr = curr.next.next;
            }else{
                curr = curr.next;//【考点】更新循环变量
            }        
        }
        return head;
    }  
    
    public static ListNode deleteDuplicates34(ListNode head) { 
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode curr = head;
    	while(curr.next != null){
    		if(curr.val != curr.next.val){
    			curr = curr.next;
    		}else{
    			curr.next = curr.next.next;
    		}
    	}
    	return head;
    }

}
