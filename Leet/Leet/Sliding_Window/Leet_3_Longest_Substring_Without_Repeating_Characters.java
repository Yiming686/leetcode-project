package Leet.Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class Leet_3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// public int lengthOfLongestSubstring(String input) {
	public int lengthOfLongestSubstring_set(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int longest = 0;
		int slow = 0;
		char[] arr = str.toCharArray();
		Set<Character> set = new HashSet<>();
		for (int fast = 0; fast < str.length(); fast++) {
//			char ch = str.charAt(fast);
			while (set.contains(arr[fast])) {
				set.remove(arr[slow]);
				slow++;
			}
			set.add(arr[fast]);
			longest = Math.max(longest, set.size());
		}
		return longest;
	}

}
