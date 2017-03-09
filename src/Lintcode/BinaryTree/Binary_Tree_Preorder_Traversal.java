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
	
//	���ı���ģ��
	private static void travereTree(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		System.out.println("ǰ�����--> "+root.val);
		travereTree(root.left);
		System.out.println("�������--> "+root.val);
		travereTree(root.right);
		System.out.println("�������--> "+root.val);
	}
	
//	�ݹ�solution
//	����ָ��һ���������ã�����һ��list�����ã��ڵݹ��������ͬʱ��ʼ��ָ�����list��
//	����Ҫ��ֵ���ʵ���ʱ����ӵ�list���棬��󷵻�list
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(list, root);
		return list;    
    }
    private static void helper(ArrayList<Integer> list, TreeNode root){
        if(root == null) return;
// 		System.out.println("ǰ�����--> "+root.val);
        list.add(root.val);//ģ�������һ�м���
		helper(list, root.left);
// 		System.out.println("�������--> "+root.val);
		helper(list, root.right);
// 		System.out.println("�������--> "+root.val);
    }

//  �ǵݹ�solution
  public static ArrayList<Integer> preorderTraversal12(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<>();
      if(root == null) return result;
      Stack<TreeNode> stack = new Stack<>();
      //�ŵ�stack����Ķ���һ���ᱻ������������Ǳ����Ŀ�ʼ
      // stack���գ�˵��Ҫ������Ԫ�ػ�û�б����꣬һ��whileѭ���ͱ�������
      // ͬʱһ���ڵ��������������������������д������ģ��������������������������
      // ���⣬���ղſ�����ӣ�stack֧��null
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
