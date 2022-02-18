package Lai.Binary_Tree;

import static Utils.ArrayUtils.printf;
import static Utils.StringUtils.toStr;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

/**
 * 
 * Given the root of a binary tree, find the maximum value V for which there
 * exists different nodes A and B where V = |A.val - B.val| and A is an ancestor
 * of B.
 * 
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any
 * child of A is an ancestor of B.)
 *
 * 
 * 
 */
public class LEET_1026_Maximum_Difference_Between_Node_and_Ancestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("[8,3,10,1,6,null,14,null,null,4,7,13]");
		TreeNodeUtils.printTree(root);
		System.out.println(""+maxAncestorDiff(root));
	}

	public  static int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] maxDiff = new int[1];
		maxAncestorDiff(root, maxDiff);
		return maxDiff[0];
	}
//   for root, what is the max diff
//  for a, b, c, d, e, when a comes, [min, max], |a-min|, |a-max|

	//from left:
	//from right:
//     
	// what to return:
	static class Result {
		int min;
		int max;

		Result(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

    private static Result maxAncestorDiff(TreeNode<Integer> root, int[] maxDiff){
        if(root == null){
            return null;
        }
    	if(root.left == null && root.right == null) {
			return new Result(root.val, root.val);
		}        
        Result left = maxAncestorDiff(root.left, maxDiff);                
        Result right = maxAncestorDiff(root.right, maxDiff);
        int min = root.val;
        int max = root.val;
        if(left != null){
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
            maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - left.min));        
            maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - left.max));        
        }
        if(right != null){
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
            maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - right.min));        
            maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - right.max));                    
        }
//        System.out.println(""+toStr(maxDiff));
		printf("root:diff %s:%s", root.val, toStr(maxDiff));
        return new Result(min, max);
    }

	private static Result maxAncestorDiff_00(TreeNode<Integer> root, int[] maxDiff) {
		if (root == null) {
			return new Result(0, 0);
		}
		if(root.left == null && root.right == null) {
			return new Result(0, 0);
		}
		Result left = maxAncestorDiff(root.left, maxDiff);
		Result right = maxAncestorDiff(root.right, maxDiff);
		int min = Math.min(left.min, right.min);
		min = Math.min(min, root.val);
		int max = Math.max(left.max, right.max);
		max = Math.max(max, root.val);
		maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - left.min));
		maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - left.max));
		maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - right.min));
		maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - right.max));
//		System.out.println(""+toStr(maxDiff));
		printf("root:diff %s:%s", root.val, toStr(maxDiff));
		return new Result(min, max);
	}

}
