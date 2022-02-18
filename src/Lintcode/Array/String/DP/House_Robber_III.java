package Lintcode.Array.String.DP;

import Lintcode.BinaryTree.TreeNode;

/**

// 给定意义下的 TreeNode SUM
337. House Robber III
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.


 *
 */
public class House_Robber_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//  worked， 二步递推的二叉树递归
 public int rob(TreeNode root) {
     if (root == null)
         return 0;
     int firstMax = root.val;
     int secondMax = 0;
     if (root.left != null) {
         firstMax += rob(root.left.left) + rob(root.left.right);
         secondMax += rob(root.left);
     }
     if (root.right != null) {
         firstMax += rob(root.right.left) + rob(root.right.right);
         secondMax += rob(root.right);
     }
     return (firstMax > secondMax) ? firstMax : secondMax;    
 }

 
}
