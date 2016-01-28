package Lintcode.BinaryTree;

import java.util.ArrayList;

/**
Construct Binary Tree from Inorder and Postorder Traversal Show result 

Given inorder and postorder traversal of a tree, construct the binary tree.

Have you met this question in a real interview? Yes
Example
Given inorder [1,2,3] and postorder [1,3,2], return a tree:

  2
 / \
1   3
Note
You may assume that duplicates do not exist in the tree.

Tags Expand 
Binary Tree
 *
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
        	return 0;
        }

        int curMinCost[] = new int[101]; //curMinCost[v]: the min cost in A[0..i] if A[i] is changed to v
        int lastMinCost[] = new int[101]; //lastMinCost[v]: the min cost in A[0..i - 1] if A[i - 1] is changed to v

        //initialize,初始化状态curMinCost[0]
        for (int v = 1; v <= 100; v++) {
        	curMinCost[v] = Math.abs(v - A.get(0));
        }

	    //curMinCost[curV]  表示元素A[i]  要变为curV 需要付出的最小成本
        //lastMinCost[lastV]表示元素A[i-1]要变为lastV需要付出的最小成本
        //此类dp注意当前i和i-1的区别，当前变量是针对i时刻的还是i-1时刻的
        for (int i = 1; i < A.size(); i++) {
            //把初始化状态curMinCost[0]付给lastMinCost[0]
            //构建新的递推关系，计算新的状态curMinCost[i]
            //最后curMinCost[A.size()-1]即为最后状态
        	System.arraycopy(curMinCost, 1, lastMinCost, 1, 100);
        	for (int curV = 1; curV <= 100; curV++) {
        	    //A中第i个值，要变为curV需要的代价，初始化为最大整数值
        	    //怎么求呢？遍历前面一个所有可能的变化，找到最小的
        	    //lastMinCost[lastV]为前面一个值变为LastV的代价加上当前A[i]变为curV的代价
        	    //curMinCost数组要和lastMinCost数组迭代替换，最后一个curMinCost数组即是所求的
        	    curMinCost[curV] = Integer.MAX_VALUE;
        		for (int lastV = 1; lastV <= 100; lastV++) {
        			if (Math.abs(curV - lastV) > target) {
        				continue;
        				// break; //不能为break，只能continue；
        			}
        			curMinCost[curV] = Math.min(curMinCost[curV], lastMinCost[lastV] + Math.abs(curV - A.get(i)));
        		}
        	}
        }
        //根据最后的状态curMinCost[A.size()-1]计算，最终所求值
        //找到curMinCost数组中的最小值，即是所求的最小成本
        int min = Integer.MAX_VALUE;
        for (int v = 1; v <= 100; v++) {
        	min = Math.min(min, curMinCost[v]);
        }

        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
