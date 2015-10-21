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
	
	
//	��˼·������ĿheadҲ���ܱ�ɾ�������Ա�������dummynode
//	Ȼ��dummyNode ��Զ������Ȼ�����շ���dummy.next����
//	head�Ĳ��ϱ仯����ָ��dummy node��ʼ�����ָ�������β
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null && head.next.next!=null){
//        	���һ�£���һ��������һ������ֵ������
//        	�������ֵ��ȣ���ô�ӵ�һ��ɾ����ʼ������һ����ɾ������
        	if(head.next.val == head.next.next.val){
//        		ע��{}����headָ��Ķ���ʼ�ձ��ֲ���
        		int val = head.next.val;
        		while(head.next!=null&& head.next.val == val){
        			head.next = head.next.next;
        		}
        	}else{
 //        		ע��headָ��Ķ������˸ı�
        		head = head.next; 
        	}
        }
        return dummy.next;
    }
    
//Accepted  �Լ�����
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null && head.next.next!=null){
        	
        	if(head.next.val == head.next.next.val){
//        		ע��head.nextָ��Ķ���ʼ�ձ��ֲ���
        		while(head.next.next.next!=null&& head.next.next.next.val == head.next.val){
        			head.next.next = head.next.next.next;
        		}
//        		���״�㡿�������������Լ�ɾ�� 
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
