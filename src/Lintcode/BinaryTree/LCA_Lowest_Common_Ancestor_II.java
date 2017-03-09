package Lintcode.BinaryTree;

/**
 * Lowest Common Ancestor II Show result
 * 
 * Given the root and two nodes in a Binary Tree. Find the lowest common
 * ancestor(LCA) of the two nodes.
 * 
 * The lowest common ancestor is the node with largest depth which is the
 * ancestor of both nodes.
 * 
 * The node has an extra attribute parent which point to the father of itself.
 * The root's parent is null.
 * 
 * Have you met this question in a real interview? Yes Example For the following
 * binary tree:
 * 
 *   4 
 *  / \ 
 * 3   7 
 *    / \ 
 *   5   6 
 * 
 * LCA(3, 5) = 4
 * 
 * LCA(5, 6) = 7
 * 
 * LCA(6, 7) = 7
 * 
 * Tags Expand LintCode Copyright Binary Tree
 * 
 * 
 * Related Problems Expand Medium Lowest Common Ancestor *
 */
public final class LCA_Lowest_Common_Ancestor_II {

	 class ParentTreeNode {
		 public ParentTreeNode parent, left, right;
	 }
	 
	//worked 
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
// Write your code here   
		if (root == null)
			return null;
// List<ParentTreeNode> listA = new ArrayList<ParentTreeNode>();
// List<ParentTreeNode> listB = new ArrayList<ParentTreeNode>();
		int countA = 0;
		int countB = 0;
		ParentTreeNode currA = A;
		ParentTreeNode currB = B;
		while (currA != null) {
// listA.add(curr);
			countA++;
			currA = currA.parent;
		}
		while (currB != null) {
// listB.add(curr);
			countB++;
			currB = currB.parent;
		}
		currA = A;
		currB = B;
// int diff = listA.size() - listB.size();
		int diff = countA - countB;
		int count = diff > 0 ? diff : -diff;
		while (count > 0) {
			if (diff > 0) {
				currA = currA.parent;
			} else {
				currB = currB.parent;
			}
			count--;
		}

		while (currA != null && currB != null) {
			//以下两行都可以
//			if (currA.val == currB.val) {
			if(currA == currB){

				return currA;
			}
			currA = currA.parent;
			currB = currB.parent;
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
