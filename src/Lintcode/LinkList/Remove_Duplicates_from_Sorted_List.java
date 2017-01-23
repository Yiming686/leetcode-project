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
	
    //worked, �μǣ�Best solution
    //ǰ��:�Ѿ������ˣ�����ȥ���ظ����⣬���ʱ����Ծ��ѭ���������䣬����Ҫ������Ǵ�����ľ���
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null) return null;
        ListNode curr = head;//�ǵ�Ҫ����ListNode�Ļ������뽨��һ���µı���
        //ѭ����ֻ�Ƚϵ�ǰ�͵�ǰ��һ��ֵ
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                    curr.next = curr.next.next;//�����㡿������ѭ������
                    // curr = curr.next.next;
            }else{
                curr = curr.next;//�����㡿����ѭ������
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
