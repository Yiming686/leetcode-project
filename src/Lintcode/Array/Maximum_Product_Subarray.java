package Lintcode.Array;

import java.util.Arrays;

/**
Maximum Product Subarray

30:00
 Start
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Have you met this question in a real interview? Yes
Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags Expand 
LinkedIn Dynamic Programming Subarray


Related Problems Expand 
Medium Best Time to Buy and Sell Stock 41 %
Medium Maximum Subarray Difference 23 %
Easy Minimum Subarray 37 %
Medium Maximum Subarray II

 *
 */
public class Maximum_Product_Subarray {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {-3, -2, 1, -4};
		int[] arr = {-4, -3, -2};
		System.out.println(""+maxProduct2(arr));
	}
	
	//First Best solution, TC is O(N), SC is O(1)
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prevLocalMax  = nums[0];
        int prevLocaLMin  = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++){
        	int localMax = Math.max(nums[i], Math.max(prevLocaLMin * nums[i], prevLocalMax * nums[i]));
            int localMin = Math.min(nums[i], Math.min(prevLocaLMin * nums[i], prevLocalMax * nums[i]));
            globalMax = Math.max(globalMax, localMax);
            
            prevLocalMax = localMax;
            prevLocaLMin = localMin;
        }
        return globalMax;
    }

	//second Best solution, TC is O(N), SC is O(1)
    public static int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prevLocalMax  = nums[0];
        int prevLocaLMin  = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++){
        	int localMax = nums[i];
        	int localMin = nums[i];
        	if(nums[i] > 0){
        		localMax = Math.max(nums[i], prevLocalMax * nums[i]);
        		localMin = Math.min(nums[i], prevLocaLMin * nums[i]);
        	}else{
        		localMax = Math.max(nums[i], prevLocaLMin * nums[i]);
        		localMin = Math.min(nums[i], prevLocalMax * nums[i]);
        	}
            globalMax = Math.max(globalMax, localMax);
            
            prevLocalMax = localMax;
            prevLocaLMin = localMin;
        }
        return globalMax;
    }

    
    // TC is O(N), SC is O(N)
    public static int maxProduct3(int[] nums) {
        //以当前元素结尾的最大值,不是全局最大值
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];
        
        minArr[0] = maxArr[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxArr[i] = Math.max(nums[i], maxArr[i - 1] * nums[i]);
                minArr[i] = Math.min(nums[i], minArr[i - 1] * nums[i]);
            } else {
                maxArr[i] = Math.max(nums[i], minArr[i - 1] * nums[i]);
                minArr[i] = Math.min(nums[i], maxArr[i - 1] * nums[i]);
            }
            maxProduct = Math.max(maxProduct, maxArr[i]);
        }
        return maxProduct;
    }


}
