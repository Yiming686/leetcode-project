package Leet.Binary_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Binary_Search_Tree_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{7,3,15,null,null,9,20}");
		Binary_Search_Tree_Iterator it = new Binary_Search_Tree_Iterator(root);
		System.out.println("next: " + it.next());
		System.out.println("next: " + it.next());
		System.out.println("hasNext: " + it.hasNext());
		System.out.println("next: " + it.next());
		System.out.println("next: " + it.next());
		System.out.println("hasNext: " + it.hasNext());
		System.out.println("next: " + it.next());
		System.out.println("next: " + it.next());
	}

	Deque<TreeNode> stack;
	TreeNode root;

	public Binary_Search_Tree_Iterator(TreeNode root) {
		this.stack = new ArrayDeque<>();
		// stack.offer(root);
		this.root = root;
	}

	/** @return the next smallest number */
	public Integer next() {
		// if(!hasNext()){
		// return null;
		// }
		TreeNode<Integer> node = null;
		if (hasNext()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			node = stack.pop();
			root = node.right;
		}
		return node != null ? node.val : null;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return root != null || !stack.isEmpty();
	}

}
