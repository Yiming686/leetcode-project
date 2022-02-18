package Leet.Binary_Tree;

import Utils.TreeNodeUtils.TreeNode;

public class Leet_543_Diameter_of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		diameterOfBinaryTree(root, max);
		return max[0] - 1;
	}

	//return how many nodes of the longest path for the node
//	´úÂë¼ò½à
	public static int diameterOfBinaryTree(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = diameterOfBinaryTree(root.left, max);
		int right = diameterOfBinaryTree(root.right, max);
		max[0] = Math.max(max[0], left + right + 1);
		return left > right ? left + 1 : right + 1;
	}

}
