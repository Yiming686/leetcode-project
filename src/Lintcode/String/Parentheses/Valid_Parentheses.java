package Lintcode.String.Parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

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

	@Test
	public void test_Valid_Parentheses(){
		Assert.assertTrue(isValidParentheses(""));
		Assert.assertTrue(isValidParentheses("deb{asdf asf}"));
		Assert.assertFalse("",isValidParentheses("{"));
		Assert.assertFalse(isValidParentheses(" asdf} asf"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    // 根据题意隐隐发现有map和stack的逻辑在里面
    // 
    // Best, worked, keep in mind
    // 小小题目别有洞天，谁研究的透彻呢
    public boolean isValidParentheses(String str)  {
        if(str == null || str.length() == 0) {
            return true;
        }    
        Stack<Character> stack = new Stack<Character>();            
        Map<Character, Character> map = new HashMap<>();//
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char ch : str.toCharArray()){
            if("({[".contains(String.valueOf(ch))){
                stack.push(ch);
            }else if(map.containsKey(ch)){//strong hire, 对别的不处理，通用解法
            // }else{//hire, 包含其他字符是会出错 
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidParentheses12(String s)  {
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
    

//    解法二：
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
