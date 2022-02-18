package Leet.Array.Backpack;

import java.util.Arrays;

public class Leet_322_Coin_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int coinChangeWithFewestCoins(int[] nums, int target) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
//        dp[j] 表示最少需要多少个coins可以组成j，所以dp[0]== 0. 如果是问方案数则dp[0] == 1,
		int[] dp = new int[target + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);//表示凑不成,invalid case
//        Arrays.fill(dp, target + 1);//
		dp[0] = 0;//能凑成，最少个数为0
		for (int i = 0; i < nums.length; i++) {
//            for(int j = target; j >= 0; j--){//from left to right
			for (int j = 0; j <= target; j++) {//from left to right            	
				if (j - nums[i] >= 0 && dp[j - nums[i]] != Integer.MAX_VALUE) {
//                    dp[j] = dp[j] + dp[j-nums[i]];
					dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
				}
			}
		}
		if (dp[target] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[target];
	}

}
