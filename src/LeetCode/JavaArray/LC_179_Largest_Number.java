package LeetCode.JavaArray;

import java.util.Arrays;

import LeetCode.ArrayPrinter;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Sort

 * 
 */

public class LC_179_Largest_Number {

    public String largestNumber(int[] nums) {
        String[] NUM = new String[nums.length];
 
    for (int i = 0; i <nums.length; i++) {
        NUM[i] = String.valueOf(nums[i]);
    }
 
    Arrays.sort(NUM, new java.util.Comparator<String>() {
        public int compare(String left, String right) {
            String leftRight = left.concat(right);
            String rightLeft = right.concat(left);
            return rightLeft.compareTo(leftRight);
//            return leftRight.compareTo(rightLeft);
        }
    });
// System.out.println(NUM);
    ArrayPrinter.printStringArray(NUM);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < NUM.length; i++) {
        sb.append(NUM[i]);
    }
 
    java.math.BigInteger result = new java.math.BigInteger(sb.toString());
    return result.toString();

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 5, 30, 34, 9};
		String str = new LC_179_Largest_Number().largestNumber(nums);
		System.out.println(str);
	}

}
