package Lai.Binary_Search_Tree;

import static Utils.TreeNodeUtils.*;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Check_If_Binary_Tree_is_Balanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{1,2,#,3}", TreeNode.class, Integer.class);
//		TreeNode root = TreeNodeUtils.fromStringToTree("{10, 5,15,2,7,12,20}", TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);
		System.out.println("isBST: " + isBalanced(root));

	}

	public static boolean isBalanced(TreeNode root) {
		// Write your solution here
		return getHeight(root) == -1 ? false : true;
	}

	//if valid, from 0, 1 to height
	private static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left == -1 || right == -1) {
			return -1;
		}
	    if(Math.abs(left - right) > 1){
	        return -1;
	      }

		return Math.max(left, right) + 1;
	}

}
