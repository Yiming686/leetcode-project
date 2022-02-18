package Lai.Array.Binary_Search;

/**

Given an integer array A, A is sorted in ascending order first then shifted 
by an arbitrary number of positions, For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). 
Find the index of the smallest number.

Assumptions

There are no duplicate elements in the array
Examples

A = {3, 4, 5, 1, 2}, return 3
A = {1, 2, 3, 4, 5}, return 0
Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.

 *
 */
public class Lai_23_Shift_Position_find_Min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int shiftPosition(int[] arr) {
		return searchMin(arr);
	}

	public int searchMin(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			// if(arr[mid] == target){
			//   return mid;
			// }
			if (arr[mid] < arr[right]) {
				// if(arr[mid] < target && target <= arr[right]){
				//   left = mid;
				// }else{
				right = mid;
				// } 
				// }else if(arr[right] < target && target < arr[mid]){
				// right = mid;
			} else {
				left = mid;
			}
		}
		// if(arr[left] == target){
		//   return left;
		// }
		// if(arr[right] == target){
		//   return right;
		// }
		if (arr[left] < arr[right]) {
			return left;
		}
		return right;
	}

}
