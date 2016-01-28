package Lintcode.Array.SegmentTree;

/**

Interval Sum II

Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):

For query(start, end), return the sum from index start to index end in the given array.
For modify(index, value), modify the number in the given index to value
Have you met this question in a real interview? Yes
Example
Given array A = [1,2,7,8,5].

query(0, 2), return 10.
modify(0, 4), change A[0] from 1 to 4.
query(0, 1), return 6.
modify(2, 1), change A[2] from 7 to 1.
query(2, 4), return 14.
Note
We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Challenge
O(logN) time for query and modify.

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Medium Interval Sum 25 %
Medium Interval Minimum Number

 *
 */
public class Interval_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class SegmentTreeNode {
        public int start, end;
        public int sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
              this.start = start;
              this.end = end;
              this.sum = sum;
              this.left = this.right = null;
        }
    }
    private SegmentTreeNode build(int start, int end, int[] A) {
        // write your code here
        if(start > end) {  // check core case
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid+1, end, A);
            
            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum =  A[start];
            
        }
        return root;
    }

    private SegmentTreeNode root;
    
    public Interval_Sum_II(int[] A) {
        // write your code here
        this.root = build(0, A.length-1, A);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return querySegmentTree(root, start ,end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        modifySegmentTree(root, index, value);
    }
    
    private int querySegmentTree(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start == root.start && root.end == end) { // ��� 
            return root.sum;
        }
        
        
        int mid = (root.start + root.end)/2;
        int leftsum = 0, rightsum = 0;
        // ������
        if(start <= mid) {
            if( mid < end) { // ���� 
                leftsum =  querySegmentTree(root.left, start, mid);
            } else { // ���� 
                leftsum = querySegmentTree(root.left, start, end);
            }
        }
        // ������
        if(mid < end) { // ���� 3
            if(start <= mid) {
                rightsum = querySegmentTree(root.right, mid+1, end);
            } else { //  ���� 
                rightsum = querySegmentTree(root.right, start, end);
            } 
        }  
        // else ���ǲ��ཻ
        return leftsum + rightsum;
    }
    private void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) { // ���ҵ�
            root.sum = value;
            return;
        }
        
        // ��ѯ
        int mid = (root.start + root.end) / 2;
        // if(root.start <= index && index <=mid) {
        if(index <=mid) {
            modifySegmentTree(root.left, index, value);
        }
        
        // if(mid < index && index <= root.end) {
        if(mid < index ) {
            modifySegmentTree(root.right, index, value);
        }
        //����
        root.sum = root.left.sum + root.right.sum;
    }

	

}
