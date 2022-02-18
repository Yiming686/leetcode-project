package Lai.Recursion_I_Sorting_Algorithm;

/**

Given an array of balls with k different colors denoted by numbers 1- k, sort the balls.

Examples

k=1, {1} is sorted to {1}
k=3, {1, 3, 2, 1, 2} is sorted to {1, 1, 2, 2, 3}
k=5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}
Assumptions

The input array is not null.
k is guaranteed to be >= 1.
k << logn.

 */
public class Lai_400_Rainbow_Sort_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//best, ease to understand
	public int[] rainbowSortIII(int[] arr, int k) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int[] pos = new int[k];//0-->k-1
		//1 -- k
		while (pos[k - 1] < arr.length) {
			//by arr[pos[k-1]]
			//1: k-1 times k-1 : k-1, k
			//k: 0   times 0   : 0 1, 
			int val = arr[pos[k - 1]];
			for (int m = 0; m < k - val; m++) {
				//0, k-2
				swap(arr, pos[k - 2 - m], pos[k - 1 - m]);
			}
			for (int m = 0; m < k - val; m++) {
				pos[k - 2 - m]++;
			}
			pos[k - 1]++;
		}
		return arr;
	}

	//worked, ==> int[] pos = new int[k+1];
	public int[] rainbowSortIII_22(int[] arr, int k) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int[] pos = new int[k + 1];//0-->k-1
		//1 -- k
		while (pos[k] < arr.length) {
			//by arr[pos[k-1]]
			//1: k-1 times k-1 : k-1, k
			//k: 0   times 0   : 0 1, 
			int val = arr[pos[k]];
			for (int m = 0; m < k - val; m++) {
				//0, k-2
				swap(arr, pos[k - 1 - m], pos[k - m]);
			}
			for (int m = 0; m < k - val; m++) {
				pos[k - 1 - m]++;
			}
			pos[k]++;
		}
		return arr;
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
