package Lai.Linked_List;

import Utils.ListNodeUtils.ListNode;

public class Leet_92_Reverse_Linked_List_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// public ListNode reverseBetween_ite1(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode start = dummy;
		ListNode prev = dummy;//points to ith Node
		ListNode curr = dummy.next;
		for (int i = 1; i <= n; i++) {//i < n 还是 i <= n ???
			if (i <= m) {//
				start = prev;//移动前，记录
				prev = prev.next;//then, points to ith Node
				curr = curr.next;
			} else {
				ListNode next = curr.next;
				curr.next = prev;//核心逻辑，翻转链表的连个相邻节点
				prev = curr;
				curr = next;
			}
		}
		start.next.next = curr;
		start.next = prev;
		return dummy.next;
	}
	
//=== Iterative Solution 2, ONE PASS : Time: O(N), Space: O(1) =================================================
	
	// public ListNode reverseBetween(ListNode head, int m, int n) {
    public ListNode reverseBetween_ite2(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode start = dummy;//prev of start of reversed part
		ListNode end = dummy.next;
		ListNode curr = dummy;

		for (int i = 1; i < n; i++) {
			if (i < m) {//until end points to m
				start = start.next;
				end = end.next;
			}else{//process m+1 to n
                curr = end.next;
                end.next = curr.next;
                curr.next = start.next;
                start.next = curr;
            } 
		}
		return dummy.next;
	}


}
