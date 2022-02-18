package Lai.BinaryTree.LCA;

/**
 * 
 * Description Given two nodes in a binary tree (with parent pointer available),
 * find their lowest common ancestor.
 * 
 * Assumptions
 * 
 * There is parent pointer for the nodes in the binary tree
 * 
 * The given two nodes are not guaranteed to be in the binary tree
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 9 12
 * 
 * / \ \
 * 
 * 2 3 14
 * 
 * The lowest common ancestor of 2 and 14 is 5
 * 
 * The lowest common ancestor of 2 and 9 is 9
 * 
 * The lowest common ancestor of 2 and 8 is null (8 is not in the tree) *
 */
public class Lowest_Common_Ancestor_II {
	
	public static class TreeNodeP {
		public int key;
		public TreeNodeP left;
		public TreeNodeP right;
		public TreeNodeP parent;

		public TreeNodeP(int key, TreeNodeP parent) {
			this.key = key;
			this.parent = parent;
		}
	}

	public static TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		// Write your solution here.
		if (one == null || two == null) {
			return null;
		}
		int lenOne = length(one);
		int lenTwo = length(two);
		return lowestCommonAncestorByDiff(one, two, lenOne - lenTwo);
	}

	private static TreeNodeP lowestCommonAncestorByDiff(TreeNodeP longer, TreeNodeP shorter, int diff) {
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while (diff < 0) {
			shorter = shorter.parent;
			diff++;
		}
		while (longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}

	private static int length(TreeNodeP node) {
		if (node == null) {
			return 0;
		}
		int len = 0;
		while (node != null) {
			len++;
			node = node.parent;
		}
		return len;
	}

}
