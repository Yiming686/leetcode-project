package LeetCode.JavaBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import Lintcode.BinaryTree.TreeNode;

public class LC_000_Binary_Search_Tree_To_Doubly_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,4,2,3}";
		TreeNodeStrIn ="{1,2,3,#,#,4,5,#,#,#,6,7,#}";
		TreeNodeStrIn ="{3,9,20,#,#,15,7}";
//		TreeNodeStrIn ="{1,2,3,#,#,4,#,5,#,6,#,7,#}";
//		TreeNodeStrIn ="{1,2,3,#,#,#,#}";
//		TreeNodeStrIn ="{1,#,2}";
//		TreeNodeStrIn ="{3}";
		TreeNode root = TreeNode.fromStringToTree(TreeNodeStrIn);
//		System.out.println(""+serialize11(root));
//		System.out.println(""+serialize12(root));
//		String str = "{7}";
//		System.out.println(""+TreeNode.convertToString(deserialize44(str)));
		System.out.println(""+TreeNode.convertToString(root));
		TreeNode node = flattenBST2DoublyLinkedList3(root);
//		System.out.println(""+TreeNode.convertToString(node));
		while(node != null){
			System.out.println(node.val);
			node = node.right;
		}
	}

    /*
    helper function -- given two list nodes, join them
    together so the second immediately follow the first.
    Sets the .next of the first and the .previous of the second.
   */
   public static void join(TreeNode a, TreeNode b) {
       a.right = b;
       b.left = a;
   }
   /*
   helper function -- given two circular doubly linked
   lists, append them and return the new list.
  */
  public static TreeNode append(TreeNode a, TreeNode b) {
      // if either is null, return the other
      if (a==null) return(b);
      if (b==null) return(a);
      
      // find the last node in each using the .previous pointer
      TreeNode aLast = a.left;
      TreeNode bLast = b.left;
      
      // join the two together to make it connected and circular
      join(aLast, b);
      join(bLast, a);
      
      return(a);
  }
	
	public static TreeNode flattenBST2DoublyLinkedList_rec(TreeNode root) {
        // base case: empty tree -> empty list
        if (root==null) return(null);
        
        // Recursively do the subtrees (leap of faith!)
        TreeNode aList = flattenBST2DoublyLinkedList_rec(root.left);
        TreeNode bList = flattenBST2DoublyLinkedList_rec(root.right);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.left = root;
        root.right = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        aList = append(aList, root);
        aList = append(aList, bList);
        
        return(aList);
	}
	
	
	
	
	public static TreeNode flattenBST2DoublyLinkedList(TreeNode root) {
		if (root==null) return(null);
		TreeNode prev = null;
		TreeNode head = null;
		flattenBST2DoublyLinkedList(root, prev, head);
		// 不是return root， 而是head
		// return root;
		return head;
	}

	private static void flattenBST2DoublyLinkedList(TreeNode p, TreeNode prev,
			TreeNode head) {
		// TODO Auto-generated method stub
		if (p == null)
			return;
		flattenBST2DoublyLinkedList(p.left, prev, head);
		p.left = prev;
		if (prev != null) {
			prev.right = p;
		} else {
			head = p;
		}
		TreeNode right = p.right;
		head.left = p;
		p.right = head;
		
		prev = p;
		
		flattenBST2DoublyLinkedList(right, prev, head);

	}
	
	public static TreeNode flattenBST2DoublyLinkedList2(TreeNode root) {
		if (root==null) return(null);
		TreeNode dummy1 = new TreeNode(0);
		TreeNode dummy2 = new TreeNode(0);
		dummy1.right = dummy2;
		dummy2.left = dummy1;
		TreeNode head = dummy1;
		TreeNode tail = dummy2;
		flattenBST2DoublyLinkedList2(root, head, tail);
		// 不是return root， 而是head
		// return root;
		return dummy1.right;
	}

	private static void flattenBST2DoublyLinkedList2(TreeNode root, TreeNode head,
			TreeNode tail) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.println(""+root.val);
		flattenBST2DoublyLinkedList2(root.left, head, tail);
		tail.left.right = root;
		root.left = tail.left;
		root.right = tail;
		tail.left = root;
		flattenBST2DoublyLinkedList2(root.right, head, tail);

	}

	public static TreeNode flattenBST2DoublyLinkedList3(TreeNode root) {
		if (root==null) return(null);
		List<TreeNode> list = new ArrayList<>();
		TreeNode dummy = new TreeNode(0);
		flattenBST2DoublyLinkedList3(root, list);
//		// 不是return root， 而是head
//		// return root;
////		System.out.println();
//		TreeNode curr = dummy;
//		for(TreeNode node : list){
////			System.out.println(""+node.val);
//			curr.right = node;
//			node.left = curr;
//			curr = node;
//		}
//		return dummy.right;
		return list.get(0);
	}

	private static void flattenBST2DoublyLinkedList3(TreeNode root, List<TreeNode> list) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
//		System.out.println(""+root.val);
		flattenBST2DoublyLinkedList3(root.left, list);
		list.add(root);
		flattenBST2DoublyLinkedList3(root.right, list);

	}


}
