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

//	�ݹ鷽��һ�㿼���۰룬�ֲ��˼·����root��Ϊroot.left, root.right����
//	����ݹ鲻�����root�����п���sum�Ĳ��
//	�˽ⷨΪ��̬������ֵ��ǰ�����
//	Tree��DFS
	
//	Accepted, 350ms,  pass at first time
	public boolean hasPathSum(TreeNode root, int sum) {
//		�߽�������1���ڵ�Ϊnull����ô�죬2.�ڵ�ΪҶ������ô��
		if(root == null){return false;}
		if(root.left == null && root.right == null && root.val == sum) return true;
		
//		�����Ż������´����߳�������Ϊ������
//		boolean left = hasPathSum(root.left, sum - root.val);
//		if(left == true) return true;
//		boolean right = hasPathSum(root.right, sum - root.val);
//		if(right == true) return true;
//		return false;
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
