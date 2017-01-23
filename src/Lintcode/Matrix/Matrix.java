package Lintcode.Matrix;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static String fromSubMatrixToString(char[][] arr, int rowLeftTop, int colLeftTop, int rowRightBottom, int colRightBottom) throws IllegalArgumentException{
		boolean showsRowCol = true;
		return fromSubMatrixToString(arr,  rowLeftTop,  colLeftTop,  rowRightBottom,  colRightBottom, showsRowCol);
	}
	static String fromSubMatrixToString(char[][] arr, int rowLeftTop, int colLeftTop, int rowRightBottom, int colRightBottom, boolean showsRowCol) throws IllegalArgumentException{
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) return "[]";
		int rows = arr.length;
		int cols = arr[0].length;
		if(rowLeftTop<0 || rowLeftTop>=rows || rowRightBottom<0 || rowRightBottom>=rows) throw new IllegalArgumentException("Illegal Arguments!");
		if(colLeftTop<0 || colLeftTop>=cols || colRightBottom<0 || colRightBottom>=cols) throw new IllegalArgumentException("Illegal Arguments!");
		if(rowLeftTop>rowRightBottom || colLeftTop > colRightBottom) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = rowLeftTop; i <=rowRightBottom; i++){
			for(int j = colLeftTop; j <=colRightBottom; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		int rowStrWidth =  String.valueOf(rowRightBottom).length();
		int colStrWidth =  String.valueOf(colRightBottom).length();

		StringBuilder sb = new StringBuilder();

		for(int i = rowLeftTop; i <=rowRightBottom; i++){
			if(showsRowCol){
				sb.append(String.format("[ row:col  %"+rowStrWidth+"d :%"+colStrWidth+"d-%"+colStrWidth+"d ] ", i,  colLeftTop, colRightBottom));
			}
			sb.append("[");
			for(int j = colLeftTop; j <=colRightBottom; j++){
				sb.append(String.format(formatStr, arr[i][j]));
			}
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();
		
	}

	
	static String fromSubMatrixToString(int[][] arr, int rowLeftTop, int colLeftTop, int rowRightBottom, int colRightBottom) throws IllegalArgumentException{
		boolean showsRowCol = true;
		return fromSubMatrixToString(arr,  rowLeftTop,  colLeftTop,  rowRightBottom,  colRightBottom, showsRowCol);
	}
	static String fromSubMatrixToString(int[][] arr, int rowLeftTop, int colLeftTop, int rowRightBottom, int colRightBottom, boolean showsRowCol) throws IllegalArgumentException{
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) return "[]";
		int rows = arr.length;
		int cols = arr[0].length;
		if(rowLeftTop<0 || rowLeftTop>=rows || rowRightBottom<0 || rowRightBottom>=rows) throw new IllegalArgumentException("Illegal Arguments!");
		if(colLeftTop<0 || colLeftTop>=cols || colRightBottom<0 || colRightBottom>=cols) throw new IllegalArgumentException("Illegal Arguments!");
		if(rowLeftTop>rowRightBottom || colLeftTop > colRightBottom) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = rowLeftTop; i <=rowRightBottom; i++){
			for(int j = colLeftTop; j <=colRightBottom; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		int rowStrWidth =  String.valueOf(rowRightBottom).length();
		int colStrWidth =  String.valueOf(colRightBottom).length();

		StringBuilder sb = new StringBuilder();

		for(int i = rowLeftTop; i <=rowRightBottom; i++){
			if(showsRowCol){
				sb.append(String.format("[ row:col  %"+rowStrWidth+"d :%"+colStrWidth+"d-%"+colStrWidth+"d ] ", i,  colLeftTop, colRightBottom));
			}
			sb.append("[");
			for(int j = colLeftTop; j <=colRightBottom; j++){
				sb.append(String.format(formatStr, arr[i][j]));
			}
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static String fromMatrixToString(boolean[][] arr) throws IllegalArgumentException{
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}
	public static String fromMatrixToString(boolean[][] arr, boolean showsRowCol) throws IllegalArgumentException{
		if(arr == null)  throw new IllegalArgumentException("Null or Empty Matrix!");
		if(arr.length == 0) return "[]";
		int strLen = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
 		}
		return sb.toString();
	}
	public static String fromRowOfMatrixToString(boolean[][] arr, int row, boolean showsRowCol){
		
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) throw new IllegalArgumentException("Empty Matrix!");
		if(row <0 || row >= arr.length) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		int rowStrWidth =  String.valueOf(arr.length).length();
		int colStrWidth =  String.valueOf(arr[0].length).length();

		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if(showsRowCol){
			sb.append(String.format("[ row:col  %"+rowStrWidth+"d : %"+1+"d-%"+colStrWidth+"d ] ", row,  0, arr[0].length));
		}

		sb.append("[");
		for(int i = 0; i < arr[row].length; i++){
			String val = (arr[row][i] == true) ? "T" : " ";
//			sb.append(String.format(formatStr, arr[row][i]));
			sb.append(String.format(formatStr, val));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	
	public static String fromMatrixToString(char[][] arr) throws IllegalArgumentException{
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}

	public static String fromMatrixToString(char[][] arr, boolean showsRowCol) throws IllegalArgumentException{
		if(arr == null)  throw new IllegalArgumentException("Null or Empty Matrix!");
		if(arr.length == 0) return "[]";
		int strLen = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
 		}
		return sb.toString();
		
	}

	public static String fromMatrixToString(int[][] arr) throws IllegalArgumentException{
		boolean showsRowCol = true;
		return fromMatrixToString(arr, showsRowCol);
	}

	public static String fromMatrixToString(int[][] arr, boolean showsRowCol) throws IllegalArgumentException{
		if(arr == null)  throw new IllegalArgumentException("Null or Empty Matrix!");
		if(arr.length == 0) return "[]";
		int strLen = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				strLen = Math.max(strLen, (String.valueOf(arr[i][j])).length());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			sb.append(fromRowOfMatrixToString(arr, i, showsRowCol));
 		}
		return sb.toString();
		
	}

	public static String fromRowOfMatrixToString(int[][] arr, int row){
		boolean showsRowCol = true;
		return fromRowOfMatrixToString(arr, row, showsRowCol);
	}
	public static String fromRowOfMatrixToString(int[][] arr, int row, boolean showsRowCol){
		
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) throw new IllegalArgumentException("Empty Matrix!");
		if(row <0 || row >= arr.length) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		int rowStrWidth =  String.valueOf(arr.length).length();
		int colStrWidth =  String.valueOf(arr[0].length).length();

		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if(showsRowCol){
			sb.append(String.format("[ row:col  %"+rowStrWidth+"d : %"+1+"d-%"+colStrWidth+"d ] ", row,  0, arr[0].length));
		}

		sb.append("[");
		for(int i = 0; i < arr[row].length; i++){
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}
	
	public static String fromRowOfMatrixToString(char[][] arr, int row, boolean showsRowCol){
		
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) throw new IllegalArgumentException("Empty Matrix!");
		if(row <0 || row >= arr.length) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		int rowStrWidth =  String.valueOf(arr.length).length();
		int colStrWidth =  String.valueOf(arr[0].length).length();

		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if(showsRowCol){
			sb.append(String.format("[ row:col  %"+rowStrWidth+"d : %"+1+"d-%"+colStrWidth+"d ] ", row,  0, arr[0].length));
		}

		sb.append("[");
		for(int i = 0; i < arr[row].length; i++){
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}
	
	public static String fromRowOfMatrixToString(Object[][] arr, int row){
		boolean showsRowCol = true;
		return fromRowOfMatrixToString(arr, row, showsRowCol);
	}
	public static String fromRowOfMatrixToString(Object[][] arr, int row, boolean showsRowCol){
		
		if(arr == null) throw new IllegalArgumentException("Null Matrix!");
		if(arr.length == 0) throw new IllegalArgumentException("Empty Matrix!");
		if(row <0 || row >= arr.length) throw new IllegalArgumentException("Illegal Arguments!");
		int valStrWidth = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				valStrWidth = Math.max(valStrWidth, (String.valueOf(arr[i][j])).length());
			}
		}
		String formatStr = " %" +valStrWidth+ "s, ";

		int rowStrWidth =  String.valueOf(arr.length).length();
		int colStrWidth =  String.valueOf(arr[0].length).length();

		StringBuilder sb = new StringBuilder();
//		sb.append(String.format("[ row : %"+rowStrWidth+"d ] ", row));
		if(showsRowCol){
			sb.append(String.format("[ row:col  %"+rowStrWidth+"d : %"+1+"d-%"+colStrWidth+"d ] ", row,  0, arr[0].length));
		}

		sb.append("[");
		for(int i = 0; i < arr[row].length; i++){
			sb.append(String.format(formatStr, arr[row][i]));
		}
		sb.append("]");
		sb.append("\n");
		return sb.toString();
	}

	
}
