package Lintcode.StackQueue;

import java.util.LinkedList;
import java.util.Stack;

/**

 Min Stack

 Description
 Notes
 Testcase
 Judge
Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

 Notice

min operation will never be called if there is no number in the stack.

Have you met this question in a real interview? Yes
Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1
Tags 
Stack Zenefits Uber Google
Related Problems 
Medium Implement Queue by Two Stacks 40 %

 *
 */
public class Min_Stack {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		3,3,6,5,7,2,5,4,8,2
//		3,3,3,3,3,2,2,2,2,2
//		3,3,2,2
//����Ŀ�����������ע��==��equals()������,��ʹ�ǶԱ�����ʱ������equals()		
		
		
	}

}

//�����ⷨ��stack����һ���� minStack������΢��һ��
//��һ�ⷨ��ͬʱpush��pop��ͬʱ��������stack��
//�ڶ��ⷨ����һ��ͬʱ��
//Second solution: TC is O(1), SC is O(n)

class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
      // do initialize if necessary
      stack = new Stack<Integer>();
      minStack = new Stack<Integer>();
  }

  public void push(int number) {
      // write your code here
      stack.push(number);
      if(minStack.isEmpty()){
          minStack.push(number);
      //����֮�������ڵȺţ������min���ظ����⣬��֤�˺���popʱ��ֻҪ��Ⱦ�pop
      } else if(number <= minStack.peek()){
          minStack.push(number);
      }
      return;
  }

  public int pop() {
      //һ����equals(), ������==
      // if(stack.peek() == minStack.peek())
      if(stack.peek().equals(minStack.peek())){
          minStack.pop();
      }
      return stack.pop();
  }

  public int min() {
      // write your code here
      return minStack.peek();
      // return minStack.peek();
  }
}

//first solution: TC is O(1), SC is O(n)
class MinStack2 {
  private LinkedList<Integer> stack;
  private LinkedList<Integer> minStack;

  public MinStack2() {
      // do initialize if necessary
      stack = new LinkedList<Integer>();
      minStack = new LinkedList<Integer>();
  }

  public void push(int number) {
      // write your code here
      stack.push(number);
      //һ����pushһ����ǰ��Сֵ����ʱpop��ʱ��ͬ��pop
      if(minStack.isEmpty()){
          minStack.push(number);
      } else{
          minStack.push(Math.min(number, minStack.peek()));
      }
      return;
  }

  public int pop() {
      // write your code here
      minStack.pop();
      return stack.pop();
  }

  public int min() {
      // write your code here
      return minStack.peek();
  }
}
  