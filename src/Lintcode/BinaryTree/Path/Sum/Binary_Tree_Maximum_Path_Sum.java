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
    //singlepath:局部值，以当前树根节点为第一个节点的最大路径和，并且大于等于0
    //计算当前singlepath只和子节点的singlepath相关
    //maxpath:全局值，所求的当前树的最大path，不一定通过当前树的根节点
    //计算当前maxpath，是子节点的maxpath比较，然后
    private class Result {
        int singlePath, maxPath;
        Result(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    //worked,singlePath含义好理解，但是值不一样，此值可正可负
    private Result helper(TreeNode root) {
        
    	//[考察点]当root为null时，result的初值非常重要，毫无疑问，maxPath必须为最小整数，而singlePath必须为0
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

	//jiuzhang solution，可称为上面的稍微改进版
    //worked,singlePath含义不好理解，此值大于等于0
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
