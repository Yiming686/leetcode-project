package LeetCode.JavaList;

public class LC_206_Reverse_Linked_List {

	/*
	 * Reverse Linked List Hint: A linked list can be reversed either
	 * iteratively or recursively. Could you implement both?
	 */

//	Only two nodes needed.
	public ListNode reverseList_it(ListNode head) {
//		���headΪnull��ֱ�ӷ���
//		���ֻ��һ���ڵ㣬ֱ�ӷ���
		if (head == null || head.next == null)
			return head;
//		��������node ����
		ListNode pre = head;
		ListNode curr = head.next;
//		whileѭ�����������飺1.(Records)��ǰ��¼״̬ 2.(Action)���curr�������Ĵ����߼� 3.(Change States)�ı�ѭ������������״̬
		while (curr != null) {
//curr�Ǵ��������������nextָ��Ҫ�ı䣬������Ҫ�����ڵ�ֵ����¼�������Ա�����������			
//			next might be null
			ListNode next = curr.next;
//			�ı�curr��ָ��֮ǰ��ֵ�Ѿ�����¼�ˣ����Բ��õ���
//			����������ѭ���߼�,�������,ָ��ǰ��, (���Բ����������Ϊnull���߼�,����߼�ֻ��һ��,���˳�ѭ����,��ִ��)
			curr.next = pre;
//			�ı�ѭ��������ע����򣬾��Բ��ɵߵ�
//			curr��ѭ����������Ҫ���ı�ģ��ؼ������������֮ǰ��ֵ�������ڸı�֮ǰʹ��
			pre = curr;
			curr = next;
		}
//		���ǵ�head������ʼ���ն�û�иı�,�������һ��Ԫ��,��������nextҪ����Ϊnull.
		//head.next = null;
		return pre;
	}

	// this is the simplest solution.
	// Accepted 270ms, {200,270, 350}
	public ListNode reverseList_rec(ListNode head) {
//		�ݹ�ı߽�����,�Լ������߼�,����ͷǵݹ���һ�µ�
//		list Ϊnull ���߽���һ��node
		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverseList_rec(head.next);
//�ݹ����߼����������У�,��δ�ı�newHead,˵���Դӵݹ�����㷵�غ�,newHead��û�иı��
//		�ҵ�end node
		ListNode end = head.next;
		end.next = head;
		head.next = null;
//��Ҫ�������,ʼ�ղ����newHead
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
