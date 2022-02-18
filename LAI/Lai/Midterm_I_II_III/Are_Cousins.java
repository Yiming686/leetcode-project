package Lai.Midterm_I_II_III;

import Utils.TreeNodeUtils.TreeNode;

public class Are_Cousins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean areCousins(TreeNode root, TreeNode node1, TreeNode node2) {
		if(node1 == node2) {
			return true;
		}
		TreeNode[] parents = new TreeNode[2];
		int[] depths = new int[2];
		areCousins(parents, depths, root, node1, node2, null, 0);
		if(depths[0] != depths[1]) {
			return false;
		}
		if(parents[0] != parents[1]) {
			return false;
		}
		return true;
	}

	private void areCousins(TreeNode[] parents, int[] depths, TreeNode root, TreeNode node1, TreeNode node2, TreeNode parent, int depth) {
		if(root == null) {
			return;
		}
		if(root == node1) {
			parents[0] = parent;
			depths[0] = depth;
			return;
		}
		if(root == node2) {
			parents[1] = parent;
			depths[1] = depth;
			return;
		}
		areCousins(parents, depths, root.left, node1, node2, root, depth + 1);
		areCousins(parents, depths, root.right, node1, node2, root, depth + 1);
	}
}
