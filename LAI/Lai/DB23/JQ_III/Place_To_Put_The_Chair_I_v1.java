package Lai.DB23.JQ_III;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import Utils.ArrayUtils;
import Utils.MatrixUtils;

public class Place_To_Put_The_Chair_I_v1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] gym = new char[][] { { 'C', 'C', 'E', 'O', 'C' }, { 'E', 'E', 'O', 'C', 'E' },
				{ 'C', 'C', 'E', 'C', 'C' }, { 'C', 'O', 'C', 'E', 'E' }, { 'E', 'C', 'O', 'C', 'C' } };
		System.out.println(""+putChair(gym));
	}

	public static List<Integer> putChair(char[][] gym) {
		// Write your solution here
		int rows = gym.length;
		int cols = gym[0].length;
		int[][] cost = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (gym[i][j] == 'E') {
					if (!addCost(cost, gym, i, j)) {
						return null;
					}
				}
			}
		}
		System.out.println(""+MatrixUtils.fromMatrixToString(cost));
		List<Integer> result = null;//coordinates
		result = Arrays.asList(-1, -1);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (gym[i][j] != 'E' && gym[i][j] != 'O') {//where able to put chair
					// if(result == null){//first result
					if (result.get(0) == -1 && result.get(1) == -1) {//first result
						result = Arrays.asList(i, j);
					} else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {//find less cost
						System.out.printf("i:j %d:%d\n", i, j);
						result.set(0, i);
						result.set(1, j);
					}
				}
			}
		}
		return result;
	}

	// 从位于[row，col]的E开始，计算所有可能放chair的位置的最短路径长度。什么时候 返回false？什么时候 返回true？
	// return  true:
	// return false:
	private static boolean addCost(int[][] cost, final char[][] gym, final int x, final int y) {
		boolean[][] visited = new boolean[gym.length][gym[0].length];
		Queue<int[]> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.offer(new int[] { x, y });
		int pathCost = 1;
		final int[][] dxy = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int[] dir : dxy) {
					int dx = point[0] + dir[0];
					int dy = point[1] + dir[1];
					if (dx >= 0 && dx < gym.length && dy >= 0 && dy < gym[0].length && !visited[dx][dy] && gym[dx][dy] != 'O') {
						visited[dx][dy] = true;
						cost[dx][dy] += pathCost;
						queue.offer(new int[] { dx, dy });
					}
				}
			}
			pathCost++;
		}
		System.out.println(""+MatrixUtils.fromMatrixToString(cost));

		for (int i = 0; i < gym.length; i++) {
			for (int j = 0; j < gym[0].length; j++) {
				if (!visited[i][j] && gym[i][j] == 'E') {//有E不连通
					return false;
				}
			}
		}
		return true;
	}

}
