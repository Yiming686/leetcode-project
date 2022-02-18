package Lai.BinaryTree.LCA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static Utils.TreeNodeUtils.*;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;
import Utils.TreeNodeUtils.TreeNode.*;

public class Preorder_Traversal_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{1,2,#,3}", TreeNode.class, Integer.class);
//		TreeNode root = TreeNodeUtils.fromStringToTree("{10, 5,15,2,7,12,20}", TreeNode.class, Integer.class);
//		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);
		
//		TreeNodeUtils.printTreeByTP(BINARY_TREE_ONE);
//		System.out.println("isBST: " + preorder(BINARY_TREE_ONE));
		System.out.println("preorder: " + preorder(root));

	}
	
	public static List<Integer> preorder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		while(!stack.isEmpty()) {
			TreeNode<Integer> node = stack.pollFirst();
			result.add(node.val);
			if(node.right != null) {
				stack.offerFirst(node.right);
			}
			if(node.left != null) {
				stack.offerFirst(node.left);
			}
		}
		return result;
	}

}
