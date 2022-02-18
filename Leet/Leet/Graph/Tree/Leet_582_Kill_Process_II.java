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

import Utils.SU;

/**
Input: 
pid =  [1, 3, 10, 5, 4]
ppid = [3, 0, 5, 3, 5]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.

 *
 */
public class Leet_582_Kill_Process_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("323. Number of Connected Components in an Undirected Graph\n" + 
				"");
		List<Integer> pidList = Arrays.asList(1, 3, 10, 5, 4);
		List<Integer> ppidList= Arrays.asList(3, 0, 5, 3, 5);
		int kill = 44;
		System.out.println(""+findRoot(pidList, ppidList, kill));
	}

//	How about to find Root,
	public static Integer findRoot(List<Integer> pidList, List<Integer> ppidList, int pid) {
		if(pid <= 0) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<>();//PID to index Map
        int size = pidList.size();
		for (int i = 0; i < size; i++) {
			map.put(pidList.get(i), i);
		}
		Integer index = map.get(pid);//not found in list
		if(index == null) {
			//not found
			return -1;
		}
		while(ppidList.get(index) != 0) {//possible: NullPointerException
			pid = ppidList.get(index);
			index = map.get(pid);
		}
		return pidList.get(index);
	}

//	public static Integer findRoot(List<Integer> pidList, List<Integer> ppidList, int pid) {
//		Map<Integer, Integer> map = new HashMap<>();//PID to index Map
//        int size = pidList.size();
//		for (int i = 0; i < size; i++) {
//			if(pidList.get(i) == pid) {
////				int index = i;
//				while(ppidList.get(i) != 0) {
//					pid = ppidList.get(i);
//					i = map.get(pid);
//				}
//				break;
//			}
//		}
//		return pidList.get(i);
//	}

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

}
