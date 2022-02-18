package Lai.Linked_List;

import Utils.ArrayUtils;
import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class LL00_Reverse_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] arr = {-3, -2,4,7,9};
//		Integer[] arr = {-3};
//		Chaaracter[] arr = {};   
//		Integer[] arr = null;
//		ListNode<Character> head = ListNodeUtils.buildLinkedList("abcd");
//		ListNodeUtils.printList(ListNodeUtils.buildLine(6));
//		ListNodeUtils.printList(ListNodeUtils.buildCycleList(4,6));
		StringBuilder sb1 = new StringBuilder("                  ");
		System.out.println(sb1.charAt(3) == ' ');
		
		System.out.println(""+sb1);
		
		StringBuilder sb = new StringBuilder("abcde");
		System.out.println(""+sb);
		sb.insert(2, "HHH");
		System.out.println(""+sb);
//		sb.replace(2,5, "AAAAAA");
		String str = "AAA";
		sb.replace(2, 2+str.length(), str);
		System.out.println(""+sb);
		int[] arr = ArrayUtils.buildIntArray(9, 0, 20);
		ListNode<Integer> head = ListNodeUtils.buildLinkedList(ArrayUtils.convertIntArr2IntegerArr(arr));
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(ListNodeUtils.findMiddle(head));
		ListNodeUtils.printList(reverseByIteration(head));
	}

/*	1. clarification
	2. examples
	3. 
*/
	public static <E> ListNode<E> reverseByIteration(ListNode<E> head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode<E> newHead = reverseByIteration(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
		
	}

}
