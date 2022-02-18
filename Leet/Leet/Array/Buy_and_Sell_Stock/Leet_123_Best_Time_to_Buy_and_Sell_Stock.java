package Leet.Array.Buy_and_Sell_Stock;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;

import Utils.SU;

public class Leet_123_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SU.ll("122. Best Time to Buy and Sell Stock II\n" + "");
//		int[] arr = { 2, 6, 4, 12 };
//		int arr = {7,1,5,3,6,4};
		int[] arr = { 8, 2, 1, 10 };
		print(arr, true);
		System.out.println("" + maxProfit(arr));
	}
//	  I:  一次交易: 仅仅区别在: currBuy = Math.max(         - price, prevBuy);
//	 II: 不限次交易:仅仅区别在: currBuy = Math.max(prevSell - price, prevBuy);
//	III:   2次交易:
//	 IV:顶多K次交易:
//	通用解法：和transaction fee，仅仅区别在：currBuy = Math.max(prevSell - price, prevBuy); 是否有 -fee
//	通用解法：和cool down，      仅仅区别在: currBuy = Math.max(prevSell - price, prevBuy); 保证prevSell不是昨天的。

//	每一天可以抵达的状态：1 or 0， currBuy to 1, currSell to 0
//	 prevBuy: 如果使得昨天的状态为1，可以得到的最大利润。
//	prevSell: 如果使得昨天的状态为0，可以得到的最大利润。
//	 currBuy: 如果使得今天的状态为1，可以得到的最大利润。其可选的两个值为：prevBuy,  或者 prevSell - prices[i];
//	currSell: 如果使得今天的状态为0，可以得到的最大利润。其可选的两个值为：prevSell, 或者 prevBuy + prices[i];

//	总是先要处理currBuy，有了buy才可能有后面的sell，形成一个tx; 
//	处理第一个currBuy, 必须保证prevBuy为数值的最小值。
//	处理第一个currSell, 此时已经有currBuy了选项了，必然不是数值的最小值，prevSell初始化为0，也即是初始balance为0；
//	states:

//		public static int maxProfit(int[] arr) {
	public static int maxProfit_min_max(int[] arr) {
		//at least two int
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int maxProfit = 0;
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			maxProfit = Math.max(maxProfit, arr[i] - min);
		}
		return maxProfit;
	}

	public static int maxProfit(int[] prices) {
//  public int maxProfit_N_1_gene(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int currBuy = -prices[0];
		int currSell = 0;
		printf("currBuy:currSell %d:%d", currBuy, currSell);
//		for (int price : prices) {
		for (int i = 1; i < prices.length; i++) {
			int prevBuy = currBuy;
			int prevSell = currSell;
			currBuy = Math.max(prevBuy, -prices[i]);//to 1:今天买进，
			currSell = Math.max(prevSell, prevBuy + prices[i]);// to 0:今天卖出
//			currBuy = Math.max(currBuy,            -prices[i]);//to 1:今天买进，
//			currSell = Math.max(currSell, currBuy + prices[i]);// to 0:今天卖出
			printf("currBuy:currSell %d:%d", currBuy, currSell);
		}
		return currSell;//最后一天卖出后的最大值
	}
//			[  2,  6,  4, 12]
//			   0,  1,  2,  3 
//			currBuy:currSell -2147483648:0
//			currBuy:currSell -2:0
//			currBuy:currSell -2:4
//			currBuy:currSell -2:4
//			currBuy:currSell -2:10
//			10

//	public int maxProfit(int[] prices) {
	public int maxProfit_N_1_gene(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int prevBuy = 0;
		int prevSell = 0;
		int currBuy = Integer.MIN_VALUE;
		int currSell = 0;
		for (int price : prices) {
			prevBuy = currBuy;
			prevSell = currSell;
			currBuy = Math.max(-price, prevBuy);// happen when buy
			currSell = Math.max(prevBuy + price, prevSell);//
		}
		return currSell;//最后一天卖出后的最大值
	}

	public static int maxProfit_dp(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int[][] dp = new int[n][2];

		for (int i = 0; i < n; i++) {
			if (i - 1 == -1) {
				dp[i][0] = 0;
				// 解释：
				//   dp[i][0] 
				// = max(dp[-1][0], dp[-1][1] + prices[i])
				// = max(0, -infinity + prices[i]) = 0
				dp[i][1] = -prices[i];
				//解释：
				//   dp[i][1] 
				// = max(dp[-1][1], dp[-1][0] - prices[i])
				// = max(-infinity, 0 - prices[i]) 
				// = -prices[i]
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			//第i天，手里没有股票时，可以获得的利益最大值：第i-1天，没有股票的最大值;或者，第i-1天，有股票，今天卖出后的最大值，
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
			//第i天，手里有股票时，可以获得的利益最大值：第i-1天，有股票的最大值;或者 今天买入
		}
		return dp[n - 1][0];//最后一天了, 没有股票时时，利益最大值

	}

}
