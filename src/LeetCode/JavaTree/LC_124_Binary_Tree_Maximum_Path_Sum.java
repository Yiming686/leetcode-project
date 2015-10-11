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
	
//	设置 maxSum.add(Integer.MIN_VALUE);是为了给后面maxSum.get(0)做准备
//	也就是给出最大值的一个初始值，其实就是先给一个最小的可能值
//最大值其实就是一个Integer，但是不能直接传递Integer变量，让他在不同递归中传递
//	java机制不允许，Integer在装箱过程中会自动创建新对象
//	所以必须用集合，ArrayList 是最佳选择
//	所以就有了getMaxSum(root, maxSum);方法，有两个参数：当前节点和大家共享的包含到目前为止的最大值的集合
	
//	问题1：为什么传入List<Integer> maxSum 参数，
//	答案1：因为java机制
//	问题2：为什么递归函数返回值，不能直接返回？
//	答案2：因为递归函数计算的是以当前节点为结尾的路径的最大值，并不包含以当前节点为中间值的路径的最大值
//	不能计算，否则递归调用含义就和题目要求不对了
//	但是当前节点为中间值的路径的最大值还必须在递归时候计算出来，万一他就是最大值呢
//	所以递归方法最后都把他计算出来存入链表里面，递归沿途始终都存储的都是截止目前得到的最终需要的最大值
//	但是他不是递归方法的返回值，他只是存储在递归方法共用的链表的第一个元素里面
//	问题3：        getMaxSum(root, maxSum); return maxSum.get(0); 能否改为 return getMaxSum(root, maxSum);
//	答案3：当然不行，原因解释在第二个问题的答案中
//	 maxPathSum(TreeNode root)的含义是找出以root 为根的树的最大路径和 
//	getMaxSum(root, maxSum) 的含义是找出以root为根的树中的并且以root为结尾的最大路径和
//	这样子他才能和getMaxSum(root.left, maxSum),getMaxSum(root.right, maxSum)级联起来
//	递归的意义才得以实现
//	 问题4：右边语句正确，能否换成下面的？	int currMaxSum = Math.max(root.val, Math.max(root.val+leftSum, root.val + rightSum));
//										int currMaxSum = root.val + Math.max(leftSum, rightSum));
//	答案4:不行，二者不等效。如果leftSum, rightSum都小于零的话
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
//		以下做法是错误的:对currMaxSum理解有误
//		int currMaxSum = Math.max(Math.max(root.val, Math.max(root.val+leftSum, root.val + rightSum)), root.val+leftSum+ rightSum );
//		maxSum.set(0, Math.max(maxSum.get(0), currMaxSum));
		
		return currMaxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
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
