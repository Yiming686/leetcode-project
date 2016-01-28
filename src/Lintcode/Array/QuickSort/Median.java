package Lintcode.Array.QuickSort;


/**
Median Show result 

Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Have you met this question in a real interview? Yes
Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5

Challenge
O(n) time.

Tags Expand 
LintCode Copyright Quick Sort Array


Related Problems Expand 
Hard Data Stream Median 24 %
Hard Median of two Sorted Arrays *
 */
public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {4,5,1,2,3};
		int[] arr = {4};
		System.out.println(""+median(arr));
	}

	
	
	//worked, My solution, the same as Kth Smallest Element (Kth Largest Element)
    public static int median(int[] nums) {
        // write your code here
        int len = nums.length;
        int k = (len%2==0) ? len/2 : (len+1)/2;
            
        return median(nums, 0, nums.length - 1, k);
    }
    
    private static int median(int[] nums, int left, int right, int k) {
        int index = partition(nums, left, right);
        if(index + 1 == k) 
            return nums[index];
        else if(index + 1 > k)
            return median(nums, left, index -1, k);
        else
            return median(nums, index + 1, right, k);
    }
    
    private static int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int index = left;
        for(int i = left; i < right; i++){
            if(nums[i]<=pivot){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;

//                nums[index] ^= nums[i];
//                nums[i] ^= nums[index];
//                nums[index] ^= nums[i];
                index++;
            }
        }
        int temp = nums[right];
        nums[right] = nums[index];
        nums[index] = temp;
//        nums[index] ^= nums[right];
//        nums[right] ^= nums[index];
//        nums[index] ^= nums[right];
        return index;
    }

}
