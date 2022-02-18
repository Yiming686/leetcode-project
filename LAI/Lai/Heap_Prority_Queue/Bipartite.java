package Lai.Heap_Prority_Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import Utils.GraphNode;

public class Bipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//��һ��ͼ��û���⣬��������������AB, A����Ķ���ֻ��ָ��B����Ķ��㣬B����Ķ���ֻ��ָ������Ķ��㣬
	public boolean isBipartite(List<GraphNode> graph) {
		// write your solution here
		Map<GraphNode, Integer> visited = new HashMap<>();
		for (GraphNode node : graph) {
			if (!isBipartite(node, visited)) {
				return false;
			}
		}
		return true;
	}

	//������ڵ������ͼ���ǲ��� bipartite�� �Ƿ���true������false
	private static boolean isBipartite(GraphNode node, Map<GraphNode, Integer> visited) {
		if (node == null) {
			//???
		}
		if(visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<>();
		visited.put(node, 0);
		queue.offer(node);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = visited.get(cur);
			int neiGroup = curGroup == 0 ? 1 : 0;
			for (GraphNode nei : cur.neighbors) {
				if (!visited.containsKey(nei)) {
					visited.put(nei, neiGroup);
					queue.offer(nei);
				} else if (visited.get(nei) != neiGroup) {
					return false;
				}
			}
		}
		return false;
	}

}
