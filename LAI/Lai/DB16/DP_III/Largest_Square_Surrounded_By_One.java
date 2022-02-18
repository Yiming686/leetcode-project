package Lai.DB16.DP_III;

import Lintcode.Matrix.Matrix;

/**
 * 
 * Determine the largest square surrounded by 1s in a binary matrix (a binary
 * matrix only contains 0 and 1), return the length of the largest square.
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
 * {{1, 0, 1, 1, 1},
 * 
 * {1, 1, 1, 1, 1},
 * 
 * {1, 1, 0, 1, 0},
 * 
 * {1, 1, 1, 1, 1},
 * 
 * {1, 1, 1, 0, 0}}
 * 
 * 
 * 
 * The largest square surrounded by 1s has length of 3.
 *
 * 
 */
public class Largest_Square_Surrounded_By_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = { { 1, 0, 1, 1, 1 },
//
//				{ 1, 1, 1, 1, 1 },
//
//				{ 1, 1, 0, 1, 0 },
//
//				{ 1, 1, 1, 1, 1 },
//
//				{ 1, 1, 1, 0, 0 } };
		int[][] arr = {{1}};
		System.out.println("matrix:\n" + Matrix.fromMatrixToString(arr));
		System.out.println("" + largestSquareSurroundedByOne(arr));
	}

	public static int largestSquareSurroundedByOne(int[][] matrix) {
		// Write your solution here
		if (matrix == null) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return 0;
		}
		int result = 0;
		int[][] left = new int[rows + 1][cols + 1];
		int[][] up = new int[rows + 1][cols + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (matrix[i][j] == 1) {
					left[i + 1][j + 1] = left[i + 1][j] + 1;
					up[i + 1][j + 1] = up[i][j + 1] + 1;
					for (int size = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); size >= 1; size--) {
						if (left[i + 2 - size][j + 1] >= size && up[i + 1][j + 2 - size] >= size) {
							result = Math.max(result, size);
							break;
						}
					}
				}
			}
		}
		System.out.println("left:\n" + Matrix.fromMatrixToString(left));
		System.out.println("up:\n" + Matrix.fromMatrixToString(up));
		return result;
	}

}
