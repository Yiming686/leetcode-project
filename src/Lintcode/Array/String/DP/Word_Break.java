package Lintcode.Array.String.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
Word Break

Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? Yes
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

Tags Expand 
String Dynamic Programming




 *
 */
public class Word_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		map.put('d', 1);
		map.put('u', 1);
		map.put('h', 1);
		Iterator<Character> it = map.keySet().iterator();
		System.out.println(""+it.next());
			
		System.out.println(""+map.get(it.next()));
		System.out.println(""+Character.toUpperCase('b'));
		System.out.println(""+Character.toLowerCase('r'));
		String s = "lintcode";
		Set<String> dict = new HashSet<String>();
		dict.add("lin");dict.add("de");dict.add("tco");
		dict.add("lint");dict.add("code");dict.add("tcode");
		System.out.println(""+wordBreak( s,  dict));
	}
	
    //思路是什么？
    //string从
    private static int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        //用两个指针，
        //i表示当前的单词长度，仅研究前i个字符，然后计算第i位置是true还是false
        for (int i = 1; i <= s.length(); i++) {
            // canSegment[i] = false;//这个是默认值
            for (int lastWordLength = 1; lastWordLength <= maxLength;
                     lastWordLength++) {
                //如果此点可分割，进入执行
                //上面要保证i - lastWordLength >= 0
                if (i - lastWordLength >= 0 && canSegment[i - lastWordLength]) {
                    String word = s.substring(i - lastWordLength, i);
                    if (dict.contains(word)) {
                        canSegment[i] = true;
                        System.out.println(""+word);
//                        break;
                    }
                }
            }
        }
        System.out.println(""+Arrays.toString(canSegment));
        return canSegment[s.length()];
    }

}
