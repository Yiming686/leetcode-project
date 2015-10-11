package Jiuzhang.DataStructure;
/*
 Easy Single Number

60% Accepted
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
Medium Single Number II 40 %
Medium Majority Number III 24 %
Medium Majority Number II 24 %
Easy Majority Number 39 %

 */
public class JZ_Single_Number_I {

	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for(int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}
	
}
