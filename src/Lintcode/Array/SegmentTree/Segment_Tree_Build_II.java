package Lintcode.Array.SegmentTree;

/**

Segment Tree Build II Show result 

The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.

start and end are both integers, they should be assigned in following rules:

The root's start and end is given by build method.
The left child of node A has start=A.left, end=(A.left + A.right) / 2.
The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
if start equals to end, there will be no children for this node.
Implement a build method with a given array, so that we can create a corresponding segment tree with every node value represent the corresponding interval max value in the array, return the root of this segment tree.

Have you met this question in a real interview? Yes
Example
Given [3,2,1,4]. The segment tree will be:

                 [0,  3] (max = 4)
                  /            \
        [0,  1] (max = 3)     [2, 3]  (max = 4)
        /        \               /             \
[0, 0](max = 3)  [1, 1](max = 2)[2, 2](max = 1) [3, 3] (max = 4)
Clarification
Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:

which of these intervals contain a given point
which of these points are in a given interval
See wiki:
Segment Tree
Interval Tree

Tags Expand 
Segment Tree


Related Problems Expand 
Medium Segment Tree Build


 *
 *
 */
public class Segment_Tree_Build_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public SegmentTreeNode build(int[] A) {
        return build(A, 0, A.length -1);
    }
    public SegmentTreeNode build(int[] A, int start, int end) {
        // write your code here       
        if(start > end) return null;
        if(start == end) return new SegmentTreeNode(start, end, A[start]);
        
        int mid = start + (end - start)/2;
        SegmentTreeNode left = build(A, start, mid);
        SegmentTreeNode right = build(A, mid+1, end);
        int max = Math.max(left.max, right.max);
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, max);
        root.left = left;
        root.right = right;
        return root;
    }

}
