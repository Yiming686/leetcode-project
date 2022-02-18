package Lai.Queue_Stack;

public class Stack_by_ListNode {
	static class ListNode{
		Integer val;
		ListNode next;
		public ListNode(Integer val) {
			this.val = val;
		}
	}
	//head��tail��ʲôʱ���ã�ֻҪ��Ԫ�أ�headһ��ָ���һ����tailָ�����һ����Ϊ��(û��Ԫ��)����ֻ��һ��Ԫ��ʱ��������ȵģ���Ϊnull��
	//����headΪnullʱ��tailҲΪnull����֮��Ȼ���κ�һ��Ϊnull��������Ϊ�գ�
	//�����ķ��������������
	private ListNode head;//point to first element; null if empty; == tail if only one;
	private int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_by_ListNode q = new Stack_by_ListNode();
		System.out.println(""+q);
		q.peek();
		q.pop();
		q.push(5);
		q.pop();
		q.push(2);
		q.push(4);
		q.push(8);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}
	
	public void push(Integer val) {
		ListNode node = new ListNode(val);
		node.next = head;
		head = node;
		size++;
		return ;
	}
	
	public Integer pop() {
		if(head == null) {//ȫ�����
			return null;
		}
		ListNode node = head;
		head = head.next;
		node.next = null;//�����ˣ�set to null
		size--;
		return node.val;
	}
	
	public Integer peek() {
		if(head == null) {
			return null;
		}
		return head.val;
	}
	
	

}
