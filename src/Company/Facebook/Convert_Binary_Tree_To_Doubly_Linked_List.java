package Company.Facebook;

import Lintcode.BinaryTree.TreeNode;

public class Convert_Binary_Tree_To_Doubly_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode convert(TreeNode root){
		TreeNode dummy = new TreeNode(0);
		helper(root, dummy);
		return dummy.right;
	}

	private static void helper(TreeNode root, TreeNode dummy) {
		if(root == null) return ;
		helper(root.left, root);
		dummy.right = root;
		root.left = dummy;
		helper(root.right, root);
		
	}
	

}
