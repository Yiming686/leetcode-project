package LeetCode.JavaTree;

public class LC_000_Least_Common_Ancester_General_Tree_IV {

//	������������ǰ�����򣬺��򣬻���ǰ�����к���
//	���㷨��Ϊǰ����
//	�ݹ鷽���ڣ��ȴ���ǰ�ڵ㣬Ȼ������ҽڵ���ã������ݵ��ý�������ɲ�ͬ�������������ս��
	public TreeNode findLeastCommonAncester(TreeNode root, TreeNode p,
			TreeNode q) {
//		�߽��������������rootΪp����q��LCU ��Ϊ root.����������p��q������һ����
		if (root == null || p == null || q == null)
			return null;
		if (root == p || root == q)
			return root;
//�ҵ�����������LCU
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
