package Lai.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Utils.ArrayUtils;
import Utils.GraphNode;

public class Is_Bipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<GraphNode> graph = new ArrayList<GraphNode>();
//		GraphNode node0 = new GraphNode(0);
//		GraphNode node1 = new GraphNode(1);
////		node0.neighbors = new ArrayList<GraphNode>();
////		node1.neighbors = new ArrayList<GraphNode>();
//		node0.neighbors.add(node1);
//		node1.neighbors.add(node0);
//		graph.add(node0);
//		graph.add(node0);
		ArrayUtils.convertSquareBracketStr2CurlyBraceStr("[[1,3],[0,2],[1,3],[0,2]]");
		int[][] edges = {{1,3},{0,2},{1,3},{0,2}};
		System.out.println(""+isBipartite(edges));
	}

    public static boolean isBipartite(int[][] edges) {
        
        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, Set<Integer>> graph = buildGraph(edges);        
        for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()){
          if(!isBipartite(entry.getKey(), map.get(entry.getKey()) == null ? true : map.get(entry.getKey()), graph, map)){
            return false;
          }
        }
        return true;
    }
    
    private static boolean isBipartite(Integer node, Boolean isTrue, Map<Integer, Set<Integer>> graph, Map<Integer, Boolean> map){
        if(map.containsKey(node)){
          return map.get(node) == isTrue;
        }
        map.put(node, isTrue);
        for(Integer nei : graph.get(node)){
          if(!isBipartite(nei, !isTrue, graph, map)){
            return false;
          };
        }
        return true;
    }

    private static Map<Integer, Set<Integer>> buildGraph(int[][] edges){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j = 0; j < edges[i].length; j++){
                set.add(edges[i][j]);
            }
            map.put(i, set);            
        }
        return map;
    }

}
