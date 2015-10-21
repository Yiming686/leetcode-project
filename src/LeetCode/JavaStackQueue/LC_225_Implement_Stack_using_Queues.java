package LeetCode.JavaStackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class LC_225_Implement_Stack_using_Queues {

//	my solution
    // q1: main queue, q2 Helper queue
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q1.isEmpty()){
            while(q1.size()>1){
                q2.offer(q1.poll());
            }
            q1.poll();    
        } else if(!q2.isEmpty()){
            while(q2.size()>0){
                q1.offer(q2.poll());
            }
            while(q1.size()>1){
                q2.offer(q1.poll());
            }
            q1.poll();    
        }
        return;
    }

    // Get the top element.
    public int top() {
            
        if(!q1.isEmpty()){
            while(q1.size()>1){
                q2.offer(q1.poll());
            }
           return q1.peek();    
        } else if(!q2.isEmpty()){
            while(q2.size()>0){
                q1.offer(q2.poll());
            }
            while(q1.size()>1){
                q2.offer(q1.poll());
            }
            return q1.peek();    
        }
        return Integer.MIN_VALUE;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
