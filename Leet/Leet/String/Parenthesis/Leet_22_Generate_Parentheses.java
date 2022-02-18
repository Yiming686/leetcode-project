package Leet.String.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class Leet_22_Generate_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		generateParenthesis(result, sb, n, n);
		return result;
	}

	public void generateParenthesis(List<String> result, StringBuilder sb, int left, int right) {

		if (left == 0 && right == 0) {
			result.add(sb.toString());
			return;
		}
		if (left > right || left < 0 || right < 0) {
			return;
		}
		generateParenthesis(result, sb.append("("), left - 1, right);
        sb.delete(sb.length() - 1, sb.length());
		generateParenthesis(result, sb.append(")"), left, right - 1);
        sb.delete(sb.length() - 1, sb.length());
	}

}
