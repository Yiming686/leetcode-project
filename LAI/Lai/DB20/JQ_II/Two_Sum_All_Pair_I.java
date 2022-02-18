package Lai.DB20.JQ_II;

import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

public class Two_Sum_All_Pair_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[] { -1, 1 };
		int[] arr = new int[] { 3, 5, 3, 2, 4, 4 };
//		int[] arr = new int[] { 1,2,2,2,3,3,4,4};
//		int target = 0;
		int target = 8;
		int k = 2;
		System.out.println("" + allPairs(arr, target));
	}

	public static List<List<Integer>> allPairs(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();//key=num, value = indices
		for (int i = 0; i < arr.length; i++) {
			List<Integer> indices = map.get(target - arr[i]);
			if (indices != null) {
				for (int j : indices) {
					result.add(Arrays.asList(i, j));
				}
			}
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<Integer>());
			}
			map.get(arr[i]).add(i);
			System.out.println("i:"+ map);
			System.out.println("i:"+ result);
			
		}
		System.out.println(""+map);
		return result;
	}

	public static List<List<Integer>> allPairs_N2(int[] arr, int target, int k) {
		// Write your solution here
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> pair = new LinkedList<>();
		TP root = TP.build("", "01000", "root", null);
		dfs(result, pair, arr, 0, 0, target, k, TP.build("root", null, result, pair, StringUtils.toStr(arr), 0, target));
		root.print();
		return result;
	}

	private static void dfs(List<List<Integer>> result, List<Integer> pair, int[] arr, int level, int pos, int target,
			int k, TP root) {
		if (level == k) {
			if (0 == target) {
				result.add(new ArrayList<>(pair));
			}
			System.out.println("" + pair);
			return;
		}
		for (int i = pos; i < arr.length; i++) {
			// swap(arr, pos, i);
			pair.add(i);
			dfs(result, pair, arr, level + 1, i + 1, target - arr[i], k,
					TP.build(root, result, pair, StringUtils.toStr(arr), level + 1, target));
			pair.remove(pair.size() - 1);
			// swap(arr, pos, i);
		}

	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
