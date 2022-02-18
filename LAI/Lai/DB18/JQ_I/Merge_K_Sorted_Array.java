package Lai.DB18.JQ_I;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] merge(int[][] arrayOfArrays) {
		// Write your solution here
		if(arrayOfArrays == null) {
			return null;
		}
//		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}			
		});
		int len = 0;
		for(int i = 0; i < arrayOfArrays.length; i++) {
			len += arrayOfArrays[i].length;
			if(arrayOfArrays[i].length != 0) {
				pq.offer(new Node(i,0, arrayOfArrays[i][0]));				
			}
		}
		int[] result = new int[len];
		int i = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			result[i++] = node.val;
			if(node.y + 1 < arrayOfArrays[node.x].length) {
				pq.offer(new Node(node.x, node.y + 1, arrayOfArrays[node.x][node.y  + 1]));
			}
		}
		return result;		
	}

	static class Node {
		int x;//row
		int y;//col
		int val;

		Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

	}

}
