package Lai.DB16.DP_III;

import Utils.TreeNodeUtils.TreeNode;

public class LC_337_House_Robber_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob_00(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int[] max = helper(root);
		return Math.max(max[0], max[1]);
	}

	private static int[] helper(TreeNode<Integer> root) {
		if (root == null) {
			return new int[2];
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int[] max = new int[2];
		max[0] = root.val + left[1] + right[1];
		// max[1] = left[0] + right[0];
		max[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return max;
	}

}
