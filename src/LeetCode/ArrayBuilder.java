package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ArrayBuilder {
	public static int[] createIntegerArray_WithDups(int len, int min, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			int element = (int) (min + Math.random() * (max - min + 1));

			arr[i] = element;
		}
		return arr;
	}

	public static int[] createIntegerArray_NoDups(int len, int min, int max) {
		if (len > max - min + 1) {
			return null;
		}

		Set<Integer> intSet = new HashSet<Integer>();
		while (intSet.size() < len) {
			double d = min + Math.random() * (max - min + 1);
			if (d < 0)
				d = d - 1;
			int element = (int) d;
//			 System.out.printf("%s, %s, %s, %s, %s, %s  \n",element, (min+ d *
//			 (max - min + 1)),d, max - min + 1,min, max );
			intSet.add(element);
		}

		Integer[] arrInt = intSet.toArray(new Integer[0]);
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = arrInt[i];

		}
		return arr;
	}
}
