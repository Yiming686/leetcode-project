package Leet.Binary_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Binary_Tree_Preorder_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{7,3,15,null,null,9,20}");
		Binary_Tree_Preorder_Iterator it = new Binary_Tree_Preorder_Iterator(root);
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
//	TreeNode root;

	public Binary_Tree_Preorder_Iterator(TreeNode root) {
		this.stack = new ArrayDeque<>();
		// stack.offer(root);
//		this.root = root;
		stack.push(root);
	}

	/** @return the next smallest number */
	public Integer next() {
		// if(!hasNext()){
		// return null;
		// }
		TreeNode<Integer> node = null;
		if (hasNext()) {
			node = stack.pop();
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
			return node.val;
		}else {
			return null;
		}
//		return node != null ? node.val : null;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

}
