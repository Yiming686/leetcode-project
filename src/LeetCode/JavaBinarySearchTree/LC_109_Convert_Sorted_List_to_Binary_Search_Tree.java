package LeetCode.JavaBinarySearchTree;

import java.util.LinkedList;

public class LC_109_Convert_Sorted_List_to_Binary_Search_Tree {

	
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
    //  ListNode current;

        ListNode current = head;
         int size = getListLength(head);
        //��ô�뵽��������size��
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

    //Ŀ��:���α���,����list
    // private ListNode current;

    //���list�ĸ����͵�ǰ��ListNode���ҵ�����ߵ�������TreeNode����������TreeNode��������TreeNode
    //�������ǰListNode����ţ���1��ʼ
    //��Ե�ǰ��size�����С�ڵ����㣬ֱ�ӷ���null
    //��������㣬��build����������build��ǰ�ڵ㣬Ȼ��build��������˼·������
    //�ؼ�����α�֤�����balanced����δ��ݲ���
    //�������������д����һ��root���ȱ������������ٱ���root������root����������������
    //���������root��Ҳ��֪����root�����node������root.left��root.right�����node����
    //������κ�list��������
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
