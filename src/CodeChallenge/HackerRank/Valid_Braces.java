package CodeChallenge.HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Braces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr = {"{}[]()", "{[}]} "};
		System.out.println(""+Arrays.toString(braces(arr)));
	}

	static String[] braces(String[] values) {
		String[] results = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = checkValid(values[i]) ? "YES" : "NO";
		}
		return results;
	}

	static boolean checkValid(String str) {
		if (str == null) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		for (char each : str.toCharArray()) {
			if (each == '(' || each == '{' || each == '[') {
				stack.add(each);
			} else if (map.containsKey(each)) {
				if(stack.size()==0 || stack.peek()!=map.get(each)){
					return false;
				}else{
					stack.pop();
				}
			}
		}
		return stack.size()==0;
	}

}
