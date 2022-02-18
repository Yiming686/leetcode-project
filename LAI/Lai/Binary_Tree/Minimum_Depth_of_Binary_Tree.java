package Lai.Binary_Tree;

import static Utils.TreeNodeUtils.toStr;

import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TreeNode;

public class Minimum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = TreeNodeUtils.fromStringToTree("[10,5,-3,3,2,null,11,3,-2,null,1]");
		TreeNode root = TreeNodeUtils.fromStringToTree("{\"170\",\"#\",\"199\",\"175\",\"#\",\"173\",\"178\",\"171\",\"174\",\"176\",\"#\",\"#\",\"172\",\"#\",\"#\",\"#\",\"177\"}");
//		TreeNode root = TreeNodeUtils.fromStringToTree("{5,3,8,#,4}");
		TreeNodeUtils.printTree(root);
		
		TreeNodeUtils.printTreeByTP(root, false);
//		System.out.println(""+pathSum(root, 2));
		System.out.println("" + minDepth(root));

	}

	public static int minDepth(TreeNode root) {
		// Write your solution here
		int[] min = new int[] { Integer.MAX_VALUE };
		TP tp = TP.build("", "111", "root", null);
		int height = minDepth(root, min, tp);TP.build("root", null, height, StringUtils.toStr(root), min[0]);//进来再加，
		tp.print();
		return height;
	}

	public static int minDepth(TreeNode root, int[] min, TP paraTp) {
		if (root == null) {paraTp.mark();
//			return Integer.MAX_VALUE;
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int left = minDepth(root.left, min, TP.build("left", paraTp));   TP.build("left", paraTp, left, StringUtils.toStr(root.left), min[0]);
		int right = minDepth(root.right, min , TP.build("right", paraTp));TP.build("right", paraTp,right, StringUtils.toStr(root.right), min[0]);
		if(root.left == null) {
			return right + 1;
		}
		if(root.right == null) {
			return left + 1;
		}

//		if(left != 0 && right != 0) {
//			min[0] = Math.min(left, right) + 1;	
//		}else if(left == 0){
//			min[0] = right + 1;
//		}else {// if(right == 0) {
//			min[0] = left + 1;
//		}
		
		return Math.min(left, right) + 1;

	}

}
