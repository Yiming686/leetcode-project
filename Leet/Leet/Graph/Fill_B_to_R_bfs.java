package Leet.Graph;

import static Utils.MatrixUtils.print;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import Utils.MatrixUtils;

public class Fill_B_to_R_bfs {

	static final char YELLOW = 'Y';//equipment
	static final char BLUE = '_';
	static final char RED = 'R';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> char2ProbMap = new HashMap<>();
		char2ProbMap.put(YELLOW, 8);
		char2ProbMap.put(BLUE, 6);
		char2ProbMap.put(RED, 2);
		List<Character> list = new ArrayList<>();
		list.add('D');		list.add('E');		list.add('F');
		char[][] matrix0 = MatrixUtils.buildMatrix(6, 6, list);
		print(matrix0);
		char[][] matrix = MatrixUtils.buildMatrix(6, 6, char2ProbMap);
//		char[][] matrix = { { '_', '_', 'R', 'Y', '_', '_' }, { '_', '_', '_', '_', '_', '_' },
//				{ 'R', 'R', '_', 'Y', '_', 'Y' }, { 'Y', '_', '_', 'Y', 'Y', '_' }, { 'Y', '_', 'R', 'R', '_', 'Y' },
//				{ '_', '_', 'Y', '_', 'Y', 'R' } };
//		char[][] matrix =  {{'Y','R','_','Y','Y','Y'},{'Y','Y','R','R','Y','_'},{'_','_','Y','_','Y','Y'},{'_','Y','R','R','_','_'},{'Y','Y','Y','_','_','_'},{'Y','_','Y','Y','_','_'}};
//		two connected blue areas: 
//		char[][] matrix =  {{'_','_','R','_','_','R'},{'_','_','_','_','R','R'},{'_','_','R','R','_','R'},{'_','_','R','_','_','R'},{'_','_','R','_','_','R'},{'_','_','R','_','_','R'}};
//		Good Example:
//		char[][] matrix =   {{'_','_','Y','Y','_','_'},{'Y','_','_','_','_','Y'},{'Y','_','Y','_','Y','Y'},{'Y','_','_','Y','Y','_'},{'Y','_','R','Y','Y','_'},{'R','Y','Y','R','_','Y'}};

//		{
//		{'_','Y','_','_','_','_'},
//		{'_','Y','R','_','R','Y'},
//		{'_','R','R','Y','Y','Y'},
//		{'Y','_','_','_','_','_'},
//		{'Y','Y','Y','_','_','Y'},
//		{'_','R','_','_','_','R'}};

		print(matrix);
		fill(matrix, 2, 1);
		print(matrix);
	}

//	from BLUE to RED
	private static void fill(char[][] matrix, int row, int col) {
		if (matrix[row][col] != BLUE) {
			System.out.println("Not BLUE!");
			return;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
//		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int[] count = new int[1];
//		fill_dfs(matrix, row, col, rows, cols, count);
		fill_bfs(matrix, row, col, rows, cols, count);
	}

	private static void fill_bfs(char[][] matrix, int x, int y, int rows, int cols, int[] count) {
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		System.out.printf("MET BLUE:  %d times, row:col [ %d, %d ] \n", ++count[0], Integer.valueOf(x),
				Integer.valueOf(y));
		matrix[x][y] = RED;
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			for(int[] dxdy : dirs) {
				int dx = loc[0] + dxdy[0];
				int dy = loc[1] + dxdy[1];
				if(dx >= 0 && dx < rows && dy >= 0 && dy < cols && matrix[dx][dy] == BLUE) {
					System.out.printf("MET BLUE:  %d times, row:col [ %d, %d ] \n", ++count[0], Integer.valueOf(dx),
							Integer.valueOf(dy));

					matrix[dx][dy] = RED;
					queue.offer(new int[] {dx, dy});	
				}
				
			}
		}
	}

	//从blue开始，遇到blue就变为red，
	private static void fill_dfs(char[][] matrix, int x, int y, int rows, int cols, int[] count) {
		if (x < 0 || x >= rows || y < 0 || y >= cols) {
			return;
		}
		//if visited, red means visited and if Yellow, need to visit
		if (matrix[x][y] != BLUE) {
			return;
		}
//		System.out.println("MET BLUE Times: "+count[0]++);
		System.out.printf("MET BLUE:  %d times, row:col [ %d, %d ] \n", ++count[0], Integer.valueOf(x),
				Integer.valueOf(y));
//		System.out.println("MET BLUE Times: "+count[0]++);
		matrix[x][y] = RED; //core logic, set from BLUE to RED 
//		for(int[] dxdy : dirs) {
//			int dx = x + dxdy[0];
//			int dy = y + dxdy[1];
//			fill(matrix, dx, dy, rows, cols, dirs);
//		}
		fill_dfs(matrix, x + 1, y, rows, cols, count);
		fill_dfs(matrix, x, y + 1, rows, cols, count);
		fill_dfs(matrix, x - 1, y, rows, cols, count);
		fill_dfs(matrix, x, y - 1, rows, cols, count);
	}

}
