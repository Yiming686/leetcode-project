package LeetCode.Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Utils.GraphNode;

public class FindAllPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<GraphNode, List<GraphNode>> graph = new HashMap<GraphNode, List<GraphNode>>();
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		GraphNode node6 = new GraphNode(6);
		
		List<GraphNode> neis = null;
		neis = new ArrayList<>();
		neis.add(node3);
		neis.add(node4);
		neis.add(node5);
		neis.add(node6);
		graph.put(node2, neis);
		
		neis = new ArrayList<>();
		neis.add(node5);
		neis.add(node6);
		graph.put(node3, neis);
		
		neis = new ArrayList<>();
		neis.add(node5);
		neis.add(node6);
		graph.put(node4, neis);

		neis = new ArrayList<>();
		neis.add(node6);
		graph.put(node5, neis);
		
		neis = new ArrayList<>();
		graph.put(node6, neis);

		
//		neis = new ArrayList<>();
//		neis.add(node2);
//		neis.add(node3);
//		neis.add(node4);
//		neis.add(node5);
//		graph.put(node6, neis);
		
		System.out.println("graph:"+graph);

//		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node5);
//		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node6);
		List<List<GraphNode>> allPaths = findAllPaths(graph, node3, node6);
//		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node5);
		System.out.println("allPaths:"+allPaths);
//		print(allPaths);
		
	}

	private static List<List<GraphNode>> findAllPaths(Map<GraphNode, List<GraphNode>> graph, GraphNode root,
			GraphNode target) {
		List<List<GraphNode>> allPaths = new ArrayList<>();
		List<GraphNode> path = new ArrayList<>();
		Set<GraphNode> visited = new HashSet<>();
		dfs(allPaths, path, visited, graph, root, target);
		return allPaths;
	}

	private static void dfs(List<List<GraphNode>> allPaths,List<GraphNode> path, Set<GraphNode> visited, Map<GraphNode, List<GraphNode>> graph, GraphNode root,
			GraphNode target) {
//		if() {
//			
//		}
		if(!visited.add(root)) {
			return;
		}
//		if(root.key == target.key) {
//			System.out.println("collect:...");
//			path.add(root);
//			allPaths.add(new ArrayList<>(path));
//			path.remove(path.size() - 1);
//			return;
//		}
		path.add(root);
		System.out.println("path:"+path);
		if(root.key == target.key) {
			System.out.println("collect:...");
			allPaths.add(new ArrayList<>(path));
//			return;
		}
		
//		if(root.equals(target)) {

//		for (GraphNode nei : root.neighbors) {
		for (GraphNode nei : graph.get(root)) {
			System.out.println("root:nei "+root.key+":"+nei.key);
			dfs(allPaths, path, visited, graph, nei, target);
		}
		path.remove(path.size() - 1);
		visited.remove(root);
	}
}
