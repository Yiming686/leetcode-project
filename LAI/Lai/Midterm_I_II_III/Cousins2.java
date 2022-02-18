package Lai.Midterm_I_II_III;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Cousins2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{6,3,5,7,8,1,2}", TreeNode.class, Integer.class);
		System.out.println(""+isCousins(root, root.left.left, root.right.left));
	}
	
	public static boolean isCousins(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2) {
		Integer level= 0;
		Integer[] levelOfNode1 = new Integer[1];
		ArrayList<TreeNode<Integer>> parent = new ArrayList<TreeNode<Integer>>();
		Boolean[] isCousins = new Boolean[1]; 
		helper(root, node1, node2, level, levelOfNode1, parent, isCousins);
		return isCousins[0];
	}
	private static void helper(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2,  Integer level, Integer[] levelOfNode1, ArrayList<TreeNode<Integer>> parent, Boolean[] isCousins) {
		if(root == null) {
			return;
		}
		if(root.left == node1 || root.right == node2) {
			if(levelOfNode1[0] == null) {
				levelOfNode1[0] = level + 1;
				parent.add(root);
			}else {
				if(levelOfNode1[0] == level + 1 && parent.get(0) == root ) {
					isCousins[0] = Boolean.TRUE;
				}else {
					isCousins[0] = Boolean.FALSE;
				}
			}
		}
		helper(root.left, node1, node2, level + 1, levelOfNode1, parent, isCousins);
		helper(root.right, node1, node2, level + 1, levelOfNode1, parent, isCousins);
	}

}
