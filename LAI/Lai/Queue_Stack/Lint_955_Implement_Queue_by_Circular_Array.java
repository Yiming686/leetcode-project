package Lai.Queue_Stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Lint_955_Implement_Queue_by_Circular_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		Iterator<Integer> it = list.iterator();
		it.hasNext();
		it.next();
		
	}

	static class CircularQueue {
		int[] arr;
		// tail: inclusive, pos to insert dat when enqueueing, inseted data on its left side 
		// head: pos to dequeue data, inserted data on its right side
		int head;//head
		int tail;//tail

		public CircularQueue(int n) {
			// initialize your data structure here
			arr = new int[n + 1];
			head = 0;
			tail = 1;
		}

		/**
		 * @return: return true if the array is full
		 */
		public boolean isFull() {
			// write your code here
			// return (tail + 1) % arr.length == head;
			return tail == head;
		}

		/**
		 * @return: return true if there is no element in the array
		 */
		public boolean isEmpty() {
			// write your code here
			return (head + 1) % arr.length == tail;
			// return tail - head == 0;
		}

		/**
		 * @param element:
		 *            the element given to be added
		 * @return: nothing
		 */
		public void enqueue(int element) {
			// write your code here
			// if(isFull()){
			//     return;
			// }
			arr[tail] = element;
			tail = (tail + 1) % arr.length;
		}

		/**
		 * @return: pop an element from the queue
		 */
		public int dequeue() {
			// write your code here
			// if(isEmpty()){
			//     return
			// }
			head = (head + 1) % arr.length;
			return arr[head];
		}
	}

}


