package Lintcode.BinaryTree.Path.Sum;

import java.util.ArrayList;
import java.util.List;


/**
 * Binary Tree Path Sum Show result
 * 
 * Given a binary tree, find all paths that sum of the nodes in the path equals
 * to a given number target.
 * 
 * A valid path is from root node to any of the leaf nodes.
 * 
 * Have you met this question in a real interview? Yes Example Given a binary
 * tree, and target = 5:
 * 
 *    1 
 *   / \ 
 *  2   4 
 * / \ 
 * 2 3 
 * return
 * 
 * [ [1, 2, 2], [1, 4] ] Tags Expand Binary Tree Binary Tree Traversal
 * 
 * 

113. Path Sum II 

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
Subscribe to see which companies asked this question

Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (E) Binary Tree Paths (E) Path Sum III


 *
 */
public class Binary_Tree_Path_Sum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,4,2,3}";
		TreeNode root = TreeNode.fromStringToTree(TreeNodeStrIn);
		System.out.println(""+binaryTreePathSum(root, 5));
		
		String TreeNodeStrIn2 ="{5,4,8,11,#,13,4,7,2,#,#,5,1}";
		TreeNode root2 = TreeNode.fromStringToTree(TreeNodeStrIn2);
//		System.out.println(""+ travereTree(root2));
		travereTree(root2);
		System.out.println(""+binaryTreePathSum(root2, 22));
	}

//	树的遍历模板
	private static void travereTree(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		System.out.println("前序遍历--> "+root.val);
		travereTree(root.left);
		System.out.println("中序遍历--> "+root.val);
		travereTree(root.right);
		System.out.println("后序遍历--> "+root.val);
	}

	//找出所以可能的从根到叶子的路径，一旦路径和等于target，加入result
    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        //第一次调用，主要是初始化list和sum
        helper(result, list, root, root.val, target);
        return result;
    }
    
    //helper的含义：在root为根节点的树中，寻找当前和sum为target的路径，加入list，加入result
    private static void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum, int target){
        if(root == null) return;
        System.out.println("::"+root.val);
        //根据题意必须保证是叶子节点
         if (root.left == null && root.right == null) {
	        if(target == sum){
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
    	}

        if(root.left != null){
            list.add(root.left.val);
            helper(result, list, root.left, sum+root.left.val, target);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            list.add(root.right.val);
            helper(result, list, root.right, sum+root.right.val, target);
            list.remove(list.size()-1);
        }
    }    



}
