package Lintcode.BinaryTree;

import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.List;

/**
Flatten Binary Tree to Linked List Show result 

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Have you met this question in a real interview? Yes
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Note
Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Challenge
Do it in-place without any extra memory.

Tags Expand 
Binary Tree Depth First Search


Related Problems Expand 
Medium Convert Binary Search Tree to Doubly Linked List 18 %
Medium Convert Sorted List to Balanced BST


 *
 *
 */
public class Flatten_Binary_Tree_to_Linked_List {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{1,2,5,3,4,#,6}");
        System.out.println(""+TreeNode.convertToString(root));
		flatten(root);
		
	}

	
    public static void flatten(TreeNode root) {
        flattenHelper(root);
    }
    
    private static TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        if (root.left == null) {
            return flattenHelper(root.right);
        }
        
        if (root.right == null) {
            root.right = root.left;
            root.left = null; // important!
            return flattenHelper(root.right);
        }
        
        // Divide
        TreeNode leftLastNode = flattenHelper(root.left);
        TreeNode rightLastNode = flattenHelper(root.right);
        
        // Conquer
        leftLastNode.right = root.right;
        root.right = root.left;
        root.left = null; // important!
        return rightLastNode;
    }
    
    
    //Jiuzhang, global variable, worked
    private TreeNode lastNode = null;

    public void flatten4(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;//把老的root.right记录下来
        flatten(root.left);
        flatten(right);//此时root已经更新了, flatten老的root.right
    }
    
    //My solution, non-recursive solution, worked, O(n) extra memory
    public void flatten3(TreeNode root) {
        // write your code here
        if(root == null) return ;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            
            if(prev!=null) {
                prev.left = null;
                prev.right = node;
            }
            prev = node;
        }
        return;
        
    }
 
	
	
	
}
