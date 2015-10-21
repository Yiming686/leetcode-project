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

	// �ݹ鷽��һ�㿼���۰룬�ֲ��˼·����root��Ϊroot.left, root.right����
	// ����ݹ鲻�����root�����п���sum�Ĳ��,sum�Ǳ仯��
	// TREE��DFS
	public List<List<Integer>> pathSum(TreeNode2<Integer> root, int sum) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		System.out.println(list);
		pathSum(result, list, root, sum);
		return result;
	}

//	�������壺�Զ���root����·����Ϊsum�ĺ���List
//	resultΪ���������listΪ��ǰlist������Ϊ״̬
	private void pathSum(List<List<Integer>> result, LinkedList<Integer> list,
			TreeNode2<Integer> root, int sum) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		list.add(root.val);
		System.out.println(list);

		if (root.left == null && root.right == null && root.val == sum) {
			// �����������list�Ĵ�����򣬷ǳ���Ҫ�����ɵߵ�
			// ���ɽ�intListֱ�Ӽ���ll�����ÿ���½�listȻ����룬�ͺ����ȡ���ϱ仯�е�list��ʱ��״̬һ����Ҳ��������������һ��
			// �����Ǵ������
			// ll.add(intList);
			// LinkedList<Integer> intList2 = new LinkedList<Integer>();
			// intList2.addAll(intList);
			// intList = intList2;
			// System.out.println(intList);

			// ��������ȷ����
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
		// �߽�������1���ڵ�Ϊnull����ô�죬2.�ڵ�ΪҶ������ô��
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum)
			return true;

		// �����Ż������´����߳�������Ϊ������
		// boolean left = hasPathSum(root.left, sum - root.val);
		// if(left == true) return true;
		// boolean right = hasPathSum(root.right, sum - root.val);
		// if(right == true) return true;
		// return false;

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
