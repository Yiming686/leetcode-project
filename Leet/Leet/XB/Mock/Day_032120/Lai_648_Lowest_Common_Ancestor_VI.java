package Leet.XB.Mock.Day_032120;

import java.util.ArrayList;
import java.util.List;

import Utils.SU;

/**
 * 648. Lowest Common Ancestor VI Medium Given M nodes in a K-nary tree, find
 * their lowest common ancestor.
 * 
 * Assumptions
 * 
 * - M >= 2.
 * 
 * - There is no parent pointer for the nodes in the K-nary tree.
 * 
 * - The given M nodes are guaranteed to be in the K-nary tree.
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 9 12
 * 
 * / | \ \
 * 
 * 1 2 3 14
 * 
 * 
 * 
 * The lowest common ancestor of 2, 3, 14 is 5.
 * 
 * The lowest common ancestor of 2, 3, 9 is 9.
 *
 */
public class Lai_648_Lowest_Common_Ancestor_VI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.lai("296. Right View Of Binary Tree\n" + 
				"");

	}

	// find LCA of K nods in Knary Tree
	public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
		// Write your solution here
		if (root == null) {
			return null;
		}
		if (nodes.contains(root)) {
			return root;
		}
		KnaryTreeNode firstOne = null;
		for (KnaryTreeNode child : root.children) {
			KnaryTreeNode node = lowestCommonAncestor(child, nodes);
			if (node != null) {
				if (firstOne != null) {
					return root;
				}
				firstOne = node;
			}
		}
		return firstOne;
	}

	private class KnaryTreeNode {
		int key;
		List<KnaryTreeNode> children;

		public KnaryTreeNode(int key) {
			this.key = key;
			this.children = new ArrayList<>();
		}
	}

}
