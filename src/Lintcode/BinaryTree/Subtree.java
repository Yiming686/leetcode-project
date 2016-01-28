package Lintcode.BinaryTree;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
Subtree Show result 

You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.

Have you met this question in a real interview? Yes
Example
T2 is a subtree of T1 in the following case:

       1                3
      / \              / 
T1 = 2   3      T2 =  4
        /
       4
T2 isn't a subtree of T1 in the following case:

       1               3
      / \               \
T1 = 2   3       T2 =    4
        /
       4
Note
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

Tags Expand 
Recursion Binary Tree

 *
 */
public class Subtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = null;
		String s2 = null;
		System.out.println(""+ (s1 == s2));
		System.out.println(""+ (s1.equals(s2)));
//		System.out.println(""+);
	}
	
    public boolean isSubtree(TreeNode tree1, TreeNode tree2) {
        // write your code here
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        
        if (isEqual(tree1, tree2)) {
            return true;
        }
        if (isSubtree(tree1.left, tree2) || isSubtree(tree1.right, tree2)) {
            return true;
        }
        return false;
    }
    
    private boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
    }
	
	
}
