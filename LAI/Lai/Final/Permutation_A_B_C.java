package Lai.Final;

import static Utils.ArrayUtils.swap;
import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayList;
import java.util.List;

import Lai.Midterm_I_II_III.permu;

public class Permutation_A_B_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StringBuilder sb = new StringBuilder();
//		sb.append("ladjfoeij");
//		sb.deleteCharAt(sb.length() - 1);
//		sb.deleteCharAt(sb.length() - 1);
//		System.out.println("sb:"+sb);
		String str = "ABC";
		System.out.println("" + permute(str));
	}
	private static List<String> permute(String str) {
		List<String> result = new ArrayList<>();
		char[] arr1 = str.toCharArray();
		char[] arr2 = new char[ 2 * arr1.length - 1];
		for(int i = 0; i < arr2.length; i ++) {
			if(i % 2 == 0) {
				arr2[i] = arr1[ i / 2 ];	
			}else {
				arr2[i] = '_';
			}			
		}
		permute(result, arr2,  0);
		return result;
	}

	private static void permute(List<String> result, char[] arr,  int pos) {
		if(pos > arr.length ) {
			result.add(String.valueOf(arr));
			return;
		}
		for(int i = pos; i < arr.length; i += 2) {
			swap(arr, pos, i);
			permute(result, arr, pos + 2);
			swap(arr,  pos, i);
		}
	}
	
	
	
	
	private static List<String> permute_00(String str) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		permute(result, sb, arr, str, 0);
		return result;
	}

	private static void permute(List<String> result, StringBuilder sb, char[] arr, String str, int pos) {
		if (pos == str.length()) {
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(""+sb.toString());
			result.add(sb.toString());
			sb.append('_');
//			result.add(String.valueOf(arr));
			return;
		}
		for (int i = pos; i < str.length(); i++) {
			swap(arr, pos, i);
			sb.append(arr[pos]);
			sb.append('_');
			permute(result, sb, arr, str, pos + 1);
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			swap(arr, pos, i);
		}

//		for(int i = pos; i < str.length(); i++) {
//			sb.append(str.charAt(i));
//			sb.append('_');
//			permute(result, sb, str, pos + 1);
//			sb.deleteCharAt(sb.length() - 1);
//			sb.deleteCharAt(sb.length() - 1);
//		}

	}

}
