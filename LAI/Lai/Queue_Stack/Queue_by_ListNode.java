package Lai.Queue_Stack;

public class Queue_by_ListNode {
	static class ListNode{
		Integer val;
		ListNode next;
		public ListNode(Integer val) {
			this.val = val;
		}
	}
	//head和tail在什么时候用？只要有元素，head一定指向第一个，tail指向最后一个，为空(没有元素)或者只有一个元素时二者是相等的，都为null；
	//所以head为null时，tail也为null，反之亦然；任何一个为null，都表明为空；
	//这样的分析对数组可以吗？
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
		if(tail == null) {//全空情况下，这是first element
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
		if(head == null) {//全空情况
			return null;
		}
		ListNode node = head;
		head = head.next;
		if(head == null) {//之前是最后一个元素情况，双双归null
			tail = null;
		}
		node.next = null;//别忘了，set to null
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
