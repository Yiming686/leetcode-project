package Lintcode.LinkList;

/**
Sort a linked list using insertion sort.


 *
 */
public class Insertion_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
//        headΪ������node���ӵ�һ��Ԫ�ؿ�ʼ�Աȼ�⣬curr.nextΪ������λ��
        while (head != null) {
            ListNode curr = dummy;
            while(curr.next != null && curr.next.val < head.val){
                curr = curr.next;
            }
            //�ĸ������滻��ɲ���+��λ
            ListNode next = head.next;
            head.next = curr.next;
            curr.next = head;
            head = next;
        }
        return dummy.next;
    }


}
