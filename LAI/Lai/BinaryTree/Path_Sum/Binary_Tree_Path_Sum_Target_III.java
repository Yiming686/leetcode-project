package Lai.BinaryTree.Path_Sum;

import java.util.HashSet;
import java.util.Set;

import Utils.StringUtils;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TreeNode;

/**
 * 
 * Given a binary tree in which each node contains an integer number. Determine
 * if there exists a path (the path can only be from one node to itself or to
 * any of its descendants), the sum of the numbers on the path is the given
 * target number.
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 2 11
 * 
 * / \
 * 
 * 6 14
 * 
 * /
 * 
 * 3
 * 
 * If target = 17, There exists a path 11 + 6, the sum of the path is target.
 * 
 * If target = 20, There exists a path 11 + 6 + 3, the sum of the path is
 * target.
 * 
 * If target = 10, There does not exist any paths sum of which is target.
 * 
 * If target = 11, There exists a path only containing the node 11.
 * 
 * How is the binary tree represented?
 * 
 * We use the level order traversal sequence with a special symbol "#" denoting
 * the null node.
 * 
 * For Example:
 * 
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * /
 * 
 * 4
 * 
 * 
 * Input: TreeNode.fromLevelOrderSpecial(new
 * String[]{"3","-8","9","4","10","2","-5","1","-2"}), 6 expected:<false> but
 * was:<true>
 * 
 * Input: TreeNode.fromLevelOrderSpecial(new String[]{"3","-8","9","4","10","2","-5","1","-2"}), 7
expected:<true> but was:<false>
 * 
 * 
 */
public class Binary_Tree_Path_Sum_Target_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("{\"3\",\"-8\",\"9\",\"4\",\"10\",\"2\",\"-5\",\"1\",\"-2\"}", TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
		System.out.println(""+exitII(root, 7));
	}

	static boolean exitII(TreeNode root, int sum) {//target
		if (root == null) {
			return false;
		}
		Set<Integer> prefixSumSet = new HashSet<>();//backtracking，这就是方案变量
		prefixSumSet.add(0);
		TP tp = TP.build("", "11111", "root", null);
		boolean hasTarget = helper(root, prefixSumSet, 0, sum, tp); TP.build("root", null, hasTarget, StringUtils.toStr(root), prefixSumSet, 0, sum);//target;
		tp.print();
		return hasTarget;
	}

	// prefixSumSet保存所有的前面的节点到root的Sum，
	// prefixSum为从父亲节点root的sum，
	// target 信息不能丢，不能变
	private static boolean helper(TreeNode<Integer> root, Set<Integer> prefixSumSet, int prefixSum, int target, TP tp) {
		if (root == null) {
			return false;
		}
		prefixSum += root.val;
		boolean needToRemove = prefixSumSet.add(prefixSum);//这是个大技巧
		if (prefixSumSet.contains(prefixSum - target)) {
			return true;
		}
		boolean left = helper(root.left, prefixSumSet, prefixSum, target ,TP.build("left", tp));TP.build("left", tp, left, StringUtils.toStr(root.left), prefixSumSet, prefixSum, target);
		boolean right = helper(root.right, prefixSumSet, prefixSum, target,TP.build("right", tp));TP.build("right", tp, right, StringUtils.toStr(root.right), prefixSumSet, prefixSum, target);
		if(needToRemove) {
			prefixSumSet.remove(prefixSum);	
		}		
		if (left || right) {
			return true;
		}
		return false;
	}

}
