package Lintcode.Array.String.DP;

/**
Best Time to Buy and Sell Stock II 

 Description
 Notes
 Testcase
 Judge
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Have you met this question in a real interview? Yes
Example
Given an example [2,1,2,0,1], return 2

Tags 
Greedy Enumeration Array
Related Problems 
Hard Best Time to Buy and Sell Stock IV 25 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III

 *
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 1, 5, 3, 6, 4};
//		int[] arr = {9,6,1,1};
		System.out.println("======================");
		maxProfit00(arr);

	}

    //worked
    public static int maxProfit00(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            int  profit = prices[i] - prices[i-1];
            if(profit > 0){
                max += profit;
            }
        }
        return max;
    }
    
    // worked, general solution
    public static int maxProfit02(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[i-1];
            // max += diff > 0 ? diff : 0;
            max += Math.max(profit, 0);
        }
        return max;
        
    }

}
