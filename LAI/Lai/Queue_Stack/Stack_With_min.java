package Lai.Queue_Stack;

import java.util.Deque;
import java.util.LinkedList;

public class Stack_With_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> stack = new LinkedList<>();
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(stack.peek());
		System.out.println(""+stack);
	}
	
	private Deque<Integer> stack;
	private Deque<Integer> minStack;
	private int globalMin;
	
	public Stack_With_min(){
		stack = new LinkedList<>();
		minStack = new LinkedList<>();
	}
	public int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		Integer result = stack.pop();
		if(result.equals(minStack.peek())) {//当相等时minStack就pop了
			minStack.pop();	
		}
		return result;
	}

//	push 决定了 pop：空push，不空minstack push，s
//	保持minStack的顶端一直为从低到当前顶端的最小的元素
	public void push(int element) {
		stack.push(element);
		if(minStack.isEmpty() || element <= minStack.peek()) {//等于时，push吗？一定得push，要不然将来pop时候，是pop还是不呢？一旦第一个pop了，后面的同样的最小值，就没有基准了
			minStack.push(element);
		}
	}

	public int top() {
		if(stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}

	public int min() {
		if(minStack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}

}
