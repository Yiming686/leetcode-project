package Leet.XXB.Interview.Day_07112020;

import Utils.ArrayUtils;
import apple.laf.JRSUIConstants.Size;

public class Largest_Weight_Sum_with_ID_Diff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 6;
		int min = 1;
		int max = 50;
		int[] ids = ArrayUtils.buildIntArray(size, min, max);
		int[] weights = ArrayUtils.buildIntArray(size, min, max);
		Node[] nodes = new Node[size];
		for(int i = 0; i < size; i++) {
			nodes[0] = new Node(ids[i], weights[i]);
		}
		
		int largest = largestWeightSum(nodes);
		System.out.println("Largest Weight Sum:" + largest);
	}
	
	private static int largestWeightSum(Node[] nodes) {
		return 0;
		
	}

	static class Node{
		private int id;
		private int weight;
		public Node(int id, int weight) {
			this.id = id;
			this.weight = weight;
		}
	}

}
