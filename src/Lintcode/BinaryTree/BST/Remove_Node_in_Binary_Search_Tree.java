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

    //ɾ����������ά��BST
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        // �ҵ����ڵ�͵�ǰ�ڵ�
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;//�������Լ������
        }
        //ɾ���ڵ�
        deleteNode(parent, node);
        //ɾ����ϣ�����root
        return dummy.left;
    }
    //����valueѰ�Ҹ��ڵ㣬find parent ���� ��ǰ�ڵ�ĸ��ڵ�
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
        //�����node�Ƿ���rightΪ�ж���������ô��ã������߼����ǶԵ�
        //Ϊʲô���Գ��أ��ܷ�λ������������
        //���nodeû�����������ͽ�����������ֱ���˸��ڵ�����
        //���������,���ڵ�������node����������node
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            //�����������
            TreeNode temp = node.right;
            TreeNode father = node;
            
            while (temp.left != null) { 
                father = temp;
                temp = temp.left;
            }
            //father��temp��ʱֻ�����ֹ�ϵ����ʱtempֻ��һ��������
            //��fatherֱ������temp��Ψһ������,Ҳ���ǳ���ɾ��temp��
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            //parentֱ������temp��Ҳ������tempȡ��node,����temp��Ψһһ��������
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            //����temp�����������ӣ����׶���node��
            temp.left = node.left;
            temp.right = node.right;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
