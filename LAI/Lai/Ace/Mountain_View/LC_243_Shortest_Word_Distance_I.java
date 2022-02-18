package Lai.Ace.Mountain_View;

import Utils.ArrayUtils;

/**
 *
 */
public class LC_243_Shortest_Word_Distance_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "A", "B", "C", "X", "D", "Y", "Y", "E","F", "X", "F", "X", "H" };
		ArrayUtils.print(words);
		System.out.println("" + shortestWordDistanceI(words, "X", "Y"));

	}
//Assumption ,two words are different
	public static int shortestWordDistanceI(String[] words, String word1, String word2) {
		int rightMostWord1 = -1;
		int rightMostWord2 = -1;
		int minDistance = words.length;//;words.length - 1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				rightMostWord1 = i;
			} else if (words[i].equals(word2)) {
				rightMostWord2 = i;
			}
			if (rightMostWord1 != -1 && rightMostWord2 != -1) {
				minDistance = Math.min(minDistance, Math.abs(rightMostWord1 - rightMostWord2));
			}
		}
		return minDistance;
	}
}
