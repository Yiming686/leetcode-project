package Leet.Array.Buy_and_Sell_Stock;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;

public class Leet_714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 8, 2, 1, 10 };
		int[] arr = {1,3,2,8,4,9};
		int fee = 2;
		print(arr, true);
		System.out.println("" + maxProfit(arr, fee));

	}
//	currBuy:currSell -2147483648:0
//	currBuy:currSell -3:0
//	currBuy:currSell -3:0
//	currBuy:currSell -3:0
//	currBuy:currSell -3:5
//	currBuy:currSell -1:5
//	currBuy:currSell -1:8
//	8
//	通用解法：和transaction fee， 仅仅区别在是否有 -fee
//	通用解法：和cool down， 仅仅区别在是否有 -fee
	
    public static int maxProfit(int[] prices, int fee) {
//public int maxProfit_N_1_gene(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int currBuy = -prices[0];
		int currSell = 0;
		printf("currBuy:currSell %d:%d", currBuy, currSell);
		for (int i = 1; i < prices.length; i++) {
			int prevBuy = currBuy;
			int prevSell = currSell;
			currBuy = Math.max(prevBuy,   prevSell - prices[i]);//to 1:今天买进，
			currSell = Math.max(prevSell, prevBuy  + prices[i]-fee);// to 0:今天卖出
			printf("currBuy:currSell %d:%d", currBuy, currSell);
		}
		return currSell;//最后一天卖出后的最大值
	}

    
    public static int maxProfit33(int[] prices, int fee) {
        int prevBuy = 0;
		int prevSell = 0;
		int currBuy = Integer.MIN_VALUE;
		int currSell = 0;
		printf("currBuy:currSell %d:%d", currBuy, currSell);
		for (int price : prices) {
			prevBuy = currBuy;
			prevSell = currSell;
			currBuy = Math.max(prevSell - price, prevBuy);//to 1:今天买进，
			currSell = Math.max(prevBuy + price - fee, prevSell);// to 0:今天卖出
			printf("currBuy:currSell %d:%d", currBuy, currSell);
		}
		return currSell;//最后一天卖出后的最大值
    }


}
