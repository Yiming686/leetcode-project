package SortingAlgorithm;

import static Utils.ArrayUtils.*;

public class Selection_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solve(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		for (int i = 0; i < array.length; i++) {
			int min = i;// default, first minimum value
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
		return array;
	}
	
	

}
