package Leet.String;


import static Utils.TrieNodeUtils.print;

import Leet.Interview.Insert_Get_Random;
import Utils.TrieNodeUtils.TrieNode;

/**
Given a list of strings words representing an English Dictionary, find the longest word in words 
that can be built one character at a time by other words in words. If there is more than one possible answer, 
return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically 
smaller than "apply".

Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].

 *
 */
public class Leet_720_Longest_Word_in_Dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = {"w","wo","wor","worl", "world"};//"world"
//		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};//"apple"
		String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};//"yodn"
		System.out.println(""+longestWord(words));
	}
    public static String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
        	insert(root, word);
//        	root.insert(word);
        }
        print(root);
        String[] longestStr = new String[] {""};
        searchLongest(root, longestStr);
        return longestStr[0];
    }
    
	private static void searchLongest(TrieNode root, String[] longestStr) {
//		char ch = 'a';
		for(int i = 0; i < 26; i++) {
			char ch = (char)(i + 'a');
			TrieNode node = root.children.get(ch);
			if(node != null) {
				if(node.isWord) {
					if(longestStr[0].length() < node.word.length()) {
						longestStr[0] = node.word;
					}
					searchLongest(node, longestStr);	
				}else {
					return;
				}
			}
			
		}
	}
	private static void insert(TrieNode root, String word) {
		TrieNode curr = root;
		int len = word.length();
		for(int i = 0; i < len; i++) {
			char ch = word.charAt(i);
			TrieNode node = curr.children.getOrDefault(ch, new TrieNode());
			curr.children.put(ch, node);
			curr = node;
		}
		curr.isWord = true;
		curr.word = word;
	}

}
