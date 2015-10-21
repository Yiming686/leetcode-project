package JavaInterviewQueston;

public class Symantec_ValidBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, 2 };
		int[] arr2 = { 2, 1, 3 };
		int[] arr3 = { 3, 2, 1, 5, 4, 6 };
		int[] arr4 = { 1, 3, 4, 2 };
		int[] arr5 = { 3, 4, 5, 1, 2 };

		TreeNode root1 = buildTree(arr1);
		TreeNode root2 = buildTree(arr2);
		TreeNode root3 = buildTree(arr3);
		TreeNode root4 = buildTree(arr4);
		TreeNode root5 = buildTree(arr5);
//		System.out.println((treeSize(root1) == arr1.length));
//
//		System.out.println((treeSize(root2) == arr2.length));
//		System.out.println((treeSize(root3) == arr3.length));
//		System.out.println((treeSize(root4) == arr4.length));
//		System.out.println((treeSize(root5) == arr5.length));

		System.out.println("--------------------");
		lastVal = Integer.MIN_VALUE;firstNode = true;
		System.out.println(isValidBST(root1));
		lastVal = Integer.MIN_VALUE;firstNode = true;
		System.out.println(isValidBST(root2));		lastVal = Integer.MIN_VALUE;firstNode = true;

		System.out.println(isValidBST(root3));		lastVal = Integer.MIN_VALUE;firstNode = true;

		System.out.println(isValidBST(root4));		lastVal = Integer.MIN_VALUE;firstNode = true;

		System.out.println(isValidBST(root5));
	}

	public static TreeNode buildTree(int[] preorder) {
		index = 0;
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static int index = 0;

	public static TreeNode helper(int[] preorder, int min, int max) {
		if (index >= preorder.length)
			return null;
		int data = preorder[index];

//		if (min <= data && data <= max) {
			TreeNode root = new TreeNode(data);
			index++;
			if (index < preorder.length) {
				root.left = helper(preorder, min, data - 1);
				root.right = helper(preorder, data + 1, max);
			}
			return root;
//		}
//		return null;
	}
	
	public static TreeNode helper2(int[] preorder, int min, int max) {
		if (index >= preorder.length)
			return null;
		int data = preorder[index];

		if (min <= data && data <= max) {
			TreeNode root = new TreeNode(data);
			index++;
			if (index < preorder.length) {
				root.left = helper(preorder, min, data - 1);
				root.right = helper(preorder, data + 1, max);
			}
			return root;
		}
		return null;
	}
	public static int treeSize(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + treeSize(root.left) + treeSize(root.right);
	}

	private static int lastVal = Integer.MIN_VALUE;
    private static boolean firstNode = true;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
	
	
}
