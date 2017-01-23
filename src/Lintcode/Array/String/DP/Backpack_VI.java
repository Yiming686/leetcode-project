package Lintcode.Array.String.DP;

/**
Backpack VI 

AKA: Combination Sum IV

Problem 重复选择+不同排列+装满可能性总数

Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Notice
The different sequences are counted as different combinations.

Example
Given nums = [1, 2, 4], target = 4

The possible combination ways are:

[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
return 6

 *
 */
public class Backpack_VI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	前面三种都是要向背包里面放动东西，所以dp[0]初始化为0
//	后面三种都是问，向背包放东西的方案个数，所以dp[0]初始化为1，表示不放的方案有一个

//	前面三种符合条件后，要放当前东西的话，必须比较后，再确定一种方法
//	后面三种符合条件后，要放当前东西的话，不必比较，直接相加
	
//	区别在于对dp[j]的含义的理解和使用
//	dp[j]的含义：可重复放置，装满对应布袋大小的方案个数	
//	对当前起来说，只要布包能放得下，都要尝试放一放
	
//dp[j]的含义：	

    public static int backPackVI(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num: nums) {
                if (j-num>=0){
                	dp[j] += dp[j-num];
                } 
                	
            }
        }
        return dp[target];
    }

}
