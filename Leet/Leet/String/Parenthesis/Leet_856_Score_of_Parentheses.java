package Leet.String.Parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

/**
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6
 *
 */
public class Leet_856_Score_of_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    // Time: O(N), Space: O(1)
// public int scoreOfParentheses(String str) {
public static int scoreOfParentheses_N_1(String str) {
   int score = 0;
   int left = 0, right = 0;
   for (int i = 0; i < str.length(); i++) {
       if (str.charAt(i) == '(') {
           left++;
       } else {
           right++;
           // if (left < right) {//��������Ч�㣺��������Ч���һ����Ҳ��������Ч���һ��    
           //     sec++; //һ��sec����һ������
           //     left = 0;
           //     right = 0;
           // }//else right == left, good, left > right, good
           // if (left == right) {//ƽ���
           //     if(s.charAt(i) == '('){
           //         score += 1;
           //     }
           // }else{//left > right
           //     score += 1 << (left - right);
           // }
           score += 1 << (left - right);//left - right is the depth
       }
       //here, make sure left >= right always
   }
   return score;        

}

//  Time: O(N), Space: O(N), using stack
//	˼·: ȫ������Integer���д���String��Integer��һ����Ӧ��ϵ��string������ʲôʱ��push����pop
//	����ͨ�ù�ʽ����������()��score = prev + 2 * (score of subproblem) ���� = prev + 1;
	public static int scoreOfParentheses(String str) {
		// public int scoreOfParentheses_N_N_better(String str) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);//��ԭ���, prev == 0 by default; prev + 2 * curr score of ()
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			if (ch == '(') {
				stack.push(0);//��ǰ���ŶԵ�prev
			} else {
				int curr = stack.pop();//�ұߵ�
				int prev = stack.pop();//��ߵ�
				if (curr == 0) {//if()
					stack.push(prev + 1);
				} else {//if not ()
					stack.push(prev + 2 * curr);
				}
				// stack.push(w + Math.max(2 * v, 1));
			}
		}
		return stack.pop();
	}

    //  Time: O(N), Space: O(N), using stack
//	˼·��ȫ������string���д���
    // public int scoreOfParentheses(String str) {
    public int scoreOfParentheses_N_N_not_good(String str) {
        Deque<String> stack = new ArrayDeque<>();
        char[] arr = str.toCharArray();
        for(char ch : arr){
            if(stack.isEmpty()){
                stack.push(ch+"");//�գ���ֱ�ӷ�
            }else if (ch == '('){
                stack.push(ch+"");//ֱ�ӷ�
            }else{
                if(stack.peek().equals("(")){//����(),�滻Ϊ1
                    stack.pop();
                    stack.push("1");
                }else{//��Σ�������), �ݹ�ֱ��(, �������ǰ���Ŷ��ڵ�ֵ������2�����Ǹ����ŶԵ�score�������ջ
                    int sum = 0;
                    while(!stack.peek().equals("(")){
                        sum += Integer.valueOf(stack.pop());    
                    }
                    stack.pop();
                    stack.push(""+ sum*2);
                }
            }
        }
        //()()()���ų�����ʱ�ж��ֵ����stack��ȡ����ֵ�ĺͷ��ؼ��ɣ�
        int sum = 0;
        while(!stack.isEmpty()){
            sum += Integer.valueOf(stack.pop());    
        }
        return sum;
    }

}
