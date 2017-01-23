package Lintcode.BinarySearch;

/**
 * Search a 2D Matrix II
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix,
 * return the occurrence of it.
 * 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. Integers in each column
 * are sorted from up to bottom. No duplicate integers in each row or column.
 * Have you met this question in a real interview? Yes Example Consider the
 * following matrix:
 * 
 * [ [1, 3, 5, 7], [2, 4, 7, 8], [3, 5, 9, 10] ] Given target = 3, return 2.
 * 
 * Challenge O(m+n) time and O(1) extra space
 * 
 * Tags Expand
 * 
 * Related Problems Expand
 *
 */

public class Search_a_2D_Matrix_II {

	public static int searchMatrix(int[][] matrix, int target) {
		// write your code here
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int num = 0;

		int rowLen = matrix.length;
		int colLen = matrix[0].length;

		int row = 0;
		int col = colLen - 1;

		while (row >= 0 && row < rowLen && col >= 0 && col < colLen) {
			int val = matrix[row][col];
			if (val == target) {
				num++;
				col--;
			} else if (val < target) {
				row++;
			} else {
				col--;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
