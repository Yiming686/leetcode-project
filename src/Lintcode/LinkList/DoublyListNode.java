package Lintcode.LinkList;

public class DoublyListNode {

    int val;
    DoublyListNode next;
    DoublyListNode prev;
    DoublyListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    
//    public static String fromListToString(DoublyListNode head) {
//        if (head == null) {
//            return "{}";
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("{");
//        while(head!=null && head.next!=null && head.next!=tail){
//        	sb.append(head.val + "-->");
//        	head = head.next;
//        }
//        if(head.next == null) sb.append(head.val +"");
//        
//        sb.append("}");
//        return sb.toString();
//    }
//
//    public static DoublyListNode fromStringToList(String str) {
//    	if(str == null || str.length() == 0) return null;
//    	String[] arr = str.split(",");
//    	DoublyListNode dummy = new DoublyListNode(0);
//    	DoublyListNode node = dummy;
//    	for(String s : arr){
//    		node.next = new DoublyListNode(Integer.valueOf(s.trim()));
//    		node = node.next;
//    	}
//    	return dummy.next;
//    	
//    }
//    public static void main(String[] args) {
//		// TODO Auto-generated method stub
//    	DoublyListNode list = fromStringToList(" 4  ,   2 ,   5   , 77   ,   33   ");
//    	System.out.println(""+DoublyListNode.fromListToString(list));;
//    	DoublyListNode toAdd = new DoublyListNode(54);
////    	list.addNodeToList(toAdd);
////    	System.out.println(""+DoublyListNode.fromListToString(list));;
//    	System.out.println(""+DoublyListNode.fromListToString(head));;
//
//	}
//    
//    static DoublyListNode head = new DoublyListNode(-1);// points to first node
//    static DoublyListNode tail = new DoublyListNode(-1); // points to the last node
//
//    static {
//		head.next = tail;
//		tail.prev = head;
//		head.prev = tail;
//		tail.next = head;
//	}
//
//	// addNodeToList() - add the inputted node to the end of the list
//	// - if the node is already in the list, move it to the end
//	// - HINT moving a node to the end is the same as removing and adding to the
//	// end
//	public static void addNodeToList(DoublyListNode toAdd) {
//		System.out.println("start:"+DoublyListNode.fromListToString(head.next));;
//		if (toAdd == null)
//			return;
//
//		if (head.next != tail) {
//			DoublyListNode curr = head;
//			DoublyListNode next = head.next;
//			while (next != tail) {
//				if (next == toAdd) {
//					// remove the node
//					curr.next = next.next;
//					next.next.prev = curr;
//					break;
//				}
//				curr = next;
//				next = next.next;
//			}
//			// add to the end
//			tail.prev.next = next;
//			next.prev = tail.prev;
//			next.next = tail;
//			tail.prev = next;
//
//		} else {
//			// if list is empty, add node
//			head.next = toAdd;
//			toAdd.prev = head;
//			toAdd.next = tail;
//			tail.prev = toAdd;
//		}
//    	System.out.println(" end:"+DoublyListNode.fromListToString(head.next));;
//
//	}
//
//	// removeNode() - remove the inputted node
//	// - if the node is not in the list do nothing
//	public  static void removeNode(DoublyListNode toRemove) {
//		if (toRemove == null)
//			return;
//		if (head.next == tail)
//			return;
//		DoublyListNode curr = head;
//		DoublyListNode next = head.next;
//		while (next != tail) {
//			if (next == toRemove) {
//				// remove the node
//				curr.next = next.next;
//				next.next.prev = curr;
//				break;
//			}
//			curr = next;
//			next = next.next;
//		}
//		return;
//	}
//
//	// popNodeFromStart() - remove the node at the start of the list and return
//	// it
//	public static  DoublyListNode popNodeFromStart() {
//		if (head.next == tail)
//			return null;
//		DoublyListNode node = head.next;
//		head.next = node.next;
//		head.next.prev = head;
//		return node;
//
//	}
//
//	// popNodeFromEnd() - remove the node at the end of the list and return it
//	public  static DoublyListNode popNodeFromEnd() {
//		if (head.next == tail)
//			return null;
//		DoublyListNode node = tail.prev;
//		node.prev.next = tail;
//		tail.prev = node.prev;
//		return node;
//	}


}
