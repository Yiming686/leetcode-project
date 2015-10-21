package LeetCode.JavaTree;

public class LC_000_Least_Common_Ancester_General_Tree_IV {

//	二叉树遍历：前序，中序，后序，还有前后序，中后序
//	此算法归为前后序
//	递归方法内，先处理当前节点，然后对左右节点调用，最后根据调用结果，构成不同条件，返回最终结果
	public TreeNode findLeastCommonAncester(TreeNode root, TreeNode p,
			TreeNode q) {
//		边界条件，规则：如果root为p或者q，LCU 即为 root.（好像在找p，q在哪里一样）
		if (root == null || p == null || q == null)
			return null;
		if (root == p || root == q)
			return root;
//找到左右子树的LCU
		TreeNode left = findLeastCommonAncester(root.left, p, q);
		TreeNode right = findLeastCommonAncester(root.right, p, q);

		if (left != null && right != null)
			return root;
		return left == null ? right: left;
//		if (left == null)
//			return right;
//		else {
//			return left;
//		}

	}
}
