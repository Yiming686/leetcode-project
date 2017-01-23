package Lintcode.BinaryTree.BST;

import java.util.ArrayList;
import java.util.List;

import apple.laf.JRSUIUtils.Tree;

/**
Unique Binary Search Trees II

30:00
 Start
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

Have you met this question in a real interview? Yes
Example
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Tags Expand 
Dynamic Programming Depth First Search


Related Problems Expand 
Medium Generate Parentheses

 *
 */
public class Unique_Binary_Search_Trees_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees(3);
	}

    public static List<TreeNode> generateTrees(int n) {
        // write your code here
    	List<TreeNode> list = generate(1, n);
    	for(TreeNode node: list){
            System.out.println(""+TreeNode.fromTreeToString(node));
    	}
        return list;
    }
    
    private static ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();   
    
        //递归调用的base case的只有一种
        if(start > end){
            rst.add(null);
            return rst;
        }
        //下面for loop构造：以i为root的多种可能子树，每一种都加入result中
        for(int i=start; i<=end; i++){
            //一定要用BST的性质：对任何根节点i，构造左子树从start到i-1，然后构造右子树从i+1到end
            //每一个返回节点都是每一棵树的root
            ArrayList<TreeNode> left = generate(start, i-1);
            ArrayList<TreeNode> right = generate(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
// should new a root here because it need to 
// be different for each tree
                    TreeNode root = new TreeNode(i);  
                    root.left = l;
                    root.right = r;
                    rst.add(root);
//                    System.out.println(""+TreeNode.fromTreeToString(root));
                }
            }
        }
        return rst;
    }

}
