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
    
    //���ǰ��������������Ԫ�أ���֪�����ٸ��������������ٸ���������
    //�������������������Ԫ�أ���֪�����ٸ��������������ٸ���������
    //ǰ������϶��������������꣬�Ż����������
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
        //����Ѱ�����Һ��ӣ�
        //�����position�ͻ�����������ķ�Χ,ע��position����inorder�����index
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        //����������ķ�Χ���������������棬���߳���һ����Ҳ��������������������
        // inorder: instart, position-1
        // preorder: prestart+1, prestart+position-instart
        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);

        //����������ķ�Χ���������������棬���߳���һ����Ҳ��������������������
        // inorder: pos+1, inend
        // preorder: prestart+position-instart+1, preend ����
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
        //�ݹ�ѭ��������nodes����������ͬʱ����
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
