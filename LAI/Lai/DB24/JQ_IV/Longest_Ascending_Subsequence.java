package Lai.DB24.JQ_IV;

import Utils.ArrayUtils;

public class Longest_Ascending_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = ArrayUtils.generateIntArraySorted(6, 0, 20);
		int[] arr = { 3, 9, 12, 15, 16, 20 };
//		int[] arr = { 3, 12, 20 };
//		System.out.println(""+longest(arr));
		ArrayUtils.printIntArray(arr);
//		System.out.println(""+find(arr, 0, 5, 15));
		System.out.println("" + find(arr, 0, 5, 111));//能和自己连接上的点
//		System.out.println("" + find2(arr, 0, 5, 1));//能和自己连接上的点
	}

	// logn to find element that is less than curr, 
	// get longest, then plus one, put it in right place for further use
	public static int longest(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int result = 0;
		int[] table = new int[arr.length + 1];//1 to arr.length
		table[1] = arr[0];//so far, the val the LAS of which is 1.
		for (int i = 1; i < arr.length; i++) {
			int index = find(table, 1, result, arr[i]);//logN to find index

		}
		return result;
	}

	// find pos in array table from left to right to insert arr[index]
	// array table: index is len of LAS, val is the last val of earliest LAS with len index
	private static int find(int[] table, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			System.out.printf("left:mid:right %d:%d:%d\n", left, mid, right);
			if (table[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.printf("right:left %d:%d\n", right, left);
		return right;
	}

	private static int find2(int[] table, int left, int right, int target) {
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (table[mid] < target) {
//				left = mid + 1;
				left = mid;
			} else {
//				right = mid - 1;
				right = mid;
			}
		}
		if (target > table[right]) {
			return right;
		} else if (target > table[left]) {
			return left;
		} else {
			return left - 1;
		}
	}

	// Time = O(N^2)，Space = O(N)
	public static int longest_01(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int globalMax = 1;
		int[] longest = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			longest[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					longest[i] = Math.max(longest[i], longest[j] + 1);
				}
			}
			globalMax = Math.max(globalMax, longest[i]);
		}
		return globalMax;
	}

}
