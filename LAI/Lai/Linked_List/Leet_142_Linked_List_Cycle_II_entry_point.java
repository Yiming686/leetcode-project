package Lai.Linked_List;

import Utils.ListNodeUtils.ListNode;

public class Leet_142_Linked_List_Cycle_II_entry_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		// public  ListNode detectCycle_head(ListNode head) {
		// write your solution here
		if (head == null || head.next == null) {
			return null;
		}
		//at least two Nodes, start point must be on the left of where cycle begins, 
		// if in the cycle erro occurs
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;// cycle found
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	// public  ListNode detectCycle(ListNode head) {    
	public ListNode detectCycle22(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		// ListNode fast = head;//TLE
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		// slow = slow.next;
		// slow = head.next;        
		// fast = head;
		slow = head;
		fast = fast.next;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
