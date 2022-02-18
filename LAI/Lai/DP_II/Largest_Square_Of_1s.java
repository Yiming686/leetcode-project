package Lai.DP_II;

import Utils.MatrixUtils;
import Utils.MatrixUtils;

public class Largest_Square_Of_1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1}
		};
		System.out.println(""+MatrixUtils.fromMatrixToString(matrix));;
		System.out.println("maxLen: "+largest(matrix));
	}
	
	  public static int largest(int[][] matrix) {
		    // Write your solution here
		    if(matrix.length == 0){
		      return 0;
		    }
		    int rows = matrix.length;
		    int cols = matrix[0].length;
		    int[][] arr = new int[rows][cols];//右下角为端点的最大矩阵边长
		    int maxLen = 0;
		    for(int i = 0; i < rows; i++){
		      for(int j = 0; j < cols; j++){
		        if(i == 0 || j == 0){
		          arr[i][j] = matrix[i][j] == 0 ? 0 : 1; 
		        }else if(matrix[i][j] == 1){
		          arr[i][j] = Math.min(arr[i][j - 1] + 1, arr[i-1][j] + 1);
		          arr[i][j] = Math.min(arr[i][j], arr[i - 1][j -1] + 1);
		        }
		        System.out.println(""+MatrixUtils.fromMatrixToString(arr));;
		        maxLen = Math.max(maxLen, arr[i][j]);
		      }
		    }
		    return maxLen;
		  }


}
