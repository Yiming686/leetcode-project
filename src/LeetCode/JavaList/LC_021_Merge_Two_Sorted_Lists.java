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
		// ���㷨����֮�����ڣ���ʼʱ����check���������������check
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			//1.����dummy node���ö�̬�˶���curr����ָ����
			ListNode dummy = new ListNode();
			ListNode curr = dummy;
//			��l1,l2�Ƿ�Ϊnull���������������
//			curr, l1 �� l2 ���ڶ�̬�ƶ�
			while (l1 != null && l2 != null) {
//				�Ա�l1��l2�е���ֵ��˭��С��curr.nextָ��˭���ǵ��ҵ����Լ�ҲҪ����ƶ�
//				l1,l2Ϊ���� ���������node
//				curr Ϊ��ǰ����������node��֮ǰ��һ��node
				if(l1.val <= l2.val ){
					curr.next = l1;
					l1 = l1.next;
				}else{
					curr.next = l2;
					l2 = l2.next;
				}
//				��whileѭ���У������ɴ˵�������curr���ҵ�һ��node�󣬾���������ƶ�
				curr = curr.next;
			}
//			����������l1����l2Ϊnull�����
			if(l1==null){curr.next = l2;}
			if(l2==null){curr.next = l1;}

			return dummy.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
