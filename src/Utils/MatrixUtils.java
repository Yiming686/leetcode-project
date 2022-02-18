package Utils;

import static Utils.StringUtils.toDashStr;
import static Utils.StringUtils.toSpaceStr;
import static Utils.StringUtils.toUnderscoreStr;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

public class MatrixUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static String fromSubMatrixToString(int[][] arr, int rowLeftTop, int colLeftTop, int rowRightBottom,
			int colRightBottom) throws IllegalArgumentException {
		boolean showsRowCol = true;
		return fromSubMatrixToString(arr, rowLeftTop, colLeftTop, rowRightBottom, colRightBottom, showsRowCol);
	}

	static String fromSubMatrixToString(int[][] arr, int rowLeftTop, int colLeftTop, int rowRightBottom,
			int colRightBottom, boolean showsRowCol) throws IllegalArgumentException {
		if (arr == null)
			throw new IllegalArgumentException("Null Matrix!");
		if (arr.length == 0)
			return "[]";
		int rows = arr.length;
		int cols = arr[0].length;
		if (rowLeftTop < 0 || rowLeftTop >= rows || rowRightBottom < 0 || rowRightBottom >= rows)
			throw new IllegalArgumentException("Illegal Arguments!");
		if (colLeftTop < 0 || colLeftTop >= cols || colRightBottom < 0 || colRightBottom >= cols)
			throw new IllegalArgumentException("Illegal Arguments!");
		if (rowLeftTop > rowRightBottom || colLeftTop > colRightBottom)
			throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for (int i = rowLeftTop; i <= rowRightBottom; i++) {
			for (int j = colLeftTop; j <= colRightBottom; j++) {
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" + valStrWidth + "s, ";

		int rowStrWidth = String.valueOf(rowRightBottom).length();
		int colStrWidth = String.valueOf(colRightBottom).length();

		StringBuilder sb = new StringBuilder();

		for (int i = rowLeftTop; i <= rowRightBottom; i++) {
			if (showsRowCol) {
				sb.append(String.format(
						"[ row:col  %" + rowStrWidth + "d :%" + colStrWidth + "d-%" + colStrWidth + "d ] ", i,
						colLeftTop, colRightBottom));
			}
			sb.append("[");
			for (int j = colLeftTop; j <= colRightBottom; j++) {
				sb.append(String.format(formatStr, arr[i][j]));
			}
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();

	}

	public static String fromMatrixToString(char[][] arr) throws IllegalArgumentException {
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}

	public static String fromMatrixToString(String[][] arr) throws IllegalArgumentException {
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}

	public static String fromMatrixToString(String[][] arr, boolean showsRowCol) throws IllegalArgumentException {
		if (arr == null)
			throw new IllegalArgumentException("Null or Empty Matrix!");
		if (arr.length == 0)
			return "[]";
		int strLen = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
		}
		return sb.toString();

	}

	public static String fromMatrixToString(char[][] arr, boolean showsRowCol) throws IllegalArgumentException {
		if (arr == null)
			throw new IllegalArgumentException("Null or Empty Matrix!");
		if (arr.length == 0)
			return "[]";
		int strLen = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
		}
		return sb.toString();

	}

	public static String fromMatrixToString(boolean[][] arr) throws IllegalArgumentException {
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}

	public static String fromMatrixToString(boolean[][] arr, boolean showsRowCol) throws IllegalArgumentException {
		Objects.requireNonNull(arr);
//		if(arr == null)  throw new IllegalArgumentException("Null or Empty Matrix!");
		if (arr.length == 0)
			return "[]";
		int strLen = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
		}
		return sb.toString();
	}

	public static String fromRowOfMatrixToString(boolean[][] arr, int row, boolean showsRowCol) {

		if (arr == null)
			throw new IllegalArgumentException("Null Matrix!");
		if (arr.length == 0)
			throw new IllegalArgumentException("Empty Matrix!");
		if (row < 0 || row >= arr.length)
			throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" + valStrWidth + "s, ";

		int rowStrWidth = String.valueOf(arr.length).length();
		int colStrWidth = String.valueOf(arr[0].length).length();
		
		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if (showsRowCol) {
			sb.append(String.format("[ row:col  %" + rowStrWidth + "d : %" + 1 + "d-%" + colStrWidth + "d ] ", row, 0,
					arr[0].length));
		}

		sb.append("[");
		for (int i = 0; i < arr[row].length; i++) {
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	public static String fromMatrixToString(int[][] arr) throws IllegalArgumentException {
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}

	public static String fromMatrixToString(int[][] arr, boolean showsRowCol) throws IllegalArgumentException {
		if (arr == null)
			throw new IllegalArgumentException("Null or Empty Matrix!");
		if (arr.length == 0)
			return "\n[]";
		int strLen = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
//		sb.append("\n");//added on Jun 28, 2019, because of TP.print();
//		sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
		
		int valStrWidth = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String valFormatStr = " %" + valStrWidth + "s, ";

		int rowStrWidth = String.valueOf(arr.length).length();
		int colStrWidth = String.valueOf(arr[0].length).length();

//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		String rowPrefix = "[ row:col  %" + rowStrWidth + "d : %" + 1 + "d-%" + colStrWidth + "d ] ";
//		System.out.println("rowPrefix: |"+rowPrefix);
//		System.out.println("rowPrefix: |"+rowPrefix);
		String firtRowPrefix = String.format(rowPrefix, 0, 0, arr[0].length-1);
//		sb.append("|");
//		String rowPrefix2 = "[ row:col  " + toSpaceStr(rowStrWidth) + " : " + toSpaceStr(1) + "" + toSpaceStr(colStrWidth) + " ] ";
		if (showsRowCol) {
//			sb.append(toSpaceStr(firtRowPrefix.length()));
			sb.append(toUnderscoreStr(firtRowPrefix.length()+1));
		}else {
			
		}
//		sb.append("|");
		for (int i = 0; i < arr[0].length; i++) {
			sb.append(String.format(valFormatStr, i).replace(' ', '_').replace(',', '_'));
		}
		sb.append("_\n");

//		boolean isFirst = true;
//		if(isFirst) {
//			sb.insert(0, prefix);
//			isFirst = false;
//		}
//		sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(fromRowOfMatrixToString(arr, i, rowPrefix, valFormatStr, showsRowCol));
		}
		return sb.toString();

	}

	public static String fromRowOfMatrixToString(char[][] arr, int row, boolean showsRowCol) {

		if (arr == null)
			throw new IllegalArgumentException("Null Matrix!");
		if (arr.length == 0)
			throw new IllegalArgumentException("Empty Matrix!");
		if (row < 0 || row >= arr.length)
			throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" + valStrWidth + "s, ";
		StringBuilder sb = new StringBuilder();
		
		int rowStrWidth = String.valueOf(arr.length).length();
		int colStrWidth = String.valueOf(arr[0].length).length();
		String prefix = "";
		if (showsRowCol) {
			prefix = String.format("[ row:col  %" + rowStrWidth + "d : %" + 1 + "d-%" + colStrWidth + "d ] ", row, 0,
					arr[0].length-1);
			sb.append(prefix);
		}


//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if (showsRowCol) {
			sb.append(String.format("[ row:col  %" + rowStrWidth + "d : %" + 1 + "d-%" + colStrWidth + "d ] ", row, 0,
					arr[0].length-1));
		}

		sb.append("[");
		for (int i = 0; i < arr[row].length; i++) {
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	public static String fromRowOfMatrixToString(int[][] arr, int row, String rowPrefix,String valFormatStr) {
		boolean showsRowCol = true;
		return fromRowOfMatrixToString(arr, row, rowPrefix, valFormatStr, showsRowCol);
	}

	public static String fromRowOfMatrixToString(int[][] arr, int row, String rowPrefix, String valFormatStr, boolean showsRowCol) {

		if (arr == null)
			throw new IllegalArgumentException("Null Matrix!");
		if (arr.length == 0)
			throw new IllegalArgumentException("Empty Matrix!");
		if (row < 0 || row >= arr.length)
			throw new IllegalArgumentException("Illegal Arguments!");
//		int valStrWidth = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
//			}
//		}
//		String formatStr = " %" + valStrWidth + "s, ";

//		int rowStrWidth = String.valueOf(arr.length).length();
//		int colStrWidth = String.valueOf(arr[0].length).length();

		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
//		String prefix = "";
		if (showsRowCol) {
			rowPrefix = String.format(rowPrefix, row, 0, arr[0].length-1);
			sb.append(rowPrefix);
		}

		sb.append("[");

		for (int i = 0; i < arr[row].length; i++) {
			sb.append(String.format(valFormatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	public static String fromRowOfMatrixToString(Object[][] arr, int row) {
		boolean showsRowCol = true;
		return fromRowOfMatrixToString(arr, row, showsRowCol);
	}

	public static String fromRowOfMatrixToString(Object[][] arr, int row, boolean showsRowCol) {

		if (arr == null)
			throw new IllegalArgumentException("Null Matrix!");
		if (arr.length == 0)
			throw new IllegalArgumentException("Empty Matrix!");
		if (row < 0 || row >= arr.length)
			throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" + valStrWidth + "s, ";

		int rowStrWidth = String.valueOf(arr.length).length();
		int colStrWidth = String.valueOf(arr[0].length).length();

		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if (showsRowCol) {
			sb.append(String.format("[ row:col  %" + rowStrWidth + "d : %" + 1 + "d-%" + colStrWidth + "d ] ", row, 0,
					arr[0].length));
		}

		sb.append("[");
		for (int i = 0; i < arr[row].length; i++) {
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	public static int[][] fromStringToMatrix(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.length() == 0) {
			return null;
		}
		str = str.trim();
		str = str.substring(2, str.length() - 2);
		String[] arr = str.split("\\],\\[");
		int[][] matrix = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			matrix[i] = ArrayUtils.fromStringToArray(arr[i]);
		}
		return matrix;
	}

	public static char[][] buildMatrix(int rows, int cols, Map<Character, Integer> char2ProbMap) {
		boolean toPrint = false;
		return buildMatrix(rows, cols, char2ProbMap, toPrint);
	}

	public static char[][] buildMatrix(int rows, int cols, Map<Character, Integer> char2ProbMap, boolean toPrint) {
		// TODO Auto-generated method stub
		List<Character> list = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : char2ProbMap.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				list.add(entry.getKey());
			}
		}
		return buildMatrix(rows, cols, list, toPrint);
	}

	public static char[][] buildMatrix(int rows, int cols, List<Character> list) {
		boolean toPrint = false;
		return buildMatrix(rows, cols, list, toPrint);
	}

	public static char[][] buildMatrix(int rows, int cols, List<Character> list, boolean toPrint) {
		char[][] matrix = new char[rows][];
		for (int i = 0; i < rows; i++) {
			matrix[i] = ArrayUtils.buildCharArrayWithDup(cols, list, toPrint);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int row = 0; row < rows; row++) {
			if (row != 0) {
				sb.append(',');
			}
			sb.append("{");
			for (int col = 0; col < rows; col++) {
				if (col != 0) {
					sb.append(',');
				}
				sb.append("'");
				sb.append(matrix[row][col]);
				sb.append("'");
			}
			sb.append("}");
		}
		sb.append("}");
		sb.append(";");
		System.out.println("Matrix: \n" + sb.toString() +"\n");
		return matrix;

	}

	public static void printCharArray(char[][] matrix) {
		// TODO Auto-generated method stub
		System.out.println("" + MatrixUtils.fromMatrixToString(matrix));
	}

	public static void print(char[][] matrix) {
		// TODO Auto-generated method stub
		System.out.println("" + MatrixUtils.fromMatrixToString(matrix));
	}
	public static void printIntArray(int[][] matrix) {
		// TODO Auto-generated method stub
		System.out.println("" + MatrixUtils.fromMatrixToString(matrix));
		;
	}

	public static void print(int[][] matrix) {
		// TODO Auto-generated method stub
		System.out.println("" + MatrixUtils.fromMatrixToString(matrix));
		;
	}


//	public static void print(char[][] matrix) {
//		// TODO Auto-generated method stub
//		
//	}

}
