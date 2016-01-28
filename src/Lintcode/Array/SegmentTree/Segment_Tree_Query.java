package Lintcode.Array.SegmentTree;

/**

Segment Tree Query Show result 

For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).

Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.

Have you met this question in a real interview? Yes
Example
For array [1, 4, 2, 3], the corresponding Segment Tree is:

                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
query(root, 1, 1), return 4

query(root, 1, 2), return 4

query(root, 2, 3), return 3

query(root, 0, 2), return 4

Note
It is much easier to understand this problem if you finished Segment Tree Build first.

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Medium Segment Tree Query II 27 %
Medium Segment Tree Modify 36 %
Medium Segment Tree Build

 *
 *
 *
 */
public class Segment_Tree_Query {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start == root.start && root.end == end) { // 如何定义，相等，返回 
            return root.max;
        }
        
        int mid = (root.start + root.end)/2;
        int leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;
        // 左子区: start <= mid 肯定有左子区，关键是从start到哪里？mid or end？
        if(start <= mid) {
            if( mid < end) { // 分裂 
                leftmax =  query(root.left, start, mid);
            } else { // 包含 
                leftmax = query(root.left, start, end);
            }
            // leftmax = query(root.left, start, Math.min(mid,end));
        }
        // 右子区: mid < end, 肯定有右子区，关键是从哪里到end？start or mid+1？
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightmax = query(root.right, mid+1, end);
            } else { //  包含 
                rightmax = query(root.right, start, end);
            }
            //rightmax = query(root.right, Math.max(mid+1,start), end);
        }  
        // else 就是不相交
        return Math.max(leftmax, rightmax);
    }
    
    //My solution, worked
    public int query44(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root.start == start && root.end == end) return root.max;
        int mid = root.start + (root.end - root.start)/2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        if(start<=mid){
            if(end <= mid){
                leftMax = query(root.left, start, end); 
            }else{
                leftMax = query(root.left, start, mid); 
                rightMax = query(root.right, mid+1, end); 
            }
        }else{
            rightMax = query(root.right, start, end);
        }
        return Math.max(leftMax, rightMax);   
    }

}
