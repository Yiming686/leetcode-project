package Lai.DFS_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class All_Valid_Permutaion_Of_Parentheses_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] arr = new char[8];
//		
//		arr[0] = 'P';
//		arr[1] = 'P';
//		arr[3] = 'P';
//		arr[6] = 'P';
//		System.out.printf(">%s< >%d<\n",String.valueOf(arr).trim(), String.valueOf(arr).trim().length());
//		
//		Object object = arr;
//		System.out.printf(">%s< >%d<\n",String.valueOf(object).trim(), String.valueOf(object).trim().length());		
//		
//		String para = String.valueOf(arr).trim();
				
		System.out.println(""+validParenthese(3));
	}

	public static List<String> validParenthese(int n){
		List<String> result = new ArrayList<>();
		char[] arr = new char[2*n];
		
		TP paraRoot = TP.build("[sb:level]",  "01111", null, result, String.valueOf(arr, 0, 0), 0, n, n);
		helper(result, arr, 0, n, n, paraRoot);
		paraRoot.print();
		return result;
	}
	 static void helper(List<String> result, char[] arr, int index, int left, int right, TP paraRoot) {
		 if(index == arr.length) {
			 result.add(String.valueOf(arr));
			 return;
		 }
		 if(left > 0) {
			 arr[index] = '(';
			 helper(result, arr, index + 1, left - 1, right, TP.build(paraRoot, result, String.valueOf(arr, 0, index + 1), index + 1, left - 1, right));
		 }
		 if(right > left) {
			 arr[index] = ')';
			 helper(result, arr, index + 1, left, right - 1, TP.build(paraRoot, result, String.valueOf(arr, 0, index + 1), index + 1, left, right - 1));
		 }
		 
	 }
	
	
}
