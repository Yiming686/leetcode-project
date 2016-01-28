package Lintcode.String;

import java.util.HashMap;
import java.util.Map;

/**
Longest Substring with At Most K Distinct Characters

Given a string s, find the length of the longest substring T that contains at most k distinct characters.

Have you met this question in a real interview? Yes
Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge
O(n), n is the size of the string s.

Tags Expand 
String Two Pointers LintCode Copyright Hash Table


Related Problems Expand 
Medium Longest Substring Without Repeating Characters *
 */


public class Longest_Substring_with_At_Most_K_Distinct_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
   		int slow = 0;
		int maxLen = 0;

		// Key: letter; value: the number of occurrences.
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int fast = 0; fast < s.length(); ++fast) {
			char c = s.charAt(fast);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
				//这一段是什么意思？
				while (map.size() > k) {
					char slowChar = s.charAt(slow++);
					int count = map.get(slowChar);
					if (count > 1) {
						map.put(slowChar, count - 1);
					} else {
						map.remove(slowChar);
					}
				}
			}
			//放在那里很重要，每次都要udate，前提要维护map的size小等于k
            //所以当map的size 可能增大时，就要检测维护			
			maxLen = Math.max(maxLen, fast - slow + 1);
		}

		return maxLen;
	} 

	
}
