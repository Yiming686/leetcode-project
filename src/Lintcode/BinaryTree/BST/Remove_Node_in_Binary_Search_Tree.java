package Lintcode.BinaryTree.BST;

/**
Remove Node in Binary Search Tree Show result 

Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.

Have you met this question in a real interview? Yes
Example
Given binary search tree:

          5

       /    \

    3          6

 /    \

2       4

Remove 3, you can either return:

          5

       /    \

    2          6

      \

         4

or :

          5

       /    \

    4          6

 /   

2

Tags Expand 
LintCode Copyright Binary Search Tree


Related Problems Expand 
Easy Insert Node in a Binary Search Tree *
 */
public class Remove_Node_in_Binary_Search_Tree {

    //删除，并调整维护BST
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        // 找到父节点和当前节点
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;//由上面自己定义的
        }
        //删除节点
        deleteNode(parent, node);
        //删除完毕，返回root
        return dummy.left;
    }
    //给定value寻找父节点，find parent 即是 当前节点的父节点
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        //这个以node是否有right为判断条件是这么想得？？？逻辑倒是对的
        //为什么不对成呢，能否换位左子树？？？
        //如果node没有右子树，就将它的左子树直接了父节点连接
        //分两种情况,父节点左连接node还是右连接node
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            //如果有右子树
            TreeNode temp = node.right;
            TreeNode father = node;
            
            while (temp.left != null) { 
                father = temp;
                temp = temp.left;
            }
            //father和temp此时只有两种关系，此时temp只有一个子树了
            //让father直接连接temp的唯一的子树,也即是彻底删除temp了
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            //parent直接连接temp，也就是让temp取代node,建立temp的唯一一个上连接
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            //建立temp的两个下连接，彻底顶替node了
            temp.left = node.left;
            temp.right = node.right;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
