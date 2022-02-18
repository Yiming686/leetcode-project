package Leet.String.Parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leet_1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "(abcd)";
//		String str = "(u(love)i)";
//		String str = "(ed(et(oc))el)";
		String str = "a(bcdefghijkl(mno)p)q";// "a(bcdefghijkl(mno)p)q"
		String SPLITER = "_";
		System.out.println("     str: " + SPLITER + str + SPLITER);
		System.out.println("reversed: " + SPLITER + reverseParentheses(str) + SPLITER);
	}

	public static String reverseParentheses(String str) {
		if (str == null || str.length() == 0)
			return str;
		char[] arr = str.toCharArray();
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(i);//记录上一次(位置
			} else if (arr[i] == ')') {
//				reverse(arr, index.pop() + 1, i - 1);//翻转不包括()
				reverse(arr, stack.pop(), i );//翻转不包括()
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : arr) {
//			if (Character.isLetter(c)) {
	        if (ch != '(' && ch != ')') {                
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	private static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

//	public static String reverseParentheses(String str) {
	public static String reverseParentheses_by_me(String str) {
		char[] arr = str.toCharArray();
		Deque<String> stack = new ArrayDeque<>();
		int prev = -1;
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '(') {
				if (prev != i - 1) { //not start With "("
					stack.push(String.valueOf(arr, prev + 1, i - prev - 1));
				}
				prev = i;
				stack.push("" + ch);
			} else if (ch == ')') {
				StringBuilder sb = new StringBuilder();
				if (prev != i - 1) {//not ()
					String curr = String.valueOf(arr, prev + 1, i - prev - 1);
					sb.insert(0, curr);
				}
				while (!stack.peek().equals("(")) {
					sb.insert(0, stack.pop());
				}
				stack.pop();//pop (
				stack.push(sb.reverse().toString());

				prev = i;
			} else {
				//do nothing
			}
		}
		return stack.peek();
	}

}
