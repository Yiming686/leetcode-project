package Lai.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 */
public class Leet_139_Word_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bb";
		List<String> dict = new ArrayList<String>();
		dict.add("a");
		dict.add("b");
		dict.add("bbb");
		dict.add("bbbb");
		System.out.println(""+wordBreak(s, dict));
//		System.out.println(""+wordBreak_00(s, dict));
	}

	private static String[][] substrings(String s) {
		int len = s.length();
		String[][] substrings = new String[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				substrings[i][j] = s.substring(i, j + 1);
				;
			}
		}
		return substrings;
	}

	private static int maxLen(List<String> dict) {
		int max = 0;
		for (String word : dict) {
			max = Math.max(max, word.length());
		}
		return max;
	}

	public static boolean wordBreak(String s, List<String> dict) {
		// worked, 左大段+右小段
		// public boolean wordBreak_00(String s, List<String> dict) {        
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return false;
		}
		String[][] substrings = substrings(s);
		Set<String> distSet = new HashSet<>(dict);
		int maxLen = maxLen(dict);
		int len = s.length();
		boolean[] canBreak = new boolean[len + 1];//from 0 , 1, s.length - 1
		canBreak[0] = true;
		for (int i = 1; i <= len; i++) {//len i, 从小到达填表
			// for(int j = 1; j <= i; j++){//len j 
			for (int j = i - maxLen + 1; j >= 1 && j <= i; j++) {//len j 1： maxLen, [i-maxLen, i] 最后单词的起始位置，长度计算
				// for(int j = 1; j <= maxLen; j++){//len j 1： maxLen, [i-maxLen, i]                
				// if(canBreak[i-j] && dict.contains(s.substring(i - j, i)) ){
				if (canBreak[j - 1] && distSet.contains(substrings[j - 1][i - 1])) { //5 3 8, [5,6,7]                    
					// if(i - j >= 0 && canBreak[i-j] && distSet.contains(substrings[i - j][i-1]) ){ //5 3 8, [5,6,7]           
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[len];
	}
	
	public static boolean wordBreak_00(String s, List<String> dict) {
		// worked, 左大段+右小段
		// public boolean wordBreak_00(String s, List<String> dict) {        
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return false;
		}
		String[][] substrings = substrings(s);
		Set<String> distSet = new HashSet<>(dict);
		int maxLen = maxLen(dict);
		int len = s.length();
		boolean[] canBreak = new boolean[len + 1];//from 0 , 1, s.length - 1
		canBreak[0] = true;
		for (int i = 1; i <= len; i++) {//len i, 从小到达填表
			// for(int j = 1; j <= i; j++){//len j 
//			for (int j = i - maxLen + 1; j >= 1 && j <= i; j++) {//len j 1： maxLen, [i-maxLen, i] 最后单词的起始位置，长度计算
			for(int j = 1; j <= maxLen; j++){//len j 1： maxLen, [i-maxLen, i]                
				// if(canBreak[i-j] && dict.contains(s.substring(i - j, i)) ){
//				if (canBreak[j - 1] && distSet.contains(substrings[j - 1][i - 1])) { //5 3 8, [5,6,7]                    
					if(i - j >= 0 && canBreak[i-j] && distSet.contains(substrings[i - j][i-1]) ){ //5 3 8, [5,6,7]           
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[len];
	}

}
