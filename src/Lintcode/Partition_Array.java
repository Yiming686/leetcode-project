package Lintcode;
/*
Medium Partition Array

24% Accepted
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Have you met this question in a real interview? Yes
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Note
You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Challenge
Can you partition the array in-place and in O(n)?

Tags Expand 
Two Pointers Sort Array


Related Problems Expand 
Easy Partition Array by Odd and Even 32 %
Medium Interleaving Positive and Negative Numbers 18 %
Easy Partition List 31 %

 */

public class Partition_Array {

	public class Solution {
		/** 
	     *@param nums: The integer array you should partition
	     *@param k: As description
	     *return: The index after partition
	     */
//		[考察点] 边界条件
//		i<=j 不是 i<j, i,j相等时,还要判断
	    public int partitionArray(int[] nums, int k) {
		    //write your code here
		    if(nums== null || nums.length == 0) return 0;
		    
		    int i = 0;
		    int j = nums.length-1;
		    while(i<=j){
		        while(i<= j && nums[i]<k)  i++;
		        while(i<= j && nums[j]>=k) j--;
		        if(i<j){
	                int temp = nums[i];
	                nums[i] = nums[j];
	                nums[j] = temp;
	                i++;
	                j--;
		        }
		    }
	        return i;	    
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
