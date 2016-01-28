package Lintcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
Binary Tree Level Order Traversal II Show result 

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
Tags Expand 
Queue Binary Tree Binary Tree Traversal Breadth First Search
 *
 */
public class Binary_Tree_Level_Order_Traversal_II {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(0, list);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
