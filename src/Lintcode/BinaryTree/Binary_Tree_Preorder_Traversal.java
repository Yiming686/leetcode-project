package Lintcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
	Binary Tree Preorder Traversal

 Description
 Notes
 Testcase
 Judge
Given a binary tree, return the preorder traversal of its nodes' values.

Example
Given:

    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

Challenge 
Can you do it without recursion?

Tags 
Recursion Binary Tree Binary Tree Traversal Non Recursion
Related Problems 
Easy Binary Tree Postorder Traversal 41 %
Easy Binary Tree Inorder Traversal 40 %

*
*
*
 */
public class Binary_Tree_Preorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,3,4,5}";
		TreeNode root = TreeNode.fromStringToTree(TreeNodeStrIn);
//		travereTree(root);
		String TreeNodeStrIn2 ="{5,4,8,11,#,13,4,7,2,#,#,5,1}";
		TreeNode root2 = TreeNode.fromStringToTree(TreeNodeStrIn2);
//		System.out.println(""+ travereTree(root2));
//		travereTree(root2);
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		stack.add(null);
		stack.add(null);
		stack.add(null);
		stack.add(root2);

//		ArrayList<Integer> result = preorderTraversal12( root);
//		System.out.println(""+result);
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
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(list, root);
		return list;    
    }
    private static void helper(ArrayList<Integer> list, TreeNode root){
        if(root == null) return;
// 		System.out.println("前序遍历--> "+root.val);
        list.add(root.val);//模板上添加一行即可
		helper(list, root.left);
// 		System.out.println("中序遍历--> "+root.val);
		helper(list, root.right);
// 		System.out.println("后序遍历--> "+root.val);
    }

//  非递归solution
  public static ArrayList<Integer> preorderTraversal12(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<>();
      if(root == null) return result;
      Stack<TreeNode> stack = new Stack<>();
      //放到stack里面的都得一定会被遍历到，这才是遍历的开始
      // stack不空，说明要遍历的元素还没有遍历完，一个while循环就遍历完了
      // 同时一个节点有左子树和右子树，二者是有处理次序的，不可随便调换次序，先添加右子树
      // 另外，不空才可以添加，stack支持null
      stack.push(root);
      while(!stack.isEmpty()){
          TreeNode node = stack.pop();
          result.add(node.val);
          if(node.right != null) stack.add(node.right);
          if(node.left != null) stack.add(node.left);
      }
      return result;
  }

  //worked, recursive solution    
  //Not best, becasue more than one ArrayLists are created
  public List<Integer> preorderTraversal13(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      if(root==null)  return result;
      List<Integer> left = preorderTraversal(root.left);
      List<Integer> right = preorderTraversal(root.right);
      result.add(root.val);
      result.addAll(left);
      result.addAll(right);
      return result;
  }

    
}
