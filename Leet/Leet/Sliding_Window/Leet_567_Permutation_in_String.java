package Leet.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

import Utils.SU;

public class Leet_567_Permutation_in_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("340. Longest Substring with At Most K Distinct Characters\n" + 
				"");
	}

	public boolean minWindow_all(String source, String target) { //76. Minimum Window Substring
		if (target == null || target.length() == 0) {
			return false; //return "";
		}
		if (source == null || source.length() == 0) {
			return false; //return "";
		}
		int sourceLen = source.length();
		int targetLen = target.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < targetLen; i++) {
			char ch = target.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int matchCount = 0;// all chars in total
		int slow = 0;
		for (int fast = 0; fast < sourceLen; fast++) {
			//process char at fast
			char ch = source.charAt(fast);
			Integer count = map.get(ch);
			if (count != null) {
				if (count >= 1) { //if (count == 1) {
					matchCount++;
				}
				map.put(ch, count - 1);
			}
//            check sliding window
			if (matchCount == targetLen) {// if (matchCount == map.size()) {
				return true;
			}
			//process slow
			if (fast >= targetLen - 1) {
				ch = source.charAt(slow);
				count = map.get(ch);//old count
				if (count != null) {
					if (count >= 0) { //if (count == 0) {
						matchCount--;
					}
					map.put(ch, count + 1);
				}
				slow++;
			}
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate_bf(int[] nums, int k, int t) {
		if (nums == null || nums.length <= 1) {
			return false;
		}
		long longT = t;
		for (int i = 0; i < nums.length; ++i) {
			// for (int j = Math.max(i - k, 0); j < i; ++j) {
			for (int j = i - k; j < i; ++j) {
				if (j >= 0) {
					long longI = nums[i];
					long longJ = nums[j];
					if (Math.abs(longI - longJ) <= longT) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int lengthOfLongestSubstring(String str) {
		// public int lengthOfLongestSubstring_array(String s) {    
		int len = str.length();
		int longest = 0;
		int[] index = new int[256];
		int slow = 0;
		for (int fast = 0; fast < len; fast++) {
			slow = Math.max(index[str.charAt(fast)], slow);
			longest = Math.max(longest, fast - slow + 1);
			index[str.charAt(fast)] = fast + 1;
		}
		return longest;
	}

}
