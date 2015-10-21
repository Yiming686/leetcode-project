package LeetCode.JavaTree;

public class LC_000_Least_Common_Ancester_BT_III {

//	������������ǰ�����򣬺��򣬻���ǰ�����к���
//	���㷨��Ϊǰ����
//	�ݹ鷽���ڣ��ȴ���ǰ�ڵ㣬Ȼ������ҽڵ���ã������ݵ��ý�������ɲ�ͬ�������������ս��
	public TreeNode findLeastCommonAncester(TreeNode root, TreeNode p,
			TreeNode q) {
//		�߽��������������rootΪp����q��LCA��Ϊ root.����������p��q������һ����
//		DFS�ݹ��һ��������root������root�ĸ��ֿ���ֵ���ó�����ֵ
		if (root == null || p == null || q == null)
			return null;
		if (root == p || root == q)
			return root;
//		DFS�ݹ�ڶ������������ӽڵ�
//		DFS�ݹ����������ʹ���Һ�Ҳ���ܵó����ۣ����Խ������Ҫ��������������
//��Ѱ����������LCU
		TreeNode left = findLeastCommonAncester(root.left, p, q);
		TreeNode right = findLeastCommonAncester(root.right, p, q);
//DFS�ݹ���Ĳ���������������������ó����յķ���ֵ
//		�Դ���Ŀ������ֵ�п���������ߣ�Ҳ�п������ұߣ����п��ܾ����м�Ľڵ�root
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
