package Lai.Graph;

public class Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		dirs[0][0] = 0;
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {//白色，并且没有访问过
					count++;
					dfs(i, j, grid, visited, dirs);
				}
			}
		}
		return count;
	}

	private static void dfs(int row, int col, final char[][] matrix, boolean[][] visited, final int[][] dirs) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
			return;
		}
		if (matrix[row][col] != '1') {
			return;
		}
		if (visited[row][col]) {
			return;
		}
		visited[row][col] = true;
		for (int[] dir : dirs) {
			dfs(row + dir[0], col + dir[1], matrix, visited, dirs);
		}
	}

}
