package Lintcode.Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Lintcode.MultiThreading.Volatile.VolatileTest;
import sun.security.util.Length;

/**
Find Max Gift in a matrix
can go right and go down
1: find max value
2: find the path of max value

[ row:col  0 : 0-5 ] [ 3,  2,  1,  0,  6, ]
[ row:col  1 : 0-5 ] [ 0,  3,  2,  2,  5, ]
[ row:col  2 : 0-5 ] [ 4,  2,  2,  6,  3, ]
[ row:col  3 : 0-5 ] [ 7,  6,  6,  7,  9, ]
[ row:col  4 : 0-5 ] [ 8,  7,  2,  7,  8, ]

[
[3, 2, 1, 0, 6, 5, 3, 9, 8], 
[3, 2, 1, 0, 2, 5, 3, 9, 8], 
[3, 2, 1, 0, 2, 6, 3, 9, 8], 
[3, 2, 1, 0, 2, 6, 7, 9, 8], 
[3, 2, 1, 0, 2, 6, 7, 7, 8], 
[3, 2, 1, 2, 2, 5, 3, 9, 8], 
[3, 2, 1, 2, 2, 6, 3, 9, 8], 
[3, 2, 1, 2, 2, 6, 7, 9, 8], 
[3, 2, 1, 2, 2, 6, 7, 7, 8], 
[3, 2, 1, 2, 2, 6, 3, 9, 8], [3, 2, 1, 2, 2, 6, 7, 9, 8], [3, 2, 1, 2, 2, 6, 7, 7, 8], [3, 2, 1, 2, 2, 6, 7, 9, 8], [3, 2, 1, 2, 2, 6, 7, 7, 8], [3, 2, 1, 2, 2, 6, 2, 7, 8], [3, 2, 3, 2, 2, 5, 3, 9, 8], [3, 2, 3, 2, 2, 6, 3, 9, 8], [3, 2, 3, 2, 2, 6, 7, 9, 8], [3, 2, 3, 2, 2, 6, 7, 7, 8], [3, 2, 3, 2, 2, 6, 3, 9, 8], [3, 2, 3, 2, 2, 6, 7, 9, 8], [3, 2, 3, 2, 2, 6, 7, 7, 8], [3, 2, 3, 2, 2, 6, 7, 9, 8], [3, 2, 3, 2, 2, 6, 7, 7, 8], [3, 2, 3, 2, 2, 6, 2, 7, 8], [3, 2, 3, 2, 2, 6, 3, 9, 8], [3, 2, 3, 2, 2, 6, 7, 9, 8], [3, 2, 3, 2, 2, 6, 7, 7, 8], [3, 2, 3, 2, 2, 6, 7, 9, 8], [3, 2, 3, 2, 2, 6, 7, 7, 8], [3, 2, 3, 2, 2, 6, 2, 7, 8], [3, 2, 3, 2, 6, 6, 7, 9, 8], [3, 2, 3, 2, 6, 6, 7, 7, 8], [3, 2, 3, 2, 6, 6, 2, 7, 8], [3, 2, 3, 2, 6, 7, 2, 7, 8], [3, 0, 3, 2, 2, 5, 3, 9, 8], [3, 0, 3, 2, 2, 6, 3, 9, 8], [3, 0, 3, 2, 2, 6, 7, 9, 8], [3, 0, 3, 2, 2, 6, 7, 7, 8], [3, 0, 3, 2, 2, 6, 3, 9, 8], [3, 0, 3, 2, 2, 6, 7, 9, 8], [3, 0, 3, 2, 2, 6, 7, 7, 8], [3, 0, 3, 2, 2, 6, 7, 9, 8], [3, 0, 3, 2, 2, 6, 7, 7, 8], [3, 0, 3, 2, 2, 6, 2, 7, 8], [3, 0, 3, 2, 2, 6, 3, 9, 8], [3, 0, 3, 2, 2, 6, 7, 9, 8], [3, 0, 3, 2, 2, 6, 7, 7, 8], [3, 0, 3, 2, 2, 6, 7, 9, 8], [3, 0, 3, 2, 2, 6, 7, 7, 8], [3, 0, 3, 2, 2, 6, 2, 7, 8], [3, 0, 3, 2, 6, 6, 7, 9, 8], [3, 0, 3, 2, 6, 6, 7, 7, 8], [3, 0, 3, 2, 6, 6, 2, 7, 8], [3, 0, 3, 2, 6, 7, 2, 7, 8], [3, 0, 4, 2, 2, 6, 3, 9, 8], [3, 0, 4, 2, 2, 6, 7, 9, 8], [3, 0, 4, 2, 2, 6, 7, 7, 8], [3, 0, 4, 2, 2, 6, 7, 9, 8], [3, 0, 4, 2, 2, 6, 7, 7, 8], [3, 0, 4, 2, 2, 6, 2, 7, 8], [3, 0, 4, 2, 6, 6, 7, 9, 8], [3, 0, 4, 2, 6, 6, 7, 7, 8], [3, 0, 4, 2, 6, 6, 2, 7, 8], [3, 0, 4, 2, 6, 7, 2, 7, 8], [3, 0, 4, 7, 6, 6, 7, 9, 8], [3, 0, 4, 7, 6, 6, 7, 7, 8], [3, 0, 4, 7, 6, 6, 2, 7, 8], [3, 0, 4, 7, 6, 7, 2, 7, 8], [3, 0, 4, 7, 8, 7, 2, 7, 8]]


[ row:col  0 : 0-5 ] [  3,   5,   6,   6,  12, ]
[ row:col  1 : 0-5 ] [  3,   8,  10,  12,  17, ]
[ row:col  2 : 0-5 ] [  7,  10,  12,  18,  21, ]
[ row:col  3 : 0-5 ] [ 14,  20,  26,  33,  42, ]
[ row:col  4 : 0-5 ] [ 22,  29,  31,  40,  50, ]


[ row:col  0 : 0-5 ] [ 50,  43,  35,  32,  31, ]
[ row:col  1 : 0-5 ] [ 47,  41,  34,  32,  25, ]
[ row:col  2 : 0-5 ] [ 47,  38,  32,  30,  20, ]
[ row:col  3 : 0-5 ] [ 43,  36,  30,  24,  17, ]
[ row:col  4 : 0-5 ] [ 32,  24,  17,  15,   8, ]


[ row:col  0 : 0-5 ] [ -50,  -43,  -35,  -32,  -31, ]
[ row:col  1 : 0-5 ] [ -47,  -41,  -34,  -32,  -25, ]
[ row:col  2 : 0-5 ] [ -47,  -38,  -32,  -30,  -20, ]
[ row:col  3 : 0-5 ] [ -43,  -36,  -30,  -24,  -17, ]
[ row:col  4 : 0-5 ] [ -32,  -24,  -17,  -15,   -8, ]

[ row:col  0 : 0-3 ] [ 1,  2,  3, ]
[ row:col  1 : 0-3 ] [ 4,  5,  6, ]
[ row:col  2 : 0-3 ] [ 7,  8,  9, ]

[[1, 2, 3, 6, 9], [1, 2, 5, 6, 9], [1, 2, 5, 8, 9], [1, 4, 5, 6, 9], [1, 4, 5, 8, 9], [1, 4, 7, 8, 9]]
[[1, 2, 3, 6, 9], [1, 2, 3, 5, 6, 9], [1, 2, 3, 5, 6, 8, 9], [1, 2, 3, 5, 4, 5, 6, 9], [1, 2, 3, 5, 4, 5, 6, 8, 9], [1, 2, 3, 5, 4, 5, 6, 7, 8, 9]]
[[1, 2, 3, 6, 9], [1, 2, 5, 6, 9], [1, 2, 5, 8, 9], [1, 4, 5, 6, 9], [1, 4, 5, 8, 9], [1, 4, 7, 8, 9]]


[
[1, 2, 3, 6, 9], 
[1, 2, 5, 6, 9], 
[1, 2, 5, 8, 9], 
[1, 4, 5, 6, 9], 
[1, 4, 5, 8, 9], 
[1, 4, 7, 8, 9]
]

 *
 *
 */
class Point{
	int x;
	int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Find_Max_Gift {
	public static void f(List<Integer> result, int val, Integer val2, Point p){
		result.add(5);
		val++;
		val2++;
		p.setX(7);
		p.setY(9);
	}
	public static void main(String[] args) {
		Integer a = 456;
		Integer b = 456;
		Integer c = 1000;
		Integer d = 1000;
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(c == d);
		System.out.println(c.equals(d));
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(4);
		int val = 8;
		Integer val2 = new Integer(3);
		Point p = new Point(3,4);
		f(result, val, val2, p);
		System.out.println(""+result);
		System.out.println(""+val);
		System.out.println(""+val2);
		System.out.println(""+p.getX() + " "+p.getY());
		// TODO Auto-generated method stub
//		Random r= new Random();
//		System.out.println(""+r.nextInt(10)+","+r.nextInt(10)+","+r.nextInt(10)+","+r.nextInt(10)+","+r.nextInt(10));
//		System.out.println(""+r.nextInt(5));
		int[][] matrix2 = new int[][]{
			{1,8,2},
			{6,7,5},
			{3,5,2},
			};

		int[][] matrix = new int[][]{
				{3,2,1,0,6},
				{0,3,2,2,5},
				{4,2,2,6,3},
				{7,6,6,7,9},
				{8,7,2,7,8},
				};
		System.out.println(""+Matrix.fromMatrixToString(matrix));
		System.out.println(""+Matrix.fromMatrixToString(matrix2));

//		System.out.println(""+findMaxGift02(matrix));
//		System.out.println(""+findMaxGift1(matrix));
//		System.out.println(""+findMaxGift2(matrix));
//		System.out.println(""+findPathOfMaxGift1(matrix));
		printAllPossiblePaths(matrix);
//		printAllPossiblePaths(matrix2);
//		findMaxPath(matrix);
//		findMaxPath(matrix2);
	}
	//===printAllPossiblePaths=================================================================================================================
	//can only go right or down
	private static void printAllPossiblePaths(int[][] matrix) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		int len = matrix.length;
		path.add(matrix[0][0]);
		printAllPossiblePaths(result, path, matrix, 0, 0, len -1, len-1 );
		System.out.println(""+result);
		System.out.println(""+result.size());
	}
	//get all possible paths
	private static void printAllPossiblePaths(List<List<Integer>> result, List<Integer> path, int[][] matrix, int row1,
			int col1, int row2, int col2) {
		// TODO Auto-generated method stub
		if(row1 < 0 || row1 > row2 || col1 < 0 || col1 > col2) return;
		if(row1 == row2 && col1 == col2){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		if(col1+1 <= col2){
			path.add(matrix[row1][col1+1]);
			printAllPossiblePaths(result, path, matrix, row1,     col1+1, row2, col2 );
			path.remove(path.size()-1);
		}
		if(row1+1 <= row2){
			path.add(matrix[row1+1][col1]);
			printAllPossiblePaths(result, path, matrix, row1 + 1, col1,   row2, col2 );
			path.remove(path.size()-1);
		}
	}
	//===findMaxPath=======int len-1, int len-1 ==========================================================================================================
	
	//can only go right or down
	private static List<List<Integer>> findMaxPath(int[][] matrix) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		List<Integer> maxSum = new ArrayList<Integer>();
		maxSum.add(-1);
		int sum = matrix[0][0];
		int len = matrix.length;
		path.add(matrix[0][0]);
//		findMaxPath(result, path, maxSum, sum, matrix, 0, 0, len -1, len-1 );
		findMaxPath(result, path, maxSum, sum, matrix, 0, 0 );
		System.out.println(""+result);
		System.out.println(""+result.size());
		return result;
	}
	//get all possible paths
	private static void findMaxPath(List<List<Integer>> result, List<Integer> path,List<Integer> maxSum, int sum, int[][] matrix,  int row1,
			int col1) {
		// TODO Auto-generated method stub
//		if(row1 < 0 || row1 > row2 || col1 < 0 || col1 > col2) return;
		if(row1 == matrix.length -1  && col1 == matrix.length -1){
			System.out.println("path:sum "+path+" "+sum);
			if(sum > maxSum.get(0)){
				System.out.println("sum:maxSum "+ sum +" "+maxSum );
				maxSum.set(0, sum);
				if(result.size() == 0){
					result.add(new ArrayList<Integer>(path));
				}else{
					result.clear();
					result.add(new ArrayList<Integer>(path));
				}
			}else if(sum == maxSum.get(0)){
				System.out.println("sum:maxSum "+ sum +" "+maxSum );
//				maxSum.set(0, sum);
				if(result.size() == 0){
//					result.add(new ArrayList<Integer>(path));
				}else{
					result.add(new ArrayList<Integer>(path));
				}
			}
//			if(sum==25){
//				System.out.println("sum:maxSum "+ sum +" "+maxSum );
//				result.add(new ArrayList<Integer>(path));
//			}
			return;
		}
		if(col1+1 < matrix.length){
			path.add(matrix[row1][col1+1]);
			findMaxPath(result, path,maxSum, sum+ matrix[row1][col1+1], matrix, row1,     col1+1);
			path.remove(path.size()-1);
		}
		if(row1+1 < matrix.length){
			path.add(matrix[row1+1][col1]);
			findMaxPath(result, path,maxSum, sum+ matrix[row1+1][col1], matrix, row1 + 1, col1);
			path.remove(path.size()-1);
		}
	}
	//===findMaxPath=======int row2, int col2==========================================================================================================
	
	//can only go right or down
	private static void findMaxPath2(int[][] matrix) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		List<Integer> maxSum = new ArrayList<Integer>();
		maxSum.add(-1);
		int sum = matrix[0][0];
		int len = matrix.length;
		path.add(matrix[0][0]);
//		findMaxPath(result, path, maxSum, sum, matrix, 0, 0, len -1, len-1 );
		findMaxPath2(result, path, maxSum, sum, matrix, 0, 0, 2, 2 );
		System.out.println(""+result);
		System.out.println(""+result.size());
	}
	//get all possible paths
	private static void findMaxPath2(List<List<Integer>> result, List<Integer> path,List<Integer> maxSum, int sum, int[][] matrix, int row1,
			int col1, int row2, int col2) {
		// TODO Auto-generated method stub
//		if(row1 < 0 || row1 > row2 || col1 < 0 || col1 > col2) return;
		if(row1 == row2 && col1 == col2){
			System.out.println("path:sum "+path+" "+sum);
			if(sum > maxSum.get(0)){
				System.out.println("sum:maxSum "+ sum +" "+maxSum );
				maxSum.set(0, sum);
				if(result.size() == 0){
					result.add(new ArrayList<Integer>(path));
				}else{
					result.clear();
					result.add(new ArrayList<Integer>(path));
				}
			}else if(sum == maxSum.get(0)){
				System.out.println("sum:maxSum "+ sum +" "+maxSum );
//				maxSum.set(0, sum);
				if(result.size() == 0){
//					result.add(new ArrayList<Integer>(path));
				}else{
					result.add(new ArrayList<Integer>(path));
				}
			}
//			if(sum==25){
//				System.out.println("sum:maxSum "+ sum +" "+maxSum );
//				result.add(new ArrayList<Integer>(path));
//			}
			return;
		}
		if(col1+1 <= col2){
			path.add(matrix[row1][col1+1]);
			findMaxPath2(result, path,maxSum, sum+ matrix[row1][col1+1], matrix, row1,     col1+1, row2, col2 );
			path.remove(path.size()-1);
		}
		if(row1+1 <= row2){
			path.add(matrix[row1+1][col1]);
			findMaxPath2(result, path,maxSum, sum+ matrix[row1+1][col1], matrix, row1 + 1, col1,   row2, col2 );
			path.remove(path.size()-1);
		}
	}


	//====================================================================================================================
	private static List<Integer> findPathOfMaxGift1(int[][] matrix) {
		// TODO Auto-generated method stub
		List<Integer> path = new ArrayList<Integer>();
		List<String> pathStr = new ArrayList<String>();

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = matrix.length;
		List<Integer> maxSum = new ArrayList<Integer>();
		maxSum.add(0);
		path.add(matrix[0][0]);
		pathStr.add(" (0,0) ");
		result.add(path);
		findPathOfMaxGift1(result, path, pathStr, maxSum,0, matrix, len, 0, 0, len -1, len - 1);
		System.out.println(""+pathStr);
		return result.get(0);
	}
	private static void findPathOfMaxGift1(List<List<Integer>> result, List<Integer> path, List<String> pathStr, List<Integer> maxSum, int pathSum, int[][] matrix, int len, int start1, int end1, int start2, int end2){
		if(start1 < 0 || start1 > start2 || end1 < 0 || end1 > end2) return;
		if(start1 == start2 && end1 == end2){
			path.add(matrix[start1][end1]);
			pathStr.add(" ("+start1+","+ end1+") ");
			pathSum += matrix[start1][end1];
			if(pathSum > maxSum.get(0)){
				System.out.println("maxSum:pathSum  "+maxSum.get(0) +":"+pathSum);
				maxSum.set(0, pathSum);
				result.set(0, path);
			}
			return;
		}
		if(end1+1 < len){
			path.add(matrix[start1][end1 + 1]);
			pathStr.add(" ("+start1+","+ (end1+1)+") ");
			pathSum += matrix[start1][end1 + 1];
			findPathOfMaxGift1(result, path, pathStr, maxSum,pathSum, matrix, len, start1,     end1 + 1, start2, end2);
			path.remove(path.size()-1);
			pathStr.remove(path.size()-1);
			pathSum -= matrix[start1][end1];
		}
		if(start1 + 1 < len){
			path.add(matrix[start1 + 1][end1]);
			pathStr.add(" ("+(start1+1)+","+ (end1)+") ");
			pathSum += matrix[start1 + 1][end1];
			findPathOfMaxGift1(result, path,pathStr, maxSum,pathSum, matrix, len, start1 + 1, end1,     start2, end2);
			path.remove(path.size()-1);
			pathStr.remove(path.size()-1);
			pathSum -= matrix[start1 + 1][end1];
		}

		
	}

	//version 2, worked, but too many duplicate computation
	private static int findMaxGift2(int[][] matrix){
		int len = matrix.length;
		int[][] maxGift = new int[len][len];
		boolean[][] isVisited = new boolean[len][len];
		List<Integer> count = new ArrayList<Integer>();
		count.add(0);
		int max = findMaxGift2(matrix, len, 0, 0, len - 1, len - 1, maxGift, isVisited, count);
//		int max = findMaxGift2(matrix, len, 0, 0, len - 2, len - 2, count);
//		int max = findMaxGift2(matrix, len, 0, 0, 4, 1, count);
		System.out.println("Count: "+count.get(0));
		return max;
//		return findMaxGift2(matrix, len, 0, 0, len - 2, len - 2);
	}
	private static int findMaxGift2(int[][] matrix, int len, int start1, int end1, int start2, int end2, int[][] maxGift, boolean[][] isVisited, List<Integer> count){
		System.out.println(""+start1 +":"+end1+"  ");
		count.set(0,count.get(0) + 1);
		if(start1 < 0 || start1 > start2 || end1 < 0 || end1 > end2) return 0;
		if(isVisited[start1][end1] == true) return maxGift[start1][end1];
		int right = findMaxGift2(matrix, len, start1, end1 + 1, start2, end2, maxGift, isVisited, count);
		int down = findMaxGift2(matrix, len, start1 + 1, end1, start2, end2, maxGift, isVisited, count);
//		System.out.println(""+start1 +":"+end1+"  "+Math.max(left, down));
//		System.out.println(""+start1 +":"+end1+"  "+(Math.max(left, down) + matrix[start1][end1]));
//		maxGift[start1][end1] = Math.max(right, down) + matrix[start1][end1];
		maxGift[start1][end1] = Math.max(right, down) + matrix[start1][end1];
		System.out.println(""+Matrix.fromMatrixToString(maxGift));
		isVisited[start1][end1] = true;
		return maxGift[start1][end1];

	}

	
	//version 1, worked, no extra memory, but too many duplicate computation
	private static int findMaxGift1(int[][] matrix){
		int len = matrix.length;
		List<Integer> count = new ArrayList<Integer>();
		count.add(0);
		int max = findMaxGift12(matrix, len, 0, 0, len - 1, len - 1, count);//503
//		int max = findMaxGift1(matrix, len, 0, 0, len - 2, len - 2, count);
//		int max = findMaxGift1(matrix, len, 0, 0, 4, 1, count);
		System.out.println("Count: "+count.get(0));
		return max;
//		return findMaxGift2(matrix, len, 0, 0, len - 2, len - 2);

	}
	//worked, version 11, no extra memory, but too many duplicate computation
	private static int findMaxGift11(int[][] matrix, int len, int start1, int end1, int start2, int end2, List<Integer> count){
		System.out.println(""+start1 +":"+end1+"  ");
		count.set(0,count.get(0) + 1);
		if(start1 < 0 || start1 > start2 || end1 < 0 || end1 > end2) return 0;
		int right = findMaxGift11(matrix, len, start1,     end1 + 1, start2, end2, count);
		int down  = findMaxGift11(matrix, len, start1 + 1, end1,     start2, end2, count);
		return Math.max(right, down) + matrix[start1][end1];
	}

//	, version 12, no extra memory, no duplicate computation
	private static int findMaxGift12(int[][] matrix, int len, int start1, int end1, int start2, int end2, List<Integer> count){
		System.out.println(""+start1 +":"+end1+"  ");
		count.set(0,count.get(0) + 1);
		if(start1 < 0 || start1 > start2 || end1 < 0 || end1 > end2) return 0;
		if(matrix[start1][end1] < 0) return  matrix[start1][end1];//有所区分，其实就是有两种元素.其实0也可能是访问过的，问题在于0无法区分标记
		matrix[start1][end1] = -matrix[start1][end1];//变为负数
		int right = findMaxGift12(matrix, len, start1, end1 + 1, start2, end2, count);
		int down = findMaxGift12(matrix, len, start1 + 1, end1, start2, end2, count);
		System.out.println(""+start1 +":"+end1+"  "+Math.min(right, down) +" : "+ matrix[start1][end1]);
//		System.out.println(""+start1 +":"+end1+"  "+(Math.max(left, down) + matrix[start1][end1]));
		matrix[start1][end1] = Math.min(right, down) + matrix[start1][end1];//求最小
//		matrix[start1][end1] = -matrix[start1][end1];
		System.out.println(""+Matrix.fromMatrixToString(matrix));
		return matrix[start1][end1];
	}
	
	
//	, version 13, no extra memory, no duplicate computation
	private static int findMaxGift13(int[][] matrix, int len, int start1, int end1, int start2, int end2, List<Integer> count){
		System.out.println(""+start1 +":"+end1+"  ");
		count.set(0,count.get(0) + 1);
		if(start1 < 0 || start1 > start2 || end1 < 0 || end1 > end2) return 0;
		if(matrix[start1][end1] < 0) return  matrix[start1][end1];
		matrix[start1][end1] = -matrix[start1][end1];//变为负数
		int right = findMaxGift13(matrix, len, start1, end1 + 1, start2, end2, count);
		int down = findMaxGift13(matrix, len, start1 + 1, end1, start2, end2, count);
		System.out.println(""+start1 +":"+end1+"  "+Math.min(right, down) +" : "+ matrix[start1][end1]);
//		System.out.println(""+start1 +":"+end1+"  "+(Math.max(left, down) + matrix[start1][end1]));
		matrix[start1][end1] = Math.min(right, down) + matrix[start1][end1];//求最小
//		matrix[start1][end1] = -matrix[start1][end1];
		System.out.println(""+Matrix.fromMatrixToString(matrix));
		return matrix[start1][end1];
	}

	
	//extra memory
	private static int findMaxGift01(int[][] matrix){
		int len = matrix.length;
		int[][] max = new int[len][len];
		max[0][0] = matrix[0][0];
		for(int j = 1; j< len; j++){
			max[0][j] = matrix[0][j] + max[0][j-1] ;
		}
		for(int i = 1; i< len; i++){
			max[i][0] = max[i-1][0] + matrix[i][0];
		}
		for(int i = 1; i< len; i++){
			for(int j = 1; j< len; j++){
				max[i][j] = Math.max(max[i-1][j], max[i][j-1]) + matrix[i][j];
				System.out.println(""+Matrix.fromMatrixToString(max));
			}
		}
		return max[len-1][len-1];
	}
	//no extra memory, better
	private static int findMaxGift02(int[][] matrix){
		int len = matrix.length;
		for(int j = 1; j< len; j++){
			matrix[0][j] += matrix[0][j-1];
		}
		for(int i = 1; i< len; i++){
			matrix[i][0] += matrix[i-1][0];
		}
		for(int i = 1; i< len; i++){
			for(int j = 1; j< len; j++){
				matrix[i][j] += Math.max(matrix[i-1][j], matrix[i][j-1]);
				System.out.println(""+Matrix.fromMatrixToString(matrix));
			}
		}
		return matrix[len-1][len-1];
	}


}
