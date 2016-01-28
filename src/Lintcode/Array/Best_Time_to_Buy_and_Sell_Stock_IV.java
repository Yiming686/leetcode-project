package Lintcode.Array;

/**
Best Time to Buy and Sell Stock IV

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Have you met this question in a real interview? Yes
Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

Note
You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Challenge
O(nk) time.

Tags Expand 
Dynamic Programming


Related Problems Expand 
Medium Best Time to Buy and Sell Stock III 26 %
Medium Best Time to Buy and Sell Stock II 50 %
Medium Best Time to Buy and Sell Stock


 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Jiuzhang solution, almost best
    public int maxProfit9(int k, int[] prices) {
        // write your code here
        if (k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int n = prices.length;
        int[][] mustsell = new int[n + 1][n + 1];   // mustSell[i][j] ��ʾǰi�죬�������j�ν��ף���i�����sell��������
        int[][] globalbest = new int[n + 1][n + 1];  // globalbest[i][j] ��ʾǰi�죬�������j�ν��ף���i����Բ�sell��������
        
        mustsell[0][0] = globalbest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustsell[0][i] = globalbest[0][i] = 0;
        }
        
        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[(i - 1)][j - 1] + gainorlose,
                                            mustsell[(i - 1)][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[(i - 1)][j], mustsell[i ][j]);
            }
        }
        return globalbest[(n - 1)][k];
    }
 
     
//	local[i][j]  ��ֹ��i�죬���һ�ν����ڵ�i�죬���ܹ�������j�ε��������
//	global[i][j] ��ֹ��i�죬���ܹ�������j�ε��������
// 
//	local[j]  ��ֹ��i�죬���һ�ν����ڵ�i�죬���ܹ�������j�ε��������
//	global[j] ��ֹ��i�죬���ܹ�������j�ε��������
	public int maxProfit(int k, int[] prices) {
		if (prices ==null || prices.length < 2)
			return 0;
		if (k >= prices.length/2)
			return maxProfitKGreaterThanLen(prices);

		int[] local  = new int[k + 1];
		int[] global = new int[k + 1];

		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j > 0; j--) {//һλ����һ��Ҫ�������
// 			for (int j = 1; j <= k; j++) {//һλ����һ��Ҫ�������
				local[j] = Math.max(global[j - 1] + diff, local[j]+ diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}
		return global[k];
	}

	public int maxProfitKGreaterThanLen(int[] prices) {
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}

		return maxProfit;
	}

    //From internet, worked, BEST standard answer
    public int maxProfit88(int k, int[] prices) {
        if (prices ==null || prices.length < 2)
			return 0;
    	int len = prices.length;
     
    	if (len < 2 || k <= 0)
    		return 0;
        //2 line below worked
        // if (k >= len) {
        if (k >= len / 2) {
            int profit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
     
    	int[][] local = new int[len][k + 1];
    	int[][] global = new int[len][k + 1];
     
    	for (int i = 1; i < len; i++) {
    		int diff = prices[i] - prices[i - 1];
    		for (int j = 1; j <= k; j++) {
    		    //2 line below worked
    			local[i][j] = Math.max(global[i - 1][j - 1] + diff,
    					local[i - 1][j] + diff);
    // 			local[i][j] = Math.max(local[i - 1][j] + Math.max(diff, 0),
    // 					local[i-1][j-1] + diff);
    			global[i][j] = Math.max(global[i - 1][j], local[i][j]);//ֻ���i����
    		}
    	}
    	return global[len - 1][k];
    }  

/*
 * 
��local[i][j]��ʾ�����i��ʱ��������j�ν��׵ľֲ����Ž⣻
��global[i][j]��ʾ�����i��ʱ��������j�ε�ȫ�����Ž⡣
���Ƕ��ߵĹ�ϵ���£�����diff = prices[i] �C prices[i �C 1]����

local[i][j] = max(global[i �C 1][j �C 1] + max(diff, 0), local[i �C 1][j] + diff) 
global[i][j] = max(global[i �C 1][j], local[i][j])
���е�local[i �C 1][j] + diff����Ϊ�˱����i�콻�׺͵�i-1�콻�׺ϲ���һ�ν��׶���һ�ν������档

 ˼·

���ǽ���i���Ѿ�ִ��j�ʽ��׵����������Ϊȫ�ֱ���global������i��������ɵ�j�ʽ��׵����������Ϊ�ֲ�����local��

����global��Ҳ��������Ҫ֪����i���Ѿ�ִ��j�ʽ��׵�������棬���Ի��ڵ�i-1���Ѿ�ִ��j�ʽ��׵��������͵�i��������ɵ�j�ʽ��׵�������棬��global[i] = max(global[i-1], local[i])��

����local��Ҳ��������Ҫ֪����i��������ɵ�j�ʽ��׵����ֲ����棬���Ի��ڵ�i-1��������ɵ�j-1�ʽ��׵����ȫ������global[i-1][j-1]���ϵ��콻�׵Ĳ�ֵ�����е�i-1��������ɵ�j�ʽ��׵����ֲ�����local[i-1][j]���ϵ��콻�׵Ĳ�ֵ��
Ҫע����ǣ���i-1��������ɵ�j-1�ʽ��������������ǰ���׵Ĳ�ֵȡ0��ʵ������������нϴ�ģ���Ϊ���ǻ���һ�����ɽ��׵���أ�����������Ļ���ȫ���Ե�������������ʧ������i-1��������ɵ�j�ʽ�������������Ƶ���i��������ɵ�j�ʽ���ʱ���൱�ڵ�i���Ѿ�Ҫ���ŵ�i-1�콻�ף�ʹ�õ�i-1��������ɵĵ�j�ʽ��׺͵�i��������ɵĵ�j�ʽ�����ͬһ�����ס�
��ʽ�ǣ�local[i][j] = max(global[i-1][j-1]+diff, local[i-1][j]+diff)
 
ע��

����k > prices.length/2����������ǿ�����II�Ľⷨ����ʡ�ռ䡣��Ϊ����������������������ô����n�콻�ף��ܹ�������Ч����Ľ��״�����С�ڵ���n/2�ģ�ֻ�в�ͬ���������ܲ�����ۡ����ڴ���n/2���ǲ��ֽ��ף��ض��ǵ�������û���κ�����ģ����۽��׶��ٴζ���һ���ġ��������k > prices.length / 2�����൱�����޴ν��ס�
����ĵڶ�ά��ʼ��������k+1����Ϊ����ҪԤ�����0�ʽ��׵����棬��0��
 
���� Follow Up

Q���������ÿ��ʱ��㣬����������1�Σ�������ÿ��ʱ��㣬����������֮ǰ���е���������Ʊ������μ��㣿
A����Ϊ���Գ������ж��֮ǰ��Ĺ�Ʊ�����ǿ���һֱ���벢���У�ֱ����һ��ȫ����ߵ�ʱ��һ������ȥ������������һֱ���룬ֱ��ʣ��۸��е�ȫ����ߵ�ʱ����ȥ���Դ����ơ������ṩ��������˼·��

�ȱ���һ���ҳ����з�ֵ��������Щ��ֵ�����ǵ��������������ӽ�һ��Heap�������ٴ�ͷ����һ�飬���ó��Ѷ�����ֱ���Ѷ�����֮ǰ�Ĳ�ֵ���ۼ���������������Ѷ���������ٿ���һ����Ч�Ѷ�����Ч�Ѷ���ָ�±��ڵ�ǰ�±�֮��ģ���ʱ�临�Ӷ�O(NlogN)��
���ҳ�ȫ����ߵ㣬Ȼ������������֮ǰ��һ�����ֵԪ�أ������Ͱ������ת�����˻�ˮ���⡣ʱ�临�Ӷ�O(N)��
Q: ���ÿ�ν�������������ô�죿
A: ������ʵ���Ͼ��ǽ��������ۣ����ߵ�ͬ���������ۣ������Ǹ�����������Ӧ������������ˡ�

 
 */
	
}
