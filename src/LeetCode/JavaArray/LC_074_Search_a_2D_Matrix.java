package LeetCode.JavaArray;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 Hide Tags Array Binary Search

 * 
 */
//https://www.youtube.com/watch?v=0-rX-Wocuew
//Search in a sorted matrix nxn solution
//(1)linear search O(n^2)
//(2)binary search O(nlogn)
//(3)diagonal binary search, consider second diagonal TC is O(logn!)
//(4)quad partition(divide and conquer, ignore 1/4 ) TC is O(n^log3), since T(n) = 3T(n/2) +o(1)
//(5)Inproved quad partition (ignore half) TC is O(n),since T(n) = 2T(n/2) + O(logn)
//(6)Down Left Search


public class LC_074_Search_a_2D_Matrix {

//	Best Solution
//	易错点：while( i >= 0 && j>=0 && i<m && j<n )
//	此条件缺一不可
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		
		int i = 0, j = n-1;
		while( i >= 0 && j>=0 && i<m && j<n ){
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				j--;
			else
				i++;
		}
		return false;
	}
	
//	递归方法
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;

		return searchMatrix(matrix, m,n,0, n - 1, target);
	}

	private boolean searchMatrix(int[][] matrix,int m, int n, int i, int j, int target) {
		// TODO Auto-generated method stub
		if(i<0 || j < 0 || i > m-1 || j> n-1) return false;
		if (matrix[i][j] == target)
			return true;
		else if (matrix[i][j] > target)
			j--;
		else
			i++;
		return searchMatrix(matrix,m,n, i,j, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
