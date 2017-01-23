package Lintcode.Array.Sum;

import Lintcode.Matrix.Matrix;

/**
k Sum Show result 

45:00
 Start
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.

Tags Expand 
LintCode Copyright Dynamic Programming


Related Problems Expand 
Medium k Sum II

 *
 */
public class k_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,2,3,4};
		int[] arr = {1,4,3,2, 0,5};
//		int[] arr = {1,2,3,4,5};
		System.out.println(""+kSum(arr, 2, 5));
	}
	
    public static int kSum(int A[], int k, int target) {
        int n = A.length;
         int[][][] f = new int[n + 1][k + 1][target + 1];//前n个数里面找k个之和为target的个数
         for (int i = 0; i < n + 1; i++) {
             f[i][0][0] = 1;
         }
         System.out.println(""+Matrix.fromMatrixToString(f[6]));
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= k && j <= i ; j++) {
                 for (int t = 1; t <= target; t++) {
                     // f[i][j][t] = 0;
                     if (t >= A[i - 1]) {
                         f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];//算上第i元素
                     }
                     f[i][j][t] += f[i - 1][j][t];//不算上第i元素
//                     System.out.println(""+Matrix.fromMatrixToString(f[1]));
                 } // for t
             } // for j
         } // for i
         return f[n][k][target];
     }

}
