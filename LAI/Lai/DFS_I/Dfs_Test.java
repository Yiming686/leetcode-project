package Lai.DFS_I;

import Utils.TreeNodeUtils;

public class Dfs_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abc";
//		System.out.println(""+permutations(str));
		int val = 4;
		TreeNodeUtils.TreeNode<Integer> root = new TreeNodeUtils.TreeNode<>(val);
		dfs(val, root);
		TreeNodeUtils.printTree(root);
	}

	private static void dfs(int val, TreeNodeUtils.TreeNode<Integer> root) {
		if(val == 1) {
			return;
		}
		root.left = new TreeNodeUtils.TreeNode<>(val - 1);
		root.right = new TreeNodeUtils.TreeNode<>(val - 1);
		dfs(val - 1, root.left);
		dfs(val - 1, root.right);
		
	}
}
