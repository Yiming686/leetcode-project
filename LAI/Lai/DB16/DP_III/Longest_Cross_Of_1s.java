package Lai.DB16.DP_III;

import com.sun.scenario.effect.Merge;

import Lintcode.Matrix.Matrix;

/**
 * Given a matrix that contains only 1s and 0s, find the largest cross which
 * contains only 1s, with the same arm lengths and the four arms joining at the
 * central point.
 * 
 * Return the arm length of the largest cross.
 * 
 * Assumptions
 * 
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0. Examples
 * 
 * { {0, 0, 0, 0},
 * 
 * {1, 1, 1, 1},
 * 
 * {0, 1, 1, 1},
 * 
 * {1, 0, 1, 1} }
 *
 *
 * 
 */
public class Longest_Cross_Of_1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{0, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 1, 1, 1},
				{1, 0, 1, 1}};
		System.out.println(""+Matrix.fromMatrixToString(matrix));
		System.out.println(""+largest(matrix));

	}

/*
	Base case: 
	1. one element: return 1 if 1; return 0 if 0;
	好神奇，有一种方法，遍历完矩阵，就知道十字交叉的长度！这个中心还是动态的，所以必须遍历所有可能的中心，然后中心开花法！
	遍历所有中心，中心开花，求得四个方向的最小值，返回全局的最小值！
	Induction Rule:
	1. 动起来，


* */
	public static int largest(int[][] matrix) {
		// Write your solution here
		if(matrix == null) {
			return -1;
		}
		if(matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] leftUp = leftUp(matrix);
		int[][] rightDown = rightDown(matrix);
		
		return merge(leftUp, rightDown );
	}


//	fill two matrixes left and up in two for loops
	private static int[][] leftUp(int[][] matrix) {
		// TODO Auto-generated method stub
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] left = new int[rows][cols];
		int[][] up = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == 1) {
					if(i == 0 && j == 0) {
						left[i][j] = 1;
						up[i][j] = 1;
					}else if(i == 0){
						left[i][j] = left[i][j - 1] + 1;//check left
						up[i][j] = 1;
					}else if(j == 0) {
						left[i][j] = 1;
						up[i][j] = up[i-1][j] + 1;//check up				
					}else {
						left[i][j] = left[i][j - 1] + 1;
						up[i][j] = up[i-1][j] + 1;		
					}
				}
			}
		}
		System.out.println("left:\n"+Matrix.fromMatrixToString(left));
		System.out.println("up:\n"+Matrix.fromMatrixToString(up));
		merge(left, up);
		System.out.println("leftUp:\n"+Matrix.fromMatrixToString(left));
		return left;
	}

	private static int[][] rightDown(int[][] matrix) {
		// TODO Auto-generated method stub
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] right = new int[rows][cols];
		int[][] down = new int[rows][cols];
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = cols - 1; j >= 0; j--) {
				if(matrix[i][j] == 1) {
					if(i == rows - 1 && j == cols - 1) {
						right[i][j] = 1;
						down[i][j] = 1;
					}else if(i == rows - 1){
						right[i][j] = right[i][j + 1] + 1;//check right
						down[i][j] = 1;
					}else if(j == cols - 1) {
						right[i][j] = 1;
						down[i][j] = down[i+1][j] + 1;//check down						
					}else {
						right[i][j] = right[i][j + 1] + 1;
						down[i][j] = down[i+1][j] + 1;		
					}
				}
			}
		}
		System.out.println("right:\n"+Matrix.fromMatrixToString(right));
		System.out.println("down:\n"+Matrix.fromMatrixToString(down));
		merge(right, down);
		System.out.println("rightDown:\n"+Matrix.fromMatrixToString(right));
		return right;
	}
	
	private static int merge(int[][] one, int[][] two) {
		// TODO Auto-generated method stub
		int result = 0;
		int rows = one.length;
		int cols = one[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				one[i][j] = Math.min(one[i][j], two[i][j]);
				result = Math.max(result, one[i][j]);
			}
		}
		return result;
	}

}
