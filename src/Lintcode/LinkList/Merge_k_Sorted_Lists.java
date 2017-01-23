package Lintcode.LinkList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

Tags 
Divide and Conquer Linked List Priority Queue Heap Uber Google Twitter LinkedIn Airbnb Facebook
Related Problems 
Easy Merge Two Sorted Arrays 35 %
Medium Ugly Number II 23 %


 *
 */
public class Merge_k_Sorted_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(-1);
		List<ListNode> lists = new LinkedList<ListNode>();
		lists.add(node1);
		lists.add(null);
//		lists.add(node2);
//		lists.add(node1);
		lists.add(null);
		lists.add(node2);
		ListNode list = mergeKLists(lists);
		System.out.println(""+ListNode.convertToString(list));
	}

    public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.isEmpty()){
            return null;
        }
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });
        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.offer(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
    
}
