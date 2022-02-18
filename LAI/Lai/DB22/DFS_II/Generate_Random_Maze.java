package Lai.DB22.DFS_II;

import static Utils.MatrixUtils.fromMatrixToString;

//import static Utils.MatrixUtils.*;

import Utils.MatrixUtils;
import Utils.TreeNodeUtils.TP;

//import static Utils.MatrixUtils.*;

public class Generate_Random_Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("last: \n"+fromMatrixToString(generateMaze(4)));;
	}

	public static int[][] generateMaze(int n) {
		int[][] maze = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					maze[i][j] = 0;
				} else {
					maze[i][j] = 1;
				}
			}
		}
		TP root = TP.build("", "111", null, fromMatrixToString(maze), 0, 0);
		generateMaze(maze, 0, 0, root);
		root.print();
		return maze;
	}

	private static void generateMaze(int[][] maze, int x, int y, TP root ) {
		System.out.printf("row:col %d:%d \n", x, y);
		System.out.println(""+MatrixUtils.fromMatrixToString(maze));;
		Dir[] dirs = Dir.values();
		shuffle(dirs);
		for (Dir dir : dirs) {
			int nextX = dir.moveX(x, 2);
			int nextY = dir.moveY(y, 2);
			System.out.printf("nextX:nextY %d:%d \n", nextX, nextY);

			if (isValidWall(maze, nextX, nextY)) {
				maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
				maze[nextX][nextY] = 0;
				generateMaze(maze, nextX, nextY, TP.build(root, fromMatrixToString(maze),  nextX, nextY));
			}
		}
	}

	private static boolean isValidWall(int[][] maze, int x, int y) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
	}

	private static void shuffle(Dir[] dirs) {
		for (int i = 0; i < dirs.length; i++) {
			int index = (int) (Math.random() * (dirs.length - i));
			Dir temp = dirs[i];
			dirs[i] = dirs[i + index];
			dirs[i + index] = temp;
		}
	}

//	int[] deltaX = new int[2] { -1, 0 };

	enum Dir {
		UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);
		int x;
		int y;

		Dir(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int moveX(int x, int times) {
			return x + times * this.x;
		}

		public int moveY(int y, int times) {
			return y + times * this.y;
		}

	}

}
