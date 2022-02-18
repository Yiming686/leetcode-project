package Lai.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lai_417_Course_Schedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// Write your solution here
		Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);
		Set<Integer> roots = new HashSet<>();
		for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
			if (entry.getValue().size() == 0) {
				roots.add(entry.getKey());
			}
		}
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new ArrayDeque<>();
		queue.addAll(roots);
		visited.addAll(roots);
		while(!queue.isEmpty()) {
			Integer course = queue.poll();
			for(Integer p : graph.get(course)) {
				if(visited.add(p)) {
					queue.offer(p);
				}
			}
		}
		if(visited.size() == numCourses) {
			return true;
		}
		return false;		

	}

	private Map<Integer, Set<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		for (int[] p : prerequisites) {
			graph.get(p[0]).add(p[1]);
		}
		return graph;
	}

}
