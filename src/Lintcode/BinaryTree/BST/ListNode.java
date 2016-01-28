package Lintcode.BinaryTree.BST;

public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
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
