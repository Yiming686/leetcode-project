package Lintcode.Array;

import java.util.Arrays;

public class Find_First_and_Second_Max_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 4, 12,15,2, 6, 8, 1, 9, 12, 15, 11 };
		Pair result = findFirstSecondMax(arr);
//		int kth = findKthMax(arr,  3);
//		int kth = findKthMax(arr,  4);
//		int kth = findKthMax(arr,  5);
		int kth = findKthMax(arr,  6);
 
		System.out.println("firstMax : " + result.firstMax);
		System.out.println("secondMax: " + result.secondMax);
		Arrays.sort(arr);
		System.out.println(""+Arrays.toString(arr));
		System.out.println("kthMax: " + kth);
	}
	private static Pair findFirstSecondMax(int[] arr) {
		// TODO Auto-generated method stub
		if(arr == null || arr.length < 2) return null;
		int firstMax  = arr[0] < arr[1]? arr[1] : arr[0];
		int secondMax = arr[0] < arr[1]? arr[0] : arr[1];

		for(int i = 2; i < arr.length; i++ ){
//			System.out.println("       ");
//			System.out.println("firstMax : " + firstMax);
//			System.out.println("secondMax: " + secondMax);

			if(arr[i] > firstMax){
				secondMax = firstMax;
				firstMax = arr[i];
			}else if(arr[i] > secondMax){
				secondMax = arr[i];
			}
		}
		
		return new Pair(firstMax, secondMax);
	}
	static class Pair {
		int firstMax;
		int secondMax;
		public Pair(int firstMax, int secondMax) {
			super();
			this.firstMax = firstMax;
			this.secondMax = secondMax;
		}
		
	}


	
	private static int findKthMax(int[] arr, int k) {
		if(arr == null || arr.length < k || k<=0) throw new IllegalArgumentException();
		return helper(arr, 0, arr.length-1, k);
	}
	
	private static int helper(int[] arr, int left, int right, int k) {
		// TODO Auto-generated method stub
		int pos = partition(arr, left, right);
		if(pos+1 == k) 
			return arr[pos];
		else if(pos+1 < k)
			return helper(arr, pos+1, right, k);
		else {
			return helper(arr, left, pos-1, k);
		}
	}
	//标准解法
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int pos = left;//在下面的循环中，pos是待插入位置
		for(int i = left; i <= right; i++){
			if(arr[i] >= pivot){
				int temp = arr[i];
				arr[i] = arr[pos];
				arr[pos] = temp;
				pos++;
			}
		}
		return --pos;//此时pos指向最后一个大于等于pivot的元素，才是可能求解的元素
	}

}
