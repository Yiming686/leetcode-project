package LeetCode.JavaList;

public class LC_206_Reverse_Linked_List {

	/*
	 * Reverse Linked List Hint: A linked list can be reversed either
	 * iteratively or recursively. Could you implement both?
	 */

//	Only two nodes needed.
	public ListNode reverseList_it(ListNode head) {
//		如果head为null，直接返回
//		如果只有一个节点，直接返回
		if (head == null || head.next == null)
			return head;
//		处理两个node 以上
		ListNode pre = head;
		ListNode curr = head.next;
//		while循环干三件事情：1.(Records)提前记录状态 2.(Action)针对curr，真正的处理逻辑 3.(Change States)改变循环变量，调整状态
		while (curr != null) {
//curr是待处理变量，他的next指向要改变，所以先要把现在的值，记录下来，以便后面继续遍历			
//			next might be null
			ListNode next = curr.next;
//			改变curr的指向，之前的值已经被记录了，所以不用担心
//			这是真正的循环逻辑,打断连接,指向前方, (绝对不可添加设置为null的逻辑,这个逻辑只有一次,在退出循环后,才执行)
			curr.next = pre;
//			改变循环变量，注意次序，绝对不可颠倒
//			curr是循环变量，是要被改变的，关键是如果还需他之前的值，必须在改变之前使用
			pre = curr;
			curr = next;
		}
//		最后记得head变量从始至终都没有改变,他是最后一个元素,所以他的next要设置为null.
		//head.next = null;
		return pre;
	}

	// this is the simplest solution.
	// Accepted 270ms, {200,270, 350}
	public ListNode reverseList_rec(ListNode head) {
//		递归的边界条件,以及处理逻辑,这个和非递归是一致的
//		list 为null 或者仅仅一个node
		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverseList_rec(head.next);
//递归后的逻辑（以下三行）,并未改变newHead,说明自从递归最里层返回后,newHead就没有改变过
//		找到end node
		ListNode end = head.next;
		end.next = head;
		head.next = null;
//就要返回这个,始终不变的newHead
		return newHead;
	}

	// Code below not works,

	// private ListNode reverseList_rec3(ListNode head) {
	// // null or one node, return;
	// if (head == null || head.next ==null){
	// return head;
	// }
	// ListNode newHead = reverseList_rec3(head.next);
	// pre.next = head;
	// head.next = null;
	//
	// return head;
	// }
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = head;
		return reverseList_rec2(head, newHead);
	}

	private ListNode reverseList_rec2(ListNode head, ListNode newHead) {
		if (head == null || head.next == null) {
			newHead = head;
			return head;
		}
		ListNode pre = reverseList_rec2(head.next, newHead);
		pre.next = head;
		head.next = null;

		return head;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode left = head;
		ListNode right = head.next;
		if (right == null)
			return head;
		ListNode end = null;

		if (right.next == null) {
			right.next = left;
			left.next = null;
			// head = right;
			end = left;
			return right;
		}
		right.next = left;
		right = reverseList(right);
		end.next = head;
		head.next = null;

		return right;
	}

	private ListNode reverseList_rec4(ListNode head) {
		// TODO Auto-generated method stub
		if (head == null || head.next == null)
			return null;
		ListNode left = head;
		ListNode right = head.next;
		if (right == null)
			return head;
		ListNode end = null;
		if (right.next == null) {
			right.next = left;
			left.next = null;
			// head = right;
			end = left;
			return end;
		}
		end = reverseList_rec(right);
		end.next = head;
		head.next = null;
		return end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
