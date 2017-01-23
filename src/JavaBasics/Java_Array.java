package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LeetCode.ArrayPrinter;

public class Java_Array {
//    public static void findString(String... a) {
//    	  for(String s : a){
//    		  System.out.println(s);
//    	  }
//    }
	public static void main(String[] args) {
//		findString("11111","222222");
		int[] intArray = { 0, 1,1, 2,1,1, 10 };
		int[] intArray2 = { 1,1, 2, 3, 4, 5 };
		List<Integer> comm = new ArrayList<Integer>();
		for(int i =0, j=0; i<intArray.length && j < intArray2.length;){
			int val1 = intArray[i];
			int val2 = intArray2[j];
			if(val1 == val2){
				comm.add(val1);
				i++;
				j++;
			}else if(val1 < val2){
				i++;
			}else{
				j++;
			}
		}
		System.out.println(""+comm);
        if( 1 == 1)return;

		
		// Apache Commons Lang library
//		int[] combinedIntArray = (intArray, intArray2);
		Map<String, int[]> map = new HashMap<String, int[]>();
		map.put("1", new int[]{1});
		map.put("2", new int[]{2});
		System.out.println(map.get("2")[0]);
		
		System.out.println("------------------");
		Integer[] arr = {8,2,6,4};
		Integer[] arr1 = {8,2,6,4,9};
		Integer[] arr2 = {8,2,6,4};
		Integer[] arr3 = {8,2,6,4};
		List<Integer[]> list =
				Arrays.asList(arr1, arr2, arr3);
		List<Integer> list5 =
				Arrays.asList(arr1);
		List<Integer> arrayList = Arrays.asList(arr1);
		boolean b = Arrays.asList(arr1).contains(2);
		
		System.out.println(b);
		
		System.out.println(list5);
		List<Integer> list2 = Arrays.asList(4,5,6);

		System.out.println(Arrays.toString(arr));
		ArrayPrinter.printIntegerArray(arr);
		Arrays.sort(arr);
		ArrayPrinter.printIntegerArray(arr);
		System.out.println(Arrays.binarySearch(arr, 1));
		System.out.println(Arrays.binarySearch(arr, 2));
		System.out.println(Arrays.binarySearch(arr, 3));
		System.out.println(Arrays.binarySearch(arr, 4));
		System.out.println(Arrays.binarySearch(arr, 5));
		System.out.println(Arrays.binarySearch(arr, 6));
		System.out.println(Arrays.binarySearch(arr, -2));
		System.out.println(Arrays.binarySearch(arr, -5));
		System.out.println(Arrays.binarySearch(arr, 11));
		System.out.println(Arrays.binarySearch(arr, 22));
	}
}
