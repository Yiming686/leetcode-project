package Lai.DB18.JQ_I;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;


/**

LCA  with PARENT pointer

Given two nodes in a binary tree (with PARENT pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree




 *
 */
public class Lai_127_Lowest_Common_Ancestor_II {

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
