package Leet.String.Parenthesis;

import static Utils.ArrayUtils.convertInt2IntArr;

import java.util.Stack;

import Utils.SU;

public class Leet_32_Longest_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("123. Best Time to Buy and Sell Stock III");
//		String str = "()()";
		String str = "))()(()()))";
		System.out.println("" + longestValidParentheses(str));
		String str2 = "  ) )a ( b ) (  c( )(d )+  -) )  ";
		System.out.println("" + longestValidParentheses2(str2));
	}

	//  Time: O(N), Space: O(1)
//	public static int longestValidParentheses(String s) {
	public int longestValidParentheses_N_1(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
			// else{
			//     maxlength = Math.max(maxlength, 2 * right);
			// }
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return maxlength;
	}

//	���Ƕ�stack����������û����ȫ���ף�һ������ƥ�䣬���ƥ������Ҷ�ɾ������ô��Ҫ֪����ǰ��Զ�Ĳ���ƥ���λ�ã�
//	��ǰ����ƥ���λ�� - ��ǰ����ƥ���λ�� == ��ǰ�Ŀ���ƥ�����ĳ���
//	����һ���ַ���������ɨ�裬��ͷ������������������ַ��������ַ����ĳ���
	public static int longestValidParentheses(String str) {
//	public static int longestValidParentheses_N_N_best(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);//��ǰ��Զ�Ĳ���ƥ���λ�ã�
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				stack.push(i);//������ƥ�䣬��ô��������ǰ��Զ�Ĳ���ƥ���λ�ã�
			} else {
				stack.pop();//�����۾���ƥ����ǰ����ƥ����ַ���
				if (stack.empty()) {
					stack.push(i);//���ջΪ�գ�˵����ʵû��ʲô���Խ���ƥ��ģ����Ե�ǰ�����µ�����Ĳ���ƥ���λ��
				} else {
					max = Math.max(i - stack.peek(), max);
				}
			}
		}
		return max;
	}

	// follow up 1:  ignore, chars that are spaces
	public static int longestValidParentheses2(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);//��ǰ��Զ�Ĳ���ƥ���λ�ã�
		int i = -1;
//        for(int i = 0;i < str.length();i++){
		for (int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			if (ch == ' ') {
				continue;
			} else {
				i++;
			}
			if (ch == '(') {
				stack.push(i);//������ƥ�䣬��ô��������ǰ��Զ�Ĳ���ƥ���λ�ã�
			} else {
				stack.pop();//�����۾���ƥ����ǰ����ƥ����ַ���
				if (stack.empty()) {
					stack.push(i);//���ջΪ�գ�˵����ʵû��ʲô���Խ���ƥ��ģ����Ե�ǰ�����µ�����Ĳ���ƥ���λ��
				} else {
					//���ջ��Ϊ�գ�˵���п��Խ���ƥ��ģ�����ƥ����ɣ���ôƥ����ַ�������Ϊ i-stack.peek()
					if (i - stack.peek() > max) {
						System.out.printf("start:end %d:%d \n", stack.peek() + 1, i);
					}
					max = Math.max(i - stack.peek(), max);
				}
			}
		}
		return max;
	}

// follow up 2:  ignore, chars that are not ( or )
	public static int longestValidParentheses3(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);//��ǰ��Զ�Ĳ���ƥ���λ�ã�
		int i = -1;
//        for(int i = 0;i < str.length();i++){
		for (int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			if (ch != '(' && ch != ')') {
				continue;
			} else {
				i++;
			}
			if (ch == '(') {
				stack.push(i);//������ƥ�䣬��ô��������ǰ��Զ�Ĳ���ƥ���λ�ã�
			} else {
				stack.pop();//�����۾���ƥ����ǰ����ƥ����ַ���
				if (stack.empty()) {
					stack.push(i);//���ջΪ�գ�˵����ʵû��ʲô���Խ���ƥ��ģ����Ե�ǰ�����µ�����Ĳ���ƥ���λ��
				} else {
					//���ջ��Ϊ�գ�˵���п��Խ���ƥ��ģ�����ƥ����ɣ���ôƥ����ַ�������Ϊ i-stack.peek()
					if (i - stack.peek() > max) {
						System.out.printf("start:end %d:%d \n", stack.peek() + 1, i);
					}
					max = Math.max(i - stack.peek(), max);
				}
			}
		}
		return max;
	}

}
