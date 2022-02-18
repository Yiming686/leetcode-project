package Leet.XB.Mock.Day_04182020;

import static Utils.TreeNodeUtils.BINARY_TREE_NULL_NODE;

import java.util.ArrayDeque;
import java.util.Queue;

public class find_Path_in_matrix_less_than_diff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 5, 2 }, { 3, 4, 1 }, { 2, 3, 0 } };
//		int diff = 4;
		int diff = 2;
		System.out.println("" + canReach(matrix, diff));

	}

	private static boolean canReach(int[][] matrix, int diff) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		int[][] neis = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };//[row, col], down, right, up, left, [1, 0][0, 1][-1, 0][0, -1], actual: right, up, down, left
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			System.out.println("curr: "+matrix[curr[0]][curr[1]]);
			if (curr[0] == rows - 1 && curr[1] == cols - 1) {
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int neiRow = curr[0] + neis[i][0];
				int neiCol = curr[1] + neis[i][1];
//				int[] nei = new int[] {curr[0] + neis[i][0], curr[1] + neis[i][1]};// not better
				if (neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols) {
					continue;
				}
				if (visited[neiRow][neiCol]) {
					continue;
				}
				if (Math.abs(matrix[curr[0]][curr[1]] - matrix[neiRow][neiCol]) > diff) {
					continue;
				}
//				if (Math.abs(matrix[neiRow][curr[1]] - matrix[neiRow][neiCol]) <= diff) {
				visited[neiRow][neiCol] = true;
				queue.offer(new int[] { neiRow, neiCol });
//				if (neiRow == rows - 1 && neiCol == cols - 1) {
//					System.out.println("nei: "+matrix[neiRow][neiCol]);
//					return true;
//				}
//				}
			}
		}
		return false;
	}

}
