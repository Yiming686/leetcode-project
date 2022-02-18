package Lai.Array;

import java.util.Arrays;

/**
 * Given a sorted integer array, remove duplicate elements. For each group of
 * elements with the same value keep only one of them. Do this in-place, using
 * the left side of the original array and maintain the relative order of the
 * elements of the array. Return the array after deduplication.
 * 
 * Assumptions
 * 
 * The array is not null Examples
 * 
 * {1, 2, 2, 3, 3, 3} → {1, 2, 3}
 *
 * 
 */
public class Array_Deduplication_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//一模一样  的题目
	public static String deDup(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (slow == 0 || arr[fast] != arr[slow - 1]) {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}

	//worked
	public static int[] dedup(int[] array) {
		// Write your solution here
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 0;
		for (int fast = 0; fast < array.length; fast++) {
			if (slow == 0 || array[fast] != array[slow - 1]) {
				array[slow++] = array[fast];
			}
		}
		return Arrays.copyOf(array, slow);
	}

}
