package Lai.Midterm_I_II_III;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Generate_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
//		list.add(3);
//		list.add(9);
//		list.add(6);
//		list.add(2);
//		list.add(7);
//		list.add(4);
//		list.add(1);
//		list.add(5);
		for(ListIterator<Integer> it = list.listIterator(); it.hasNext(); ) {
			System.out.println(""+it.next());
			if(it.hasNext()) {
				System.out.println(""+it.next());
				System.out.println(""+it.previous());
			}
		}
//		list.add(new Integer(3));
		
//		System.out.println(""+list);
//		generateBlocks(3);
	}

	public static void generateBlocks(int n) {
		if (n < 1) {
			return;
		}
		char[] arr = new char[2 * n];
		helper(arr, n, n, 0);
	}

	private static void helper(char[] arr, int left, int right, int pos) {
		if (left == 0 && right == 0) {
//			System.out.println(""+ String.valueOf(arr));
			print(arr);
			System.out.println("----------------------");
			return;
		}
		if (left > 0) {
			arr[pos] = '{';
			helper(arr, left - 1, right, pos + 1);
		}
		if (left < right) {
			arr[pos] = '}';
			helper(arr, left, right - 1, pos + 1);
		}

	}

	private static void print(char[] arr) {
		int level = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '{') {
				print(level);
				System.out.println("if {");
				level++;
			} else {
				level--;
				print(level);
				System.out.println("}");
			}
		}
	}

	private static void print(int level) {
		StringBuilder sb = new StringBuilder();
		while (--level >= 0) {
			sb.append("  ");
		}
		System.out.print("" + sb.toString());
		return;
	}

//	public static void generateBlocks(int n) {
//		if (n <= 0) {
//			return;
//		}
//		Map<Integer, String> map = new HashMap<>();
//		String prefix = "";
//		for (int i = 0; i <= n; i++) {
//			map.put(i, prefix);
//			prefix += "  ";
//		}
//		int level = 0;
//	    helper_0(n, n, new StringBuilder(), map, level);
////		helper(n, n, new StringBuilder(), map);
//		return;
//	}
//
////	worked
//	private static void helper_0(int left, int right, StringBuilder sb, Map<Integer, String> map, int level) {
//		if (left > right || left < 0 || right < 0) {
//			return;
//		}
////		System.out.println("level: \n" + level);
//		if (left == 0 && right == 0) {
//			System.out.println("" + sb.toString());
//			System.out.println("------------------------");
//			return;
//		}
//		String val = map.get(level) + "if {\n";
//		sb.append(val);
//		helper_0(left - 1, right,  sb, map, level + 1);
//		sb.delete(sb.length() - val.length() , sb.length());
//    
//		val = map.get(level - 1) + "}\n";
//		sb.append(map.get(level - 1) + "}\n");
//		helper_0(left, right - 1, sb , map, level - 1);
//		sb.delete(sb.length() - val.length() , sb.length());
//
//////		String val = map.get(level) + "if {\n";
////		String val = map.get(level) + "{\n";
////		sb.append(val);
//////		sb.append(map.get(level) + "if {\n");
////		helper_0(left - 1, right,  sb, map, level + 1);
////		sb.delete(sb.length() - val.length() , sb.length());
//////		sb.delete(sb.length() - 2*level - 6 , sb.length());
////		val = map.get(level - 1) + "}\n";
////		sb.append(val);
//////		sb.append(map.get(level - 1) + "}\n");
////		helper_0(left, right - 1, sb , map, level - 1);
////		sb.delete(sb.length() - val.length() , sb.length());
//////		sb.delete(sb.length() - 2*level - 2 , sb.length());
//	}
//
//	private static void helper(int left, int right, StringBuilder sb, Map<Integer, String> map) {
//		if (left > right || left < 0 || right < 0) {
//			return;
//		}
//		if (left == 0 && right == 0) {
//			print(sb, map);
//			return;
//		}
//		helper(left - 1, right, sb.append("{") , map);
//		helper(left, right - 1, sb.append("}"), map);
//	}
//
//	private static void print(StringBuilder sb, Map<Integer, String> map) {
//		int level = 0;
////		char[] arr = sb.toCharArray();
//		for(int i = 0; i < sb.length(); i++) {
////		for (char ch : arr) {
//			char ch = sb.charAt(i);
//			if (ch == '{') {
//				System.out.println(map.get(level) + "if {");
//				level++;
//			} else {
//				level--;
//				System.out.println(map.get(level) + "}");
//			}
//
//		}
//		System.out.println();
//	}
}

/*
 * { { { {}}}} { { {} {}}} { { {}} {}} { { {}}} {}
 * 
 */