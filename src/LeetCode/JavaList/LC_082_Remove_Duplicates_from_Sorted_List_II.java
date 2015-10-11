package LeetCode.JavaList;

/*
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

Hide Tags Linked List

 * 
 */
public class LC_082_Remove_Duplicates_from_Sorted_List_II {
	
	
//	【思路】此题目head也可能被删掉，所以必须运用dummynode
//	然后dummyNode 永远不懂，然后最终返回dummy.next即可
//	head的不断变化，从指向dummy node开始，最后指向链表结尾
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null && head.next.next!=null){
//        	侦测一下，下一个和下下一个，把值留下来
//        	加入二者值相等，那么从第一个删除开始，引起一连串删除操作
        	if(head.next.val == head.next.next.val){
//        		注意{}里面head指向的对象，始终保持不变
        		int val = head.next.val;
        		while(head.next!=null&& head.next.val == val){
        			head.next = head.next.next;
        		}
        	}else{
 //        		注意head指向的对象发生了改变
        		head = head.next; 
        	}
        }
        return dummy.next;
    }
    
//Accepted  自己代码
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null && head.next.next!=null){
        	
        	if(head.next.val == head.next.next.val){
//        		注意head.next指向的对象，始终保持不变
        		while(head.next.next.next!=null&& head.next.next.next.val == head.next.val){
        			head.next.next = head.next.next.next;
        		}
//        		【易错点】容易忘掉，把自己删掉 
        		head.next = head.next.next.next;
        	}else{
        		head = head.next; 
        	}
        }
        return dummy.next;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
