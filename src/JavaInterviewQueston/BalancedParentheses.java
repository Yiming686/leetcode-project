package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BalancedParentheses {

/*****************************
 *  FaceBook mianjing
Given a string with parentheses, return a string with balanced parentheses 
by removing the fewest characters possible. You cannot add anything to the 
string.
Examples:
balance("()") -> "()"
balance(")(") -> "". 
balance("(((((") -> ""
balance("(()()(") -> "()()"
balance(")(())(") -> "(())"
	 * 
	 */
	public String findBalancedParentheses(String str) {
		LinkedList<Character> stack = new LinkedList<Character>();
		char[] charArr = str.toCharArray();
		int[] intArr = {1,2};
//		str.
		LinkedList<Character> charList = new LinkedList<Character>();
		for(Character ch : charArr){
			stack.push(ch);
		}
		Character chLast = null;
		while(!stack.isEmpty()){
			Character chPeek = stack.peek();
			if(chLast == null){
				Character chPop = stack.pop();
				charList.addFirst(chPop);
			}


			
		}
		
		
		return str;
	}

}
