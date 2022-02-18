package Lintcode.Array.String.DP;

import Utils.MatrixUtils;

/**
Climbing Stairs 

 Description
 Notes
 Testcase
 Judge
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Have you met this question in a real interview? Yes
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3

Tags 
Dynamic Programming
Related Problems 
Naive Fibonacci 24 %
Medium House Robber

 *
 */
public class Climbing_Stairs_I_Fibonacci_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+climbStairs01(3));
		System.out.println(""+climbStairs01(5));
		System.out.println(""+climbStairs01(6));
		System.out.println(""+climbStairs01(7));
		System.out.println(""+climbStairs01(8));
		System.out.println(""+climbStairs01(9));
		System.out.println(""+climbStairs01(10));
	}
	
//	n : 0 1 2 3 4 5  6  7  8  9 10 
//	Fi: 1 1 2 3 5 8 13 21 34 55 89 
    //SC is O(N)
    public static int climbStairs00(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i = 2; i <= n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }

	//  TC is O(logN) time
	 public static int climbStairs01(int n) {
	     int[][] matrix = {{1, 1},
	                     {1, 0}};
	     int[][] result = power(matrix, n-1);
	     return result[0][0] + result[0][1];
	 }
	 
	//  worked,   TC is O(logN) time
    public static int climbStairs(int n) {
        int[][] matrix = {{1, 1},
                          {1, 0}};
        int[][] result = power(matrix, n-1);
        return result[0][0] + result[0][1];
    }
    
    private static int[][] power(int[][] matrix, int power){
        int[][] result = new int[][]{{1, 0},
                                     {0, 1}};
        if(power == 0){
            return result;
        }
        if(power == 1){
            return matrix;
        }
       if(power == 2){
           result[0][0] = matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[1][0];
           result[1][0] = matrix[1][0] * matrix[0][0] + matrix[1][1] * matrix[1][0];
           result[0][1] = matrix[0][0] * matrix[0][1] + matrix[0][1] * matrix[1][1];
           result[1][1] = matrix[1][0] * matrix[0][1] + matrix[1][1] * matrix[1][1];
           return result;
        }

        if(power % 2 == 0){
            result = power(power(matrix, power / 2), 2);
            return result;
        }else{
             matrix = power(power(matrix, power / 2), 2);
	         result[0][0] = matrix[0][0]  + matrix[0][1];
	         result[1][0] = matrix[1][0]  + matrix[1][1];
	         result[0][1] = matrix[0][0];
	         result[1][1] = matrix[1][0];
            return result;
        }
    }
    
}
