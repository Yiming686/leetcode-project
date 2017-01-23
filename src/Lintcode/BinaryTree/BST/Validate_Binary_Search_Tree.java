package Lintcode.BinaryTree.BST;

/**
Validate Binary Search Tree Show result 

30:00
 Start
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

Tags Expand 
Divide and Conquer Recursion Binary Search Tree Binary Tree


Related Problems Expand 
Medium Inorder Successor in Binary Search Tree 26 %
Medium Balanced Binary Tree

 *
 */
public class Validate_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ResultType {
		boolean isBST;
		int minValue;
		int maxValue; 

		ResultType(boolean isBST, int minValue, int maxValue) {
			this.isBST = isBST; // �����Ƿ���BST
			this.minValue = minValue;// ��������Ԫ�ص���Сֵ
			this.maxValue = maxValue;// ��������Ԫ�ص����ֵ
		}
	}

	// Jiuzhang, worked,
	public boolean isValidBST(TreeNode root) {
		ResultType r = validateHelper(root);
		return r.isBST;
	}

	// Ӧ��divide-conquer����
	private ResultType validateHelper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		// ������������Ϣ���Ƿ�BST�Լ������Сֵ
		ResultType left = validateHelper(root.left);
		// ������������Ϣ���Ƿ�BST�Լ������Сֵ
		ResultType right = validateHelper(root.right);
		// �ȸ���������������Ϣ���ж�
		if (!left.isBST || !right.isBST) {
			// if is_bst is false then minValue and maxValue are useless
			return new ResultType(false, 0, 0);
		}
		// ���ݵ�ǰroot������������Ϣ���ж�,�����BST�ı������Ե��ж�
		// ����㣺ע��ȺŲ�����
		if (root.left != null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val) {
			return new ResultType(false, 0, 0);
		}
		// ���������жϣ���ǰ��BST�����������Сֵ
		// ����㣺��չ��ǰnode�������Сֵ��Χ
//		return new ResultType(true, Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue));

		//���ʹ���{1,#,2,3} ==> true, Expected false
		return new ResultType(true, left.minValue, right.maxValue);

	}

	// geeks solution, worked but not for [Integer.MIN_VALUE, Integer.MIN_VALUE]
	boolean isValidBST99(TreeNode node) {
		return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	boolean isBSTUtil(TreeNode node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.val < min || node.val > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		boolean left = isBSTUtil(node.left, min, node.val - 1);
		boolean right = isBSTUtil(node.right, node.val + 1, max);
		return (left && right // Allow only distinct values
		); // Allow only distinct values

	}

}
