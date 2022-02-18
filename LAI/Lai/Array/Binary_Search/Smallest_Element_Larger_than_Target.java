package Lai.Array.Binary_Search;

import Utils.ArrayUtils;

public class Smallest_Element_Larger_than_Target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = ArrayUtils.generateIntArraySorted(8, 0, 20);
		int[] arr = {1,  5,  7,  9, 13, 15, 19, 22};
		ArrayUtils.printIntArray(arr);
		System.out.println(""+smallestElementLargerThanTarget(arr, 22));
	}

	public static int smallestElementLargerThanTarget(int[] arr, int target) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return -1;
		}
//		if (target < arr[0]) {// || target > arr[arr.length - 1]){
//			return 0;
//		}
//		if (target >= arr[arr.length - 1]) {// || target > arr[arr.length - 1]){
//			return -1;
//		}

		int left = 0;
		int right = arr.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				left = mid;
			} else if (arr[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		System.out.println("left:"+ left);
		System.out.println("right:"+ right);
		if (target < arr[right]) {
			return right;
		}
		if (target == arr[right]) {
			return right + 1;
		}
		return -1;
	}

}
