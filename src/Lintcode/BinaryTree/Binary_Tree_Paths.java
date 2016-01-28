package Lintcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Paths Show result
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Have you met this question in a real interview? Yes Example Given the
 * following binary tree:
 * 
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 * [ "1->2->5", "1->3" ] Tags Expand Binary Tree Binary Tree Traversal Facebook
 * Google
 *
 */
public class Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
    
    public List<String> binaryTreePaths2(TreeNode root) {
        // Write your code here
    // }
    // public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        // List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<String> result = new ArrayList<String>();
        if(root == null) return result;
        StringBuilder sb = new StringBuilder();
        //第一次调用，主要是初始化list和sum
        helper(result, sb, root);
        return result;
    }
    
    //helper的含义：在root为根节点的树中，寻找当前和sum为target的路径，加入list，加入result
    private static void helper(List<String> result,StringBuilder sb, TreeNode root){
        if(root == null) return;
        sb.append("->"+root.val);
    
        if(root.left != null){
            sb.append("->"+root.left.val);
            helper(result, sb, root.left);
            // sb.append.remove÷/(list.size()-1);
        }
        if(root.right != null){
            sb.append("->"+root.right.val);
            helper(result, sb, root.right);
            // sb.append.remove(list.size()-1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
