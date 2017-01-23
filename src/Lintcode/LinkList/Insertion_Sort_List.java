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
//        head为待插入node，从第一个元素开始对比检测，curr.next为待插入位置
        while (head != null) {
            ListNode curr = dummy;
            while(curr.next != null && curr.next.val < head.val){
                curr = curr.next;
            }
            //四个递推替换完成插入+归位
            ListNode next = head.next;
            head.next = curr.next;
            curr.next = head;
            head = next;
        }
        return dummy.next;
    }


}
