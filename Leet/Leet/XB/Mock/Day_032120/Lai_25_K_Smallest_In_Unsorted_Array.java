package Leet.XB.Mock.Day_032120;

import static Utils.ArrayUtils.print;

import java.util.Arrays;

public class Lai_25_K_Smallest_In_Unsorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {3, 4, 1, 2, 5};
		int[] A = {12,2,4,3,9,6};
		int k = 4;
		print(kSmallest(A, k));
		System.out.println(""+kthSmallest(A, k));
	}

	public static int[] kSmallest(int[] arr, int k) {
		// Write your solution here
		int left = 0;
		int right = arr.length - 1;
//				int pos = partitionA(arr, left, right);//like find the mid in BS
		int pos = -1;
		while (pos != k - 1) {
			if (pos < k - 1) {
				left = pos + 1;
				pos = partition(arr, left, right);
			} else {
				right = pos - 1;
				pos = partition(arr, left, right);
			}
		}
		int[] result = Arrays.copyOf(arr, k);
		Arrays.sort(result);
		return result;
	}
	
	public  static int kthSmallest(int[] arr, int k) {
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid Input: int[] array!");
		}
		if(k < 1 || k > arr.length) {
			throw new IllegalArgumentException("Invalid Input: int k!");
		}
		return findKthSmallest(arr, 0, arr.length - 1, k);
	}
	private static int findKthSmallest(int[] arr, int left, int right, int k) {
		int pos = partition(arr, left, right);
		if(pos == k-1) {
			return arr[pos];
		}else if(pos < k - 1) {
			return findKthSmallest(arr, pos + 1, right, k);
		}else {
			return findKthSmallest(arr, left, pos - 1, k);
		}
		
	}
	private static int partition(int[] arr, int left, int right) {
		int pivotPos = right;
		int pivot = arr[pivotPos];
		right--;
		while (left <= right) {
			if (arr[left] < pivot) {
				left++;
			} else {
				swap(arr, left, right--);
			}
		}
		//right to last smaller; left to first larger, only return left
		swap(arr, left, pivotPos);
		return left;
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
