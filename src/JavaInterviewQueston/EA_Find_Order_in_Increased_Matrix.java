package JavaInterviewQueston;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Problem: There are M*N distinct integer in a M x N matrix, given any index I, j, I' and j', if i>=I' and j>=j'  then mat[i][j] >= mat[I'][j']
For any given integer x in matrix mat, create a function to return rank(x)
e.g. 3x4 matrix
    	[1,3,7,10]
    	[4,5,8,12]
    	[6,9,11,13]

example:
rank(6): 5
rank(9): 8
rank(5) :  4
rank(1) : 1
rank(13) : 12
 

 */
public class EA_Find_Order_in_Increased_Matrix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{{1,3,7,10},{4,5,8,12},{6,9,11,13}};
//		int k = 12;
//		int k = 5;
		int k = 9;
//		int k = 13;
//		int k = 6;
//		System.out.println("len:"+matrix[0].length);
//		System.out.println("order: "+kthSmallest( matrix, k) );
		System.out.println("order: "+getRank( matrix, k) );

		
	}
    public  static class Point {
        public int row, col, val;
        public Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    } 
    
//    static Comparator<Point> comp = new Comparator<Point>() {
//        @Override
//        public int compare(Point left, Point right) {
//            return left.val - right.val;
//        }
//    };
    
    public static int getRank(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
//        if (k > matrix.length * matrix[0].length) {
//            return 0;
//        }
        return getRankHorizontal(matrix, k);
        // return vertical(matrix, k);
    }

    private  static int getRankHorizontal(int[][] matrix, int k) {
//        Queue<Point> heap = new PriorityQueue<Point>(k, comp);
//        for (int i = 0; i < Math.min(matrix.length, k); i++) {
//            heap.offer(new Point(i, 0, matrix[i][0]));
//        }
//        for (int i = 0; i < k - 1; i++) {
//            Point curr = heap.poll();
//            if (curr.col + 1 < matrix[0].length) {
//                heap.offer(new Point(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
//            }
//        }
//        return heap.peek().val;
    	int rowLen = matrix.length;
    	int colLen = matrix[0].length;
        Queue<Point> heap = new PriorityQueue<Point>(rowLen, new Comparator<Point>() {
//        Queue<Point> heap = new LinkedList<Point>(rowLen, new Comparator<Point>() {
            @Override
            public int compare(Point left, Point right) {
                return left.val - right.val;
            }
        });
        for (int i = 0; i < rowLen; i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }
        int rank = 0;
        for (int i = 0; i < colLen * rowLen; i++) {
            Point curr = heap.poll();
            rank++;
            if(curr.val == k){
            	return rank; 
            }
            if (curr.col + 1 < colLen) {
                heap.offer(new Point(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
            }
        }
        return -1;

    }

    
    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        if (k > matrix.length * matrix[0].length) {
            return 0;
        }
        return horizontal(matrix, k);
        // return vertical(matrix, k);
    }
    
    private  static int horizontal(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point left, Point right) {
                return left.val - right.val;
            }
        });
        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.col + 1 < matrix[0].length) {
                heap.offer(new Point(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
            }
        }
        return heap.peek().val;
    }
    
    private static int vertical(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point left, Point right) {
                return left.val - right.val;
            }
        });
        for (int i = 0; i < Math.min(matrix[0].length, k); i++) {
            heap.offer(new Point(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.row + 1 < matrix.length) {
                heap.offer(new Point(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]));
            }
        }
        return heap.peek().val;
    }

    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1 != null){
            node.next = l1;
        }
        if(l2 != null){
            node.next = l2;
        }
        return dummy.next;
    }

}
