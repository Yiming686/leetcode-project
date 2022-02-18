package Lai.DFS_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class Combination_Sum {

	public static void main(String[] args) {
//		int[] coins = {34,31,29,16,2};
//		int[] coins = { 5, 10, 25 };
		int[] coins = { 2,3,6,7 };
//		System.out.println("coin: "+Arrays.toString(coins));
//		char[] arr = {'\u0000','3','8','\u0000'};
//		System.out.println("arr: "+Arrays.toString(arr));
		System.out.println("" + combinationSum(coins, 7));
		;

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null) {
			return result;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);//ÅÅÐòÄ¿µÄ
		TP paraRoot = TP.build("[sb:level]","01011", null, result, list, Arrays.toString(candidates), 0, target);
		helper(result, list, candidates, 0, target, paraRoot);
//		helper(result, coins, sol, target, 0, paraRoot);

		paraRoot.print();

		return result;
		
	}

	static void helper(ArrayList<List<Integer>> result, ArrayList<Integer> list, int[] candidates, int index, int target, TP paraRoot) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		// int prev = -1;
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}

			// if (prev != -1 && prev == candidates[i]) {
			//     continue;
			// }

			list.add(candidates[i]);
			helper(result, list, candidates, i, target - candidates[i], TP.build(paraRoot,result, list, Arrays.toString(candidates), i, target - candidates[i]));
			list.remove(list.size() - 1);

			// prev = candidates[i];
		}
	}

}
