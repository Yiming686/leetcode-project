package Leet.String.Expression_Tree;

import static Utils.TreeNodeUtils.SPACE_CHAR;

import java.util.ArrayDeque;
import java.util.Deque;

import Utils.SU;

public class Leet_224_Basic_Calculator {

	public static void main(String[] args) {
		SU.ll("439. Ternary Expression Parser\n" + 
				"");
		// TODO Auto-generated method stub
//		String s = "2-(5-6)";//3
//		String s = "(1+(4+5+2)-3)+(6+8)";//23
		String s = "1 + 1";

		System.out.println(""+calculate(s));
	}
	
    public static int calculate(String s) {
    		Deque<Character> opeStack = new ArrayDeque<>();
    		Deque<Integer> numStack = new ArrayDeque<>();
    		int len = s.length();
    		//' ', '(', ')', '+', '-', '423'
    		for(int i = 0; i < len; i++) {
    			char ch = s.charAt(i);
    			if(ch == ' ') {
    				continue;//do nothing
    			}
			if(Character.isDigit(ch)) {
				int num = 0;
				while(i < len && Character.isDigit(s.charAt(i))) {
					num = 10 * num + s.charAt(i) - '0';
					i++;
				}
				i--;
				numStack.offerFirst(num);
    			}else if(ch == '(') {
    				opeStack.offerFirst(ch);
    			}else if(ch == ')') {
    				operate(opeStack, numStack);
    				opeStack.pollFirst();//remove '('
    			}else {//'+', '-'
    				operate(opeStack, numStack);
    				opeStack.offerFirst(ch);
    			}
    		}
    		while(!opeStack.isEmpty()) {
    			operate(opeStack, numStack);
    		}
    		return numStack.pollFirst();
    }

	private static void operate(Deque<Character> opeStack, Deque<Integer> numStack) {
		while(!opeStack.isEmpty() && opeStack.peek() != '(') {
			char op = opeStack.pollFirst();
			int val2 = numStack.pollFirst();
			int val1 = numStack.pollFirst();
			if(op == '+') {
				numStack.offerFirst(val1 + val2);
			}else {
				numStack.offerFirst(val1 - val2);
			}
		}
	}

}
