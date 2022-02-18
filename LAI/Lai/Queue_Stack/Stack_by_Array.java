package Lai.Queue_Stack;

public class Stack_by_Array {
	//head和tail在什么时候用？只要有元素，head一定指向第一个，tail指向最后一个，为空(没有元素)或者只有一个元素时二者是相等的，都为null；
	//所以head为null时，tail也为null，反之亦然；任何一个为null，都表明为空；
	//这样的分析对数组可以吗？
	private Integer[] arr = new Integer[16];
	private int head;//point to first element; 最好指向待push插入位置
//	private int size; size == head+1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_by_Array q = new Stack_by_Array();
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
		//ensure capacity，确保 head+2 能放得下
		arr[head] = val;
		head++;
//		此处确保ensure capacity，必要时扩容resize
		return ;
	}
	
	public Integer pop() {
		if(head == 0) {//全空情况
			return null;
		}
		Integer val = arr[head-1];
		head--;
		return val;
	}
	
	public Integer peek() {
		if(head == 0) {
			return null;
		}
		return arr[head-1];
	}
	
	

}
