package LeetCode.JavaTree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC_101_Symmetric_Tree {

//	Perfect solution, Accepted
	public boolean isSymmetric_rec(TreeNode root) {
		if (root == null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return isBothSymmetric(left, right);

	}

	private boolean isBothSymmetric(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		boolean isLeft = isBothSymmetric(left.left, right.right);
		boolean isRight = isBothSymmetric(left.right, right.left);
		if(isLeft == true && isRight == true) return true;
//		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		LinkedHashMap map = new LinkedHashMap();

		map = new LinkedHashMap(44, 44, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 444;
            }
        };
		return false;
	}

	// isSymmetric2 比isSymmetric 在处理check逻辑更好
	public boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		// 建立两个Queue，插入元素策略不一样，一个是先左右后，一个是先右后左
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		// 初始化，分别插入左右元素
		leftQueue.add(root.left);
		rightQueue.add(root.right);

		while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			// 循环体第一步：取出头元素，并删除之，记得用poll，不报异常，不要用remove
			// 必须保留引用，以便第三步，利用他们来插入数据
			TreeNode leftEl = leftQueue.poll();
			TreeNode rightEl = rightQueue.poll();
			// 循环体第二步：挨个check元素，是否相同，null视为相同
			// 如果都是null,不必check,直接continue
			if (rightEl == null && leftEl == null) {
				continue;
			}
			if (leftEl == null || rightEl == null) {
				return false;
			}
			// 循环体第三步：插入新元素
			if (rightEl.val != leftEl.val)
				return false;
			leftQueue.add(leftEl.left);
			leftQueue.add(leftEl.right);

			rightQueue.add(rightEl.right);
			rightQueue.add(rightEl.left);
		}
		return true;
	}

	// BFS
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		// 建立两个Queue，插入元素策略不一样，一个是先左右后，一个是先右后左
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		// 初始化，分别插入左右元素
		leftQueue.add(root.left);
		rightQueue.add(root.right);
		// 循环终结条件是什么？
		while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			// 循环体第一步：取出头元素，并删除之，记得用poll，不报异常，不要用remove
			// 必须保留引用，以便第三步，利用他们来插入数据
			TreeNode leftEl = leftQueue.poll();
			TreeNode rightEl = rightQueue.poll();
			// 循环体第二步：挨个check元素，是否相同，null视为相同
			// 如果都是null,不必check,直接continue
			// 以下三行可以删掉
			if (rightEl == null && leftEl == null) {
				continue;
			}
			if (leftEl == null && rightEl != null) {
				return false;
			}
			if (rightEl == null && leftEl != null) {
				return false;
			}
			// 循环体第三步：插入新元素
			if (rightEl != null && leftEl != null) {
				if (rightEl.val != leftEl.val)
					return false;
				leftQueue.add(leftEl.left);
				leftQueue.add(leftEl.right);

				rightQueue.add(rightEl.right);
				rightQueue.add(rightEl.left);
			}
		}
		// 如果都为空，返回true，否则false
		if (leftQueue.isEmpty() && rightQueue.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
