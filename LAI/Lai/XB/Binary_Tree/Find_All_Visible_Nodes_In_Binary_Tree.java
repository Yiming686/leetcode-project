package Lai.XB.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

import Leet.OA.Other.Max_Index_Diff_to_Make_Adjacent_Values;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Find_All_Visible_Nodes_In_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = TreeNodeUtils.fromStringToTree("{7,3,15,null,null,9,20}");
		TreeNode root = TreeNodeUtils.fromStringToTree("{2,7,1,6,5,3,4}");
		int[] max = new int[] {Integer.MIN_VALUE};
		List<Integer> result = new ArrayList<Integer>();
		findAllVivibleNodes(result, root, max);
//		findAllVivibleNodes(result, root, null);
		System.out.println(""+result);
	}

	private static void findAllVivibleNodes(List<Integer> result, TreeNode<Integer> root, int[] max) {
		// TODO Auto-generated method stub
		if(root == null) {
			return;
		}
		int temp = max[0]; 
		if(  root.val > temp) {
			result.add(root.val);
			max[0] = root.val;
		}else {
			
		} 
		findAllVivibleNodes(result, root.left, max);
		findAllVivibleNodes(result, root.right, max);
//		if(root.val > temp) {
			max[0] = temp;
//		}
	}
//	private static void findAllVivibleNodes(List<Integer> result, TreeNode<Integer> root, TreeNode<Integer> max) {
//		// TODO Auto-generated method stub
//		if(root == null) {
//			return;
//		}
//		if(max == null || root.val > max.val) {
//			result.add(root.val);
//			max = root;
//		}
//		findAllVivibleNodes(result, root.left, max);
//		findAllVivibleNodes(result, root.right, max);
//	}

}
