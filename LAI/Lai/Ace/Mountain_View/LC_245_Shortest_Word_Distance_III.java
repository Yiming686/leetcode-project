package Lai.Ace.Mountain_View;

import Utils.ArrayUtils;

/**
 * 
 * LC_243_Shortest_Word_Distance_III
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 MAY BE THE SAME and they represent two individual words in
 * the list.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Input: word1 = “makes”, word2 = “coding” Output: 1 Input: word1 = "makes",
 * word2 = "makes" Output: 3 Note: You may assume word1 and word2 are both in
 * the list.
 *
 * 
 * 
 */
public class LC_245_Shortest_Word_Distance_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = { "A", "B", "C", "X", "D", "Y", "Y", "E", "X", "F", "X", "H" };
		String[] words = { "A", "A","A" };
//		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		ArrayUtils.print(words);
		System.out.println("" + shortestWordDistanceIII(words, "A", "A"));
//		System.out.println("" + shortestWordDistanceIII(words, "makes", "coding"));
	}

//	i1 and i2 are the indexes where word1 and word2 were last seen. 
//	Except if they're the same word, then i1 is the previous index.
	public static int shortestWordDistanceIII(String[] words, String word1, String word2) {
		int dist = Integer.MAX_VALUE;//words.length;
		int i1 = -dist; //i1 记录当前最近的word1的位置
		int i2 = dist;//i2 记录当前最近的word2的位置
//		int i1 = -1; //i1 记录当前最近的word1的位置
//		int i2 = -1;//i2 记录当前最近的word2的位置

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				i1 = i; //i1 记录当前最近的word1
			}
			if (words[i].equals(word2)) {
				if (word1.equals(word2)) {
					i1 = i2;
				}
				i2 = i;
			}
			dist = Math.min(dist, Math.abs(i1 - i2));
			print("i1:i2:dist", i1, i2, dist);
		}
		return (int) dist;
	}

	private static void  print(String valNames, Object... objects) {
		// TODO Auto-generated method stub
		valNames = valNames.trim();
		String[] arr = valNames.split(":");
		String format = valNames + " ";
		String prefix = "";
		for(String str : arr ) {
			format += prefix + "%2s";
			prefix = ":";
		}		
		System.out.println(""+String.format(format, objects)); 
	}
}
