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

		// layer: from 0--(rows-1)/2或(cols-1)/2
		int layers = rows < cols ? (rows + 1) / 2 : (cols + 1) / 2;
		int layer = 0;// 层的概念，每一个while loop 里面增加count++
		while (layer < layers) {//里面做六件事情：右+下+判断退出+左+上+循环变量递增
			// 向右打印：count层，i从count到cols-count，行，列的开始和结束都有count，记住
			// 关键是此行必须从第一个元素打印到最后一个
			for (int i = layer; i <= cols - 1 - layer; i++)
				result.add(matrix[layer][i]);

			// 向下打印：count层，i从count+1到cols-count，行，列的开始和结束都有count，记住
			// 关键是此列必须从该列第二个元素打印到最后一个
			for (int i = layer + 1; i <= rows - 1 - layer; i++)
				result.add(matrix[i][cols - layer - 1]);

			//以下条件满足：layer 不断增加，而当行或列是奇数并且layer是最后一行时，在此处务必要退出。这是非常重要的！
			if ( rows == 2 * layer + 1 || cols == 2 * layer + 1 ) // if rows or cols is odd number and layer is the last one
				break;

			// 向左打印，count层, i从cols-count-2开始，到count
			for (int i = cols - 2 - layer; i >= layer; i--)
				result.add(matrix[rows - layer - 1][i]);

			// 向下打印：count层，j从cols-countcount+1到，行，列的开始和结束都有count，记住
			// 关键是此列必须从该列第二个元素打印到最后一个
			for (int i = rows - 2 - layer; i >= layer + 1; i--)
				result.add(matrix[i][layer]);

			layer++;
		}
		return result;
	}
}
