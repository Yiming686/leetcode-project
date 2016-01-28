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
        int[][] mustsell = new int[n + 1][n + 1];   // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n + 1][n + 1];  // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
        
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
 
     
//	local[i][j]  截止第i天，最后一次交易在第i天，且总共交易了j次的最大利润
//	global[i][j] 截止第i天，且总共交易了j次的最大利润
// 
//	local[j]  截止第i天，最后一次交易在第i天，且总共交易了j次的最大利润
//	global[j] 截止第i天，且总共交易了j次的最大利润
	public int maxProfit(int k, int[] prices) {
		if (prices ==null || prices.length < 2)
			return 0;
		if (k >= prices.length/2)
			return maxProfitKGreaterThanLen(prices);

		int[] local  = new int[k + 1];
		int[] global = new int[k + 1];

		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j > 0; j--) {//一位数组一般要降序遍历
// 			for (int j = 1; j <= k; j++) {//一位数组一般要降序遍历
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
    			global[i][j] = Math.max(global[i - 1][j], local[i][j]);//只针对i递推
    		}
    	}
    	return global[len - 1][k];
    }  

/*
 * 
用local[i][j]表示到达第i天时，最多进行j次交易的局部最优解；
用global[i][j]表示到达第i天时，最多进行j次的全局最优解。
它们二者的关系如下（其中diff = prices[i] – prices[i – 1]）：

local[i][j] = max(global[i – 1][j – 1] + max(diff, 0), local[i – 1][j] + diff) 
global[i][j] = max(global[i – 1][j], local[i][j])
其中的local[i – 1][j] + diff就是为了避免第i天交易和第i-1天交易合并成一次交易而少一次交易收益。

 思路

我们将第i天已经执行j笔交易的最大收益作为全局变量global，将第i天正好完成第j笔交易的最大收益作为局部变量local。

对于global，也就是我们要知道第i天已经执行j笔交易的最大收益，可以基于第i-1天已经执行j笔交易的最大收益和第i天正好完成第j笔交易的最大收益，即global[i] = max(global[i-1], local[i])。

对于local，也就是我们要知道第i天正好完成第j笔交易的最大局部收益，可以基于第i-1天正好完成第j-1笔交易的最大全局收益global[i-1][j-1]加上当天交易的差值，还有第i-1天正好完成第j笔交易的最大局部收益local[i-1][j]加上当天交易的差值。
要注意的是，第i-1天正好完成第j-1笔交易这种情况，当前交易的差值取0和实际昨天今天差价中较大的，因为我们还有一次自由交易的余地，所以如果亏的话完全可以当天买卖避免损失。但第i-1天正好完成第j笔交易这种情况来推导第i天正好完成第j笔交易时，相当于第i天已经要连着第i-1天交易，使得第i-1天正好完成的第j笔交易和第i天正好完成的第j笔交易是同一个交易。
算式是：local[i][j] = max(global[i-1][j-1]+diff, local[i-1][j]+diff)
 
注意

对于k > prices.length/2的情况，我们可以用II的解法来节省空间。因为按照题意必须先买后卖，那么对于n天交易，能够产生有效收益的交易次数是小于等于n/2的，只有不同天买卖才能产生差价。对于大于n/2的那部分交易，必定是当天买卖没有任何收益的，无论交易多少次都是一样的。所以如果k > prices.length / 2，就相当于无限次交易。
数组的第二维初始化长度是k+1，因为我们要预留完成0笔交易的收益，是0。
 
后续 Follow Up

Q：如果对于每个时间点，都可以买入1次，而对于每个时间点，都可以卖出之前持有的任意多个股票，该如何计算？
A：因为可以持续持有多个之前买的股票，我们可以一直买入并持有，直到第一个全局最高点时再一起卖出去。接着我们再一直买入，直到剩余价格中的全局最高点时卖出去，以此类推。这里提供两个解题思路：

先遍历一遍找出所有峰值，并将这些峰值和他们的坐标打包起来，扔进一个Heap。这样再从头遍历一遍，先拿出堆顶，把直到堆顶坐标之前的差值都累加起来，过了这个堆顶的坐标后再看下一个有效堆顶（有效堆顶是指下标在当前下标之后的）。时间复杂度O(NlogN)。
先找出全局最高点，然后在整个数组之前加一个最大值元素，这样就把这道题转换成了积水问题。时间复杂度O(N)。
Q: 如果每次交易有手续费怎么办？
A: 手续费实际上就是降低了卖价（或者等同于提高了买价），我们根据手续费相应调整利润就行了。

 
 */
	
}
