package Lintcode.Array.String.DP;

/**

House Robber II 

 Description
 Notes
 Testcase
 Judge
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Notice

This is an extension of House Robber.

Have you met this question in a real interview? Yes
Example
nums = [3,6,4], return 6

Tags 
Related Problems 
Medium House Robber III 30 %
Medium Paint House 35 %
Easy Paint Fence 30 %
Medium House Robber

 *
 */
public class House_Robber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	worked
    public static int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
     }
        
    private static int helper(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prevMax = 0;
        int currMax = 0;
        for(int i = start; i <= end; i++){
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + nums[i]);
            prevMax = temp;
        }
        return currMax;
    }

    
}
