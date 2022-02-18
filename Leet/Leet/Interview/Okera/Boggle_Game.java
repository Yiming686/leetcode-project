package Leet.Interview.Okera;

import static Utils.ArrayUtils.print;
import static Utils.MatrixUtils.print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Boggle_Game {

	public static void main(String[] args) {
//		String boardFilePath = "Leet/Leet/Interview/Okera/board.txt";
		String boardFilePath = "Leet/Leet/Interview/Okera/board_2.txt";
		
//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary.txt";
//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_4.txt";
		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_5.txt";

		char[][] board = loadBoard(boardFilePath);
		String[] words = loadWords(wordsFilePath);
		print(board);
//		print(words);
//		print(words, 0, 10);
//		char[][] board = { { 'c', 'a', 't' }, { 'd', 'k', 'n' }, { 't', 'a', 'r' } };
//		print(board);
//		String[] words = { "cat", "tar", "tarn", "rat", "can" };
//		String[] words = { "cat", "tar", "tarn", "rat", "can","dkn","dkt" };
//		System.out.println("Words: " + findWords(board, words));
		int minLen = 3;
		findWords(board, words, minLen);
	}

private static char[][] loadBoard(String boardFilePath) {
	char[][] board = null;
	try {
		FileReader fileReader = new FileReader(new File(boardFilePath));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String data = null;
		int row = -1;
		while ((data = bufferedReader.readLine()) != null) {
			if (row == -1) {
				String[] arr = data.split(" ");
				int rows = Integer.valueOf(arr[0]);
				int cols = Integer.valueOf(arr[1]);
				board = new char[rows][cols];
			} else {
				String[] arr = data.split(" ");
				board[row] = new char[arr.length];
				for (int col = 0; col < board[0].length; col++) {
					board[row][col] = arr[col].charAt(0);
				}
			}
			row++;
		}
		fileReader.close();
		bufferedReader.close();
	} catch (IOException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
	return board;
}

private static String[] loadWords(String wordListFilePath) {
	List<String> wordsList = new ArrayList<String>();
	try {
		FileReader fileReader = new FileReader(new File(wordListFilePath));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String str = null;
		int count = 0;
		while ((str = bufferedReader.readLine()) != null) {
			count++;
			wordsList.add(str);
		}
		System.out.println("count: " + count);
		fileReader.close();
		bufferedReader.close();
	} catch (IOException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
	return wordsList.toArray(new String[0]);
}

//	1. identify all the valid words can be constructed using adjacent letters without repeating any letters.
//	2. Words must be at least 3 letters.
//	3. Note that 'can' is not valid  because you cannot go diagonally.
//	4. Output all the words it found to standard out with each word on its own line.
//	5. Repeated words should be printed.

//	static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// Solution 2:  trie tree + dfs backtracking
	private static TrieNode buildDict(String[] words) {
		// TODO Auto-generated method stub
		if (words == null || words.length == 0) {
			return null;
		}
		TrieNode root = new TrieNode();
		for (String word : words) {
			if (word == null || word.length() == 0) {
				continue;
			}
			insert(root, word);
		}
		return root;
	}

	private static void insert(TrieNode root, String word) {
		char[] arr = word.toCharArray();
		for (char ch : arr) {
//			if (root.children[ch - 'a'] == null) {
			if (root.children.get(ch) == null) {
//				root.children[ch - 'a'] = new TrieNode();
				root.children.put(ch, new TrieNode());
			}
//			root = root.children[ch - 'a'];
			root = root.children.get(ch);
		}
		root.isWord = true;
	}

//	public static Set<String> findWords(char[][] board, String[] words) {
//		Set<String> result = new HashSet<>();
//		// sanity check
//		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
//			throw new IllegalArgumentException("invalid input");
//		}
//		// step one --> build the Trie from the given list of words.
//		TrieNode root = buildDict(words);
//		final int rows = board.length;
//		final int cols = board[0].length;
//		// from every cell try to find the word corresponding to the part start from the current cell
//		boolean[][] visited = new boolean[rows][cols];
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				helper(board, i, j, root, sb, result, visited);
//			}
//		}
//		return result;
//	}

	public static void findWords(char[][] board, String[] words, int minLen) {
//		Set<String> result = new HashSet<>();
		// sanity check
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			throw new IllegalArgumentException("invalid input");
		}
		// step one --> build the Trie from the given list of words.
		TrieNode root = buildDict(words);
		final int rows = board.length;
		final int cols = board[0].length;
		// from every cell try to find the word corresponding to the part start from the current cell
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean[][] visited = new boolean[rows][cols];
//				helper(board, i, j, root, sb, result, visited);
				helper(board, i, j, root, sb, visited, minLen);
			}
		}
	}

	private static void helper(char[][] board, int x, int y, TrieNode root, StringBuilder sb, boolean[][] visited,
			int minLen) {
		// base cases
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
			return;
		}
		char ch = board[x][y];
//		if (root.children[ch - 'a'] == null) {
		if (root.children.get(ch) == null) {
			return;
		}
		// recursive rule
//		root = root.children[ch - 'a'];
		root = root.children.get(ch);
		sb.append(ch);
		if (root.isWord) {
//		if (root.isWord && sb.length() >= minLen) {			
//			result.add(sb.toString());
			System.out.println(sb.toString());
//			return; //Do not return here
		}
		visited[x][y] = true;
		helper(board, x + 1, y, root, sb, visited, minLen);
		helper(board, x - 1, y, root, sb, visited, minLen);
		helper(board, x, y - 1, root, sb, visited, minLen);
		helper(board, x, y + 1, root, sb, visited, minLen);
		visited[x][y] = false;
		sb.deleteCharAt(sb.length() - 1);
	}

//	private static void helper(char[][] board, int x, int y, TrieNode root, StringBuilder sb, Set<String> result,
//			boolean[][] visited) {
//		// base cases
//		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
//			return;
//		}
//		char ch = board[x][y];
//		if (root.children[ch - 'a'] == null) {
//			return;
//		}
//		// recursive rule
//		root = root.children[ch - 'a'];
////		root = root.children[ch - 'a'];
//		sb.append(ch);
//		if (root.isWord) {
////		if (root.isWord && sb.length() >= 3) {			
//			result.add(sb.toString());
////			return; //=== Wrong ===
//		}
//		visited[x][y] = true;
//		for (int[] dir : DIRS) {
//			int neiX = dir[0] + x;
//			int neiY = dir[1] + y;
//			helper(board, neiX, neiY, root, sb, result, visited);
//		}
//		visited[x][y] = false;
//		sb.deleteCharAt(sb.length() - 1);
//	}

	static class TrieNode {
//		int count; // how many words (aka purple nodes) are on this subtree
		boolean isWord; // indicate if the node is the end of a word.
		Map<Character, TrieNode> children;
//		TrieNode[] children;

		TrieNode() {
			this.children = new HashMap<>();
//			this.children = new TrieNode[26];
		}
	}

}

/*
 * # Boggle Interview Question
 * 
 * We'd like you to implement a solution to the board game Boggle. In Boggle,
 * the objective is to, given a grid of letters, identify all the valid words
 * can be constructed using adjacent letters without repeating any letters.
 * Words must be at least 3 letters.
 * 
 * For example, in the board below: ``` c a t d k n t a r ``` The valid words
 * are: 'cat', 'tar', 'tarn' and 'rat'. Note that 'can' is not valid because you
 * cannot go diagonally.
 * 
 * Your solution should take two file paths as arguments. The first is a file
 * containing the dictionary and the second is the file describing the board.
 * The program should output all the words it found to standard out with each
 * word on its own line. Repeated words should be printed. The program should
 * not output anything else to standard out.
 * 
 * A dictionary is included in this repo and the format of it is just a list of
 * words, each on its own line.
 * 
 * The format of the board is: ``` <number of rows> <number of columns> Grid of
 * board letters ```
 * 
 * Examples of both the board and dictionary are included in this repo. For
 * example, if your program was called 'boggle', it should: ``` $ ./boggle
 * ./dictionary.txt ./board.txt cat tar tarn rat ```
 * 
 * 
 */