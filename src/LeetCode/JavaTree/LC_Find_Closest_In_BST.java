package LeetCode.JavaTree;

public class LC_Find_Closest_In_BST {

	public TreeNode findClosedTreeNodeInBST(TreeNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		if (root.val > val) {
			TreeNode left = findClosedTreeNodeInBST(root.left, val);

			return (Math.abs(left.val - val) > Math.abs(root.val - val)) ? root
					: left;
		} else {
			TreeNode right = findClosedTreeNodeInBST(root.right, val);

			return (Math.abs(right.val - val) > Math.abs(root.val - val)) ? root
					: right;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
