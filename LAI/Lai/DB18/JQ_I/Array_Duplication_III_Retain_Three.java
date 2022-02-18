package Lai.DB18.JQ_I;

import static Utils.ArrayUtils.toStr;

import java.util.Arrays;

import Utils.ArrayUtils;

public class Array_Duplication_III_Retain_Three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[  5,  7,  8,  9]  from 1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  4,  4,  5,  5,  7,  8,  9
//		int[] arr = ArrayUtils.generateIntArrayWithDupSorted(20, 1,9);
//		int[] arr = {1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  4,  4,  5,  5,  7,  8,  9};
//		int[] arr = {1,2,3,3,3,2,2};
		int[] arr = {1,1,2,2,2,3};
		System.out.println("" + toStr(dedup(arr)));

	}

	public static int[] dedup(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return arr;
		}
		int slow = 0;		
		for(int fast = 0; fast < arr.length; fast++) {
			if(slow < 1 || arr[fast] != arr[slow - 1]) {
				arr[slow++] = arr[fast];
			}else {
				//ɾ�������ظ���Ԫ�أ�ɾ������ֵ��arr[slow]һ����Ԫ��
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
