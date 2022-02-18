package Lai.DFS.Parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**

Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]



 *
 */
public class Lai_179_All_Valid_Permutations_Of_Parentheses_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<String> validParentheses(int l, int m, int n) {
		final char[] arr = new char[] { '(', ')', '<', '>', '{', '}' };
		int[] charLeft = new int[] { l, l, m, m, n, n };
		List<String> result = new ArrayList<>();
		int len = 2 * (l + m + n);
		StringBuilder sb = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		helper(result, sb, len, stack, arr, charLeft);
		return result;

	}

	//len个位置，每个位置尝试arr.length次
	private static void helper(List<String> result, StringBuilder sb, int len, Deque<Character> stack, char[] arr,
			int[] charLeft) {
		if (sb.length() == len) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {//左括号
				if (charLeft[i] > 0) {
					sb.append(arr[i]);
					stack.offerFirst(arr[i]);
					charLeft[i]--;
					helper(result, sb, len, stack, arr, charLeft);
					charLeft[i]++;
					stack.pollFirst();
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == arr[i - 1]) {//干什么呢? 看栈顶元素
					sb.append(arr[i]);
					stack.pollFirst(); // stack.offerFirst(arr[i]);
					charLeft[i]--;
					helper(result, sb, len, stack, arr, charLeft);
					charLeft[i]++;
					stack.offerFirst(arr[i - 1]);// stack.pollFirst();
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
	}

}
