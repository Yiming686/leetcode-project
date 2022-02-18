package Lai.Array.Binary_Search;

import Lai.Midterm_I_II_III.permu;
import Utils.SU;

/**
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ¡Ù nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -¡Þ.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.


 *
 */
public class Leet_162_Find_Peak_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("");
	}

//	Leet_852_Peak_Index_in_a_Mountain_Array The same as Leet_162_Find_Peak_Element
	public static int findPeakElement(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < arr[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
    //     recuresive solution
    public int findPeakElement_rec(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return findPeakElement(arr, left, right);
    }
    private int findPeakElement(int[] arr, int left, int right) {
        if(left == right) return left;
        int mid = left + (right - left)/2;           
        if(arr[mid] < arr[mid+1]){
            left = mid + 1;
            return findPeakElement(arr, left, right);
        }else{
            right = mid;
            return findPeakElement(arr, left, right);
        }
    }
	

}
