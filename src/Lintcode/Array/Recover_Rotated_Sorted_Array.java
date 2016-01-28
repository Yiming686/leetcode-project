package Lintcode.Array;

import java.util.ArrayList;

/**
Recover Rotated Sorted Array Show result 

Given a rotated sorted array, recover it to sorted array in-place.

Have you met this question in a real interview? Yes
Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
In-place, O(1) extra space and O(n) time.

Clarification
What is rotated array?

For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
Tags Expand 
Sorted Array Array


Related Problems Expand 
Medium Sort Colors 32 %
Easy Rotate String

 *
 */
public class Recover_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = ' ';
		System.out.println(""+(ch == ' '));
	}
	
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null) return;
        int size = nums.size();
        if( size == 0 || size == 1) return;
        int k = 0;
        for(int i = 0; i < size - 1; i ++){
            if(nums.get(i) > nums.get(i+1)){
                k = i;
                break;
            }
        }
        if(k == 0) return;
        reverse(nums, 0, k);
        reverse(nums, k+1, size - 1);
        reverse(nums, 0, size - 1);
        return;
    }
    
    void reverse(ArrayList<Integer> nums, int left, int right){
        while(left < right){
            int temp = nums.get(right);
            nums.set(right, nums.get(left));
            nums.set(left, temp);
            left++;
            right--;
        }
    }

}
