package Lai.Ace.Mountain_View;

import Lintcode.Matrix.Matrix;
import Utils.ArrayUtils;

public class N_Chocolate_K_Cuts_With_Max_Sweetness_Left {

	public static void main(String[] args) {
//		int[] arr = ArrayUtils.generateIntArray(5, 0, 10);
		int[] arr = {8,  3,  4,  2,  6};
		int k = 4;
		ArrayUtils.printIntArray(arr);
//		System.out.println(""+kCutsWithMaxLeft(arr, k));

		System.out.println("" + maxMin(arr, k));
		;
	}

//	private static String kCutsWithMaxLeft(int[] arr, int k) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	private static int[] getPrefixSum(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] prefixSum = new int[arr.length + 1]; //why +1
		if (arr.length == 0) {
			return prefixSum;
		}
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i-1];
		}
		ArrayUtils.printIntArray("prefixSum", prefixSum);
		return prefixSum;
	}

	//k <= n, n == arr.length;
	public static int maxMin(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] prefixSum = getPrefixSum(arr);
		int n = arr.length;
		int[][] dp = new int[n + 1 ][k+ 1];//why + 1?
			for (int i = 1; i <= n; i++) {//bars长度
				for (int j = 1; j <= k; j++) {//切割位置,no, 得到几块
				if (j == 1) {//留下一份
					dp[i][j] = prefixSum[i];
				} else {
					for (int m = j - 1; m < i; m++) {//
						int min = Math.min(dp[m][j-1], prefixSum[i] - prefixSum[m]);
						dp[i][j] = Math.max(dp[i][j], min);
					}
				}
				System.out.println(""+Matrix.fromMatrixToString(dp));
			}

		}
		return dp[n][k];
	}

}
