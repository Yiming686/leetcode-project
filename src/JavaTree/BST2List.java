package JavaTree;

//public class BST2List {
//
//}
//TreeList.java
/*
 Demonstrates the greatest recursive pointer problem ever --
 recursively changing an ordered binary tree into a circular
 doubly linked list.
 See http://cslibrary.stanford.edu/109/

 This code is not especially OOP.

 This code is free for any purpose.
 Feb 22, 2000
 Nick Parlante nick.parlante@cs.stanford.edu
 */

/*
 This is the simple Node class from which the tree and list
 are built. This does not have any methods -- it's just used
 as dumb storage by TreeList.
 The code below tries to be clear where it treats a Node pointer
 as a tree vs. where it is treated as a list.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.val = data;
		left = null;
		right = null;
	}
}
//class Node {
//	int data;
//	Node small;
//	Node large;
//
//	public Node(int data) {
//		this.data = data;
//		small = null;
//		large = null;
//	}
//}

/*
 * TreeList main methods: -join() -- utility to connect two list nodes -append()
 * -- utility to append two lists -treeToList() -- the core recursive function
 * -treeInsert() -- used to build the tree
 */
public class BST2List {
	/*
	 * helper function -- given two list nodes, join them together so the second
	 * immediately follow the first. Sets the .next of the first and the
	 * .previous of the second.
	 */
	public static void join(TreeNode a, TreeNode b) {
		a.right = b;
		b.left = a;
	}

	/*
	 * helper function -- given two circular doubly linked lists, append them
	 * and return the new list.
	 */
	public static TreeNode append(TreeNode a, TreeNode b) {
		// if either is null, return the other
		if (a == null)
			return (b);
		if (b == null)
			return (a);

		// find the last node in each using the .previous pointer
		TreeNode aLast = a.left;
		TreeNode bLast = b.left;

		// join the two together to make it connected and circular
		join(aLast, b);
		join(bLast, a);

		return (a);
	}

	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a
	 * circular doubly linked list which is returned.
	 */
	public static TreeNode treeToList(TreeNode root) {
		// base case: empty tree -> empty list
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode aList = treeToList(root.left);
		TreeNode bList = treeToList(root.right);

		// Make the single root node into a list length-1
		// in preparation for the appending
		root.left = root;
		root.right = root;

		// At this point we have three lists, and it's
		// just a matter of appending them together
		// in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
	}

	/*
	 * Given a non-empty tree, insert a new node in the proper place. The tree
	 * must be non-empty because Java's lack of reference variables makes that
	 * case and this method messier than they should be.
	 */
	public static void treeInsert(TreeNode root, int newData) {
		if (newData <= root.val) {
			if (root.right != null)
				treeInsert(root.right, newData);
			else
				root.right = new TreeNode(newData);
		} else {
			if (root.left != null)
				treeInsert(root.left, newData);
			else
				root.left = new TreeNode(newData);
		}
	}

	public static void BSTreeInsert(TreeNode root, int newData) {
		if (newData <= root.val) {
			if (root.left != null)
				BSTreeInsert(root.left, newData);
			else
				root.left = new TreeNode(newData);
		} else {
			if (root.right != null)
				BSTreeInsert(root.right, newData);
			else
				root.right = new TreeNode(newData);
		}
	}

	// Do an inorder traversal to print a tree
	// Does not print the ending "\n"
	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(Integer.toString(root.val) + " ");
		printTree(root.right);
	}

	// Do a traversal of the list and print it out
	public static void printList(TreeNode head) {
		TreeNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.val) + " ");
			current = current.right;
			if (current == head)
				break;
		}

		System.out.println();
	}

	// Demonstrate tree->list with the list 1..5
	public static void main(String[] args) {

		// first build the tree shown in the problem document
		// http://cslibrary.stanford.edu/109/
		TreeNode root = new TreeNode(4);
		// treeInsert(root, 5);
		// treeInsert(root, 2);
		// treeInsert(root, 1);
		// treeInsert(root, 3);

		BSTreeInsert(root, 5);
		BSTreeInsert(root, 2);
		BSTreeInsert(root, 1);
		BSTreeInsert(root, 3);

		System.out.println("tree:");
		printTree(root); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		TreeNode head = treeToList(root);
		printList(head); // 1 2 3 4 5 yay!
	}
}