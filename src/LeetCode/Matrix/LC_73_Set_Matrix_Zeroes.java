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

// ���ģ������ⷨ�ĺ���˼·�����ȱ�������ǣ�Ȼ����������ȷ���ǲ�����Ҫ����
// ���𣺵�һ�ֽⷨ��00λ��,��ʼ�������У��ڶ��ⷨ��11λ��,��ʼ��������
//	�ڶ��ֽⷨ�����һ�л��һ�в�������û��ϵ��������㣬�������ǰ��¼��һ�л��ߵ�һ���Ƿ���Ҫ���㣬����ͻᶪʧ�����Ϣ
	
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
//        mark first cols and first row, �������⣬�����ֳ���������Ҫ�ı��ֳ�
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
//      �ı��һ�к͵�һ�У����б�ǣ� �˲������Ը��ǵ�һ�л��ߵ�һ�е�ԭ������ֵ�����Ա�����ǰ��¼�������ֳ�������matrix[0][0]
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
