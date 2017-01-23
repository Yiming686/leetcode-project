package Lintcode.Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;

/**
Submatrix Sum Show result 

30:00
 Start
Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.

Have you met this question in a real interview? Yes
Example
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]
return [(1,1), (2,2)]

Challenge
O(n3) time.

Tags Expand 
Enumeration Matrix


Related Problems Expand 
Medium Subarray Sum Closest 15 %
Easy Subarray Sum

 *
 */
public class Submatrix_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1 = new int[][]{
			{1 ,5 ,7},
			{3 ,7 ,-8},
			{4 ,-8 ,9}
		};
		int[][] matrix = new int[][]{
			{-3 ,2 ,7},
			{3 ,-2 ,8},
			{4 ,-8 ,2}
		};

		System.out.println(""+Matrix.fromMatrixToString(submatrixSum(matrix)));
	}
	
    public static int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        
        List<int[][]> list = new ArrayList<int[][]> (); 
        
        int M = matrix.length;
        if (M == 0) return list.get(0);
        int N = matrix[0].length;
        if (N == 0) return list.get(0);
        
        // pre-compute: sum[i][j] = sum of submatrix [(0, 0), (i, j)]
        //DP: 含义很重要
        int[][] sum = new int[M+1][N+1];

        //初始化：sum存放当前元素到00元素的组成矩阵的所有元素和        
        for (int i=0; i<M; ++i) {
            for (int j=0; j<N; ++j)
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
        }
		System.out.println(""+Matrix.fromMatrixToString(sum));

        
        for (int l=0; l<M; ++l) {
            for (int h=l+1; h<=M; ++h) {
                //map必须防止这个一行，这个循环内
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                // map.put(0,0);
                for (int j=0; j<=N; ++j) {
                    //差值表示
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                    	int[][] result = new int[2][2];
                        int k = map.get(diff);
                        result[0][0] = l;   result[0][1] = k;
                        result[1][0] = h-1; result[1][1] = j-1;
                        return result;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return list.get(list.size() -1);
    }


}
