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
           // if (left < right) {//绝对是无效点：可能是有效后的一个，也可能是无效后的一个    
           //     sec++; //一个sec，配一个（，
           //     left = 0;
           //     right = 0;
           // }//else right == left, good, left > right, good
           // if (left == right) {//平衡点
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
//	思路: 全部按照Integer进行处理，String和Integer有一个对应关系，string告诉了什么时候push或者pop
//	建立通用公式：计算任意()，score = prev + 2 * (score of subproblem) 或者 = prev + 1;
	public static int scoreOfParentheses(String str) {
		// public int scoreOfParentheses_N_N_better(String str) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);//有原因的, prev == 0 by default; prev + 2 * curr score of ()
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			if (ch == '(') {
				stack.push(0);//当前括号对的prev
			} else {
				int curr = stack.pop();//右边的
				int prev = stack.pop();//左边的
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
//	思路：全部按照string进行处理
    // public int scoreOfParentheses(String str) {
    public int scoreOfParentheses_N_N_not_good(String str) {
        Deque<String> stack = new ArrayDeque<>();
        char[] arr = str.toCharArray();
        for(char ch : arr){
            if(stack.isEmpty()){
                stack.push(ch+"");//空，就直接放
            }else if (ch == '('){
                stack.push(ch+"");//直接放
            }else{
                if(stack.peek().equals("(")){//发现(),替换为1
                    stack.pop();
                    stack.push("1");
                }else{//其次，遇到了), 递归直到(, 计算出当前括号对内的值，乘以2，就是该括号对的score，放入堆栈
                    int sum = 0;
                    while(!stack.peek().equals("(")){
                        sum += Integer.valueOf(stack.pop());    
                    }
                    stack.pop();
                    stack.push(""+ sum*2);
                }
            }
        }
        //()()()不排除，此时有多个值，在stack，取所有值的和返回即可！
        int sum = 0;
        while(!stack.isEmpty()){
            sum += Integer.valueOf(stack.pop());    
        }
        return sum;
    }

}
