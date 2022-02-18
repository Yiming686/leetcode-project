package Lai.DB16.DP_III;

import java.util.Arrays;

import Lintcode.Matrix.Matrix;

/**
 * 
 * Given a matrix that contains integers, find the submatrix with the largest
 * sum.
 * 
 * Return the sum of the submatrix.
 * 
 * Assumptions
 * 
 * The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
 * Examples
 * 
 * { {1, -2, -1, 4},
 * 
 * {1, -1, 1, 1},
 * 
 * {0, -1, -1, 1},
 * 
 * {0, 0, 1, 1} }
 * 
 * the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 *
 * 
 */
public class Largest_SubMatrix_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = {{-4,2,-1,0,2},{2,3,2,1,-3},{-3,-3,-2,2,4},{1,1,2,-2,5},{-4,0,1,1,-4}};
//		int[][] arr = { { 1, -2, -1, 4 },
//
//				{ 1, -1, 1, 1 },
//
//				{ 0, -1, -1, 1 },
//
//				{ 0, 0, 1, 1 } };
//		int[][] arr = { { 1 }, { -2 } };
//		int[][] arr = 		{{1}};
		int[][] arr ={{-1,-2,-3},{-4,-3,-2},{-3,0,-1}};
		System.out.println("arr:\n" + Matrix.fromMatrixToString(arr));
		System.out.println("" + largest(arr));

	}

	public static int largest(int[][] matrix) {
		// Write your solution here
		if (matrix == null) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return 0;
		}
		// int[][] sumUp2Down = new int[rows + 1][cols + 1];//前缀和必须多加一个行或者列
		// for (int i = 1; i <= rows; i++) {//row
		// 	for (int j = 1; j <= cols; j++) {//col
		// 		sumUp2Down[i][j] = sumUp2Down[i-1][j] + matrix[i-1][j-1];
		// 	}
		// }
		//System.out.println("sumUp2Down:\n" + Matrix.fromMatrixToString(sumUp2Down));
		int globalMax = Integer.MIN_VALUE;//不可轻易初始化为0，应该为Integer.MIN_VALUE
		int localMax = Integer.MIN_VALUE;//不可轻易初始化为0，应该为Integer.MIN_VALUE
		for (int i = 0; i < rows; i++) {//top
			int[] sum = new int[cols]; //up2downSum
			for (int j = i; j < rows; j++) {//bottom
				sum[0] = sum[0] + matrix[j][0];
				localMax = sum[0];
				globalMax = Math.max(globalMax, localMax);
				for (int k = 1; k < cols; k++) {//col
					sum[k] = sum[k] + matrix[j][k];
					if (localMax < 0) {
						localMax = sum[k];
					} else {
						localMax += sum[k];
						;
					}
					globalMax = Math.max(globalMax, localMax);
				}
			}
			System.out.println(""+Arrays.toString(sum));
		}
		return globalMax;
	}

//	O(N^3)
	public static int largestN3N2(int[][] matrix) {
		// Write your solution here
		if (matrix == null) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return 0;
		}
		int[][] sumUp2Down = new int[rows + 1][cols + 1];//前缀和必须多加一个行或者列
		for (int i = 1; i <= rows; i++) {//row
			for (int j = 1; j <= cols; j++) {//col
				sumUp2Down[i][j] = sumUp2Down[i - 1][j] + matrix[i - 1][j - 1];
			}
		}
		System.out.println("sumUp2Down:\n" + Matrix.fromMatrixToString(sumUp2Down));
		int globalMax = Integer.MIN_VALUE;//不可轻易初始化为0，应该为Integer.MIN_VALUE
		int localMax = Integer.MIN_VALUE;//不可轻易初始化为0，应该为Integer.MIN_VALUE
		for (int i = 0; i <= rows; i++) {//top
			for (int j = i + 1; j <= rows; j++) {//bottom
				for (int k = 1; k <= cols; k++) {//left2right
					if (localMax < 0) {
						localMax = sumUp2Down[j][k] - sumUp2Down[i][k];
					} else {
						localMax += sumUp2Down[j][k] - sumUp2Down[i][k];
					}
					System.out.println("localMax:" + localMax);
					globalMax = Math.max(globalMax, localMax);
				}
				localMax = Integer.MIN_VALUE;
			}
			localMax = Integer.MIN_VALUE;
		}
		return globalMax;
	}

//	O(N^4)
	public static int largest_N4(int[][] matrix) {
		// Write your solution here
		if (matrix == null) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return 0;
		}
		int[][] sum = new int[rows + 1][cols + 1];//前缀和必须多加一个行或者列
		int max = Integer.MIN_VALUE;//不可轻易初始化为0，应该为Integer.MIN_VALUE
//		计算所有的从(0,0)到(rows-1, cols-1)的子矩阵的和，放到多一行多一列的矩阵里，(0,0)对应(1，1)，(rows-1, cols-1)对应(rows, cols)
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
			}
		}
//		System.out.println("sum:\n"+ Matrix.fromMatrixToString(sum));
//		
		for (int i = 0; i < rows; i++) {//针对点
			for (int j = 0; j < cols; j++) {//针对点
				for (int k = i + 1; k <= rows; k++) {//针对点
					for (int m = j + 1; m <= cols; m++) {//针对点
						max = Math.max(max, sum[k][m] - sum[i][m] - sum[k][j] + sum[i][j]);
//						System.out.println("max:"+(sum[k][m] - sum[i][m] - sum[k][j] + sum[i][j]));
					}
				}
			}
		}
		return max;
	}

}
