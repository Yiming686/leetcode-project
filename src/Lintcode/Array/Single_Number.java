package Lintcode.Array;

/**
Single Number

Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,1,3,4,3], return 4

Challenge
One-pass, constant extra space.

Tags Expand 
Greedy


Related Problems Expand 
Medium Single Number III 33 %
Medium Single Number II 38 %
Medium Majority Number III 25 %
Medium Majority Number II 27 %
Easy Majority Number

 *
 */
public class Single_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int n = A[0];
		for(int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}
}
