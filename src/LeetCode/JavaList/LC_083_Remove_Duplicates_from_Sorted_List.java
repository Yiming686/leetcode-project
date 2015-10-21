package LeetCode.JavaList;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Hide Tags Linked List

 * 
 */
public class LC_083_Remove_Duplicates_from_Sorted_List {

	
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head;
        while(node.next != null){
        	if(node.val == node.next.val){
        		node.next = node.next.next;
        	}else{
        		node = node.next;
        	}
        }
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 本代码由九章算法编辑提供。没有版权欢迎转发。
	 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
	 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
	 * - 更多详情请见官方网站：http://www.jiuzhang.com/
	 */

	public class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        if (head == null) {
	            return null;
	        }

	        ListNode node = head;
	        while (node.next != null) {
	            if (node.val == node.next.val) {
	                node.next = node.next.next;
	            } else {
	                node = node.next;
	            }
	        }
	        return head;
	    }
	}
}
