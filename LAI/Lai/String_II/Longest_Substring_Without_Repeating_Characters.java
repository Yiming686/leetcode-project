package Lai.String_II;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the longest substring without any repeating characters
 * and return the length of it. The input string is guaranteed to be not null.
 * 
 * For example, the longest substring without repeating letters for "bcdfbd" is
 * "bcdf", we should return 4 in this case.
 *
 * 
 */
public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longest(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return 0;
		}
		int max = 0;
		int left = 0;
		int right = 0;
		Set<Character> set = new HashSet<>();
		while (right < input.length()) {
			if (!set.contains(input.charAt(right))) {
				set.add(input.charAt(right++));
				// max = Math.max(max, set.size());
				max = Math.max(max, right - left);
			} else {
				set.remove(input.charAt(left++));
			}
		}
		return max;
	}

	public int longest00(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return 0;
		}
		int left = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		for (int right = 0; right < input.length(); right++) {
			if (!set.contains(input.charAt(right))) {
				set.add(input.charAt(right));
				max = Math.max(max, set.size());
			} else {
				while (input.charAt(left) != input.charAt(right)) {
					set.remove(input.charAt(left));
					left++;
				}
				left++;
			}
		}
		return max;
	}

}
