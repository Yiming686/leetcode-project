package Lintcode.Google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import sun.security.util.Length;

/**
Q2: Given a list of words and a word inside the list, create a (shortest ??) unique abbreviation for it. 
Assuming the format is (leading letters)(length of middle letters)(trailing letters)

word: internal (8) --> i6l, int4l, in4al, intern1l

Example:
dict: words, worde, worss
word: words
abbr: w3s, wo2s, w2ds

words: w3s, wo2s, w3s
“”()
	w ({3: “”, o : “o”}, false, null)
3          o  
s(“w3s”, true, 2)
count > 1 not unique
if only if count == 1 add to list<String>

How to get all possible abb for a word? 

 *
 *
 * 
 */
public class Check_Unique_Abbreviation_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<String>();
		words.add("words");
		words.add("worde");
		words.add("worst");
		System.out.println(""+findUniqueII(words, "w3s"));
	}
	static String findUniqueII(List<String> words, String word) {
		Map<String, Queue<String>> map = new HashMap<String, Queue<String>>();
		
		
		for(int i = 0; i < words.size(); i++){
			String str = words.get(i);
			if(!map.containsKey(str)){
				Queue<String> queue = new PriorityQueue<String>(11, new Comparator<String>(){
					@Override
					public int compare(String s1, String s2) {
						return s1.length() - s2.length();
					}
				});
				map.put(str, queue);
			}else{
				continue;
			}
			Queue<String> queue = map.get(str);
			int len = str.length();
			for(int j = 1; j < len-1; j++){
				String abb = ""+str.substring(0, j) + (len -j -1) + str.charAt(len - 1);
				System.out.println("abb: "+abb);
				queue.offer(abb);
			}
			
			
		}
		return null;
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
