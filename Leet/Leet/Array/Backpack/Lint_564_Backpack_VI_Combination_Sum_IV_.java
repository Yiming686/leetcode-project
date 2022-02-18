package Leet.Array.Backpack;

import static Utils.ArrayUtils.print;
import static Utils.MatrixUtils.print;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers;

/**
Description
中文
English
Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

A number in the array can be used multiple times in the combination.
Different orders are counted as different combinations.

Have you met this question in a real interview?  
Example
Example1

Input: nums = [1, 2, 4], and target = 4
Output: 6
Explanation:
The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
Example2

Input: nums = [1, 2], and target = 4
Output: 5
Explanation:
The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
Related Pro

 *
 */
public class Lint_564_Backpack_VI_Combination_Sum_IV_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4};
//		int[] nums = {1,2};
		int target = 4;
		System.out.println(""+backPackVI(nums, target));
		System.out.println(""+backPackVI_2d(nums, target));
	}

//	public static int backPackIV(int[] nums, int target) {
//和backPackIV对比，起来，就是内外for循环，调换次序了。所以启发对内外循环的新认知
//	target 由小到大，对于当前target值j，所有的方案可能以什么结尾呢，nums[0] -> nums[i], 
//	先前对于target值j-1，我们应该已经统计完毕了， 现在只需要针对统计以nums[i]为结尾的方案总数，
//	所以dp[j]定义: target j 对应的所有方案总数；所以dp[0]==1, 
	public static int backPackVI(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		// for(int j = target; j >= 0; j--){
		for (int j = 0; j <= target; j++) {
			for (int i = 0; i < nums.length; i++) {
				if (j - nums[i] >= 0) {
					dp[j] = dp[j] + dp[j - nums[i]];
				}
			}
			print(dp);
		}
		return dp[target];
	}

//	dp[j][i] 前i个物品组成体积为j的组合个数，所以返回dp[target][len]
	public static int backPackVI_2d(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[][] dp = new int[target + 1][len+1];
		dp[0][0] = 1;
		// for(int j = target; j >= 0; j--){
		for (int j = 0; j <= target; j++) {
			for (int i = 0; i < nums.length; i++) {
				dp[0][i+1] = 1;
				dp[j][i+1] = dp[j][i];
				if (j - nums[i] >= 0) {
//					dp[j][i+1] = dp[j][i+1] + dp[j - nums[i]][len];
					dp[j][i+1] = dp[j][i] + dp[j - nums[i]][len];
				}
			}
			print(dp);
		}
		return dp[target][len];
	}

	public static int backPackIV(int[] nums, int target) {
		// public int backPackIV_me(int[] nums, int target) {        
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			// for(int j = target; j >= 0; j--){
			for (int j = 0; j <= target; j++) {//nums[i] 可以放多次，这是由从小到大的次序决定的。只是表明，可以有多个，但是他们的次序是没关系的。
				if (j - nums[i] >= 0) {
					dp[j] = dp[j] + dp[j - nums[i]];
				}
			}
		}
		return dp[target];
	}

}
