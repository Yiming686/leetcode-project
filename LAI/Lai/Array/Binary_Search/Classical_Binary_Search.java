package Lai.Array.Binary_Search;

import java.util.Arrays;

public class Classical_Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 4, 8, 9 };
		System.out.println("" + Arrays.toString(arr));
		System.out.println("===============================");
		System.out.println("" + binarySearch(arr, 99));

//		{3,4,5,6,6,9,16}
	}

	public static int binarySearch(int[] arr, int target) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1; // mid or mid + 1,  mid + 1 is wrong
			} else {
				right = mid - 1; // mid or mid - 1,  mid - 1 is wrong
			}
		}
		return -1;
	}

}
