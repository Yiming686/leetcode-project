package Lintcode.BinaryTree;

/**
Construct Binary Tree from Preorder and Inorder Traversal Show result 

Given preorder and inorder traversal of a tree, construct the binary tree.

Have you met this question in a real interview? Yes
Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

  2
 / \
1   3
Note
You may assume that duplicates do not exist in the tree.

Tags Expand 
Binary Tree

 *
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    private int findPosition(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    //针对前序遍历数组里面的元素，你知道多少个在左子树，多少个在右子树
    //针对中序遍历数组里面的元素，你知道多少个在左子树，多少个在右子树
    //前序遍历肯定将左子树遍历完，才会进入右子树
    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
            int[] preorder, int prestart, int preend) {
    	//both of the two base cases worked well
        // if (instart > inend) {
        //     return null;
        // }

        if (prestart > preend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        //下面寻找左右孩子，
        //获得了position就获得左右子树的范围,注意position属于inorder数组的index
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        //获得左子树的范围，在两个数组里面，二者长度一样，也就是左子树的两种序列
        // inorder: instart, position-1
        // preorder: prestart+1, prestart+position-instart
        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);

        //获得右子树的范围，在两个数组里面，二者长度一样，也就是右子树的两种序列
        // inorder: pos+1, inend
        // preorder: prestart+position-instart+1, preend 或者
        // preorder: position - inend+ preend + 1, preend
        root.right = myBuildTree(inorder, position + 1, inend,
        preorder, prestart+position-instart+1, preend);

        // root.right = myBuildTree(inorder, position + 1, inend,
        //         preorder, position - inend + preend + 1, preend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        //递归循环，构建nodes，两个数组同时利用
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
