package Lai.DFS_I;

import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

/**



Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Input: "()())()"
Output: ["()()()", "(())()"]

Input :  
)(
Output:  
[]

Input :  
(a)(
Output:  
[(a)]


 *
 */
public class Remove_Invalid_Parentheses {
	static char ch;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		System.out.println(""+removeInvalidParentheses("()())()"));
		System.out.println("ch:"+ ch);
		char[] arr = new char[2];
		System.out.println("char:"+ (arr[0] == '\u0000'));
//		System.out.println(""+removeInvalidParentheses(")())("));
		System.out.println(""+removeInvalidParentheses("(a)())()"));
//		System.out.println(""+removeInvalidParentheses(")))"));
	}

//	O(D^N*N) D is diff,
	public static List<String> removeInvalidParentheses(String str) {
		// 1. 需要统计分别有多少个左括号，右括号需要删除
		// 2. 遍历string:
		// 当遇到左括号，且待删除的左括号个数大于零，那么就删除当前，再DFS递归判断当左右都是0的时候，是不是valid
		// 当遇到右括号，且待删除的右括号个数大于零，那么就删除当前，再DFS递归判断当左右都为0的时候，是不是valid
		// 3. 需要一个检验当前string是不是valid的函数

		// corner case:
		List<String> result = new ArrayList<>();
		if (str == null || str.length() == 0) {
			result.add("");
			return result;
		}

		// 1.统计待删除的左右括号个数
		int[] count = needToDelete(str);

//		StringBuilder cur = new StringBuilder(str);
		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder(str);
		TP root = TP.build("", "11111", null, StringUtils.toStr(sb), 0, count[0], count[1], result);
//		removeInvalid01(sb, 0, count[0], count[1], result, root);
//		removeInvalid02(arr, 0, count[0], count[1], result, root);
		removeInvalid03(sb, 0, count[0], count[1], result, root);
		root.print();
		System.out.println(""+result);
		return result;
	}

////	O(N)
//	private static void removeInvalid02(char[] arr, int start, int left, int right, List<String> result, TP root) {
//		// base case: 当需要删除的左右括号数都等于0，并且当前的这个substring是valid的，就加入res中
//		if (left == 0 && right == 0) {
////			int[] arr = needToDelete(sb.toString());
////			if (arr[0] == 0 && arr[1] == 0) {
//				result.add(new String(arr));
//				TP.build(TP.IS_BASE_CASE, root, Arrays.toString(arr), start, left, right, result);
////			}
//			return;
//		}
//		// 遍历string，从start开始往后遍历：
//		for (int i = start; i < arr.length; i++) {
//			// 先去重：如果当前char与之前相同，就继续
//			if (i > start && arr.charAt(i) == sb.charAt(i - 1)) {
//				continue;
//			}
//
//			// 如果遇到左括号且需要删除的左括号数大于0，那么就删除这个左括号，做DFS递归
//			if (sb.charAt(i) == '(' && left > 0) {
//				sb.deleteCharAt(i);
//				removeInvalid02(arr, i, left - 1, right, result, TP.build(root, Arrays.toString(arr), i, left - 1, right, result));
//				sb.insert(i, '('); // backtracking回去
//			}
//			// 如果遇到右括号且需要删除的右括号数大于0，那么就删除这个右括号，做DFS递归
//			if (sb.charAt(i) == ')' && right > 0) {
//				sb.deleteCharAt(i);
//				removeInvalid02(arr, i, left, right - 1, result, TP.build(root, Arrays.toString(arr), i, left, right - 1, result));
//				sb.insert(i, ')');
//			}
//		}
//	}
	
//	O(N)
	private static void removeInvalid01(StringBuilder sb, int start, int left, int right, List<String> result, TP root) {
		// base case: 当需要删除的左右括号数都等于0，并且当前的这个substring是valid的，就加入res中
		if (left == 0 && right == 0) {
//			int[] arr = needToDelete(sb.toString());
//			if (arr[0] == 0 && arr[1] == 0) {
				result.add(sb.toString());
				TP.build(TP.IS_BASE_CASE, root, sb, start, left, right, result);
//			}
			return;
		}
		// 遍历string，从start开始往后遍历：
		for (int i = start; i < sb.length(); i++) {
			// 先去重：如果当前char与之前相同，就继续
			if (i > start && sb.charAt(i) == sb.charAt(i - 1)) {
				continue;
			}

			// 如果遇到右括号且需要删除的右括号数大于0，那么就删除这个右括号，做DFS递归
			if (sb.charAt(i) == ')' && right > 0) {
				sb.deleteCharAt(i);
				removeInvalid01(sb, i, left, right - 1, result, TP.build(root, sb, i, left, right - 1, result));
				sb.insert(i, ')');
			}
			// 如果遇到左括号且需要删除的左括号数大于0，那么就删除这个左括号，做DFS递归
			if (sb.charAt(i) == '(' && left > 0) {
				sb.deleteCharAt(i);
				removeInvalid01(sb, i, left - 1, right, result, TP.build(root, sb, i, left - 1, right, result));
				sb.insert(i, '('); // backtracking回去
			}
		}
	}

//	O(N)
//	left, right表示当前位置前，(和)的需要删除的个数；当前是(，则left++;当前是)，则right++；
	private static int[] needToDelete(String str) {
		int left = 0, right = 0;
		int[] arr = new int[2];
		for (char c : str.toCharArray()) {
			if (c == '(') {
				left++;
			} else if (c == ')') {
				if (left > 0) {
					left--;
				} else {
					right++;
				}
			}
		}
		arr[0] = left;
		arr[1] = right;
		return arr;
	}
//从start开始，删除l+r个需要删除的，每一层删除一个
	private static void removeInvalid03(StringBuilder sb, int start, int left, int right, List<String> result, TP root) {
		// base case: 当需要删除的左右括号数都等于0，并且当前的这个substring是valid的，就加入res中
		if (left == 0 && right == 0) {
//			int[] arr = needToDelete(sb.toString());
//			if (arr[0] == 0 && arr[1] == 0) {
				if(isValid(sb.toString())) {
					result.add(sb.toString());
					TP.build(TP.IS_BASE_CASE, root, sb, start, left, right, result);
				}
//			}
			return;
		}
		// 遍历string，从start开始往后遍历：
		for (int i = start; i < sb.length(); i++) {
			// 先去重：如果当前char与之前相同，就继续
			if (i > start && sb.charAt(i) == sb.charAt(i - 1)) {
				continue;
			}

			// 如果遇到右括号且需要删除的右括号数大于0，那么就删除这个右括号，做DFS递归
			if (sb.charAt(i) == ')' && right > 0) {
				sb.deleteCharAt(i);
				removeInvalid03(sb, i, left, right - 1, result, TP.build(root, sb, i, left, right - 1, result));
				sb.insert(i, ')');
			}
			// 如果遇到左括号且需要删除的左括号数大于0，那么就删除这个左括号，做DFS递归
			if (sb.charAt(i) == '(' && left > 0) {
				sb.deleteCharAt(i);
				removeInvalid03(sb, i, left - 1, right, result, TP.build(root, sb, i, left - 1, right, result));
				sb.insert(i, '('); // backtracking回去
			}
		}
	}
	static boolean isValid(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				count++;
			}else if(str.charAt(i) == ')'){
				count--;
				if(count < 0) {
					return false;
				}
			}
		}
		return count == 0;
	}

}
