package Lai.BinaryTree.LCA;

import java.util.Arrays;

import static Utils.TreeNodeUtils.*;

import Utils.StringUtils;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TreeNode;

public class Longest_Distance_in_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String TreeNodeStrIn = "{1,2,8,#,#,-5,2}";
//		String TreeNodeStrIn ="{1,9,8}";
//		TreeNode<Integer> root2 = TreeNodeUtil.fromStringToTree(TreeNodeStrIn); //.fromStringToTree(TreeNodeStrIn);
//		TreeNode<Integer> root2 = TreeNodeUtils.fromStringToTree(TreeNodeStrIn, TreeNode.class, Integer.class); // .fromStringToTree(TreeNodeStrIn);
//		printTree(root2);
//		TreeNode root = TreeNodeUtils.fromStringToTree("{1,2,3,4,5,#,#,#,#,6,7,#,#,#,8,#,9,#}", TreeNode.class, Integer.class);
//		TreeNode root = TreeNodeUtils.BINARY_TREE_SLASH_SLASH;
//		root = TreeNodeUtils.BINARY_TREE_COMPLETE_PLUS_L;
		TreeNode root = TreeNodeUtils.BINARY_TREE_TWO_NODE_BACK_SLASH;
//		root = TreeNodeUtils.BINARY_TREE_COMPLETE_PLUS_RIGHT;
		printTree(root);
		TreeNodeUtils.printTreeByTP(root);
		
		root = TreeNodeUtils.BINARY_TREE_DIAMOND_NEW;
//		root = TreeNodeUtils.BINARY_TREE_COMPLETE_PLUS_RIGHT;
		printTree(root);

		
//		System.out.println("" + findLongestDistance(root));
	}

//	给定一个二叉树，返回树里面距离最大的两个节点的距离。一个节点，返回0；两个节点，返回1；
	static int findLongestDistance(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] longest = new int[1];
		TP tp = TP.build("", "111", "root", null);
		int val = getHeight(longest, root, tp); TP.build("root", null, val, longest[0], StringUtils.toStr(root));
		tp.print();
		return longest[0];
	}

//	给定一个二叉树节点，返回从根节点到最深的叶子节点的距离，也就是树的高度
	static int getHeight(int[] longest, TreeNode root, TP tp) {
		if (root == null) {
//			TP.build(TP.IS_BASE_CASE, tp, 0, longest[0], toStr(root));
			return 0;
		}
		int left = getHeight(longest, root.left, TP.build("left", tp));    TP.build("left", tp, left, longest[0], StringUtils.toStr(root.left));
		int right = getHeight(longest, root.right, TP.build("right", tp)); TP.build("right", tp, right, longest[0], StringUtils.toStr(root.right));
		longest[0] = Math.max(longest[0], left + right);
		return Math.max(left, right) + 1;
	}
//	private int 

}
