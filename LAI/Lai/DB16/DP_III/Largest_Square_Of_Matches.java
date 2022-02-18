package Lai.DB16.DP_III;

import Lintcode.Matrix.Matrix;

/**
 * 
 * Determine the largest square surrounded by a bunch of matches (each match is
 * either horizontal or vertical), return the length of the largest square.
 * 
 * The input is a matrix of points. Each point has one of the following values:
 * 
 * 0 - there is no match to its right or bottom.
 * 
 * 1 - there is a match to its right.
 * 
 * 2 - there is a match to its bottom.
 * 
 * 3 - there is a match to its right, and a match to its bottom.
 * 
 * 
 * 
 * Assumptions
 * 
 * The given matrix is guaranteed to be of size M * N, where M, N >= 0
 * 
 * 
 * 
 * Examples
 * 
 * {{3, 1, 1, 3, 0, 1, 1, 0},
 * 
 * {2, 0, 0, 2, 0, 0, 0, 0},
 * 
 * {3, 1, 3, 0, 0, 0, 0, 0},
 * 
 * {2, 0, 2, 0, 0, 0, 0, 0},
 * 
 * {1, 1, 0, 0, 0, 0, 0, 0}}
 * 
 * 
 * 
 * This matrix represents the following bunch of matches:
 * 
 * 
 * 
 * The largest square has length of 2.
 *
 * 
 */
public class Largest_Square_Of_Matches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				 {3, 1, 1, 3, 0, 1, 1, 0},

				 {2, 0, 0, 2, 0, 0, 0, 0},

				 {3, 1, 3, 0, 0, 0, 0, 0},

				 {2, 0, 2, 0, 0, 0, 0, 0},

				 {1, 1, 0, 0, 0, 0, 0, 0}};
		
//		int[][] arr = { { 3 } };
//		int[][] arr = { { 3, 1, 1, 2, 0, 1 }, { 2, 2, 1, 2, 3, 1 }, { 2, 3, 0, 2, 2, 0 }, { 1, 1, 1, 0, 0, 2 },
//				{ 2, 3, 0, 3, 2, 1 } };
		System.out.println("matrix:\n" + Matrix.fromMatrixToString(arr));
		System.out.println("" + largestSquareOfMatches(arr));

	}

	public static int largestSquareOfMatches(int[][] matrix) {
		// Write your solution here
		if (matrix == null) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows <= 1 || cols <= 1) {
			return 0;
		}
		int result = 0;
		int[][] right = new int[rows + 1][cols + 1];
		int[][] down = new int[rows + 1][cols + 1];
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					right[i][j] = right[i][j+1] + 1;
				} else if (matrix[i][j] == 2) {
					down[i][j] = down[i+1][j] + 1;
				} else if (matrix[i][j] == 3) {
					right[i][j] = right[i][j+1] + 1;
					down[i][j] = down[i+1][j] + 1;
				}
				for (int size = Math.min(right[i][j], down[i][j]); size >= 1; size--) {
					if (down[i][j + size] >= size && right[i + size][j] >= size) {
						result = Math.max(result, size);
						break;
					}
				}
			}
		}
		System.out.println("right:\n" + Matrix.fromMatrixToString(right));
		System.out.println("down:\n" + Matrix.fromMatrixToString(down));
		return result;
	}

}
