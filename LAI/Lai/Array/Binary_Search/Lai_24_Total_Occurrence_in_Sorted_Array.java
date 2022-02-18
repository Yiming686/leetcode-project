package Lai.Array.Binary_Search;

/**
Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.

Examples

A = {1, 2, 3, 4, 5}, T = 3, return 1
A = {1, 2, 2, 2, 3}, T = 2, return 3
A = {1, 2, 2, 2, 3}, T = 4, return 0
Corner Cases

What if A is null? We should return 0 in this case.

 *
 */
public class Lai_24_Total_Occurrence_in_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int totalOccurrence(int[] arr, int target) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int firstPos = findFirst(arr, 0, arr.length - 1, target);
		if (firstPos == -1) {
			return 0;
		}
		int lastPos = findLast(arr, firstPos, arr.length - 1, target);
		return lastPos - firstPos + 1;
	}

	private int findFirst(int[] arr, int start, int end, int target) {
		int left = start;
		int right = end;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (arr[left] == target) {
			return left;
		} else if (arr[right] == target) {
			return right;
		} else {
			return -1;
		}
	}

	private int findLast(int[] arr, int start, int end, int target) {
		int left = start;
		int right = end;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (arr[right] == target) {
			return right;
		} else if (arr[left] == target) {
			return left;
		} else {
			return -1;
		}
	}

}
