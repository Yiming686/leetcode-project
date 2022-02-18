package Leet.Graph;

import static Utils.MatrixUtils.print;

import java.util.HashMap;
import java.util.Map;

import Utils.MatrixUtils;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: 11110 11010 11000 00000
 * 
 * Output: 1 Example 2:
 * 
 * Input: 11000 11000 00100 00011
 * 
 * Output: 3
 *
 * 
 */
public class Leet_200_Number_of_Islands {

	private static final char ONE = 'M';
	private static final char ZERO = '_';
	public static void main(String[] args) {
		int rows = 6;
		int cols = 6;
//		List<Character> list = new ArrayList<>();
//		list.add('1');
//		list.add('0');
		Map<Character, Integer> map = new HashMap<>();
		map.put(ONE, 20);
		map.put(ZERO, 50);
//		char[][] grid = MatrixUtils.buildMatrix(rows, cols, list);
		char[][] grid = MatrixUtils.buildMatrix(rows, cols, map);
		print(grid);
		System.out.println("Number of Islands Found: "+numIslands(grid));
		print(grid);
	}

//	�ܽ᣺����ͼ���⣬��Ҫ����ȫ�ֱ����أ����ɾ��������������ģ�
//	����һ��ͼ�����Ǳ���ץסһ���㣬�Ϳ����ҵ������ھӣ�Ȼ��������εִ����еĵ㣬���ǣ�ÿһ���㶼���������ֵ��
//	����Ǹ���Ѱ�������ͬ��ֵ�����б�������ô�п��ܺܶ�㲢���ܱ���������Ϊ���Ǳ�һЩ�������ֵ�����˳�����
//	����������ͼ�ж��ٸ�1�Ͷ��ٸ�0����ôһ��ͼ�ı��������ɵִ����еĵ㣬���ҵõ���Ҫ��ֵ��
//	public static int numIslands(char[][] grid) {
	
//	dfs or bfs �ǿ���ȫ�����������еĵ㣬����������������������п��ܲ���ȫ���������еĵ�
//	��dfs����bfs�����������1. ���ֻ�Ǳ����ִ��ôһ��dfs����bfs�Ϳ���
//	2.����Ǹ���������������ǰ����ͨ����� ������������
	public static int numIslands_dfs(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == ONE) {
					count++;
					dfs(grid, i, j, rows, cols);//grid used to mark visited partially
					grid[i][j] = ONE;
				}
			}
		}
		return count;
	}

	private static void dfs(char[][] grid, int x, int y, int rows, int cols) {
		if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != ONE) {
			return;
		}
		grid[x][y] = ZERO;//mark visited, change from ONE to ZERO
		dfs(grid, x + 1,     y, rows, cols);
		dfs(grid, x,     y + 1, rows, cols);
		dfs(grid, x - 1,     y, rows, cols);
		dfs(grid, x,     y - 1, rows, cols);
	}
	
	public static int numIslands(char[][] grid) {
//		public static int numIslands_bfs(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == ONE) {
					count++;
					bfs(grid, i, j, rows, cols);//grid used to mark visited partially
//					grid[i][j] = ONE;
				}
			}
		}
		return count;
	}

//	must be one, use bfs to find one connected area and set to zeros, some might not reachable
	private static void bfs(char[][] grid, int row, int col, int rows, int cols) {
		
		
	}
}
