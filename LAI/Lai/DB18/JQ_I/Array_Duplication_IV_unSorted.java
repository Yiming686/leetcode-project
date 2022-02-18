package Lai.DB18.JQ_I;

import static Utils.ArrayUtils.toStr;

import java.util.Arrays;

import Utils.ArrayUtils;

public class Array_Duplication_IV_unSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[  5,  7,  8,  9]  from 1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  4,  4,  5,  5,  7,  8,  9
//		int[] arr = ArrayUtils.generateIntArrayWithDupSorted(20, 1,9);
//		int[] arr = {1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  4,  4,  5,  5,  7,  8,  9};
//		int[] arr = {1,2,3,3,3,2,2};
		int len = 1;
		int r = (- 1) /2; //为什么负数/2 ，等于正数呢？-1=（1111111111111），-1+1 = 0； 除以2 等价于右移1位，
		System.out.println("r: "+r );
//		int[] arr = {1,1,2,2,2,3};
//		System.out.println("" + toStr(dedup(arr)));

	}
//The Same as the Array_Duplication_III_Retain_Three
	public static int[] dedup(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return arr;
		}
		int slow = 0;		
		for(int fast = 0; fast < arr.length; fast++) {
			if(slow < 1 || arr[fast] != arr[slow - 1]) {
				arr[slow++] = arr[fast];
			}else {
				//删除所有重复的元素，删除所有值和arr[slow]一样的元素
				while(fast < arr.length && arr[fast] == arr[slow - 1]) {
					fast++;					
				}				
				slow--;
				fast--;
			}
		}
		return Arrays.copyOf(arr, slow);
//		return Arrays.copyOfRange(arr, 0, left);
	}
}
