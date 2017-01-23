package Lintcode.BinaryTree.BST;

import java.util.List;

public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        
        public static ListNode buildList(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for(int val : arr){
            	ListNode node = new ListNode(val);
            	curr.next = node;
            	curr = curr.next;
            }
            return dummy.next;
        }

        public static String fromListToString(ListNode head) {
            if (head == null) {
                return "{}";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            while(head!=null && head.next!=null){
            	sb.append(head.val + ",");
            	head = head.next;
            }
            if(head.next == null) sb.append(head.val +"");
            
            sb.append("}");
            return sb.toString();
        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
