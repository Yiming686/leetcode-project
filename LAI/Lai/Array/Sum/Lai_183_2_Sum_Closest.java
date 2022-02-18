package Lai.Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the pair of elements in a given array that sum to a value that is
 * closest to the given target number. Return the values of the two numbers.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 2 Examples
 * 
 * A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
 *
 * 
 */
public class Lai_183_2_Sum_Closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 3, 4, 1, -1, 2, 0, 5 };
		int target = -2;
		System.out.println(""+closest(arr, target));
	}

	public static List<Integer> closest(int[] arr, int target) {
		// Write your solution here
		List<Integer> result = new ArrayList<>();
		result.add(-1);
		result.add(-1);
		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int j = bsClosest(arr, i, target);//
			if (Math.abs(arr[i] + arr[j] - target) < diff) {
				diff = Math.abs(arr[i] + arr[j] - target);
				result.set(0, arr[i]);
				result.set(1, arr[j]);
			}
		}
		return result;
	}

	// 找出arr，里面i位置元素后面的j，二者之和距离target 最近
	private static int bsClosest(int[] arr, int pos, int target) {
//	private static int bsClosest(int[] arr, int pos, int target, int d) {		
		int left = pos + 1;
		int right = arr.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[pos] + arr[mid] == target) {
				// right = mid - 1;
				return mid;
//			} else if ((arr[pos] + arr[mid] + 2 * d) < (target + 2 * d)) {
			}else if(arr[pos] + arr[mid] < target){				
				left = mid;
			} else {
				right = mid;
			}
		}
		if (Math.abs(arr[pos] + arr[left] - target) < Math.abs(arr[pos] + arr[right] - target)) {
			return left;
		}
		return right;
	}

}
