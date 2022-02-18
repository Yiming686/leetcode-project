package Lai.Heap_Prority_Queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

import Utils.ArrayUtils;

public class K_Smallest_In_Unsorted_Array {
	static abstract class BBB{
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = ArrayUtils.buildIntArrayNoDup(15, 2, 30);
//		int[] arr = {12,  8, 12, 13, 20,  8,  8, 24};
//		int[] arr1 = {22, 13, 29, 19,  3, 12,  5,  9,  7, 21, 23, 26, 14, 30,  6};
//		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
//		ArrayUtils.printIntArray("arr1: ", arr1);
//		ArrayUtils.printIntArray("arr2: ", arr2);
//		int left = 11;
//		int right = 13;
//		ArrayUtils.printIntArray(arr);
//		ArrayUtils.printIntArray(ArrayUtils.generateNewSortedIntArray(arr));

		ArrayUtils.printIntArray(findKSmallest(arr, 5));
		int left = -1;
//		while(left != 14) {
//			left = new Random().nextInt(arr1.length);
//		}
//		System.out.println("left: "+left);
//		int right = left + new Random().nextInt(arr1.length - left );
//		int pos1 = partitionA(arr1, left, right);
//		int pos2 = partitionB(arr2, left, right);
//		System.out.println("partition： "+ pos1);
//		System.out.println("partitionB： "+ pos2);
//		System.out.printf("Result: %s, left:right %s:%s ", ( pos1 == pos2), left, right);
	}


	//worked, TC is O(K + (N-K)logK), SC is O(K), k must be less than arr.lenght or NPE
	public static int[] kSmallest00(int[] arr, int k) {
		// Write your solution here
		if (arr == null || arr.length == 0 || k <= 0) {
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				maxHeap.offer(arr[i]);//怎么存储的怎么知道呢？由comparator来决定的,当前最小的K个数
			} else if (arr[i] < maxHeap.peek()) {//和最大的比较，只要更小的k个数
				maxHeap.poll();
				maxHeap.offer(arr[i]);
			}
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = maxHeap.poll();
		}
		return result;
	}
	
	//worked, quick select, but not good-looking: find a pivot and find the correct position for pivot then 
	public static int[] kSmallest_quickselect01(int[] arr, int k) {
		int left = 0; 
		int right = arr.length - 1;
//		int pos = partitionA(arr, left, right);//like find the mid in BS
		int pos = -1;
		while(pos != k - 1) {
			if(pos < k - 1 ) {
				left = pos + 1;
				pos = partitionA(arr, left, right);
			}else {
				right = pos - 1;
				pos = partitionA(arr, left, right);
			}
		}
		int[] result = Arrays.copyOf(arr, k);
		return result;
	}
	
	//given arr and k, find k smallest elements
	public static int[] findKSmallest(int[] arr, int k) {
		quickSelect(arr, 0, arr.length - 1, k - 1);//在arr的0到len范围内，令0到k-1的元素是最小的, 
		ArrayUtils.printIntArray(arr, 3);
		int[] result = Arrays.copyOf(arr, k);
		return result;
	}
	
	//在arr的left到right范围内，令0到pos的元素是最小的
	//reorder arr to make sure the first k ones are the smallest ones
	//left, right, pos 递归时，为arr的绝对index位置
	private static void quickSelect(int[] arr, int left, int right, int pos) {
		int mid = partitionA(arr, left, right);//前mid个是最小的
		if(mid == pos) {
			return;
		}
		if(mid < pos) {//
			quickSelect(arr, mid + 1, right, pos);
		}else {
			quickSelect(arr, left , mid - 1, pos);
		}
		
	}


	//given arr and target, return the position of target
	//best partition ever
	private static int partitionA(int[] arr, int left, int right) {
		int pivotPos = right;
		int pivot = arr[pivotPos];
		right--;
		while(left <= right) {
			if(arr[left] < pivot) {
				left++;
			}else {
				ArrayUtils.swap(arr, left, right--);
			}
		}
		//right to last smaller; left to first larger, only return left
		ArrayUtils.swap(arr, left, pivotPos);
		return left;
	}
	private static int partitionB(int[] arr, int left, int right) {
		int pivotPos = right;
		int pivot = arr[pivotPos];
		int start = left;
		int end = right - 1;
		while(start <= end) {
			if(arr[start] < pivot) {
				start++;
			}else if(arr[end] >= pivot){
				end--;
			}else {
				ArrayUtils.swap(arr, start++, end--);
			}
		}
		ArrayUtils.swap(arr, start, right);
		return start;
	}

}
