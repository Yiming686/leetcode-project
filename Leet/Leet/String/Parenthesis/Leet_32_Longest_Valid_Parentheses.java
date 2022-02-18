package Leet.String.Parenthesis;

import static Utils.ArrayUtils.convertInt2IntArr;

import java.util.Stack;

import Utils.SU;

public class Leet_32_Longest_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("123. Best Time to Buy and Sell Stock III");
//		String str = "()()";
		String str = "))()(()()))";
		System.out.println("" + longestValidParentheses(str));
		String str2 = "  ) )a ( b ) (  c( )(d )+  -) )  ";
		System.out.println("" + longestValidParentheses2(str2));
	}

	//  Time: O(N), Space: O(1)
//	public static int longestValidParentheses(String s) {
	public int longestValidParentheses_N_1(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
			// else{
			//     maxlength = Math.max(maxlength, 2 * right);
			// }
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return maxlength;
	}

//	还是对stack的物理意义没有完全明白！一旦出现匹配，如果匹配的左右都删除，那么需要知道先前最远的不可匹配的位置，
//	当前可以匹配的位置 - 先前不可匹配的位置 == 当前的可以匹配的最长的长度
//	给定一个字符串，依次扫描，回头查找满足条件的最长的字符串，或字符串的长度
	public static int longestValidParentheses(String str) {
//	public static int longestValidParentheses_N_N_best(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);//先前最远的不可匹配的位置，
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				stack.push(i);//不进行匹配，那么它就是先前最远的不可匹配的位置，
			} else {
				stack.pop();//闭起眼睛，匹配先前不可匹配的字符，
				if (stack.empty()) {
					stack.push(i);//如果栈为空，说明其实没有什么可以进行匹配的，所以当前就是新的最近的不可匹配的位置
				} else {
					max = Math.max(i - stack.peek(), max);
				}
			}
		}
		return max;
	}

	// follow up 1:  ignore, chars that are spaces
	public static int longestValidParentheses2(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);//先前最远的不可匹配的位置，
		int i = -1;
//        for(int i = 0;i < str.length();i++){
		for (int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			if (ch == ' ') {
				continue;
			} else {
				i++;
			}
			if (ch == '(') {
				stack.push(i);//不进行匹配，那么它就是先前最远的不可匹配的位置，
			} else {
				stack.pop();//闭起眼睛，匹配先前不可匹配的字符，
				if (stack.empty()) {
					stack.push(i);//如果栈为空，说明其实没有什么可以进行匹配的，所以当前就是新的最近的不可匹配的位置
				} else {
					//如果栈不为空，说明有可以进行匹配的，并且匹配完成，那么匹配的字符串长度为 i-stack.peek()
					if (i - stack.peek() > max) {
						System.out.printf("start:end %d:%d \n", stack.peek() + 1, i);
					}
					max = Math.max(i - stack.peek(), max);
				}
			}
		}
		return max;
	}

// follow up 2:  ignore, chars that are not ( or )
	public static int longestValidParentheses3(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);//先前最远的不可匹配的位置，
		int i = -1;
//        for(int i = 0;i < str.length();i++){
		for (int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			if (ch != '(' && ch != ')') {
				continue;
			} else {
				i++;
			}
			if (ch == '(') {
				stack.push(i);//不进行匹配，那么它就是先前最远的不可匹配的位置，
			} else {
				stack.pop();//闭起眼睛，匹配先前不可匹配的字符，
				if (stack.empty()) {
					stack.push(i);//如果栈为空，说明其实没有什么可以进行匹配的，所以当前就是新的最近的不可匹配的位置
				} else {
					//如果栈不为空，说明有可以进行匹配的，并且匹配完成，那么匹配的字符串长度为 i-stack.peek()
					if (i - stack.peek() > max) {
						System.out.printf("start:end %d:%d \n", stack.peek() + 1, i);
					}
					max = Math.max(i - stack.peek(), max);
				}
			}
		}
		return max;
	}

}
