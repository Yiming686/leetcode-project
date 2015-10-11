package Jiuzhang.DataStructure;

import java.util.ArrayList;

/*
 Easy Majority Number

 39% Accepted
 Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

 Have you met this question in a real interview? Yes
 Example
 Given [1, 1, 1, 1, 2, 2, 2], return 1

 Challenge
 O(n) time and O(1) extra space

 Tags Expand 
 Greedy Enumeration LintCode Copyright


 Related Problems Expand 
 Medium Single Number III 33 %
 Medium Single Number II 40 %
 Easy Single Number 60 %
 Medium Majority Number III 24 %
 Medium Majority Number II 24 %
 Medium Digit Counts 36 %

 */
public class JZ_Majority_Number {

	public int majorityNumber(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() == 0) {
			return -1;
		}
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.size(); j++) {
				bits[i] += nums.get(i) >> i & 1;
				// bits[i] %= 3;
			}
			bits[i] %= 3;
			// result |= (bits[i] << i);
			result |= (bits[i] << i);
		}
		// for (int i = 0; i < 32; i++) {
		// result |= (bits[i] << i);
		// }
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
