package Leet.String.Parenthesis;

import static Utils.ArrayUtils.toStr;
import static Utils.StringUtils.toStr;

public class Leet_1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(()())"; 
//		String str = "()(())()";
		String SPLITER = "_";
		System.out.println("     str: " + SPLITER + str + SPLITER);
		System.out.println("reversed: " + SPLITER + toStr(maxDepthAfterSplit(str)) + SPLITER);

	}

	public static int[] maxDepthAfterSplit(String str) {
		char[] arr = str.toCharArray();
		int[] result = new int[arr.length];
		int left = 0;
		int right = 0;
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '(') {
				result[i] = left;
//				right = left;
				left = 1 - left;
			} else {
				result[i] = right;
//				left = right;
				right = 1 - right;
			}
		}
		return result;
	}

}
