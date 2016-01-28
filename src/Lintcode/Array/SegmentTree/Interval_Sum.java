package Lintcode.Array.SegmentTree;

import java.util.ArrayList;


/**

Interval Sum

Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the sum number between index start and end in the given array, return the result list.

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]

Note
We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Challenge
O(logN) time for each query

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Hard Interval Sum II

 *
 */
public class Interval_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class SegmentTreeNode {
        public int start, end;
        public Long sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, Long sum) {
              this.start = start;
              this.end = end;
              this.sum = sum;
              this.left = this.right = null;
        }
    }
    public SegmentTreeNode build(int start, int end, int[] A) {
        // write your code here
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0L);
        if(start == end) {
            root.sum =  Long.valueOf(A[start]);   
        }else{
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid+1, end, A);
            
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }
    // public SegmentTreeNode build(int start, int end, int[] A) {
    //     // write your code here
    //     if(start > end) {  // check core case
    //         return null;
    //     }
        
    //     SegmentTreeNode root = new SegmentTreeNode(start, end, 0L);
        
    //     if(start != end) {
    //         int mid = (start + end) / 2;
    //         root.left = build(start, mid, A);
    //         root.right = build(mid+1, end, A);
            
    //         root.sum = root.left.sum + root.right.sum;
    //     } else {
    //         root.sum =  Long.valueOf(A[start]);
            
    //     }
    //     return root;
    // }
    public Long query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start == root.start && root.end == end) { // 相等 
            return root.sum;
        }
        
        
        int mid = (root.start + root.end)/2;
        Long leftsum = 0L, rightsum = 0L;
        // 左子区
        if(start <= mid) {//mid归左子树,只要小于等于就有左子树了
            if( mid < end) { // 分裂 
                leftsum =  query(root.left, start, mid);
            } else { // 包含 
                leftsum = query(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3, mid归左子树,要计算右子树,不能有等号
            if(start <= mid) {
                rightsum = query(root.right, mid+1, end);
            } else { //  包含 
                rightsum = query(root.right, start, end);
            } 
        }  
        // else 就是不相交
        return leftsum + rightsum;
    }
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        SegmentTreeNode root = build(0, A.length - 1, A);
        ArrayList<Long> ans = new ArrayList<Long>();
        for(Interval in : queries) {
            ans.add(query(root, in.start, in.end));
        }
        return ans;
    }


}
