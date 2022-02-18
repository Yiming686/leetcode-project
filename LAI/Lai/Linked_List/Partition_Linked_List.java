package Lai.Linked_List;

import java.util.Arrays;

import Utils.ListNodeUtils;
import Utils.ListNodeUtils.ListNode;
import Utils.ListNodeUtils.CycleList;
import Utils.ArrayUtils;

public class Partition_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArrayNoDup(9, -20, 20);
		System.out.println(""+Arrays.toString(arr));
//		int[] arr = ArrayUtils.generateIntArrayNoDup(9, -20, 20);
//		int[] arr = {2, -10, 12, -2, -8, -4, -9, -17, 11};
		
		ListNode<Integer> head = ListNodeUtils.buildLinkedList(ArrayUtils.convertIntArr2IntegerArr(arr));
		ListNodeUtils.printList(head);
		ListNodeUtils.printList(partition(head, 8));

	}

	  public static ListNode<Integer> partition(ListNode<Integer> head, int target) {
		    // Write your solution here
		    if(head == null || head.next == null){
		      return head;
		    }
		    ListNode less = new ListNode(0);
		    ListNode greater = new ListNode(0);
		    ListNode currLess = less;
		    ListNode currGreater = greater;
		    while(head != null){
		      if(head.val < target){
		        currLess.next = head;
		        currLess = currLess.next;
		      }else{
		        currGreater.next = head;
		        currGreater = currGreater.next;
		      }
		      head = head.next;
		    }
		    ListNodeUtils.printList(less);
		    ListNodeUtils.printList(greater);
		    currLess.next = greater.next;
		    currGreater.next = null;
		    
		    head = less.next;
		    less.next = null;
		    greater.next = null;
		    return head;
		  }

}
