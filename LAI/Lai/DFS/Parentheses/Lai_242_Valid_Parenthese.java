package Lai.DFS.Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order.

Examples

"()" and "()[]{}", "[{()}()]" are all valid but "(]" and "([)]" are not.


 *
 */
public class Lai_242_Valid_Parenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValid(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return true;
		}
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (!map.containsKey(ch)) {//{[(
				stack.offerFirst(ch);
			} else {//}])
				if (!stack.isEmpty() && stack.peekFirst() == map.get(ch)) {
					stack.pollFirst();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
