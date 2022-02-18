package Lintcode.Matrix;

import java.util.ArrayList;
import java.util.List;

import Utils.MatrixUtils;

/**
Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Have you met this question in a real interview? Yes
Example
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

Tags Expand 
Array Matrix


Related Problems Expand 
Medium Spiral Matrix II 34 %
Easy Matrix Zigzag Traversal *
 */
public class Spiral_Matrix {

	public static void main(String[] args) {
		
//		String s = "";s.cont
		// TODO Auto-generated method stub
		int[][] matrix = Spiral_Matrix_III.generateMatrix(3,5);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		
		matrix = Spiral_Matrix_III.generateMatrix(0,0);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		
		matrix = Spiral_Matrix_III.generateMatrix(1,1);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		
		matrix = Spiral_Matrix_III.generateMatrix(2,2);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		
		matrix = Spiral_Matrix_III.generateMatrix(3,3);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		
		matrix = Spiral_Matrix_III.generateMatrix(4,4);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		

		matrix = Spiral_Matrix_III.generateMatrix(5,5);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 
		
		matrix = Spiral_Matrix_III.generateMatrix(5,11);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 

		matrix = Spiral_Matrix_III.generateMatrix(7,12);
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));
		System.out.println(""+spiralOrder(matrix)); 

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return result;

		int rows = matrix.length;
		int cols = matrix[0].length;

		// layer: from 0--(rows-1)/2��(cols-1)/2
		int layers = rows < cols ? (rows + 1) / 2 : (cols + 1) / 2;
		int layer = 0;// ��ĸ��ÿһ��while loop ��������count++
		while (layer < layers) {//�������������飺��+��+�ж��˳�+��+��+ѭ����������
			// ���Ҵ�ӡ��count�㣬i��count��cols-count���У��еĿ�ʼ�ͽ�������count����ס
			// �ؼ��Ǵ��б���ӵ�һ��Ԫ�ش�ӡ�����һ��
			for (int i = layer; i <= cols - 1 - layer; i++)
				result.add(matrix[layer][i]);

			// ���´�ӡ��count�㣬i��count+1��cols-count���У��еĿ�ʼ�ͽ�������count����ס
			// �ؼ��Ǵ��б���Ӹ��еڶ���Ԫ�ش�ӡ�����һ��
			for (int i = layer + 1; i <= rows - 1 - layer; i++)
				result.add(matrix[i][cols - layer - 1]);

			//�����������㣺layer �������ӣ������л�������������layer�����һ��ʱ���ڴ˴����Ҫ�˳������Ƿǳ���Ҫ�ģ�
			if ( rows == 2 * layer + 1 || cols == 2 * layer + 1 ) // if rows or cols is odd number and layer is the last one
				break;

			// �����ӡ��count��, i��cols-count-2��ʼ����count
			for (int i = cols - 2 - layer; i >= layer; i--)
				result.add(matrix[rows - layer - 1][i]);

			// ���´�ӡ��count�㣬j��cols-countcount+1�����У��еĿ�ʼ�ͽ�������count����ס
			// �ؼ��Ǵ��б���Ӹ��еڶ���Ԫ�ش�ӡ�����һ��
			for (int i = rows - 2 - layer; i >= layer + 1; i--)
				result.add(matrix[i][layer]);

			layer++;
		}
		return result;
	}
}
