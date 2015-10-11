package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.List;

/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"

 Hide Tags Backtracking String

 */
public class LC_022_Generate_Parentheses {

	// Accepted, 250ms
	// ���ֱ�Ӽ�ѭ����Ȼ���жϣ��Ѷȵ�
	// ���ֱ��Ҫ����������ݹ��㷨���ѶȻ����е��
	// ����ʶ������Ҫ����ַ���String�����Ǳ���Ҫ�������ַ�char
	// ������α仯���ַ�����ĳ��Ȳ���
	// �ݹ��д���ʲô������

	// ��Ҫ�ǹ��ɵ��ܽᣬ����ʱ��
	// 1.���û��ʣ����������ſ���left==right==0��������
	// 2.������еݹ�������ſ��ã�����������ţ�Ȼ��ݹ����
	// 3.���������ʣ��������������ʣ������
	public List<String> generateParenthesis(int n) {
		List<String> strList = new ArrayList<String>();
		char[] charArr = new char[2 * n];

		generateParenthesis(strList, charArr, n, n, 0);
		return strList;
	}

	private void generateParenthesis(List<String> strList, char[] charArr,
			int left, int right, int curr) {
		// TODO Auto-generated method stub
		if (left < 0 || right < left)
			return;
		if (left == 0 && right == 0)
			strList.add(new String(charArr));
		else {
			if (left > 0) {
				charArr[curr] = '(';
				generateParenthesis(strList, charArr, left - 1, right, curr + 1);
			}
			if (right > left) {
				charArr[curr] = ')';
				generateParenthesis(strList, charArr, left, right - 1, curr + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createParenthsis(6);
	}

	private static void createParenthsis(int n) {
		// TODO Auto-generated method stub
		char[] charArr = new char[2 * n];

		createParenthsis(charArr, n, n, 0);
	}

	private static void createParenthsis(char[] charArr, int left, int right,
			int curr) {
		// TODO Auto-generated method stub
		// �����������˵����ʹû���˻�Ҫ��������һ��û���˾���ֹ
		 System.out.printf("l=%s,r=%s,curr=%s   \n", left, right, curr);

		if (left < 0 || right < left)
			return;
		if (left == 0 && right == 0)
			System.out.println(charArr);
		if (curr < charArr.length) {
			// if (left > 0) {
			charArr[curr] = '(';
			createParenthsis(charArr, left - 1, right, curr + 1);
			// }
			// if (right > left) {
			charArr[curr] = ')';
			createParenthsis(charArr, left, right - 1, curr + 1);
			// }
		}
	}
}
