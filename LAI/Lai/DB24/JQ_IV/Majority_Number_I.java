package Lai.DB24.JQ_IV;

import static  Utils.ArrayUtils.*;

import Utils.ArrayUtils;

public class Majority_Number_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = ArrayUtils.buildIntArray(7, 0, 20);
		int [] arr2 = ArrayUtils.buildIntArrayAllDup(8, 11);
		int [] arr = ArrayUtils.mergeIntArrays(arr1, arr2);
		arr = ArrayUtils.shuffle(arr);
		ArrayUtils.printIntArray(arr);
		System.out.println(""+majority(arr));
	}

	public static int majority(int[] arr) {
		int count = 1;
		int val = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == val) {
				count++;
			} else if (count != 0) {
				count--;
			} else {
				val = arr[i];
				count = 1;
			}
			printf("val:count %d:%d \n", val,count);
		}
		return val;
	}

}
