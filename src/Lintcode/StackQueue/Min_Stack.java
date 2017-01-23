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
//此题目是想告诉我们注意==和equals()的区别,即使是对比整数时对象用equals()		
		
		
	}

}

//两个解法的stack含义一样， minStack含义略微不一样
//第一解法，同时push和pop，同时更改两个stack，
//第二解法，不一定同时了
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
      //精彩之处就在于等号，解决了min的重复问题，保证了后面pop时，只要相等就pop
      } else if(number <= minStack.peek()){
          minStack.push(number);
      }
      return;
  }

  public int pop() {
      //一定用equals(), 不能用==
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
      //一定会push一个当前最小值，到时pop的时候，同步pop
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
  