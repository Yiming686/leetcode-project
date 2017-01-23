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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //worked, basic solution, 用string来遍历, recommend
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
        StringBuilder sb = new StringBuilder();
        binaryTreePaths(list, root, "");
        return list;
    }
    private void binaryTreePaths(List<String> list, TreeNode root, String str) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(str+root.val);
            return;
        }
        binaryTreePaths(list, root.left,  str+root.val+"->");
        binaryTreePaths(list, root.right, str+root.val+"->");
    }
//----------------------------------------------------------------------
    //worse than above, not use
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null)  return result;
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        // if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        // }
        
        // if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        // }
    }
//==========================================================================    
    
    //worked, 用StringBuilder来实现, recommend
    public List<String> binaryTreePaths22(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
        StringBuilder sb = new StringBuilder();
        binaryTreePaths(list, root, sb);
        return list;
    }
    private void binaryTreePaths(List<String> list, TreeNode root, StringBuilder sb) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sb.append(String.valueOf(root.val));
            list.add(sb.toString());
            // sb.delete(sb.lastIndexOf(""+root.val), sb.length()-1);
            return;
        }

        int len = sb.length();
        sb.append(root.val + "->");
        binaryTreePaths(list, root.left,  sb);
        sb.delete(len, sb.length());
        
        len = sb.length();
        sb.append(root.val + "->");
        binaryTreePaths(list, root.right, sb);
        sb.delete(len, sb.length());
    }

    //----------------------------------------------------------------------
    
    //worked, using stringbuilder, not use
    public List<String> binaryTreePaths44(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null) return result;
        StringBuilder sb = new StringBuilder();
        //第一次调用，主要是初始化list和sum
        sb.append(root.val);
        helper(result, sb, root);
        return result;
    }
    
    //helper的含义：在root为根节点的树中，寻找当前和sum为target的路径，加入list，加入result
    private static void helper(List<String> result,StringBuilder sb, TreeNode root){
        if(root == null) return;
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }

        if(root.left != null){
            int len = sb.length();
            sb.append("->"+root.left.val);
            helper(result, sb, root.left);
            sb.delete(len, sb.length());
        }
        if(root.right != null){
            int len = sb.length();
            sb.append("->"+root.right.val);
            helper(result, sb, root.right);
            sb.delete(len, sb.length());
        }
    }

}
