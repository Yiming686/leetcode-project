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
//	  I:  һ�ν���: ����������: currBuy = Math.max(         - price, prevBuy);
//	 II: ���޴ν���:����������: currBuy = Math.max(prevSell - price, prevBuy);
//	III:   2�ν���:
//	 IV:����K�ν���:
//	ͨ�ýⷨ����transaction fee�����������ڣ�currBuy = Math.max(prevSell - price, prevBuy); �Ƿ��� -fee
//	ͨ�ýⷨ����cool down��      ����������: currBuy = Math.max(prevSell - price, prevBuy); ��֤prevSell��������ġ�

//	ÿһ����Եִ��״̬��1 or 0�� currBuy to 1, currSell to 0
//	 prevBuy: ���ʹ�������״̬Ϊ1�����Եõ����������
//	prevSell: ���ʹ�������״̬Ϊ0�����Եõ����������
//	 currBuy: ���ʹ�ý����״̬Ϊ1�����Եõ�������������ѡ������ֵΪ��prevBuy,  ���� prevSell - prices[i];
//	currSell: ���ʹ�ý����״̬Ϊ0�����Եõ�������������ѡ������ֵΪ��prevSell, ���� prevBuy + prices[i];

//	������Ҫ����currBuy������buy�ſ����к����sell���γ�һ��tx; 
//	�����һ��currBuy, ���뱣֤prevBuyΪ��ֵ����Сֵ��
//	�����һ��currSell, ��ʱ�Ѿ���currBuy��ѡ���ˣ���Ȼ������ֵ����Сֵ��prevSell��ʼ��Ϊ0��Ҳ���ǳ�ʼbalanceΪ0��
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
			currBuy = Math.max(prevBuy, -prices[i]);//to 1:���������
			currSell = Math.max(prevSell, prevBuy + prices[i]);// to 0:��������
//			currBuy = Math.max(currBuy,            -prices[i]);//to 1:���������
//			currSell = Math.max(currSell, currBuy + prices[i]);// to 0:��������
			printf("currBuy:currSell %d:%d", currBuy, currSell);
		}
		return currSell;//���һ������������ֵ
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
		return currSell;//���һ������������ֵ
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
				// ���ͣ�
				//   dp[i][0] 
				// = max(dp[-1][0], dp[-1][1] + prices[i])
				// = max(0, -infinity + prices[i]) = 0
				dp[i][1] = -prices[i];
				//���ͣ�
				//   dp[i][1] 
				// = max(dp[-1][1], dp[-1][0] - prices[i])
				// = max(-infinity, 0 - prices[i]) 
				// = -prices[i]
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			//��i�죬����û�й�Ʊʱ�����Ի�õ��������ֵ����i-1�죬û�й�Ʊ�����ֵ;���ߣ���i-1�죬�й�Ʊ����������������ֵ��
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
			//��i�죬�����й�Ʊʱ�����Ի�õ��������ֵ����i-1�죬�й�Ʊ�����ֵ;���� ��������
		}
		return dp[n - 1][0];//���һ����, û�й�Ʊʱʱ���������ֵ

	}

}
