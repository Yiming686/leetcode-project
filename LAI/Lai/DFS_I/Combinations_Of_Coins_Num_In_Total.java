package Lai.DFS_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Utils.ArrayUtils;
import Utils.TreeNodeUtils.TP;

public class Combinations_Of_Coins_Num_In_Total {

	public static void main(String[] args) {
//		int[] coins = {2,4,8};
//		int[] coins = {5,10,25};
		int[] coins = {10,5,25};
		System.out.println(""+combinationsNumInTotal(50, coins));;

	}
	
	//个数有多少个
//	dp[0] = 1; 什么都不取，至少有这一种组合
	//dp问答：1. 时间序列是coins，它的次序可以交换。
//	2. coins可以凑成的<所有目标值>的可能性个数，初始化为100...00,
//	3. 对当前coin，尽可能用，带来的影响，更新<前面所有coin>可以凑成的<所有目标值>的可能性个数。
//	不用时的凑成当前目标值的可能性个数 加上 使用当前coin的可以凑成<当前目标值减去coin>的可能性个数，来更新局部变量。
//	4. 对当前coin，可能性分为用和不用，不用的次数加上用一个的次数，来更新局部变量。初始化为100...00,
//	5. 对
    public static int combinationsNumInTotal(int target, int[] coins) {
    	
//    		int[] arr = ArrayUtils.generateIntArray(0, target);
    	int[] arr = ArrayUtils.buildIntArrayNoDupSorted(target + 1, 0, target);
    		ArrayUtils.printIntArray(arr, 3);
        int[] dp = new int[target + 1];//index为可能的target
        dp[0] = 1;
        for (int coin : coins) {
        		ArrayUtils.printIntArray(arr, 3);
        		System.out.println("coin: "+ coin);
            for (int i = coin; i <= target; i++) {
            		System.out.println("target: "+ i);
            		if(dp[i] > 1 && dp[i-coin] > 1) {
//            			System.out.printf("<===>%s%3d,%s%3d,\n",Utils.generateCharStr(4*(i-coin - 1),'='), i-coin, Utils.generateCharStr(4*(coin - 1),'='), i );
            			System.out.printf("<===>%s%3d,%s%3d,\n",ArrayUtils.buildCharArrayAllDup(4*(i-coin - 1),'=', true, false), i-coin, ArrayUtils.buildCharArrayAllDup(4*(coin - 1),'=', true, false), i );
//            			System.out.printf("<===>%s%3d,%s%3d,\n",ArrayUtils.generateCharArrayAllDup(4*(i-coin - 1),'='), i-coin, ArrayUtils.generateCharArrayAllDup(4*(coin - 1),'='), i );
            		}
                dp[i] += dp[i-coin];
                ArrayUtils.printIntArray(dp, 3, 0);
            }
        }
		System.out.println("-------------------");
		ArrayUtils.printIntArray(dp, 3, 0);
        return dp[target];
    }
    
	public static int combinationsNumInTotal11(int target, int[] coins) {
		int[] numInTotal = new int[target + 1]; // return min[target]
		Arrays.fill(numInTotal, Integer.MAX_VALUE);
		//min[0] = 0; ???
		numInTotal[0] = 0; // 总和为0所需的硬币的最小个数为0，正确。// 总和为1所需的硬币的最小个数为-1，表示不可达，所以正确。
		for(int i = 0; i <= target; i++) {//遍历所有target的可能
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0) {
					numInTotal[i] = Math.min(numInTotal[i], numInTotal[i - coins[j]] + 1);
				}
			}
		}
		return numInTotal[target] == target + 1 ? -1 : numInTotal[target];
	}

//	给定一组硬币面额和目标值，求出这些面额的所有个数组合，使得它们的和为目标值
//	coins: 一组面额
//	target: 目标值
	public static List<List<Integer>> combinations00(int target, int[] coins) {
		List<List<Integer>> result = new ArrayList<>();
		
//		int[] sol = new int[coins.length];
//		TP paraRoot = TP.build("[sb:level]","00111", null, result, Arrays.toString(coins), Arrays.toString(sol), target, 0);
//		helper(result, coins, sol, target, 0, paraRoot);
		
		List<Integer> sol = new ArrayList<>(coins.length);
		TP paraRoot = TP.build("[sb:level]","00111", null, result, Arrays.toString(coins), sol, target, 0);
		helper(result, coins, sol, target, 0, paraRoot);

		paraRoot.print();

		return result;  
	}
	
	static void helper(List<List<Integer>> result, int[] coins, List<Integer> sol, int target, int index, TP paraRoot) {
		if (index == coins.length) {
			if (target == 0) {
				result.add(new ArrayList<Integer>(sol));
			}
			return;
		}
		for (int i = 0; i * coins[index] <= target; i++) {
			sol.add(i);
			helper(result, coins, sol, target - i * coins[index], index + 1, TP.build(paraRoot, result, Arrays.toString(coins),  sol, target - i * coins[index], index + 1));
			sol.remove(sol.size() - 1);
		}
	}

	
// 题意：给定一组硬币面额和目标值，求出这些面额的所有个数组合，使得它们的和为目标值
// 思路：将所有组合的可能性进行分类，从第一个面额开始，逐步考虑
//	1. 第一个硬币使用一个，然后求解子问题 f(coins，target - 1 * coins[0])
//	2. 第一个硬币使用二个, 然后求解子问题 f(coins，target - 2 * coins[0])
//	3. 第一个硬币使用三个, 然后求解子问题 f(coins，target - 3 * coins[0])
//	4. 第一个硬币顶多使用n个, 然后求解子问题 f(coins，target - n * coins[0])
// result: 最后的返回值，包含所有个数组和的列表
// sol: 对应硬币的一组个数组合 
// coins: 给定一组面额，始终保持不变
// target: 目标值
// index: 给定这组硬币面额的当前索引，从0开始，到达coins.length,即表示coins使用完了，没有coins可用了
	static void helper(List<List<Integer>> result, int[] coins, int[] sol, int target, int index, TP paraRoot) {

		if (index == coins.length) {
			if (target == 0) {
				result.add(new ArrayList<Integer>(Arrays.stream(sol).boxed().collect(Collectors.toList())));
//				result.add(new ArrayList<Integer>(IntStream.of(sol).boxed().collect(Collectors.toList())));
//				System.out.println("sol: "+ Arrays.asList(sol));
			}else {
				//System.out.println("Target: "+ target);
			}
			return;
		}
		for (int i = 0; i * coins[index] <= target; i++) {
			sol[index] = i;
//			System.out.println("sol: "+ Arrays.toString(sol));
//			helper(result, coins, sol, target - i * coins[index], index + 1, TP.build(tpRoot, result, Arrays.asList(sol), target - i * coins[index], index + 1));
			helper(result, coins, sol, target - i * coins[index], index + 1, TP.build(paraRoot, result, Arrays.toString(coins),  Arrays.toString(sol), target - i * coins[index], index + 1));
			
//			sol[index] = 0;
		}

	}

}
