package Lintcode.Matrix;

/**

 Search a 2D Matrix II

 Description
 Notes
 Testcase
 Judge
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

Challenge 
O(m+n) time and O(1) extra space

Tags 
Matrix Sorted Matrix Google
Related Problems 
Easy Search a 2D Matrix 28 %

 *
 */
public class Search_a_2D_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{
			{3,2,1,0,6},
			{0,3,2,2,5},
			{4,2,2,6,3},
			{7,6,6,7,9},
			{8,7,2,7,8},
			};
			matrix = new int[][]{
				{1, 2, 3, 7},
				{2, 3, 7, 8},
				{3, 5, 9, 10}
				};
//			matrix = new int[][]{
//				{4}
//				};
//			matrix = new int[][]{
//				{4,9},
//				{9,13}
//				};

			int target = 2;
			System.out.println(""+searchMatrix(matrix, target));
	}
	
    public static int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
		return 0;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int tlRow = 0;//左上角的行, top left
		int tlCol = 0;//左上角的的列,  top left
		int brRow = rows - 1;//右下角的行, bottom right
		int brCol = cols - 1;//右下角的列, bottom right
	
	    int count = 0;
	    while(tlRow <= brRow && tlCol <= brCol ){//只要至少一个点，一个行，一个列就行
	        int left = tlCol;//每次while进来后，重新初始化
	        int right = brCol;//每次while进来后，重新初始化
	        while(left <= right){//可以使一个点
	            int mid = left + (right - left)/2;
	            if(matrix[tlRow][mid] == target){
	                count ++;
	                left = mid;
	                right = mid - 1;
	                break;//求个数就break，求是否存在就直接return
	            }else if(matrix[tlRow][mid] < target){
	                left = mid + 1;
	            }else{
	                right = mid - 1;
	            }
	        }    
	        tlRow++;//直接求得新的更小矩阵的左上角的row
	        brCol= right;//上面BS后right有用，求得新的更小矩阵的右下角的列col
	        
	        left = tlRow;//重新bs列
	        right = brRow;//重新bs列
	        while(left <= right){//可以使一个点
	            int mid = left + (right - left)/2;
	            if(matrix[mid][tlCol] == target){
	                count ++;
	                left = mid;
	                right = mid - 1;
	                break;//求个数就break，求是否存在就直接return
	            }else if(matrix[mid][tlCol] < target){
	                left = mid + 1;
	            }else{
	                right = mid - 1;
	            }
	        }    
	        tlCol++;//直接求得新的更小矩阵的左上角的col
	        brRow = right;//上面BS后right有用，求得新的更小矩阵的右下角的row
	//        新的更小矩阵的左上右下两个点都已经得到
	    }
	    return count;
	}


}
