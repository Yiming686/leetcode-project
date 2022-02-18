package Lai.Linked_List;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;
import Utils.ListNodeUtils.CycleList;

public class Insert_In_Sorted_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	用不用Dummy Node？？
	public static ListNode<Integer> insert00(ListNode<Integer> head, int val) {
		// Write your solution here
		ListNode<Integer> newNode = new ListNode<>(val);
		if (head == null || val < head.val) {
			newNode.next = head;
			return newNode;
		}
		ListNode<Integer> curr = head; // curr动态移动
		while (curr.next != null && curr.next.val < val) {
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
	}

	public static ListNode<Integer> insert11(ListNode<Integer> head, int value) {
		// Write your solution here
		ListNode<Integer> newNode = new ListNode<>(value);
		ListNode<Integer> dummy = new ListNode<>(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null && head.next.val < value) {
			head = head.next;
		}
		newNode.next = head.next;
		head.next = newNode;
		return dummy.next;
	}

}
