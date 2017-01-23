package Lintcode.LinkList;

import Lintcode.BinaryTree.TreeNode;

/**
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Example
               2
1->2->3  =>   / \
             1   3
Tags 
Recursion Linked List
Related Problems 
Easy Flatten Binary Tree to Linked List 30 %
Easy Convert Sorted Array to Binary Search Tree With Minimal Height 32 %

 *
 *
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = ListNode.buildList(new int[] { 0, 1, 2, 3, 4, 5, 6 });
		System.out.println("" + ListNode.convertToString(list));
		TreeNode root = sortedListToBST1(list);
		System.out.println("" + TreeNode.convertToString(root));
	}
	
    private static int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    // 解法一：divide and conquer, 
    // 计算size，然后divide and conquer,比findMid 更好的
    public static TreeNode sortedListToBST1(ListNode head) {  
        // write your code here
        ListNode current = head;
         int size = getListLength(head);
        return sortedListToBSTHelper(head, size);
    } 
    // 针对从head开始的list的前size个元素，构建BST
    public static TreeNode sortedListToBSTHelper(ListNode head, int size) {
        if (head ==null || size <= 0) {
            return null;
        }
        //找到最左边点生成左TreeNode
        TreeNode left = sortedListToBSTHelper(head, (size-1) / 2 );
        //生成现在TreeNode即root
        // ListNode mid = findNode(node, (size-1) / 2 + 1);
        ListNode mid = head;
        int pos = (size-1) / 2 + 1;
        while(--pos > 0){
            mid = mid.next;
        }
        
        // TreeNode root = mid!=null ? new TreeNode(mid.val) : null;
        TreeNode root = new TreeNode(mid.val);
        TreeNode right = sortedListToBSTHelper(mid.next, (size - 1) - (size-1) / 2 );
        //连接，root 和 left 和 right
        root.left = left;
        root.right = right;

        return root;
    }
    

	// 解法二，利用修正后的findMiddle()
	// divide and conquer 
	    public static TreeNode sortedListToBST2(ListNode head) {
	    	if(head == null){
	    		return null;
	    	}
	    	if(head.next == null){
	    		return new TreeNode(head.val);
	    	}
	    	if(head.next.next == null){
	    		TreeNode root = new TreeNode(head.val);
	    		TreeNode right = new TreeNode(head.next.val);
	    		root.right = right;
	    		return root;
	    	}
			ListNode beforeMid = findBeforeMiddle(head);
			
			ListNode leftList = head;
			ListNode mid = beforeMid.next;
			ListNode rightList = beforeMid.next.next;
			beforeMid.next = null;
			
			TreeNode leftTree  = sortedListToBST2(leftList);
			TreeNode rightTree = sortedListToBST2(rightList);

			TreeNode root = new TreeNode(mid.val);
			root.left = leftTree;
			root.right = rightTree;

			return root;
	    }
	    
	    // at least three 3 nodes
	    private static ListNode findBeforeMiddle(ListNode head){
	    	if(head == null){
	    		return head;
	    	}
	    	ListNode dummy = new ListNode(0);
	    	dummy.next = head;
	    	ListNode beforeMid = dummy;//do not move head,
	    	
	    	ListNode slow = head;
	    	ListNode fast = head.next;
	    	while(fast != null && fast.next != null){
	    	    beforeMid = beforeMid.next;
	    		slow = slow.next;
	    		fast = fast.next.next;
	    	}
	    	return beforeMid;
	    }

//	    correct, find the middle one
	private static ListNode findMiddle2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

//	Not Correct, find the one before the middle one
	private static ListNode findBeforeMiddle3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;// bug here
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
