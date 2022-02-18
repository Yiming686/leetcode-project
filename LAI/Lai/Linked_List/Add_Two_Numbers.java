package Lai.Linked_List;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class Add_Two_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + Character.digit('a', 16));
		ListNode<Integer> num1 = ListNodeUtils.buildIntegerLinkedList(7229);
		ListNode<Integer> num2 = ListNodeUtils.buildIntegerLinkedList(8999);
		ListNodeUtils.printList(num1);
		ListNodeUtils.printList(num2);
		ListNodeUtils.printList(addTwoNumbers(num1,num2));

	}

	public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		if(l1 == null && l2 == null) {
			return l1;
		}
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		ListNode dummy = new ListNode<>(0);
		ListNode curr = dummy;
		int carry = 0;
		while(l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			curr.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			curr = curr.next;
		}
		while(l1 != null) {
			int sum = l1.val + carry;
			curr.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			curr = curr.next;
		}
		while(l2 != null) {
			int sum = l2.val + carry;
			curr.next = new ListNode(sum % 10);
			carry = sum / 10;
			l2 = l2.next;
			curr = curr.next;
		}
		if(carry != 0) {
			curr.next = new ListNode(carry);
		}
		return dummy.next;
	}
}
