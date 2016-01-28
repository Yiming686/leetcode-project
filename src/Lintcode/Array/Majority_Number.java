package Lintcode.Array;

import java.util.ArrayList;

/**
Majority Number Show result 

Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
O(n) time and O(1) extra space

Tags Expand 
Greedy Enumeration LintCode Copyright Zenefits


Related Problems Expand 
Medium Single Number III 33 %
Medium Single Number II 38 %
Easy Single Number 57 %
Medium Majority Number III 26 %
Medium Majority Number II 27 %
Medium Digit Counts *

 */
public class Majority_Number {
	
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate=0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count ++;
            } else {
                if (candidate == nums.get(i)) {
                    count ++;
                } else {
                    count --;
                }
            }
        }
        return candidate;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
