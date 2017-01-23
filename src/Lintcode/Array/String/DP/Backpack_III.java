package Lintcode.Array.String.DP;

/**
Backpack III

Problem 重复选择+最大价值

Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m. What's the maximum value can you put into the backpack?

Notice
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 15.

 *
 */
public class Backpack_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	可重复选择，所以对布袋大小的遍历可以从小到大
    public static int backPackIII(int[] A, int[] V, int m) {
        int[] dp = new int[m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i]){
                	dp[j] = Math.max(dp[j], dp[j-A[i]]+V[i]);
                } 
            }
        }
        return dp[m];
    }
    
}
