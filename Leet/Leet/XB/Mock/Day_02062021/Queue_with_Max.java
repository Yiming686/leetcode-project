package Leet.XB.Mock.Day_02062021;

import static Utils.TreeNodeUtils.BINARY_TREE_NULL_NODE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Queue_with_Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue_with_Max q = new Queue_with_Max();
		System.out.println("max: "+ q.max());
		q.offer(5); System.out.println("max: "+ q.max());
		q.offer(1); System.out.println("max: "+ q.max());
		q.offer(8); System.out.println("max: "+ q.max());
		q.offer(10); System.out.println("max: "+ q.max());
		q.offer(3); System.out.println("max: "+ q.max());
		q.offer(10); System.out.println("max: "+ q.max());
		q.offer(5); System.out.println("max: "+ q.max());
		q.offer(0); System.out.println("max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
		q.poll(); System.out.println("poll(), max: "+ q.max());
	
		
	}

	Queue<Integer> queue;//
	Deque<Integer> deque;//
	
	Queue_with_Max(){
		this.queue = new ArrayDeque<>();
		this.deque = new ArrayDeque<>();
	}
	
	public void offer(int val) {
		if(queue.isEmpty()) {
			queue.offer(val);
			deque.offerLast(val);
		}else if(val >= deque.peekLast()){
			deque.offerLast(val);
		}//else do nothing
		
	}
	
	public Integer poll() {
		if(queue.isEmpty()) {
			return null;
		}
		Integer result = queue.poll();
		if(result.equals(deque.peekFirst())) {
			deque.pollFirst();
		}
		return result;
	}
	
	public Integer max() {
		if(deque.isEmpty()) {
			return null;
		}
		return deque.peekLast();
	}
	
}
