package Lintcode.Array.Median;

/**
Sliding Window Median

Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;

Challenge
O(nlog(n)) time

Tags Expand 
LintCode Copyright Heap


Related Problems Expand 
Super Building Outline 11 %
Super Sliding Window Maximum 25 %
Hard Data Stream Median

 *
 */
public class Sliding_Window_Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
