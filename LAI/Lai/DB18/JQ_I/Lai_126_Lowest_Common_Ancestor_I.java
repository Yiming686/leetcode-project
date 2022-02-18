package Lai.DB18.JQ_I;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;


/**

Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree



 *
 */
public class Lai_126_Lowest_Common_Ancestor_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("[8,3,10,1,6,null,14,null,null,4,7,13]");
		TreeNodeUtils.printTree(root);
		
		System.out.println("" + lowestCommonAncestor(root, root.left.left, root.left.right.right).val);
		
	}

	  // worked
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two){
	  if(root == null){
	    return null;
	  }
	  if(root == one || root == two){
	    return root;
	  }
	  TreeNode left = lowestCommonAncestor(root.left, one, two);
	  TreeNode right = lowestCommonAncestor(root.right, one, two);
	  if(left != null && right != null){
	    return root;
	  }
	  return left != null ? left : right;
	}

}
