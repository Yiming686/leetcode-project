package Leet.XB.Mock.Day_032120;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TreeNode;

public class Lai_296_Right_View_Of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		int depth = 0;
		rightSideView(root, result, depth);
		return result;
	}

	private static void rightSideView(TreeNode<Integer> root, List<Integer> result, int depth) {
		if (root == null) {
			return;
		}
		if (result.size() == depth) {
			result.add(root.val);
		}
		rightSideView(root.right, result, depth + 1);
		rightSideView(root.left, result, depth + 1);
	}

}
