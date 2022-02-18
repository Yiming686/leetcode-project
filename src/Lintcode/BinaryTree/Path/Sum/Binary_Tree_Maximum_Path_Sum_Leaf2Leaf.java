package Lintcode.BinaryTree.Path.Sum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

/**
Binary Tree Maximum Path Sum II Show result 

Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)

Tags Expand 
Binary Tree


Related Problems Expand 
Medium Binary Tree Maximum Path Sum

 *
 */
public class Binary_Tree_Maximum_Path_Sum_Leaf2Leaf {

//	299999999
//	2147483647
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,8,#,#,-5555,-2,1,2,8,#,#,-5555,-2}";
//		TreeNodeStrIn ="{7,299999999,299999999}";
//		 TreeNodeStrIn ="{-15,5,6,-8,1,3,9,2,6,#,#,#,#,#,0,#,#,#,#,4,-1,#,#,10}";
//		 TreeNodeStrIn ="{-15,5,6,-8,1,3,9,2,6}";

//		String TreeNodeStrIn ="{1,9,8}";
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree(TreeNodeStrIn, TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
//		System.out.println(""+maxPathSum2(root));
		
		System.out.println("maxPathSum: "+maxPathSumLeaf2Leaf(root).maxPathSum);
//		char[] ch = new char[3] ;
//		System.out.println("ch"+ String.valueOf(ch[0])+"HHH");
//		System.out.println(""+(ch[2]==' '));
//		System.out.println(""+(ch[2]+"d").equals(ch[0]+"d"));
//		System.out.println(""+(int)ch[0]);
//		System.out.println(""+(int)(''));
//		System.out.format("[%13s]%n", "");  // prints "[             ]" (13 spaces)
//		System.out.format("[%1$3s]%n", ""); // prints "[   ]" (3 spaces)
//		System.out.format("[%1$ds]%n",3, ""); // prints "[   ]" (3 spaces)
//		System.out.format("[%3s]%n", ""); // prints "[   ]" (3 spaces)
//	    int n = 2;
//	    String s = String.format("%1$"+n+"s ", 99);
//		System.out.println(""+s);
	    int count = 3;
	    String spaces = String.format("%"+count+"s","");
	    System.out.println("HH"+spaces+"HH");
//	    List<String> list = new LinkedList<>();
//	    list.add(null);
//	    list.add(null);
//	    list.add(null);
//	    System.out.println(""+list.size());
//	    Deque<String> queue = new LinkedList<>();
//	    queue.add(null);
//	    queue.add(null);
//	    queue.add(null);
//	    System.out.println(""+queue.size());
}
	
    public static int maxPathSum2(TreeNode<Integer> root) {
        // Write your code here
        if(root == null) return 0;
        int leftMaxPathSum  = maxPathSum2(root.left);
        int rightMaxPathSum = maxPathSum2(root.right);
        //正确并且简洁
        return Math.max(0, Math.max(leftMaxPathSum,rightMaxPathSum)) + root.val;
    }
    
    static class Result{
    		int singlePathSum;
    		int maxPathSum;
    		public Result(Integer singlePathSum, Integer maxPathSum){
    			this.singlePathSum = singlePathSum;
    			this.maxPathSum = maxPathSum;
    		}
    }
    
    public static Result maxPathSumLeaf2Leaf(TreeNode<Integer> root) {
        // Write your code here
        if(root == null) {
        		return new Result(0, Integer.MIN_VALUE);
        }
        if(root.left == null && root.right == null) {
    			return new Result(root.val, Integer.MIN_VALUE);
        }
        if(root.left == null) {
        		return maxPathSumLeaf2Leaf(root.right);
        }
        if(root.right == null) {
    			return maxPathSumLeaf2Leaf(root.left);
        }

        Result left = maxPathSumLeaf2Leaf(root.left);
        Result right = maxPathSumLeaf2Leaf(root.right);
        int singlePathSum  = Math.max(left.singlePathSum, right.singlePathSum);
        singlePathSum +=  root.val;
        int maxPathSum = Math.max(left.maxPathSum, right.maxPathSum);
        maxPathSum = Math.max(maxPathSum, left.singlePathSum + root.val + right.singlePathSum);
        //正确并且简洁
        System.out.println("Root: "+root.val + ", singlePath: " + singlePathSum + ", max: " + maxPathSum);
        return  new Result(singlePathSum, maxPathSum);
    }

}
