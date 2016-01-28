package Lintcode;

import sun.util.logging.resources.logging_zh_TW;

//	1) Optimal Substructure:
//		Let LISS(X) indicates size of largest independent set of a tree with root X.
//
//		     LISS(X) = MAX { (1 + sum of LISS for all grandchildren of X),
//		                     (sum of LISS for all children of X) }


public class largest_independent_set_Of_Binary_Tree {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root         = new TreeNode(20);
	    root.left                = new TreeNode(8);
	    root.left.left          = new TreeNode(4);
	    root.left.right         = new TreeNode(12);
	    root.left.right.left   = new TreeNode(10);
	    root.left.right.right  = new TreeNode(14);
	    root.right               = new TreeNode(22);
	    root.right.right        = new TreeNode(25);
	    long start = System.nanoTime();
//	    System.currentTimeMillis();
	    System.out.printf ("Size of the Largest Independent Set is %d \n", getSizeOfLIS(root));
	    long end = System.nanoTime();
	    System.out.println(""+ (end - start));
	    
	    start = System.nanoTime();
	    System.out.printf ("Size of the Largest Independent Set getSizeOfLIS_nonRec is %d \n", getSizeOfLIS_nonRec(root));
	    end = System.nanoTime();
	    System.out.println(""+ (end - start));
	    
	}
	
	// The function returns size of the largest independent set in a given 
	// binary tree
	static int getSizeOfLIS(TreeNode root)
	{
	    if (root == null)
	       return 0;
	 
	    // Caculate size excluding the current node
	    int size_excl = getSizeOfLIS(root.left) + getSizeOfLIS(root.right);
	 
	    // Calculate size including the current node
	    int size_incl = 1;
	    if (root.left != null)
	       size_incl += getSizeOfLIS(root.left.left) + getSizeOfLIS(root.left.right);
	    if (root.right != null)
	       size_incl += getSizeOfLIS(root.right.left) + getSizeOfLIS(root.right.right);
	 
	    // Return the maximum of two sizes
	    return Math.max(size_incl, size_excl);
	}

	
		// A memoization function returns size of the largest independent set in
	//  a given binary tree
	static int getSizeOfLIS_nonRec(TreeNode root)
	{
	    if (root == null)
	        return 0;
	 
	    if (root.liss != 0)
	        return root.liss;
	 
	    if (root.left == null && root.right == null)
	        return (root.liss = 1);
	 
	    // Calculate size excluding the current node
	    int liss_excl = getSizeOfLIS_nonRec(root.left) + getSizeOfLIS_nonRec(root.right);
	 
	    // Calculate size including the current node
	    int liss_incl = 1;
	    if (root.left!=null)
	        liss_incl += getSizeOfLIS_nonRec(root.left.left) + getSizeOfLIS_nonRec(root.left.right);
	    if (root.right!=null)
	        liss_incl += getSizeOfLIS_nonRec(root.right.left) + getSizeOfLIS_nonRec(root.right.right);
	 
	    // Maximum of two sizes is LISS, store it for future uses.
	    root.liss = Math.max(liss_incl, liss_excl);
	 
	    return root.liss;
	}

}
