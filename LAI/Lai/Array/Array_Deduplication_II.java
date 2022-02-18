package Lai.Array;

import java.util.Arrays;

public class Array_Deduplication_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5 };
		System.out.println("" + Arrays.toString(arr));
		System.out.println("" + Arrays.toString(dedup(arr)));
	}

	public static int[] dedup(int[] array) {
		return dedup(array, 3);
	}

	public static int[] dedup(int[] array, int k) {
		// Write your solution here
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 1;
		int count = 1;
		for (int fast = 1; fast < array.length; fast++) {
			System.out.println("prev count: "+count);
			if (array[fast] != array[slow - 1]) {
				array[slow] = array[fast];
				slow++;
				count = 1;
			} else if (count < k) {
				array[slow] = array[fast];
				slow++;
				count++;
			} else {
				count++;
			}
			System.out.println("curr count: "+count);

		}
		return Arrays.copyOf(array, slow);

	}

}
