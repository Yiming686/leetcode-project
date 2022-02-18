package Lintcode.String.Parentheses;

import java.util.HashMap;
import java.util.Map;

import Utils.StringUtils;

//   (2*(3-(4*5))) = -34 
//   ((2*3)-(4*5)) = -14 
//   ((2*(3-4))*5) = -10 
//   (2*((3-4)*5)) = -10 
//   (((2*3)-4)*5) = 10

public class Generate_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateBlocks(2);
//		generateBlocks(6);
	}

	public static void generateBlocks(int n) {
		if (n <= 0) {
			return;
		}
		Map<Integer, String> map = new HashMap<>();
		String prefix = "";
		for (int i = 0; i <= n; i++) {
			map.put(i, prefix);
			prefix += "  ";
		}
		int level = 0;
//	    helper_0(n, n, "", map, level);
		helper_1(n, n, "", map);
		return;
	}

//	worked
	private static void helper_0(int left, int right, String str, Map<Integer, String> map, int level) {
		if (left > right || left < 0 || right < 0) {
			return;
		}
		System.out.println("level: \n" + level);
		if (left == 0 && right == 0) {
			System.out.println("" + str);
			return;
		}
		helper_0(left - 1, right, str + map.get(level) + "if {\n", map, level + 1);
		helper_0(left, right - 1, str + map.get(level - 1) + "}\n", map, level - 1);
	}

	private static void helper_1(int left, int right, String str, Map<Integer, String> map) {
//		if (left > right || left < 0 || right < 0) {
//			return;
//		}
//		if (left < 0 || right < 0) {
//			return;
//		}
		if (str.length() == 6) {

//		if (str.length() == 4 && ( left == 0 || right == 0)) {
			System.out.println(str);
			return;
		}
		if (left == 0 && right == 0) {
//			print(str);
//			print(str, map);
			StringUtils.print(str);
			return;
		}
//		if(left > 0) {
			helper_1(left - 1, right, str + "{", map);
//		}
//		if(right > 0) {
			helper_1(left, right - 1, str + "}", map);
//		}
	}

	private static void print(String str) {
//		int level = 0;
//		char[] arr = str.toCharArray();
//		for (char ch : arr) {
//			if (ch == '{') {
//				System.out.println(map.get(level) + "if {");
//				level++;
//			} else {
//				level--;
//				System.out.println(map.get(level) + "}");
//			}
//
//		}
		System.out.println(str);
	}
	private static void print(String str, Map<Integer, String> map) {
		int level = 0;
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			if (ch == '{') {
				System.out.println(map.get(level) + "if {");
				level++;
			} else {
				level--;
				System.out.println(map.get(level) + "}");
			}

		}
		System.out.println();
	}
}

/*
 * { { { {}}}} { { {} {}}} { { {}} {}} { { {}}} {}
 * 
 */