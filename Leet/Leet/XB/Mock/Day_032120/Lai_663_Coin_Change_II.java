package Leet.XB.Mock.Day_032120;

public class Lai_663_Coin_Change_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int coinChange(int amount, int[] coins) {
		int len = coins.length;
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				if (j - coins[i] >= 0) {
//		          dp[j] = dp[j] + dp[j-coins[i]];
					dp[j] += dp[j - coins[i]];
				}
			}
		}
		return dp[amount];
	}

}
