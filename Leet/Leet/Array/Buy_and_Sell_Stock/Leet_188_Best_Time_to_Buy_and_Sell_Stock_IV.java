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
			currBuy = Math.max(prevBuy,   prevSell - prices[i]);//to 1:���������
			currSell = Math.max(prevSell, prevBuy  + prices[i]);// to 0:��������
		}
		return currSell;//���һ������������ֵ
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
				currBuy[j] = Math.max(  prevBuy[j], prevSell[j - 1] - prices[i]);//to 1:���������
				currSell[j] = Math.max(prevSell[j],  prevBuy[j]     + prices[i]);// to 0:��������
			}
		}
		return currSell[k];
	}

//	��������k�ν���,���Եõ����������
//	 localMax[j]�����෢����j�ν��ף������һ�ν���   �����ڵ��죬���Եõ������������ʵ�������������ڵ��죬������ɣ����һ�ν�����ɡ�
//	globalMax[j]�����෢����j�ν��ף������һ�ν��ײ��ط����ڵ��죬���Եõ����������
	public static int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		if (2 * k >= prices.length) {
			return maxProfit(prices);
		}
		int[] localMax = new int[k + 1]; //[][][] //0,1,2 �ν���
		int[] globalMax = new int[k + 1];//[][][]
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - prices[i - 1];//profit
			for (int j = k; j > 0; j--) {
//                         ǰһ��j�ν��׺�����local����+��������  ǰһ��j-1�ν��׺�����ȫ������ + ��������
//				                          k<=j         j        k<=j-1                  j
				localMax[j] = Math.max(localMax[j] + profit, globalMax[j - 1] + Math.max(profit, 0));
				globalMax[j] = Math.max(globalMax[j], localMax[j]);
			}
		}
		return globalMax[k];//ȫ�ֽ������Σ�maxprofit
	}

//	���޽��״���,���Եõ����������
//	 localMax�����һ�ν���   �����ڵ��죬���Եõ������������ʵ�������������ڵ��죬������ɣ����һ�ν�����ɡ�
//	globalMax�����һ�ν��ײ��ط����ڵ��죬���Եõ����������
	public static int maxProfit44(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int localProfit = 0;
		int globalProfit = 0;
		int len = prices.length;
		for (int i = 1; i < len; i++) {
			int profit = prices[i] - prices[i - 1];
//			                 ǰһ������local����+��������  ǰһ������ȫ������+��������
			localProfit = Math.max(localProfit + profit, globalProfit + profit); //���һ�η���������
			globalProfit = Math.max(globalProfit, localProfit);
		}
		return globalProfit;
	}

}
