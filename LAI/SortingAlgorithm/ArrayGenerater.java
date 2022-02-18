package SortingAlgorithm;

import java.util.Arrays;

public class ArrayGenerater {
		
		public static int[] intArray(int size, int left, int right){
			int[] arr = new int[size];
			int range = right - left + 1;
			for(int i = 0; i < size; i++) {
				arr[i] = left + (int)(Math.random() * range );
				if(arr[i] == left || arr[i] == right || arr[i] == right - 1) {
//					System.out.println(""+arr[i]);
				}
			}
			System.out.println(""+Arrays.toString(arr));
			return arr;
		}
		

}
