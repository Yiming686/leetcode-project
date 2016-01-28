package Lintcode.Array.Partition;

/**
Partition Array by Odd and Even Show result 

Partition an integers array into odd number first and even number second.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]

Challenge
Do it in-place.

Tags Expand 
Two Pointers Array


Related Problems Expand 
Medium Partition Array

 *
 *
 */
public class Partition_Array_by_Odd_and_Even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public void partitionArray(int[] nums) {
        // write your code here;
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            if(nums[left] % 2 == 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }else{
                left++;
            }
        }
    }
}
