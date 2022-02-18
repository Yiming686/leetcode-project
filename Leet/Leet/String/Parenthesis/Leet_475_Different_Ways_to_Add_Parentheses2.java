package Leet.String.Parenthesis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_475_Different_Ways_to_Add_Parentheses2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = "2-1-1";
//		String input = "  22    *     3333 -  4444 *   5555 ";
//		String input2 = "22*3333-4444*5555 ";
		String input = "2-1-1";
//		String input = "2*3-4*5*2+2*2";
//		List<String> list = split(input);
//		List<String> list = splitWithSpaces(input);
//		List<String> list2 = splitWithSpaces(input2);
//		System.out.println("splitWithSpaces: "+list);
//		System.out.println("list: "+split(input));
//		System.out.println("list_old: "+split_old(input));
//		
//		System.out.println("splitWithSpaces: "+list2);
//		System.out.println("list: "+split(input2));
//		System.out.println("list_old: "+split_old(input2));

		System.out.println(""+diffWaysToCompute(input));
	}

//	错误的分解：错误在哪里呢？错误在针对的数字的个数，每层减少一个，最后一层1个，
//	正确地分解：针对n个数，就有n-1对左右括号，就是求解n
//	题目理解：对添加()的含义的理解，把两个东西括起来，不能是三个东西，这个东西可以是数字，也可以是一定括号括起来的东西
//	也就是说每一个(),就会减少一个数字，有了这个限制，对于n个数字，就必须得有n-1个左右括号。
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if(input == null){
            return result;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        diffWaysToCompute(input, map);
        return map.get(input);
    }
    public static List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> map) {
        if(input == null){
            return new ArrayList<>();
        }
        List<Integer> result = map.get(input);
        if(result != null){
            return result;
        }
        result = new ArrayList<>();
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")){
            result.add(Integer.valueOf(input));
            map.put(input, result);
            return result;
        }
        
        int len = input.length();
        for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i+1, len);
                List<Integer> leftVals = diffWaysToCompute(left, map);
                List<Integer> rightVals = diffWaysToCompute(right, map);
                for(Integer val1 : leftVals){
                    for(Integer val2 : rightVals){
                        result.add(operate(val1, val2, ch));
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }
    private static Integer operate(Integer val1, Integer val2, char op){
        if (op == '+' ){
            return val1 + val2;
        }else if (op == '-' ){
            return val1 - val2;
        }else{
            return val1 * val2;
        }
    }	

}
