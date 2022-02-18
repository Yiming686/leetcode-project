package Leet.String.Expression_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class Leet_679_24_Game_II {

	public static void main(String[] args) {
		LinkedHashMap map = new LinkedHashMap<>();
		ConcurrentSkipListMap map2 = new ConcurrentSkipListMap<>();
		map2.firstEntry();
		map2.lastEntry();
//		map.
		// TODO Auto-generated method stub
//		int[] nums = {4, 1, 8, 7};
		int[] nums = {4, 1, 8, 7};
//		int[] nums = {4,6,13,4};
		
//		System.out.println(""+judgePoint24(nums));
		Set<String> result = new HashSet<>();
		result.addAll(judgePoint24(nums));
		int num = result.size();
		System.out.println("总共有 "+num+" 种算法：");
		for( String str : result) {
			System.out.println(""+str);
		}
	}

	public static List<String> judgePoint24(int[] nums) {
		//Sanity Check
		 List<String> result = new ArrayList<>();
		List<Pair> list = new ArrayList<>();
		for (int n : nums) {
			list.add(new Pair("" + n, Double.valueOf(n)));
		}
		StringBuilder sb = new StringBuilder();
		backtrack(result, list);
		return result;
	}
	static class Pair{
		String str;
		Double val;
		Pair(String str, Double val){
			this.str = str;
			this.val = val;
		}
	}
	private static void backtrack(List<String> result, List<Pair> list) {
		if (list.size() == 1) {
			 if(Math.abs(list.get(0).val - 24) < 0.00001) {
//				 result.add(list.get(0).str + " = 24");
//				 result.add(list.get(0).str.trim().substring(1, list.get(0).str.trim().length() - 1) + " = 24");
				 result.add(list.get(0).str.substring(1, list.get(0).str.length() - 1) + " = 24");
			 }
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Pair> next = new ArrayList<>();
				for (int k = 0; k < list.size(); k++) {
					if (k != i && k != j) {
						next.add(list.get(k));
					}
				}
				for (Pair pair: allComb(list.get(i), list.get(j))) {
					next.add(pair);//size--;
					backtrack(result, next);
					next.remove(next.size() - 1);
				}
			}
		}
	}

//	private static List<Pair> allComb(Pair a, Pair b) {
//		List<Pair> list = new ArrayList<>();
//		list.add(new Pair("" + a.str + " + " + b.str +"", a.val + b.val));
//		list.add(new Pair("" + a.str + " * " + b.str +"", a.val * b.val));
//		list.add(new Pair("" + a.str + " - " + b.str +"", a.val - b.val));
//		list.add(new Pair("" + b.str + " - " + a.str +"", b.val - a.val));
//		list.add(new Pair("" + a.str + " / " + b.str +"", a.val / b.val));
//		list.add(new Pair("" + b.str + " / " + a.str +"", b.val / a.val));
//		return list;
//	}

	private static List<Pair> allComb(Pair a, Pair b) {
		List<Pair> list = new ArrayList<>();
		list.add(new Pair("(" + a.str + " + " + b.str +")", a.val + b.val));
		list.add(new Pair("(" + a.str + " * " + b.str +")", a.val * b.val));
		list.add(new Pair("(" + a.str + " - " + b.str +")", a.val - b.val));
		list.add(new Pair("(" + b.str + " - " + a.str +")", b.val - a.val));
		list.add(new Pair("(" + a.str + " / " + b.str +")", a.val / b.val));
		list.add(new Pair("(" + b.str + " / " + a.str +")", b.val / a.val));
		
//		list.add(new Pair("( " + a.str + " + " + b.str +" )", a.val + b.val));
//		list.add(new Pair("( " + a.str + " * " + b.str +" )", a.val * b.val));
//		list.add(new Pair("( " + a.str + " - " + b.str +" )", a.val - b.val));
//		list.add(new Pair("( " + b.str + " - " + a.str +" )", b.val - a.val));
//		list.add(new Pair("( " + a.str + " / " + b.str +" )", a.val / b.val));
//		list.add(new Pair("( " + b.str + " / " + a.str +" )", b.val / a.val));
		return list;
	}

	private static Map<String, Double> allMap(double a, double b) {
		Map<String, Double> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		map.put(sb.append(" ").append(Math.round(a + b)).append(" ").toString(), a + b);
		map.put(sb.append(" ").append(Math.round(a * b)).append(" ").toString(), a * b);
		map.put(sb.append(" ").append(Math.round(a - b)).append(" ").toString(), a - b);
		map.put(sb.append(" ").append(Math.round(b - a)).append(" ").toString(), b - a);
		map.put(sb.append(" ").append(Math.round(a / b)).append(" ").toString(), a / b);
		map.put(sb.append(" ").append(Math.round(b / a)).append(" ").toString(), b / a);

		return map;
	}

	private static List<Double> allComb(double a, double b) {
		List<Double> list = Arrays.asList(a + b, a * b, a - b, b - a, a / b, b / a);
		return list;
	}

}
