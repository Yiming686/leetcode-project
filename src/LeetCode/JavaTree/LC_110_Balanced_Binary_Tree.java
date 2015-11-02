package LeetCode.JavaTree;

public class LC_110_Balanced_Binary_Tree {

	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 * 
	 * Hide Tags Tree Depth-first Search
	 */

//	�Ż��ⷨ��Accepted
//	����˼·����ǰֻ�ǵõ�root�ĸ߶ȣ�����������isBalanced��Ϣ�������޷��ж�
//	�������isBalanced��Ϣ��ȥ���Ϳ����ж���
//	���ø߶ȱ�ǣ�ͨ���߶ȿ϶�����0�����Ծ�ƫƫѡ��-1����Ϊ������
//	�����balanced�� �߶ȱ��Ϊ-1�� Ȼ��check�Ƿ�Ϊ-1
	public boolean isBalancedBT(TreeNode root) {
		return getHeightRoot(root) != -1;
	}

//	����1�����Ϊnull ����0��
//	����2������߶ȣ����Ϊ-1��ֱ�ӷ���-1�����Ҹ߶ȣ� ���Ϊ-1��Ҳֱ�ӷ���-1
//	����3������ֵ
	private int getHeightRoot(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = getHeightRoot(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = getHeightRoot(root.right);
		if (rightHeight == -1)
			return -1;
		 int diff = Math.abs(leftHeight - rightHeight);

		 if(diff > 1) return -1;
		int height = leftHeight > rightHeight ? leftHeight : rightHeight;
		return ++height;
	}

//	ͨ���ⷨ��Accepted�� һ�����
	public boolean isBalanced(TreeNode root) {
		// ���¹��������node���ã����Ժ�������cases
		// ��Ϊǰ�����DFS��
		// ����1�����Ϊnull������true
		if (root == null)
			return true;
		// ����2�������ߺ��ұ߶���balanced������true�����ò����ȷ����ʵ����
		// �����Լ������Ҷ�ƽ���ˣ��Լ�����ƽ�������һ���ʣ�������Ȼ��������
		// ���ڵ�����ǣ�������Ҷ�balanced�ĸ߶Ȳ�ԶԶ����1����ô�϶�root����balanced�ģ������������Ĺ���û�п��ǵ���
		// ���Թ���2��Ӧ�������Ҷ�balanced�����Ҹ߶Ȳ�ܴ���1��
		// ����������root�ǵ����ڵ�Ҳ�����õ�
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);

		if (isLeftBalanced && isRightBalanced) {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			 int diff = Math.abs(leftHeight - rightHeight);
//			int diff = (leftHeight - rightHeight);
//			diff = diff > 0 ? diff : (-1) * diff;
			return diff > 1 ? false : true;
		}
		return false;
	}

	private int getHeight(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
//		int height = leftHeight > rightHeight ? leftHeight : rightHeight;
//		return ++height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right) ? true:false;
    }
    public int height(TreeNode node){
            if(node==null) return 0;
            return 1 + Math.max(height(node.left), height(node.right));
    } 

}
