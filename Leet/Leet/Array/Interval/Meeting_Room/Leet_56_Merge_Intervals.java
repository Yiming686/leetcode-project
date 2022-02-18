package Leet.Array.Interval.Meeting_Room;

import static Utils.MatrixUtils.print;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leet_56_Merge_Intervals {

//	Input: [[1,3],[2,6],[8,10],[15,18]]
//	Output: [[1,6],[8,10],[15,18]]
//	Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//	Input: [[1,4],[4,5]]
//	Output: [[1,5]]
//	Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//		print(merge(intervals));
//		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] intervals = { { 1, 4 }, { 4, 5 } };
		print(merge(intervals));
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return intervals;
		}
		//Sort intervals
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> merged = new LinkedList<int[]>();
		int[] prev = intervals[0];//all merged to left of 1
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (prev[1] < curr[0]) {
				merged.add(prev);
				prev = curr;
			} else {
				prev = new int[] { prev[0], Math.max(prev[1], curr[1]) };
			}
		}
		merged.add(prev);
		return merged.toArray(new int[0][0]);

		// int[][] result = new int[merged.size()][2];
		// for(int i = 0; i < merged.size(); i++){
		//     result[i] = merged.get(i);
		// }
		// return result;

	}

}
