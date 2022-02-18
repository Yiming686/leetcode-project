package Leet.Array.Buy_and_Sell_Stock;

import java.util.Arrays;

public class Leet_123_Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int maxProfit(int[] prices) {
//	public int maxProfit_at_most_k(int k, int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] currBuy = new int[2 + 1];
		int[] currSell = new int[2 + 1];
		Arrays.fill(currBuy, Integer.MIN_VALUE);
		for (int price : prices) {
			int[] prevBuy = currBuy;
			int[] prevSell = currSell;
			for (int i = 2; i > 0; i--) {
				currBuy[i] = Math.max(prevBuy[i], prevSell[i - 1] - price);
				currSell[i] = Math.max(prevSell[i], prevBuy[i] + price);
			}
		}
		return currSell[2];
	}

	public int maxProfit22(int[] prices) {
		// public int maxProfit_at_most_k(int[] prices) {        
		return maxProfit_at_most_k(2, prices);
	}

	public int maxProfit_at_most_k(int k, int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] currBuy = new int[k + 1];
		int[] currSell = new int[k + 1];
		Arrays.fill(currBuy, Integer.MIN_VALUE);
		for (int price : prices) {
			int[] prevBuy = currBuy;
			int[] prevSell = currSell;
			for (int i = k; i > 0; i--) {
				currBuy[i] = Math.max(prevBuy[i], prevSell[i - 1] - price);
				currSell[i] = Math.max(prevSell[i], prevBuy[i] + price);
			}
		}
		return currSell[k];
	}

}
