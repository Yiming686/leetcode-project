package Lai.DB18.JQ_I;

import Utils.TreeNodeUtils.TreeNode;
import javafx.scene.Parent;

public class Closest_Number_In_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int closest(TreeNode<Integer> root, int target) {
//		if(root == null) {
//			return -1;
//		}
		TreeNode<Integer> parpar = null;
		TreeNode<Integer> par = null;
		while(root != null) {
			parpar = par;
			par = root;
			if(target < root.val) {
				root = root.left;
			}else {
				root = root.right;
			}			
		}
		
		return Math.abs(par.val - target) < Math.abs(parpar.val - target) ? par.val : parpar.val;
	}

}
