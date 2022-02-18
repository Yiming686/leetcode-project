package Lai.Linked_List;

import Utils.ArrayUtils;
import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Rotate_List_By_K_Places {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArray(7, 2, 20);
		ListNode<Integer> head = ListNodeUtils.buildLinkedList(ArrayUtils.convertIntArr2IntegerArr(arr));
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(rotateKplace(head, 6));

	}

	public static ListNode rotateKplace(ListNode head, int n) {
		// Write your solution here
		if (head == null || n < 0) {
			return head;
		}
		int len = 1;
		ListNode curr = head;
		while (curr.next != null) {
			len++;
			curr = curr.next;
		}
		if (n % len == 0) {
			return head;
		}
		ListNode tail = curr;
		int k = len - n % len - 1;
		curr = head;
		while (--k >= 0) {
			curr = curr.next;
		}
		ListNode newHead = curr.next;
		curr.next = null;
		tail.next = head;
		return newHead;

	}

}
