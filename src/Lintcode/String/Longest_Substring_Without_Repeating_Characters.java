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
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        int left = 0; 
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            if (set.contains(rightChar)) {
            	char leftChar = str.charAt(left);
                while (leftChar != rightChar) {
                    set.remove(leftChar);
                    left ++;
                    leftChar = str.charAt(left);
                }
                left ++;
            } else {
                set.add(rightChar);
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


	
}
