package Leet.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Utils.SU;

public class Leet_1048_Longest_String_Chain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("720. Longest Word in Dictionary\n" + 
				"");
		String word = "dhcu";
		for (int i = 0; i < word.length(); ++i) {//O(len^2)
			String prev = word.substring(0, i) + word.substring(i + 1);
			System.out.println("prev: " + prev);
//			best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
		}

		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		System.out.println("" + longestStrChain(words));

	}

//	map: word and its longest chain before itself
//	遍历每一个单词，需要的状态是什么，如果把这个单词的所有predecessor都找出来，那么pre的最长链的长度是多少，
//	如果存在, +1;如果不存在, 千万不能加到，map中去，
	public static int longestStrChain(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int global = 0;
		for (String word : words) {//O(N)
			int local = 0;
			for (int i = 0; i < word.length(); ++i) {//O(len^2)
				String prev = word.substring(0, i) + word.substring(i + 1);
				local = Math.max(local, map.getOrDefault(prev, 0) + 1);
			}
			map.put(word, local);
			global = Math.max(global, local);
		}
		return global;
	}

}
