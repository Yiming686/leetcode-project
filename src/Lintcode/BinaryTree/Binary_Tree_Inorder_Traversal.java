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
    public ArrayList<Integer> inorderTraversal11(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(list, root);
		return list;    
    }
    private void helper(ArrayList<Integer> list, TreeNode root){
        if(root == null) return;
// 		System.out.println("ǰ�����--> "+root.val);
		helper(list, root.left);
        list.add(root.val);//ģ�������һ�м���
// 		System.out.println("�������--> "+root.val);
		helper(list, root.right);
// 		System.out.println("�������--> "+root.val);
    }

    //    �ǵݹ�solution
    //best , worked ������ע����ȫ������ģ��DFS�ݹ����
//    ��ǰnode����,ֻ��һ���ط�pushֻ��һ���ط�pop
//    ��һ�μ���node��node��left��֧��ȫ��push��������Ϣȫ��
//    ��pop����Ϊstack���գ�pop������node�����֧��Ϣ������Ҫ���д����ˣ�ֻ��Ҫ�����ҷ�֧��Ϣ
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack0 = new ArrayDeque<>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;//�����������˽ڵ�
        // while��ž���ѭ��������������ķ�ʽ
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {//�Ȱ�֮ǰ���ֵļ�¼�������������ǰ��ķ���
                stack.push(curr);
                curr = curr.left;
            }else{
                //����cornercase�ˣ�Ҳ���Ǽ�¼���ˣ������м䣬���������
                //ע�����pop()�������ȴ�����updateѭ������ 
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;//�����������˽ڵ㣬�����������ķ���
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
            //access��һ��
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();//access�ڶ��飬���Կ�pop��������ʼʹ��
            result.add(curr.val);
            curr = curr.right;//������ǰ�ߣ������µ�Ԫ��
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
