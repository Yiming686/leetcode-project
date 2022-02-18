package Leet.Array.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_78_Subsets {

//	 ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
//	 [[], [1], [2], [2, 1], [3], [3, 1], [3, 2], [3, 2, 1]]
//			 
//	 [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
//	 [[], [1], [1, 2], [1, 2, 3] [1, 3], [2], [2, 3], [3]  ]
			 
//	[[], [1], [2], [2, 1], [3], [3, 1], [3, 2], [3, 2, 1]]
//	[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]

//	[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
//	[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
//		int[] nums = { 3,2,1 };
		
//		int[] nums = { 1, 2, 2, 3 };
		System.out.println("" + subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
//	public static List<List<Integer>> subsets_dfs_type_II(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<>();
//		Arrays.sort(nums);

		susets(result, nums, list, 0, 0);
//		susets(result, nums, list, 0);
		return result;
	}

	private static void susets(List<List<Integer>> result, int[] nums, List<Integer> list, int pos, int sum) {
		if (pos == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
//		System.out.println("sum: " + sum);
		list.add(nums[pos]);
		susets(result, nums, list, pos + 1, sum + nums[pos]);
		list.remove(list.size() - 1);
		susets(result, nums, list, pos + 1, sum);
	}

//	public static List<List<Integer>> subsets(int[] nums) {
	public static List<List<Integer>> subsets_dfs_type_I(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<>();
		susets(result, nums, list, 0);
		return result;
	}

	private static void susets(List<List<Integer>> result, int[] nums, List<Integer> list, int pos) {
		result.add(new ArrayList<>(list));
		for (int i = pos; i < nums.length; i++) {
			if (!list.contains(nums[i])) {
				list.add(nums[i]);
				susets(result, nums, list, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

}
