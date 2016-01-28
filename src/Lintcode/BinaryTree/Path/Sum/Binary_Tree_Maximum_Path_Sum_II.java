package Lintcode.BinaryTree.Path.Sum;


/**
Binary Tree Maximum Path Sum II Show result 

Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)

Tags Expand 
Binary Tree


Related Problems Expand 
Medium Binary Tree Maximum Path Sum

 *
 */
public class Binary_Tree_Maximum_Path_Sum_II {

    public static int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null) return 0;
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return left > right ? left + root.val: right + root.val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
