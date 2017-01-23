package Lintcode.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Abbreviation. Given a word, the abbreviation is the (leading letter)(length of middle letters)(trailing letter).
Eg. internationalization i18n, accessibility a11y, automatically a11y
clock --> c3k
Q1: Given a list of words and an abbreviation, determine whether the abbreviation is unique.
example:
 list of words: words, worde, worst
 abbr: w3s
	abc-->a1c, 
ab-->ab
a-->a
 whether w3s corresponds to only one word in the dict?


 *
 *
 * 
 */
public class Check_Unique_Abbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<String>();
		words.add("words");
		words.add("worde");
		words.add("worst");
		System.out.println(""+findUnique(words, "w3s"));
	}

	static boolean findUnique(List<String> words, String abbreviation) {
		if (words == null || words.size() == 0)
			return false;
		if (abbreviation == null)
			return false;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : words) { // O(n), where n is the size of the list
			int len = str.length();
			String abb = len < 3 ? str : ""+str.charAt(0) + (len - 2) + str.charAt(len - 1);
			System.out.println(""+str);
			if (!map.containsKey(abb)) {
				map.put(abb, 1);
			} else {
				map.put(abb, map.get(abb) + 1);
			}
		}
		System.out.println(""+map);
		if (!map.containsKey(abbreviation)) {
			return false; // not exist, not nuique
		} else {
			if (map.get(abbreviation) == 1) {
				return true;// nuique
			} else {
				return false;// not nuique
			}

		}
	}

}
