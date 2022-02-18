package Lai.HashTable_String_I;

import Utils.ArrayUtils;

public class Missing_Number_I {

	public static void main(String[] args) {
		int[] arr = new int[] { 8, 11, 10, 9, 4, 5, 6, 1, 2, 3, 7 };
		System.out.println("len: " + arr.length);
		System.out.println("" + missing(arr));
	}

	public static int missing(int[] arr) {
		int n = arr.length + 1;//长度为n-1
		for (int i = 0; i < arr.length; i++) {
			ArrayUtils.printIntArray(arr);
			while (arr[i] != i + 1 && arr[i] != n) {//swap to arr[i] - 1， if arr[i] == n,
				ArrayUtils.swap(arr, i, arr[i] - 1);//index不能超过n-2
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return n;
	}

}
