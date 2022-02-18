package Lai.HashTable_String_I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.ArrayUtils;

public class Common_Numbers_Of_Two_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = ArrayUtils.convertStr2IntArr("abc");
		int[] arr1 = ArrayUtils.convertStr2IntArr("122223445");  
		int[] arr2 = ArrayUtils.convertStr2IntArr("22233444555");
		System.out.println("common: "+findCommon(arr1, arr2));
	}

//	HashMap, TC is O(N), SC is O(N)
	private static List<Integer> findCommon(int[] arr1, int[] arr2) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for(int key : arr1) {
			Integer val = map1.get(key);
			if(val == null) {
				map1.put(key, 1);
			}else {
				map1.put(key, val + 1);
			}
		}
		for(int key : arr2) {
			Integer val = map2.get(key);
			if(val == null) {
				map2.put(key, 1);
			}else {
				map2.put(key, val + 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			Integer key1 = entry.getKey();
			Integer val1 = entry.getValue();
			Integer val2 = map2.get(key1);
			if(val2 != null) {
				Integer comm = Math.min(val1, val2);
				for(int i = 0; i < comm; i++) {
					result.add(key1);
				}
			}
		}
		return result;
	}	
	
// two pointers, TC is O(m+n), SC is O(1)
	private static List<Integer> findCommon00(int[] arr1, int[] arr2) {
		List<Integer> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while (i1 < arr1.length && i2 < arr2.length) {
			if (arr1[i1] == arr2[i2]) {
				result.add(arr1[i1]);
				i1++;
				i2++;
			} else if (arr1[i1] < arr2[i2]) {
				i1++;
			} else {
				i2++;
			}
		}
		result.toArray(new Integer[0]);
		return result;
	}
	
	public static List<Integer> common(List<Integer> A, List<Integer> B) {
		// Write your solution here
		int[] arr1 = new int[A.size()];
		int[] arr2 = new int[B.size()];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = A.get(i);
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = B.get(i);
		}
		return findCommon00(arr1, arr2);
	}

}
