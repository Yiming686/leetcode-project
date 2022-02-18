package Lai.BinaryTree.LCA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;
import javafx.scene.transform.Rotate;

public class Inorder_Traversal_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{1,2,#,3,4,5,6,7}", TreeNode.class, Integer.class);
//		TreeNode root = TreeNodeUtils.fromStringToTree("{10, 5,15,2,7,12,20}", TreeNode.class, Integer.class);
//		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);

//		TreeNodeUtils.printTreeByTP(BINARY_TREE_ONE);
//		System.out.println("isBST: " + preorder(BINARY_TREE_ONE));
		System.out.println("inOrder: " + inorder(root));

	}

	public static List<Integer> inorder00(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode<Integer> curr = root;
//		stack.offerFirst(root);
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.offerFirst(curr);
				curr = curr.left;
			} else {
				curr = stack.pollFirst();
				result.add(curr.val);
				curr = curr.right;
			}
		}
		return result;
	}

	public static List<Integer> inorder(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode<Integer> curr = root;

//		stack.offerFirst(root);
//		离开，令栈不空
		while (curr != null) {
			stack.offerFirst(curr);
			curr = curr.left;
		}
		while (!stack.isEmpty()) {
//			第二次遇到
			curr = stack.pollFirst();
			result.add(curr.val);
			curr = curr.right;
//			离开
			while (curr != null) {
				stack.offerFirst(curr);
				curr = curr.left;
			}
		}

		return result;
	}

}
