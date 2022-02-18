package Lai.Intervals.Rectangle.Area;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 *
 */
public class Leet_56_Merge_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	merge all overlapping Unsorted intervals.
	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return intervals;
		}
		//Sort intervals
		 Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> merged = new LinkedList<int[]>();
		int[] curr = intervals[0];//all merged to left of 1
		for (int i = 1; i < intervals.length; i++) {
			int[] next = intervals[i];
			if (curr[1] < next[0]) {
				merged.add(curr);
				curr = next;
			} else {
				curr = new int[] { curr[0], Math.max(curr[1], next[1]) };
			}
		}
		merged.add(curr);
		return merged.toArray(new int[0][0]);

		// int[][] result = new int[merged.size()][2];
		// for(int i = 0; i < merged.size(); i++){
		//     result[i] = merged.get(i);
		// }
		// return result;

	}

}
