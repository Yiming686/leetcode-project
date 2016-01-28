package Lintcode.Array.SegmentTree;

import java.util.ArrayList;

/**

Count of Smaller Number before itself Show result 

Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) . For each element Ai in the array, count the number of element before this element Ai is smaller than it and return count number array.

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], return [0,1,2,3,2]

Note
We suggest you finish problem Segment Tree Build, Segment Tree Query II and Count of Smaller Number before itself I first.

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Medium Count of Smaller Number

 *
 *
 *
 */
public class Count_of_Smaller_Number_before_itself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private SegmentTreeNode root;
    
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end) {  // check core case
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);
        } else {
            root.count =  0;
        }
        return root;
    }
    
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(end < start) return 0;
        if(start == root.start && root.end == end) { // 相等 
            return root.count;
        }
        
        int mid = (root.start + root.end)/2;
        int leftcount = 0, rightcount = 0;
        // 左子区
        if(start <= mid) {
            if( mid < end) { // 分裂 
                leftcount =  querySegmentTree(root.left, start, mid);
            } else { // 包含 
                leftcount = querySegmentTree(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightcount = querySegmentTree(root.right, mid+1, end);
            } else { //  包含 
                rightcount = querySegmentTree(root.right, start, end);
            } 
        }  
        // else 就是不相交
        return leftcount + rightcount;
    }
    
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) { // 查找到
            root.count += value;
            return;
        }
        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modifySegmentTree(root.left, index, value);
        }
        if(mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        //更新
        root.count = root.left.count + root.right.count;
    }
    
    //解题思路:给定无序数组，当前元素之前，有几个比当前元素小的元素
    // 1.先建树,根据元素建立好树的node的区间。现在知道不同区间元素个数的分布吗!?错，第一次全部为0
    //2.依次针对每一个元素，在树中查询要找的值，
    //3.然后将当前元素插入
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        root = build(0, 10000);//这个树是元素的分布，不是index，初始个数全为0
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int res;

        for(int i = 0; i < A.length; i++) {//数组不是排序的
            // res = 0;//针对当前元素统计个数
            // // if(A[i] > 0) {//如果当前元素大于0，查询0到当前元素减1的个数
            //     res = querySegmentTree(root, 0, A[i]-1);
            // // }
            // ans.add(res);
            ans.add(querySegmentTree(root, 0, A[i]-1));
            modifySegmentTree(root, A[i], 1);
        }
        return ans;
    }    
    
    //Naive solution,O(n^2), so Time Limit Exceeded 
    public ArrayList<Integer> countOfSmallerNumberII77(int[] A) {
        // write your code here
        int len = A.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i< len; i++){
            int count = 0;
            for(int j = 0; j< i; j++){
                if(A[j] < A[i]) count++;
            }
            list.add(count);
        }
        return list;
    }
    
    class SegmentTreeNode{
        int start, end, count;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
              this.start = start;
              this.end = end;
              this.count = count;
              this.left = this.right = null;
        }
        
    } 
    
}
