package Leet.Binary_Tree;

import static Utils.ArrayUtils.print;
import static Utils.TreeNodeUtils.printTree;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Leet_226_Invert_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{2,3,4,5,6,7,8,9,10,11,12,13,14}");
		printTree(root);
		invertTree(root);
		printTree(root);
	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		// root.right = invertTree(root.left);
		// root.left = invertTree(root.right);
		// TreeNode temp = root.left;
		// root.left = root.right;
		// root.right = temp;
		root.left = right;
		root.right = left;
		return root;
	}

}
