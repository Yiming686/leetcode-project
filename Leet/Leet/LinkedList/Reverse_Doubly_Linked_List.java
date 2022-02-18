package Leet.LinkedList;

import static Utils.ListNodeUtils.printList;
import static Utils.ListNodeUtils.printListLeft2Right;
import static Utils.ListNodeUtils.printListRight2Left;
import static Utils.ListNodeUtils.toHead;
import static Utils.ListNodeUtils.toTail;



import Utils.ListNodeUtils;
import Utils.ListNodeUtils.DoublyListNode;

public class Reverse_Doubly_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyListNode head = ListNodeUtils.buildIntegerDoublyLinkedList(new int[] {1,1,2,2,2,3,6,6,6,6,9,9});
		printListLeft2Right(head, 50);
		printListRight2Left(toTail(head), 50);
		
		printListLeft2Right(reverse_ite(toHead(head)), 50);
		printListRight2Left(reverse_ite(toHead(head)), 50);
	}
	public static DoublyListNode reverse_ite(DoublyListNode head) {
		DoublyListNode prev = null;
		DoublyListNode curr = head;
		while(curr != null) {
			DoublyListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
