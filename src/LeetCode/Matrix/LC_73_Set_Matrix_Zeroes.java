package LeetCode.Matrix;

import Utils.MatrixUtils;

/**
73. Set Matrix Zeroes
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Seen this question in a real interview before?   Yes  No
Difficulty:Medium
Total Accepted:108.5K
Total Submissions:301.9K
Contributor: LeetCode
Subscribe to see which companies asked this question.

Related Topics 
Array 
Similar Questions 
Game of Life

 *
 */
public class LC_73_Set_Matrix_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,0,0,5},
				          {4,3,1,4},
				          {0,1,1,4},
				          {1,2,1,3},
				          {0,0,1,1}};
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		setZeroes(matrix);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
	}

// 核心：两个解法的核心思路都是先遍历做标记，然后遍历检查标记确认是不是需要置零
// 区别：第一种解法从00位置,开始遍历所有，第二解法从11位置,开始遍历所有
//	第二种解法如果第一行或第一列不是零则没关系，如果是零，则必须提前记录第一行或者第一列是否需要置零，否则就会丢失这个信息
	
	  //worked,  TC is O(M*N), SC is O(M+N), two big for loops
	 public static void setZeroes00(int[][] matrix) {
	     if(matrix == null || matrix.length == 0){
	         return;
	     } 
	     if(matrix[0] == null || matrix[0].length == 0){
	         return;
	     }
	     int rows = matrix.length;
	     int cols = matrix[0].length;
	     boolean[] hasZeroInRows = new boolean[rows];        
	     boolean[] hasZeroInCols = new boolean[cols];
	     for(int i = 0; i < rows; i++){
	         for(int j = 0; j < cols; j++){
	             if(matrix[i][j] == 0){
	                 hasZeroInRows[i] = true;
	                 hasZeroInCols[j] = true;
	             }           
	         }
	     }
	     for(int i = 0; i < rows; i++){
	         for(int j = 0; j < cols; j++){
	             if(hasZeroInRows[i] == true || hasZeroInCols[j] == true){
	                 matrix[i][j] = 0;
	             }           
	         }
	     }        
	     return;
	 }

	// worked, TC is O(M*N), SC is O(1), two big for loops + two +two for loops
    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        } 
        if(matrix[0] == null || matrix[0].length == 0){
            return;
        }
        boolean hasZeroInFirstCol = false;
        boolean hasZeroInFirstRow = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
//        mark first cols and first row, 根据题意，保留现场，后面需要改变现场
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                hasZeroInFirstCol = true;
                break;
            }
        }
        for(int j = 0; j < cols; j++){
            if(matrix[0][j] == 0){
                hasZeroInFirstRow = true;
                break;
            }
        }
//      改变第一行和第一列，进行标记， 此操作可以覆盖第一行或者第一列的原来的数值，所以必须提前记录，保留现场，除了matrix[0][0]
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }           
            }
        }
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }           
            }
        }        
		
//        for(int i = 0; i < rows; i++){
//            if(matrix[i][0] == 0){
//                for(int j = 1; j < cols; j++){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        for(int j = 0; j < cols; j++){
//            if(matrix[0][j] == 0){
//                for(int i = 0; i < rows; i++){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
        if(hasZeroInFirstCol){
            for(int i = 0; i < rows; i++){
               matrix[i][0] = 0; 
            }
        }
        if(hasZeroInFirstRow){
            for(int j = 0; j < cols; j++){
               matrix[0][j] = 0; 
            }
        }
        return;
    }	
}
