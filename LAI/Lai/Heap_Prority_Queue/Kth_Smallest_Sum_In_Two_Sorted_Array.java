package Lai.Heap_Prority_Queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Kth_Smallest_Sum_In_Two_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,8,9};
		int[] B = {2,3,4,7};
		int k = 20;
		System.out.println(""+kthSum(A, B, k));
	}

	static class Cell {
		int sum;
		int i;
		int j;

		public Cell(int sum, int i, int j) {
			this.sum = sum;
			this.i = i;
			this.j = j;
		}
	}

	public static int kthSum(int[] A, int[] B, int k) {
		// Write your solution here
//		Queue<Cell> pq = new PriorityQueue<>(16, new Comparator<Cell>() {
//			public int compare(Cell c1, Cell c2) {
//				if (c1.sum < c2.sum) {
//					return -1;
//				}
//				if (c1.sum > c2.sum) {
//					return 1;
//				}
//				return 0;
//			}
//		});
		Queue<Cell> pq = new PriorityQueue<>((c1, c2) -> c1.sum - c2.sum);

		boolean[][] visited = new boolean[A.length][B.length];
		int i = 0;
		int j = 0;
		pq.offer(new Cell(A[i] + B[j], i, j));
		visited[i][j] = true;
		while (--k > 0) {
			Cell cell = pq.poll();
			System.out.printf("cell: sum: %d, i: %d, j: %d \n", cell.sum, cell.i, cell.j);
//		      if(A[i] + B[j+1] < A[i+1] + B[j]){
//		        cell.sum = A[i] + B[j+1];
//		        cell.j = j + 1;
//		      }else{
//		        cell.sum = A[i + 1] + B[j];
//		        cell.i = i + 1;
//		      }
//		     
			i = cell.i;
			j = cell.j;
			if (j + 1 < B.length && !visited[i][j+1]) {
				pq.offer(new Cell(A[i] + B[j + 1], i, j + 1));
				visited[i][j + 1] = true;
			}
			if (i + 1 < A.length && !visited[i+1][j]) {
				pq.offer(new Cell(A[i + 1] + B[j], i + 1, j));
				visited[i + 1][j] = true;
			}
		}
		return pq.peek().sum;
	}

}
