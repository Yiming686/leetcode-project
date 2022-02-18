package Lai.Intervals.Rectangle.Area;

import java.util.LinkedList;
import java.util.List;

/**

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 *
 */
public class Leet_57_Insert_Interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new LinkedList<int[]>();

		boolean hasInserted = false;
		for (int i = 0; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (curr[1] < newInterval[0]) {
				result.add(curr);
			} else if (curr[0] > newInterval[1]) {
				if (!hasInserted) {
					hasInserted = true;
					result.add(newInterval);
				}
				result.add(curr);
			} else {
				newInterval[0] = Math.min(curr[0], newInterval[0]);
				newInterval[1] = Math.max(curr[1], newInterval[1]);
			}
		}
		if (!hasInserted) {
			result.add(newInterval);
		}
		return result.toArray(new int[0][0]);
	}

}
