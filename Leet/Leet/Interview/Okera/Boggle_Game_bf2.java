package Leet.Interview.Okera;

import static Utils.ArrayUtils.print;
import static Utils.MatrixUtils.print;
import static Utils.TreeNodeUtils.DELIMITER_CHAR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boggle_Game_bf2 {

	public static void main(String[] args) {
		String boardFilePath = "Leet/Leet/Interview/Okera/board_2.txt";
		String wordsFilePath = "Leet/Leet/Interview/Okera/dictionary_5.txt";
		char[][] board = loadBoard(boardFilePath);
		String[] words = loadWords(wordsFilePath);
		int minLen = 0;
		finWordsBruteForce(board, words, minLen);
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

// Solution 1: brute force, dfs + backtracking
public static List<String> finWordsBruteForce(char[][] board, String[] words, int minLen) {
	List<String> result = new ArrayList<>();
	for (String word : words) {
		if (word.length() >= minLen) {
			findWord(board, word, result);
		}
	}
	return result;
}

private static boolean findWord(char[][] board, String word, List<String> result) {
	final int rows = board.length;
	final int cols = board[0].length;
	boolean found = false;
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
			boolean[][] visited = new boolean[rows][cols]; // what is the purpose of this?
			if (helper(board, i, j, word, 0, visited, result)) {
				found = true;
			}
		}
	}
	return found;
}

private static boolean helper(char[][] board, int x, int y, String word, int index, boolean[][] visited,
		List<String> result) {

	if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]
			|| board[x][y] != word.charAt(index)) {
		return false;
	}
	if (index == word.length() - 1) {
		result.add(word);
		return true;
	}
	// recursive rule
	visited[x][y] = true; // record the cell is used on the current DFS path.
	boolean down = helper(board, x + 1, y, word, index + 1, visited, result);
	boolean up = helper(board, x - 1, y, word, index + 1, visited, result);
	boolean right = helper(board, x, y + 1, word, index + 1, visited, result);
	boolean left = helper(board, x, y - 1, word, index + 1, visited, result);
	visited[x][y] = false; // recover to make it available for other paths.
	return down || up || right || left;
}

}
