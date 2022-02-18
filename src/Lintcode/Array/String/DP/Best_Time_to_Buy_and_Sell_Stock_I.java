package Lintcode.Array.String.DP;

import java.util.Arrays;
import java.util.Objects;

/**

Best Time to Buy and Sell Stock 

 Description
 Notes
 Testcase
 Judge
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Have you met this question in a real interview? Yes
Example
Given array [3,2,3,1,2], return 1.

Tags 
Related Problems 
Hard Best Time to Buy and Sell Stock IV 25 %
Medium Maximum Product Subarray 30 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III

 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 1, 5, 3, 6, 4};
//		int[] arr = {9,6,1,1};
		System.out.println("======================");
		maxProfit(arr);

	}
	// worked, best solution, at most one transaction   
    public static int maxProfit00(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        int len =  prices.length;
        for(int i = 1; i < len; i++){
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);//核心逻辑，计算最大利润
            minPrice = Math.min(minPrice, prices[i]);//更新循环变量，更新最小价格
        }
        return maxProfit;
    }
    
    // worked, general solution
    public static int maxProfit(int[] prices) {
        Objects.requireNonNull(prices);
        int localMax = 0;//都大于零
        int globalMax = 0;//都大于零
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[i-1];
            localMax = Math.max(Math.max(profit, 0), localMax+profit);//因为都大于零，所以Math.max(diff, 0)
//            localMax = Math.max(profit, localMax+profit);//因为都大于零，所以Math.max(diff, 0)
            globalMax = Math.max(globalMax, localMax);
         	System.out.println(" local: "+localMax + "  global: "+globalMax);
        }
        return globalMax;
        
    }

}
