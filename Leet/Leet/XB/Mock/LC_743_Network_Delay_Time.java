package Leet.XB.Mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import Utils.ArrayUtils;

public class LC_743_Network_Delay_Time {

	public static void main(String[] args) {
//		[[2,1,1],[2,3,1],[3,4,1]]
//				4
//				2		
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int n = 4;
		int k = 2;
		int longest= networkDelayTime(times, n, k);
		
		System.out.println(""+longest);
	}
	
    public static int networkDelayTime(int[][] times, int n, int k) {
        if(times == null){
            return -1;
        }
        Map<Integer, Map<Integer, Integer>> graph = buildGraph(times, n);
        int[] shortestTimeArr = new int[n];
        Arrays.fill(shortestTimeArr, Integer.MAX_VALUE);
        shortestTimeArr[k-1] = 0;
        dijkstra(graph, n, k, shortestTimeArr);
        ArrayUtils.print(shortestTimeArr);
        int longest = 0;
        for(int shortestTime: shortestTimeArr){
            if(shortestTime == Integer.MAX_VALUE ){
                return -1;
            }
            longest = Math.max(longest, shortestTime);
        }
        return longest;
    }
    
    private static  Map<Integer, Map<Integer, Integer>> buildGraph(int[][] times, int n){
        if(times == null){
            return null;
        }   
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int i = 0; i < times.length; i++){
            Map<Integer, Integer> map = graph.getOrDefault(times[i][0], new HashMap<>());
            map.put(times[i][1], times[i][2]);
            graph.put(times[i][0], map);
        }
        return graph;
    }
    private static class Pair{
        private int id;
        private int dist;
        Pair(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }
    private static void dijkstra(Map<Integer, Map<Integer, Integer>> graph, int N,  int s, int[] shortestTimeArr) {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));
        pq.offer(new Pair(s, 0));
        Set<Integer> settled = new HashSet<>();
        // int[] dist = new int[N];
        // Arrays.fill(dist, Integer.MAX_VALUE);
        // dist[s] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (settled.contains(cur.id)) continue;
            settled.add(cur.id);
            Map<Integer, Integer> neighbors = graph.get(cur.id);
            for (Map.Entry<Integer, Integer> neighbor : neighbors.entrySet()) {
                int newDist = cur.dist + neighbor.getValue();
                if (newDist < shortestTimeArr[neighbor.getKey() - 1]) {
                    // dist[neighbor.getKey()] = newDist;
                    shortestTimeArr[neighbor.getKey() -1] = newDist;                  
                    pq.offer(new Pair(neighbor.getKey(), newDist));
                }	
            }

        }
    }

}
