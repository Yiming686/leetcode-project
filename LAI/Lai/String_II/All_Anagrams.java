package Lai.String_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

/**
 * Find all occurrence of anagrams of a given string s in a given string l.
 * Return the list of starting indices.
 * 
 * Assumptions
 * 
 * s is not null or empty. l is not null. Examples
 * 
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2
 * starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 *
 * 
 */
public class All_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer num = 7;
//		System.out.println("" + num.toBinaryString(num));
//		System.out.println("" + num);
//		System.out.println("" + (num & 0));
//		System.out.println("" + num);
//		System.out.println("" + num.toBinaryString(~num));
		System.out.println("" + allAnagrams("abc", "abcaaa")); //0, 2, 3
//		String shorter = "abc";
//		String longer = "abcbac";
//		System.out.println("" + allAnagrams(shorter, longer));
//		System.out.println("" + allAnagrams("abc", "abcbac")); //0, 2, 3
//		System.out.println("" + allAnagrams("aab", "ababacbbaac")); //0, 2, 7
	}

//	longer: N, shorter: M
//	Time: O(M+N)        Space: O(M)
	public static List<Integer> allAnagrams(String shorter, String longer) {
		// Write your solution here
		List<Integer> result = new ArrayList<>();
		if (longer == null || longer.length() == 0 || shorter.length() >= longer.length()) {
			return result;
		}
		Map<Character, Integer> map = countMap(shorter);//记录Anagram的唯一性
		int match = 0;//计算match了多少个不同的字符
		for (int i = 0; i < longer.length(); i++) {
			char ch = longer.charAt(i);//拿到当前字符
			Integer count = map.get(ch);//看看map里面还有几个剩余的
			if (count != null) {//map里面有
				map.put(ch, --count);//用掉一个，减掉一个;最后一个为0
				if (count == 0) {//如果是0，表示该字符用完了，这时就是match这个字符了。可能为复制，
					match++;
				}
			}
			if (i >= shorter.length()) {//有等于号吗？
				ch = longer.charAt(i - shorter.length());//取出最左的字符
				count = map.get(ch);//剩余了几个
				if (count != null) {
					map.put(ch, ++count);//该字符退出，那么该字符的可用个数多了一个，必须增加1
					if (count == 1) {//如果是1，表示该字符用完了，状态变为多了一个可用的，此时match必须减一
						match--;
					}
				}
			}
			if (match == map.size()) {//map的key都match了
				result.add(i - shorter.length() + 1);//怎么理解？
			}
		}
		return result;
	}

	private static Map<Character, Integer> countMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}
		return map;
	}

}
