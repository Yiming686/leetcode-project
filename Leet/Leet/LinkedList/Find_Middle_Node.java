package Leet.LinkedList;

import static Utils.LinkedListUtils.print;
import static Utils.StringUtils.toStr;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Find_Middle_Node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = ListNodeUtils.buildIntegerLinkedListNoDupSorted(16, 1, 30);
//		ListNode list = ListNodeUtils.buildIntegerLinkedList("2,4,5,8,9");
//		ListNode list = ListNodeUtils.buildIntegerLinkedList("   8  ,  9   ");
//		ListNode list = ListNodeUtils.buildCharacterLinkedList("   c  ,  g   ");
		print(list, 4);

		System.out.println("mid: "+getMid(list).val);
	}
    private static ListNode getMid(ListNode head) {
    	int width = 4;
    	int slowIndex = 0;
    	int fastIndex = 0;
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		str1.append("slowIndex: ").append(String.format("%"+width+"s", slowIndex));;
		str2.append("fastIndex: ").append(String.format("%"+width+"s", fastIndex));;

//    	ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
//        while (fast != null && fast.next != null) {
        while (fast.next != null && fast.next.next != null) {
//            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
            slowIndex += 1;
            fastIndex += 2;
            str1.append(String.format("%"+width+"s", slowIndex));
            str2.append(String.format("%"+width+"s", fastIndex));
        }
    	System.out.println(str1);
    	System.out.println(str2);

        return slow;
//        return prev;
    }

}
