package Lai.Recursion_II;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Binary_Tree_Path_Sum_To_Target_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{2,3,2}", TreeNode.class, Integer.class);
		root = TreeNodeUtils.BINARY_TREE_GENERAL;
		System.out.println(""+TreeNodeUtils.fromTreeToString(root));;
//		5,1,null,-1,7,0
		root = TreeNodeUtils.fromStringToTree("{5,1,null,-1,7,0}", TreeNode.class, Integer.class);
		root = TreeNodeUtils.fromStringToTree("{3,-8,9,4,10,2,-5,1,-2}", TreeNode.class, Integer.class);
//		[]{3,-8,9,4,10,2,-5,1,-2}), 
		TreeNodeUtils.printTree(root);
	}

}
