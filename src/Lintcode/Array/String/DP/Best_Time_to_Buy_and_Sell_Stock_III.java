package Lintcode.Array.String.DP;

import java.util.Arrays;

/**

Best Time to Buy and Sell Stock III 

 Description
 Notes
 Testcase
 Judge
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Notice

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Have you met this question in a real interview? Yes
Example
Given an example [4,4,6,1,1,4,2,5], return 6.

Tags 
Related Problems 
Hard Best Time to Buy and Sell Stock IV 25 %
Medium Best Time to Buy and Sell Stock III 27 %
Medium Best Time to Buy and Sell Stock II 49 %
Medium Best Time to Buy and Sell Stock 41 %
Medium Maximum Subarray Difference 24 %
Hard Maximum Subarray III 24 %
Medium Maximum Subarray II 26 %
Easy Maximum Subarray

 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,6,1,1,4,2,5,1};
//		int[] arr = {9,6,1,1};
		System.out.println("======================");
		maxProfit(arr);
		System.out.println("======================");
		maxProfitOnlyTwoTransactions(arr);
		System.out.println("======================");
		maxProfitLeftRight(arr);
	}

//	worked, best, keep in mind, general solution
    public static int maxProfit(int[] prices) {  
        if(prices==null || prices.length==0)  
            return 0;  
        int[] localMax = new int[3];  
        int[] globalMax = new int[3];  
        for(int i=1; i<prices.length;i++){  
        	System.out.println("   i: "+i);
            int profit = prices[i]-prices[i-1];  
            for(int j=2;j>=1;j--){  
                localMax[j] = Math.max(globalMax[j-1]+Math.max(profit, 0), localMax[j]+profit);  
                globalMax[j] = Math.max(globalMax[j], localMax[j]); 
             	System.out.println(" local: "+Arrays.toString(localMax));
             	System.out.println("global: "+Arrays.toString(globalMax));
            }  
        }  
        return globalMax[2];  
    }
    
//	worked, for k transactions
    public static int maxProfit02(int[] prices) {  
        if(prices==null || prices.length==0)  
            return 0;  
        int k = 2;
        int[] localMax = new int[k+1];  
        int[] globalMax = new int[k+1];  
        for(int i=1; i<prices.length;i++){  
            int profit = prices[i]-prices[i-1];  
            for(int j=k;j>=1;j--){  
                localMax[j] = Math.max(globalMax[j-1]+Math.max(profit, 0), localMax[j]+profit);  
                globalMax[j] = Math.max(globalMax[j], localMax[j]);  
            }  
        }  
        return globalMax[k];  
    }
	
//  worked, global is correct, but local is not
 public static int maxProfit11(int[] prices) {  
     if(prices==null || prices.length==0)  
         return 0;  
     int[] local = new int[3];  
     int[] global = new int[3];  
     for(int i=1; i<prices.length;i++){  
    	 System.out.println("   i: "+i);
         int profit = prices[i]-prices[i-1];
         // if(profit > 0){
         	local[2] = Math.max(global[1]+Math.max(profit, 0), local[2]+profit);  
         	global[2] = Math.max(global[2], local[2]);  
         	System.out.println(" local: "+Arrays.toString(local));
         	System.out.println("global: "+Arrays.toString(global));
         	local[1] = Math.max(global[0]+Math.max(profit, 0), local[1]+profit);  
         	global[1] = Math.max(global[1], local[1]);
         	System.out.println(" local: "+Arrays.toString(local));
         	System.out.println("global: "+Arrays.toString(global));
         // }
     }  
     return global[2];  
 }
//	worked, no arrays, only variables
 public static int maxProfitNoArrays(int[] prices) {  
     if(prices==null || prices.length==0)  
         return 0;  
     int localMax1 = 0;
     int localMax2 = 0;
     int globalMax1 = 0;
     int globalMax2 = 0;
     for(int i=1; i<prices.length;i++){  
         int profit = prices[i]-prices[i-1];  
         localMax2 = Math.max(globalMax1+Math.max(profit, 0), localMax2+profit);  
         globalMax2 = Math.max(globalMax2, localMax2);  

         localMax1 = Math.max(Math.max(profit, 0), localMax1+profit);  
         globalMax1 = Math.max(globalMax1, localMax1);  

     }  
     return globalMax2;  
 }

//wrong solution: if(profit > 0){
public static int maxProfitOnlyTwoTransactions(int[] prices) {  
	  if(prices==null || prices.length==0)  
	      return 0;  
	  int[] local = new int[3];  
	  int[] global = new int[3];  
	  for(int i=1; i<prices.length;i++){  
	 	 System.out.println("   i: "+i);

	      int profit = prices[i]-prices[i-1];
	      		if(profit > 0){
	      			local[2] += profit;
	      			local[2] = Math.max(local[2], global[1]+profit);  
	      		}
				global[2] = Math.max(global[2], local[2]);  
				System.out.println(" local: "+Arrays.toString(local));
				System.out.println("global: "+Arrays.toString(global));
				
				local[1] = Math.max(global[0]+profit, local[1]+profit);  
				global[1] = Math.max(global[1], local[1]); 
				System.out.println(" local: "+Arrays.toString(local));
				System.out.println("global: "+Arrays.toString(global));

	  }  
	  return global[2];  
	}

 // worked, another DPsolution，利用之前的计算结果
 	public static int maxProfitLeftRight(int[] prices) {
         if(prices.length == 0) return 0;
         int[] left = new int[prices.length];
         int[] right = new int[prices.length];
         int leftMin = prices[0];
         int rightMax = prices[prices.length-1];
         int sum = 0;
         //计算左半段最大收益
         for(int i = 1 ; i < prices.length; i++){
             leftMin = Math.min(prices[i], leftMin);
             left[i] = Math.max(prices[i] - leftMin, left[i-1]);
             // int j = i;
             // i = prices.length - 1 - j;
             // rightMax = Math.max(prices[i], rightMax);
             // right[i] = Math.max(rightMax - prices[i], right[i+1]);
             // i = j;
         }
         //计算右半段最大收益
         for(int i = prices.length - 2 ; i >= 0; i--){
             rightMax = Math.max(prices[i], rightMax);
             right[i] = Math.max(rightMax - prices[i], right[i+1]);
         }
         
         //找出两次交易最大收益组合
         for(int i = 0 ; i < prices.length; i++){
             if((left[i]+right[i])>sum) sum = left[i]+right[i];
         }
      	System.out.println(" local: "+Arrays.toString(left));
      	System.out.println("global: "+Arrays.toString(right));
        
         return sum;
     }

 	
}
