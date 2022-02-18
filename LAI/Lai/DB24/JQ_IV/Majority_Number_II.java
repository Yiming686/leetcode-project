package Lai.DB24.JQ_IV;

import static Utils.ArrayUtils.printf;

import java.util.ArrayList;

import Utils.ArrayUtils;

/**
 * 
 * Given an integer array of length L, find all numbers that occur more than 1/3
 * * L times if any exist.
 * 
 * Assumptions
 * 
 * The given array is not null Examples
 * 
 * A = {1, 2, 1, 2, 1}, return [1, 2] A = {1, 2, 1, 2, 3, 3, 1}, return [1] A =
 * {1, 2, 2, 3, 1, 3}, return []
 *
 * 
 * 
 */
public class Majority_Number_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = ArrayUtils.buildIntArray(9, 0, 20);
		int [] arr2 = ArrayUtils.buildIntArrayAllDup(5, 4);
		int [] arr = ArrayUtils.mergeIntArrays(arr1, arr2);
		arr = ArrayUtils.shuffle(arr);
		ArrayUtils.printIntArray(arr);
		ArrayList<Integer> nums = ArrayUtils.convertIntArrToArrayList(arr);
		System.out.println(""+majorityNumber(nums));

	}

	public static int majorityNumber(ArrayList<Integer> nums) {
		int candidate1 = 0, candidate2 = 0;
		int count1, count2;
		count1 = count2 = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (candidate1 == nums.get(i)) {
				count1++;
			} else if (candidate2 == nums.get(i)) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = nums.get(i);
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = nums.get(i);
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
			printf("candidate1:count1:candidate2:count2 %d:%d %d:%d \n", candidate1,count1, candidate2,count2 );
		}
		count1 = count2 = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == candidate1) {
				count1++;
			} else if (nums.get(i) == candidate2) {
				count2++;
			}
		}
		return count1 > count2 ? candidate1 : candidate2;
	}

}
