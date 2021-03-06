package Lintcode.Array.SegmentTree;

/**

Segment Tree Build Show result 

The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.

start and end are both integers, they should be assigned in following rules:

The root's start and end is given by build method.
The left child of node A has start=A.left, end=(A.left + A.right) / 2.
The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
if start equals to end, there will be no children for this node.
Implement a build method with two parameters start and end, so that we can create a corresponding segment tree with every node has the correct start and end value, return the root of this segment tree.

Have you met this question in a real interview? Yes
Example
Given start=0, end=3. The segment tree will be:

               [0,  3]
             /        \
      [0,  1]           [2, 3]
      /     \           /     \
   [0, 0]  [1, 1]     [2, 2]  [3, 3]
Given start=1, end=6. The segment tree will be:

               [1,  6]
             /        \
      [1,  3]           [4,  6]
      /     \           /     \
   [1, 2]  [3,3]     [4, 5]   [6,6]
   /    \           /     \
[1,1]   [2,2]     [4,4]   [5,5]
Clarification
Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:

which of these intervals contain a given point
which of these points are in a given interval
See wiki:
Segment Tree
Interval Tree

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Medium Segment Tree Build II 35 %
Medium Segment Tree Query II 27 %
Medium Segment Tree Modify 36 %
Medium Segment Tree Query


 *
 *
 */
public class Segment_Tree_Build {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //���������worked�� ����Segment Tree Build II
    public SegmentTreeNode build(int start, int end) {
        // write your code here       
        if(start > end) return null;
        if(start == end) return new SegmentTreeNode(start, end);
        
        int mid = start + (end - start)/2;
        SegmentTreeNode left = build(start, mid);
        SegmentTreeNode right = build(mid+1, end);
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = left;
        root.right = right;
        return root;

    }
    
    //my solution, worked
    public SegmentTreeNode build5(int start, int end) {
        // write your code here
        if(start > end) return null;
        if(start == end) return new SegmentTreeNode(start, end);
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        int mid = start + (end - start)/2;
        root.left = build(start, mid);
        root.right = build(mid+1, end);
        return root;
    }

    //Jiuzhang solution, worked
    public SegmentTreeNode build9(int start, int end) {
        // write your code here
        if(start > end) {  // check core case
            return null;
        }
       
        SegmentTreeNode root = new SegmentTreeNode(start, end);
       
        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);
           
            // root.max = Math.max(root.left.max, root.right.max);
        }
        return root;
    }

    class SegmentTreeNode {

    	
        public int start, end;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }


    }

    
    
}
