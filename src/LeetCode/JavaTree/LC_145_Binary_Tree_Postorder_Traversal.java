package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?

 Hide Tags Tree Stack

 */

public class LC_145_Binary_Tree_Postorder_Traversal {
	
//	Accepted
    public List<Integer> postorderTraversal_rec(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
        postorderTraversal(root, ret);
		return ret;
    }
    public void postorderTraversal(TreeNode root, ArrayList<Integer> ret){
		if (root == null)
			return ;

        postorderTraversal(root.left, ret);
        postorderTraversal(root.right, ret);
        ret.add(root.val);
		return;
    }
//	worked
//	注意：node != null || !stack.isEmpty() 里面的if else if else 关系
//	注意：else{   break;  }  
    public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root == null)
			return ret;

		// Stack stack = new Stack();
		TreeNode node = root;
		TreeNode lastNode = null;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			}else{
    			if (!stack.isEmpty()) {
    				node = (TreeNode) stack.peek();
    				node = node.right;
    
    				if (node == null || node == lastNode) {
    					node = (TreeNode) stack.pop();
    					ret.add(node.val);
    					// System.out.format(" %d", node.val); //visit
    
    					lastNode = node;
    
    					if (!stack.isEmpty()) {
    						node = (TreeNode) stack.peek();
    						node = node.right;
    						if (node == lastNode) {
    							// set as null to let it execute the second branch
    							// in while
    							node = null;
    						}
    					}else{  
                            break;  
                        }  
    				}
    			}
			}
		}
		return ret;
    }
//    Not Work
	public List<Integer> postorderTraversal2(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else if (!stack.isEmpty()) {
				p = stack.peek();
				if (p.right == null) {
					p = stack.pop();
					ret.add(p.val);
					p = null;
				} else {
					p = p.right;
				}
			} else {

			}
		}
		return ret;
	}
}
