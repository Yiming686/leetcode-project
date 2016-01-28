package Lintcode.Array.BinarySearch;

/**
Search a 2D Matrix Show result 

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge
O(log(n) + log(m)) time

Tags Expand  

Related Problems Expand 	

 *
 */
public class Search_a_2D_Matrix {

	//TC is O(log(m*n))
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return false;
		}

		int row = matrix.length, column = matrix[0].length;
		int start = 0, end = row * column - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int number = matrix[mid / column][mid % column];
			if (number == target) {
				return true;
			} else if (number < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		if (matrix[start / column][start % column] == target) {
			return true;
		}
		if (matrix[end / column][end % column] == target) {
			return true;
		}
		return false;
	}
	
	//TC is O(log(m)+log(n))
    public static boolean searchMatrix2(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
// 			return 0;
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
// 			return 0;
			return false;
		}
        // int num = 0;
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        int row = 0;
        int col = colLen - 1;
        
		while (row >=0 && row < rowLen && col >=0 && col < colLen) {
		    int val = matrix[row][col];
		    //找到后怎么办？num++，row和col怎么变，必须变，否则infinite loop
		    //到底是row++还是col--；
			if (val == target) {
                // num++;
                // col--;
                return true;
            } else if (val < target) {
				row++;
			} else {
				col--;
			}
		}
// 		return num;
        return false;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}




