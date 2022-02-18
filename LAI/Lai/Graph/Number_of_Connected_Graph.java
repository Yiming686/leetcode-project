package Lai.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Number_of_Connected_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 12;
//		int n = 7;
		int n = 10;
//		int[][] edges = new int[][]{{8,11},{5,11},{5,9},{6,9},{0,7},{1,4},{3,4},{4,8},{2,7},{1,5},{3,5},{7,10},{6,10},{2,5},{0,9},{6,7},{1,11},{8,9},{1,10},{2,4}};
//		int[][] edges = {{0,1},{1,2},{3,4}};
//		int[][] edges = new int[][] { { 2, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		int[][] edges = new int[][]{{0,6},{0,2},{4,5},{0,3},{1,4},{1,9},{3,7},{5,7},{3,5},{6,8},{4,8},{7,9},{2,8}};

//		System.out.println("" + countComponents_bfs(n, edges));
		System.out.println("" + countComponents_dfs(n, edges));
//		System.out.println("" + countComponents_uf(n, edges));
	}

//--- BFS ---------------------------------------------------------------------------------------	
	public static int countComponents_bfs(int n, int[][] edges) {
		// Write your solution here
		//build graph
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] arr : edges) {
			Set<Integer> set = map.get(arr[0]);
			if (set == null) {
				set = new HashSet<Integer>();
				map.put(arr[0], set);
			}
			set.add(arr[1]);
//		        set = map.get(arr[1]);
//		        if(set == null){
//		          set = new HashSet<Integer>();
//		          map.put(arr[1], set);
//		        }
//		        set.add(arr[0]);
		}
		System.out.println("map:" + map);
		int count = 0;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new ArrayDeque<>();
//		    for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
		for (int label = 0; label < n; label++) {
//		    		Map.Entry<Integer, Set<Integer>> entry : m
			if (!visited.contains(label)) {
				System.out.println("visited:" + visited);
				System.out.println("label:" + label);
				count++;
				queue.offer(label);
				visited.add(label);
				while (!queue.isEmpty()) {
					int size = queue.size();
					for (int i = 0; i < size; i++) {
						Integer val = queue.poll();
						if (map.get(val) == null) {
							continue;
						}
						for (Integer nei : map.get(val)) {
							if (!visited.contains(nei)) {
								queue.offer(nei);
								visited.add(nei);
							}
						}
					}
				}
			}
		}
		return count;
	}
	
//	--- DFS ---------------------------------------------------------------------------------------
    public static int countComponents_dfs(int n, int[][] edges) {
        if(n <= 1) return n;
        Map<Integer, List<Integer>> map = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(i, map, visited);
            }
        }
        return count;
    }
    
    private static Map<Integer, List<Integer>> buildGraph(int n, int[][] edges){
    		Map<Integer, List<Integer>> map = new HashMap<>();
    		for(int i = 0; i < n; i++) {
    			map.put(i, new ArrayList<Integer>());
    		}
    		for(int[] arr: edges) {
    			map.get(arr[0]).add(arr[1]);
    			map.get(arr[1]).add(arr[0]);
    		}
    		return map;
    }
    
    private static void dfs(int label, Map<Integer, List<Integer>> map, boolean[] visited){
	    	if(visited[label]) {
	    		return;
	    	}
        visited[label] = true;
        for(int nei : map.get(label)){
            dfs(nei, map, visited);
        }
    }


//--- Union Find ---------------------------------------------------------------------------------------
	static class UnionFind {
		int[] parent = null;
		int count = 0;

		public UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			count = n;
		}

		public void union(int i, int j) {
			int x = find(i);
			int y = find(j);
			if (x == y)
				return;
			else {
				parent[y] = x;
				count--;
			}
		}

		public int find(int p) {
			while (parent[p] != p) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}
	}

	public static int countComponents_uf(int n, int[][] edges) {

		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}
		return uf.count;
	}

}
