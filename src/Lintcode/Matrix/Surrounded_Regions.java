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

	// �ҵ�Ϊ0�ģ�����������������bfs����
	// 0��ΪF����������Ϊ0�ı�ΪT������queue
	// ���ʣ���ڲ�0����X���ƣ��Լ���Χ��F���������0��ΪX������F��Ϊ0
	public void bfs(char[][] board, int row, int col) {
		if (board[row][col] != 'O') {
			return;
		}

		final int[] dx = { +1, -1, 0, 0 };
		final int[] dy = { 0, 0, +1, -1 };

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(row, col));
		// ����Ϊ0�ģ��Լ����ڵģ���Ҫ����
		while (!queue.isEmpty()) {
			// ��һ����poll����һ��Ԫ��
			Node node = queue.poll();
			// �ڶ������������Ԫ�أ����ΪT
			board[node.x][node.y] = 'T';
			// ��������Ѱ�����ܽ��ڵ�0����queue��������
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
