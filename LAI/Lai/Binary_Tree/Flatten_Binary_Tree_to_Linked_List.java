package Lai.Binary_Tree;

import Utils.TreeNodeUtils.TreeNode;

/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


 *
 */
public class Flatten_Binary_Tree_to_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode flatten(TreeNode root) {
		// Write your solution here
		if (root == null) {
			return null;
		}
		TreeNode[] nodes = flatten2List(root);
		return nodes[0];
	}

	private static TreeNode[] flatten2List(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return new TreeNode[] { root, root };
		}
		TreeNode[] left = flatten2List(root.left);
		TreeNode[] right = flatten2List(root.right);
		if (left != null && right != null) {
			root.left = null;
			root.right = left[0];
			left[1].right = right[0];
			return new TreeNode[] { root, right[1] };
		}
		if (left != null) {
			root.left = null;
			root.right = left[0];
			return new TreeNode[] { root, left[1] };
		}
		// if(right != null){
		//root.left = null;
		root.right = right[0];
		return new TreeNode[] { root, right[1] };
		// }

	}

}
