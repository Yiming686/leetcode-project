package Leet.String.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class Leet_1249_Minimum_Remove_to_Make_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "))((";
//		String str = "())()(((";
		String str = "())()(((";
		System.out.println("str: " + str);
		System.out.println("" + minRemoveToMakeValid(str));
	}

//  Time: O(N), Space: O(N), Great solution, very like minAddToMakeValid
	public static String minRemoveToMakeValid(String str) {
		// int minAdd = minAddToMakeValid(str);
		List<Integer> list = new ArrayList<>();
		char[] arr = str.toCharArray();
		int left = 0;
		int right = 0;
		for (int i = 0; i < arr.length; i++) {//sliding window, for each arr[i]
			char ch = arr[i];
			if (ch != '(' && ch != ')') {
				continue;
			}
			if (ch == '(') {
				left++;
				list.add(i);
			} else {
				right++;
				if (right > left) {//right == left + 1
					arr[i] = ' ';
					left = 0;
					right = 0;
				}
			}
			//here, make sure left >= right always
		}
		int count = left - right;
		for (int i = 0; i < count; i++) {
			arr[list.get(list.size() - 1 - i)] = ' ';
            // arr[list.get(i)] = ' ';//Wrong, must delete ( from last to first
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ') {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}

	//  Time: O(N), Space: O(1), Great solution, easy to explain
	public static int minAddToMakeValid(String str) {
		// public int minAddToMakeValid_(String s) {
		int sec = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
			} else {
				right++;
				if (right > left) {//绝对是无效点：可能是有效后的一个，也可能是无效后的一个    
					sec++; //一个sec，配一个（，
					left = 0;
					right = 0;
				}
			}
			//here, make sure left >= right always
		}
		return sec + left - right;
	}

}
