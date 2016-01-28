package Lintcode.Matrix;

import Lintcode.Array.Matrix;

/**
Spiral Matrix II Show result 

Given an integer m x n, generate a square matrix filled with elements from 1 to m x n in spiral order.

Have you met this question in a real interview? Yes
Example
Given m = 3,n = 5,

You should return the following matrix:

[  1,   2,   3,   4,   5, ]
[ 12,  13,  14,  15,   6, ]
[ 11,  10,   9,   8,   7, ]

Given m = 5,n = 3,

You should return the following matrix:

[  1,   2,   3, ]
[ 12,  13,   4, ]
[ 11,  14,   5, ]
[ 10,  15,   6, ]
[  9,   8,   7, ]

Note
Tags Expand 
Array


Related Problems Expand 
Medium Spiral Matrix 25 % *
 *
 */
public class Spiral_Matrix_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(-1, -1), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(0, 0), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(1, 1), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(2, 2), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(3, 3), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(4, 4), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(5, 5), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(3, 5), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(5, 3), false));

		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(2, 6), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(6, 2), false));

		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(1, 6), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(6, 1), false));

		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(5, 12), false));
		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(12, 5), false));

	}
	
	public static int[][] generateMatrix(int rowLen, int colLen) {
		// Write your code here
		int[][] arr = new int[rowLen][colLen];
		if (rowLen <= 0)
			return arr;

		int layer = 0;// from 0 to (n+1)/2 - 1. ok, got it
		int layers = rowLen < colLen ? (rowLen + 1) / 2 : (colLen + 1) / 2;
//		int minLen = rowLen < colLen ?rowLen : colLen;
		int count = 1;
		while (layer < layers) {//里面做六件事情：右+下+判断退出+左+上+循环变量递增
			// to right: layer,layer -- i -- layer, colLen-1-layer
			for (int i = layer; i <= colLen - 2 - layer; i++)
				arr[layer][i] = count++;
			// to bottom: layer+1,colLen-1-layer -- rowLen-1-layer, rowLen-1-layer
			for (int i = layer ; i <= rowLen - 1 - layer; i++)
				arr[i][colLen - 1 - layer] = count++;
			//以下条件满足：layer 不断增加，而当行或列是奇数并且layer是最后一行时，在此处务必要退出。这是非常重要的！
			if ( rowLen == 2 * layer + 1 || colLen == 2 * layer + 1 ) // if rows or cols is odd number and layer is the last one
				break;
//			 if( layer == lastLayer) break;			//this condition is wrong
			// to left: rowLen-1-layer,colLen-2-layer -- i -- rowLen-1-layer, layer
			for (int i = colLen - 2 - layer; i >= layer; i--)
				arr[rowLen - 1 - layer][i] = count++;
			// to top: rowLen-2-layer,layer -- layer+1, layer
			for (int i = rowLen - 2 - layer; i >= layer + 1; i--)
				arr[i][layer] = count++;
			layer++;
		}
		return arr;
	}

	//worked
	public static int[][] generateMatrix1(int rowLen, int colLen) {
		// Write your code here
		int[][] arr = new int[rowLen][colLen];
		if (rowLen <= 0)
			return arr;

		int layer = 0;// from 0 to (n+1)/2 - 1. ok, got it
//		int minLen = rowLen < colLen ? rowLen : colLen;
		int layers = rowLen < colLen ? (rowLen + 1) / 2 : (colLen + 1) / 2;
//		int layers = (minLen + 1) / 2;
		int count = 1;

		while (layer < layers) {
			// to right: layer,layer -- i -- layer, colLen-1-layer
			for (int i = layer; i <= colLen - 1 - layer; i++)
				arr[layer][i] = count++;
			// to bottom: layer+1,colLen-1-layer -- rowLen-1-layer, rowLen-1-layer
			for (int i = layer + 1; i <= rowLen - 1 - layer; i++)
				arr[i][colLen - 1 - layer] = count++;
			//以下条件是非常重要的, 向小者看齐, layer 不断增加，当满足此条件是跳出，只看奇数
			 if(rowLen == 2 * layer + 1 || colLen == 2 * layer + 1) break;
//			if(minLen == 2 * layer + 1) break;
			// to left: rowLen-1-layer,colLen-2-layer -- i -- rowLen-1-layer, layer
			for (int i = colLen - 2 - layer; i >= layer; i--)
				arr[rowLen - 1 - layer][i] = count++;
			// to top: rowLen-2-layer,layer -- layer+1, layer
			for (int i = rowLen - 2 - layer; i >= layer + 1; i--)
				arr[i][layer] = count++;
			layer++;
		}
		return arr;
	}

}
