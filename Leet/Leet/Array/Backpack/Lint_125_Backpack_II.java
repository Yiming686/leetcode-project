package Leet.Array.Backpack;

import Utils.SU;

/**
Description
ÖÐÎÄ
English
There are n items and a backpack with size m. Given array A representing the size of each item and array V representing the value of each item.

What's the maximum value can you put into the backpack?

A[i], V[i], n, m are all integers.
You can not split an item.
The sum size of the items you want to put into backpack can not exceed m.
Each item can only be picked up once
Have you met this question in a real interview?  
Example
Example 1:

Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
Output: 9
Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9 
Example 2:

Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
Output: 10
Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10 
Challenge
O(nm) memory is acceptable, can you do it in O(m) memory?

 *
 */
public class Lint_125_Backpack_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("322. Coin Change\n" + 
				"");
	}
    public static int backPackII(int target, int[] sizes, int[] values) {
    // public int backPackII_me(int m, int[] A, int[] V) {        
        if(sizes == null || sizes.length == 0){
            return 0;
        }
        int[] dp = new int[target + 1];
        // dp[0] = 1;
        for(int i = 0; i < sizes.length; i++){
            for(int j = target; j >= 0; j--){
            // for(int j = 0; j <= target; j++){    
                if(j - sizes[i] >= 0 ){
                    dp[j] = Math.max(dp[j], dp[j-sizes[i]] + values[i]);
                }
            }
        }
        return dp[target];
    }

}
