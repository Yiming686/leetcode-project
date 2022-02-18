package Leet.Array.Buy_and_Sell_Stock;

import java.util.Arrays;

public class Leet_188_Best_Time_to_Buy_and_Sell_Stock_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit(int[] prices) {
//  public int maxProfit_N_1_gene(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int currBuy = Integer.MIN_VALUE;
		int currSell = 0;
//		for (int price : prices) {
		for (int i = 0; i < prices.length; i++) {
			int prevBuy = currBuy;
			int prevSell = currSell;
			currBuy = Math.max(prevBuy,   prevSell - prices[i]);//to 1:今天买进，
			currSell = Math.max(prevSell, prevBuy  + prices[i]);// to 0:今天卖出
		}
		return currSell;//最后一天卖出后的最大值
	}

	public static int maxProfit(int[] prices, int k) {
		//  public int maxProfit_N_1_gene(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		if (2 * k > prices.length) {
			return maxProfit(prices);
		}
		int[] currBuy = new int[k + 1];
		Arrays.fill(currBuy, -prices[0]);
		int[] currSell = new int[k + 1];
//				for (int price : prices) {
		for (int i = 1; i < prices.length; i++) {
			int[] prevBuy = currBuy;
			int[] prevSell = currSell;
			for (int j = k; j >= 1; j--) {
				currBuy[j] = Math.max(  prevBuy[j], prevSell[j - 1] - prices[i]);//to 1:今天买进，
				currSell[j] = Math.max(prevSell[j],  prevBuy[j]     + prices[i]);// to 0:今天卖出
			}
		}
		return currSell[k];
	}

//	顶多有限k次交易,可以得到的最大利润
//	 localMax[j]：顶多发生了j次交易，且最后一次交易   发生在当天，可以得到的最大利润。其实就是卖出必须在当天，卖出完成，标记一次交易完成。
//	globalMax[j]：顶多发生了j次交易，且最后一次交易不必发生在当天，可以得到的最大利润。
	public static int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		if (2 * k >= prices.length) {
			return maxProfit(prices);
		}
		int[] localMax = new int[k + 1]; //[][][] //0,1,2 次交易
		int[] globalMax = new int[k + 1];//[][][]
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - prices[i - 1];//profit
			for (int j = k; j > 0; j--) {
//                         前一天j次交易后的最大local利润+今日利润  前一天j-1次交易后的最大全局利润 + 今日利润
//				                          k<=j         j        k<=j-1                  j
				localMax[j] = Math.max(localMax[j] + profit, globalMax[j - 1] + Math.max(profit, 0));
				globalMax[j] = Math.max(globalMax[j], localMax[j]);
			}
		}
		return globalMax[k];//全局交易三次，maxprofit
	}

//	不限交易次数,可以得到的最大利润
//	 localMax：最后一次交易   发生在当天，可以得到的最大利润。其实就是卖出必须在当天，卖出完成，标记一次交易完成。
//	globalMax：最后一次交易不必发生在当天，可以得到的最大利润。
	public static int maxProfit44(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int localProfit = 0;
		int globalProfit = 0;
		int len = prices.length;
		for (int i = 1; i < len; i++) {
			int profit = prices[i] - prices[i - 1];
//			                 前一天的最大local利润+今日利润  前一天的最大全局利润+今日利润
			localProfit = Math.max(localProfit + profit, globalProfit + profit); //最后一次发生在哪里
			globalProfit = Math.max(globalProfit, localProfit);
		}
		return globalProfit;
	}

}
