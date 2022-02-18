package Lintcode.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 Binary Tree Inorder Traversal

 Description
 Notes
 Testcase
 Judge
Given a binary tree, return the inorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [1,3,2].

Challenge 
Can you do it without recursion?

Tags 
Recursion Binary Tree Binary Tree Traversal
Related Problems 
Easy Binary Tree Preorder Traversal 41 %

 *
 */
public class Binary_Tree_Inorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	树的遍历模板
	private static void travereTree(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		System.out.println("前序遍历--> "+root.val);
		travereTree(root.left);
		System.out.println("中序遍历--> "+root.val);
		travereTree(root.right);
		System.out.println("后序遍历--> "+root.val);
	}
	
//	递归solution
//	给定指向一个树的引用，建立一个list的引用，在递归遍历树的同时，始终指向这个list，
//	把需要的值在适当的时候添加到list里面，最后返回list
    public ArrayList<Integer> inorderTraversal11(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(list, root);
		return list;    
    }
    private void helper(ArrayList<Integer> list, TreeNode root){
        if(root == null) return;
// 		System.out.println("前序遍历--> "+root.val);
		helper(list, root.left);
        list.add(root.val);//模板上添加一行即可
// 		System.out.println("中序遍历--> "+root.val);
		helper(list, root.right);
// 		System.out.println("后序遍历--> "+root.val);
    }

    //    非递归solution
    //best , worked ，看看注释完全就是在模拟DFS递归遍历
//    当前node概念,只在一个地方push只在一个地方pop
//    第一次见面node和node的left分支，全部push，所有信息全在
//    能pop，因为stack不空，pop出来的node的左分支信息，不需要进行处理了，只需要处理右分支信息
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack0 = new ArrayDeque<>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;//中序遍历处理此节点
        // while序号就是循环处理中序遍历的方式
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {//先把之前部分的记录下来，就如调动前面的方法
                stack.push(curr);
                curr = curr.left;
            }else{
                //到了cornercase了，也就是记录完了，到了中间，可以输出了
                //注意次序，pop()出来后，先处理，再update循环变量 
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;//中序遍历处理此节点，就如调动后面的方法
            }
        }
        return result;
    }

    //worked
    public ArrayList<Integer> inorderTraversal15(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            //access第一遍
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();//access第二遍，所以可pop出来，开始使用
            result.add(curr.val);
            curr = curr.right;//继续向前走，走向新的元素
        }
        return result;
    }

    //worked, recursive solution    
    //Not best, becasue more than one ArrayLists are created
    public List<Integer> inorderTraversal16(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)  return result;
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }

}
