package Lintcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
Longest Increasing Subsequence

 Description
 Notes
 Testcase
 Judge
Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Clarification
What's the definition of longest increasing subsequence?

The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

Challenge 
Time complexity O(n^2) or O(nlogn)

Tags 
Binary Search LintCode Copyright Dynamic Programming
Related Problems 

 *
 */
public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int b = 3;
//		int shift = 2;
//		System.out.println(""+(b << shift));
		
		int[] arr = new int[]{2,3,5,6};
		arr = new int[]{4, 2, 4, 5, 3, 7};
		
//		arr = new int[]{5, 4, 1, 2, 3};
		arr = new int[]{1,1,1,1,1,1,1};
		
		System.out.println( "MaxLen: "+ longestIncreasingSubsequence(arr));

//		int val = 1;
//		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
//		val = 2;
//		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
//		val = 3;
////		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
//		val = 4;
////		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
//		val = 5;
////		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
//		val = 7;
//		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
//		val = 9;
//		System.out.println(val + ": "+ firstPositionofTarget(arr, val));
		
	}
	
//  解法一：brutal force solution    
    //worked, Jiuzhang solution, another version, TC is O(N^2), SC is O(N)
    // DP 的四要素：
    // 1.状态: count[i] 截止当前时刻的最长递增序列长度
    // 2.状态变化方程： 当前时刻的最长递增序列长度=前面的最长递增序列长度+1
    // 3.初始条件：第一个时刻为1
    // 4.最终所求：求得遍历所有时刻后的最大值
    
    public static int longestIncreasingSubsequence12(int[] nums) {
        //f[i]每一位表示从开始到元素i的最长递增序列的长度
        //针对当前元素，必须遍历之前所有的元素，才知到
        int [] count = new int[nums.length];//f的定义不清楚，题目做不出
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {//不能有等号
                    // f[i] = (f[i] > f[j] + 1) ? f[i] : f[j] + 1;
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            max = Math.max(max, count[i]);//when to update max
            // if (f[i] > max) {
            //     max = f[i];
            // }
        }
        return max;
    }

//  解法二：binary search solution,
// My solution, very clear, much better than jiuzhang solution
//  TC is O(NlogN)
    public static int longestIncreasingSubsequence21(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
       int[] lisArray = new int[nums.length];
       lisArray[0] = nums[0];
       int maxLen = 1;
       for (int i = 1; i < nums.length; i++) {
           maxLen = findMaxLength(lisArray, nums[i], maxLen);
       }
       return maxLen;
   }
   
   private static int findMaxLength(int[] lisArray, int val, int maxLen){
       if(lisArray == null){
           return -1;
       }
       if(val > lisArray[maxLen-1]){
            lisArray[maxLen] = val;
            return maxLen + 1;
       }
       int left = 0;
       int right = maxLen - 1;
       while(left + 1 < right){
           int mid = left + (right - left)/2;
           if(lisArray[mid] >= val){
               right = mid;
           }else{
               left = mid;
           }
       }
       int index = 0;
       if(val <= lisArray[left]){
           index = left;
       }else{
           index = right;
       }
       lisArray[index] = val;
       return maxLen;
   }
    
    //  解法二：binary search solution,jiuzhang solution, ignore it
//  TC is O(NlogN)
   public static int longestIncreasingSubsequence2(int[] nums) {
       int[] minLast = new int[nums.length + 1];
       minLast[0] = Integer.MIN_VALUE;
       for (int i = 1; i <= nums.length; i++) {
           minLast[i] = Integer.MAX_VALUE;
       }
       
       for (int i = 0; i < nums.length; i++) {
           // find the first number in minLast > nums[i]
           int index = binarySearch(minLast, nums[i]);
           minLast[index] = nums[i];
       }
       
       for (int i = nums.length; i >= 1; i--) {
           if (minLast[i] != Integer.MAX_VALUE) {
               return i;
           }
       }
       
       return 0;
   }
   
   // find the first number > num
   // This shoud be "Search Insert Position" + "First Position of Target"
   // It is "Search Insert Position" but has duplicates
   // It is "First Position of Target" but return index not -1 even when it does not exist in the array
   // 搜寻策略和
   private static int binarySearch(int[] minLast, int num) {
       int start = 0, end = minLast.length - 1;
       while (start + 1 < end) {
           int mid = (end - start) / 2 + start;
           if (minLast[mid] == num) {
               return mid;
           }else if (minLast[mid] < num) {
               start = mid;
           } else {
               end = mid;
           }
       }
       
       if (minLast[start] > num) {
           return start;
       }
       return end;
   }

   // worked,
   private static int firstPositionofTarget(int[] arr, int val){
       if(arr == null){
           return -1;
       }
       int len = arr.length;
       int left = 0;
       int right = len - 1;
       if(val <= arr[0]) return 0;
//       if(val == arr[len-1]) return len-1;
//       if(val > arr[len-1]) return len;
       while(left + 1 < right){
           int mid = left + (right - left)/2;
           if(arr[mid] >= val){
               right = mid;
           }else{
               left = mid;
           }
       }
       if(val <= arr[left]){
           return left;
       }else{
           return right;
       }
       
   }

   
   
   public static int longestIncreasingSubsequence(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
       List<Integer> lisList = new ArrayList<>();
       lisList.add(nums[0]);
       int maxLen = 1;
       for (int i = 1; i < nums.length; i++) {
           // int index = Arrays.binarySearch(lisArray, 0, maxLen - 1, nums[i]);
           // maxLen = (index == maxLen)? maxLen + 1 : maxLen;
           findMaxLength(lisList, nums[i]);
       }
           maxLen = lisList.size();
       return maxLen;
   }
   
   private static void findMaxLength(List<Integer> lisList, int val){
       if(lisList == null){
           return;
       }
       int size = lisList.size();
       if(val > lisList.get(size-1)){
           lisList.add(val);
       }
       int left = 0;
       int right = size - 1;
       while(left <= right){
           int mid = left + (right - left)/2;
           if(lisList.get(mid) >= val){
               right = mid - 1;
           }else{
               left = mid + 1;
           }
       }
       
       // int index = 0;
       // if(val <= lisArray[left]){
       //     index = left;
       // }else{
       //     index = right;
       // }
       lisList.set(left, val);
   }


}
