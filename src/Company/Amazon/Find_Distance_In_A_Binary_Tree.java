package Company.Amazon;

import Lintcode.BinaryTree.TreeNode;

/**
 * @author yiming
 *
 */
public class Find_Distance_In_A_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
//	    
		System.out.println(""+TreeNode.convertToString(root));

	    System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
	    System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
//	    System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
//	    System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
//	    System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));

	}

	// The main function that returns distance between n1 and n2
	// This function returns -1 if either n1 or n2 is not present in
	// Binary Tree.
	private static int findDistance(TreeNode root, int n1, int n2) {
	    // Initialize d1 (distance of n1 from root), d2 (distance of n2 
	    // from root) and dist(distance between n1 and n2)
	    int[] d1 = {-1}, d2 = {-1}, dist = {0}, lvl = {1};
	    TreeNode lca = findDistUtil(root, n1, n2, d1, d2, dist, 1);
	 System.out.println("lca: "+lca.val);
	    // If both n1 and n2 were present in Binary Tree, return dist
	    if (d1[0] != -1 && d2[0] != -1)
	        return dist[0];
	 
	    // If n1 is ancestor of n2, consider n1 as root and find level 
	    // of n2 in subtree rooted with n1
	    int[] l = {0};
	    if (d1[0] != -1)
	    {
	        dist[0] = findLevel(lca, n2, l);
	        return dist[0];
	    }
	 
	    // If n2 is ancestor of n1, consider n2 as root and find level 
	    // of n1 in subtree rooted with n2
	    if (d2[0] != -1)
	    {
	        dist[0] = findLevel(lca, n1, l);
	        return dist[0];
	    }
	    return -1;
	}


	private static TreeNode findDistUtil(TreeNode root, int n1, int n2, int[] d1, int[] d2, int[] dist, int lvl) {
	    // Base case
	    if (root == null) return null;
	 
	    // If either n1 or n2 matches with root's key, report
	    // the presence by returning root (Note that if a key is
	    // ancestor of other, then the ancestor key becomes LCA
	    if (root.val == n1)
	    {
	         d1[0] = lvl;
	         return root;
	    }
	    if (root.val == n2)
	    {
	         d2[0] = lvl;
	         return root;
	    }
	 
	    // Look for n1 and n2 in left and right subtrees
	    lvl++;
	    TreeNode left_lca  = findDistUtil(root.left, n1, n2, d1, d2, dist, lvl);
	    TreeNode right_lca = findDistUtil(root.right, n1, n2, d1, d2, dist, lvl);
	 
	    // If both of the above calls return Non-NULL, then one key
	    // is present in once subtree and other is present in other,
	    // So this node is the LCA
	    if (left_lca != null && right_lca != null)
	    {
	        dist[0] = d1[0] + d2[0] - 2*lvl;
	        return root;
	    }
	 
	    // Otherwise check if left subtree or right subtree is LCA
	    return (left_lca != null)? left_lca: right_lca;		
	}

	// Returns level of key k if it is present in tree, otherwise returns -1
	private static int findLevel(TreeNode root, int k, int[] level) {
	    // Base Case
	    if (root == null)
	        return -1;
	 
	    // If key is present at root, or in left subtree or right subtree,
	    // return true;
	    if (root.val == k)
	        return level[0];
	 
	    level[0]++;
	    int l = findLevel(root.left, k, level);
	    return (l != -1)? l : findLevel(root.right, k, level);
	}
	
}
