package Lai.DP_II;

import static Utils.TreeNodeUtils.BINARY_TREE_BACK_SLASH_BACK_SLASH_DEFAULT_STRING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC140_Word_Break_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "catsanddog";
//		List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s = "aaaaaaaaaa";
		List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
				"aaaaaaaaa", "aaaaaaaaaa");
//		new ArrayList<>();
//		dict.add(e);
		System.out.println("" + wordBreak(s, dict));
	}

	public static List<String> wordBreak(String s, List<String> dict) {
		List<String> result = new ArrayList<>();
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
//		Map<Integer, List<String>> map = new HashMap<>();
		wordBreak(result, sb, arr, 0, dict);
		return result;
	}

	private static void wordBreak(List<String> result, StringBuilder sb, char[] arr, int pos, List<String> dict) {
//		if(map.containsKey(pos)) {
//			List<String> val = map.get(pos);
//			for(String str : val) {
//				result.add(sb.toString() + str);
//			}
//			return;
//		}
		if (pos > arr.length) {
			return;
		}
		if (pos == arr.length) {
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString() + "\n");
			sb.append(" ");
			return;
		}
		for (int i = pos; i < arr.length; i++) {
			String str = String.valueOf(arr, pos, i + 1 - pos);
			if (dict.contains(str)) {
				sb.append(str);
				sb.append(" ");
				wordBreak(result, sb, arr, pos + str.length(), dict);
				sb.delete(sb.length() - str.length() - 1, sb.length());
			}
		}
	}

//	dfs + memo solution,Runtime: 16 ms, faster than 6.08%
	public static List<String> wordBreak_dfs_memo(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null) {
			return res;
		}

		Map<String, List<String>> memo = new HashMap<>();
		return wordBreak_dfs_memo(s, wordDict, memo);

	}

	// dfs定义： 以last 为prefix的所有 符合条件的word
	private static List<String> wordBreak_dfs_memo(String s, List<String> dict, Map<String, List<String>> memo) {
		int n = s.length();
		// if (n == 0) {
		//     return new ArrayList<>();
		// }
		if (memo.containsKey(s)) {
			return memo.get(s);
		}
		List<String> res = new ArrayList<>();//仅仅针对当前str的0到len-1，也是memo的key为str，值为res
		if (dict.contains(s)) {
			res.add(s);
		}
		for (int i = 1; i <= n; i++) {//i为长度
			String prefix = s.substring(0, i);
			String s2 = s.substring(i);
			if (dict.contains(prefix)) {
				List<String> suffixs = wordBreak_dfs_memo(s2, dict, memo);
				for (String ss : suffixs) {
					res.add(prefix + " " + ss);
				}
			}
		}
		memo.put(s, res);
		return res;
	}

//	Leetcode Solution:
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return word_Break(s, wordDict, 0);
	}

	HashMap<Integer, List<String>> map = new HashMap<>();

	public List<String> word_Break(String s, Set<String> wordDict, int start) {
		if (map.containsKey(start)) {
			return map.get(start);
		}
		LinkedList<String> res = new LinkedList<>();
		if (start == s.length()) {
			res.add("");
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end))) {
				List<String> list = word_Break(s, wordDict, end);
				for (String l : list) {
					res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
				}
			}
		}
		map.put(start, res);
		return res;
	}

}
