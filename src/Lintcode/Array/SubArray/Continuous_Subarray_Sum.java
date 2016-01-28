package Lintcode.Array.SubArray;

import java.util.ArrayList;

/**
Continuous Subarray Sum Show result 

Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Have you met this question in a real interview? Yes
Example
Give [-3, 1, 3, -3, 4], return [1,4].

Tags Expand 
Subarray Array


Related Problems Expand 
Easy Maximum Subarray 37 %

 *
 *
 */
public class Continuous_Subarray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 //Best solution, worked, based on the following method
    public ArrayList<Integer> continuousSubarraySum(int[] nums) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;

        int localMax  = nums[0];
        int globalMax = nums[0];
        
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(localMax < 0){
                localMax = nums[i];
                left = i;
                right = i;
            }else{
                localMax = localMax + nums[i];
                right = i;
            }
            if(globalMax < localMax){
                globalMax = localMax;
                
                maxLeft = left;
                maxRight = right;
            }
        }
        result.add(maxLeft);
        result.add(maxRight);
        return result;
    }


}
