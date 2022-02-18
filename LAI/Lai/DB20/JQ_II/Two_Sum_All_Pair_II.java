package Lai.DB20.JQ_II;

import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

public class Two_Sum_All_Pair_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[] { -1, 1 };
//		int[] arr = new int[] { 3, 5, 3, 2, 4, 4 };
//		int[] arr = new int[] { 4,1,3,2 };
//		int[] arr = new int[] { 2, 4,1,2,3,2 };
		int[] arr = new int[]{3,4,0,-1,2,0,5};
//		int target = 0;
//		int target = 13;
//		int target = 8;
		int target = 4;
		int k = 3;
		System.out.println("" + allPairs(arr, target, k));
	}

	public static List<List<Integer>> allPairs(int[] arr, int target, int k) {
		// Write your solution here
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> pair = new LinkedList<>();
//		Arrays.sort(arr);
		System.out.println(""+Arrays.toString(arr));
		TP root = TP.build("", "01000", "root", null);
		dfs(result, pair, arr, 0, 0, target, k, TP.build("root", null, result, pair, StringUtils.toStr(arr), 0, target));
		root.print();
		return result;
	}

//	O(N^k)
	private static void dfs(List<List<Integer>> result, List<Integer> pair, int[] arr, int level, int pos, int target,
			int k, TP root) {
		if (level == k) {
			if (0 == target) {
				result.add(new ArrayList<>(pair));
			}
			System.out.println("" + pair);
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = pos; i < arr.length; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
				// swap(arr, pos, i);
				pair.add(arr[i]);
				dfs(result, pair, arr, level + 1, i +1, target - arr[i], k,
						TP.build(root, result, pair, StringUtils.toStr(arr), level + 1, target - arr[i]));
				pair.remove(pair.size() - 1);
				// swap(arr, pos, i);
			}
		}

	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
