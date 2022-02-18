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

public class Boggle_Game2 {

	public static void main(String[] args) {
		String boardFilePath = "Leet/Leet/Interview/Okera/board.txt";
//		String boardFilePath = "Leet/Leet/Interview/Okera/board_2.txt";

//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary.txt";
		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_4.txt";
//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_5.txt";

		char[][] board = loadBoard(boardFilePath);
		String[] words = loadWords(wordsFilePath);
		print(board);
		print(words);
//		print(words, 0, 10);
//		char[][] board = { { 'c', 'a', 't' }, { 'd', 'k', 'n' }, { 't', 'a', 'r' } };
//		print(board);
//		String[] words = { "cat", "tar", "tarn", "rat", "can" };
//		String[] words = { "cat", "tar", "tarn", "rat", "can","dkn","dkt" };
//		System.out.println("Words: " + findWords(board, words));
		int minLen = 3;
		findWordsUsingTrie(board, words, minLen);
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

static class TrieNode {
	boolean isWord; // indicate if the node is the end of a word.
	Map<Character, TrieNode> children;

	TrieNode() {
		this.children = new HashMap<>();
	}
}

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
		if (root.children.get(ch) == null) {
			root.children.put(ch, new TrieNode());
		}
		root = root.children.get(ch);
	}
	root.isWord = true;
}

public static void findWordsUsingTrie(char[][] board, String[] words, int minLen) {
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
	if (root.children.get(ch) == null) {
		return;
	}
	// recursive rule
	root = root.children.get(ch);
	sb.append(ch);
//		if (root.isWord) {
	if (root.isWord && sb.length() >= minLen) {
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


}
