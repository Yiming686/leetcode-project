package Leet.Graph.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leet_582_Kill_Process {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> pidList = Arrays.asList(1, 3, 10, 5);
		List<Integer> ppidList= Arrays.asList(3, 0, 5, 3);
		int kill = 3;
		System.out.println(""+killProcess(pidList, ppidList, kill	));
	}

	public static List<Integer> killProcess(List<Integer> pidList, List<Integer> ppidList, int kill) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();//PID to PIDS, parent to children
		int size = pidList.size();
		for (int i = 0; i < size; i++) {
			Set<Integer> children = map.getOrDefault(ppidList.get(i), new HashSet<>());
			children.add(pidList.get(i));
			map.put(ppidList.get(i), children);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(kill);
		while (!queue.isEmpty()) {
			Integer pid = queue.poll();
			result.add(pid);
			if (map.containsKey(pid)) {
				for (Integer childPid : map.get(pid)) {
					queue.offer(childPid);
				}
			}
		}
		return result;
	}
	

	public static List<Integer> killProcess2(List<Integer> pidList, List<Integer> ppidList, int kill) {
		String[] pidArr = pidList.stream().toArray(String[]::new);
		String[] ppidArr = ppidList.stream().toArray(String[]::new);

		List<Integer> result = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();//PID to PIDS, parent to children
		int size = pidList.size();
		for (int i = 0; i < size; i++) {
			Set<Integer> children = map.getOrDefault(ppidList.get(i), new HashSet<>());
			children.add(pidList.get(i));
			map.put(ppidList.get(i), children);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(kill);
		while (!queue.isEmpty()) {
			Integer pid = queue.poll();
			result.add(pid);
			if (map.containsKey(pid)) {
				for (Integer childPid : map.get(pid)) {
					queue.offer(childPid);
				}
			}
		}
		return result;
	}


}
