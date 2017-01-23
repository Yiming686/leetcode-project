package Lintcode.StackQueue;

import java.util.Stack;

/**

 Implement Queue by Two Stacks

 Description
 Notes
 Testcase
 Judge
As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Have you met this question in a real interview? Yes
Example
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2
Challenge 
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.

Tags 
LintCode Copyright Stack Queue
Related Problems 
Medium Min Stack 33 %

 *
 */
public class Implement_Queue_by_Two_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    //构造两个stack，第一个stack是queue的入口，第二个stack是queue的出口
    //enqueue时闭着眼睛，往stack1里面push；dequeue时,必须从stack2顶端pop元素
    //需先判断，若不为空，pop之，为空，用while循环，把stack1里面的元素全部pop并push到stack2里面然后，pop最顶端的
    
}
