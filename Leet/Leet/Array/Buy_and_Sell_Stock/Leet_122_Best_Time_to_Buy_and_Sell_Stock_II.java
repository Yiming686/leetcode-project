package Leet.Array.Buy_and_Sell_Stock;

import static Utils.ArrayUtils.printCharArrayNoIndex;

public class Leet_122_Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			currBuy = Math.max(prevBuy,   prevSell - prices[i]);//to 1:���������
			currSell = Math.max(prevSell, prevBuy  + prices[i]);// to 0:��������
		}
		return currSell;//���һ������������ֵ
	}

}
