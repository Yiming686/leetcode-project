package LeetCode.JavaTree;

import static org.junit.Assert.*;

import org.junit.Test;



public class LC_112_Path_Sum_II_Test {

	@Test
	public void test() {
		Integer[][] bianryTreeData = {{1},{2,null}};
		TreeNode2<Integer> root = createBinaryTreeByArray(bianryTreeData);

		new LC_112_Path_Sum_II().pathSum(root,3);
	}
	
	public static <E> TreeNode2<E> createBinaryTreeByArray(E[][] bianryTreeData) {
		if (bianryTreeData == null) return null;
		E rootData = bianryTreeData[0][0];
		int rootRow = 0;
		int rootLine = 0;
		TreeNode2<E> root = new TreeNode2<E>(rootData);
		recursivelyCreateBinaryTreeByArray(root, bianryTreeData, rootRow,
				rootLine);
		return root;
	}
	public static <E> void recursivelyCreateBinaryTreeByArray(TreeNode2<E> root,
			E[][] bianryTreeData, int rootRow, int rootLine) {
	
		if (root == null) return;
		int leftRow = rootRow + 1;
		int leftLine = rootLine * 2;
		int rightRow = rootRow + 1;
		int rightLine = rootLine * 2 + 1;
		if (leftRow >= bianryTreeData.length) return;
		E leftData = null;
		E rightData = null;
		if (leftLine < bianryTreeData[leftRow].length) {
			leftData = bianryTreeData[leftRow][leftLine];
		}
		if (rightLine < bianryTreeData[leftRow].length) {
			rightData = bianryTreeData[rightRow][rightLine];
		}
		if (leftData != null) {
			TreeNode2<E> leftChild = new TreeNode2<E>(leftData);
			root.left = leftChild;
		}
		if (rightData != null) {
			TreeNode2<E> rightChild = new TreeNode2<E>(rightData);
			root.right = rightChild;
		}
		recursivelyCreateBinaryTreeByArray(root.left, bianryTreeData, leftRow,
				leftLine);
		recursivelyCreateBinaryTreeByArray(root.right, bianryTreeData,
				rightRow, rightLine);
	}

}
