package LeetCode.JavaArray;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Hide Tags Array Dynamic Programming

 */
public class LC_121_Best_Time_To_Buy_And_Sell_Stock_I {

//	依次遍历，计算当天卖出的最大值local
//	同时，记录过去 local的最大值global
//	最后输出全局最大值global
//	
//	注意local 和 global 的初值和含义
//	local是截止第i天只有一次买入卖出，卖出的话的最大利润，所以要么大于零（涨了，卖），要么等于0（跌了，买卖就在当天）
//	global是从0到i天，只有一次买卖的最大利润。
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int len = prices.length;
        if(len < 2) return 0;
        int local = 0;
        int global = 0;
        for(int i = 1; i< len; i++){
            local = Math.max(local + prices[i] - prices[i-1],0);
            global = Math.max(global, local); 
        }
        return global;
    }
    
//    if the min and max and their index are needed, use this
    public int maxProfit2(int[] prices) {
        if(prices == null) return 0;
        if(prices.length < 2) return 0;

		int min = prices[0];
		int max = prices[0];
        int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
		    if (prices[i] < min) {
				min = prices[i];
			}
			if ((prices[i] - min) > maxProfit) {
				maxProfit = prices[i] - min;
				max = prices[i];
			}

		}
		return maxProfit;
    }
    
//    please print the indices and values of min and max 
    public int maxProfit3(int[] prices) {
        if(prices == null) return 0;
        if(prices.length < 2) return 0;

        int currMin = prices[0];
		int min = prices[0];
		int max = prices[0];
		
		int currMinIndex = 0;
		int minIndex = 0;
		int maxIndex = 0;
		
        int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
		    if (prices[i] < currMin) {
		    	currMin = prices[i];
				currMinIndex = i;
			}
			if ((prices[i] - currMin) > maxProfit) {
				maxProfit = prices[i] - currMin;
				
				maxIndex = i;
				max = prices[i];
				
				minIndex = currMinIndex;
				min  = currMin;
			}

		}
		System.out.printf("minIndex=%s,min=%s,maxIndex=%s,max=%s \n", minIndex, min, maxIndex, max);
		return maxProfit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
