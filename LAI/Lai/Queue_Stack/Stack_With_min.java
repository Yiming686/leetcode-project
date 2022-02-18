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
		if(result.equals(minStack.peek())) {//�����ʱminStack��pop��
			minStack.pop();	
		}
		return result;
	}

//	push ������ pop����push������minstack push��s
//	����minStack�Ķ���һֱΪ�ӵ͵���ǰ���˵���С��Ԫ��
	public void push(int element) {
		stack.push(element);
		if(minStack.isEmpty() || element <= minStack.peek()) {//����ʱ��push��һ����push��Ҫ��Ȼ����popʱ����pop���ǲ��أ�һ����һ��pop�ˣ������ͬ������Сֵ����û�л�׼��
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
