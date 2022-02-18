package Lai.Array;

import java.util.PriorityQueue;

public class KthSmallestInTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 3};
		 for(int i = 1; i <= 6 ; i++ ){
			 System.out.println("i: "+kthSmallest(arr1, arr2, i));
		 }
//		System.out.println(""+kthSmallest(arr1, arr2, 6));
	}

	public static int kthSmallest0(int[] arr1, int[] arr2, int k){
		  //assumption length of A, B is greater than 0, k > 0
		  int rows = arr1.length;
		  int cols = arr2.length;
		  boolean[][] visited = new boolean[rows][cols];
		  PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, (c1, c2) -> {return c1.val - c2.val;});
		  minHeap.offer(new Cell(arr1[0] + arr2[0], 0, 0));
		  visited[0][0]=true;
		  for(int i = 0; i < k - 1 ; i++ ){
			  Cell cell = minHeap.poll();
//			  System.out.println("val: "+cell.val);
			  if(cell.row + 1 < arr1.length && !visited[cell.row + 1][cell.col]) {
//				  cell.val = arr1[cell.row + 1] + arr2[cell.col];
//				  cell.row = cell.row + 1;
				  minHeap.offer(new Cell(arr1[cell.row + 1] + arr2[cell.col], cell.row + 1, cell.col));
				  visited[cell.row + 1][cell.col]=true;
			  }
			  if(cell.col + 1 < arr2.length && !visited[cell.row][cell.col + 1]) {
//				  cell.val = arr1[cell.row] + arr2[cell.col + 1];
//				  cell.col = cell.col + 1;
				  minHeap.offer(new Cell(arr1[cell.row] + arr2[cell.col + 1], cell.row, cell.col + 1));
				  visited[cell.row][cell.col + 1]=true;
			  }
//				Integer [] arr = pq3.toArray(new Integer[0]);
//			  Cell [] arr = minHeap.toArray(new Cell[0]);
//			  System.out.println("Heap: "+Arrays.toString(minHeap.toArray(new Integer[0])));
//			  System.out.println("Heap: "+Arrays.toString(minHeap.toArray(new Cell[0])));
		  }
		  return minHeap.peek().val;
		  
	}

	
	public static int kthSmallest(int[] arr1, int[] arr2, int k){
		  //assumption length of A, B is greater than 0, k > 0
		  int rows = arr1.length;
		  int cols = arr2.length;
		  boolean[][] visited = new boolean[rows][cols];
		  PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, (c1, c2) -> {return c1.val - c2.val;});
		  minHeap.offer(new Cell(arr1[0] + arr2[0], 0, 0));
		  visited[0][0]=true;
		  for(int i = 0; i < k - 1 ; i++ ){
			  Cell cell = minHeap.poll();
			  if(cell.row + 1 < arr1.length && !visited[cell.row + 1][cell.col]) {
				  minHeap.offer(new Cell(arr1[cell.row + 1] + arr2[cell.col], cell.row + 1, cell.col));
				  visited[cell.row + 1][cell.col]=true;
			  }
			  if(cell.col + 1 < arr2.length && !visited[cell.row][cell.col + 1]) {
				  minHeap.offer(new Cell(arr1[cell.row] + arr2[cell.col + 1], cell.row, cell.col + 1));
				  visited[cell.row][cell.col + 1]=true;
			  }
		  }
		  return minHeap.peek().val;
	}

//	static class Cell implements Comparable<Cell>{
	static class Cell {
		
		int val;
		int row;
		int col;
		
		public Cell(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}

//		@Override
//		public int compareTo(Cell o) {
//			// TODO Auto-generated method stub
//			return val - o.val;
//		}

		@Override
		public String toString() {
			return "Cell [val=" + val + ", row=" + row + ", col=" + col + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		
		
	}


}
