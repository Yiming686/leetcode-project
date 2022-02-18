package Lai.Binary_Search_Tree;

import Utils.ArrayUtils;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Is_Binary_Search_Tree_Or_Not {

	public static void main(String[] args) {
//		int[] arr = ArrayUtils.generateIntArrayNoDupSorted(12, -20, 20);
		
		TreeNode root = TreeNodeUtils.fromStringToTree("{10, 5,15,2,7,12,20}", TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);
		System.out.println("isBST: "+ isBST(root));
	}

//	Solution 1: to Array, SC is O(1) or O(N);
	public static boolean isBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	//(min, max) (min, root.val) (root.val, max)
	private static boolean isBST(TreeNode<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}

}
