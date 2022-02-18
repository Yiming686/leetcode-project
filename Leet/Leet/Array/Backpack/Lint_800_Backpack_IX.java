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
			double minProb = 1;//+=初始化为0，*=初始化为1
			for (double prob : probs) {
				minProb *= (1 - prob);
			}
			return minProb;
		}
//		元素是学校;组合是1-m个学校;属性是组合的没有收到offer的概率，这个怎么求？特征是属性的最小值。
//		针对组合，没有收到offer的概率p0和至少收到一个offer的p1，we have: p0+p1=1
//		针对每一所学校，可以得到独立的成功概率p，和独立的失败概率1-p; 如果选择了一组学校，那么针对这个组合，
		double[] dp = new double[amount + 1];//给定金额j, 没有收到offer的最小值
		Arrays.fill(dp, 1);//标记没有收到offer的概率为1，dp[0]的值由递推公式来决定
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
		int[] dp = new int[m + 1];//给定大小布袋，其能够得到的最大Value
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
