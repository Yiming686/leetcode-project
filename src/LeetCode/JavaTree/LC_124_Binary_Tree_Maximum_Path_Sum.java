package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

Hide Tags Tree Depth-first Search

 * 
 */
public class LC_124_Binary_Tree_Maximum_Path_Sum {
	
//	���� maxSum.add(Integer.MIN_VALUE);��Ϊ�˸�����maxSum.get(0)��׼��
//	Ҳ���Ǹ������ֵ��һ����ʼֵ����ʵ�����ȸ�һ����С�Ŀ���ֵ
//���ֵ��ʵ����һ��Integer�����ǲ���ֱ�Ӵ���Integer�����������ڲ�ͬ�ݹ��д���
//	java���Ʋ�����Integer��װ������л��Զ������¶���
//	���Ա����ü��ϣ�ArrayList �����ѡ��
//	���Ծ�����getMaxSum(root, maxSum);��������������������ǰ�ڵ�ʹ�ҹ���İ�����ĿǰΪֹ�����ֵ�ļ���
	
//	����1��Ϊʲô����List<Integer> maxSum ������
//	��1����Ϊjava����
//	����2��Ϊʲô�ݹ麯������ֵ������ֱ�ӷ��أ�
//	��2����Ϊ�ݹ麯����������Ե�ǰ�ڵ�Ϊ��β��·�������ֵ�����������Ե�ǰ�ڵ�Ϊ�м�ֵ��·�������ֵ
//	���ܼ��㣬����ݹ���ú���ͺ���ĿҪ�󲻶���
//	���ǵ�ǰ�ڵ�Ϊ�м�ֵ��·�������ֵ�������ڵݹ�ʱ������������һ���������ֵ��
//	���Եݹ鷽����󶼰���������������������棬�ݹ���;ʼ�ն��洢�Ķ��ǽ�ֹĿǰ�õ���������Ҫ�����ֵ
//	���������ǵݹ鷽���ķ���ֵ����ֻ�Ǵ洢�ڵݹ鷽�����õ�����ĵ�һ��Ԫ������
//	����3��        getMaxSum(root, maxSum); return maxSum.get(0); �ܷ��Ϊ return getMaxSum(root, maxSum);
//	��3����Ȼ���У�ԭ������ڵڶ�������Ĵ���
//	 maxPathSum(TreeNode root)�ĺ������ҳ���root Ϊ�����������·���� 
//	getMaxSum(root, maxSum) �ĺ������ҳ���rootΪ�������еĲ�����rootΪ��β�����·����
//	�����������ܺ�getMaxSum(root.left, maxSum),getMaxSum(root.right, maxSum)��������
//	�ݹ������ŵ���ʵ��
//	 ����4���ұ������ȷ���ܷ񻻳�����ģ�	int currMaxSum = Math.max(root.val, Math.max(root.val+leftSum, root.val + rightSum));
//										int currMaxSum = root.val + Math.max(leftSum, rightSum));
//	��4:���У����߲���Ч�����leftSum, rightSum��С����Ļ�
    public int maxPathSum(TreeNode root) {
        List<Integer> maxSum = new ArrayList<Integer>();
        maxSum.add(Integer.MIN_VALUE);
        getMaxSum(root, maxSum);
        return maxSum.get(0);
    }

	private int getMaxSum(TreeNode root, List<Integer> maxSum) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int leftSum = getMaxSum(root.left, maxSum);
		int rightSum = getMaxSum(root.right, maxSum);
		
		int currMaxSum = Math.max(root.val, Math.max(root.val+leftSum, root.val + rightSum));
		maxSum.set(0, Math.max(maxSum.get(0), Math.max(currMaxSum, root.val+leftSum+ rightSum )));
//		���������Ǵ����:��currMaxSum�������
//		int currMaxSum = Math.max(Math.max(root.val, Math.max(root.val+leftSum, root.val + rightSum)), root.val+leftSum+ rightSum );
//		maxSum.set(0, Math.max(maxSum.get(0), currMaxSum));
		
		return currMaxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * �������ɾ����㷨�༭�ṩ��û�а�Ȩ��ӭת����
 * - �����㷨�����ڰ��������й����ҵ��õĹ�������ʦ�ŶӾ����Թ�Ⱥ͹��ڵ�һ�ߴ�˾��ְ����ʦ��
 * - ���е�������ѵ�γ̰����������㷨�࣬ϵͳ��ư࣬BAT���ڰ�
 * - ������������ٷ���վ��http://www.jiuzhang.com/
 */

 class Solution {
    private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}
