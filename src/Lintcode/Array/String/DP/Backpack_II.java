package Lintcode.Array.String.DP;

/**

Backpack II

Problem 单次选择+最大价值

Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

Have you met this question in a real interview? Yes
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

Note
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Challenge
O(n x m) memory is acceptable, can you do it in O(m) memory?

Tags Expand 
LintCode Copyright Dynamic Programming Backpack


Related Problems Expand 
Medium Backpack

 *
 *
 */
public class Backpack_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	首先定义状�?? K(i,w) 为前 i 个物品放入size�? w 的背包中�?获得的最大价值，则相应的状�?�转移方程为�? K(i,w)=max{K(i�?1,w),K(i�?1,w−w​i​�??)+v​i​�?�}
	//First Best Solution, worked,TC is O(n x m), SC is O(m)
    public int backPackII(int m, int[] A,  int V[]) {  
        if (A.length==0) return 0;  
        int len = A.length;  
        int[] maxVal = new int[m+1];  
        maxVal[0] = 0;  
        for (int i=1;i<=len;i++)  
            // for (int j=0;j<=m;j++){  
            for (int j=m;j>=0;j--){  
                //如果袋子够大，可以装得下A[i-1], 则装入并计算其最大�??
                //求最大�?�就是要比较：不装入的最大�?�和装入后的值中的大�?
	            if (j - A[i-1] >= 0) {
	                maxVal[j] = Math.max(maxVal[j], maxVal[j-A[i-1]]+V[i-1]);
	            }
            }  
        return maxVal[m];  
    }  
	//Second Best Solution,worked, TC is O(n x m), SC is O(m)
    public int backPackII2(int m, int[] A, int V[]) {
        // write your code here
	    int[][] res = new int[2][m+1];
	    res[0][0] = 0;
	    for (int i=1; i<=A.length; i++) {
	        for (int j=0; j<=m; j++) {
                if (j - A[i-1] >= 0)
	                res[i%2][j] = Math.max(res[(i-1)%2][j], res[(i-1)%2][j-A[i-1]]+V[i-1]);
	            else
	                res[i%2][j] = res[(i-1)%2][j];
	        }
	    }
	    return res[A.length%2][m];
	}

	//Third Solution, worked,TC is O(n x m), SC is O(n x m)
    public int backPackII3(int m, int[] A, int V[]) {
        // write your code here
	    int[][] res = new int[A.length+1][m+1];
	    res[0][0] = 0;
	    for (int i=1; i<=A.length; i++) {
	        for (int j=0; j<=m; j++) {
	            if (j - A[i-1] >= 0)
	                res[i][j] = Math.max(res[i-1][j], res[i-1][j-A[i-1]]+V[i-1]);
	            else
	                res[i][j] = res[i-1][j];
	        }
	    }
	    return res[A.length][m];
	}



}
