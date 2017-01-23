package Lintcode.Array.String.DP;

/**
Backpack IV

Problem 重复选择+唯一排列+装满可能性总数
Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may be chosen unlimited number of times

Example
Given candidate items [2,3,6,7] and target 7,

A solution set is:

[7]
[2, 2, 3]
return 2
 *
 */
public class Backpack_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	前面三种都是要向背包里面放动东西，所以dp[0]初始化为0
//	后面三种都是问，向背包放东西的方案个数，所以dp[0]初始化为1，表示不放的方案有一个

//	前面三种符合条件后，要放当前东西，必须比较后，再确定一种方法
//	后面三种符合条件后，要放当前东西，不必比较，直接相加
//	区别在于对dp[j]的含义的理解和使用
//	dp[j]的含义：可重复放置，装满对应布袋大小的方案个数
	
//	dp[j]的含义每次肯定不一样，初始化0位置的值也不一样
//	对当前起来说，只要布包能放得下，都要尝试放一放
//	
    public int backPackIV(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
//            原来解法
//                if (nums[i] == j) dp[j]++;
//                else if (nums[i] < j) dp[j] += dp[j-nums[i]];
            	if ( j- nums[i] >= 0){
            		dp[j] += dp[j-nums[i]];
            	}
            }
        }
        return dp[target];
    }

}
