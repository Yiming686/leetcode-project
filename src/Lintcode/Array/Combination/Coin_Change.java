package Lintcode.Array.Combination;

import java.util.ArrayList;
import java.util.Arrays;

/**
322. Coin Change My Submissions Question
Total Accepted: 2634 Total Submissions: 10265 Difficulty: Medium
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Dynamic Programming

 *
 */
public class Coin_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+Integer.MAX_VALUE);
		int[] coins = {1, 2, 5};
		int amount = 11;
		Long start = System.nanoTime();
		Long start1 = System.currentTimeMillis();
		System.out.println(""+coinChange(coins, amount));
		Long end = System.nanoTime();
		Long end1 = System.currentTimeMillis();
		System.out.println("ns:"+(end-start));
		System.out.println("ms:"+(end1-start1));
	}

    //     Bottom up
    public static int coinChange(int[] coins, int target) {
        if(target < 0){
            return -1;
        }
        if(target == 0 ){
            return 0;
        }
        int[] dp = new int[target + 1];  //
        Arrays.fill(dp, target + 1);  
        dp[0] = 0;  
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                if ( j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[target] == target + 1 ? -1 : dp[target];
    }

	//worked, but Time Limit Exceeded 
    public static int coinChangeBacktracking(int[] coins, int amount) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        coinChange(result, list, sum, coins, amount);
        if(result.size() == 0) return -1;
        return result.get(0).size();
         
     }
     
     private static void coinChange(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int sum, int[] coins, int amount){
//    	 System.out.println(""+list);
//    	 System.out.println(""+sum);
         if(sum == amount){
             if(result.size() == 0){
                 result.add(new ArrayList<Integer>(list));    
             }else if(list.size() < result.get(0).size() ){
                 result.set(0, new ArrayList<Integer>(list));    
             }
             System.out.println("resut:sum"+result +" : "+sum);
             return;
         }
         if(sum > amount) return;
         for(int i = 0; i < coins.length; i++){
             list.add(coins[i]);
             coinChange(result, list, sum + coins[i], coins, amount);           
             list.remove(list.size() - 1);
         }
     }
     
     

}
