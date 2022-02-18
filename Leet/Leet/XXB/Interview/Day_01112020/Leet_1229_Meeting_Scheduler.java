package Leet.XXB.Interview.Day_01112020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_1229_Meeting_Scheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
		Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
		// Arrays.sort(slots2, (a, b) -> a[][0] - b[][0]);
		List<Integer> result = new ArrayList<>();
		int common = 0;
		int i = 0;
		int j = 0;
		while (i < slots1.length && j < slots2.length) {
			if (slots1[i][0] <= slots2[j][0]) {
				if (slots1[i][1] >= slots2[j][1]) {
					if (findCommon(result, slots2[j][0], slots2[j][1], duration)) {
						return result;
					}
				} else {
					if (findCommon(result, slots2[j][0], slots1[i][1], duration)) {
						return result;
					}
				}
				i++;
			} else {
				if (slots2[j][1] >= slots1[i][1]) {
					if (findCommon(result, slots1[i][0], slots1[i][1], duration)) {
						return result;
					}
				} else {
					if (findCommon(result, slots1[i][0], slots2[j][1], duration)) {
						return result;
					}
				}
				j++;
			}
		}
		return result;
	}

	private boolean findCommon(List<Integer> result, int start, int end, int duration) {
		boolean found = end - start >= duration;
		if (found) {
			result.add(start);
			result.add(start + duration);
		}
		return found;
	}

}
