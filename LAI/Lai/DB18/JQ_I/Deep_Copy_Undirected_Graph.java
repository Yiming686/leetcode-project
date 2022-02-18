package Lai.DB18.JQ_I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import Lai.DFS_I.Dfs_Test;
import Utils.GraphNode;

public class Deep_Copy_Undirected_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<GraphNode> copy(List<GraphNode> graph) {
		// Write your solution here.
		if (graph == null) {
			return null;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			dfs(node, map);
		}
		return new ArrayList<>(map.values());
	}

	private static void dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
		if (map.containsKey(node)) {//visited
			return;
		}
		GraphNode copy = new GraphNode(node.key);
		map.put(node, copy);//mark visited
		for (GraphNode nei : node.neighbors) {
			dfs(nei, map);
			copy.neighbors.add(map.get(nei));
		}
	}

//	static class GraphNode {
//		public int key;
//		public List<GraphNode> neighbors;
//
//		public GraphNode(int key) {
//			this.key = key;
//			this.neighbors = new ArrayList<GraphNode>();
//		}
//	}

}
