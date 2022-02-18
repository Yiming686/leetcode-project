package Lai.DB23.JQ_III;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sun.istack.internal.FinalArrayList;

import Utils.MatrixUtils;

public class Max_Water_Trapped_II {

//	Input: new int[][]{{4,3,2},{5,1,3},{4,3,2}}, expected:<2> but was:<4>
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { { 4, 3, 2 }, { 5, 1, 3 }, { 4, 3, 2 } };
		System.out.println("" + MatrixUtils.fromMatrixToString(matrix));
		System.out.println("" + maxTrapped(matrix));
	}
	
	public static int maxTrapped(final int[][] matrix) {
		if (matrix == null || matrix.length < 3 || matrix[0].length < 3) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = 0;
//		Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
//			@Override
//			public int compare(int[] p1, int[] p2) {
//				if (p1[2] == p2[2]) {
//					return 0;
//				}
//				return p1[2] < p2[2] ? -1 : 1;//due to minHeap
//			}
//		});//
//		Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> { return p1[2] - p2[2];});//OK
		Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);//OK
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			minHeap.offer(new int[] { i, 0, matrix[i][0] });
			minHeap.offer(new int[] { i, cols - 1, matrix[i][cols - 1] });
			visited[i][0] = true;
			visited[i][cols - 1] = true;
		}
		for (int j = 1; j < cols - 1; j++) {
			minHeap.offer(new int[] { 0, j, matrix[0][j] });
			minHeap.offer(new int[] { rows - 1, j, matrix[rows - 1][j] });
			visited[0][j] = true;
			visited[rows - 1][j] = true;
		}
		final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };//left, down, up, right
		while (!minHeap.isEmpty()) {
			int[] curr = minHeap.poll();//poll lowesst
			for (int[] dir : DIRS) {//得到，没有标记，continue， 标记，核心逻辑：计算更新逻辑所求的max，
				int newX = curr[0] + dir[0];
				int newY = curr[1] + dir[1];
				if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
					visited[newX][newY] = true;
					max += Math.max(0, curr[2] - matrix[newX][newY]);
					minHeap.offer(new int[] { newX, newY, Math.max(curr[2], matrix[newX][newY]) });
				}
			}
		}
		return max;
	}

}
