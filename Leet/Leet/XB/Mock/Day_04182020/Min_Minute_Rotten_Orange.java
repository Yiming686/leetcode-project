package Leet.XB.Mock.Day_04182020;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.security.provider.JavaKeyStore.CaseExactJKS;

public class Min_Minute_Rotten_Orange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 2, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 } };
		System.out.println("" + minMinute(matrix));

	}

//	case: 0, do nothing
//	case: 1, check closest dist to 2
//	case: 2, do nothing
	private static int minMinute(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int min = Integer.MAX_VALUE;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (matrix[row][col] == 1) {// from 1 to 2,if 0, stop,  if can not find return -1;
					int len = minLen(matrix, row, col); //find closest distance to rotten orange
					if (len == Integer.MAX_VALUE) {
						return -1;
					} else {
						min = Math.min(min, len);
					}
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static int minLen(int[][] matrix, int row, int col) {

		return 0;
	}

}
