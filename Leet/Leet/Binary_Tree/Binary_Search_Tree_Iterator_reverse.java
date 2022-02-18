package Leet.Binary_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import Utils.SU;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Binary_Search_Tree_Iterator_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("863. All Nodes Distance K in Binary Tree\n" + 
				"");
		TreeNode root = TreeNodeUtils.fromStringToTree("{7,3,15,null,null,9,20}");
		Binary_Search_Tree_Iterator_reverse it = new Binary_Search_Tree_Iterator_reverse(root);
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

	public Binary_Search_Tree_Iterator_reverse(TreeNode root) {
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
				root = root.right;
			}
			node = stack.pop();
			root = node.left;
		}
		return node != null ? node.val : null;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return root != null || !stack.isEmpty();
	}

}
