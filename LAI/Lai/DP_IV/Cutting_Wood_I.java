package Lai.DP_IV;

import static Utils.TreeNodeUtils.printTree;
import static Utils.ArrayUtils.*;
import java.util.Arrays;

//import Utils.ArrayUtils.*;
import Utils.MatrixUtils;

public class Cutting_Wood_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 4, 7};
		int length = 10;
		System.out.println(""+minCost_00(arr, length));
		System.out.println(""+minCost_01(arr, length));//like min cuts to get all palindrome
//		System.out.println(""+minCost_02(arr, length));
	}
	
	public static int minCost_02(int[] cuts, int length) {
		// Assumptions: cuts is not null, length >= 0, all cuts are valid numbers.
		// First we need to pad the original array at leftmost and
		// rightmost position.
		int[] helper = new int[cuts.length + 2];
		helper[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = length;   
		// minCost[i][j]: the min cost of cutting the partition(i,j).
		int[][] minCost = new int[helper.length][helper.length];
		for (int i = 0; i < helper.length; i++) {
			for (int j = i; j < helper.length; j++) {
				if (j == i ||  j == i + 1) {
					minCost[i][j] = 0;
				} else {
					printf("i:j %d:%d\n", i, j);
					minCost[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
					}
					minCost[i][j] += helper[j] - helper[i];
					printf(""+MatrixUtils.fromMatrixToString(minCost));
				}
			}
		}
		return minCost[0][helper.length - 1];
	}
	
//	like min cuts to get all palindromes
	public static int minCost_01(int[] cuts, int length) {
		// Assumptions: cuts is not null, length >= 0, all cuts are valid numbers.
		// First we need to pad the original array at leftmost and
		// rightmost position.
		int[] helper = new int[cuts.length + 2];
		helper[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = length;   
		// minCost[i][j]: the min cost of cutting the partition(i,j).
		int[][] minCost = new int[helper.length][helper.length];
		for (int i = helper.length - 1; i >= 0; i--) {
			for (int j = i; j < helper.length; j++) {
				if (j == i ||  j == i + 1) {
					minCost[i][j] = 0;
				} else {
					printf("i:j %d:%d\n", i, j);
					minCost[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
					}
					minCost[i][j] += helper[j] - helper[i];
					printf(""+MatrixUtils.fromMatrixToString(minCost));
				}
			}
		}
		return minCost[0][helper.length - 1];
	}

	public static int minCost_00(int[] cuts, int length) {
		// Assumptions: cuts is not null, length >= 0, all cuts are valid numbers.
		// First we need to pad the original array at leftmost and
		// rightmost position.
		int[] helper = new int[cuts.length + 2];

		helper[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = length;
		// minCost[i][j]: the min cost of cutting the partition(i,j).
		int[][] minCost = new int[helper.length][helper.length];
		for (int j = 1; j < helper.length; j++) {
			for (int i = j - 1; i >= 0; i--) {
				if (i + 1 == j) {
					minCost[i][j] = 0;
				} else {
					printf("i:j %d:%d\n", j, i);
					minCost[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k <= j - 1; k++) {
						minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
					}
					minCost[i][j] += helper[j] - helper[i];
					printf(""+MatrixUtils.fromMatrixToString(minCost));
				}
			}
		}
//		System.out.println(""+MatrixUtils.fromMatrixToString(minCost));
		return minCost[0][helper.length - 1];
	}

}
