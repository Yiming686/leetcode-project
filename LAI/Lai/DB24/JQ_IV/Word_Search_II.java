package Lai.DB24.JQ_IV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Search_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//				ArrayUtils.convertSquareBracketStr2CurlyBraceStr("[\"oath\",\"pea\",\"eat\",\"rain\"]");
		char[][] board ={
				  {'o','a','a','n'},
				  {'e','t','a','e'},
				  {'i','h','k','r'},
				  {'i','f','l','v'}
				}; 
		String[] dict = {"oath","pea","eat","rain"};
		System.out.println(""+ findWords(board, dict));
	}

	public static  List<String> findWords(char[][] board, String[] words) {
		// Write your solution here
		List<String> result = new ArrayList<>();
//		Map<Character, List<>>
//		TrieNode trie = buildTrie(words);
		return result;
	}
	
//	private static TrieNode buildTrie(String[] words) {
//		// TODO Auto-generated method stub
//		TrieNode root = new TrieNode('\0');
//		TrieNode curr = root;
//		for(int i = 0; i < words.length; i++) {
//			for(int j = 0; j < words[i].length(); i++) {
//				char ch = words[i].charAt(j);
//				List<TrieNode> children = curr.children;
//				if(children.) {
//					
//				}
//			}
//		}
//		return root;
//	}
//	
//	  static class TrieNode {
//			String word;
//			 boolean hasWord;
//			 Map<Character, TrieNode> map;
//			 public TrieNode() {
//				 map = new HashMap<Character, TrieNode>();
//			 }
//		}
	
}
