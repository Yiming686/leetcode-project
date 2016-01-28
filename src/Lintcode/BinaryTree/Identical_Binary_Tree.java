package Lintcode.BinaryTree;

/**

 Identical Binary Tree

Check if two binary trees are identical. Identical means the two binary trees have the same structure and every identical position has the same value.

Have you met this question in a real interview? Yes
Example
    1             1
   / \           / \
  2   2   and   2   2
 /             /
4             4
are identical.

    1             1
   / \           / \
  2   3   and   2   3
 /               \
4                 4
are not identical.

Tags Expand 
Binary Tree


Related Problems Expand 
Easy Tweaked Identical Binary Tree 28 %
Easy Symmetric Binary Tree 36 %
Easy Complete Binary Tree

 *
 *
 */
public class Identical_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //3 lines solution. 
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if(a == null || b == null) return a == b;
        if(a.val != b.val) return false;                
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
    
    public boolean isIdentical6(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null || b == null) return a == b;
        // if(a == null && b == null){ return true;}
        // if(a == null || b == null){ return false;}
        if(a.val != b.val){
            return false;                
        }
        
        // boolean left = isIdentical(a.left, b.left);
        // boolean right = isIdentical(a.right, b.right);
        // if(left == false || right == false){ return false;}
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
    
    //worked
    public boolean isIdentical5(TreeNode a, TreeNode b) {
        // Write your code here
        //1 line below, worked
        // if(a == null || b == null) return a == b;

        if(a == null && b == null){ return true;}
        if(a == null || b == null){ return false;}
        if(a.val != b.val){
            return false;                
        }
        
        boolean left = isIdentical(a.left, b.left);
        boolean right = isIdentical(a.right, b.right);
        
        if(left == false || right == false){ return false;}
        return true;
    }
    
}
