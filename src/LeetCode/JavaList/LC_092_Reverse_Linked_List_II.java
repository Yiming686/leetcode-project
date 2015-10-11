package LeetCode.JavaList;

public class LC_092_Reverse_Linked_List_II {

	/*
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of
	 * list.
	 */

//	Accepted， 250ms，
//	好理解，好实现
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode curr = dummy.next;
		ListNode start = dummy;

		for (int i = 1; i <= n; i++) {
			if (i == m) {
				start = pre;
			}
			if (i > m && i <= n) {
				ListNode next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			} else {
				pre = pre.next;
				curr = curr.next;
			}
		}

		start.next.next = curr;
		start.next = pre;

		return dummy.next;
	}

//	solution from book, Accepted 230ms, {230, 250, 350}
    public ListNode reverseBetween_book(ListNode head, int m, int n) {
        
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode mNode = new ListNode(0);

		ListNode pre = dummy;
		ListNode curr = dummy.next;
		ListNode next;

		for (int i = 1; i <= n; i++) {
			if (i == m) {
				mNode = curr;
			}
			if(i<m) pre = pre.next;
            next = curr.next;

			if (i > m && i <= n) {
				mNode.next = next;
				curr.next = pre.next;
				pre.next = curr;
			} 
            curr = next;
		}

		return dummy.next;
    }
	// public ListNode reverseBetween(ListNode head, int m, int n) {
	// 利用已有的递归方法，写成Accepted
	// 此时才发现dummy Node的必要性了：因为是list，有时需要记录，待处理节点前面的节点，但是对于首节点，就不适用了
	// 为此，创建dummy节点，使得它指向head 首节点。即可
	public ListNode reverseBetween_rec(ListNode head, int m, int n) {

		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first1 = head, last1 = head, curr = dummy;
		ListNode first2 = dummy, last2 = head.next;
		// id的初值，是为了保持，m和n值的正确性
		int i = -1;
		while (curr != null) {
			i++;
			if (i == m - 1) {
				first2 = curr;
				first1 = curr.next;
			}
			if (i == n) {
				last1 = curr;
				last2 = last1.next;
				break;
			}
			curr = curr.next;
		}
		last1.next = null;
		ListNode newFirst1 = reverseList_rec(first1);
		first1.next = last2;
		first2.next = newFirst1;

		return dummy.next;
	}

	// Only two nodes needed.
	public ListNode reverseList_it(ListNode head) {
		// 如果head为null，直接返回
		// 如果只有一个节点，直接返回
		if (head == null || head.next == null)
			return head;
		// 处理两个node 以上
		ListNode pre = head;
		ListNode curr = head.next;
		// while循环干三件事情：1.(Records)提前记录状态 2.(Action)针对curr，真正的处理逻辑 3.(Change
		// States)改变循环变量，调整状态
		while (curr != null) {
			// curr是待处理变量，他的next指向要改变，所以先要把现在的值，记录下来，以便后面继续遍历
			// next might be null
			ListNode next = curr.next;
			// 改变curr的指向，之前的值已经被记录了，所以不用担心
			// 这是真正的循环逻辑,打断连接,指向前方, (绝对不可添加设置为null的逻辑,这个逻辑只有一次,在退出循环后,才执行)
			curr.next = pre;
			// 改变循环变量，注意次序，绝对不可颠倒
			// curr是循环变量，是要被改变的，关键是如果还需他之前的值，必须在改变之前使用
			pre = curr;
			curr = next;
		}
		// 最后记得head变量从始至终都没有改变,他是最后一个元素,所以他的next要设置为null.
		head.next = null;
		return pre;
	}

	// this is the simplest solution.
	// Accepted 270ms, {200,270, 350}
	public ListNode reverseList_rec(ListNode head) {
		// 递归的边界条件,以及处理逻辑,这个和非递归是一致的
		// list 为null 或者仅仅一个node
		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverseList_rec(head.next);
		// 递归后的逻辑（以下三行）,并未改变newHead,说明自从递归最里层返回后,newHead就没有改变过
		// 找到end node
		ListNode end = head.next;
		end.next = head;
		head.next = null;
		// 就要返回这个,始终不变的newHead
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
