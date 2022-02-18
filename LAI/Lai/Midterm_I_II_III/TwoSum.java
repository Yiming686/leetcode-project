package Lai.Midterm_I_II_III;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 5 };
		int[] B = { 4, 6, 8 };
//		int[] A = {1,4,6,8,10};
//		int[] B = {1,4,5,7,8};

//		6, 7,9,
//		8, 9,11,
//		10,11,13
//		6,7,8,9,10,11,13
//		int k = 13;
//		while(--k >= 0) {
//			System.out.println(""+kthSmallest(A, B, 4));
//		}
		System.out.println("" + kthSmallest(A, B, 14));
	}

	static class Cell {
		int i;
		int j;
		int val;

		Cell(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}

	public static int kthSmallest(int[] A, int[] B, int k) {
		//Assumption:   k >0 and less than A.lenghth + B.length
		if (A.length == 0 && k < B.length) {
			return B[k - 1];
		}
		if (B.length == 0 && k < A.length) {
			return A[k - 1];
		}

		PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				return c1.val - c2.val;
			}
		});
		queue.offer(new Cell(0, 0, A[0] + B[0]));
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		//int len = A.length < B.length ? B.length : A.length;
		//int count = k;
		while (--k > 0) {//poll k-1 times
			Cell cell = queue.poll();
			if (cell.i + 1 < A.length && !visited.contains((cell.i + 1) * B.length + cell.j)) {
				visited.add((cell.i + 1) * B.length + cell.j);
				queue.offer(new Cell(cell.i + 1, cell.j, A[cell.i + 1] + B[cell.j]));
			}
			if (cell.j + 1 < B.length && !visited.contains(cell.i * B.length + cell.j + 1)) {
				visited.add(cell.i * B.length + cell.j + 1);
				queue.offer(new Cell(cell.i, cell.j + 1, A[cell.i] + B[cell.j + 1]));
			}
		}
//		System.out.println(""+);
		return queue.peek().val;
	}

}
