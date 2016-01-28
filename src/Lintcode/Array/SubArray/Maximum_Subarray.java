package Lintcode.Array.SubArray;

/**
Maximum Subarray Show result 

Given an array of integers, find a contiguous subarray which has the largest sum.

Have you met this question in a real interview? Yes
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Note
The subarray should contain at least one number.

Challenge
Can you do it in time complexity O(n)?

Tags Expand 
Greedy Enumeration LintCode Copyright LinkedIn Subarray Array


Related Problems Expand 
Medium Continuous Subarray Sum 21 %
Medium Best Time to Buy and Sell Stock III 26 %
Hard Maximum Subarray III 23 %

 *
 */
public class Maximum_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Best solution, worked
    public int maxSubArray6(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0) return 0;
        int localMax  = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            // sum += nums.get(i);
            localMax = Math.max(nums[i], localMax + nums[i]);
            // min = Math.min(min, Math.min(min + nums.get(i), nums.get(i)));
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;

    }
    
    //worked
    public int maxSubArray(int[] nums) {
        // int global = Integer.MIN_VALUE;
        int global = nums[0];
        int local = 0;
        for(int i = 0; i < nums.length; i++){
            if(local < 0){
                local = 0;
            }
            local += nums[i];
            global = Math.max(global, local);
        }
        return global;
    }



}
