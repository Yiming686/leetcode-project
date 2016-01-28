package LeetCode.JavaBinarySearchTree;

public class LC_000_Insert_Node_in_a_Binary_Search_Tree {

	// recursive solution
	// BST��root������node
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
		// ����ѭ��Ѱ��λ�ã�currָ�����λ��
		while (curr != null) {
			// ������ڴ�ѭ����ĵ�һ�У����ܷ������һ��
			prev = curr;
			if (curr.val > node.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		// ��ʱcurrΪnull��˵���ҵ�λ�ã�Ȼ�����prev��node�Աȣ����node
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
