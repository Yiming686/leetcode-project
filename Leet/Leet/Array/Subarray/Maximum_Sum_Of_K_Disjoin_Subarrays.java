package Leet.Array.Subarray;

import static Utils.ArrayUtils.print;
import static Utils.MatrixUtils.print;

public class Maximum_Sum_Of_K_Disjoin_Subarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,2,3,4,5};//15
		int[] arr = { 1, -2, 3, -4, 5, 6, 7 };//22
//		int[] arr = { 1, -2, };//22
		int k = 2;
		
		System.out.println("" + maxSum_v1(arr, k));
		System.out.println("" + maxSum_v2(arr, k));

	}

//	DP solution:
//	M[n][k] represents max sum of k disjoin subarrays for first n Integers in array arr.
//	M[n][k] = max{
//				case 1: M[n-1][k-1] + maxSubarraySum(arr, n-1, n-1); 
//              case 2: M[n-2][k-1] + maxSubarraySum(arr, n-2, n-1);
//	              ... :
//	            case n-k+1: M[k-1][k-1] + maxSubarraySum(arr, k-1, n-1);
//	}
//	Base case: M[1][1] ... M[n][1]
	
//	constants: len, k
//	M[i][j] represents max sum of j disjoin subarrays for first i Integers in array arr.
//	M[i][j] = max{
//				case 1: M[i-1][j-1] + maxSubarraySum(arr, i-1, i-1); 
//              case 2: M[i-2][j-1] + maxSubarraySum(arr, i-2, i-1);
//	              ... :
//				case 2: M[i-l][j-1] + maxSubarraySum(arr, i-l, i-1);
//	            case i-(i-j+1): M[j-1][j-1] + maxSubarraySum(arr, i-(i-j+1), i-1);
//				case len: M[0][j-1] + maxSubarraySum(arr, 0, i-1);
//	}
	
//	Base case: M[1][1] ... M[n][1]
//	Time: O(n^2*k), Space: O(n*k)
	private static int maxSum_v1(int[] arr, int k) {
		int len = arr.length;
		int[][] dp = new int[len+1][k+1];
		for(int i = 1; i <= len; i++) {
//			dp[i][0] = Integer.MIN_VALUE;
			dp[i][1] = largestSum(arr, 0, i-1);	
		}
		for (int j = 2; j <= k; j++) {//col: j disjoin subarrays
			for (int i = 1; i <= len; i++) {//row: first i Integers
				dp[i][j] = Integer.MIN_VALUE;
				for (int l = 1; l <= len; l++) {//row: first i Integers
					if(i- l >= j-1) {
//					dp[i][j] = Math.max(dp[i][j], dp[j - 1][j-1] + largestSum(arr, j-1, i-1));
						dp[i][j] = Math.max(dp[i][j], dp[i-l][j-1] + largestSum(arr, i-l, i-1));
					}
				}
			}
			print(dp); //maxSum_v1
		}
		return dp[len][k];
	}
//	constants: len, k
//	M[i] represents max sum of k disjoin subarrays for first i Integers in array arr.
//	M[i] = max{
//				case 1: M[i-1] + maxSubarraySum(arr, i-1, i-1); 
//              case 2: M[i-2] + maxSubarraySum(arr, i-2, i-1);
//	              ... :
//				case 2: M[i-l] + maxSubarraySum(arr, i-l, i-1);
//	            case i-(i-j+1): M[j-1] + maxSubarraySum(arr, i-(i-j+1), i-1);
//				case len: M[0][j-1] + maxSubarraySum(arr, 0, i-1);
//	}
	
//	Base case: M[1][1] ... M[n][1]
//	Time: O(n*k), Space: O(n)
	private static int maxSum_v2(int[] arr, int k) {
		int len = arr.length;
//		int[][] dp = new int[len+1][k+1];
		int[] dp = new int[len+1];
//		for(int i = 1; i <= len; i++) {
		for (int i = len; i >= 1; i--) {//row: first i Integersx			
//			dp[i][0] = Integer.MIN_VALUE;
			dp[i] = largestSum(arr, 0, i-1);	//k=1
		}
		print(dp);
		for (int j = 2; j <= k; j++) {//col: j disjoin subarrays
//		for (int j = k; j >= 2; j--) {//col: j disjoin subarrays			
			for (int i = 1; i <= len; i++) {//row: first i Integersx
//			for (int i = len; i >= 1; i--) {//row: first i Integersx				
				dp[i] = Integer.MIN_VALUE;
				for (int l = 1; l <= len; l++) {//row: first i Integers
					if(i - l >= 0) {
//					dp[i][j] = Math.max(dp[i][j], dp[j - 1][j-1] + largestSum(arr, j-1, i-1));
//						dp[i] = Math.max(dp[i], dp[len - i] + largestSum(arr, i-1, len - 1));
						dp[i] = Math.max(dp[i], dp[i-l] + largestSum(arr, i-l, i - 1));
					}
				}
			}
			print(dp);//maxSum_v2
		}
		return dp[len];
	}
	
//private static int maxSum_v0(int[] arr, int k) {
//		int len = arr.length;
//		int[][] dp = new int[len][k+1];
//		for(int i = 0; i < len; i++) {
//			dp[i][1] = Integer.MIN_VALUE;	
//		}
//		
//		for (int j = 1; j <= k; j++) {//j disjoin subarrays
//			
//			for (int i = 1; i <= len; i++) {// first i+1 Integers
//				if(i - j + 1 >= 0 && j - 1 >= 0) {
//					dp[i][j] = Math.max(dp[i][j], dp[i - j + 1][j-1] + largestSum(arr, j-1, i-1));
//				}
//			}
//		}
//		return dp[len][k];
//	}

//	private static int largestSum(int[] array) {
	private static int largestSum(int[] arr, int start, int end) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = end - start + 1;
//		int[] localSum = new int[arr.length];
		int[] localSum = new int[len];
//		printf("start:end %d:%d", start, end);
		localSum[0] = arr[0 + start];
		int maxSum = localSum[0];
		for (int i = 1; i < len; i++) {
			if (localSum[i - 1] > 0) {
				localSum[i] = localSum[i - 1] + arr[i + start];
			} else {
				localSum[i] = arr[i + start];
			}
			maxSum = Math.max(maxSum, localSum[i]);
		}
		return maxSum;
	}

}
