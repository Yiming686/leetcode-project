package Leet.Array.Subarray;

public class Paint_Woods_With_Min_Total_Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	
	private static int minTotalTime(int[] arr, int k) {
		int len = arr.length;
		int[][] dp = new int[len+1][k+1];
		for(int i = 0; i < len; i++) {
			dp[i][1] = Integer.MAX_VALUE;
//			dp[i][1] = arr[];	
		}
		
		for (int j = 1; j <= k; j++) {//j disjoin subarrays
			
			for (int i = 1; i <= len; i++) {// first i+1 Integers
				if(j - 1 >= 0) {
//					dp[i][j] = Math.min(dp[][], Math.max(dp[i][j], time()));
				}
			}
		}
		return dp[len][k];
	}

}
