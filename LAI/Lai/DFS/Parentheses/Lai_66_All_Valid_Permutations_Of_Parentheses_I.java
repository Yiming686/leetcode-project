package Lai.DFS.Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
Given N pairs of parentheses ¡°()¡±, return a list with all the valid permutations.

Assumptions

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

 *
 */
public class Lai_66_All_Valid_Permutations_Of_Parentheses_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> validParentheses(int n) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(result, sb, n, n);
		return result;
	}

	private void helper(List<String> result, StringBuilder sb, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(sb.toString());
			return;
		}
		if (left > 0) {
			sb.append("(");
			helper(result, sb, left - 1, right);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (left < right) {
			sb.append(")");
			helper(result, sb, left, right - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
