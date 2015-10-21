package LeetCode.JavaArray;

/*
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Hide Tags Array

 * 
 */
public class LC_073_Set_Matrix_Zeroes {

//	Accepted:
//	找到第一个为0的点，记录坐标x和y。然后一旦发现为0的元素，在x行和y列标记
//	然后循环
//	第一个全循环，碰到策略不一样：第一次碰到0元素，用xy记录，以后碰到0元素，标记在x行和y列，可以覆盖元素
//	容易搞错: 既不在x行，也不在y列的元素：if(i!=x && j!=y )
	public static void setZeroes(int[][] matrix) {
		printArrayInMatrix(matrix);
		if (matrix == null)
			return;
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;

		int x = -1, y = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (x == -1 && y == -1) {
						x = i;
						y = j;
					} else {
						matrix[x][j] = 0;
						matrix[i][y] = 0;
					}
				}
			}
		}
		printArrayInMatrix(matrix);
		if (x == -1 || y == -1)
			return;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i!=x && j!=y ){
					if (matrix[x][j] == 0 || matrix[i][y] == 0) {
						matrix[i][j] = 0;
					}
					
				}
			}
		}
		for (int i = 0; i < m; i++) {
			matrix[i][y] = 0;
		}
		for (int j = 0; j < n; j++) {
			matrix[x][j] = 0;
		}
		printArrayInMatrix(matrix);
	}

//	
//			Input:		[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
//			Output:		[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
//			Expected:	[[0,0,0,0],[0,0,0,4],[0,0,0,0],[0,0,0,3],[0,0,0,0]]

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {0,0,0,5 },{4,3,1,4},{0,1,1,4},{1,2,0,3},{0,0,1,1} };
//		printArrayInMatrix(matrix);
		setZeroes(matrix);
	}
	private static void printArrayInMatrix(int[][] arr) {
		int count = arr.length * arr[0].length;
		// int width = new Integer(count).toString().length();
		int width = Integer.valueOf(count).toString().length() + 2;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%-" + width + "s", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * 本代码由九章算法编辑提供。没有版权欢迎转发。 - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。 -
	 * 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班 - 更多详情请见官方网站：http://www.jiuzhang.com/
	 */

	public class Solution {
		// using O(m+n) is easy, to enable O(1), we have to use the space within
		// the matrix
		public void setZeroes(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return;

			int rows = matrix.length;
			int cols = matrix[0].length;

			boolean empty_row0 = false;
			boolean empty_col0 = false;
			for (int i = 0; i < cols; i++) {
				if (matrix[0][i] == 0) {
					empty_row0 = true;
					break;
				}
			}

			for (int i = 0; i < rows; i++) {
				if (matrix[i][0] == 0) {
					empty_col0 = true;
					break;
				}
			}

			for (int i = 1; i < rows; i++) {
				for (int j = 1; j < cols; j++) {
					if (matrix[i][j] == 0) {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}

			for (int i = 1; i < rows; i++) {
				for (int j = 1; j < cols; j++) {
					if (matrix[0][j] == 0 || matrix[i][0] == 0)
						matrix[i][j] = 0;
				}
			}

			if (empty_row0) {
				for (int i = 0; i < cols; i++) {
					matrix[0][i] = 0;
				}
			}

			if (empty_col0) {
				for (int i = 0; i < rows; i++) {
					matrix[i][0] = 0;
				}
			}

		}
	}
}
