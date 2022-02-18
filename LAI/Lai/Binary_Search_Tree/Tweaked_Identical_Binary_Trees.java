package Lai.Binary_Search_Tree;

import javax.jws.Oneway;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Tweaked_Identical_Binary_Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{10, 5,15,2,7,12,20}", TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);
		System.out.println("isBST: " + isTweakedIdentical(root));

	}
	public static boolean isTweakedIdentical(TreeNode root) {
		if(root == null) {
			return true;
		}
		return isTweakedIdentical(root.left, root.right);
	}
	
	public static boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		// Write your solution here
		if(one == null && two == null) {
			return true;
		}
		if(one == null || two == null) {
			return false;
		}
		if(one.val != two.val) {
			return false;
		}
		return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left) ;
	}

}
