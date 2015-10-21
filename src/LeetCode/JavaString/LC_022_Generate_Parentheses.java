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
	// 如果直接简单循环，然后判断，难度低
	// 如果直接要给出，这个递归算法，难度还是有点大，
	// 简单认识：尽管要输出字符串String，但是必须要处理单个字符char
	// 无论如何变化，字符数组的长度不变
	// 递归中传递什么参数？

	// 主要是规律的总结，花费时间
	// 1.如果没有剩余的左右括号可用left==right==0，输出结果
	// 2.如果还有递归的左括号可用，则插入左括号，然后递归调用
	// 3.如果右括号剩余量大于左括号剩余量，
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
		// 这个条件就是说（即使没有了还要继续，）一旦没有了就终止
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
