package Lintcode.BinaryTree.Path.Sum;


/**
Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 6.

Tags Expand 
Divide and Conquer Dynamic Programming Recursion


Related Problems Expand 
Easy Minimum Path Sum 33 %

 *
 */
public class Binary_Tree_Maximum_Path_Sum {
    //singlepath:�ֲ�ֵ���Ե�ǰ�����ڵ�Ϊ��һ���ڵ�����·���ͣ����Ҵ��ڵ���0
    //���㵱ǰsinglepathֻ���ӽڵ��singlepath���
    //maxpath:ȫ��ֵ������ĵ�ǰ�������path����һ��ͨ����ǰ���ĸ��ڵ�
    //���㵱ǰmaxpath�����ӽڵ��maxpath�Ƚϣ�Ȼ��
    private class Result {
        int singlePath, maxPath;
        Result(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    //worked,singlePath�������⣬����ֵ��һ������ֵ�����ɸ�
    private Result helper(TreeNode root) {
        
    	//[�����]��rootΪnullʱ��result�ĳ�ֵ�ǳ���Ҫ���������ʣ�maxPath����Ϊ��С��������singlePath����Ϊ0
        // if(root == null){ return new Result(0, Integer.MIN_VALUE);}
        // if(root == null){ return new Result(0, 0);}
        if(root == null){ return new Result(0, Integer.MIN_VALUE);}
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        
        int singlePath = Math.max(left.singlePath + root.val, right.singlePath + root.val) ;
        // singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        // maxPath = Math.max(maxPath, left.singlePath + root.val + right.singlePath);
        maxPath = Math.max(maxPath, root.val);
        maxPath = Math.max(maxPath, left.singlePath + root.val);
        maxPath = Math.max(maxPath, root.val + right.singlePath);
        maxPath = Math.max(maxPath, left.singlePath + root.val + right.singlePath);

        
        return new Result(singlePath, maxPath);
    }

	//jiuzhang solution���ɳ�Ϊ�������΢�Ľ���
    //worked,singlePath���岻����⣬��ֵ���ڵ���0
    private Result helper2(TreeNode root) {
        if(root == null){ return new Result(0, Integer.MIN_VALUE);}
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath + root.val, right.singlePath + root.val) ;
        singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + root.val + right.singlePath);
        
        return new Result(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        Result result = helper(root);
        return result.maxPath;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
