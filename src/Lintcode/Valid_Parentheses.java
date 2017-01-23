package Lintcode;

import java.util.Stack;

/**
Valid Parentheses

 Description
 Notes
 Testcase
 Judge
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Have you met this question in a real interview? Yes
Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Tags 
Stack Google
Related Problems 
Medium Generate Parentheses 35 %

 *
 */
public class Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidParentheses(String s)  {
        if(s == null || s.length() == 0) {
            return true;
            // throw new IllegalArgumentException();
            // return new illegalArgumentException();
        }
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            if("({[".contains(String.valueOf(ch))){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    char top = stack.pop();
                    if(!isPair(top, ch)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isPair(char top, char ch){
        return (top == '(' && ch == ')') || (top == '{' && ch == '}') ||(top == '[' && ch == ']');
    }
    

//    ½â·¨¶þ£º
    //worked 
    public boolean isValidParentheses22(String s) {
        // Write your code here
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if ("({[".contains(String.valueOf(c))) {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && isValid(stack.peek(), c)) {
				// if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private boolean isValid(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
				|| (c1 == '[' && c2 == ']');
	}

    
}
