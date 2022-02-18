package Lai.Ace.DFS3.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.TreeNodeUtils.TP;

public class Subset_II {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();
		System.out.println("1:"+map.containsKey('d'));
		System.out.println("2:"+map.get('d'));
		map.put('d', 33);
		System.out.println("3:"+map.containsKey('d'));
		System.out.println("4:"+map.get('d'));
		map.remove('d');
		System.out.println("5:"+map.containsKey('d'));
		System.out.println("6:"+map.get('d'));
		map.put('d', 33);
		System.out.println("7:"+map.containsKey('d'));
		System.out.println("8:"+map.get('d'));
		map.put('d', null);
		System.out.println("9:"+map.containsKey('d'));
		System.out.println("10:"+map.get('d'));

		// TODO Auto-generated method stub
//		System.out.println(""+subSets("abc"));
		System.out.println(""+subSets("abbbc"));
	}
	public static List<String> subSets(String set) {
		// Write your solution here.
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arr = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		// sb�������п��ܵ��Ӽ������ս���result����󷵻�result
		//index��0��ʼ������µ�����0--len-1ÿ�������ͬ�ַ���appendȻ��ɾ�����²㼴��ֹ��ֻ��arr����
		
		TP paraRoot = TP.build("[sb:level]",  "0101", null, result, sb, String.valueOf(arr), 0);
		helper(result, sb, arr, 0, paraRoot);
		paraRoot.print();
//		System.out.println("result: "+ result);
		return result;

	}

	private static void helper(List<String> result, StringBuilder sb, char[] arr, int pos, TP paraRoot) {
		if (pos == arr.length) { 
			result.add(sb.toString());
			return;
		}
		sb.append(arr[pos]);
		helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));
		sb.deleteCharAt(sb.length() - 1);
		while(pos + 1 < arr.length && arr[pos] == arr[pos + 1]) {
			pos++;
		}
		helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));

	}


}
