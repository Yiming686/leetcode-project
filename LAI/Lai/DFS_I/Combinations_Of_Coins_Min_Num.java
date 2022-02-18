package Lai.DFS_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Utils.TreeNodeUtils.TP;

public class Combinations_Of_Coins_Min_Num {

	public static void main(String[] args) {
		int[] coins = {5,10,25};
		System.out.println(""+combinationsWithMinNum(0, coins));;
	}
	public static int combinationsWithMinNum(int target, int[] coins) {
		int[] min = new int[target + 1]; // return min[target]
		Arrays.fill(min, target + 1);
		//min[0] = 0; ???
		min[0] = 0; // �ܺ�Ϊ0�����Ӳ�ҵ���С����Ϊ0����ȷ��// �ܺ�Ϊ1�����Ӳ�ҵ���С����Ϊ-1����ʾ���ɴ������ȷ��
		for(int i = 0; i <= target; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0) {
					min[i] = Math.min(min[i], min[i - coins[j]] + 1);
				}
			}
		}
		return min[target] == target + 1 ? -1 : min[target];
	}

//	����һ��Ӳ������Ŀ��ֵ�������Щ�������и�����ϣ�ʹ�����ǵĺ�ΪĿ��ֵ
//	coins: һ�����
//	target: Ŀ��ֵ
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

	
// ���⣺����һ��Ӳ������Ŀ��ֵ�������Щ�������и�����ϣ�ʹ�����ǵĺ�ΪĿ��ֵ
// ˼·����������ϵĿ����Խ��з��࣬�ӵ�һ����ʼ���𲽿���
//	1. ��һ��Ӳ��ʹ��һ����Ȼ����������� f(coins��target - 1 * coins[0])
//	2. ��һ��Ӳ��ʹ�ö���, Ȼ����������� f(coins��target - 2 * coins[0])
//	3. ��һ��Ӳ��ʹ������, Ȼ����������� f(coins��target - 3 * coins[0])
//	4. ��һ��Ӳ�Ҷ���ʹ��n��, Ȼ����������� f(coins��target - n * coins[0])
// result: ���ķ���ֵ���������и�����͵��б�
// sol: ��ӦӲ�ҵ�һ�������� 
// coins: ����һ����ʼ�ձ��ֲ���
// target: Ŀ��ֵ
// index: ��������Ӳ�����ĵ�ǰ��������0��ʼ������coins.length,����ʾcoinsʹ�����ˣ�û��coins������
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
