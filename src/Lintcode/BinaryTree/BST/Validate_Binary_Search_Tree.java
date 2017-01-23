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
			this.isBST = isBST; // 此树是否是BST
			this.minValue = minValue;// 此树所有元素的最小值
			this.maxValue = maxValue;// 此树所有元素的最大值
		}
	}

	// Jiuzhang, worked,
	public boolean isValidBST(TreeNode root) {
		ResultType r = validateHelper(root);
		return r.isBST;
	}

	// 应用divide-conquer策略
	private ResultType validateHelper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		// 求左子树的信息：是否BST以及最大最小值
		ResultType left = validateHelper(root.left);
		// 求右子树的信息：是否BST以及最大最小值
		ResultType right = validateHelper(root.right);
		// 先根据左右子树的信息来判断
		if (!left.isBST || !right.isBST) {
			// if is_bst is false then minValue and maxValue are useless
			return new ResultType(false, 0, 0);
		}
		// 根据当前root和左右子树信息来判断,这才是BST的本质属性的判断
		// 考察点：注意等号不能少
		if (root.left != null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val) {
			return new ResultType(false, 0, 0);
		}
		// 经过以上判断，当前是BST，并求最大最小值
		// 考察点：拓展当前node的最大最小值范围
//		return new ResultType(true, Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue));

		//典型错误：{1,#,2,3} ==> true, Expected false
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
