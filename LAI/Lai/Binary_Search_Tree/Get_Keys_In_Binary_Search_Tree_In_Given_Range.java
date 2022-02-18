package Lai.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Get_Keys_In_Binary_Search_Tree_In_Given_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{10, 5,15,2,7,12,20}", TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);
		System.out.println("isBST: " + getRange(root, 8, 18));
	}

	public static List<Integer> getRange(TreeNode<Integer> root, int min, int max) {
		List<Integer> result = new ArrayList<>();
		getRange(root, min, max, result);
		System.out.println("result: " + result);
		return result;
	}

//浪费太多，每个节点都去了一遍, TC: O(N), SC: O(H)
	private static void getRange00(TreeNode<Integer> root, int min, int max, List<Integer> result) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		getRange(root.left, min, max, result);
		if (root.val >= min && root.val <= max) {
			result.add(root.val);
		}
		getRange(root.right, min, max, result);
	}

//	浪费太多，每个节点都去了一遍, TC: O(Height + Num of Nodes in the range), SC: O(H)
	private static void getRange(TreeNode<Integer> root, int min, int max, List<Integer> result) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		if(root.val > min) {
			getRange(root.left, min, max, result);
		}
		if (root.val >= min && root.val <= max) {
			result.add(root.val);
		}
		if(root.val < max) {
			getRange(root.right, min, max, result);
		}
	}

}
