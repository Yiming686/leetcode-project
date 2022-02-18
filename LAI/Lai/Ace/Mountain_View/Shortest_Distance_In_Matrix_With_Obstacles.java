package Lai.Ace.Mountain_View;

import java.util.ArrayDeque;
import java.util.Queue;

import Lintcode.Matrix.Matrix;

/**
 
 00000
 00X00
 0XX0X
 sX00e
 
 *
 *
 */
public class Shortest_Distance_In_Matrix_With_Obstacles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { {0,0,0,0,0},
						{0,0,1,0,0},
						{0,1,1,0,1},
						{0,1,0,0,0}};
		int[] start = {3,0};
		int[] end   = {3,4};
		System.out.println(""+Matrix.fromMatrixToString(arr));
		System.out.println(""+shortestPath(arr, start, end));
	}
	
	public static int shortestPath(int[][] arr, int[] start, int[] end) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		int dist = 0;
		int[] dx = {1, 0,-1,  0};
		int[] dy = {0, 1, 0, -1};//down, left, right, up
		while(!queue.isEmpty()) {
			int size = queue.size();
			System.out.println(""+toStr(queue));
			for(int i = 0; i < size; i++) {
				int[] point = queue.poll();
				if(point[0] == end[0] && point[1] == end[1]) {
					return dist;
				}
				for(int j = 0; j < 4; j++ ) {
					int newX = point[0] + dx[j];
					int newY = point[1] + dy[j];
					if(newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && arr[newX][newY] == 0 && !visited[newX][newY]) {
						queue.offer(new int[] {newX, newY});
						visited[newX][newY] = true;
					}
				}
			}
			dist++;
		}
		return -1;
	}

	private static String toStr(Queue<int[]> queue) {
		StringBuilder sb = new StringBuilder();
		
		for(int[] val : queue) {
			sb.append("(");
			sb.append(val[0]);
			sb.append(",");
			sb.append(val[1]);
			sb.append(")");
		}
		
		return sb.toString();
	}

	//	public static int shortestPath(int[][] arr, int s1x, int s1y, int s2x, int s2y) {
//		
//		return -1;
//	}

}
