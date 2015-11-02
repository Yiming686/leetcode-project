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

//	优化解法，Accepted
//	基本思路：以前只是得到root的高度，根本不包含isBalanced信息，所以无法判断
//	现在添加isBalanced信息进去，就可以判断了
//	启用高度标记，通常高度肯定大于0，所以就偏偏选用-1来作为错误标记
//	如果不balanced， 高度标记为-1， 然后check是否为-1
	public boolean isBalancedBT(TreeNode root) {
		return getHeightRoot(root) != -1;
	}

//	策略1：如果为null 返回0；
//	策略2：求左高度，如果为-1，直接返回-1；求右高度， 如果为-1，也直接返回-1
//	策略3：绝对值
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

//	通常解法，Accepted， 一般较慢
	public boolean isBalanced(TreeNode root) {
		// 以下规则对所以node适用，所以涵盖所以cases
		// 作为前序遍历DFS，
		// 规则1：如果为null，返回true
		if (root == null)
			return true;
		// 规则2：如果左边和右边都是balanced，返回true（这个貌似正确，其实错误）
		// 反问自己，左右都平衡了，自己就是平衡的了吗，一反问，问题自然就清晰了
		// 存在的情况是，如果左右都balanced的高度差远远大于1，那么肯定root不是balanced的，这是上面错误的规则没有考虑到的
		// 所以规则2：应该是左右都balanced，并且高度差不能大于1；
		// 这个规则对于root是单个节点也是适用的
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
