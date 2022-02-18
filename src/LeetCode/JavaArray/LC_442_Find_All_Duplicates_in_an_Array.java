package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

[]
数值在1到n里面，复杂度都为O(1)
Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]


 *
 */
public class LC_442_Find_All_Duplicates_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[]{4,3,2,7,8,2,3,1};
		System.out.println(""+findDuplicates(nums));
		System.out.println(""+Arrays.toString(nums));
	}
	
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length < 2){
			return result;
		} 
//		int len = nums.length;
		for(int i = 0; i < nums.length; i++){
			int val = nums[i];
			int pos = (val < 0 ? -val : val) - 1;
			if(nums[pos] < 0){
				result.add(pos+1);
//				 nums[pos] = -nums[pos];
			}
			 else{
			nums[pos] = -nums[pos];
			 }
		}
		return result;
	}

}





