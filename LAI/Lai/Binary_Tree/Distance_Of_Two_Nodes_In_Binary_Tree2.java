package Lai.Binary_Tree;

import Utils.StringUtils;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TreeNode;

/**
 * 
 * 
Find distance between two given keys of a Binary Tree, no parent pointers are given. Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.

Assumptions:

There are no duplicate keys in the binary tree.
The given two keys are guaranteed to be in the binary tree.
The given two keys are different.
Examples:

    1

   /  \

  2    3

 / \  /  \  

4   5 6   7

       \

         8

distance(4, 5) = 2

distance(4, 6) = 4


 *
 */
public class Distance_Of_Two_Nodes_In_Binary_Tree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TreeNode root = TreeNodeUtils.fromStringToTree("{\"7\",\"3\",\"9\",\"1\",\"5\",\"8\",\"10\",\"#\",\"2\",\"4\",\"6\"}");
//		TreeNode root = TreeNodeUtils.fromStringToTree("{\"7\",\"3\",\"9\",\"1\",\"5\",\"8\",\"10\",\"#\",\"2\",\"4\",\"6\"}");
		TreeNode root = TreeNodeUtils.fromStringToTree("{\"7\",\"3\",\"9\",\"1\",\"5\",\"8\",\"10\",\"#\",\"2\",\"4\",\"6\"}");
//		TreeNode root = TreeNodeUtils.fromStringToTree("{5,3,8,#,4}");
		TreeNodeUtils.printTree(root);
		
		TreeNodeUtils.printTreeByTP(root, false);
//		System.out.println(""+pathSum(root, 2));
//		System.out.println("" + distance(root, 8, 1));
		TP tp = TP.build("", "11", "root", null);
//		int dis = distance(root, 2, 6, tp);TP.build("root", null, dis, toStr(root));//进来再加，
		int dis = distance(root, 1, 8, tp);TP.build("root", null, dis, StringUtils.toStr(root));//进来再加，
		tp.print();
		System.out.println("" + dis);
		
	}
	
	//0表示没找着，1表示找着并且距离当前节点1，
	  public static int distance(TreeNode<Integer> root, int k1, int k2 , TP paraTp) {
		    // Write your solution here
		  if(root == null) {
			  return 0;//
		  }
		  if(root.val == k1 || root.val == k2) {
			  return 1;
		  }
		  int left = distance(root.left, k1, k2,TP.build("left", paraTp)); TP.build("left", paraTp, left, StringUtils.toStr(root.left));
		  int right = distance(root.right, k1, k2,TP.build("right", paraTp));TP.build("right", paraTp,right, StringUtils.toStr(root.right));
		  if(left == 0 && right == 0) {
			  return 0;
		  }
		  if(left != 0 && right != 0) {
			  return (left + right);//??
		  }
		  if(left > 0) {
			  return left + 1;
		  }
		  if(right > 0) {
			 return right + 1;
		  }
		  return left != 0 ? left : right;
	  }

}
