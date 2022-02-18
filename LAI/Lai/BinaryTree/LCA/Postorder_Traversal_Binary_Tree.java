package Lai.BinaryTree.LCA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Utils.TreeNodeUtils.TreeNode;

public class Postorder_Traversal_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode<Integer> curr = stack.peek();//看一下栈顶，不能急着poll
			if (prev == null || prev.left == curr || prev.right == curr) {//向下走，当前curr三种情况，很清晰：
				if (curr.left != null) {
					stack.offerFirst(curr.left);
				} else if (curr.right != null) {
					stack.offerFirst(curr.right);
				} else {//curr为叶子节点
					stack.pollFirst();
					result.add(curr.val);
				}
			} else if (curr.left == prev && curr.right == null || curr.right == prev) {//向上走，third times
				stack.pollFirst();
				result.add(curr.val);
			} else { // going up but curr.rigtht != null;
				stack.offerFirst(curr.right);
			}
			prev = curr;
		}
		return result;
	}
}
