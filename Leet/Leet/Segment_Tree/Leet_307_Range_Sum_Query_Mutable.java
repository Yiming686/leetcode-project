package Leet.Segment_Tree;

public class Leet_307_Range_Sum_Query_Mutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 5};
		root = buildTree(arr);
		
		System.out.println(""+sumRange(0, 2));
		update(1, 2);
		System.out.println(""+sumRange(0, 2));
	}

//	public NumArray(int[] arr) {
//        TreeNode root = buildTree(arr);
//    }

	public static void update(int i, int val) {
		update(root, i, val);
	}

	public static int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	 static TreeNode root;

	private static void update(TreeNode root, int i, int val) {
		if (root.start == root.end && root.start == i) {
			root.sum = val;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (i <= mid) {
			update(root.left, i, val);
		}
		if (i > mid) {
			update(root.right, i, val);
		}
		root.sum = root.left.sum + root.right.sum;//update root's sum
	}

	private static int sumRange(TreeNode root, int from, int to) {
		if (root == null) {
			return 0;
		}
		if (root.start == from && root.end == to) {
			return root.sum;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (to <= mid) {
			return sumRange(root.left, from, to);
		}
		if (from > mid) {
			return sumRange(root.right, from, to);
		}
		int leftSum = sumRange(root.left, from, mid);
		int rightSum = sumRange(root.right, mid + 1, to);
		// int rightSum = (to > mid) ? sumRange(root.right, mid + 1,  to): 0; // wrong
		// int rightSum = (to > mid) ? sumRange(root.right, to,  end): 0;
		return leftSum + rightSum;
	}

	private static TreeNode buildTree(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		return buildTree(arr, 0, arr.length - 1);
	}

	private static TreeNode buildTree(int[] arr, int start, int end) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(start, end, arr[start]);
		}
		int mid = start + (end - start) / 2;
		// TreeNode left = buildTree(root.left, start, mid);
		// TreeNode right = buildTree(root.right, mid + 1, end);
		TreeNode left = buildTree(arr, start, mid);
		TreeNode right = buildTree(arr, mid + 1, end);
		// int sum = left.sum + right.sum + root.sum;
		int sum = left.sum + right.sum;
		TreeNode root = new TreeNode(start, end, sum);
		root.left = left;
		root.right = right;
		return root;
	}

	 static class TreeNode {
		int start;
		int end;
		int sum;
		TreeNode left, right;

		TreeNode(int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}

	}	
}
