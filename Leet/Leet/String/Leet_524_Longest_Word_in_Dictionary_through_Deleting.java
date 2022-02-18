package Leet.String;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1: Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: "apple" Example 2: Input: s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: "a" Note: All the strings in the input will only contain lower-case
 * letters. The size of the dictionary won't exceed 1,000. The length of all the
 * strings in the input won't exceed 1,000.
 *
 * 
 */
public class Leet_524_Longest_Word_in_Dictionary_through_Deleting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abpcplea";
		String str = "apllea";
		String[] arr = { "ale", "apple", "monkey", "plea" };
//		String str = "abpcplea";
//		String[] arr = {"a","b","c"};
		List<String> dict = new ArrayList<String>();
		dict = Arrays.asList(arr);
		System.out.println("" + findLongestWord(str, dict));
	}

//	worked
	public static String findLongestWord_00(String str, List<String> dict) {
		int lenOfStr = str.length();
		String longestStr = null;
		for (String word : dict) {
//    		longer and smaller by lexicographical
			if (word == null) {
				continue;
			}
			int lenOfWord = word.length();
			if (canMatch(str, word, lenOfStr, lenOfWord) && (longestStr == null || lenOfWord > longestStr.length()
					|| (lenOfWord == longestStr.length() && word.compareTo(longestStr) < 0))) {
				longestStr = word;
			}
		}
		return longestStr == null ? "" : longestStr;
	}

	public static String findLongestWord(String str, List<String> dict) {
		int lenOfStr = str.length();
		String longestStr = null;
		for (String word : dict) {
//    		longer and smaller by lexicographical
			if (word == null) {
				continue;
			}
			int lenOfWord = word.length();
			if (canMatch(str, word, lenOfStr, lenOfWord)) {
				if (longestStr == null) {
					longestStr = word;
				} else if (lenOfWord > longestStr.length()) {
					longestStr = word;
				} else if (lenOfWord == longestStr.length() && word.compareTo(longestStr) < 0) {
					longestStr = word;
				}
			}
		}
		return longestStr == null ? "" : longestStr;
	}

	private static boolean canMatch(String str, String word, int lenOfStr, int lenOfWord) {
		int j = 0;
		for (int i = 0; i < lenOfStr && j < lenOfWord; i++, j++) {
			if (str.charAt(i) != word.charAt(j)) {
				j--;
			}
		}
		return j == lenOfWord;
	}

}
