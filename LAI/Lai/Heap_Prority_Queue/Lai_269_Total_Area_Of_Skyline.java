package Lai.Heap_Prority_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import Utils.MatrixUtils;

public class Lai_269_Total_Area_Of_Skyline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = MatrixUtils.fromStringToMatrix("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]");
		System.out.println("" + MatrixUtils.fromMatrixToString(buildings));
//		System.out.println("" + getSkyline(buildings));
		System.out.println("area: " + getSkylineArea(buildings));

	}

	public int totalArea(List<Building> buildings) {
		// Write your solution here.
		int[][] buildingsArr = new int[buildings.size()][];
		for (int i = 0; i < buildings.size(); i++) {
			Building b = buildings.get(i);
			buildingsArr[i] = new int[] { b.start, b.end, b.height };
		}
		return getSkylineArea(buildingsArr);
	}

	public static int getSkylineArea(int[][] buildings) {
		int area = 0;
//				List<List<Integer>> result = new ArrayList<List<Integer>>();
//				List<int[]> list = new ArrayList<>();
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
				//printf("Area: %3d :: Height: %3d, Left: %3d, Right: %3d", area, prevMax, prevStart, currStart );
				prevStart = currStart;
				prevMax = currMax;
			}
		}
//				return result;		
		return area;
	}

	public int totalArea_via_List(List<Building> buildings) {
		int area = 0;
		List<int[]> points = new ArrayList<>();
		for (Building b : buildings) {
			points.add(new int[] { b.start, -b.height });//start point
			points.add(new int[] { b.end, b.height });//end point
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
//					result.add(Arrays.asList(currStart, currMax)); //list.add(new int[] { currStart, currMax });
				area += prevMax * (currStart - prevStart);
				//printf("Area: %3d :: Height: %3d, Left: %3d, Right: %3d", area, prevMax, prevStart, currStart );
				prevStart = currStart;
				prevMax = currMax;
			}
		}
//			return result;		
		return area;
	}

	static class Building {
		public int start;
		public int end;
		public int height;

		public Building(int start, int end, int height) {
			this.start = start;
			this.end = end;
			this.height = height;
		}
	}

}
