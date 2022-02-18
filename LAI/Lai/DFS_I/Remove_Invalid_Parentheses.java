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
		// 1. ��Ҫͳ�Ʒֱ��ж��ٸ������ţ���������Ҫɾ��
		// 2. ����string:
		// �����������ţ��Ҵ�ɾ���������Ÿ��������㣬��ô��ɾ����ǰ����DFS�ݹ��жϵ����Ҷ���0��ʱ���ǲ���valid
		// �����������ţ��Ҵ�ɾ���������Ÿ��������㣬��ô��ɾ����ǰ����DFS�ݹ��жϵ����Ҷ�Ϊ0��ʱ���ǲ���valid
		// 3. ��Ҫһ�����鵱ǰstring�ǲ���valid�ĺ���

		// corner case:
		List<String> result = new ArrayList<>();
		if (str == null || str.length() == 0) {
			result.add("");
			return result;
		}

		// 1.ͳ�ƴ�ɾ�����������Ÿ���
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
//		// base case: ����Ҫɾ��������������������0�����ҵ�ǰ�����substring��valid�ģ��ͼ���res��
//		if (left == 0 && right == 0) {
////			int[] arr = needToDelete(sb.toString());
////			if (arr[0] == 0 && arr[1] == 0) {
//				result.add(new String(arr));
//				TP.build(TP.IS_BASE_CASE, root, Arrays.toString(arr), start, left, right, result);
////			}
//			return;
//		}
//		// ����string����start��ʼ���������
//		for (int i = start; i < arr.length; i++) {
//			// ��ȥ�أ������ǰchar��֮ǰ��ͬ���ͼ���
//			if (i > start && arr.charAt(i) == sb.charAt(i - 1)) {
//				continue;
//			}
//
//			// �����������������Ҫɾ����������������0����ô��ɾ����������ţ���DFS�ݹ�
//			if (sb.charAt(i) == '(' && left > 0) {
//				sb.deleteCharAt(i);
//				removeInvalid02(arr, i, left - 1, right, result, TP.build(root, Arrays.toString(arr), i, left - 1, right, result));
//				sb.insert(i, '('); // backtracking��ȥ
//			}
//			// �����������������Ҫɾ����������������0����ô��ɾ����������ţ���DFS�ݹ�
//			if (sb.charAt(i) == ')' && right > 0) {
//				sb.deleteCharAt(i);
//				removeInvalid02(arr, i, left, right - 1, result, TP.build(root, Arrays.toString(arr), i, left, right - 1, result));
//				sb.insert(i, ')');
//			}
//		}
//	}
	
//	O(N)
	private static void removeInvalid01(StringBuilder sb, int start, int left, int right, List<String> result, TP root) {
		// base case: ����Ҫɾ��������������������0�����ҵ�ǰ�����substring��valid�ģ��ͼ���res��
		if (left == 0 && right == 0) {
//			int[] arr = needToDelete(sb.toString());
//			if (arr[0] == 0 && arr[1] == 0) {
				result.add(sb.toString());
				TP.build(TP.IS_BASE_CASE, root, sb, start, left, right, result);
//			}
			return;
		}
		// ����string����start��ʼ���������
		for (int i = start; i < sb.length(); i++) {
			// ��ȥ�أ������ǰchar��֮ǰ��ͬ���ͼ���
			if (i > start && sb.charAt(i) == sb.charAt(i - 1)) {
				continue;
			}

			// �����������������Ҫɾ����������������0����ô��ɾ����������ţ���DFS�ݹ�
			if (sb.charAt(i) == ')' && right > 0) {
				sb.deleteCharAt(i);
				removeInvalid01(sb, i, left, right - 1, result, TP.build(root, sb, i, left, right - 1, result));
				sb.insert(i, ')');
			}
			// �����������������Ҫɾ����������������0����ô��ɾ����������ţ���DFS�ݹ�
			if (sb.charAt(i) == '(' && left > 0) {
				sb.deleteCharAt(i);
				removeInvalid01(sb, i, left - 1, right, result, TP.build(root, sb, i, left - 1, right, result));
				sb.insert(i, '('); // backtracking��ȥ
			}
		}
	}

//	O(N)
//	left, right��ʾ��ǰλ��ǰ��(��)����Ҫɾ���ĸ�������ǰ��(����left++;��ǰ��)����right++��
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
//��start��ʼ��ɾ��l+r����Ҫɾ���ģ�ÿһ��ɾ��һ��
	private static void removeInvalid03(StringBuilder sb, int start, int left, int right, List<String> result, TP root) {
		// base case: ����Ҫɾ��������������������0�����ҵ�ǰ�����substring��valid�ģ��ͼ���res��
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
		// ����string����start��ʼ���������
		for (int i = start; i < sb.length(); i++) {
			// ��ȥ�أ������ǰchar��֮ǰ��ͬ���ͼ���
			if (i > start && sb.charAt(i) == sb.charAt(i - 1)) {
				continue;
			}

			// �����������������Ҫɾ����������������0����ô��ɾ����������ţ���DFS�ݹ�
			if (sb.charAt(i) == ')' && right > 0) {
				sb.deleteCharAt(i);
				removeInvalid03(sb, i, left, right - 1, result, TP.build(root, sb, i, left, right - 1, result));
				sb.insert(i, ')');
			}
			// �����������������Ҫɾ����������������0����ô��ɾ����������ţ���DFS�ݹ�
			if (sb.charAt(i) == '(' && left > 0) {
				sb.deleteCharAt(i);
				removeInvalid03(sb, i, left - 1, right, result, TP.build(root, sb, i, left - 1, right, result));
				sb.insert(i, '('); // backtracking��ȥ
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
