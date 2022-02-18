package Lai.Heap_Prority_Queue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Kth_Smallest_in_Sorted_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { 
				{ 1, 3, 5, 7 },

				{ 2, 4, 8, 9 },

				{ 3, 5, 11, 15 },

				{ 6, 8, 13, 18 } };
		System.out.println("" + kthSmallest(matrix, 15));
	}

	
	public static int kthSmallest(int[][] matrix, int k) {
		// Write your solution here
		//1<= k <= rows * cols
		int rows = matrix.length;
		int cols = matrix[0].length;

//		 PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) ->  c1.val - c2.val);
		PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				return c1.val - c2.val;
			}
		});

//		boolean[][] visited = new boolean[k][k];//has been offered into pq
		Set<Integer> set = new HashSet<>();
		pq.offer(new Cell(0, 0, matrix[0][0]));
		set.add(0);
		while (--k > 0) {//k减一次
			Cell cell = pq.poll();
			if (cell.row + 1 < rows && !set.contains((cell.row + 1) * cols + cell.col)) {
				pq.offer(new Cell(cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]));
				set.add((cell.row + 1) * cols+cell.col);
				System.out.printf("row:col:val %d:%d:%d \n", cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]);
			}
			if (cell.col + 1 < cols && !set.contains(cell.row * cols + cell.col + 1)) {
				pq.offer(new Cell(cell.row, cell.col + 1, matrix[cell.row][cell.col + 1]));
				set.add(cell.row * cols + cell.col + 1);
				System.out.printf("row:col:val %d:%d:%d \n", cell.row, cell.col + 1, matrix[cell.row][cell.col+1]);
			}
//			System.out.println("size: "+pq.size());
//			System.out.println("size: "+Arrays.toString(pq.toArray()));
//			print(pq);
			pq.stream().forEach(elem -> System.out.print(elem.val + ", "));
			System.out.println("");
		}
		return pq.peek().val;
	}

	//TC is klog(2), SC is O(logk+k^2)
	public static int kthSmallest00(int[][] matrix, int k) {
		// Write your solution here
		//1<= k <= rows * cols
		int rows = matrix.length;
		int cols = matrix[0].length;

//		 PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) ->  c1.val - c2.val);
		PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				return c1.val - c2.val;
			}
		});

		boolean[][] visited = new boolean[k][k];//has been offered into pq
		pq.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;
		while (--k > 0) {//k减一次
			Cell cell = pq.poll();
			if (cell.row + 1 < rows && !visited[cell.row + 1][cell.col]) {
				pq.offer(new Cell(cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]));
				visited[cell.row + 1][cell.col] = true;
				System.out.printf("row:col:val %d:%d:%d \n", cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]);
			}
			if (cell.col + 1 < cols && !visited[cell.row][cell.col + 1]) {
				pq.offer(new Cell(cell.row, cell.col + 1, matrix[cell.row][cell.col + 1]));
				visited[cell.row][cell.col + 1] = true;
				System.out.printf("row:col:val %d:%d:%d \n", cell.row, cell.col + 1, matrix[cell.row][cell.col+1]);
			}
//			System.out.println("size: "+pq.size());
//			System.out.println("size: "+Arrays.toString(pq.toArray()));
//			print(pq);
			pq.stream().forEach(elem -> System.out.print(elem.val + ", "));
			System.out.println("");
		}
		return pq.peek().val;
	}

	private static void print(PriorityQueue<Cell> pq) {
		pq.stream().forEach(elem -> System.out.print(elem.val + ", "));
//		 Stream<Integer> sorted = lists.stream().sorted();
//        sorted.forEach(elem -> System.out.print(elem + ","));
	}
	static class Cell {
		int row;
		int col;
		int val;

		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

}
