package Lintcode.Array.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import Lintcode.Array.Matrix;

/**

Kth Largest in N Arrays

 Description
 Notes
 Testcase
 Judge
Find K-th largest element in N arrays.

 Notice

You can swap elements in the array

Have you met this question in a real interview? Yes
Example
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.

In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.

Tags 
Heap
Related Problems 
Medium Largest Number 19 %


 *
 */
public class Kth_Largest_in_N_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrays = new int[][]{
			{9,3,2,4,7},
			{1,2,3,4,8}
		}; 
//		[[11],[1,2,3,4,112,87],[564],[789,12,15]], 7
		arrays = new int[][]{
			{11},
			{1,2,3,4,112,87},
			{564},
			{789,12,15}
		}; 

		System.out.println("Kth: "+KthInArrays(arrays, 7));

	}

    static class Point {
        public int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    } 

    public static int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        // validate the array and k
        int rows = arrays.length;
//        int cols = arrays[0].length;
        Queue<Point> heap = new PriorityQueue<Point>(1, new Comparator<Point>() {
            @Override
            public int compare(Point left, Point right) {
                return right.val - left.val;
            }
        });
        for(int i = 0; i < rows; i++){
            int cols = arrays[i].length;//cols might vary every time 
            if(cols > 0){
            	Arrays.sort(arrays[i]);//asc order
            	heap.offer(new Point(i, cols - 1, arrays[i][cols - 1]));                
            }
        }
        System.out.println(""+Matrix.fromMatrixToString(arrays));
        //poll() k-1 times
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();//largest in the heap
            System.out.println("curr.val: "+curr.val);
            if (curr.y - 1 >= 0) {//Null pointer
                curr.y = curr.y - 1;
                curr.val =  arrays[curr.x][curr.y];
                heap.offer(curr);
            }
        }
        // for (int i = 0; i < k - 1; i++) {
        //     Point curr = heap.poll();//largest in the heap
        //     if (curr.y + 1 < matrix[0].length) {
        //         curr.y = curr.y + 1;
        //         curr.val =  matrix[curr.x][curr.y];
        //         heap.offer(curr);
        //     }
        // }
        //第k个是peek()的
        return heap.peek().val;
    }    
	
	
}
