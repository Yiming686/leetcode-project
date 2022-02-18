package Leet.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

import Utils.SU;

public class Leet_340_Longest_Substring_with_At_Most_K_Distinct_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("238. Product of Array Except Self\n" + 
				"");
		System.out.println(""+lengthOfLongestSubstringKDistinct("", 2));
		System.out.println(""+lengthOfLongestSubstringKDistinct("", 5));
	}

	public static int lengthOfLongestSubstringKDistinct(String str, int k) {
		Map<Character, Integer> map = new HashMap<>();;
		int slow = 0;
		int longest = 0;
		for (int fast = 0; fast < str.length(); fast++) {
			// add fast.
			char charAtFast  = str.charAt(fast);
			int countCharAtFast = map.getOrDefault(charAtFast, 0);
			map.put(charAtFast, countCharAtFast + 1);
			// find the slow.
			while (map.size() > k) {
				char charAtSlow  = str.charAt(slow);
				int countCharAtSlow = map.getOrDefault(charAtSlow, 0);
				if (countCharAtSlow == 1) {
					map.remove(charAtSlow);
				} else {
					map.put(charAtSlow, countCharAtSlow - 1);
				}
				slow++;
			}
			// update longest
			longest = Math.max(longest, fast - slow + 1);
		}
		return longest;
	}

}
