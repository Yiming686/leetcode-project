package Lai.Binary_Search_Tree;

import Utils.TreeNodeUtils.TreeNode;

public class Leet_99_Recover_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void recoverTree(TreeNode root) {
		// traverse and get two elements
		TreeNode<Integer>[] nodes = new TreeNode[3];
		// nodes[2] = new TreeNode(Integer.MIN_VALUE); 
		traverse(root, nodes);
		// swap
		int temp = nodes[0].val;
		nodes[0].val = nodes[1].val;
		nodes[1].val = temp;
	}

//	node0��node1�������ڣ�Ҳ���Լ���������ѵ㴦����������else
	private static void traverse(TreeNode<Integer> root, TreeNode<Integer>[] nodes) {
		if (root == null) {
			return;
		}
		traverse(root.left, nodes);
		if (nodes[2] != null) {
			if (nodes[0] == null && root.val < nodes[2].val) {
				nodes[0] = nodes[2];
			}//�ѵ��������������else
			if (nodes[0] != null && root.val < nodes[2].val) {
				nodes[1] = root;
			}
		}
		nodes[2] = root;//����prev always
		traverse(root.right, nodes);
	}

}
