package Lintcode.Array.SubArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
Maximum Subarray II Show result 

Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

Have you met this question in a real interview? Yes
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

Note
The subarray should contain at least one number

Challenge
Can you do it in time complexity O(n) ?

Tags Expand 
Greedy Enumeration Forward-Backward Traversal LintCode Copyright Subarray Array


Related Problems Expand 
Medium Maximum Product Subarray 27 %
Medium Best Time to Buy and Sell Stock III 26 %
Hard Maximum Subarray III

 *
 */
public class Maximum_Subarray_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> stack = new LinkedList<Integer>();
		String str = "sfwef";
		System.out.println(""+str.length());
		System.out.println(""+str.substring(3,3));
		System.out.println(""+str.substring(0,5));
		System.out.println(""+str.substring(4));
		System.out.println(""+str.substring(5));
		System.out.println(""+str.substring(0));
//		System.out.println(""+str.substring(6));

	}

    //worked, easy to understand
    //use the solution to Maximum Subarray Difference
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
         if (len==0) return 0;
    
         int[] leftMax = new int[len];
         int[] leftMin = new int[len];//not used
         int endMax = nums.get(0);
         int endMin = nums.get(0);//not used
         leftMax[0] = endMax;
         leftMin[0] = endMin;//not used
         for (int i=1;i<len;i++){
             //Calculate max subarray.
             endMax = Math.max(nums.get(i), nums.get(i)+endMax);//local max
             leftMax[i] = Math.max(leftMax[i-1],endMax);//global max
    
             //Calculate min subarray.
//             endMin = Math.min(nums.get(i),nums.get(i)+endMin);//local min
//             leftMin[i] = Math.min(leftMin[i-1],endMin);//global min
         }
         int[] rightMin = new int[len];
         int[] rightMax = new int[len];
         endMin = nums.get(len-1);
         endMax = nums.get(len-1);
         rightMin[len-1] = endMin;
         rightMax[len-1] = endMax;
         for (int i=len-2;i>=0;i--){
             endMax = Math.max(nums.get(i),nums.get(i)+endMax);
             rightMax[i] = Math.max(rightMax[i+1],endMax);
//             endMin = Math.min(nums.get(i),nums.get(i)+endMin);
//             rightMin[i] = Math.min(rightMin[i+1],endMin); 
         }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len - 1; i++){
            max = Math.max(max, leftMax[i] + rightMax[i + 1]);
        }
        return max;
    }

}
