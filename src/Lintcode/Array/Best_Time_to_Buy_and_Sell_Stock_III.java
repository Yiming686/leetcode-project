package Lintcode.Array;

/**
Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Have you met this question in a real interview? Yes
Example
Given an example [4,4,6,1,1,4,2,5], return 6.

Note
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Tags Expand 
Enumeration Forward-Backward Traversal Array


Related Problems Expand 
Hard Best Time to Buy and Sell Stock IV 22 %
Medium Best Time to Buy and Sell Stock III 26 %
Medium Best Time to Buy and Sell Stock II 50 %
Medium Best Time to Buy and Sell Stock 41 %
Medium Maximum Subarray Difference 23 %
Hard Maximum Subarray III 23 %
Medium Maximum Subarray II 23 %
Easy Maximum Subarray


 *
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public int maxProfit44(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            int  diff = prices[i] - prices[i-1];

        }
        return 0;
    }
    
    public int maxProfit5(int[] prices) {
        return maxProfit55(2, prices);
    }
    public int maxProfit55(int k, int[] prices) {
		if (prices ==null || prices.length < 2)
			return 0;
// 		if (k >= prices.length)
// 			return maxProfitKGreaterThanLen(prices);

		int[] local  = new int[k + 1];
		int[] global = new int[k + 1];

		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j > 0; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j]
						+ diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}
		return global[k];
	}
	
	public int maxProfit443(int[] prices) {
        if(prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int leftMin = prices[0];
        int rightMax = prices[prices.length-1];
        int sum = 0;
        //计算左半段最大收益
        for(int i = 1 ; i < prices.length; i++){
            leftMin = Math.min(prices[i], leftMin);
            left[i] = Math.max(prices[i] - leftMin, left[i-1]);
        }
        //计算右半段最大收益
        for(int i = prices.length - 2 ; i >= 0; i--){
            rightMax = Math.max(prices[i], rightMax);
            right[i] = Math.max(rightMax - prices[i], right[i+1]);
        }
        //找出两次交易最大收益组合
        for(int i = 0 ; i < prices.length; i++){
            if((left[i]+right[i])>sum) sum = left[i]+right[i];
        }
        return sum;
    }
	
	

	public int maxProfitKGreaterThanLen(int[] prices) {
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}

		return maxProfit;
	}
	
	
	public int maxProfit(int[] prices) {
	    int k = 2;
        if (prices ==null || prices.length < 2)
			return 0;
    	int len = prices.length;
     
    	if (len < 2 || k <= 0)
    		return 0;
        if (k >= len / 2) {
            int profit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    	int[][] local = new int[len][k + 1];
    	int[][] global = new int[len][k + 1];
    	for (int i = 1; i < len; i++) {
    		int diff = prices[i] - prices[i - 1];
    		for (int j = 1; j <= k; j++) {
    			local[i][j] = Math.max(global[i - 1][j - 1] + diff,
    					local[i - 1][j] + diff);
    			global[i][j] = Math.max(global[i - 1][j], local[i][j]);//只针对i递推
    		}
    	}
    	return global[len - 1][k];
    }  

}
