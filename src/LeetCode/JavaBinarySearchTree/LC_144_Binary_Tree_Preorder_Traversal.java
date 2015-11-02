package LeetCode.JavaBinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

Hide Tags Tree Stack

 */
public class LC_144_Binary_Tree_Preorder_Traversal {
	
//	Accepted
    public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
        preorderTraversal(root, ret);
		return ret;
    }
    public void preorderTraversal(TreeNode root, ArrayList<Integer> ret){
		if (root == null)
			return ;

        ret.add(root.val);
        preorderTraversal(root.left, ret);
        preorderTraversal(root.right, ret);
		return;
    }
//	思想是：从root开始遍历所有节点，根据特定的机制，stack机制，达到preorder遍历的目的。
//	root里面包含左右子树信息，如果不进行记录，遍历过后，一旦pop出去，便丢失了。
//	为此一定要存储起来，怎么存储呢，为了达到先序遍历目的，所以不先遍历的右子树，先入栈存储长时保存，再存储左子树
//	
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root== null) return list;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
        	list.add(node.val);
        	if(node.right!=null) stack.push(node.right);
        	if(node.left!=null) stack.push(node.left);
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
