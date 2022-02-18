package Leet.Binary_Tree;

import Utils.TreeNodeUtils.TreeNode;

public class Lai_142_Binary_Tree_Diameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int diameter(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		// max[0] = 1;
		diameter(root, max);
		return max[0];
	}

	private int diameter(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		//从root.left 到叶子节点的最大距离
		int left = diameter(root.left, max);//OK
		//从root.left 到叶子节点的最大距离
		int right = diameter(root.right, max);//OK
		//什么时候更新
		if (left > 0 && right > 0) {
			max[0] = Math.max(max[0], right + left + 1);
		}
		return Math.max(left, right) + 1;//OK
	}

}
