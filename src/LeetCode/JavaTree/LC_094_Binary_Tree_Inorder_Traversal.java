package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 Hide Tags Tree Hash Table Stack

 * 
 */

//以下三种执行思路一模一样，不过代码组织形式不一样
//第一种最优，第二其次，第三再次
//实际操作确实是从第三到第二再到第一
//第三种是实际运行轨迹
//第二种进行方法抽象，看着简洁
//第三种对象归纳总结：root节点和弹出节点的右节点处理一直，所以p先是root，后来右节点

//先把本节点和左子节点存储，本节点不弹出，所以不用担心右节点问题
//如果左子节点为null，退回弹出本节点，然后转向右节点

public class LC_094_Binary_Tree_Inorder_Traversal {

	//Accepted	
    public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
        inorderTraversal(root, ret);
		return ret;
    }
    public void inorderTraversal(TreeNode root, ArrayList<Integer> ret){
		if (root == null)
			return;

        inorderTraversal(root.left, ret);
        ret.add(root.val);
        inorderTraversal(root.right, ret);
		return;
    }
    
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	    public static TreeNode makeTree(int[] arr, int i) {
	        if (i >= arr.length) {
	            return null;
	        } else {
	            TreeNode e = new TreeNode(arr[i]);
	            e.left = makeTree(arr, i * 2 + 1);
	            e.right = makeTree(arr, i * 2 + 2);
	            return e;
	        }
	    }
	}
	
//	Acceped, 很棒的
	public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                ret.add(p.val);
                p = p.right;
            }
        }
        return ret;
    }
	public List<Integer> inorderTraversal3(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		pushLeft(stack,root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
				pushLeft(stack,node.right);
			}
		}
		return list;
	}
	void pushLeft(LinkedList<TreeNode> stack, TreeNode node){
		if(node==null) return;
		while(node.left!=null){
			stack.push(node.left);
			node = node.left;
		}
	}

	public List<Integer> inorderTraversal4(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (root.left != null) {
			stack.push(root.left);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
				while (node.right.left != null) {
					stack.push(node.right.left);
				}
			}
		}
		return list;
	}

    public static void main(String[] args) {
        int[] t = new int [] {1, 2, 5, 3, 4, 0, 6};
        TreeNode root = TreeNode.makeTree(t, 0); 
        LC_094_Binary_Tree_Inorder_Traversal s = new LC_094_Binary_Tree_Inorder_Traversal();
        System.out.println(s.inorderTraversal3(root));
    }
    
    public class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: Inorder in ArrayList which contains node values.
         */
        public ArrayList<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            TreeNode curt = root;
            while (curt != null || !stack.empty()) {
                while (curt != null) {
                    stack.add(curt);
                    curt = curt.left;
                }
                curt = stack.peek();
                stack.pop();
                result.add(curt.val);
                curt = curt.right;
            }
            return result;
        }
    }
}
