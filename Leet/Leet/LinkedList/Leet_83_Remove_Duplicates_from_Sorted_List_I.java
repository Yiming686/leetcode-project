package Leet.LinkedList;

import static Utils.ListNodeUtils.printList;

import Utils.ListNodeUtils.ListNode;

public class Leet_83_Remove_Duplicates_from_Sorted_List_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = buildList();
		head = buildList(); printList(head);
		head = buildList(); printList(deleteDuplicates(head));//s=f=h
		head = buildList(); printList(deleteDuplicates_v21(head));//s, f=s.next
		head = buildList(); printList(deleteDuplicates_v22(head));//s=f=dummy
		int k = 2;
		head = buildList(); printList(deleteDuplicatesKeepKValues_v31(head, k));//s=f=dummy
		head = buildList(); printList(deleteDuplicatesKeepKValues_v32(head, k));//s=f=dummy
		
	}
	private static ListNode buildList() {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		curr.next = new ListNode(1);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(2);curr = curr.next;
		curr.next = new ListNode(4);curr = curr.next;
		curr.next = new ListNode(4);curr = curr.next;
		curr.next = new ListNode(4);curr = curr.next;
		curr.next = new ListNode(4);curr = curr.next;
		curr.next = new ListNode(4);curr = curr.next;
		curr.next = new ListNode(6);curr = curr.next;
		curr.next = new ListNode(8);curr = curr.next;
		curr.next = new ListNode(8);curr = curr.next;
		curr.next = new ListNode(8);curr = curr.next;
//		curr.next = new ListNode(8);curr = curr.next;
		curr.next = new ListNode(9);curr = curr.next;
		curr.next = new ListNode(9);curr = curr.next;
		return head;
	}
	public static ListNode deleteDuplicatesKeepKValues_v32(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value
			int count = 0;
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				count++;
				if(count <= k ) {
					slow = slow.next;
				}
				fast = fast.next;
			}
			//fast points to last pos for curr val
			if(k == 0) {//一个不留
				if (fast == slow.next) {//一个不留，但是此时没有重复的，可以留
					slow = slow.next;
				}else {//有重复的
					slow.next = fast.next;
					//slow不动，什么也不做
				}
			}else {//顶多留1个或者多个
				if (fast == slow.next) {//但是此时没有重复的，可以留
					slow = slow.next;
				}else {
					slow.next = fast.next;
					//slow不动，什么也不做
				}
			}
//			if (fast != slow.next) {//only one node of this val
//				slow.next = fast.next;
//				slow = fast;
//			} else {//more than one nodes of this val, NOTE, do NOT change slow
//				slow = slow.next;
//			}
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}

	public static ListNode deleteDuplicatesKeepKValues_v31(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = head;
		ListNode fast = head;
//		ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value
			int count = 1;
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				fast = fast.next;
				count++;
				if(count <= k) {
					slow = fast;
				}
			}
			//fast points to last pos for curr val
			if (fast != slow) {//only one node of this val
//				slow = slow.next;
//			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			slow = slow.next;
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}

	public static ListNode deleteDuplicatesKeepKValues_00(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = head;
		ListNode fast = head;
//		ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value
			int count = 1;
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				fast = fast.next;
				count++;
				if(count <= k) {
					slow = fast;
				}
			}
			//fast points to last pos for curr val
			if (fast != slow) {//only one node of this val
//				slow = slow.next;
//			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			slow = slow.next;
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}

	public static ListNode deleteDuplicates_v22(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
//		ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value 
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				fast = fast.next;
			}
			//fast points to last pos for curr val
			if (fast == slow.next) {//only one node of this val
				slow = slow.next;
			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}

	public static ListNode deleteDuplicates_v21(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = slow.next;//for each iteration, fast so far always points to the last pos of current value
		while (fast != null) {//use fast to traverse list and count the number of current value 
			while (fast.next != null && fast.next.val == fast.val) {//find next pos where val changed
				fast = fast.next;
			}
			//fast points to last pos for curr val
			if (fast == slow.next) {//only one node of this val
				slow = slow.next;
			} else {//more than one nodes of this val, NOTE, do NOT change slow
				slow.next = fast.next;
			}
			fast = fast.next;
		}
		//question: where is slow? last possible unique value 
		return dummy.next;//might not be head, head is also could be deleted
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode slow = dummy;
        //slow point to first, fast to the last, then slow.next = fast.next
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){//use fast to traverse list and count the number of current value 
            while(fast.next != null && fast.next.val == fast.val){
                fast = fast.next;
            }
            // fast points to last pos for curr val
            if(fast != slow){//only one node of this val
                // slow = slow.next;
            // }else{//more than one nodes of this val, NOTE, do NOT change slow
                // slow = fast.next;
                slow.next = fast.next;
                
            }
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }

}
