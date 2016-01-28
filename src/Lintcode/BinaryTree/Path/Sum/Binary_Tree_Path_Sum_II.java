package Lintcode.BinaryTree.Path.Sum;

import java.util.ArrayList;
import java.util.List;


public class Binary_Tree_Path_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,3,4,5,6,7,8,9,10}";
//		String TreeNodeStrIn ="{1,2,3,4,5,6,7,8,9,10,#,1,#,#,#,#,#,#,2}";
		TreeNode root = TreeNode.fromStringToTree(TreeNodeStrIn);
//		String TreeNodeStrOut = TreeNode.serialize(root);
//		System.out.println("TreeNodeStrOut: "+TreeNodeStrOut);

		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
//		for(int el : arr){
//			System.out.printf("sum=%s, Result=%s\n", el, findSum(root, el));
//		}
		int max = 66;
		while(max>0){
			if(findSum(root, max))
				System.out.printf("sum=%s, Result=%s\n", max, findSum(root, max));
			max--;
		}
		
//		int sum = 18;
//		System.out.println(""+findSum(root, sum));
	}
	public static boolean findSum2(TreeNode root, int sum){
		if(root == null) return false;
		List<Integer> list = new ArrayList<Integer>(); 
		list.add(root.val);
		return findSum2(root, list, sum);
	}

	private static boolean findSum2(TreeNode root, List<Integer> list, int sum) {
		System.out.println(""+list);
		if(root == null) return false;
	    if(root.left == null && root.right == null && sum == root.val) {
//	    	list.add(root.val);
	    	return true;
	    }
	    boolean left  = false;
	    boolean right  = false;
	    if(root.left != null){
	    	list.add(root.left.val);
	    	left  = findSum2(root.left, list, sum - root.val);
	    	list.remove(list.size()-1);
	    }
	    if(root.right != null){
	    	list.add(root.right.val);
	    	right = findSum2(root.right, list, sum - root.val);
	    	list.remove(list.size()-1);
	    }
	    if(left == true || right == true) return true;
		return false;
	}

	//perfect solution
//	private static boolean findSum(TreeNode root, int sum){
//	    if(root == null) return false;
//	    if(root.left == null && root.right == null && sum == root.val) return true;
//	    boolean left  = findSum(root.left,  sum - root.val); 
//    	boolean right = findSum(root.right, sum - root.val);
//	    if(left == true || right == true) return true;
//	    return false;
//	}
	private static boolean findSum(TreeNode root, int sum){
	    if(root == null) return false;
	    int target = sum;
    	return findSum(root.right, root.val, target);
	}
	private static boolean findSum(TreeNode root, int sum, int target){
	    if(root == null) return false;
	    if(root.left == null && root.right == null && sum == root.val) return true;
	    boolean left  = findSum(root.left,  sum + root.val, target); 
    	boolean right = findSum(root.right, sum + root.val, target);
	    if(left == true || right == true) return true;
	    return false;
	}

}
