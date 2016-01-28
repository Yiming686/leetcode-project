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
        if(start == root.start && root.end == end) { // ��� 
            return root.count;
        }
        
        int mid = (root.start + root.end)/2;
        int leftcount = 0, rightcount = 0;
        // ������
        if(start <= mid) {
            if( mid < end) { // ���� 
                leftcount =  querySegmentTree(root.left, start, mid);
            } else { // ���� 
                leftcount = querySegmentTree(root.left, start, end);
            }
        }
        // ������
        if(mid < end) { // ���� 3
            if(start <= mid) {
                rightcount = querySegmentTree(root.right, mid+1, end);
            } else { //  ���� 
                rightcount = querySegmentTree(root.right, start, end);
            } 
        }  
        // else ���ǲ��ཻ
        return leftcount + rightcount;
    }
    
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) { // ���ҵ�
            root.count += value;
            return;
        }
        // ��ѯ
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modifySegmentTree(root.left, index, value);
        }
        if(mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        //����
        root.count = root.left.count + root.right.count;
    }
    
    //����˼·:�����������飬��ǰԪ��֮ǰ���м����ȵ�ǰԪ��С��Ԫ��
    // 1.�Ƚ���,����Ԫ�ؽ���������node�����䡣����֪����ͬ����Ԫ�ظ����ķֲ���!?����һ��ȫ��Ϊ0
    //2.�������ÿһ��Ԫ�أ������в�ѯҪ�ҵ�ֵ��
    //3.Ȼ�󽫵�ǰԪ�ز���
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        root = build(0, 10000);//�������Ԫ�صķֲ�������index����ʼ����ȫΪ0
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int res;

        for(int i = 0; i < A.length; i++) {//���鲻�������
            // res = 0;//��Ե�ǰԪ��ͳ�Ƹ���
            // // if(A[i] > 0) {//�����ǰԪ�ش���0����ѯ0����ǰԪ�ؼ�1�ĸ���
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
