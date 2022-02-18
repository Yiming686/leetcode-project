package Leet.String;

import Utils.SU;

public class Rerverse_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("1048. Longest String Chain");
		
		
		String str = "12345";
//		String str = "123456";
//		String str = "";
//		              32154 
//		String str = "10002552551";
//		String str = "0000";
		System.out.println(""+reverse(str));
	}

	private static String reverse(String str) {
		// TODO Auto-generated method stub
		char[] arr = str.toCharArray();
		return reverse(arr, 0, arr.length - 1);
	}

	private static String reverse(char[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end) {
			return "_";
		}
		if(start == end) {
			return "" + arr[start];
		}
		StringBuilder sb = new StringBuilder();
		int mid = start + (end - start) / 2;
		String left = reverse(arr, start, mid);
		String right = reverse(arr, mid + 1, end);
		sb.append(right).append(left);
		return sb.toString();
	}

}
