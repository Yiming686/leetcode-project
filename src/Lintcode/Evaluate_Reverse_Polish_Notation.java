package Lintcode;

import java.util.Stack;

/**
 * 
Evaluate Reverse Polish Notation

 Description
 Notes
 Testcase
 Judge
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Have you met this question in a real interview? Yes
Example
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
Tags 
LinkedIn Stack
Related Problems 
Hard Convert Expression to Reverse Polish Notation 25 %

 *
 */

public class Evaluate_Reverse_Polish_Notation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// worked, best, easy to understand
	public static int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		String operators = "+-*/";
		for (String token : tokens) {
			if (!operators.contains(token)) {
				s.push(Integer.valueOf(token));
			} else {
				int b = s.pop();
				int a = s.pop();

				switch (token) {
				case "+":
					s.push(a + b);
					break;
				case "-":
					s.push(a - b);
					break;
				case "*":
					s.push(a * b);
					break;
				case "/":
					s.push(a / b);
					break;
				default:
					;
				}
			}
		}
		return s.pop();
	}

}
