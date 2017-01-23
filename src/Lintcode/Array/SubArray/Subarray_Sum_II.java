package Lintcode.Array.SubArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
Subarray Sum Show result 

15:00
 Start
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Have you met this question in a real interview? Yes
 Notice

There is at least one subarray that it's sum equals to zero.

Example
Tags
Related Problems
Example
Tags
Related Problems
 Notes
Medium Submatrix Sum 21 %
Medium Minimum Size Subarray Sum 24 %
Medium Subarray Sum Closest 15 %


 Notes
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3]

 *
 */
public class Subarray_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{-3, 1, 2, -3, 4};
		System.out.println(""+subarraySum(arr, -3));
		System.out.println(""+subarraySum2(arr, -3));
	}

    //暴力法，O(n^2) 
    public static ArrayList<Integer> subarraySum(int[] nums, int target) {
       if(nums == null || nums.length == 0) return null;
       ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum+=nums[j];
                if(sum == target){
                   ans.add(i);
                   ans.add(j);
//                   return ans;
                }
            }
        }
        return ans;
    }

    //转换思路，仅仅O(n), 拿下
    public static ArrayList<Integer> subarraySum77(int[] nums) {
        return subarraySum2(nums, 0);
    }
   private static ArrayList<Integer> subarraySum2(int[] nums, int target) {
       // write your code here
       if(nums == null || nums.length == 0) return null;
       int len = nums.length;
       ArrayList<Integer> ans = new ArrayList<Integer>();
       //记录各种sum 和 index
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       map.put(0, -1);
      
       int sum = 0;
       for (int i = 0; i < len; i++) {
           sum += nums[i];
           // if (map.containsKey(target - sum)) {
           if (map.containsKey(sum - target)) {
               ans.add(map.get(sum - target) + 1);
               ans.add(i);
//               return ans;
           }
           map.put(sum, i);
       }
       return ans;
   }

    
}
