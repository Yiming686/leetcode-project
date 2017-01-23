package Lintcode.Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
Surrounded Regions

30:00
 Start
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Have you met this question in a real interview? Yes
Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
Tags Expand 
Breadth First Search Union Find


Related Problems Expand 
Easy Number of Islands

 *
 */
public class Surrounded_Regions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void surroundedRegions(char[][] board) {
		if (board.length == 0) {
			return;
		}

		int rowLen = board.length;
		int colLen = board[0].length;

		for (int i = 0; i < rowLen; i++) {
			bfs(board, i, 0);
			bfs(board, i, colLen - 1);
		}

		for (int j = 1; j < colLen - 1; j++) {
			bfs(board, 0, j);
			bfs(board, rowLen - 1, j);
		}

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				switch (board[i][j]) {
				case 'O':
					board[i][j] = 'X';
					break;
				case 'T':
					board[i][j] = 'O';
				}
			}
		}
	}

	// 找到为0的，进行依次上下四周bfs处理，
	// 0变为F，上下四周为0的变为T，加入queue
	// 最后剩下内部0，被X环绕，以及外围的F，最后遇到0变为X，遇到F变为0
	public void bfs(char[][] board, int row, int col) {
		if (board[row][col] != 'O') {
			return;
		}

		final int[] dx = { +1, -1, 0, 0 };
		final int[] dy = { 0, 0, +1, -1 };

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(row, col));
		// 凡是为0的，以及紧邻的，都要处理
		while (!queue.isEmpty()) {
			// 第一步：poll出来一个元素
			Node node = queue.poll();
			// 第二步：处理这个元素：标记为T
			board[node.x][node.y] = 'T';
			// 第三步：寻找四周紧邻的0加入queue，后序处理
			for (int i = 0; i < dx.length; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];

				// check validity
				if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
					queue.offer(new Node(x, y));
				}
			}
		}
	}

}
