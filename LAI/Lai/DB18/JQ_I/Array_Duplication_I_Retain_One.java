package Lai.DB18.JQ_I;

import static Utils.ArrayUtils.toStr;

import java.util.Arrays;

import Utils.ArrayUtils;

public class Array_Duplication_I_Retain_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArrayWithDupSorted(20, 1,5);
		System.out.println("" + toStr(dedup(arr)));

	}

	public static int[] dedup(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return arr;
		}
		int left = 0;		
		for(int right = 0; right < arr.length; right++) {
			if(left < 1 || arr[right] != arr[left - 1]) {
				arr[left++] = arr[right];
			}
		}
		return Arrays.copyOf(arr, left);
//		return Arrays.copyOfRange(arr, 0, left);
	}
}
