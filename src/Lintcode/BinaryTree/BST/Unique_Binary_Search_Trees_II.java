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
    
        //�ݹ���õ�base case��ֻ��һ��
        if(start > end){
            rst.add(null);
            return rst;
        }
        //����for loop���죺��iΪroot�Ķ��ֿ���������ÿһ�ֶ�����result��
        for(int i=start; i<=end; i++){
            //һ��Ҫ��BST�����ʣ����κθ��ڵ�i��������������start��i-1��Ȼ������������i+1��end
            //ÿһ�����ؽڵ㶼��ÿһ������root
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
