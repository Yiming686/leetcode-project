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
        //第一步：用bst属性搜寻node，找p，用while循环
        while(root != null && root.val != p.val){
            if(root.val > p.val){
                successor = root;//因为当前是左子树的successor
                root = root.left;
            }else{
                root = root.right;
            }
        }
        //第二步，处理结果，a：没找到
        if(root == null) return null;
        //b: 找到了，右子树为空，直接返回
        if(root.right == null) {
            return successor;
        }
        //找到了，右子树不为空，找最右边节点，返回
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

}
