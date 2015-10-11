package LeetCode.JavaArray;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Greedy

 */
public class LC_122_Best_Time_To_Buy_And_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int len = prices.length;
        if(len < 2 ) return 0;
        
        int maxProfit = 0;
        for(int i = 1; i < len; i ++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
    
    public int maxProfit2(int[] prices) {
        if(prices == null) return 0;
        int len = prices.length;
        if(len < 2 ) return 0;
        
        int maxProfit = 0;
        for(int i = 1; i < len; i ++){
            maxProfit = Math.max(maxProfit, maxProfit + prices[i] - prices[i-1]);
        }
        return maxProfit;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
