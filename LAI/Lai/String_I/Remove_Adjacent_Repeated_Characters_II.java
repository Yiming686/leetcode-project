package Lai.String_I;

import java.util.Arrays;

/**
 * 
 * 第二种问题：有重复的情况下，保留顶多两个重复元素，顶多希望看见重复两次，多了接受不了
 * 不论是否排好序了，
 * 
 * Remove adjacent, repeated characters in a given string, leaving only two
 * characters for each group of such characters. The characters in the string
 * are sorted in ascending order.
 * 
 * Assumptions
 * 
 * Try to do it in place. Examples
 * 
 * “aaaabbbc” is transferred to “aabbc” Corner Cases
 * 
 * If the given string is null, we do not need to do anything.
 *
 * 
 */
public class Remove_Adjacent_Repeated_Characters_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		k=5, bbdef bbakqikdski
//		     bbdef bbakqikdski
		String str = "bbbbtttttaaaabbbc";
		System.out.println("" + deDup(str, 2));
	}

	public static String deDup(String input) {
		// Write your solution here
		if (input == null || input.length() < 3) {
			return input;
		}
		char[] arr = input.toCharArray();
		int left = 2;
		for (int right = 2; right < arr.length; right++) {
			if (arr[right] != arr[left - 2]) {
				arr[left++] = arr[right];
			}
		}
		return new String(arr, 0, left);
	}

	public static String deDup(String input, int k) {
		// Write your solution here
		if (input == null || input.length() <= k) {
			return input;
		}
		char[] arr = input.toCharArray();
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			if (left < k || arr[right] != arr[left - k]) {
				arr[left++] = arr[right];
			}
		}
		return new String(arr, 0, left);
	}

	public int[] deDup(int[] input, int k) {
		// Write your solution here
		if (input == null || input.length <= k) {
			return input;
		}
		int slow = k;
		for (int fast = k; fast < input.length; fast++) {
			if (input[fast] != input[slow - k]) {
				input[slow++] = input[fast];
			}
		}
		return Arrays.copyOf(input, slow);
	}

}
