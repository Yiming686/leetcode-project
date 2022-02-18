package Leet.XXB.Interview.Day_01112020;

import static Utils.ArrayUtils.swap;

import java.util.Arrays;

import Utils.ArrayUtils;

public class K_th_largest_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {3,2,1,5,6,4}; //6,5,4,3,2,1
		                           
//		int[] arr = {3,2,3,1,2,4,3,5,3,5,6}; // 6, 5,5,4,3,3,3,3,2, 2, 1
////                                              1, 2,3,4,5,6,7,8,9,10,11
////                                             11,10,9,8,7,6,5,4,3, 2, 1
////		
		int[] arr = ArrayUtils.buildIntArray(20, -50, 50);
//		ArrayUtils.sort(arr);
		int[] arrOutput = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arrOutput[i] = findKthLargest(arr, i+1);			
		}
		System.out.println("By method:");
		ArrayUtils.print(arrOutput, true);
		
		System.out.println("Original:");
		Arrays.sort(arr);
		ArrayUtils.print(arr, true);
//		
		
		
		int k = 8;
//		int k = 4;
		System.out.println(""+findKthLargest(arr, k));		
	}

	private static int findKthLargest(int[] arr, int k) {
		//assumption
		return findKthLargest(arr, 0, arr.length - 1, k);
	}

//	
	private static int findKthLargest(int[] arr, int left, int right, int k) {
		int pos = partitionAscending(arr, left, right);//from largest to smallest
//		int pos = partitionDescending(arr, left, right);//from largest to smallest
		if(pos == k - 1) {
			return arr[pos];//the kth largest
		}
		if(pos < k -1) {
			return findKthLargest(arr, pos + 1, right, k);
		}else {
			return findKthLargest(arr, left, pos - 1, k);
		}				
	}
	
	private static int partitionAscending(int[] arr, int start, int end) {
		int pivotIndex = end; //or random pick
		int pivot = arr[pivotIndex];
		int left = start;
		int right = end - 1;
		while(left <= right) {//descending order
			if(arr[left] < pivot) {//
//				swap(arr, left, right);
//				right--;
				left++;
			}else {				
				swap(arr, left, right);
 				right--;
//				left++; 
			}
		}
		swap(arr, left, pivotIndex);		
		return left;
	}
	
	private static int partitionDescending(int[] arr, int start, int end) {
		int pivotIndex = end; //or random pick
		int pivot = arr[pivotIndex];
		int left = start;
		int right = end - 1;
		while(left <= right) {//descending order
			if(arr[left] <= pivot) {//
				swap(arr, left, right);
				right--;
//				start++;
			}else {				
				left++; 
// 				end--;???
			}
		}
		swap(arr, left, pivotIndex);		
		return left;
	}
	
	private static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

}
