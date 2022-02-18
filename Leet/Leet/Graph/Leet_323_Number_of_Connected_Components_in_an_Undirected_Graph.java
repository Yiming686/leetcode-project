package Leet.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leet_323_Number_of_Connected_Components_in_an_Undirected_Graph {
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{2,4},{2,1},{2,4},{2,1}};
		System.out.println(""+countComponents(n, edges));
	}

//  build graph, not change each node, mark if visited for each node via dfs traversal
	public static int countComponents(int n, int[][] edges) {
		if (n < 1) {
			return 0;
		}		
		if (edges == null || edges.length == 0 || edges[0].length == 0) {
			return n;
		}
		// Map<Integer, List<Integer>> map = buildGraph2(n, edges);  //not best
		Set<Integer>[] arrOfSet = buildGraph2(n, edges);
		// Set<Integer> visited = new HashSet<>();   //not best
		boolean[] visited = new boolean[n];
		//how to count via dfs traversal
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				dfs2(arrOfSet, i, visited);
				// bfs2(arrOfSet, i, visited);
			}
		}
		return count;
	}

	// 1-2,1-2,1-2,
	private static Set<Integer>[] buildGraph2(int n, int[][] edges) {
		Set<Integer>[] arrOfSet = new HashSet[n];
		for (int i = 0; i < n; i++) {
			arrOfSet[i] = new HashSet<>();
		}
		for (int[] edge : edges) {
			arrOfSet[edge[0]].add(edge[1]);
			arrOfSet[edge[1]].add(edge[0]);
		}
		return arrOfSet;
	}

	//mark visited 1, mark visited 2, mark visited 3, differences
//1: direct traversal, do sth, to neighbors
//2: check if a cycle, if visited, return; set visiting; set visited
//3: to find path, backtracking
//to pick one, mark visited
	private static void dfs2(Set<Integer>[] arrOfSet, int curr, boolean[] visited) {
		if (visited[curr]) {
			return;
		}
		visited[curr] = true;
		for (Integer nei : arrOfSet[curr]) {
			dfs2(arrOfSet, nei, visited);
		}
	}

	private static void bfs2(Set<Integer>[] arrOfSet, int root, boolean[] visited) {
		if (visited[root]) {
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		visited[root] = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			Integer node = queue.poll();
			for (Integer nei : arrOfSet[node]) {
				if (!visited[nei]) {
					visited[nei] = true;
					queue.offer(nei);
				}
			}
		}
	}

}
