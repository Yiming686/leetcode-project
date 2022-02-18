package Lai.Array.Binary_Search;

public class First_Occurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int firstOccurrence(int[] arr, int target) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				right = mid;
//				return mid;
			} else if (arr[mid] < target) {
				left = mid; // mid or mid + 1,  mid + 1 is wrong
			} else {
				right = mid; // mid or mid - 1,  mid - 1 is wrong
			}
		}
		if(arr[left] == target) {
			return left;
		}
		if(arr[right] == target) {
			return right;
		}
		return -1;
	}

}
