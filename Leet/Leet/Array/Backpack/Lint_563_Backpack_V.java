package Leet.Array.Backpack;

import static Utils.ArrayUtils.print;
import static Utils.TreeNodeUtils.isSame;

import java.util.Arrays;

/**
 * 
563. Backpack V

Description
ÖÐÎÄ
English
Given n items with size nums[i] which an integer array and all positive numbers. 
An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Have you met this question in a real interview?  
Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is: 
[7]
[1, 3, 3]
return 2

 *
 */
public class Lint_563_Backpack_V {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,3,7};
//		int target = 7;
		int target = 5;
		System.out.println(""+backPackV(nums, target));
	}
    public static int backPackV(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
//            for(int j = target; j >= 0; j--){//from left to right
            for(int j = 0; j <= target; j++){//from left to right            	
                if(j - nums[i] >= 0 ){
//                    dp[j] = dp[j] + dp[j-nums[i]];
                    dp[j] = Math.min(dp[j], dp[j-nums[i]] + 1);
                }
            }
            print(dp);
        }
        return dp[target];
    }

}
