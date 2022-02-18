package Leet.Array.Backpack;

import java.util.Arrays;

public class Lint_800_Backpack_IX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// public double backpackIX(int n, int[] prices, double[] probability) {
	public static double backpackIX(int amount, int[] appFees, double[] probs) {
		// write your code here
		if (amount <= 0 || appFees == null || appFees.length == 0) {
			return 0;
		}
		int sumOfFees = 0;
		for (int fee : appFees) {
			sumOfFees += fee;
		}
		if (amount >= sumOfFees) {
			double minProb = 1;//+=��ʼ��Ϊ0��*=��ʼ��Ϊ1
			for (double prob : probs) {
				minProb *= (1 - prob);
			}
			return minProb;
		}
//		Ԫ����ѧУ;�����1-m��ѧУ;��������ϵ�û���յ�offer�ĸ��ʣ������ô�����������Ե���Сֵ��
//		�����ϣ�û���յ�offer�ĸ���p0�������յ�һ��offer��p1��we have: p0+p1=1
//		���ÿһ��ѧУ�����Եõ������ĳɹ�����p���Ͷ�����ʧ�ܸ���1-p; ���ѡ����һ��ѧУ����ô��������ϣ�
		double[] dp = new double[amount + 1];//�������j, û���յ�offer����Сֵ
		Arrays.fill(dp, 1);//���û���յ�offer�ĸ���Ϊ1��dp[0]��ֵ�ɵ��ƹ�ʽ������
		for (int i = 0; i < appFees.length; i++) {
			for (int j = amount; j >= 0; j--) {
				if (j - appFees[i] >= 0) {
					// dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
					dp[j] = Math.min(dp[j], dp[j - appFees[i]] * (1 - probs[i]));
				}
			}
		}
		return 1 - dp[amount];
	}

	public static int backPackII(int m, int[] A, int[] V) {
		// write your code here
		if (m <= 0 || A == null || A.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int size : A) {
			sum += size;
		}
		if (m >= sum) {
			sum = 0;
			for (int value : V) {
				sum += value;
			}
			return sum;
		}
		int[] dp = new int[m + 1];//������С���������ܹ��õ������Value
		for (int i = 0; i < A.length; i++) {
			for (int j = m; j >= 0; j--) {
				if (j - A[i] >= 0) {
					dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
				}
			}
		}
		return dp[m];
	}
}
