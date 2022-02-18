package LeetCode.Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Utils.GraphNode;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class FindAllPaths4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 TreeNode<Integer>  treeNode = TreeNodeUtils.COMPLETE_TREE;
//		 TreeNodeUtils.printTree(treeNode);
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
//		graph.put(node2, neis);
		node2.neighbors = neis;
		
		neis = new ArrayList<>();
		neis.add(node5);
		neis.add(node6);
//		graph.put(node3, neis);
		node3.neighbors = neis;
		
		neis = new ArrayList<>();
		neis.add(node5);
		neis.add(node6);
//		graph.put(node4, neis);
		node4.neighbors = neis;

		neis = new ArrayList<>();
		neis.add(node6);
//		graph.put(node5, neis);
		node5.neighbors = neis;
		
		neis = new ArrayList<>();
//		graph.put(node6, neis);
		node6.neighbors = neis;

		
//		neis = new ArrayList<>();
//		neis.add(node2);
//		neis.add(node3);
//		neis.add(node4);
//		neis.add(node5);
//		graph.put(node6, neis);
		
		System.out.println("graph:"+graph);
		System.out.println("node2:"+node2.toNeis());
		System.out.println("node3:"+node3.toNeis());
		System.out.println("node4:"+node4.toNeis());
		System.out.println("node5:"+node5.toNeis());
		System.out.println("node6:"+node6.toNeis());

//		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node2);
//		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node5);
		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node6);
//		List<List<GraphNode>> allPaths = findAllPaths(graph, node3, node6);
//		List<List<GraphNode>> allPaths = findAllPaths(graph, node2, node5);
		System.out.println("allPaths:"+allPaths);
//		print(allPaths);
		
	}

	private static List<List<GraphNode>> findAllPaths(Map<GraphNode, List<GraphNode>> graph, GraphNode root,
			GraphNode target) {
		List<List<GraphNode>> allPaths = new ArrayList<>();
		List<GraphNode> path = new LinkedList<>();
		Set<GraphNode> visited = new HashSet<>();
		dfs(allPaths, path, visited, graph, root, target);
		return allPaths;
	}

	private static void dfs(List<List<GraphNode>> allPaths,List<GraphNode> path, Set<GraphNode> visited, Map<GraphNode, List<GraphNode>> graph, GraphNode root,
			GraphNode target) {
		if(root == null) {
			return;
		}
		if(!visited.add(root)) {
			return;
		}
//		path.add(root);
		path.add(0, root);
		System.out.println("path:"+path);
		if(root == target) {
			System.out.println("collect:...");
			allPaths.add(new ArrayList<>(path));
//			return;
		}
		
//		if(root.equals(target)) {

		for (GraphNode nei : root.neighbors) {
//		for (GraphNode nei : graph.get(root)) {
			System.out.println("root:nei "+root.key+":"+nei.key);
//			dfs(allPaths, path, visited, graph, nei, target);
			dfs(allPaths, path, visited, graph, nei, target);
		}
//		path.remove(path.size() - 1);
		path.remove(0);
		visited.remove(root);
	}
}
