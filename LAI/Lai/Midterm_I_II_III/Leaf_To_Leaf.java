package Lai.Midterm_I_II_III;

import Utils.TreeNodeUtils.TreeNode;

public class Leaf_To_Leaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return getHeight(root) == -1;
        
    }
    
    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.right);
        int right = getHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left -right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
        
    }

}
