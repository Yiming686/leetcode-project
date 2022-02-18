package Lai.DP_II;

import java.util.Arrays;

import Utils.ArrayUtils;

/**
 * 
 * Given an array A of non-negative integers, you are initially positioned at
 * index 0 of the array. A[i] means the maximum jump distance from index i (you
 * can only jump towards the end of the array). Determine the minimum number of
 * jumps you need to reach the end of array. If you can not reach the end of the
 * array, return -1.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 1. Examples
 * 
 * {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the
 * end of array)
 * 
 * {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in
 * this case.
 *
 *
 * 
 * 
 */
public class Array_Hopper_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2,1,0,3,1};
		int[] arr = {0,1};
//		int[] arr = ArrayUtils.generateIntArrayWithDup(12, 0, 6);
		System.out.println(""+minJump(arr));

//		System.out.println(""+minJump(arr));
	}

//	what I learned from DP
//	
	public static int minJump_A(int[] arr) {
		int len = arr.length;
		if (len == 1) {
			return 0;
		}
		int[] min = new int[len];// min steps to i from 0
		Arrays.fill(min, -1);
		min[0] = 0;
//		System.out.println(""+Arrays.toString(min));
		for (int i = 1; i < len; i++) {//dest
			for (int j = 0; j < i; j++) {//orig
				if (arr[j] + j >= i && min[j] != -1) {
					if (min[i] == -1) {
						min[i] = min[j] + 1;
					} else {
						min[i] = Math.min(min[i], min[j] + 1);
					}
				}
			}
		}
		ArrayUtils.printIntArray(min);
		return min[len - 1];
	}
	
	public static int minJump(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int len = arr.length;
		int min = 0;//from 0 to current pos i
		int currReach = 0;//current reach for i
		int lastReach = 0;//last reach
		for (int i = 0; i < len; i++) {
			if(i > currReach) {
				return -1;
			}
			if( i > lastReach) {
				min++;
				lastReach = currReach;
			}
			currReach = Math.max(currReach, i + arr[i]);//ÐÂµÄ current reach
			if(currReach >= len - 1) {
				return min;
			}
		}
//		return currReach >= len - 1 ? min : -1;
		return -1;
    // return currReach >= len ? min : -1;
	}

}
