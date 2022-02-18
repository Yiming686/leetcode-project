package Lai.DP;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Cut_Rope {
	
	public static void main(String[] args) {
//		TreeNodeUtil2.printTree(COMPLETE_TREE);
//		TreeNodeUtil2.printTree(ONLY_LEFT_CHILD_TREE);
//		TreeNodeUtil2.printTree(ONLY_RIGHT_CHILD_TREE);
//		TreeNode<Integer> COMPLETE_TREE =  TreeNodeUtil2.fromStringToTree("{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}", TreeNode.class, Integer.class);
//		TreeNode<Integer> COMPLETE_TREE =  TreeNodeUtil2.fromStringToTree("{ 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15}", TreeNode.class, Integer.class);
		TreeNode<Integer> COMPLETE_TREE =  TreeNodeUtils.fromStringToTree("{ 8, 4,12, 2, 6,10,14, 1, 3, 5, 7, 9,11,13,15}", TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(COMPLETE_TREE);
	}

}
