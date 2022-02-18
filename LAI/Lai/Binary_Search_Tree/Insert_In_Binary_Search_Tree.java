package Lai.Binary_Search_Tree;

import static Utils.TreeNodeUtils.*;
import Utils.TreeNodeUtils.TreeNode;

public class Insert_In_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTree(BINARY_TREE_GENERAL);

	}

//	Iterative
	public TreeNode insert11(TreeNode root, int target) {
		TreeNode node = new TreeNode(target);
		if (root == null) {
			return node;
		}
		TreeNode<Integer> prev = null;
		TreeNode<Integer> curr = root;
		while (curr != null) {
			prev = curr;
			if (target < curr.val) {
				curr = curr.left;
			} else if (target > curr.val) {
				curr = curr.right;
			} else {
				return root;
			}
		}
		//curr == null;
		if (target < prev.val) {
			prev.left = node;
		} else {
			prev.right = node;
		}
		return root;
	}

}
