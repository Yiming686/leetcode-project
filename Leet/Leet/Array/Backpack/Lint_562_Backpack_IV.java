package Leet.Array.Backpack;

/**
 * 
562. Backpack IV

Description
ÖÐÎÄ
English
Given an integer array nums[] which contains n unique positive numbers, 
num[i] indicate the size of ith item. An integer target denotes the size of backpack. 
Find the number of ways to fill the backpack.

Each item may be chosen unlimited number of times

Have you met this question in a real interview?  
Example
Example1

Input: nums = [2,3,6,7] and target = 7
Output: 2
Explanation:
Solution sets are: 
[7]
[2, 2, 3]
Example2

Input: nums = [2,3,4,5] and target = 7
Output: 3
Explanation:
Solution sets are: 
[2, 5]
[3, 4]
[2, 2, 3]
Related Problems

 *
 */
public class Lint_562_Backpack_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int backPackIV(int[] nums, int target) {
    // public int backPackIV_me(int[] nums, int target) {        
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            // for(int j = target; j >= 0; j--){
            for(int j = 0; j <= target; j++){    
                if(j - nums[i] >= 0 ){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }

}
