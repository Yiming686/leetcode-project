package Lai.DB18.JQ_I;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Lai_128_Lowest_Common_Ancestor_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("[8,3,10,1,6,null,14,null,null,4,7,13]");
		TreeNodeUtils.printTree(root);
		
		System.out.println("" + lowestCommonAncestor(root, root.left.left, root.left.right.right));

	}

	public static TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode one, TreeNode two) {
		if (root == null) {
			return null;
		}
		int[] count = new int[1];
		return count[0] == 2 ? lca(root, count, one, two) : null;
	}

	private static TreeNode lca(TreeNode root, int[] count, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}
		System.out.println(""+root.val);
		TreeNode left = lca(root.left, count, node1, node2);
		TreeNode right = lca(root.right, count, node1, node2);
		// if(root == node1 && node1 == node2){
		//      count[0]++;count[0]++;
		//      return node1;
		//  }
		if (root == node1 || root == node2) {
			count[0]++;
			System.out.println(""+count[0]);
			return root;
		}
		if (left != null && right != null) {
			return root;
		}
		return (left != null) ? left : right;
	}

}
