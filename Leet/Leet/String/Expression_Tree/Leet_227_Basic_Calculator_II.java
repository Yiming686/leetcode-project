package Leet.String.Expression_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet_227_Basic_Calculator_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "2-(5-6)";//3
//		String s = "(1+(4+5+2)-3)+(6+8)";//23
//		String s = "1 + 1";
//		String s = "3+2*2"; // 7
//		String s = " 3+5 / 2 "; // 5
		String s = "1*2-3/4+5*6-7*8+9/10"; //-24
		System.out.println(""+calculate_II(s));
	}
	
    public static int calculate_II(String s) {
    		Deque<Character> opeStack = new ArrayDeque<>();
    		Deque<Integer> numStack = new ArrayDeque<>();
    		int len = s.length();
    		//' ', '(', ')', '+', '-', , '*', '/', '423'
    		for(int i = 0; i < len; i++) {
    			char ch = s.charAt(i);
    			if(ch == ' ') {
    				continue;//do nothing
    			}
			if(Character.isDigit(ch)) {//"423"
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
    				operateII(opeStack, numStack);
    				opeStack.pollFirst();//remove '('
    			}else {//'+', '-', '*', '/'
    				if(!opeStack.isEmpty() && getPrecedence(ch) <= getPrecedence(opeStack.peekFirst())) {
                        char op = opeStack.pollFirst();
                        int val2 = numStack.pollFirst();
                        int val1 = numStack.pollFirst();
                        numStack.offerFirst(operate(op, val1, val2));
        				opeStack.offerFirst(ch);
    				}else {
    					opeStack.offerFirst(ch);	
    				}
    			}
    		}
    		while(!opeStack.isEmpty()) {
    			operateII(opeStack, numStack);
    		}
    		return numStack.pollFirst();
    }

	private static void operateII(Deque<Character> opeStack, Deque<Integer> numStack) {
//		while(!opeStack.isEmpty() && opeStack.peek() != '(') {
		while(!opeStack.isEmpty() && opeStack.peek() != '(') {
			char op = opeStack.pollFirst();
			int val2 = numStack.pollFirst();
			int val1 = numStack.pollFirst();
			numStack.offerFirst(operate(op, val1, val2));
		}
	}
	
	private static int operate(char op, int val1, int val2) {
		switch(op){
			case '*': return val1 * val2;
			case '/': return val1 / val2;
			case '+': return val1 + val2;
			case '-': return val1 - val2;
		}
		return Integer.MIN_VALUE;
	}

	private static int getPrecedence(char ch) {
		switch(ch){
			case '*': return 3;
			case '/': return 3;
			case '+': return 2;
			case '-': return 2;
			case '(': return 1;
			case ')': return 1;
		}
		return Integer.MIN_VALUE;
	}

	private static void operateI(Deque<Character> opeStack, Deque<Integer> numStack) {
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
