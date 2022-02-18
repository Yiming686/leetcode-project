package Leet.Interview.Okera;

import static Utils.ArrayUtils.print;
import static Utils.MatrixUtils.print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boggle_Game_bf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String boardFilePath = "";
//		String DictFilePath = "";
//		char[][] board = { { 'c', 'a', 't' }, { 'd', 'k', 'n' }, { 't', 'a', 'r' } };

//		String boardFilePath = "Leet/Leet/Interview/Okera/board.txt";
		String boardFilePath = "Leet/Leet/Interview/Okera/board_2.txt";
		
//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary.txt";
//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_4.txt";
		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_5.txt";

//		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_2.txt";
		char[][] board = loadBoard(boardFilePath);
		String[] words = loadWords(wordsFilePath);
		print(board);
//		print(words);
		System.out.println("Length of Words: " + words.length);
//		print(words, 0, 10);
//		char[][] board = { { 'c', 'a', 't' }, { 'd', 'k', 'n' }, { 't', 'a', 'r' } };
//		print(board);
//		String[] words = { "cat", "tar", "tarn", "rat", "can" };
//		String[] words = { "cat", "tar", "tarn", "rat", "can","dkn","dkt" };
//		System.out.println("Words: " + findWords(board, words));
		System.out.println("Words: " + finWordsBruteForce(board, words));
//		finWordsBruteForce(board, words);

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

//	private static char[][] loadBoard_0(String boardFilePath) {
//		char[][] board = null;
//		try {
//			File file = new File(boardFilePath);
//			Scanner scanner = new Scanner(file);
//			int row = -1;
//			while (scanner.hasNextLine()) {
//				if (row == -1) {
//					String data = scanner.nextLine().trim();
//					String[] arr = data.split(" ");
//					int rows = Integer.valueOf(arr[0]);
//					int cols = Integer.valueOf(arr[1]);
//					board = new char[rows][cols];
//				} else {
//					String data = scanner.nextLine();
//					String[] arr = data.split(" ");
//					board[row] = new char[arr.length];
//					for (int col = 0; col < board[0].length; col++) {
//						board[row][col] = arr[col].charAt(0);
//					}
//				}
//				row++;
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//		return board;
//	}
//
//	private static String[] loadWords_0(String wordListFilePath) {
//		List<String> wordsList = new ArrayList<String>();
//		try {
//			int count = 0;
//			File file = new File(wordListFilePath);
//			Scanner scanner = new Scanner(file);
//			while (scanner.hasNextLine()) {
//				count++;
//				String data = scanner.nextLine().trim();
//				if (data.startsWith("//") || data.equals("")) {
//					continue;
//				}
//				wordsList.add(data);
//			}
//			scanner.close();
//			System.out.println("count: " + count);
//		} catch (FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//		return wordsList.toArray(new String[0]);
//	}

//	1. identify all the valid words can be constructed using adjacent letters without repeating any letters.
//	2. Words must be at least 3 letters.
//	3. Note that 'can' is not valid  because you cannot go diagonally.
//	4. Output all the words it found to standard out with each word on its own line.
//	5. Repeated words should be printed.

//	static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

//	Method 1: (brute force)
//	for each of the words, try to find if it exists in the matrix
	// Solution 1: brute force, dfs + backtracking
	public static List<String> finWordsBruteForce(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			findWord(board, word, result);
//			if (doesExist(board, word, result)) {
////				result.add(word);
//			}
		}
		return result;
	}

	private static boolean findWord(char[][] board, String word, List<String> result) {
		final int rows = board.length;
		final int cols = board[0].length;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean[][] visited = new boolean[rows][cols]; // what is the purpose of this?
//				helper(board, i, j, word, 0, visited, result);
				if (helper(board, i, j, word, 0, visited, result)) {
//					return true;
				}
			}
		}
		return false;
	}

	private static boolean helper(char[][] board, int x, int y, String word, int index, boolean[][] visited,
			List<String> result) {
		// base case
		// 1. if all the characters are matched, we found a path representing the word.
		if (index == word.length()) {
			result.add(word);
			return true;
		}
		// 2. think carefully about all other terminate conditions
		// a). out of bound
		// b). already visited
		// c). can not match the character.
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]
				|| board[x][y] != word.charAt(index)) {
			return false;
		}
		// recursive rule
		visited[x][y] = true; // record the cell is used on the current DFS path.
		if (helper(board, x + 1, y, word, index + 1, visited, result)) {
			return true;
		}
		if (helper(board, x - 1, y, word, index + 1, visited, result)) {
			return true;
		}
		if (helper(board, x, y + 1, word, index + 1, visited, result)) {
			return true;
		}
		if (helper(board, x, y - 1, word, index + 1, visited, result)) {
			return true;
		}
		visited[x][y] = false; // recover to make it available for other paths.
		return false;
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