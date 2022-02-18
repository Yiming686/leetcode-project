package Lai.Array.Binary_Search;

import java.util.Arrays;

public class Closest_In_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 4, 8, 9 };
		System.out.println("" + Arrays.toString(arr));
		System.out.println("===============================");
//		System.out.println("" + closestInSortedArray(arr, 99));
		System.out.println("" + closestInSortedArray(arr, -1));

//		{3,4,5,6,6,9,16}

	}
	public static int closestInSortedArray(int[] arr, int target) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left + 1< right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid; // mid or mid + 1,  mid + 1 is wrong
			} else {
				right = mid; // mid or mid - 1,  mid - 1 is wrong
			}
		}
	    if(Math.abs(target - arr[left]) <= Math.abs(target - arr[right])){
	        return left;
	      }else{
	        return right;
	    }

	}

}
