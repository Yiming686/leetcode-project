package Lai.Midterm_I_II_III;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class permu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
//		permutations(str);
		System.out.println("" + permutations(str));
	}

	public static List<String> permutations(String str) {
		// Write your solution here
		List<String> result = new ArrayList<>();
//		StringBuilder sb = new StringBuilder();
		String sb = new String();
		char[] arr = str.toCharArray();
		TP tracingPara = TP.build("[result:level]","0001",null, result, String.valueOf(arr), 0, sb.toString());
		helper(result, arr, 0, sb, tracingPara);
		tracingPara.print();

		return result;
	}

	// (1) result存放所有最终的结果，也就是所有可能的排列
	// (2) arr 单个变量，初始化为静态的值，但是经过递归变化，可以动态遍历所有可能的排列，当符合条件的时候，其快照存入result，
	// (3) index表示它的左边从0开始不包含它的位置已经选好元素了，
	// 所以只给index这个位置，从目前arr里面可能选择的字符里面，选取一个
	// index初始化为0，从0位置开始选择所有可能的元素放入，一个都不能缺，当index变为len-1或者len时就可以结束了。
	// 要将元素搬来搬去，还能随机选取，string要变为数组

	private static void helper(List<String> result, char[] arr, int level,String sb , TP parent) {
		if (level == arr.length) {
			result.add(sb);
			return;
		}
//		sb.append(arr[level]);
		String temp1 = sb;
		sb += arr[level];
		if(level != arr.length -1) {
//			sb.append("_");
			String temp2 = sb;
			sb += "_";
			helper(result, arr, level + 1, sb, TP.build(parent, result, String.valueOf(arr), level + 1, sb.toString()));
			sb = temp2;
//			sb.deleteCharAt(sb.length() - 1);
		}
		helper(result, arr, level + 1, sb, TP.build(parent, result, String.valueOf(arr), level + 1, sb.toString()));
		sb = temp1;
//		sb.deleteCharAt(sb.length() - 1);
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
