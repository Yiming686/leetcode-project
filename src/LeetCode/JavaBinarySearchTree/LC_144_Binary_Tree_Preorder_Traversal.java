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
//	˼���ǣ���root��ʼ�������нڵ㣬�����ض��Ļ��ƣ�stack���ƣ��ﵽpreorder������Ŀ�ġ�
//	root�����������������Ϣ����������м�¼����������һ��pop��ȥ���㶪ʧ�ˡ�
//	Ϊ��һ��Ҫ�洢��������ô�洢�أ�Ϊ�˴ﵽ�������Ŀ�ģ����Բ��ȱ�����������������ջ�洢��ʱ���棬�ٴ洢������
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
