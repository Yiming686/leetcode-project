package Lai.Queue_Stack;

import java.sql.SQLClientInfoException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Queue_By_Two_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Deque<Integer> s1;
	private Deque<Integer> s2;
	
//	push(e)--> s1.addFirst(e);
//	pop()--> s1.removeFirst();
//	peek()--> s1.peekFirst();
	public Queue_By_Two_Stacks() {
		// Write your solution here.
		s1 = new ArrayDeque<Integer>();
		s2 = new ArrayDeque<Integer>();
		s1.addFirst(null);
		s1.addFirst(null);
	}
//           Out <== ] s2 : s1 [ <== In

	public Integer poll() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.addFirst(s1.removeFirst());
			}
		}
		return s2.isEmpty() ? null : s2.removeFirst();
//		return s2.pop(); //Input: if null, java.util.NoSuchElementException
	}

	public void offer(int element) {
		s1.addFirst(element);
	}

	public Integer peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.addFirst(s1.removeFirst());
			}
		}
		return s2.peekFirst(); //Input: if null, return null
	}

	public int size() {
		return s1.size() + s2.size();
	}

	public boolean isEmpty() {
		return s1.size() == 0 && s2.size() == 0;
	}

}
