package LeetCode.JavaTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LC_112_Path_Sum_I {
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
 
 */

//	递归方法一般考虑折半，分拆的思路，把root变为root.left, root.right处理
//	这个递归不仅拆分root，还有考虑sum的拆解
//	此解法为动态带变量值的前序遍历
//	Tree，DFS
	
//	Accepted, 350ms,  pass at first time
	public boolean hasPathSum(TreeNode root, int sum) {
//		边界条件：1，节点为null是怎么办，2.节点为叶子是怎么办
		if(root == null){return false;}
		if(root.left == null && root.right == null && root.val == sum) return true;
		
//		代码优化，以下代码冗长，更换为更简洁的
//		boolean left = hasPathSum(root.left, sum - root.val);
//		if(left == true) return true;
//		boolean right = hasPathSum(root.right, sum - root.val);
//		if(right == true) return true;
//		return false;
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
