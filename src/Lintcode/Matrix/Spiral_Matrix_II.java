package Lintcode.Matrix;

import Utils.MatrixUtils;

/**
Spiral Matrix II Show result 

Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

Have you met this question in a real interview? Yes
Example
Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
Note
Tags Expand 
Array


Related Problems Expand 
Medium Spiral Matrix 25 % *
 */
public class Spiral_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Matrix.fromSubMatrixToString(generateMatrix(33), 7, 8, 15,15);
//		System.out.println(""+Matrix.fromRowOfMatrixToString(generateMatrix(0), 3));
		System.out.println(""+MatrixUtils.fromMatrixToString(generateMatrix(0)));
		System.out.println(""+MatrixUtils.fromMatrixToString(generateMatrix(1)));
		System.out.println(""+MatrixUtils.fromMatrixToString(generateMatrix(2)));
		System.out.println(""+MatrixUtils.fromMatrixToString(generateMatrix(3)));
		System.out.println(""+MatrixUtils.fromMatrixToString(generateMatrix(4), false));
		System.out.println(""+MatrixUtils.fromMatrixToString(generateMatrix(9), false));
//		System.out.println(""+Matrix.fromMatrixToString(generateMatrix(5), false));
//		System.out.println(""+Matrix.fromSubMatrixToString(generateMatrix(16), 8, 9, 14,14));
//		System.out.println(""+Matrix.fromSubMatrixToString(generateMatrix(33), 7, 8, 15,15));
//		System.out.println(""+Matrix.fromSubMatrixToString(generateMatrix(0), 0,0,0,0));

		
	}
	//worked
    public static int[][] generateMatrix(int n) {
        // Write your code here
        int[][] arr = new int[n][n];
       if(n <=0) return arr;
        
        int layers = (n+1)/2;
        int count = 1;
        //layer是循环变量，赋初值，退出循环条件，循环里面不断改变其值，一般在循环体最后一行
        int layer = 0;// from 0 to (n+1)/2 - 1. ok, got it
        while(layer < layers){
            //to right: layer,layer -- i -- layer, n-1-layer
            for(int i = layer; i <= n - 1 - layer; i++)
                arr[layer][i] = count++;
            //to bottom: layer+1,n-1-layer -- n-1-layer, n-1-layer
            for(int i = layer+1; i <= n - 1 - layer; i++)
                arr[i][n-1-layer] = count++;
            //因为是方阵，所以下面条件不需要，the following is useless
            // if(n == 2 * layer + 1) break;
            //to left: n-1-layer,n-1-layer -- i -- n-1-layer, layer
            for(int i = n-2-layer; i >= layer; i--)
                arr[n-1-layer][i] = count++;
            //to top: n-1-layer,layer -- layer+1, layer
            for(int i = n-2-layer; i >= layer+1; i--)
                arr[i][layer] = count++;
            layer++;
        }
        return arr;
    }

    
}
