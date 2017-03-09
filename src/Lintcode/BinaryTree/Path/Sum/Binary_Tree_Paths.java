package Lintcode.BinaryTree.Path.Sum;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String.v
	}

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
    private static void helper(TreeNode root, String path, List<String> result) {
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
}
