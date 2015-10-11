package Lintcode;

import LeetCode.ArrayPrinter;

/*
Medium Longest Increasing Subsequence

26% Accepted
Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)

Clarification
What's the definition of longest increasing subsequence?

    * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.  

    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem

Tags Expand 
Binary Search LintCode Copyright Dynamic Programming
 * 
 */

public class Longest_Common_Subsequence {

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
//	此题目一个是思路要清晰
//	玩的就是两个array，不能搞混了
//	第一个数组绝对不能改动，是原始数字组成的数组
//	第二个数组是动态变化的，每个数字含义是当前对应index的原始数组的里面的数字的目前的最大子序列长度
//	 犯了严重错误：把if(nums[j]<=nums[i]) 写成了 if(lens[j]<=lens[i])
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null) return 0;
        int len = nums.length;
        if(len == 0) return 0;
        int[] lens = new int[len];
        
        int max = 1;
        for(int i = 0; i< len;i++){
            lens[i] = 1;
        }
        ArrayPrinter.printIntegerArray(lens);

        for(int i = 1; i < len;i++){
            for(int j = 0; j< i;j++){
                if(nums[j]<=nums[i]){
                    lens[i] = Math.max(lens[i], lens[j] + 1); 
                    max = Math.max(max,  lens[i]);
                }
                ArrayPrinter.printIntegerArray(lens);
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub]
//		int[] nums = {9,3,6,2,7};
		int[] nums = {3,4,-1,0,6,2,3};
		new Longest_Common_Subsequence().longestIncreasingSubsequence(nums);
	}

}
