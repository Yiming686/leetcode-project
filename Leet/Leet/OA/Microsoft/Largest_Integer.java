package Leet.OA.Microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that, given an array A of N integers, returns the lagest
 * integer K > 0 such that both values K and -K exisit in array A. If there is
 * no such integer, the function should return 0.
 *
 * 
 * 
 */
public class Largest_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, -2, 5, -3 };
//		int[] nums = { 1, 2, 3, -4 };
		System.out.println(largestNum(nums));
		System.out.println(largestNum2(nums));

	}

	private static int largestNum(int[] nums) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(-nums[i])) {
				res = Math.max(res, Math.abs(nums[i]));
			}
			set.add(nums[i]);
		}
		return res;
	}

	private static int largestNum2(int[] nums) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(-nums[i]);
			if (set.contains(nums[i])) {
				res = Math.max(res, Math.abs(nums[i]));
			}
		}
		return res;
	}

}
