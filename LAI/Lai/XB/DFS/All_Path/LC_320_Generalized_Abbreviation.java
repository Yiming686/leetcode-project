package Lai.XB.DFS.All_Path;

import static Utils.ArrayUtils.convertCharacterArr2CharArr;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class LC_320_Generalized_Abbreviation {

	public static void main(String[] args) {

		System.out.println("" + subSets("word"));
//		System.out.println("" + subSets("interaction"));
	}

//    public static List<String> generateAbbreviations(String word) {
//        
//    }

//	public static List<String> subSets(String set) {
//		// Write your solution here.
//		List<String> result = new ArrayList<String>();
//		if (set == null) {
//			return result;
//		}
//		char[] arr = set.toCharArray();
//		StringBuilder sb = new StringBuilder();
////		StringBuilder sb = new StringBuilder();
//		// sb遍历所有可能的子集，快照进入result，最后返回result
//		//index从0开始逐层向下递增，0--len-1每层遍历不同字符，append然后删除，下层即终止，只有arr不变
//		
//		TP paraRoot = TP.build("[sb:level]",  "0100", null, result, sb, String.valueOf(arr), 0);
//		helper(result, sb, arr, 0, paraRoot);
//		paraRoot.print();
//		System.out.println("result: "+ result);
//		return result;
//
//	}
//	private static void helper(List<String> result, StringBuilder sb, char[] arr, int pos, TP paraRoot) {
//		if (pos == arr.length) {
//			result.add(sb.toString());
//			return;
//		}
//		sb.append(arr[pos]);
//		helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));
//		sb.deleteCharAt(sb.length() - 1);
//		
//		if(sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1))) {
//			int val = Character.digit(sb.charAt(sb.length() - 1), 10);
//			sb.deleteCharAt(sb.length() - 1);
//			sb.append(""+(val + 1));
//			helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));
//		}else {
//			sb.append("1");
//			helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));
//			sb.deleteCharAt(sb.length() - 1);
//		}
//	}

//	2 branches
	public static List<String> subSets(String word) {
		List<String> result = new ArrayList<String>();
		if (word == null) {
			return result;
		}
		char[] arr = word.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 0;//how many empty chars
		subSets(result, sb, arr, 0, 0);
		System.out.println("" + result);
		return result;
	}

	private static void subSets(List<String> result, StringBuilder sb, char[] arr, int pos, int count) {
		if(pos == arr.length) {
			if(count > 0) {
				String str = String.valueOf(count);
				sb.append(str);
				result.add(sb.toString());
				sb.delete(sb.length() - str.length(), sb.length());
			}else {
				result.add(sb.toString());
			}
			return;
		}
		subSets(result, sb, arr, pos + 1,  count + 1 );
		if(count == 0) {
			sb.append(arr[pos]);
			subSets(result, sb, arr, pos + 1,  0 );
			sb.deleteCharAt(sb.length() - 1);
		}else {
			String str = String.valueOf(count);
			sb.append(str);
			sb.append(arr[pos]);
			subSets(result, sb, arr, pos + 1,  0 );
			sb.deleteCharAt(sb.length() - 1);
			sb.delete(sb.length() - str.length(), sb.length());
		}
	}

//	N branches
	public static List<String> geneAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		if (word == null) {
			return result;
		}
		char[] arr = word.toCharArray();
		StringBuilder sb = new StringBuilder();
		helper(result, sb, arr, 0);
		System.out.println("" + result);
		return result;
	}

	private static void helper(List<String> result, StringBuilder sb, char[] arr, int pos) {
//		System.out.println("sb:"+sb);
		if (pos == arr.length) {
			result.add(sb.toString());
			return;
		}
		sb.append(arr[pos]);
		helper(result, sb, arr, pos + 1);
		sb.deleteCharAt(sb.length() - 1);
		if (sb.length() == 0 || !Character.isDigit(sb.charAt(sb.length() - 1))) {
			for (int i = pos; i < arr.length; i++) {
				int len = i - pos + 1;
				System.out.println("len:" + len);
				System.out.println("sub:" + len);
				sb.append("" + len);
				helper(result, sb, arr, i + 1);
				sb.delete(sb.length() - String.valueOf(len).length(), sb.length());
			}
		}
	}
}
