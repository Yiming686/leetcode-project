package Lintcode.Array;

/**
Find Min & Max in an Array Using Minimum Comparisons
 
Given an array of integers find the maximum and minimum elements by using minimum comparisons.

 *
 */
public class Find_Min_and_Max_in_an_Array_Using_Minimum_Comparisons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = { 3, 4, 2, 6, 8, 1, 9, 12, 15, 11 };
		Pair result = getMinMax(a1, 0, a1.length - 1);
 
		System.out.println("Min: " + result.min);
		System.out.println("Max: " + result.max);
	}
	
	static class Pair {
		int min;
		int max;
	}
	
	public static Pair getMinMax(int arr[], int low, int high) {
		Pair result = new Pair();
		Pair left = new Pair();
		Pair right = new Pair();
 
		// if there is only one element
		if (low == high) {
			result.max = arr[low];
			result.min = arr[low];
			return result;
		}
 
		// if there are two elements
		if (high == low + 1) {
			if (arr[low] > arr[high]) {
				result.max = arr[low];
				result.min = arr[high];
			} else {
				result.max = arr[high];
				result.min = arr[low];
			}
			return result;
		}
 
		// if there are more than 2 elements
		int mid = (low + high) / 2;
		left  = getMinMax(arr, low,     mid);
		right = getMinMax(arr, mid + 1, high);
 
		if (left.min < right.min)
			result.min = left.min;
		else
			result.min = right.min;
 
		if (left.max > right.max)
			result.max = left.max;
		else
			result.max = right.max;
 
		return result;
	}


}
