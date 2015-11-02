package LeetCode.JavaBinarySearchTree;

import java.util.ArrayList;



//SC, O(n) solution
public class LC_000_Binary_Search_Tree_Iterator {
    private ArrayList<TreeNode> results = new ArrayList<TreeNode>();
    private int index = -1;
    //@param root: The root of binary tree.
    public LC_000_Binary_Search_Tree_Iterator(TreeNode root) {
        // write your code here
        helper(root, results);
    }

    //中序遍历，带条件    
    private void helper(TreeNode root, ArrayList<TreeNode> results) {
        if (root == null) {
            return;
        }
        helper(root.left, results);
        results.add(root);
        helper(root.right, results);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        index++;
        return results.size() > 0 && index < results.size();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        return results.get(index);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
