package Lai.BinaryTree.Construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reconstruct Binary Tree With Levelorder And Inorder
 * 
 * Description Given the levelorder and inorder traversal sequence of a binary
 * tree, reconstruct the original tree.
 * 
 * Assumptions
 * 
 * The given sequences are not null and they have the same length There are no
 * duplicate keys in the binary tree Examples
 * 
 * levelorder traversal = {5, 3, 8, 1, 4, 11}
 * 
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 * 
 * the corresponding binary tree is
 * 
 * 5
 * 
 * / \
 * 
 * 3 8
 * 
 * / \ \
 * 
 * 1 4 11
 * 
 * How is the binary tree represented?
 * 
 * We use level order traversal sequence with a special symbol "#" denoting the
 * null node.
 * 
 * For Example:
 * 
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * /
 * 
 * 4
 * 
 * Hard Binary Tree
 *
 */
public class Reconstruct_Binary_Tree_With_Levelorder_And_Inorder {
		static class TreeNode {
			int val;
			int liss;
			TreeNode left;
			TreeNode right;
			public TreeNode(int val) {
				super();
				this.val = val;
			}
		}
		public static void main(String[] args) {
			int[] arr1 = new int[]{1,6,5,7,4,10,9};
			int[] arr2 = new int[]{4,1,10,5,9,6,7};
			reconstruct(arr1, arr2);
		}
	
	  public static TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
		    // Write your solution here
		    if(inOrder == null || levelOrder == null){
		      return null;
		    }
		    Map<Integer, Integer> map = new HashMap<>();
		    for(int i = 0; i < inOrder.length; i++){
		      map.put(inOrder[i], i);
		    }
		    List<Integer> nodes = new ArrayList<>();
		    for(int val : levelOrder){
		      nodes.add(val);
		    }
		    return helper(map, nodes);
	}
		 
	  private static TreeNode helper(Map<Integer, Integer> map, List<Integer> nodes){
		    if(nodes.isEmpty()){
		      return null;
		    }
		    TreeNode root = new TreeNode(nodes.get(0));
		    int pos = map.get(nodes.get(0));
		    List<Integer> leftNodes = new ArrayList<>();
		    List<Integer> rightNodes = new ArrayList<>();
		    System.out.println("nodes:"+nodes);
		    for(int i = 1; i < nodes.size(); i++){
		      if(map.get(nodes.get(i)) < pos){
		        leftNodes.add(nodes.get(i));
		      }else{
		        rightNodes.add(nodes.get(i));
		      }      
		    }
		    root.left = helper(map, leftNodes);
		    root.right = helper(map, rightNodes);
		    return root;
	}

		  
}
