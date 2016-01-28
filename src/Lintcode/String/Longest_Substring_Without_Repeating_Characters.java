package Lintcode.String;

import java.util.HashSet;

/**
Longest Substring Without Repeating Characters Show result 

Given a string, find the length of the longest substring without repeating characters.

Have you met this question in a real interview? Yes
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

Challenge
O(n) time

Tags Expand 
String Two Pointers Hash Table


Related Problems Expand 
Medium Longest Substring with At Most K Distinct Characters *
 */
public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// TC is O(n)
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        int slow = 0; 
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (set.contains(ch)) {
                while (s.charAt(slow) != ch) {
                    set.remove(s.charAt(slow));
                    slow ++;
                }
                slow ++;
            } else {
                set.add(s.charAt(fast));
            }
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }


	
}
