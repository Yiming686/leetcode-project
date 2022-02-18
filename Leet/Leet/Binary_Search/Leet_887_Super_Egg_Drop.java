package Leet.Binary_Search;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;

public class Leet_887_Super_Egg_Drop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int K = 6;
		int N = 200;
		System.out.println("" + superEggDrop(K, N));
	}
	/*
	���ǿ��Ըı�һ������˼·����k��������m���ڿ��Բ�����ٲ㣺
	����: dp[k][m] ��ʾk��������m��������ܲ���Ĳ�����
	��ô���������ת��Ϊ�� k <= K ʱ����һ����С��m��ʹ��dp[k][m] <= N��

	���������������dp[k][m]�Ĳ��ԣ�
	����������k��������m��ʱ���ڵ�X���Ӽ�������ʱ�򣬻������ֽ�����������ˣ�����û�顣
	�������û�飬���ǽ��������ڸ��ߵ�¥���ӣ������ȷ�� X + dp[k][m-1] ��Ľ����
	����������ˣ����ǽ��������ڸ��͵�¥���ӣ������ȷ�� Y + dp[k-1][m-1] ��Ľ�� (�����ڵ�X���ϻ���Y��)��
	��ˣ�����Ӽ�������������ܲ�� dp[k-1][m-1] (ˤ��ʱ��ȷ���Ĳ���) + dp[k][m-1] (ûˤ��ʱ��ȷ���Ĳ���) + 1 (����) ��Ľ����
	���⣬����֪��һ������һ��ֻ�ܲ�һ�㣬û�м���һ�㶼���ܲ������
	������ǿ����г������ĵ���ʽ:
	dp[k][0] = 0
	dp[1][m] = m (m > 0)
	dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1 (k > 0, m>0)

	*/    
//	     DP solution: Time: O(K * N), Space: O(K * N)
//		public int superEggDrop(int K, int N) {
		public int superEggDrop_DP(int K, int N) {
	        int[][] dp = new int[N+2][K+2];
	        // memset(dp, 0, sizeof(dp));
	        // dp[0][0] = 0;
	        for (int m = 1; m <= N; m++) {
	            dp[m][0] = 0;
	            for (int k = 1; k <= K; k++) {
	                dp[m][k] = dp[m-1][k] + dp[m-1][k-1] + 1;
	                if (dp[m][k] >= N) {
	                    return m;
	                }
	            }
	        }
	        return N;
	    }

//	Time Complexity: O(K * \log N), Space Complexity: O(1)
	public static int superEggDrop(int K, int N) {
		int low = 1, high = N;
		while (low < high) {
			int mid = low + (high - low) / 2;
			printf("low:mid:high :: %d:%d:%d",low, mid, high);
			if (f(mid, K, N) < N) {//�ص����˴������ĺ���
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	//�ص����˴������ĺ��壺¥��x, ����k�������¥��N
//	��Ȼ�Ƶ�����ʹ��k���������ƶ�x�����ܲ�����¥������ͨ�ʽ���Ƶ����̿��Բμ�������ӣ�ͨ�ʽ���£�
//     f(k,x) = x(x-1)..(x-k)/k! + ... + x(x-1)(x-2)/3! + x(x-1)/2! + x
	public static int f(int x, int K, int N) {
		int sum = 0; 
		int count = 1;
		for (int i = 1; i <= K; ++i) {//����K��
			count *= x - i + 1;
			count /= i;
			sum += count;//¥�������ε���,����������ߵִ�N������
			if (sum >= N) {//count��������ֹ��
				break;
			}
		}
		return sum;
	}

}
