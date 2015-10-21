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
	 * �������ɾ����㷨�༭�ṩ��û�а�Ȩ��ӭת����
	 * - �����㷨�����ڰ��������й����ҵ��õĹ�������ʦ�ŶӾ����Թ�Ⱥ͹��ڵ�һ�ߴ�˾��ְ����ʦ��
	 * - ���е�������ѵ�γ̰����������㷨�࣬ϵͳ��ư࣬BAT���ڰ�
	 * - ������������ٷ���վ��http://www.jiuzhang.com/
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
