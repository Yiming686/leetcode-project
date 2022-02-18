package Leet.XB.Mock.Day_04172021;

import static Utils.ArrayUtils.partitionA;
import static Utils.LinkedListUtils.print;
import static Utils.TreeNodeUtils.BINARY_TREE_NULL_NODE;

import Utils.ListNodeUtils.ListNode;




public class Quick_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		5, 2 1,7,3,6,4,9;
		ListNode head = new ListNode(5);
		ListNode curr = head;
		curr.next = new ListNode(4); curr = curr.next;
		curr.next = new ListNode(2); curr = curr.next;
		curr.next = new ListNode(1); curr = curr.next;
		curr.next = new ListNode(9); curr = curr.next;
		curr.next = new ListNode(7); curr = curr.next;
		curr.next = new ListNode(3); curr = curr.next;
		curr.next = new ListNode(6); curr = curr.next;
//		sort(head);
		print(quickSort(head).head);
	}

	static class Result{
		ListNode head;
		ListNode tail;
		Result(ListNode head,ListNode tail){
			this.head = head;
			this.tail = tail;
		}
	}
	//given an array, pick pivot to partition, then get two parts of subarrays,
	private static Result quickSort(ListNode<Integer> head) {
		if(head == null || head.next == null) {
			return new Result(head, head);
		}

		ListNode<Integer> pivot = head;
		ListNode<Integer> dummy1 = new ListNode(-1);
		ListNode<Integer> dummy2 = new ListNode(-1);
		ListNode head1 = dummy1;
		ListNode head2 = dummy2;
		head = head.next;
		while(head != null) {
			if(head.val < pivot.val) {
				head1.next = head;
				head1 = head1.next;
			}else {
				head2.next = head;
				head2 = head2.next;
			}
			head = head.next;
		}
		head1.next = null;
		head2.next = null;
		
		Result left = quickSort(dummy1.next);
		Result right = quickSort(dummy2.next);
		head = null;
		ListNode tail = null;

		if(left.head != null) {
			head = left.head;
			left.tail.next = pivot;
		}else {
			head = pivot;
		}
		if(right.tail != null) {
			tail = right.tail;
		}else {
			tail = pivot;
		}
		pivot.next = right.head;
		return new Result(head, tail);
	}
	
	private static Result partition(ListNode head) {
		
		ListNode left = null;
		ListNode right = null;
		return null;
	}
	
	

}
