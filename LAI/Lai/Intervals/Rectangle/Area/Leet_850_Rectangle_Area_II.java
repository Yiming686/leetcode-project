package Lai.Intervals.Rectangle.Area;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Utils.MatrixUtils;
import Utils.StringUtils;

/**
 * Input: [[0,0,2,2],[1,0,2,3],[1,0,3,1]] Output: 6 Explanation: As illustrated
 * in the picture.
 *
 * 
 */
public class Leet_850_Rectangle_Area_II {

	public static void main(String[] args) {
		Integer[] points = new Integer[] {6,2,4,1,8};
		Arrays.sort(points);//
		System.out.println(""+ StringUtils.toStr(points));
		// TODO Auto-generated method stub
//		int[][] rectangles = 
		int[][] rectangles = MatrixUtils.fromStringToMatrix("[[0,0,2,2],[1,0,2,3],[1,0,3,1]]");
//		int[][] rectangles = MatrixUtils.fromStringToMatrix("[[0,0,1000000000,1000000000]]");

		System.out.println("" + MatrixUtils.fromMatrixToString(rectangles));
//				System.out.println("" + getSkyline(buildings));
		System.out.println("area: " + rectangleArea_NlogN(rectangles));

	}

//	=== 3/3 Solution: Segment Tree Solution, Time: O(NlogN), Space: O(N) =================================================================================

//    public  int rectangleArea(int[][] rectangles) {
     public static int rectangleArea_NlogN(int[][] rectangles) {
		long area = 0L;
		if(rectangles == null || rectangles.length == 0) {
			return 0;
		}
		List<Segment> segments = new ArrayList<>();
		Set<Integer> setOfPoints = new HashSet<>();
		for(int[] rect : rectangles) {
			segments.add(new Segment(rect[1], rect[0], rect[2], true));
			segments.add(new Segment(rect[3], rect[0], rect[2], false));
			setOfPoints.add(rect[0]);//start point of segment
			setOfPoints.add(rect[2]);//start point of segment
		}
		Collections.sort(segments, (a, b) ->a.pos - b.pos);
		
		Integer[] points = setOfPoints.toArray(new Integer[0]);
		Arrays.sort(points);//
		Map<Integer, Integer> map = new HashMap<>();//val to index
		for(int i = 0; i < points.length; i++) {
			map.put(points[i], i);//index to val
		}
		
		Node root = new Node(0, points.length - 1, points);
		int prevPos = segments.get(0).pos;
		long prevLen = 0;
		for(Segment segment : segments) {
			area += (segment.pos - prevPos) * prevLen;
			area %= 1000000007;
			prevLen %= 1000000007;

            prevPos = segment.pos;
			prevLen = update(root, map.get(segment.start), map.get(segment.end), segment.isStart);;
		}
		area %= 1000000007;
		return (int)area;
	}
	
	static class Node{
		int from;
		int mid;
		int to;
		Integer[] points;//
		
		Node left;
		Node right;
		int count;
		int lenOfSegments;
		Node(int from, int to, Integer[] points){
			this.from = from;
			this.to = to;
			this.mid = from + (to - from) / 2;
			this.points = points;
		}
    }
        //
	public static  int update(Node root, int start, int end, boolean isStart) {
			if(start >= end) {
				return 0;
			}
			//update count
			if(start == root.from && end == root.to) {
				root.count += isStart == true ? 1 : -1; 
			}else {
				// Node left = getLeftNode(root);
				// Node right = getRightNode(root);
				// update(root.left, start, Math.min(root.mid, end), isStart);
				// update(root.right, Math.max(root.mid, start), end, isStart);
                update(getLeftNode(root), start, Math.min(root.mid, end), isStart);
				update(getRightNode(root), Math.max(root.mid, start), end, isStart);
			}
			//update lenOfSegments
			if(root.count > 0) {
				root.lenOfSegments = root.points[root.to] - root.points[root.from];//index not
			}else {
                root.lenOfSegments = root.left  == null ? 0 : root.left.lenOfSegments;
                root.lenOfSegments += root.right == null ? 0 : root.right.lenOfSegments;
			}
			return root.lenOfSegments;			
	}

		
	    private static  Node getLeftNode(Node root) {
			return root.left = (root.left == null) ? new Node(root.from, root.mid, root.points) : root.left;
		}

		private static  Node getRightNode(Node root) {
            return root.right = (root.right == null) ? new Node(root.mid, root.to, root.points) : root.right;
		}

	
	static class Segment{
		int pos;//index
		int start;//index
		int end;//index
		boolean isStart;
		Segment(int pos, int start, int end, boolean isStart){
			this.pos = pos;
			this.start = start;
			this.end = end;
			this.isStart = isStart;
		}
	}
	
//	=== 2/3 Solution: Sweep Line Solution, Time:  O(N^2*LogN), Space: O(N)=================================================================================	

//		O(2*N):   for loop each interval	
//	O(NlogN))         add and remove interval and sort them, and calculate the current new length in total
//				     area += (currPos - prevPos) * prevLen
//	                 prevLen = current new length

	
//	=== 1/3 Solution: Brutal Force Solution£¬Time:  O(N^3), Space: O(N^2) =================================================================================
//	Brutal Force solution: O(N^3)
	public static int rectangleArea_bf_N3(int[][] rectangles) {
		// public static int rectangleArea_N3_bf(int[][] rectangles) {
		long area = 0L;
		if (rectangles == null || rectangles.length == 0) {
			return 0;
		}
		Set<Integer> setX = new HashSet<>();
		Set<Integer> setY = new HashSet<>();
		for (int[] rect : rectangles) {
			setX.add(rect[0]);
			setY.add(rect[1]);
			setX.add(rect[2]);
			setY.add(rect[3]);
		}
		Integer[] arrX = setX.toArray(new Integer[0]);
		Integer[] arrY = setY.toArray(new Integer[0]);
		Arrays.sort(arrX);
		Arrays.sort(arrY);
		Map<Integer, Integer> mapX = new HashMap<>();
		Map<Integer, Integer> mapY = new HashMap<>();
		for (int i = 0; i < arrX.length; i++) {
			mapX.put(arrX[i], i);
		}
		for (int i = 0; i < arrY.length; i++) {
			mapY.put(arrY[i], i);
		}

		// boolean[][] isCovered = new boolean[arrX.length][arrY.length];   WRONG     
		boolean[][] isCovered = new boolean[arrY.length][arrX.length];
		for (int[] rect : rectangles) {
			for (int j = mapX.get(rect[0]); j < mapX.get(rect[2]); j++) {
				for (int i = mapY.get(rect[1]); i < mapY.get(rect[3]); i++) {
					isCovered[i][j] = true;
				}
			}
		}
		for (int i = 0; i < isCovered.length - 1; i++) {//Y
			for (int j = 0; j < isCovered[0].length - 1; j++) {//X
				if (isCovered[i][j]) {
					area += (long) (arrX[j + 1] - arrX[j]) * (arrY[i + 1] - arrY[i]);
					area %= 1000000007;
				}
			}
		}
		return (int) area;
	}

}
