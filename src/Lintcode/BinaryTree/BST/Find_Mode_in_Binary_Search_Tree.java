package Lintcode.BinaryTree.BST;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_Mode_in_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Integer> modes = new ArrayList<>(); 
        modes.add(5);modes.add(7);modes.add(5);modes.add(89);
        Object[] arr =  modes.toArray();
        
        System.out.println(""+Arrays.toString(arr));
		TreeNode root = TreeNode.fromStringToTree("{1,#,2,2}");
		System.out.println(""+ Arrays.toString(findMode(root)));;
	}

    public static int[] findMode(TreeNode root) {
        int[] max = new int[1];  
        int[] currVal = new int[1];  
        int[] currCount = new int[1];  
        ArrayList<Integer> modes = new ArrayList<>(); 
        helper(root, max, currVal, currCount, modes);
        return modes.stream().mapToInt(i->i).toArray();
        
    }
    
    private static void helper(TreeNode root, int[] max, int[] currVal, int currCount[], ArrayList<Integer> modes) {  
        if (root == null) {  
            return;  
        }  
        helper(root.left, max, currVal, currCount, modes);
        if (root.val != currVal[0]) {  
            currVal[0] = root.val;  
            currCount[0] = 1;  
        } else {  
            currCount[0] ++;  
        }  
        if (currCount[0] == max[0]) { 
            modes.add(currVal[0]);
        }else if(currCount[0] > max[0]){
            max[0] = currCount[0];  
            modes.clear();//÷ÿµ„øºµ„
            modes.add(currVal[0]);
        }
        helper(root.right, max, currVal, currCount, modes);

    }

}
