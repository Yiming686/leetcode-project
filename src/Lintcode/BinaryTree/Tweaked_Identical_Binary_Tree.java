package Lintcode.BinaryTree;

/**

Tweaked Identical Binary Tree Show result 

Check two given binary trees are identical or not. Assuming any number of tweaks are allowed. A tweak is defined as a swap of the children of one node in the tree.

Have you met this question in a real interview? Yes
Example
    1             1
   / \           / \
  2   3   and   3   2
 /                   \
4                     4
are identical.

    1             1
   / \           / \
  2   3   and   3   2
 /             /
4             4
are not identical.

Note
There is no two nodes with the same value in the tree.

Challenge
O(n) time

Tags Expand 
Binary Tree


Related Problems Expand 
Easy Identical Binary Tree

 *
 *
 *
 */
public class Tweaked_Identical_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //My solution, worked 
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null){ return true;}
        if(a == null || b == null){ return false;}
        if(a.val != b.val){
            return false;                
        }
        boolean left = isTweakedIdentical(a.left, b.left);
        boolean right = isTweakedIdentical(a.right, b.right);
        
        if(left == true && right == true) return true;
        
        left = isTweakedIdentical(a.left, b.right);
        right = isTweakedIdentical(a.right, b.left);
        
        if(left == true && right == true) return true;

        return false;
    }
    
  //Jiuzhang solution
    public boolean isTweakedIdentical6(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) {
            return true;
        }
        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)) {
            return true;
        }
        return false;
    }
}
