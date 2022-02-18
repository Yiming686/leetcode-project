package Lai.DB18.JQ_I;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

/**
 * 
 * Given K nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * 
 * K >= 2
 * 
 * There is no parent pointer for the nodes in the binary tree
 * 
 * The given K nodes are guaranteed to be in the binary tree
 *
 * 
 * 
 * 
 * 
 * 
 */
public class Lai_129_Lowest_Common_Ancestor_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("[8,3,10,1,6,null,14,null,null,4,7,13]");
		TreeNodeUtils.printTree(root);
		List<TreeNode> list = new ArrayList<>();
		list.add(root.left.left);
		list.add(root.left.right.right);
		list.add(root.right.right);
		
		System.out.println("" + lowestCommonAncestor(root, list).val);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		if (root == null) {
			return null;
		}
		if (nodes.contains(root)) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, nodes);
		TreeNode right = lowestCommonAncestor(root.right, nodes);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	private static TreeNode lowestCommonAncestor_126(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return null;
		}
		if (root == one || root == two) {
			return root;
		}
		TreeNode left = lowestCommonAncestor_126(root.left, one, two);
		TreeNode right = lowestCommonAncestor_126(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

}
