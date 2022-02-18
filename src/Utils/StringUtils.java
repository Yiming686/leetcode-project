package Utils;

import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import Utils.ListNodeUtils.ListNode;

public class StringUtils {
	public static void BBB() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "66. All Valid Permutations Of Parentheses I";
//		String str = "Determine If One String Is Another's Substring";
//		System.out.println(""+connByUnderscore(str));
		System.out.println("Lai_" + connByUnderscore(str));
//		System.out.println(""+connByUnderscore(str));
	}

	public static String connByUnderscore(String str) {
		char[] arr = str.trim().replaceAll("\\.", "").toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ' || (!Character.isDigit(arr[i]) && !Character.isLetter(arr[i]))) {
				arr[i] = '_';
			}
		}
		return new String(arr);
	}
	public static String toDashStr(int len) {
		StringBuilder sb = new StringBuilder();
		while(--len >= 0) {
			sb.append("-");
		}
		return sb.toString();
	}
	public static String toUnderscoreStr(int len) {
		StringBuilder sb = new StringBuilder();
		while(--len >= 0) {
			sb.append("_");
		}
		return sb.toString();
	}
	public static String toSpaceStr(int len) {
		StringBuilder sb = new StringBuilder();
		while(--len >= 0) {
			sb.append(" ");
		}
		return sb.toString();
	}
	public static String toStr(Deque<Integer> stack) {
		// TODO Auto-generated method stub
		return stack == null ? "null" : stack.toString();
	}

	public static String toStr(StringBuilder sb) {
		return sb == null ? "null" : sb.toString();
	}

	public static String toStr(Character[] arr) {
		return arr == null ? "null" : Arrays.toString(arr);
	}

	public static String toStr(Set set) {
		return set == null ? "null"
				: "[" + String.valueOf(set.stream().map(n -> n.toString()).collect(Collectors.joining(",")) + "]");
	}

	public static String toStr(Map map) {
		return map == null ? "null"
				: "[" + String
						.valueOf(map.entrySet().stream().map(n -> n.toString()).collect(Collectors.joining(",")) + "]");
	}

	public static String toStr(TreeNodeUtils.TreeNode node) {
		return node == null ? "null" : String.valueOf(node.val);
	}

//	public static String toStr(int[] arr) {
//		return arr == null ? "null" : Arrays.toString(arr);
//	}

	public static String toStr(Integer[] arr) {
		return arr == null ? "null" : Arrays.toString(arr);
	}

	public static String toStr(char[] arr) {
		//		
		return arr == null ? "null" : Arrays.toString(arr);
	}
	
	public static void print(String str) {
		print("", str);
	}
	public static void print(String comment, String str) {
		System.out.println(comment + str);
	}

}
