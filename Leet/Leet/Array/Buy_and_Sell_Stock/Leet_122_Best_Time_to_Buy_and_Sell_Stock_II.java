package Leet.Array.Buy_and_Sell_Stock;

import static Utils.ArrayUtils.printCharArrayNoIndex;

public class Leet_122_Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
    public static int maxProfit(int[] prices) {
//public int maxProfit_N_1_gene(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 10;
		}
		int currBuy = -prices[0];
		int currSell = 0;
		for (int i = 1; i < prices.length; i++) {
			int prevBuy = currBuy;
			int prevSell = currSell;
			currBuy = Math.max(prevBuy,   prevSell - prices[i]);//to 1:今天买进，
			currSell = Math.max(prevSell, prevBuy  + prices[i]);// to 0:今天卖出
		}
		return currSell;//最后一天卖出后的最大值
	}

}
