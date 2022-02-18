package Lai.Matrix;

import Lintcode.Matrix.Spiral_Matrix_III;
import Utils.MatrixUtils;

/**
Rotate Matrix

Description
Rotate an N * N matrix clockwise 90 degrees.

Assumptions

The matrix is not null and N >= 0
Examples

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }

Medium
2 D Array *
 */
public class RotateMatrix_NN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = ArrayGenerater.intArray(4, 1, 10);
		int[][] matrix = Spiral_Matrix_III.generateMatrix(4,4);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		rotate(matrix);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));

	}

	  public static void rotate(int[][] matrix) {
		    // Write your solution here
		    int len = matrix[0].length;
		    int layers = len/2;
		    for(int i = 0; i < layers; i++){
		      for(int j = i + 0; j < i + len - 1; j++){
					System.out.printf("%d, %d, %d, %d \n",matrix[i][j], matrix[i + j][i + len - 1], matrix[i + len - 1][i + len - 1 - j], matrix[i + len - 1 - j][i]);

		        int temp = matrix[i][j];
		        matrix[i][j] = matrix[i+len-1-j][i];
		        matrix[i+len-1-j][i] = matrix[i+len-1][i+len-1-j];
		        matrix[i+len-1][i+len-1-j] = matrix[i+j][i+len-1];
		        matrix[i+j][i+len-1] = temp;
		      }
		      len -= 2;
		    }
		  }

	public static void rotate00(int[][] matrix) {
		// Write your solution here
		int len = matrix[0].length;
		int layers = len / 2;
		for (int i = 0; i < layers; i++) {
			for (int j = i; j < i + len - 1; j++) {
				System.out.printf("%d, %d, %d, %d \n",matrix[i][j], matrix[i + j][i + len - 1], matrix[i + len - 1][i + len - 1 - j], matrix[i + len - 1 - j][i]);
//				System.out.printf("%d, %d, %d, %d \n",3);
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i + len - 1 - j][i];
				matrix[i + len - 1 - j][i] = matrix[i + len - 1][i + len - 1 - j];
				matrix[i + len - 1][i + len - 1 - j] = matrix[i + j][i + len - 1];
				matrix[i + j][i + len - 1] = temp;
			}
			len -= 2;
		}
	}

}
