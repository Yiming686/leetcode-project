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

//	����ķֽ⣺�����������أ���������Ե����ֵĸ�����ÿ�����һ�������һ��1����
//	��ȷ�طֽ⣺���n����������n-1���������ţ��������n
//	��Ŀ��⣺�����()�ĺ������⣬��������������������������������������������������֣�Ҳ������һ�������������Ķ���
//	Ҳ����˵ÿһ��(),�ͻ����һ�����֣�����������ƣ�����n�����֣��ͱ������n-1���������š�
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
