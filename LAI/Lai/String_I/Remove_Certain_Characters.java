package Lai.String_I;

import java.util.HashSet;
import java.util.Set;

public class Remove_Certain_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String remove(String input, String t) {
		// Write your solution here
		Set<Character> set = new HashSet<>();
		int len = t.length();
		for (int i = 0; i < len; i++) {
			set.add(t.charAt(i));
		}
		char[] arr = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (!set.contains(arr[fast])) {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}

	public static String remove00(String input, String t) {
		// Write your solution here
		Set<Character> set = new HashSet<>();
		int len = t.length();
		for (int i = 0; i < len; i++) {
			set.add(t.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (!set.contains(input.charAt(i))) {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}

}
