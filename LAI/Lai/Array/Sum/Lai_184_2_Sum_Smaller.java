package Lai.Array.Sum;

import java.util.Arrays;

/**
 * Determine the number of pairs of elements in a given array that sum to a
 * value smaller than the given target number.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 2 Examples
 * 
 * A = {1, 2, 2, 4, 7}, target = 7, number of pairs is 6({1,2}, {1, 2}, {1, 4},
 * {2, 2}, {2, 4}, {2, 4})
 *
 * 
 * 
 */
public class Lai_184_2_Sum_Smaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int smallerPairs(int[] arr, int target) {
		// Write your solution here
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int j = bs(arr, i, target);//
			count += j - i;
		}
		return count;
	}

	//last pos2 where arr[pos] + arr[pos2] < target
	private int bs(int[] arr, int pos, int target) {
		int left = pos;
		int right = arr.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[pos] + arr[mid] == target) {
				right = mid - 1;
			} else if (arr[pos] + arr[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (arr[pos] + arr[right] < target) {
			return right;
		}
		return left;
	}

}
