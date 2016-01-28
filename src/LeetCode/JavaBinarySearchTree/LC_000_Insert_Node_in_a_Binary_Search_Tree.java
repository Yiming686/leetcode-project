package LeetCode.JavaBinarySearchTree;

public class LC_000_Insert_Node_in_a_Binary_Search_Tree {

	// recursive solution
	// BST树root，插入node
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		// write your code here
		if (root == null)
			return node;
		if (root.val > node.val) {
			root.left = insertNode(root.left, node);
		} else {
			root.right = insertNode(root.right, node);
		}
		return root;
	}

	// non-recursive solution
	public TreeNode insertNode1(TreeNode root, TreeNode node) {
		// write your code here
		if (root == null)
			return node;
		TreeNode prev = null;
		TreeNode curr = root;
		// 左右循环寻找位置，curr指向插入位置
		while (curr != null) {
			// 必须放在此循环体的第一行，不能放在最后一行
			prev = curr;
			if (curr.val > node.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		// 此时curr为null，说明找到位置，然后根据prev和node对比，添加node
		if (prev.val > node.val) {
			prev.left = node;
		} else {
			prev.right = node;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
