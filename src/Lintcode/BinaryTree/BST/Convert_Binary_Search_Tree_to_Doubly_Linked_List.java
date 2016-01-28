package Lintcode.BinaryTree.BST;

import java.util.LinkedList;

public class Convert_Binary_Search_Tree_to_Doubly_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{4,2,5,1,3}");
		System.out.println(""+TreeNode.fromTreeToString(root));
		DoublyListNode  head = bstToDoublyList2(root);
		System.out.println(""+TreeNode.fromTreeToString(root));
		DoublyListNode  node = head;
		System.out.println("============");

		while(node.next!=head){
			System.out.println(""+node.val);
			node = node.next;
		}
		System.out.println(""+node.val);
		System.out.println("============");
		node = head;
		while(node.prev!=head){
			System.out.println(""+node.prev.val);
			node = node.prev;
		}
		System.out.println(""+node.prev.val);
		
		
	}
	
	
	//WORKED, BUT MIGHT Memory Limit Exceeded
   	public static DoublyListNode bstToDoublyList2(TreeNode root) {  
        // ArrayList<Integer> result = new ArrayList<Integer>();
  	    DoublyListNode dummy = new DoublyListNode(0);

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curt = root;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            DoublyListNode node = new DoublyListNode(curt.val);
            if(dummy.next == null) {
                node.prev = node;
                node.next = node;
                dummy.next = node;
            }else{
                DoublyListNode head = dummy.next;
                node.prev = head.prev;
                node.next = head;
                head.prev.next = node;
                head.prev = node;
            }
            curt = curt.right;
        }
   	    return dummy.next;

    }

	
	//WORKED, BUT MIGHT Memory Limit Exceeded
   	public static  DoublyListNode bstToDoublyList(TreeNode root) {  
   	    DoublyListNode dummy = new DoublyListNode(0);
   	     bstToDoublyList(root, dummy );   
   	    return dummy.next;
    }
   	static void bstToDoublyList(TreeNode root, DoublyListNode dummy){
        if(root == null) return;
        bstToDoublyList(root.left, dummy);
        DoublyListNode node = new DoublyListNode(root.val);
        if(dummy.next == null) {
            node.prev = node;
            node.next = node;
            dummy.next = node;
        }else{
            DoublyListNode head = dummy.next;
            node.prev = head.prev;
            node.next = head;
            head.prev.next = node;
            head.prev = node;
        }
        bstToDoublyList(root.right, dummy);
    }
    
//   	static  class TreeNode {
//        public int val;
//        public TreeNode left, right;
//        public TreeNode(int val) {
//            this.val = val;
//            this.left = this.right = null;
//        }
//    }
   static class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }
    

}
