package Lai.Recursion_I_Sorting_Algorithm;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.swap;
import static Utils.ArrayUtils.toStr;

import java.util.Arrays;

import Utils.ArrayUtils;

public class Heap_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[  5,  7,  8,  9]  from 1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  4,  4,  5,  5,  7,  8,  9
		int[] arr = ArrayUtils.buildIntArrayNoDup(6, 1,20);
//		int[] arr = {1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  4,  4,  5,  5,  7,  8,  9};
//		int[] arr = {1,2,3,3,3,2,2};
//		int[] arr = { 1, 1, 2, 2, 2, 3 };
//		int[] arr = {2, 12,  7, 15, 10, 13};
		int[] arr2 = new int[arr.length]; 
		System.arraycopy(arr, 0, arr2, 0, arr.length);
//		int[] arr3 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOfRange(arr, 0, arr.length);
		print(arr);
		print(arr2);
		print(arr3);
		System.out.println("sorted: " + toStr(heapSort(arr)));

	}

//	sort in ascending order
	private static int[] heapSort(int[] arr) {
		//step 1: heapify
		heapify(arr);
		print("after heapify: "+ toStr(arr));
		//step 2: pop
		int pos = arr.length - 1;
		while(pos >= 0) {
			swap(arr, 0, pos);
			percolateDown(arr, pos, 0);
			pos--;
		}
		
		//step 3: add to end
		return arr;
	}

//	build heap, max heap, sorted in descending order
//	two properties: ONE: complete binary tree ; TWO: sort from root to leaf
//	if a new one is added ,it must be added into the last one, due to ONE, then maintain TWO
//	given node index, the two left and right child are 2 * index + 1 and 2 * index + 2
//	so given index of a child, its parent index is (index - 1) / 2;
//	0,1,2,3,4,5,6
	
//	private static void heapify(int[] arr) {
//	private static void heapify_00(int[] arr) {
//		int index = 1;//all 0 to last is a max heap
//		int parent = (index - 1) / 2;
//		
//		while(index < arr.length) {
//			int temp = index;
//			while(parent >= 0 && arr[index] > arr[parent]) {
//				swap(arr, index, parent);
//				index = parent;
//				parent = (index - 1) / 2;
//			}
//			index = temp+1;
//			parent = (index - 1) / 2;
//		}
//	}
	
	//最后一个有孩子的节点，(len - 1 - 1) / 2 最好为 len / 2 - 1
	private static void heapify(int[] arr) {
//	private static void heapify_11(int[] arr) {
		int len = arr.length;
		int last = (len - 1 - 1) / 2; //bugs
//		int first2Down = len / 2 - 1;
		while(last >= 0) {
			percolateDown(arr, len, last);
			last--;
		}
	}
	//maxHeap，因为从大到小排列，所以找孩子中的最大的，要交换就交换最大的上来，
	private static void percolateDown(int[] arr, int len, int index) {		
		while( index <= (len - 1 - 1) /2 ) {//bugs
//		while( index <=  len/2 - 1 ) {//bugs			
//			print("index: " + index);
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			int candidate = leftChildIndex;
			if(rightChildIndex < len && arr[rightChildIndex] > arr[leftChildIndex]) {
				candidate = rightChildIndex;
			}
//			if(arr[index] < arr[candidate]) {
			if(candidate < len && arr[index] < arr[candidate]) {				
				swap(arr, index, candidate);
			}else {
//				break;//没有这句可以吗
			}
			index = candidate;
		}		
	}
	
	private static void percolateUp(int[] arr, int len, int newVal) {
		
	}
	
}
