package Lai.DB18.JQ_I;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Lai.DB18.JQ_I.Merge_K_Sorted_Array.Node;
import Utils.ListNodeUtils.ListNode;

public class Merge_K_Sorted_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode merge(List<ListNode> listOfLists) {
		if(listOfLists == null) {
			return null;
		}
//		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode<Integer>>() {
			@Override
			public int compare(ListNode<Integer> o1, ListNode<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}			
		});
//		int len = 0;
		for(int i = 0; i < listOfLists.size(); i++) {
//			len += listOfLists[i].length;
//			if(arrayOfArrays[i].length != 0) {
//				pq.offer(new Node(i, listOfLists.get(i).val));
				pq.offer(listOfLists.get(i));
//			}
		}
		ListNode dummy = new ListNode(0);
		ListNode curr  = dummy; 
		while(!pq.isEmpty()) {
			ListNode node = pq.poll();
			curr.next = node;
			if(node.next != null) {
				pq.offer(node.next);
			}
			curr = curr.next;
		}
		return dummy.next;		
	}


}
