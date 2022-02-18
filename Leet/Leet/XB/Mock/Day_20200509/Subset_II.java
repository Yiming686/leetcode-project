package Leet.XB.Mock.Day_20200509;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subset_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> result = subSetsII("abc");
//		List<String> result = subSets("abc");
		System.out.println(result);
//		System.out.println(subSets("abb"));
	}

	public static List<String> subSetsII(String str) {
		// Write your solution here.
		List<String> result = new ArrayList<>();
		if (str == null) {
			return result;
		}
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
//		List<Character> list = new LinkedList<Character>();
//		helper(result, list, arr, 0);
		helper(result, sb, arr, 0);
		return result;
	}

	static void helper(List<String> result, List<Character> list, char[] arr, int index) {		
//		if (index == arr.length) {
			result.add(list.toString());
//			return;
//		}
		for(int i = index; i < arr.length; i++) {
			list.add(arr[index]);
			helper(result, list, arr, index + 1);
			list.remove(list.size() - 1);
		}
	}

	public static List<String> subSets(String str) {
		// Write your solution here.
		List<String> result = new ArrayList<>();
		if (str == null) {
			return result;
		}
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		result.add("");
		helper(result, sb, arr, 0);
		return result;
	}

	static void helper(List<String> result, StringBuilder sb, char[] arr, int index) {	
		if(index == arr.length) {
			result.add(sb.toString());
			return;
		}
		
		for(int i = index; i < arr.length; i++) {
			sb.append(arr[index]);			
			helper(result, sb, arr, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
//	static void helper(List<String> result, StringBuilder sb, char[] arr, int index) {
//		if (index == arr.length) {
//			result.add(sb.toString());
//			return;
//		}
//
//		sb.append(arr[index]);
//		helper(result, sb, arr, index + 1);
//		sb.deleteCharAt(sb.length() - 1);
//		while (index + 1 < arr.length && arr[index] == arr[index + 1]) {
//			index++;
//		}
//		helper(result, sb, arr, index + 1);
//
//	}
}
