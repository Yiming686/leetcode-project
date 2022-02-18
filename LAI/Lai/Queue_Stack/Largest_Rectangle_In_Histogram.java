package Lai.Queue_Stack;

import java.util.Deque;
import java.util.LinkedList;

//public class Largest_Rectangle_In_Histogram {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

//Largest Rectangle In Histogram
//Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each
//bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.
//http://app.laicode.io/app/problem/198

public class Largest_Rectangle_In_Histogram {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	public int largest(int[] array) {
// Assumptions: array is not null, array.length >= 1,
// all the values in the array are non-negative.
		int result = 0;
// Note that the stack contains the ¡°index¡±,
//not the ¡°value¡± of the array
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i <= array.length; i++) {
//we need a way of popping out all the elements in the stack
// at last, so that we explicitly add a bar of height 0
			int cur = i == array.length ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
				int height = array[stack.pollFirst()];
// determine the left boundary of the largest rectangle
//with height array[i]
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
//determine the right boundary of the 1largest rectangle
//with height of the popped element
				result = Math.max(result, height * (i - left));

			}
			stack.offerFirst(i);
		}
		return result;
	}
}
