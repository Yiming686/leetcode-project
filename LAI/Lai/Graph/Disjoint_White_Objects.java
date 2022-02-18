package Lai.Graph;

import static Utils.MatrixUtils.fromMatrixToString;

import com.sun.istack.internal.FinalArrayList;

public class Disjoint_White_Objects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{{0,1,0,1},{1,0,0,1},{0,1,1,0},{0,1,0,0}};
		System.out.println(""+fromMatrixToString(matrix));
		System.out.println(""+whiteObjects(matrix));
	}

	public static int whiteObjects(int[][] matrix) {
		// Write your solution here
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	    dirs[0][0] = 0;
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && matrix[i][j] == 0) {//白色，并且没有访问过
					count++;
					dfs(i, j, matrix, visited, dirs);
				}
			}
		}
		return count;
	}

	private static void dfs(int row, int col, final int[][] matrix, boolean[][] visited, final int[][] dirs) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
			return;
		}
		if(matrix[row][col] != 0) {
			return;
		}
		if (visited[row][col]) {
			return;
		}
		visited[row][col] = true;
		System.out.println(""+fromMatrixToString(visited));
		for (int[] dir : dirs) {
			dfs(row + dir[0], col + dir[1], matrix, visited, dirs);	
		}
	}

}
