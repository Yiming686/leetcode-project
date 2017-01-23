package Lintcode.Kth.Elements;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
Kth Smallest Number in Sorted Matrix

Find the kth smallest number in at row and column sorted matrix.

Have you met this question in a real interview? Yes
Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Challenge
O(k log n), n is the maximal number in width and height.

Tags Expand 
Heap Priority Queue Matrix


Related Problems Expand 
Medium Kth Largest Element

 *
 */
public class Kth_Smallest_Number_in_Sorted_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1 = new int[][]{
			{1 ,5 ,7},
			{3 ,7 ,8},
			{4 ,8 ,9}
		};
		int[][] matrix = new int[][]{
			{-3 ,2 ,7},
			{3 ,-2 ,8},
			{4 ,-8 ,2}
		};
//		1,3,4,5,7,7,8,8,9,-1
//		1,3,4,5,7,8,9,-1,-1,-1
		System.out.println(""+kthSmallest11(matrix1, 1));
		System.out.println(""+kthSmallest11(matrix1, 2));
		System.out.println(""+kthSmallest11(matrix1, 3));
		System.out.println(""+kthSmallest11(matrix1, 4));
		System.out.println(""+kthSmallest11(matrix1, 5));
		System.out.println(""+kthSmallest11(matrix1, 6));
		System.out.println(""+kthSmallest11(matrix1, 7));
		System.out.println(""+kthSmallest11(matrix1, 8));
		System.out.println(""+kthSmallest11(matrix1, 9));
		System.out.println(""+kthSmallest11(matrix1, 10));
	}

    public static int kthSmallest11(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        if (k > matrix.length * matrix[0].length) {
            return -1;
        }
        return horizontal(matrix, k);
        // return vertical(matrix, k);
    }
    
    private static int horizontal(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point left, Point right) {
                return left.val - right.val;
            }
        });
        
        // Queue<Point> heap = new PriorityQueue<>( (Point p1, Point p2)-> p1.val - p2.val);
    // 添加k个或者length个，即可        
        // Queue<Point> heap = new PriorityQueue<Point>(k, (Point left, Point right) -> return left.val - right.val);
    // 添加k个或者length个，即可
        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }
        // 前面k-1个元素处理逻辑相同，poll()k-1个，符合条件再添加
        Set<Integer> set = new HashSet<>();
        
        int pre = -1;
        while(set.size() < k && !heap.isEmpty()){
        	Point curr = heap.poll();
	    	while(curr.val == pre && !heap.isEmpty()){
		        curr = heap.poll();
			}
	    	pre = curr.val;
	    	set.add(pre);
	        if (curr.y + 1 < matrix[0].length) {
	          curr.y = curr.y + 1;
	          curr.val =  matrix[curr.x][curr.y];
	          heap.offer(curr);
	        }
        }
//        for (int i = 0; i < k - 1; i++) {
//        	Point curr = heap.poll();
////        	while(curr.val == pre){
////                curr = heap.poll();
////        	}
////            pre = curr.val;
//            if (curr.y + 1 < matrix[0].length) {
//                curr.y = curr.y + 1;
//                curr.val =  matrix[curr.x][curr.y];
//                heap.offer(curr);
//            }
//        }
//        //第k个是peek()的
        if(k <= set.size()){
        	return pre;
        }else{
        	return -1;
        }
    }
    
    
    static class Point {
        public int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    } 	
}
