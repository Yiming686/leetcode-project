package Leet.String.Expression_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:

The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.
Example 1:

Input: "T?2:3"

Output: "2"

Explanation: If true, then result is 2; otherwise result is 3.
Example 2:

Input: "F?1:T?4:5"

Output: "4"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
Example 3:

Input: "T?T?F:5:3"

Output: "F"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"

 *
 */
public class Leet_439_Ternary_Expression_Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	就是一个操作符，然后两个操作数，操作符决定如何得到数值，？：都是分隔符，？表明是父亲，：表明是孩子，所以给定表达式就给定exp tree了
//	所以给定的就是：exp tree的前序遍历，所以计算的时候需要从右到左扫描
	public String parseTernary(String exp) {
//	public String parseTernary_by1(String exp) {
		if (exp == null || exp.length() == 0) {
			return exp;
		}
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = exp.length() - 1; i >= 0; i--) {
			if (exp.charAt(i) == '?') {
				char val1 = stack.pop();
				char val2 = stack.pop();
				stack.push((exp.charAt(--i) == 'T') ? val1 : val2);
			} else if (exp.charAt(i) == ':') {
				//do nothing
			} else {
				stack.push(exp.charAt(i));
			}
		}
		return String.valueOf(stack.pop());
	}
	
//	IF all saved as strings
	public String parseTernary(String[] exp) {
//		public String parseTernary_by1(String exp) {
			if (exp == null || exp.length == 0) {
				return null;
			}
			Deque<String> stack = new ArrayDeque<>();
			for (int i = exp.length - 1; i >= 0; i--) {
				if ("?".equalsIgnoreCase(exp[i])) {
					String val1 = stack.pop();
					String val2 = stack.pop();
					stack.push("true".equalsIgnoreCase(exp[i]) ? val1 : val2);
				} else if (":".equalsIgnoreCase(exp[i])) {
					//do nothing
				} else {
					stack.push(exp[i]);
				}
			}
			return String.valueOf(stack.pop());
		}

}
