package LeetCode.JavaTree;

public class LC_000_Least_Common_Ancester_BT_III {

//	二叉树遍历：前序，中序，后序，还有前后序，中后序
//	此算法归为前后序
//	递归方法内，先处理当前节点，然后对左右节点调用，最后根据调用结果，构成不同条件，返回最终结果
	public TreeNode findLeastCommonAncester(TreeNode root, TreeNode p,
			TreeNode q) {
//		边界条件，规则：如果root为p或者q，LCA即为 root.（好像在找p，q在哪里一样）
//		DFS递归第一步：处理root，根据root的各种可能值，得出返回值
		if (root == null || p == null || q == null)
			return null;
		if (root == p || root == q)
			return root;
//		DFS递归第二步：查找左子节点
//		DFS递归第三步：即使查找后，也不能得出结论，所以紧随其后，要继续查找右子树
//找寻左右子树的LCU
		TreeNode left = findLeastCommonAncester(root.left, p, q);
		TreeNode right = findLeastCommonAncester(root.right, p, q);
//DFS递归第四步：根据上面两步结果，得出最终的返回值
//		对此题目，返回值有可能是在左边，也有可能在右边，更有可能就是中间的节点root
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
