package LeetCode.JavaBinarySearchTree;

import java.util.LinkedList;

public class LC_109_Convert_Sorted_List_to_Binary_Search_Tree {

	
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
    //  ListNode current;

        ListNode current = head;
         int size = getListLength(head);
        //怎么想到仅仅传递size呢
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        list.addLast(head);
        return sortedListToBSTHelper(list, size);
    }
    
    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    //目的:依次遍历,整个list
    // private ListNode current;

    //针对list的个数和当前的ListNode：找到最左边点生成左TreeNode，生成现在TreeNode，生成右TreeNode
    //计算出当前ListNode的序号，从1开始
    //针对当前的size，如果小于等于零，直接返回null
    //如果大于零，先build左子树，再build当前节点，然后build右子树，思路很清晰
    //关键是如何保证次序和balanced，如何传递参数
    //中序遍历很容易写，给一个root，先遍历左子树，再遍历root（处理root），最后遍历右子树
    //如果给定了root，也就知道了root下面的node个数，root.left和root.right下面的node个数
    //但是如何和list关联起来
    public TreeNode sortedListToBSTHelper(LinkedList<ListNode> list, int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(list, size / 2);
        ListNode last = list.get(0);
        TreeNode root = new TreeNode(last.val);
        list.clear();
        last = last.next;
        list.addLast(last);
        TreeNode right = sortedListToBSTHelper(list, (size - 1) - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
