package Lai.Binary_Search_Tree;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Delete_In_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = TreeNodeUtils.COMPLETE_TREE;
//		TreeNode<Integer> root = TreeNodeUtils.GENERAL_TREE;
		TreeNode<Integer> root = TreeNodeUtils.ONLY_RIGHT_CHILD_TREE;
		TreeNodeUtils.printTree(root);
		deleteSmallest(root);
		TreeNodeUtils.printTree(deleteSmallest(root));

//		TreeNodeUtils.printTree(deleteSmallest(deleteSmallest(root)));
		

	}

	//给定Tree 和 node的值，删除对应node，返回新的树的根节点
	public static TreeNode<Integer> delete(TreeNode<Integer> root, int target) {
		if(root == null) {
			return null;
		}
		if(root.val < target) {
			root.right = delete(root.right, target);
			return root;
		}else if(root.val > target) {
			root.left = delete(root.left, target);
			return root;
		}
		//case: root.val == target
		if(root.left == null && root.right == null) {
			return null;
		}
		if(root.left == null) {
//			root.right = null;
			return root.right;
		}else if(root.right == null) {
			return root.left;
		}
		//case: root.left != null && root.right != null, find smallest in right subtree, make it new root and return it;
		TreeNode<Integer> smallest = deleteSmallest(root.right);
		//case: smallest.right == null or smallest.right != null
		smallest.left = root.left;
		smallest.right = root.right;
		
		return smallest;

	}

	private static TreeNode<Integer> deleteSmallest(TreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return null;
		}
		if(root.left == null) {
			TreeNode<Integer> curr = root.right;
//			root.right = null;
			return curr;
		}
		TreeNode<Integer> curr = root;
		while(curr.left.left != null) {
			curr = curr.left;
		}
		TreeNode<Integer> smallest = curr.left;
		curr.left = smallest.right;
		return smallest;
	}
	
	

}
