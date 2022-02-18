package Lai.DB16.DP_III;

import Lintcode.Matrix.Matrix;

public class Largest_X_Of_1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{0, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 1, 1, 1},
				{1, 0, 1, 1}};
		System.out.println(""+Matrix.fromMatrixToString(matrix));
		System.out.println(""+largest(matrix));

	}
	
	public static int largest(int[][] matrix) {
		// Write your solution here
		if(matrix == null) {
			return -1;
		}
		if(matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] leftUp = leftUp(matrix, rows, cols);
		int[][] rightDown = rightDown(matrix, rows, cols);
		
		return merge(leftUp, rightDown , rows, cols);
	}

	private static int[][] leftUp(int[][] matrix, int rows, int cols) {
		int[][] left = new int[rows][cols];
		int[][] up = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == 1) {
					left[i][j] = getNum(left, i - 1, j - 1, rows, cols) + 1;
					up[i][j] = getNum(up, i - 1, j + 1, rows, cols) + 1;
				}
			}
		}
		System.out.println("left:\n"+Matrix.fromMatrixToString(left));
		System.out.println("up:\n"+Matrix.fromMatrixToString(up));
		merge(left, up, rows, cols);
		System.out.println("leftUp:\n"+Matrix.fromMatrixToString(left));
		return left;
	}

	private static int getNum(int[][] matrix, int i, int j, int rows, int cols) {
		if(i < 0 || i >= rows || j < 0 || j >= cols) {
			return 0;
		}
		return matrix[i][j];
	}

	private static int[][] rightDown(int[][] matrix, int rows, int cols) {
		int[][] right = new int[rows][cols];
		int[][] down = new int[rows][cols];
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = cols - 1; j >= 0; j--) {
				if(matrix[i][j] == 1) {
					right[i][j] = getNum(right, i + 1, j + 1, rows, cols) + 1;
					down[i][j] = getNum(down, i + 1, j - 1, rows, cols) + 1;
				}
			}
		}
		System.out.println("right:\n"+Matrix.fromMatrixToString(right));
		System.out.println("down:\n"+Matrix.fromMatrixToString(down));
		merge(right, down, rows, cols);
		System.out.println("rightDown:\n"+Matrix.fromMatrixToString(right));

		return right;
	}

	private static int merge(int[][] one, int[][] two, int rows, int cols) {
		int result = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				one[i][j] = Math.min(one[i][j], two[i][j]);
				result = Math.max(result, one[i][j]);
			}
		}
		return result;

	}


}
