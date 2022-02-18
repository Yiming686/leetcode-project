package Leet.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_684_Redundant_Connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{1,2}, {1,3}, {2,3}};
		findRedundantConnection(edges);
	}
    public static int[] findRedundantConnection(int[][] edges) {
        if(edges == null){
            return null;
        }
        if(edges.length == 0){
            return new int[2];
        }
     	Map<Integer, Set<Integer>> graph = new HashMap();
     	for (int[] e : edges) {
     	    if (dfs(graph, e[0], e[1], new HashSet<>())){
                return e;
            } 
     	    graph.getOrDefault(e[0], new HashSet<>()).add(e[1]);
            graph.getOrDefault(e[1], new HashSet<>()).add(e[0]);    
     	}
        return new int[]{0,0}; 
    }
    
    private static boolean dfs(Map<Integer, Set<Integer>> graph, int a, int b, Set<Integer> visited){
        // if(a == null){
        //     return false;
        // }
        if(!visited.add(a)){
            return false;
        }
        if(a == b){
            return true;
        }
        if(graph.get(a) == null){
            return false;
        }
        for(Integer nei : graph.get(a)){
            if(dfs(graph, nei, b, visited)){
                return true;
            }
        }
        return false;
    }

}
