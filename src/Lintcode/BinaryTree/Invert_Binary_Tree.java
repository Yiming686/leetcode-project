package Lintcode.BinaryTree;

import java.util.LinkedList;

/**
Invert Binary Tree Show result 

15:00
 Start
Invert a binary tree.

Have you met this question in a real interview? Yes
Example
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4
Challenge
Do it in recursion is acceptable, can you do it without recursion?

Tags Expand 
Binary Tre

 *
 */
public class Invert_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //worked, jiuzhang solution
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
    //worked, my solution
    public void invertBinaryTree22(TreeNode root) {
         if(root == null) return;
         invertBinaryTree(root.left);
         invertBinaryTree(root.right);
         TreeNode temp = root.right;
         root.right = root.left;
         root.left = temp;
     }
    
    //worked, non-recursive solution    
    public static void invertBinaryTree3(TreeNode root) {
        if (root == null) {
            return ;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);//access第一遍
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();//已经access一遍，可以pop出来使用了
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return;
    }


}
