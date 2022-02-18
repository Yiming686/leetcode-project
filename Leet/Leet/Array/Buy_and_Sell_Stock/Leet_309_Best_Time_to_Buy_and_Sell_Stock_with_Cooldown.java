package Leet.Array.Buy_and_Sell_Stock;

public class Leet_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit_III_cooldown(int[] prices) {
		//public int maxProfit_III_cooldown_N_1_best(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int prevSell = 0;
		int currBuy = -prices[0];
		int currSell = 0;
		for (int i = 1; i < prices.length; i++) {
			int prevBuy = currBuy;
			currBuy = Math.max(prevBuy, prevSell - prices[i]);//to 1:今天买进，
			prevSell = currSell;
			currSell = Math.max(prevSell, prevBuy + prices[i]);// to 0:今天卖出
		}
		return currSell;//最后一天卖出后的最大值
	}
}
