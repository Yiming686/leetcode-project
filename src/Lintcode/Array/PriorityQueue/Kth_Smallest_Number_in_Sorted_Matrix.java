package Lintcode.Array.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 Kth Smallest Number in Sorted Matrix

30:00
 Start
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

	}

	
    public class Point {
        public int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    } 
    
    Comparator<Point> comp = new Comparator<Point>() {
        @Override
        public int compare(Point left, Point right) {
            return left.val - right.val;
        }
    };
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        if (k > matrix.length * matrix[0].length) {
            return 0;
        }
        return horizontal(matrix, k);
        // return vertical(matrix, k);
    }
    
    private int horizontal(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, comp);
        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.y + 1 < matrix[0].length) {
                curr.y = curr.y + 1;
                curr.val =  matrix[curr.x][curr.y];
                heap.offer(curr);
                // heap.offer(new Point(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
            }
        }
        return heap.peek().val;
    }
    
    private int vertical(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, comp);
        for (int i = 0; i < Math.min(matrix[0].length, k); i++) {
            heap.offer(new Point(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.x + 1 < matrix.length) {
                heap.offer(new Point(curr.x + 1, curr.y, matrix[curr.x + 1][curr.y]));
            }
        }
        return heap.peek().val;
    }

}
