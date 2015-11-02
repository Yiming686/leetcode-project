package LeetCode.JavaBinarySearchTree;


public class LC_000_Binary_Search_Tree_To_Doubly_Linked_List {

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
	
	public TreeNode flattenBST2DoublyLinkedList_rec(TreeNode root) {
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
	
	
	
	
	public TreeNode flattenBST2DoublyLinkedList(TreeNode root) {
		if (root==null) return(null);
		TreeNode prev = null;
		TreeNode head = null;
		flattenBST2DoublyLinkedList(root, prev, head);
		// 不是return root， 而是head
		// return root;
		return head;
	}

	private void flattenBST2DoublyLinkedList(TreeNode p, TreeNode prev,
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
