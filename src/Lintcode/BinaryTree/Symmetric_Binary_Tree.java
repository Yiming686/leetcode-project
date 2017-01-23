package Lintcode.BinaryTree;

import java.util.LinkedList;

/**
Symmetric Binary Tree

15:00
 Start
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Have you met this question in a real interview? Yes
Example
    1
   / \
  2   2
 / \ / \
3  4 4  3
is a symmetric binary tree.

    1
   / \
  2   2
   \   \
   3    3
is not a symmetric binary tree.

Challenge
Can you solve it both recursively and iteratively?

Tags Expand 
Binary Tree


Related Problems Expand 
Easy Identical Binary Tree 44 %
Easy Complete Binary Tree

 *
 */
public class Symmetric_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //worked, recursively
    public boolean isSymmetric(TreeNode root) {
        if(root == null)  return true;
        return isSymmetric(root.left, root.right ); 
    }
    //worked, recursively
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // if(left == null && right == null){ return true;}
        // if(left == null || right == null){ return false;}
        if(left == null || right == null){ return left == right;}
        if(left.val != right.val){
            return false;                
        }
        boolean left1 = isSymmetric(left.left, right.right);
        boolean right1 = isSymmetric(left.right, right.left);
        return left1 && right1;
    }
    //worked, iteratively
    public boolean isSymmetric99(TreeNode root) {
        if(root == null)  return true;
        
        LinkedList<TreeNode> stackLeft = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stackRight = new LinkedList<TreeNode>();
        stackLeft.push(root);
        stackRight.push(root);
        
        while(!stackLeft.isEmpty() && !stackRight.isEmpty()){
            //pop nodes
            TreeNode currLeft  = stackLeft.pop();
            TreeNode currRight = stackRight.pop();
            //handle nodes that just poped
            if(currLeft == null && currRight != null) return false;
            if(currLeft != null && currRight == null) return false; 
            if(currLeft.val!= currRight.val){
                return false;
            }
            //handle the children of those nodes just poped
            if(currLeft.left != null && currRight.right != null){
                stackLeft.push(currLeft.left);
                stackRight.push(currRight.right);
            }
            if(currLeft.left != null && currRight.right == null){ return false;}
            if(currLeft.left == null && currRight.right != null){ return false;}

            if(currLeft.right != null && currRight.left != null){
                stackLeft.push(currLeft.right);
                stackRight.push(currRight.left);
            }
            if(currLeft.right != null && currRight.left == null){ return false;}
            if(currLeft.right == null && currRight.left != null){ return false;}
        }        
        // if(stackLeft.isEmpty() && stackRight.isEmpty()){
            return true;
        // }else{
            // return false;
        // }
       
    }

}
