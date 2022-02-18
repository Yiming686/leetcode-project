package Leet.OA.Juniper_Networks;

import static Utils.TreeNodeUtils.SPACE_CHAR;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

import Utils.ArrayUtils;

/**
 * Given a string, we want to know the maximum no. of occurrences of any
 * substring that satisfies following two conditions:
 * 
 * The substring¡¯s lengths is within in inclusive range of minLength to
 * maxLength. The total no. of unique characters in the string doesn¡¯t exceed
 * maxUnique. For example, given a string s=abcde, minLength=2, maxLength=5,
 * maxUnique=3, the substrings matching the criteria are (ab, bc, cd, de, abc,
 * bcd, cde). Any shorter string fails he minLength>=2 any longer will fail
 * maxUnique <= 3. Each of the substring occurs only one time.
 * 
 * INPUT : First line contains a string, second line contains minLength, third
 * line contains maxLength, and the last line contains maxUnique.
 * 
 * Constraints : 2<=n<=105 2<=minLength<= maxLength <=26 maxLength<n
 * 2<=maxUnique<=26
 * 
 * SAMPLE INPUT :
 * 
 * ababab 2 3 4 SAMPLE OUTPUT :
 * 
 * 3 We want to find the no. of occurrences of the most frequently occurring
 * substring of s= ¡°ababab¡± that has the length in the inclusive range from
 * minLength = 2 and maxLength=3 and contains maximum of maxUnique = 4 unique
 * characters. The substring ab occurs three times aba, bab and ba occurs twice.
 * Because we want maximum of this frequencies we return 3 as our answer.
 * 
 * Please tell me how to solve this question
 *
 * 
 * 
 */
public class Most_Frequent_Substring {

	public static void main(String[] args) {
//		System.out.println(getCount(3, 5, 5, " as up up up."));
//		System.out.println(getCount(2, 3, 4, "ababab"));
//		System.out.println(""+getHighestFrequencyOfSubstring(3, 5, 5, " as up up up."));
//		System.out.println(""+getHighestFrequencyOfSubstring(2, 3, 4, "ababab"));
		// TODO Auto-generated method stub
//		char[] arr = ArrayUtils.generateCharArrayWithDup(10, 'a', 'c', true);
		char[] arr = ArrayUtils.buildCharArrayWithDup(12, 'a', 'b', true);
		String str = String.valueOf(arr);
		System.out.println(getCount(3, 5, 5, str));
		System.out.println(""+getHighestFrequencyOfSubstring(3, 5, 5, str));
	}

//	public static int mostFrequesntSubstring(char[] arr) {
//		if(arr == null || arr.length == 0) {
//			return 0;
//		}
//		Map<String, Integer> map = new HashMap<>();
//		
//		for(int i = 0; i < arr.length; i++) {
//			char ch = arr[i];
//			
//		}
//	}
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
		int frequency = 0;
	}
	
	static TrieNode root;
	static Set distinctCharacters = new HashSet();
    
	public static int getHighestFrequencyOfSubstring(int k, int l, int m, String s) {
		int len = s.length();
		if (s == null || len == 0) {
			return 0;
		}
		if (k < 0 || l < 0 || m <= 0) {
			return 0;
		}
		int maxFrequency = 1;
		root = new TrieNode();
		for (int i = 0; i < len; ++i) {
			for (int j = k; j <= l && j <= len; ++j) {
				String substring = s.substring(i, j);
				// return -1 if distincts more than m
				int currentFrequency = insertIntoTrie(substring, m);
				if (currentFrequency == -1) {
					break;
				}
				maxFrequency = (currentFrequency > maxFrequency) ? currentFrequency : maxFrequency;
			}
			k += 1;
			l += 1;
		}
		return maxFrequency;
	}

	public static int insertIntoTrie(String word, int m) {
		distinctCharacters.clear();
		TrieNode parent = root;
		for (char c : word.toCharArray()) {
			distinctCharacters.add(c);
			if (distinctCharacters.size() > m) {
				return -1;
			}
			int i = c - 'a';
			if (parent.next[i] == null) {
				parent.next[i] = new TrieNode();
			}
			parent = parent.next[i];
		}
		if (parent.word != null) {
			parent.frequency += 1;
		} else {
			parent.word = word;
			parent.frequency = 1;
		}
		return parent.frequency;
	}

	/**
	 * 
	 * @param k
	 *            min length
	 * @param l
	 *            max length
	 * @param m
	 *            number of unique characters
	 * @param s
	 *            the string
	 * @return
	 */
	private static int getCount(int k, int l, int m, String s) {
		Set<Character> uniqueChars = new HashSet<Character>();
		Map<String, Integer> stats = new HashMap<String, Integer>();
		for (int h = 0; h < s.length() - k; h++) {
			for (int t = h + k; t <= s.length() && t <= h + l && uniqueChars.size() <= m; t++) {
				uniqueChars.clear();
				String subStr = s.substring(h, t);// this method does not
				// include last position
				if (stats.containsKey(subStr)) {
					stats.put(subStr, stats.get(subStr) + 1);
					populateSet(subStr, uniqueChars);
				} else {
					stats.put(subStr, 1);
				}
			}
		}
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(stats.size(),
				new Comparator<Map.Entry<String, Integer>>() {

					@Override
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}

				});
		pq.addAll(stats.entrySet());
		Map.Entry<String, Integer> entry = pq.poll();
		System.out.println(entry.getKey());
		return entry.getValue();
	}

	private static void populateSet(String s, Set<Character> uniqueChars) {
		Objects.requireNonNull(s);
		Objects.requireNonNull(uniqueChars);
		for (char c : s.toCharArray())
			uniqueChars.add(c);

	}

}
