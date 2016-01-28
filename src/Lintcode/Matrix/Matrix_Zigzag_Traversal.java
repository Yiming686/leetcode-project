package Lintcode.Matrix;

import java.util.Arrays;

/**

Matrix Zigzag Traversal

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1, 2,  3,  4],
  [5, 6,  7,  8],
  [9,10, 11, 12]
]
return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]

Tags Expand 
LintCode Copyright Matrix


Related Problems Expand 
Medium Spiral Matrix 24 %
Medium Rotate Image

 *
 *
 */
public class Matrix_Zigzag_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{1, 2, 5, 9}, {6, 3, 4, 7}, {10, 11, 8, 12}};
		
		int[][] matrix = {{1, 2,  3,  4}, {5, 6,  7,  8}, {9,10, 11, 12}};
		System.out.println(""+Arrays.toString(printZMatrix(matrix)));
		System.out.println(""+Matrix.fromMatrixToString(matrix));
	}
	
    //My soluton, work
    public static int[] printZMatrix(int[][] matrix) {
        // write your code here
        if(matrix == null) return null;
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int size = rowLen * colLen;
        
        int[] arr = new int[size];
        
        int i = 0, j = 0;
        arr[0] = matrix[0][0];
        
        int index = 1;
        //循环变量index
        while(index < size){
            //step1:单步移动. 如果可以就向右一步，不行，如果可以就向下一步
            if(j+1 < colLen){
                j++;//to right
                arr[index++] = matrix[i][j];	
            }else{
                if(i+1 < rowLen) {
                    i++;//to down
                    arr[index++] = matrix[i][j]; 
                }
            }
            //step2:多步移动.如果可以就持续向左下,不行，如果可以就向右一步
            while(i+1 < rowLen && j-1 >=0){//to leftdown
                i++;
                j--;
                arr[index++] = matrix[i][j];
            }
            //step3:单步移动.如果可以就向下一步，不行，如果可以就向右一步
            if(i+1 < rowLen){
                i++;
                arr[index++] = matrix[i][j];
            }else{
                if(j+1 < colLen){
                    j++;
                    arr[index++] = matrix[i][j];
                }
            }
            //step4:多步移动.如果可以就持续向右上,不行，如果可以就向右一步           
            while(j+1 < colLen && i-1 >=0){//to leftdown
                i--;
                j++;
                arr[index++] = matrix[i][j];
            }
        }
        return arr;
    }

}
