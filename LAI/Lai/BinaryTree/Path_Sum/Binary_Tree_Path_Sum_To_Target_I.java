package Lai.BinaryTree.Path_Sum;

import Utils.TreeNodeUtils.TreeNode;

/**
Easy
Given a binary tree and a target sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.

Example:
Given the below binary tree and target = 16,

              5
             / \
            4   8
           /   / \
          1    3  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.


 *
 */
public class Binary_Tree_Path_Sum_To_Target_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean exist(TreeNode<Integer> root, int target) {
		// Write your solution here
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				return true;
			}
		}
		if (root.left == null) {
			return exist(root.right, target - root.val);
		}
		if (root.right == null) {
			return exist(root.left, target - root.val);
		}
		return exist(root.left, target - root.val) || exist(root.right, target - root.val);
	}

}
