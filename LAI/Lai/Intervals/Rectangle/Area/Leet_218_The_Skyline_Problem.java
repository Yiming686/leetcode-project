package Lai.Intervals.Rectangle.Area;

import static Utils.ArrayUtils.printf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import Utils.MatrixUtils;

public class Leet_218_The_Skyline_Problem {

//	Input:    [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//	Expected: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = MatrixUtils.fromStringToMatrix("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]");
		System.out.println("" + MatrixUtils.fromMatrixToString(buildings));
//		System.out.println("" + getSkyline(buildings));
		System.out.println("area: "+getSkylineArea(buildings));
	}
	
	public static int getSkylineArea(int[][] buildings) {
		int area = 0;
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		List<int[]> list = new ArrayList<>();
		List<int[]> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new int[] { b[0], -b[2] });//start point
			points.add(new int[] { b[1], b[2] });//end point
		}
		// Collections.sort(points, (a, b) ->{
		//   if(a[0] != b[0]){
		//     return a[0] - b[0];
		//   }else{
		//     return a[1] - b[1];
		//   }});
		Collections.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});
		int prevStart = 0;
		int prevMax = 0;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(0, 1);
		for (int[] p : points) {
			if (p[1] < 0) {//start
				treeMap.put(-p[1], treeMap.getOrDefault(-p[1], 0) + 1);//高度值，个数加1
			} else {//end
				int count = treeMap.get(p[1]);
				if (count == 1) {
					treeMap.remove(p[1]);
				} else {
					treeMap.put(p[1], count - 1);//高度值，个数加1
				}
			}
			int currStart = p[0];
			int currMax = treeMap.lastKey();
			if (currMax != prevMax) {
//				result.add(Arrays.asList(currStart, currMax)); //list.add(new int[] { currStart, currMax });
				area += prevMax * (currStart - prevStart);
				printf("Area: %3d :: Height: %3d, Left: %3d, Right: %3d", area, prevMax, prevStart, currStart );
				prevStart = currStart;
				prevMax = currMax;
			}
		}
//		return result;
		
		return area;
	}
	
	public static List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<int[]> list = new ArrayList<>();
		List<int[]> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new int[] { b[0], -b[2] });//start point
			points.add(new int[] { b[1], b[2] });//end point
		}
		 Collections.sort(points, (a, b) ->{
		   if(a[0] != b[0]){
		     return a[0] - b[0];
		   }else{
		     return a[1] - b[1];
		   }});
//		worked well: new Comparator<int[]>
//		Collections.sort(points, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] a, int[] b) {
//				if (a[0] != b[0]) {
//					return a[0] - b[0];
//				} else {
//					return a[1] - b[1];
//				}
//			}
//		});
		int prevStart = 0;
		int prevMax = 0;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(0, 1);
		for (int[] p : points) {
			if (p[1] < 0) {//start
				treeMap.put(-p[1], treeMap.getOrDefault(-p[1], 0) + 1);//高度值，个数加1
			} else {//end
				int count = treeMap.get(p[1]);
				if (count == 1) {
					treeMap.remove(p[1]);
				} else {
					treeMap.put(p[1], count - 1);//高度值，个数加1
				}
			}
			int currStart = p[0];
			int currMax = treeMap.lastKey();
			if (currMax != prevMax) {
				result.add(Arrays.asList(currStart, currMax)); //list.add(new int[] { currStart, currMax });
			}
			prevStart = currStart;
			prevMax = currMax;
		}
		return result;
	}

	public int[][] getSkyline_toArr(int[][] buildings) {
		// Write your solution here
		// int[][] result = new int[][];
		List<int[]> list = new ArrayList<>();
		List<int[]> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new int[] { b[0], -b[2] });//start point
			points.add(new int[] { b[1], b[2] });//end point
		}
		// Collections.sort(points, (a, b) ->{
		//   if(a[0] != b[0]){
		//     return a[0] - b[0];
		//   }else{
		//     return a[1] - b[1];
		//   }});
		Collections.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});
		int prevStart = 0;
		int prevMax = 0;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(0, 1);
		for (int[] p : points) {
			if (p[1] < 0) {//start
				treeMap.put(-p[1], treeMap.getOrDefault(-p[1], 0) + 1);//高度值，个数加1
			} else {//end
				int count = treeMap.get(p[1]);
				if (count == 1) {
					treeMap.remove(p[1]);
				} else {
					treeMap.put(p[1], count - 1);//高度值，个数加1
				}
			}
			int currStart = p[0];
			int currMax = treeMap.lastKey();
			if (currMax != prevMax) {
				list.add(new int[] { currStart, currMax });
			}
			prevStart = currStart;
			prevMax = currMax;
		}
		int[][] result = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

//	static class Point {
//		int pos;
//		boolean isStart;
//		boolean isDeleted;
//		int[] building;//start, end and height
//
//		Point(int pos, boolean isStart, int[] building) {
//			this.pos = pos;
//			this.isStart = isStart;
//			this.isDeleted = false;
//			this.building = building;
//		}
//
//		@Override
//		public String toString() {
//			return "Point [pos=" + pos + ", isStart=" + isStart + ", building=" + Arrays.toString(building) + "]";
//		}
//		
//	}
//
//	public static List<List<Integer>> getSkyline(int[][] buildings) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		if (buildings == null || buildings.length == 0)
//			return result;
//		// List<int[]> heights = new ArrayList<int[]>();
//		List<Point> points = new ArrayList<>();
//		for (int[] b : buildings) {
//			//-表示开始节点，多个重叠的话，开始节点放在前面处理
//			// heights.add(new int[]{b[0],-b[2]});
//			// heights.add(new int[]{b[1], b[2]});// 表示结束节点，遇到就删除
//			points.add(new Point(b[0], true, b));
//			points.add(new Point(b[1], false, b));
//		}
//		Collections.sort(points, new Comparator<Point>() {
//			public int compare(Point p1, Point p2) {
//				if (p1.pos != p2.pos) {
//					return p1.pos - p2.pos;//从小到大
//				} else {
//					return p1.building[1] - p2.building[1];//从小到大
//				}
//			}
//		});
//		for(Point p : points) {
//			System.out.println("p: "+ p.toString());
//		}
////		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(11, (a, b) -> b[2] - a[2]);
//		PriorityQueue<Point> pq = new PriorityQueue<Point>(11, (a, b) -> b.building[2] - a.building[2]);
////		pq
////		 int area = 0;       
//		int prevPos = 0;
//		for (Point p : points) {
//			List<Integer> list = new ArrayList<>();
//			while (!pq.isEmpty() && pq.peek().isDeleted) {
//				pq.poll();
//			}
//			int prevHeight = pq.isEmpty() ? 0 : pq.peek().building[2];
//			// area += currHeight * (p.pos - prevPos);
//			if (p.isStart) {
//				if( p.building[2] > prevHeight) {
//					list.add(p.pos);
//					list.add(p.building[2]);					
//				}
////				if(!pq.isEmpty() && p.building[2] > pq.peek().building[2]) {
////					list.add(p.pos);
////					list.add(currHeight);					
////				}
//				pq.offer(p);
//			} else {
//				if(p.building[2] <= prevHeight) {
//					p.isDeleted = true;
//				}
////				prevPos = p.pos;
////				list.add(p.pos);
////				list.add(currHeight);
//			}
//
//			result.add(list);
//		}
//		// return area;
//		return result;
//	}

}
