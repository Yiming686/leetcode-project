package Leet.Binary_Tree.View;

import static Utils.TreeNodeUtils.printTree;
import static Utils.TreeNodeUtils.printTreeByTP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TreeNode;

public class Top_View_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{5,1,9,#,3,8,11,2,7,#,#,#,#,#,#,8,#,9}");
//		TreeNode<Integer> root0 = TreeNodeUtils
//				.fromStringToTree("{5,1,9,#,3,8,11,2,7,#,6,#,#,#,#,8,#,#,9,9,#, #,10, #,#,#,12}");
//		printTree(root0);
		
//		TreeNode<Integer> root = TreeNodeUtils
//				.fromStringToTree("{5,1,9,#,3,8,11,2,#,#,6,#,#,7,#,#,9,8,#, #,10, 9,#,#,12,18,#,#,#}");
		TreeNode<Integer> root = TreeNodeUtils
				.fromStringToTree("{5,1,9,#,3,8,11,2,#,#,6,#,#,7,#,#,9,8,#, #,10, 9,#,#,12,#,#, #,20, #, 33}");
//		TreeNodeUtils.printTree(root);
//		TreeNodeUtils.printTreeByTP(root, false);
//		TreeNodeUtils.printTreeByTP(root);
//		printTree(root);
		printTreeByTP(root, true);
//		System.out.println(""+inorder(root));
		System.out.println("topSideView_ite: " + topSideView_ite(root));
//		System.out.println("topSideView_rec: " + topSideView_rec(root));
	}

//	private static List<Integer> inorder(TreeNode<Integer> root) {
//		List<Integer> result = new ArrayList<>();
//		if (root == null) {
//			return result;
//		}
//		inorder(result, root);
//		return result;
//	}
//
//	private static void inorder(List<Integer> result, TreeNode<Integer> root) {
//		if (root == null) {
//			return;
//		}
//		inorder(result, root.left);
//		inorder(result, root.right);
//		result.add(root.val);
//	}

	public static List<Integer> topSideView_rec(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		topSideView_rec(result, root, 0);
		return result;
	}

//	逐步填充技术，妙，index已经标注好了，当第一次遇到的时候，加入即可！每一层都是从右到左遍历的，因为是特殊的先右后左的preorder遍历
	private static void topSideView_rec(List<Integer> result, TreeNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (result.size() == level) {
			result.add(root.val);
			;
		}
		topSideView_rec(result, root.left, level + 1);
		topSideView_rec(result, root.right, level + 1);
	}

	public static List<Integer> topSideView_ite(TreeNode<Integer> root) {
		LinkedList<Integer> result = new LinkedList<>();//
		if (root == null) {
			return result;
		}
		int minCol = 0;
		int maxCol = 0;
		Deque<NodeWithColumn> queue = new ArrayDeque<>();
		queue.offer(new NodeWithColumn(root, 0));
		result.addFirst(root.val);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NodeWithColumn curr = queue.poll();
//				System.out.println(""+curr.node.val);
				if (curr.node.left != null) {
					//possible to update minCol
					if(curr.col == minCol) {
						minCol--;
						result.addFirst(curr.node.left.val);
					}
					queue.offer(new NodeWithColumn(curr.node.left, curr.col - 1));
				}
				if (curr.node.right != null) {
					//possible to update maxCol
					if(curr.col == maxCol) {
						maxCol++;
						result.addLast(curr.node.right.val);
					}
					queue.offer(new NodeWithColumn(curr.node.right, curr.col + 1));
				}
			}
		}
		return result;
	}
	static class NodeWithColumn{
		TreeNode<Integer> node;
		int col;
		public NodeWithColumn(TreeNode node, int col) {
			this.node = node;
			this.col = col;
		}
	}

}
