package Leet.Interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Basic_Calculator {

    public static void main(String args[] ) throws Exception {
//        System.out.println("Hello World");
//        String str = "((1+2)*(3+(4*5)))";
        String str = "((1+2))";
        System.out.println(parse(str));
    }
    
    
    
    //assumption valid input
    static Integer parse(String str){
        // if(str == null || ){
            
        // }
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        int len = str.length();
        // String signs = "()+-*";
        Set<Character> signs = new HashSet<>();
        signs.add('+');signs.add('(');signs.add(')');
        signs.add('-');signs.add('*');
        
        //
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(ch == ' '){
                continue;
            }
            //operators
            if(signs.contains(ch)){
                
                if(ch == '('){
                    stack2.offerFirst(ch);
                }else if(ch == ')'){
                    calculate(stack1, stack2);
                    stack2.pollFirst();
                }else{
                    calculate(stack1, stack2);
                    stack2.offerFirst(ch);
                }
                
            //integers   
            }else{
                // int val = 0;
                // while(i < len && ){
                    
                // }
                stack1.offerFirst(Integer.valueOf(ch));
            }
        }
        while(!stack2.isEmpty()){
            calculate(stack1, stack2);
        }
        return stack1.peekFirst();
        
    }
    
    private static void calculate(Deque<Integer> stack1, Deque<Character> stack2 ){
        while(!stack2.isEmpty() && stack2.peekFirst() != '('){
            char ch = stack2.pollFirst();
            int val1 = stack1.pollFirst();
            int val2 = stack1.pollFirst();
            if(ch == '+'){
               stack1.offerFirst(val1 + val2); 
            }else if(ch == '-'){
                stack1.offerFirst(val2 - val1); 
            }else {
//            	if(ch == '*'){
                stack1.offerFirst(val2 * val1); 
            }
        }
    }
 

}
