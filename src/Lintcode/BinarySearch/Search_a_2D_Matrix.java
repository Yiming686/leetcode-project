package Lintcode.BinarySearch;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{1,2,3},null,{4,5,6}};
		int[][] matrix = {null,null,null};
		System.out.println(""+matrix.length);
		System.out.println(""+ (matrix[0] == null));
	}

	//  worked, TC is O(log(m*n))
	 public static boolean searchMatrix00(int[][] matrix, int target) {
	     if(matrix == null || matrix.length == 0 ){
	         return false;
	     }
	     if(matrix[0] == null || matrix[0].length == 0){
	         return false;
	     }
	     int rows = matrix.length;
	     int cols = matrix[0].length;
	     
	     int start = 0;
	     int end = rows * cols - 1;
	     while(start + 1 < end){
	         int mid = start + (end - start)/2;
	         int val = matrix[mid/cols][mid%cols];
	         if(val == target){
	             return true;
	         }else if(val < target){
	             start = mid; 
	         }else{
	             end = mid;
	         }
	     }
	     if(matrix[start/cols][start%cols] == target || matrix[end/cols][end%cols] == target){
	         return true;
	     }
	     return false;
	 }
 
	//  worked, TC is O(log(m)+log(n))
	 public static boolean searchMatrix(int[][] matrix, int target) {
	     if(matrix == null || matrix.length == 0 ){
	         return false;
	     }
	     if(matrix[0] == null || matrix[0].length == 0){
	         return false;
	     }
	     int rows = matrix.length;
	     int cols = matrix[0].length;
	     
	     int row = 0;
	     int col = cols - 1;
	     while(row < rows && col >= 0){
	         if(matrix[row][col] == target){
	             return true;
	         }else if(matrix[row][col] < target){
	             row++;
	         }else{
	             col--;
	         }
	     }
	     return false;
	 }
	
}




