package Lintcode.Common.Questions;

import Lintcode.BinaryTree.TreeNode;

/**
[] 在一个二叉树里面寻找 元素值
 *
 */
public class Search_For_Value_In_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{3,4,5,#,6,7}");
		System.out.println(""+ TreeNode.convertToString(root));
		System.out.println(""+search(root, 2));
		System.out.println(""+search(root, 3));
		System.out.println(""+search(root, 4));
		System.out.println(""+search(root, 5));
		System.out.println(""+search(root, 6));
		System.out.println(""+search(root, 7));
		System.out.println(""+search(root, 8));
	}
	
	static boolean search(TreeNode root, int val){
	    if(root == null) return false;
	    if(root.val == val) return true;
	    
	    boolean left  =  search(root.left, val);
	    boolean right =  search(root.right, val);
	    
	   return left || right;
	}


}
