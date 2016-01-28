package Lintcode.Array;

import com.sun.org.apache.bcel.internal.generic.StackInstruction;

/**
Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ¡Ý s. If there isn't one, return -1 instead.

Have you met this question in a real interview? Yes
Example
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

Challenge
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

Tags Expand 
Two Pointers Array Facebook


Related Problems Expand 
Medium Subarray Sum Closest 16 %
Easy Subarray Sum

 *
 */
public class Minimum_Size_Subarray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,2,4,3};
		System.out.println(""+minimumSize(arr, 7));
	}
	
	/*
	 * 
Time complexity of method 2 looks more than O(n), but if we take a closer look at the program, 
then we can figure out the time complexity is O(n). We can prove it 
by counting the number of operations performed on every element of arr[] in worst case. 
There are at most 2 operations performed on every element: 
(a) the element is added to the curr_sum 
(b) the element is subtracted from curr_sum. 
So the upper bound on number of operations is 2n which is O(n).

PAYPALISHIRING

	 * */
    public static int minimumSize(int[] nums, int s) {
        // write your code here
        int j = 0, i = 0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s ) {
                sum += nums[j];
                j ++;
            }
            if(sum >=s && ans > j-i){
            		ans = j-i;
//            	ans = Math.min(ans, j - i  );
            		System.out.println("i:j "+ i +" : "+(j-1));
            	
            }
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }

}
