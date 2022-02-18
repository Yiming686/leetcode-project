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

//	总结：无向图问题，需要几次全局遍历呢？这由具体问题来决定的！
//	这是一个图，但是本来抓住一个点，就可以找到他的邻居，然后遍历依次抵达所有的点，但是，每一个点都有其特殊的值，
//	如果是根据寻找这个相同的值来进行遍历，那么有可能很多点并不能遍历到，因为他们被一些非特殊的值隔离了出来。
//	如果相求这个图有多少个1和多少个0，那么一次图的遍历，即可抵达所有的点，并且得到想要的值！
//	public static int numIslands(char[][] grid) {
	
//	dfs or bfs 是可以全部遍历完所有的点，但是如果加上限制条件就有可能不能全部遍历所有的点
//	由dfs或者bfs的任务决定：1. 如果只是遍历抵达，那么一次dfs或者bfs就可以
//	2.如果是根据条件，遍历当前的联通面积， 对满足条件的
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
