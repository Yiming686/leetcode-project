package Leet.String.Parenthesis;

import java.util.HashMap;
import java.util.Map;

import Utils.ArrayUtils;
import Utils.StringUtils;

public class Leet_921_Minimum_Add_to_Make_Parentheses_Valid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> char2ProbMap = new HashMap<>();
		char2ProbMap.put('(', 7);
		char2ProbMap.put(')', 7);
		char[ ] arr = ArrayUtils.buildCharArrayWithDup(8, char2ProbMap);
//		String str = "())()()";
		String str = String.valueOf(arr);
		System.out.println(""+str);
		System.out.println(""+minAddToMakeValid(str));
	}

//  Time: O(N), Space: O(1), Great solution, easy to explain
    public static int minAddToMakeValid(String str) {
    // public int minAddToMakeValid_(String s) {
        int left = 0, right = 0;
        int sec = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (right > left) {//绝对是无效点：可能是有效后的一个，也可能是无效后的一个    
                    sec++; //一个sec，配一个（，
                    left = 0;
                    right = 0;
                }
            }
            //here, make sure left >= right always
        }
        return sec + left - right;
    }
    
//  Time: O(N), Space: O(1), Great solution, easy to explain
//    public int minAddToMakeValid(String s) {
     public static int minAddToMakeValid_(String s) {
        int left = 0, right = 0;
        int sec = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (right > left) {//绝对是无效点：可能是有效后的一个，也可能是无效后的一个    
                    sec++; //一个sec，配一个（，
                    left = 0;
                    right = 0;
                }
            }
            //here, make sure left >= right always
        }
        return sec + left - right;
    }

}
