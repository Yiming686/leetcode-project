package Leet.String.Parenthesis;

import static Utils.ArrayUtils.toStr;
import static Utils.TreeNodeUtils.BINARY_TREE_BACK_SLASH_BACK_SLASH_NEW;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet_11021_Remove_Outermost_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "(()())"; 
//		String str = "()(())()";
//		String str = "(()())(())";
		String str = "(()())(())(()(()))";
		String SPLITER = "_";
		System.out.println("     str: " + SPLITER + str + SPLITER);
		System.out.println("reversed: " + SPLITER + removeOuterParentheses(str) + SPLITER);

	}

	public static String removeOuterParentheses(String str) {
		// public String removeOuterParentheses_N_1_best(String str) {        
		StringBuilder sb = new StringBuilder();
		int left = 0, right = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
				if (left != 1) {
					sb.append('(');//add except the first, left == 1
				}
			} else {
				right++;
				//left == righ or left > right
				if (right == left) {
					// sb.append(str.substring(i - 2 * left + 2, i));
					left = 0;
					right = 0;
				} else {
					sb.append(')');//add when left != right
				}
			}
		}
		return sb.toString();
	}

	public static String removeOuterParentheses00(String str) {
		// public String removeOuterParentheses_N_1(String str) {        
		StringBuilder sb = new StringBuilder();
		int left = 0, right = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
			} else {
				right++;
				//left == righ or left > right
				if (right == left) {    
					sb.append(str.substring(i - 2 * left + 2, i));
					left = 0;
					right = 0;
				}
			}
		}
		return sb.toString();
	}

//    public static String removeOuterParentheses(String str) {
	public String removeOuterParentheses_N_N(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '(') {
				stack.push(i);// index where char is (
			} else {
				int left = stack.pop();
				if (stack.isEmpty()) {//left+1, i-1
					sb.append(String.valueOf(arr, left + 1, i - left - 1));
				}
			}
		}
		return sb.toString();
	}

}
