package Lai.Ace.Mock;

import static Utils.ArrayUtils.printf;
import static Utils.TreeNodeUtils.toStr;

import java.util.Arrays;

import Utils.ArrayUtils;
import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

public class LC_1105_Filling_Bookcase_Shelves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayUtils.convertSquareBracketStr2IntArrCurlyBraceStr("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]");
		int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
		int shelf_width = 4;
//		System.out.println(""+minHeightShelves(books, shelf_width));
		System.out.println("" + minHeightShelves_TP(books, shelf_width));
	}

	public int minHeightShelves(int[][] books, int shelf_width) {
		int[] minHeight = new int[books.length + 1];
		Arrays.fill(minHeight, Integer.MAX_VALUE);
		minHeight[books.length] = 0;
		minHeightShelves(books, shelf_width, minHeight, 0);
		return minHeight[0];
	}

	private void minHeightShelves(int[][] books, int shelf_width, int[] minHeight, int pos) {
		if (pos == books.length) {
			return;
		}
		int height = 0;
		int width = 0;
		for (int i = pos; i < books.length; i++) {
			width += books[i][0];
			height = Math.max(height, books[i][1]);
			if (width <= shelf_width) {
				if (minHeight[pos] == Integer.MAX_VALUE) {
					minHeightShelves(books, shelf_width, minHeight, i + 1);
				}
				minHeight[pos] = Math.min(minHeight[pos], height + minHeight[i + 1]);
			} else {
				break;
			}
		}

	}

	public static int minHeightShelves_TP(int[][] books, int shelf_width) {
		int[] minHeight = new int[books.length + 1];
		Arrays.fill(minHeight, Integer.MAX_VALUE);
		minHeight[books.length] = 0;
		TP root = TP.build("", "1111", "root", null, shelf_width, StringUtils.toStr(minHeight), 0, 0);
		minHeightShelves_TP(books, shelf_width, minHeight, 0, 0, root);
		root.print();
		return minHeight[0];
	}

	private static void minHeightShelves_TP(int[][] books, int shelf_width, int[] minHeight, int pos, int level,
			TP root) {
		if (pos == books.length) {
			return;
		}
		int height = 0;
		int width = 0;
		for (int i = pos; i < books.length; i++) {
//        		printf("pos:i %d:%d", pos, i);
			width += books[i][0];
			height = Math.max(height, books[i][1]);
//            printf("w:h %d:%d", width, height);
			if (width <= shelf_width) {
				if (minHeight[pos] != 0) {
					minHeightShelves_TP(books, shelf_width, minHeight, i + 1, level + 1,
							TP.build(root, shelf_width, StringUtils.toStr(minHeight), i + 1, level + 1));
				}

				minHeight[pos] = Math.min(minHeight[pos], height + minHeight[i + 1]);
			} else {
				break;
			}
		}

	}

}
