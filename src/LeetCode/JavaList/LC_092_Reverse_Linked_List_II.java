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
	 * Note: Given m, n satisfy the following condition: 1 �� m �� n �� length of
	 * list.
	 */

//	Accepted�� 250ms��
//	����⣬��ʵ��
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
	// �������еĵݹ鷽����д��Accepted
	// ��ʱ�ŷ���dummy Node�ı�Ҫ���ˣ���Ϊ��list����ʱ��Ҫ��¼��������ڵ�ǰ��Ľڵ㣬���Ƕ����׽ڵ㣬�Ͳ�������
	// Ϊ�ˣ�����dummy�ڵ㣬ʹ����ָ��head �׽ڵ㡣����
	public ListNode reverseBetween_rec(ListNode head, int m, int n) {

		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first1 = head, last1 = head, curr = dummy;
		ListNode first2 = dummy, last2 = head.next;
		// id�ĳ�ֵ����Ϊ�˱��֣�m��nֵ����ȷ��
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
		// ���headΪnull��ֱ�ӷ���
		// ���ֻ��һ���ڵ㣬ֱ�ӷ���
		if (head == null || head.next == null)
			return head;
		// ��������node ����
		ListNode pre = head;
		ListNode curr = head.next;
		// whileѭ�����������飺1.(Records)��ǰ��¼״̬ 2.(Action)���curr�������Ĵ����߼� 3.(Change
		// States)�ı�ѭ������������״̬
		while (curr != null) {
			// curr�Ǵ��������������nextָ��Ҫ�ı䣬������Ҫ�����ڵ�ֵ����¼�������Ա�����������
			// next might be null
			ListNode next = curr.next;
			// �ı�curr��ָ��֮ǰ��ֵ�Ѿ�����¼�ˣ����Բ��õ���
			// ����������ѭ���߼�,�������,ָ��ǰ��, (���Բ����������Ϊnull���߼�,����߼�ֻ��һ��,���˳�ѭ����,��ִ��)
			curr.next = pre;
			// �ı�ѭ��������ע����򣬾��Բ��ɵߵ�
			// curr��ѭ����������Ҫ���ı�ģ��ؼ������������֮ǰ��ֵ�������ڸı�֮ǰʹ��
			pre = curr;
			curr = next;
		}
		// ���ǵ�head������ʼ���ն�û�иı�,�������һ��Ԫ��,��������nextҪ����Ϊnull.
		head.next = null;
		return pre;
	}

	// this is the simplest solution.
	// Accepted 270ms, {200,270, 350}
	public ListNode reverseList_rec(ListNode head) {
		// �ݹ�ı߽�����,�Լ������߼�,����ͷǵݹ���һ�µ�
		// list Ϊnull ���߽���һ��node
		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverseList_rec(head.next);
		// �ݹ����߼����������У�,��δ�ı�newHead,˵���Դӵݹ�����㷵�غ�,newHead��û�иı��
		// �ҵ�end node
		ListNode end = head.next;
		end.next = head;
		head.next = null;
		// ��Ҫ�������,ʼ�ղ����newHead
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
