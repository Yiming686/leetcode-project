package LeetCode.JavaArray;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.

 Hide Tags Dynamic Programming

 */
public class LC_188_Best_Time_To_Buy_And_Sell_Stock_IV {

//	local[i][j]  截止第i天，最后一次交易在第i天，且总共交易了j次的最大利润
//	global[i][j] 截止第i天，且总共交易了j次的最大利润
//	
	public int maxProfit(int k, int[] prices) {
		if (prices ==null || prices.length < 2)
			return 0;
		if (k >= prices.length)
			return maxProfitKGreaterThanLen(prices);

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

	public int maxProfitKGreaterThanLen(int[] prices) {
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
