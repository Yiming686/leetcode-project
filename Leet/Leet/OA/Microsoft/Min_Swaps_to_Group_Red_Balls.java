package Leet.OA.Microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Example:
 * 
 * Input: "RRRWRR" Output: 2
 *
 * 
 */
public class Min_Swaps_to_Group_Red_Balls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "RRRWRR";
		System.out.println("" + solution(str));
	}

	public static int solution(String str) {
		List<Integer> redIndices = getRedIndices(str);
		int mid = redIndices.size() / 2;
		int minSwaps = 0;
		for (int i = 0; i < redIndices.size(); i++) {
			// number of swaps for each R is the distance to mid, minus the number of R's between them
			minSwaps += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
		}
		return minSwaps;
	}

	private static List<Integer> getRedIndices(String s) {
		List<Integer> indices = new ArrayList<>(s.length());
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R') {
				indices.add(i);
			}
		}
		return indices;
	}

}
