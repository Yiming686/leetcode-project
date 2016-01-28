package Lintcode.BinaryTree;

//public class Morris_Inorder_Traversal_Binary_Tree {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
//Java program to print inorder traversal without recursion and stack

//A binary tree node
class Node {

	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class Morris_Inorder_Traversal_Binary_Tree {

	static Node root;

	/*
	 * Function to traverse binary tree without recursion and without stack
	 */
	void MorrisTraversal(Node node) {
		if (node == null) {
			return;
		}
		Node pre = null;
		Node current = node;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {

				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
					/*
					 * Revert the changes made in if part to restore the
					 * original tree i.e., fix the right child of predecssor
					 */
				} else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */

		} /* End of while */

	}

	public static void main(String args[]) {
		int sum = 14;
		Morris_Inorder_Traversal_Binary_Tree tree = new Morris_Inorder_Traversal_Binary_Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.MorrisTraversal(root);
	}
}

//This code has been contributed by Mayank Jaiswal