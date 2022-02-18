package Lintcode.BinarySearch;

import sun.security.util.Length;

/**
 * 
Find Peak Element 

 Description
 Notes
 Testcase
 Judge
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

 Notice

The array may contains multiple peeks, find any of them.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

Challenge 
Time complexity O(logN)

Tags 
Binary Search LintCode Copyright Array Google
Related Problems 
Medium Maximum Number in Mountain Sequence 45 %
Hard Find Peak Element II

 *
 */
public class Find_Peak_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 1, 3, 4, 5, 7, 6};
		System.out.println(""+findPeak(arr));
	}
	
    public static int findPeak(int[] nums) {
    	int len = nums.length;
    	int start = 0;
    	int end = len - 1;
    	while(start + 1 < end){
    		int mid = start + (end - start)/2;
    		if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]){
    			return mid;
    		}else if(nums[mid] > nums[mid - 1]){
    			start = mid + 1;
    		}else{
    			end = mid - 1;
    		}
    	}
    	return nums[start] > nums[end] ? start : end;
    }

	
}
