package LeetCode.JavaBinarySearchTree;

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
    
    
    //����solution
    public ArrayList<Integer> postorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //��ָ������ܣ�ÿ��curr��һ�£�prevָ����ǰ��curr
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;


        stack.push(root);
        //һ��whileѭ���������ж�stack�Ƿ�Ϊ��
        //while�����һ��peek����������if-else��Ӧ��ÿ��ֻ����ִ�����е�һ�Σ���һ�νϸ���
        //ʲôʱ��pop�أ�ֻ�����
        while (!stack.empty()) {
            curr = stack.peek();
            //����������curr��pre��������Թ�ϵ��������ϣ�prevָ��curr
            //down��ʱ�������Ϊ��push����������������߿��ˣ����ұ�
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
                //else do nothing::curr.left == null; curr.right == null; next iteration: prev == curr
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right or prev == curr
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
//	worked
//	ע�⣺node != null || !stack.isEmpty() �����if else if else ��ϵ
//	ע�⣺else{   break;  }  
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
