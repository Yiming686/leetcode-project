package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].

 Hide Tags Array

 * 
 */
public class LC_054_Spiral_Matrix {
	/**
	 * 本代码由九章算法编辑提供。没有版权欢迎转发。
	 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
	 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
	 * - 更多详情请见官方网站：http://www.jiuzhang.com/
	 */

	public class Solution {
	    public ArrayList<Integer> spiralOrder(int[][] matrix) {
	        ArrayList<Integer> rst = new ArrayList<Integer>();
	        if(matrix == null || matrix.length == 0) 
	            return rst;
	        
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int count = 0;
	        while(count * 2 < rows && count * 2 < cols){
	            for(int i = count; i < cols-count; i++)
	                rst.add(matrix[count][i]);
	            
	            
	            for(int i = count+1; i< rows-count; i++)
	                rst.add(matrix[i][cols-count-1]);
	            
	            if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
	                break;
	                
	            for(int i = cols-count-2; i>=count; i--)
	                rst.add(matrix[rows-count-1][i]);
	                
	            for(int i = rows-count-2; i>= count+1; i--)
	                rst.add(matrix[i][count]);
	            
	            count++;
	        }
	        return rst;
	    }
	}
//	Accepted，perfect because ease to understand
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null)
			return list;

		int m = matrix.length;
		if (m < 1)
			return list;
		int n = matrix[0].length;

		int right = n - 1;
		int left = 0;
		int bottom = m - 1;
		int top = 0;

		// while(true){
//		认定这个必须得条件 二者缺一不可
//		在运动中，一旦发现二者之一，不成立，立马退出
//		运动中一律用局部变量
		while (left <= right && top <= bottom) {
			// to right
			for (int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			if (++top > bottom)
				break;
			// to bottom
			for (int j = top; j <= bottom; j++) {
				list.add(matrix[j][right]);
			}
			if (--right < left)
				break;
			// to left
			for (int i = right; i >= left; i--) {
				list.add(matrix[bottom][i]);
			}
			if (--bottom < top)
				break;
			// to top
			for (int j = bottom; j >= top; j--) {
				list.add(matrix[j][left]);
			}
			if (++left > right)
				break;
		}
		return list;
	}

	public static List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null)
			return list;

		int m = matrix.length;
		if (m < 1)
			return list;

		int n = matrix[0].length;

		int right = n - 1;
		int left = 0;
		int bottom = m - 1;
		int top = 0;

		int row = 0, col = 0;
		System.out.printf("   %6s %6s %6s %6s %6s %6s  \n", "row", "col",
				"left", "right", "top", "bottom");
		System.out
				.printf("--------------------------------------------------------------------  \n");
		// while(left<=right && top<=bottom){
		for (int i = 0; i < m * n; i++) {

			System.out.printf("1: %6s %6s %6s %6s %6s %6s  \n", row, col, left,
					right, top, bottom);

			// to right
			for (col = left; col <= right; col++) {
				list.add(matrix[row][col]);
			}
			col--;
			top++;
			// to bottom
			for (row = top; row <= bottom; row++) {
				list.add(matrix[row][col]);
			}
			row--;
			right--;
			// to left
			for (col = right; col >= left; col--) {
				list.add(matrix[row][col]);
			}
			col++;
			bottom--;
			// to top
			for (row = bottom; row >= top; row--) {
				list.add(matrix[row][col]);
			}
			row++;
			left++;
			System.out.printf("2: %6s %6s %6s %6s %6s %6s  \n", row, col, left,
					right, top, bottom);
		}
		System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] matrix = {{1}};
		// int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		// int[][] matrix =
		// {{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
		// int[][] matrix =
		// {{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8}};
		int[][] matrix = { { 2, 3, 4 } };
		// int[][] matrix = {{2},{3},{4}};
		spiralOrder(matrix);
		
	}

}
