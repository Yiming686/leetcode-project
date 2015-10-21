package LeetCode.JavaTree;

public class LC_000_Least_Common_Ancester_BST_I {

//	answer
	public TreeNode findLeastCommonAncester(TreeNode root, TreeNode p,
			TreeNode q) {

		if (root == null || p == null || q == null)
			return null;
//		if (root == p || root == q)
//			return root;
		if (root.val > q.val && root.val > p.val) {
			return findLeastCommonAncester(root.left, p, q);
		} else if (root.val < q.val && root.val < p.val) {
			return findLeastCommonAncester(root.right, p, q);
		} else {
			 return root;
		}
	}
	
	public TreeNode findLeastCommonAncester2(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null)
			return null;
		TreeNode lcu = null;
		if (root.val > p.val && root.val > q.val) {
			 lcu = findLeastCommonAncester(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			 lcu = findLeastCommonAncester(root.right, p, q);
		} else {
			 lcu = root;
		}
		return lcu;
	}
}
