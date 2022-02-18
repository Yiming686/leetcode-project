package Lai.Linked_List;


import Utils.ArrayUtils;
import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;

public class LL01_Reverse_Pair_by_Pair_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] arr = {-3, -2,4,7,9};
//		Integer[] arr = {-3};
//		Chaaracter[] arr = {};   
//		Integer[] arr = null;
//		ListNode<Character> head = ListNodeUtils.buildLinkedList("abcd");
//		ListNodeUtils.printList(ListNodeUtils.buildLine(6));
//		ListNodeUtils.printList(ListNodeUtils.buildCycleList(4,6));

		int[] arr = ArrayUtils.buildIntArray(13, 2, 20);
		ListNode<Integer> head = ListNodeUtils.buildLinkedList(ArrayUtils.convertIntArr2IntegerArr(arr));
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(ListNodeUtils.findMiddle(head));
//		ListNodeUtils.printList(reversePairByPairByIteration(head));
//		System.out.println(""+hasKNodes(head, 1));
		ListNodeUtils.printList(reversePairByPairByIteration(head,4));
	}

	/*
	 * 1. clarification 2. examples 3.
	 */
	// worked��best
	private static <E> ListNode<E> reversePairByPairByIteration(ListNode<E> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<E> dummy = new ListNode<E>(head.val);
		dummy.next = head;
		ListNode<E> curr = dummy;
		while (curr.next != null && curr.next.next != null) { // ��һ�ʣ��ܷ�ѭ����ֻҪ����������Ϳ��Խ���loop
			// Reverse by Pair �ĺ����߼�����ע(��ǰloop��)ǰһ��curr�����һ��next�͵�һ��curr.next
			ListNode<E> next = curr.next.next;// ���(��ǰloop��)���һ����λ��
			curr.next.next = next.next;// (��ǰloop��)��һ��ָ��(����loop��)��һ����curr,next����������next���ҵ�next����һ�����ж�next֮ǰ������
			next.next = curr.next;//
			curr.next = next;

			curr = curr.next.next;// ����ѭ������
		}
		return dummy.next;
	}

	// worked,but ignore, not the best
	private static <E> ListNode<E> reversePairByPairByIteration2(ListNode<E> head) {
		if (head == null || head.next == null) {
			return head;
		}
		// ѭ�������м�����head, next, nextNext
		ListNode<E> newHead = head.next;
		while (head.next != null) {
			ListNode<E> next = head.next;
			ListNode<E> nextNext = head.next.next;
			next.next = head;
			if (nextNext == null || nextNext.next == null) {
				head.next = nextNext;
				// break;
			} else {
				head.next = nextNext.next;
				head = nextNext;
			}
		}
		return newHead;
	}

	private static <E> ListNode<E> reversePairByPairByRecursion(ListNode<E> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<E> next = head.next;
		ListNode<E> newHead = reversePairByPairByRecursion(head.next.next);
		head.next = newHead;
		next.next = head;
		return next;
	}

	// ��չ��ÿ���������K���ڵ�
	private static <E> ListNode<E> reversePairByPairByIteration(ListNode<E> head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<E> dummy = new ListNode<E>(head.val);
		dummy.next = head;
		ListNode<E> curr = dummy;
		while (hasKNodes(curr, k)) { // ��һ�ʣ��ܷ�ѭ����ֻҪ����������Ϳ��Խ���loop
			// Reverse by Pair �ĺ����߼�����ע(��ǰloop��)ǰһ��curr�����һ��next�͵�һ��curr.next
			ListNode<E> next = findKthNodes(curr, k);// ���(��ǰloop��)���һ����λ��
			ListNode<E> nextNext = next.next; 
			next.next = null;
			ListNodeUtils.reverse(curr.next);
			ListNode<E> end = curr.next;
			end.next = nextNext;
			curr.next = next;
			
			curr = end;// ����ѭ������
		}
		return dummy.next;
	}

	// curr�ĺ�����k���ڵ���
	private static <E> boolean hasKNodes(ListNode<E> curr, int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("K must be large than 0!");
		}
		if(curr == null) {
			return false;
		}
		while (--k >= 0) {
			curr = curr.next;
			if(curr == null) {
				return false;
			}
		}
		return true;
	}

	// ����curr�ĺ����k���ڵ�
	private static <E> ListNode<E> findKthNodes(ListNode<E> curr, int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("K must be large than 0!");
		}
		if(curr == null) {
			return null;
		}
		while (--k >= 0) {
			curr = curr.next;
		}
		return curr;
	}
	
}
