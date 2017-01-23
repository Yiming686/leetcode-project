package Lintcode.BinaryTree.BST;

/**
Inorder Successor in Binary Search Tree

30:00
 Start
Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

Have you met this question in a real interview? Yes
Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

Note
If the given node has no in-order successor in the tree, return null.

Challenge
O(h), where h is the height of the BST.

Tags Expand 
Binary Search Tree Binary Tree


Related Problems Expand 
Medium Validate Binary Search Tree 21 %
Hard Binary Search Tree Iterator

 *
 */
public class Inorder_Successor_in_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null || p == null) return null;
        TreeNode successor = null;
        //��һ������bst������Ѱnode����p����whileѭ��
        while(root != null && root.val != p.val){
            if(root.val > p.val){
                successor = root;//��Ϊ��ǰ����������successor
                root = root.left;
            }else{
                root = root.right;
            }
        }
        //�ڶ�������������a��û�ҵ�
        if(root == null) return null;
        //b: �ҵ��ˣ�������Ϊ�գ�ֱ�ӷ���
        if(root.right == null) {
            return successor;
        }
        //�ҵ��ˣ���������Ϊ�գ������ұ߽ڵ㣬����
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

}
