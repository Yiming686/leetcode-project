package Lai.Queue_Stack;

public class Queue_by_ListNode {
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
	private ListNode tail;//point to last element; null if empty; == head if only one;
	private int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue_by_ListNode q = new Queue_by_ListNode();
		System.out.println(""+q);
		q.peek();
		q.poll();
		q.offer(5);
		q.poll();
		q.offer(2);
		q.offer(4);
		q.offer(8);
		q.poll();
		q.poll();
		q.poll();
		q.poll();
	}
	
	public boolean offer(Integer val) {
		ListNode node = new ListNode(val);
		if(tail == null) {//ȫ������£�����first element
			head = node;
			tail = node; 
		}else {
			tail.next = node;
			tail = tail.next;
		}
		size++;
		return true;
	}
	
	public Integer poll() {
		if(head == null) {//ȫ�����
			return null;
		}
		ListNode node = head;
		head = head.next;
		if(head == null) {//֮ǰ�����һ��Ԫ�������˫˫��null
			tail = null;
		}
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
