package Lai.Ace.Mountain_View;

import Lintcode.Matrix.Matrix;
import Utils.ArrayUtils;

/**
 * 
 * Given an array which consists of non-negative integers and an integer k, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000 1 ≤ m ≤ min(50, n) Examples:
 * 
 * Input: nums = [7,2,5,10,8] k = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 *
 * 
 * 
 */
public class LC_410_Split_Array_Largest_Sum {

	public static void main(String[] args) {
//		int[] arr = ArrayUtils.generateIntArray(5, 0, 10);
		int[] arr = { 7, 2, 5, 10, 8 };
		int k = 2;//18
		ArrayUtils.printIntArray(arr);
//		System.out.println(""+kCutsWithMaxLeft(arr, k));

		System.out.println("" + maxMin(arr, k));
		;

	}

//    public static int splitArray(int[] nums, int m) {
//        return -1;
//    }
	private static int[] getPrefixSum(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] prefixSum = new int[arr.length + 1]; //why +1
		if (arr.length == 0) {
			return prefixSum;
		}
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
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
		int[][] dp = new int[n + 1][k + 1];//why + 1?
		for (int i = 1; i <= n; i++) {//bars长度
			for (int j = 1; j <= k; j++) {//切割位置,no, 得到几块
				if (j == 1) {//留下一份
					dp[i][j] = prefixSum[i];
				} else {
					for (int m = j - 1; m < i; m++) {//
//						int min = Math.min(dp[m][j-1], prefixSum[i] - prefixSum[m]);
//						dp[i][j] = Math.max(dp[i][j], min);
						int min = Math.max(dp[m][j - 1], prefixSum[i] - prefixSum[m]);
						dp[i][j] = Math.min(dp[i][j], min);
					}
				}
				System.out.println("" + Matrix.fromMatrixToString(dp));
			}

		}
		return dp[n][k];
	}

}
