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
	我们可以改变一下求解的思路，求k个鸡蛋在m步内可以测出多少层：
	假设: dp[k][m] 表示k个鸡蛋在m步内最多能测出的层数。
	那么，问题可以转化为当 k <= K 时，找一个最小的m，使得dp[k][m] <= N。

	我们来考虑下求解dp[k][m]的策略：
	假设我们有k个鸡蛋第m步时，在第X层扔鸡蛋。这时候，会有两种结果，鸡蛋碎了，或者没碎。
	如果鸡蛋没碎，我们接下来会在更高的楼层扔，最多能确定 X + dp[k][m-1] 层的结果；
	如果鸡蛋碎了，我们接下来会在更低的楼层扔，最多能确定 Y + dp[k-1][m-1] 层的结果 (假设在第X层上还有Y层)。
	因此，这次扔鸡蛋，我们最多能测出 dp[k-1][m-1] (摔碎时能确定的层数) + dp[k][m-1] (没摔碎时能确定的层数) + 1 (本层) 层的结果。
	另外，我们知道一个鸡蛋一次只能测一层，没有鸡蛋一层都不能测出来。
	因此我们可以列出完整的递推式:
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
			if (f(mid, K, N) < N) {//重点理解此处方法的含义
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	//重点理解此处方法的含义：楼层x, 鸡蛋k个，最大楼层N
//	居然推导出了使用k个鸡蛋，移动x次所能测的最大楼层数的通项公式，推导过程可以参见这个帖子，通项公式如下：
//     f(k,x) = x(x-1)..(x-k)/k! + ... + x(x-1)(x-2)/3! + x(x-1)/2! + x
	public static int f(int x, int K, int N) {
		int sum = 0; 
		int count = 1;
		for (int i = 1; i <= K; ++i) {//尝试K次
			count *= x - i + 1;
			count /= i;
			sum += count;//楼层数依次递增,如果超过或者抵达N，结束
			if (sum >= N) {//count必须立即止步
				break;
			}
		}
		return sum;
	}

}
