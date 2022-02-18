package Lai.BinaryTree.Path_Sum;

import Utils.TreeNodeUtils.TreeNode;

public class Maximum_Path_Sum_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxPathSum(TreeNode<Integer> root) {
		// Write your solution here
		int[] max = new int[1];//leaf到leaf的max，返回变量
		max[0] = Integer.MIN_VALUE;
		if (root == null) {
			return max[0];
		}
		helper(root, max);
		return max[0];
	}

	private static int helper(TreeNode<Integer> root, int[] max) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			int left = helper(root.left, max);//返回经过当前节点的leaf到leaf的最大路径和
			int right = helper(root.right, max);
			max[0] = Math.max(max[0], left + right + root.val);
			return root.val + Math.max(left, right);
		}

//		if (root.left != null) {
//			return root.val + helper(root.left, max);
//		}
//		return root.val + helper(root.right, max);
		return root.val + (root.left != null ? helper(root.left, max) : helper(root.right, max));
	}

}
