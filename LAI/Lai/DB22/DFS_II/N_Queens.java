package Lai.DB22.DFS_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class N_Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("01:\n" + nqueens01(4));
//		System.out.println("02:\n" + nqueens02(8));
	}

//	worked, Best Ever
//	Time: O(N*N^N), Space: O(N)
	public static List<List<Integer>> nqueens01(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sol = new ArrayList<>();
		// int[] cur = new int[n];
		int row = 0;
		boolean[] usedColumns = new boolean[n];
		boolean[] usedDiagonals = new boolean[2 * n - 1];
		boolean[] usedRevDiagonals = new boolean[2 * n - 1];
//		TP root = TP.build("", "1111000", null, result, sol, n, row, Arrays.toString(usedColumns), Arrays.toString(usedDiagonals), Arrays.toString(usedRevDiagonals));
//		helper(result, sol, n, row, usedColumns, usedDiagonals, usedRevDiagonals, root);
		TP root = TP.build("", "1111000", null, result, sol, n, row, Arrays.toString(usedColumns), Arrays.toString(usedDiagonals), Arrays.toString(usedRevDiagonals));
		helper(result, sol, n, row, usedColumns, usedDiagonals, usedRevDiagonals, root);
		root.print();
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> sol, int n, int row, boolean[] usedColumns,
			boolean[] usedDiagonals, boolean[] usedRevDiagonals,TP root) {
		if (row == n) {
			result.add(new ArrayList<>(sol));
			root.mark();
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(n, row, col, usedColumns, usedDiagonals, usedRevDiagonals)) {
				mark(n, row, col, usedColumns, usedDiagonals, usedRevDiagonals);//赶紧把当前点标记好
				sol.add(col);//开始尝试
				helper(result, sol, n, row + 1, usedColumns, usedDiagonals, usedRevDiagonals, TP.build(root, result, sol, n, row + 1, Arrays.toString(usedColumns), Arrays.toString(usedDiagonals), Arrays.toString(usedRevDiagonals)));//进入下一步
				sol.remove(sol.size() - 1);//尝试完毕，赶紧恢复原样
				unmark(n, row, col, usedColumns, usedDiagonals, usedRevDiagonals);//尝试完毕，赶紧恢复原样
			}
		}
	}

	//sol截止目前已经确定的Q位置，row，col为当前的try的行列
	// O(1)
	// 为了判断，如果同列没有，正反截距也都没有queen，那么就是valid的
	private static boolean isValid(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
			boolean[] usedRevDiagonals) {
		return !usedColumns[col] && !usedDiagonals[col + row] && !usedRevDiagonals[row - col + n - 1];//row - col ,   col - row
	}

	private static void mark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
			boolean[] usedRevDiagonals) {
		usedColumns[col] = true;
		usedDiagonals[row + col] = true;
		usedRevDiagonals[row - col + n - 1] = true;
	}

	private static void unmark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
			boolean[] usedRevDiagonals) {
		usedColumns[col] = false;
		usedDiagonals[row + col] = false;
		usedRevDiagonals[row - col + n - 1] = false;
	}

//		============================================================================================================================
//		wworked, valid is O(N)
//		Time: O(N*N^N), Space: O(N)
	public static List<List<Integer>> nqueens02(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sol = new ArrayList<>();
		int row = 0;
		helper(result, sol, row, n);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> sol, int row, int n) {
		if (row == n) {
			result.add(new ArrayList<>(sol));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(sol, row, col)) {
				sol.add(col);
				helper(result, sol, row + 1, n);
				sol.remove(sol.size() - 1);
			}
		}
	}

	//sol截止目前已经确定的Q位置，row，col为当前的try的行列
	// O(N)
	private static boolean isValid(List<Integer> sol, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (sol.get(i) == col || Math.abs(sol.get(i) - col) == row - i) {
				return false;
			}
		}
		return true;
	}

}
