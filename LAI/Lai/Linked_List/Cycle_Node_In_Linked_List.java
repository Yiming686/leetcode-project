package Lai.Linked_List;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;
import Utils.ListNodeUtils.CycleList;

public class Cycle_Node_In_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 1;
		int n = 16;
		ListNode head1 = ListNodeUtils.buildLinkedList(m, n);
		ListNodeUtils.printList(head1);
		System.out.println("\nhasCycle: "+ListNodeUtils.hasCycle(head1));
		CycleList cycleList2 = ListNodeUtils.buildCycleList(m, n);
		System.out.println("\nhasCycle: "+ListNodeUtils.hasCycle(cycleList2.headOfCycle));
		
//		System.out.println("mid: "+ListNodeUtils.findMiddle(head1).val);
//		CycleList cycleList1 = ListNodeUtils.buildCycleList(1, n);
//		ListNodeUtils.printCycleList(cycleList1);
//		CycleList cycleList2 = ListNodeUtils.buildCycleList(m, n);
//		ListNodeUtils.printCycleList(cycleList2);
//		
//		System.out.println("EntryOfCycle: "+cycleNode(cycleList1.headOfLine).val);
//		System.out.println("EntryOfCycle: "+cycleNode(cycleList2.headOfLine).val);
	}

	public static ListNode cycleNode(ListNode head) {
		// write your solution here
		if(head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		System.out.println("slow:fast " + slow.val +":" + fast.val);
		if(fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while(slow != fast) {
			System.out.println("slow:fast " + slow.val +":" + fast.val);
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	//因为fast早先一步，所以最后差一步
    public static ListNode cycleNode22(ListNode head) {
        if(head == null ){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(slow == null || fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        slow = slow.next;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
