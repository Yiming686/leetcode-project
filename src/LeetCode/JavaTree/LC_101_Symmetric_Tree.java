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

	// isSymmetric2 ��isSymmetric �ڴ���check�߼�����
	public boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		// ��������Queue������Ԫ�ز��Բ�һ����һ���������Һ�һ�������Һ���
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		// ��ʼ�����ֱ��������Ԫ��
		leftQueue.add(root.left);
		rightQueue.add(root.right);

		while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			// ѭ�����һ����ȡ��ͷԪ�أ���ɾ��֮���ǵ���poll�������쳣����Ҫ��remove
			// ���뱣�����ã��Ա��������������������������
			TreeNode leftEl = leftQueue.poll();
			TreeNode rightEl = rightQueue.poll();
			// ѭ����ڶ���������checkԪ�أ��Ƿ���ͬ��null��Ϊ��ͬ
			// �������null,����check,ֱ��continue
			if (rightEl == null && leftEl == null) {
				continue;
			}
			if (leftEl == null || rightEl == null) {
				return false;
			}
			// ѭ�����������������Ԫ��
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
		// ��������Queue������Ԫ�ز��Բ�һ����һ���������Һ�һ�������Һ���
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		// ��ʼ�����ֱ��������Ԫ��
		leftQueue.add(root.left);
		rightQueue.add(root.right);
		// ѭ���ս�������ʲô��
		while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			// ѭ�����һ����ȡ��ͷԪ�أ���ɾ��֮���ǵ���poll�������쳣����Ҫ��remove
			// ���뱣�����ã��Ա��������������������������
			TreeNode leftEl = leftQueue.poll();
			TreeNode rightEl = rightQueue.poll();
			// ѭ����ڶ���������checkԪ�أ��Ƿ���ͬ��null��Ϊ��ͬ
			// �������null,����check,ֱ��continue
			// �������п���ɾ��
			if (rightEl == null && leftEl == null) {
				continue;
			}
			if (leftEl == null && rightEl != null) {
				return false;
			}
			if (rightEl == null && leftEl != null) {
				return false;
			}
			// ѭ�����������������Ԫ��
			if (rightEl != null && leftEl != null) {
				if (rightEl.val != leftEl.val)
					return false;
				leftQueue.add(leftEl.left);
				leftQueue.add(leftEl.right);

				rightQueue.add(rightEl.right);
				rightQueue.add(rightEl.left);
			}
		}
		// �����Ϊ�գ�����true������false
		if (leftQueue.isEmpty() && rightQueue.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
