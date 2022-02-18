package Lai.Array.Binary_Search;

import java.util.Arrays;

public class Search_In_Unknown_Sized_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dict dict = new Dict(new int[0]);
		int target =  0;
		System.out.println("Expect:  -1, Actual: " + search(dict, target));
		
		dict = new Dict(new int[] {1});
		target =  0;
		System.out.println("Expect:  -1, Actual: " + search(dict, target));

		dict = new Dict(new int[] {1});
		target =  1;
		System.out.println("Expect:  0, Actual: " + search(dict, target));

		dict = new Dict(new int[] {1});
		target =  2;
		System.out.println("Expect:  -1, Actual: " + search(dict, target));

		dict = new Dict(new int[] {1, 3});
		target =  0;
		System.out.println("Expect:  -1, Actual: " + search(dict, target));

		dict = new Dict(new int[] {1, 3});
		target =  3;
		System.out.println("Expect:  1, Actual: " + search(dict, target));

		dict = new Dict(new int[] {1, 3});
		target =  4;
		System.out.println("Expect:  -1, Actual: " + search(dict, target));

		dict = new Dict(new int[] {1, 3, 4, 4,6,10,11,12,15,15});
		target =  6;
		System.out.println("Expect: 4, Actual: " + search(dict, target));
	
		target =  15;
		System.out.println("Expect: 8, Actual: " + search(dict, target));

		dict = new Dict(largeArray(100000));
		target =  99999;
		System.out.println("Expect: 99999, Actual: " + search(dict, target));

		target =  100000 + 0;
		System.out.println("Expect: -1, Actual: " + search(dict, target));

	}

	private static int[] largeArray(int size) {
		// TODO Auto-generated method stub
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = i;
		}
		return arr;
	}

	public static int search(Dict dict, int target) {
		// Write your solution here
		if (dict == null || dict.get(0) == null) {
			return -1;
		}
		// if(dict.get(0) == target){
		// return 0;
		// }
		int left = 0;
		int right = 1;
		while (dict.get(right) != null && dict.get(right) < target) {
			left = right;
			right = right * 2;
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (dict.get(mid) == null || dict.get(mid) > target) {
				right = mid - 1;
			} else if (dict.get(mid) == target) {
				return mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	interface IDictionary{
		public Integer get(int index);
	}
	
	static class Dict implements IDictionary{
		private int[] arr;
		public Dict(int[] arr) {
			this.arr = arr;
		}
		@Override
		public Integer get(int index) {
			// TODO Auto-generated method stub
			if(arr == null || index >= arr.length) {
				return null;
			}
			return arr[index];
		}
		@Override
		public String toString() {
			if(arr == null) {
				return String.valueOf(null);
			}
			if(arr.length <= 10) {
				Arrays.toString(arr);
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 5; i++){
				sb.append(arr[i]).append(", ");
			}
			sb.append("......, ");
			for(int i = arr.length - 4; i < arr.length; i++) {
				sb.append(arr[i]);
				if(i != arr.length - 1) {
					sb.append(", ");
				}
			}
			sb.append("]");
			return sb.toString();
		}
		

	}
}
