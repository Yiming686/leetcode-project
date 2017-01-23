package Lintcode.Array.String.DP;

/**
Backpack V
Problem 单次选择+装满可能性总数
Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is:

[7]
[1, 3, 3]
return 2

 *
 */
public class Backpack_V {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	前面三种都是要向背包里面放动东西，所以dp[0]初始化为0
//	后面三种都是问，向背包放东西的方案个数，所以dp[0]初始化为1，表示不放的方案有一个

//	前面三种符合条件后，要放当前东西，必须比较后，再确定一种方法
//	后面三种符合条件后，要放当前东西，不必比较，直接相加
//	区别在于对dp[j]的含义的理解和使用
//	dp[j]的含义：可重复放置，装满对应布袋大小的方案个数	
//	对当前起来说，只要布包能放得下，都要尝试放一放
	
//dp[j]的含义：和Backpack IV的含义不一样，因为每一物件只能取一次，所以布袋大小的遍历要从大到小	
	
	public int backPackV(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                	dp[j] += dp[j-nums[i]];	
                }
            }
        }
        return dp[target];
    }


}
