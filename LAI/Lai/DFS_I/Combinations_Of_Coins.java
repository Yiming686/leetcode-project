package Lai.DFS_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Utils.TreeNodeUtils.TP;

public class Combinations_Of_Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] coins = {34,31,29,16,2};
		int[] coins = {5,10,25};
//		System.out.println("coin: "+Arrays.toString(coins));
//		char[] arr = {'\u0000','3','8','\u0000'};
//		System.out.println("arr: "+Arrays.toString(arr));
		System.out.println(""+combinations(50, coins));;
	}

//	����һ��Ӳ������Ŀ��ֵ�������Щ�������и�����ϣ�ʹ�����ǵĺ�ΪĿ��ֵ
//	coins: һ�����
//	target: Ŀ��ֵ
	public static List<List<Integer>> combinations(int target, int[] coins) {
		// Write your solution here
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
