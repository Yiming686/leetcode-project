package Lintcode.Array;

/**

Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Have you met this question in a real interview? Yes
Example
Given an example [3,2,3,1,2], return 1

Tags Expand 
Greedy Enumeration Array Facebook Uber


Related Problems Expand 
Hard Best Time to Buy and Sell Stock IV 22 %
Medium Maximum Product Subarray 27 %
Medium Best Time to Buy and Sell Stock III 26 %
Hard Maximum Subarray III

 *
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //典型的错误解法，看看错在哪里了，以后加以避免
    public int maxProfit77(int[] prices) {
		if (prices ==null || prices.length < 2 )
			return 0;
    	int len = prices.length;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max - min;
    }

    //TC is O(N) ,SC is O(1)
    public int maxProfit55(int[] prices) {
		if (prices ==null || prices.length < 2 )
			return 0;
    	int len = prices.length;
    	int min = prices[0];
    // 	int max = Integer.MIN_VALUE;//错误初始值，有问题的
        int maxProfit = 0;//正确初始值
        //循环变量有三个
        for (int i = 1; i < len; i++) {
            int temp = prices[i] - min;
            if (temp > maxProfit) {
                maxProfit = temp;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }

    //worked 
    public int maxProfit4(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0) return 0;
        int localMax = 0;
        int globalMax = 0;
        for(int i = 1; i < prices.length; i++){
            int  diff = prices[i] - prices[i-1];
            localMax = Math.max(diff, localMax + diff);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
    //My test,
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0) return 0;
        int localMax = 0;
        int globalMax = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            localMax = Math.max(diff, localMax+diff);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }


}
