package Lintcode.BinaryTree.Path.Sum;


/**
Binary Tree Maximum Path Sum II Show result 

Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)

Tags Expand 
Binary Tree


Related Problems Expand 
Medium Binary Tree Maximum Path Sum

 *
 */
public class Binary_Tree_Maximum_Path_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,8,#,#,-5,-2}";
//		String TreeNodeStrIn ="{1,9,8}";

		TreeNode root = TreeNode.fromStringToTree(TreeNodeStrIn);
		System.out.println(""+maxPathSum2(root));

	}
	
	//��root�����ͣ����ܽ���������ڵ㣬����null����0��Ҷ�ӽڵ�����䱾��ֵ
	//worked�����η�
    public static int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null) return 0;
        int leftMaxPathSum  = maxPathSum2(root.left);
        int rightMaxPathSum = maxPathSum2(root.right);
        //��ȷ���Ҽ��
        return Math.max(0, Math.max(leftMaxPathSum,rightMaxPathSum)) + root.val;
//        ��ȷ�ļ��㣬���Ǹ��ӆ���
//        return Math.max(leftMaxPathSum, 0) > Math.max(rightMaxPathSum, 0) ? Math.max(leftMaxPathSum, 0) + root.val: Math.max(rightMaxPathSum, 0) + root.val;
        //����ļ���
//        return leftMaxPathSum > rightMaxPathSum ? leftMaxPathSum + root.val: rightMaxPathSum + root.val;
    }

}
