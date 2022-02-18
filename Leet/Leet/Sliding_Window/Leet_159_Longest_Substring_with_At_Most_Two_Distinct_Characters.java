package Leet.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Leet_159_Longest_Substring_with_At_Most_Two_Distinct_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "eceba";// return 3;
		String str = "ccaabbb";// return 4;
		int k = 2;
		System.out.println(""+lengthOfLongestSubstringKDistinct99(str, k));
		System.out.println(""+lengthOfLongestSubstringKDistinct99(str.toCharArray(), k));
	}
	
    public static int lengthOfLongestSubstringKDistinct99(String str, int k) {
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
    
    public static int lengthOfLongestSubstringKDistinct99(char[] arr, int k) {
		Map<Character, Integer> map = new HashMap<>();;
		int slow = 0;
		int longest = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			// add fast.
			char charAtFast  = arr[fast];
			int countCharAtFast = map.getOrDefault(charAtFast, 0);
			map.put(charAtFast, countCharAtFast + 1);
			// find the slow.
			while (map.size() > k) {
				char charAtSlow  = arr[slow];
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
    
    public static int lengthOfLongestSubstringKDistinct99(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();;
		int slow = 0;
		int longest = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			// add fast.
			int charAtFast  = arr[fast];
			int countCharAtFast = map.getOrDefault(charAtFast, 0);
			map.put(charAtFast, countCharAtFast + 1);
			// find the slow.
			while (map.size() > k) {
				int charAtSlow  = arr[slow];
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
