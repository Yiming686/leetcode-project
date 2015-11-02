package LeetCode.JavaBinarySearchTree;

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Hide Tags Tree Depth-first Search

 * 
 */
public class LC_099_Recover_Binary_Search_Tree {

    public void recoverTree(TreeNode root) {

    	TreeNode n1 = null;
    	TreeNode n2 = null;
    	TreeNode n3 = null;
    	recoverBST(root, n1, n2, n3);
//    	recoverBST(right, n1, n2, n3);
    }
    
    
	private TreeNode recoverBST(TreeNode root, TreeNode n1, TreeNode n2,
			TreeNode n3) {
    	if(root == null) return null;

    	TreeNode left = recoverBST(root.left, n1, n2, n3);
    	if(left!= null && left.val > root.val){
    		if(n2 == null){
    			n1 = left;
    			n2 = root;
    		}else{
    			n3=root;
    		}
    	} 
    	TreeNode right = recoverBST(root.right, n1, n2, n3);
    	if(right!= null &&  root.val > right.val){
    		if(n2 == null){
        		n1 = root;
        		n2 = right;
    		}else{
    			n3=right;
    		}
    	}
    	return null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
