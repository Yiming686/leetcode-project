package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode2<Integer> { int val;
 * TreeNode2<Integer> left; TreeNode2<Integer> right; TreeNode2<Integer>(int x)
 * { val = x; } }
 */
public class LC_112_Path_Sum_II {
	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each
	 * path's sum equals the given sum.
	 * 
	 * For example: Given the below binary tree and sum = 22,
	 */

	// 递归方法一般考虑折半，分拆的思路，把root变为root.left, root.right处理
	// 这个递归不仅拆分root，还有考虑sum的拆解,sum是变化的
	// TREE，DFS
	public List<List<Integer>> pathSum(TreeNode2<Integer> root, int sum) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		System.out.println(list);
		pathSum(result, list, root, sum);
		return result;
	}

//	方法含义：对顶点root，找路径和为sum的后续List
//	result为最终输出，list为先前list，二者为状态
	private void pathSum(List<List<Integer>> result, LinkedList<Integer> list,
			TreeNode2<Integer> root, int sum) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		list.add(root.val);
		System.out.println(list);

		if (root.left == null && root.right == null && root.val == sum) {
			// 这里面对两个list的处理次序，非常重要，不可颠倒
			// 不可将intList直接加入ll，最好每次新建list然后加入，就好像截取不断变化中的list当时的状态一样，也就是满足条件那一刻
			// 以下是错误代码
			// ll.add(intList);
			// LinkedList<Integer> intList2 = new LinkedList<Integer>();
			// intList2.addAll(intList);
			// intList = intList2;
			// System.out.println(intList);

			// 以下是正确代码
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			result.add(newList);
			return;
		}
		pathSum(result, list, root.left, sum - root.val);
		if (root.left != null) {
			list.removeLast();
			System.out.println(list);
		}
		pathSum(result, list, root.right, sum - root.val);
		if (root.right != null) {
			list.removeLast();
			System.out.println(list);
		}

		return;
	}

	// Accepted, 350ms, pass at first time
	public boolean hasPathSum(TreeNode2<Integer> root, int sum) {
		// 边界条件：1，节点为null是怎么办，2.节点为叶子是怎么办
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum)
			return true;

		// 代码优化，以下代码冗长，更换为更简洁的
		// boolean left = hasPathSum(root.left, sum - root.val);
		// if(left == true) return true;
		// boolean right = hasPathSum(root.right, sum - root.val);
		// if(right == true) return true;
		// return false;

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
