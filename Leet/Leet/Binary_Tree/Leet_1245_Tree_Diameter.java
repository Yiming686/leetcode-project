package Leet.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Leet_1245_Tree_Diameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	Time: O(N), Space: (N)
//	which to pick to save neighbors, Set or List
	public int treeDiameter(int[][] edges) {
		if (edges == null || edges.length == 0) {
			return 0;
		}
		int len = edges.length + 1;//for a tree, number of nodes = num of edges + 1
		// Set<Integer>[] neis= new HashSet[len]; 
		List<Integer>[] neis = new ArrayList[len];
		boolean[] visited = new boolean[len];
		for (int i = 0; i < len; i++) {
			// neis[i] = new HashSet<>();
			neis[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			neis[edge[0]].add(edge[1]);
			neis[edge[1]].add(edge[0]);
		}
		int[] longest = new int[1];// by default, 0
		dfs(longest, neis, visited, edges[0][0]);
		return longest[0];
	}

	// given node, need to know the longest path starting from itself
//     if visited, return -1; if not, but no children, return 0;
	// private int dfs(int[] longest, Set<Integer>[] neis, boolean[] visited, int curr){
	private int dfs(int[] longest, List<Integer>[] neis, boolean[] visited, int curr) {
		if (visited[curr]) {
			return -1;//0;//-1;//or -1
		}
		visited[curr] = true;
		int max = 0;//Integer.MIN_VALUE;
		int secondMax = 0;
		for (int nei : neis[curr]) {
			int lenOfPath = 1 + dfs(longest, neis, visited, nei);//do not forget plus 1
			if (lenOfPath >= max) {
				secondMax = max;
				max = lenOfPath;
			} else if (lenOfPath >= secondMax) {
				secondMax = lenOfPath;
			}
		}
		longest[0] = Math.max(longest[0], max + secondMax);
		return max;
	}

}
