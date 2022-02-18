package Lintcode.Array.String.DP;

/**
Best Time to Buy and Sell Stock IV 

 Description
 Notes
 Testcase
 Judge
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Notice

You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Have you met this question in a real interview? Yes
Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

Challenge 
O(nk) time.

Tags 
Dynamic Programming
Related Problems 
Medium Best Time to Buy and Sell Stock III 27 %
Medium Best Time to Buy and Sell Stock II 49 %
Medium Best Time to Buy and Sell Stock
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,6,1,1,4,2,5,1};
//		int[] arr = {9,6,1,1};
		System.out.println("======================");
		maxProfit(5, arr);
		System.out.println("======================");
	}
	
    //  best solution, keep in mind
    public static int maxProfit(int k, int[] prices) {
    
        if(prices==null || prices.length==0 || k < 1)  
            return 0;  
		if (k >= prices.length/2){
		    int maxProfit = 0;
		    for (int i = 1; i < prices.length; i++) {
		        maxProfit += Math.max(prices[i] - prices[i - 1], 0);
            }
            return maxProfit;
		}
        int[] local = new int[k+1]; //截止这一天最多交易2次但最后一次交易发生在今天的最大利润
        int[] global = new int[k+1];//截止这一天最多交易2次的最大利润 
        for(int i=1; i<prices.length;i++){  
            int diff = prices[i]-prices[i-1];  
            for(int j=k;j>=1;j--){  
                // local[j] = Math.max(global[j-1]+diff, local[j]+diff);
                local[j] = Math.max(global[j-1]+Math.max(diff,0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);  
            }  
        }  
        return global[k];  
    }	

}
