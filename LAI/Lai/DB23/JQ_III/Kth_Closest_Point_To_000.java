package Lai.DB23.JQ_III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Kth_Closest_Point_To_000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2,3};
		int[] b = new int[]{0,3,4};
		int[] c = new int[]{1,2};
		int k = 15;
//		Set<Integer> set = new TreeSet<>();
//		int count = 0;
//		for(int i = 0; i < a.length; i++) {
//			for(int j = 0; j < b.length; j++) {
//				for(int m = 0; m < c.length; m++) {
//					count++;
//					System.out.println(""+(count));
//					System.out.println(""+i+j+m);
////					set.add(v1 * v2 * v3);
//				}
//			}
//		}
//		for(int v1 : a) {
//			for(int v2 : b) {
//				for(int v3 : c) {
//					set.add(v1 * v2 * v3);
//				}
//			}
//		}
//		System.out.println(""+set);
		System.out.println(""+closest(a,b,c,k));//expected:<[3, 3, 2]> but was:<[2, 4, 2]
	}
	public static List<Integer> closest(final int[] a, final int[] b, final int[] c, int k) {
	    Queue<Cell> minHeap = new PriorityQueue<>(2 * k, new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				// TODO Auto-generated method stub
				long dist1 = distance(o1, a, b, c);
				long dist2 = distance(o2, a, b, c);
				if(dist1 == dist2) {
					return 0;
				}
				return dist1 < dist2 ? -1 : 1;
			}
	    });
	    Set<Cell> visited = new HashSet<>();
	    Cell cell = new Cell(0, 0, 0);
	    minHeap.offer(cell);
	    visited.add(cell);
	    while(--k > 0) {
	    	System.out.println("k:"+k);
	    		System.out.println(""+Arrays.toString(minHeap.toArray(new Cell[0])));
	    		cell = minHeap.poll();
	    		System.out.println("cell:"+ cell);
	    		Cell nei = new Cell(cell.x + 1, cell.y, cell.z);
	    		if(cell.x + 1 < a.length && visited.add(nei)) {
	    			minHeap.offer(nei);
	    			System.out.println("nei1:"+ nei);
	    		}
	    		nei = new Cell(cell.x, cell.y + 1, cell.z);
	    		if(cell.y + 1 < b.length && visited.add(nei)) {
	    			minHeap.offer(nei);
	    			System.out.println("nei2:"+ nei);
	    		}
	    		nei = new Cell(cell.x, cell.y, cell.z + 1);
	    		if(cell.z + 1 < c.length && visited.add(nei)) {
	    			minHeap.offer(nei);
		    		System.out.println("nei3:"+ nei);
	    		}
	    }
	    cell = minHeap.peek();
	    return Arrays.asList(cell.x, cell.y, cell.z);
	}
	
	static class Cell{
		int x;
		int y;
		int z;
//		long dist;
		public Cell(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
//			this.dist = 1L * x * x * y * y * z * z;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			result = prime * result + z;
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
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			if (z != other.z)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "[" + x + ", " + y + ", " + z  + "]";
		}
		
	}
	
	  private static long distance(Cell cell, final int[] a, final int[] b, final int[] c){
		    return 0L + 
		           a[cell.x] * a[cell.x] +
		           a[cell.y] * a[cell.y] +
		           a[cell.z] * a[cell.z];
		  }

	public static List<Integer> closest_01(final int[] a, final int[] b, final int[] c, int k) {
	    Queue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
	      @Override
	      public int compare(List<Integer> list1, List<Integer> list2){
	        long dist1 = ddistance(list1, a, b, c);
	        long dist2 = ddistance(list2, a, b, c); 
	        if(dist1 == dist2){
	          return 0;
	        }
	        return dist1 < dist2 ? -1 : 1;
	        //return (int)(dist1 - dist2);
	      }
	    });
	    Set<List<Integer>> visited = new HashSet<>();
	    List<Integer> curr = Arrays.asList(0, 0, 0);
	    minHeap.offer(curr);
	    visited.add(curr);
	    while(--k >= 0){
//	    	while(k > 0){
	      curr = minHeap.poll();
	      System.out.println("k:"+(15-k));
	      System.out.println("curr:"+curr);
	      List<Integer> nei = Arrays.asList(curr.get(0) + 1, curr.get(1), curr.get(2));
	      if(curr.get(0) + 1 < a.length && visited.add(nei)){
	        minHeap.offer(nei);
	      }
	      nei = Arrays.asList(curr.get(0) , curr.get(1)+ 1, curr.get(2));
	      if(curr.get(1) + 1 < b.length && visited.add(nei)){
	        minHeap.offer(nei);
	      }
	      nei = Arrays.asList(curr.get(0) , curr.get(1), curr.get(2) + 1);
	      if(curr.get(2) + 1 < c.length && visited.add(nei)){
	        minHeap.offer(nei);
	      }      
//	      k--;
	    }
	    curr.set(0, a[curr.get(0)]);
	    curr.set(1, b[curr.get(1)]);
	    curr.set(2, c[curr.get(2)]);
	    return curr;
	  }

	  private static long ddistance(List<Integer> list, final int[] a, final int[] b, final int[] c){
	    return 0L + 
	           a[list.get(0)] * a[list.get(0)] +
	           a[list.get(1)] * a[list.get(1)] +
	           a[list.get(2)] * a[list.get(2)];
	  }


}
