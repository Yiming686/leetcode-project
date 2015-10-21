package LeetCode.JavaList;

public class LC_021_Merge_Two_Sorted_Lists {

	/**
	 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
	 * Definition for singly-linked list. 
	 * public class ListNode { 
	 * 	int val;
	 * 	ListNode next; 
	 * 	ListNode(int x) 
	 * { val = x; } }
	 */
	public class Solution {
		// 此算法奥妙之处在于，开始时不用check参数，到了最后在check
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			//1.创建dummy node，让动态运动的curr首先指向他
			ListNode dummy = new ListNode();
			ListNode curr = dummy;
//			对l1,l2是否为null，分三种情况处理
//			curr, l1 和 l2 都在动态移动
			while (l1 != null && l2 != null) {
//				对比l1和l2中的数值，谁的小就curr.next指向谁，记得找到后自己也要向后移动
//				l1,l2为即将 处理的两个node
//				curr 为当前待处理两个node，之前的一个node
				if(l1.val <= l2.val ){
					curr.next = l1;
					l1 = l1.next;
				}else{
					curr.next = l2;
					l2 = l2.next;
				}
//				此while循环中，必须由此迭代，让curr在找到一个node后，就依次向后移动
				curr = curr.next;
			}
//			接下来处理l1或者l2为null的情况
			if(l1==null){curr.next = l2;}
			if(l2==null){curr.next = l1;}

			return dummy.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
