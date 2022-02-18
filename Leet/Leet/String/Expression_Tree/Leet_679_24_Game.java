package Leet.String.Expression_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_679_24_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 1, 8, 7};
		System.out.println(""+judgePoint24(nums));
	}

	public static boolean judgePoint24(int[] nums) {
		//Sanity Check
		List<Double> list = new ArrayList<>();
		for (int n : nums) {
			list.add((double) n);
		}
		return backtrack(list);
	}

	private static boolean backtrack(List<Double> list) {
		if (list.size() == 1) {
			return Math.abs(list.get(0) - 24) < 0.00001;
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Double> next = new ArrayList<>();
				for (int k = 0; k < list.size(); k++) {
					if (k != i && k != j) {
						next.add(list.get(k));
					}
				}
				for (Double d : allComb(list.get(i), list.get(j))) {
					next.add(d);//size--;
					if (backtrack(next)) {
						return true;
					} else {
						next.remove(next.size() - 1);
					}
				}
			}
		}
		return false;
	}

	private static List<Double> allComb(double a, double b) {
		List<Double> list = Arrays.asList(a + b, a * b, a - b, b - a, a / b, b / a);
		return list;
	}

}
