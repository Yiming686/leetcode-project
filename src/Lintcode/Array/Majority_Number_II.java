package Lintcode.Array;

import java.util.ArrayList;

/**
Majority Number II Show result 

Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.

Note
There is only one majority number in the array.

Challenge
O(n) time and O(1) extra space.

Tags Expand 
Greedy Enumeration LintCode Copyright Zenefits


Related Problems Expand 
Medium Single Number III 33 %
Medium Single Number II 38 %
Easy Single Number 57 %
Medium Majority Number III 26 %
Medium Majority Number II 27 %
Easy Majority Number

 */
public class Majority_Number_II {
	
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate1 = -1, candidate2 = -1;
        int count1, count2;
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1 ++;
            } else if (candidate2 == nums.get(i)) {
                count2 ++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }    
        return count1 > count2 ? candidate1 : candidate2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
