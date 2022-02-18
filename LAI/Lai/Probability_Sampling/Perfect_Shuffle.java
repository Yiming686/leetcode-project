package Lai.Probability_Sampling;

import Utils.ArrayUtils;

public class Perfect_Shuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArray(9, 1, 50);
		shuffle(arr);
		ArrayUtils.printIntArray(arr);
//		int k = 1000000;
//		int count0 = 0;
//		int count1 = 0;
//		while(--k > 0) {
//			int val = (int) (Math.random() * 2);
//			if(val == 0) {
//				count0++;
//			}else {
//				count1++;
//			}
//		}
		
//		System.out.println("count0: "+count0 );
//		System.out.println("count1: "+count1 );
//		System.out.println("diff: "+ Math.abs(count1 - count0 ));
		System.out.println(""+ (int) (Math.random() * (0 + 1)));
		System.out.println(""+ (int) (Math.random() * (1 + 1)));
		System.out.println(""+ (int) (Math.random() * (2 + 1)));
	}
	

	public static void shuffle(int[] array) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = array.length - 1; i >= 1; i--) {
			int index = (int) (Math.random() * (i + 1));
			swap(array, index, i);
		}
	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

}
