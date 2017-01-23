package Lintcode.String.Palindrome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
Palindrome Partitioning

30:00
 Start
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
Tags Expand 
Backtracking Depth First Search


Related Problems Expand 
Medium Palindrome Partitioning II

 *
 */
public class Palindrome_Partitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "every";
//		String str = "ddddd";
		System.out.println(""+partition(str));
	}

	
    //易错点: 
    // 需要new ArrayList, result.add(new ArrayList<String>(path));
    // 调用i,而不是i-1， helper(result, path, s, i);
    // substring(),而不是subString(),String str = s.substring(pos, i);
    // 什么应该返回? isPal(), if(str == null) throw new IllegalArgumentException();
	
    public static ArrayList<ArrayList<String>> partition(String str) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (str == null) {
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        //将str从0位置开始分割，返回result
        //path不停变换，但是result一般包含多个path
        helper(result, path, str, 0);
        return result;
    }

    private static void helper(ArrayList<ArrayList<String>> result,  ArrayList<String> path, String str, int pos) {
        //没有以pos开始的字符串了，所以把path加入result
        if (pos == str.length()) {
        	System.out.println(spaces(str.length() +1) + " Add: " + path);
            result.add(new ArrayList<String>(path));
            return;
        }
        //分割，以pos开始，i结束
        for (int i = pos + 1; i <= str.length(); i++) {
            String subStr = str.substring(pos, i);
            //如果是palindrom，加入path，在此前提下，求出后面位置的可能path并加入result，
            //求完后，记得删除当前path里面的palindrom，取消此前提
            if (isPalindrome(subStr)) {
                //path加入这一段
                path.add(subStr);
            	System.out.println("path:str  "+spaces(pos) + path + " : " + subStr);
                //进入递归，继续分割，path多了一个，i变为新的开始位置
                helper(result, path, str, i );
                path.remove(path.size() - 1);
            }
        }
    }


    
    private static boolean isPalindrome(String s) {
        if(s == null) return true;
        //一个指向第一个，一个指向最后一个字符
        int start = 0;
        int end = s.length() - 1;
        //一个++，一个--，只要没有碰面，逐次检测字符，一旦不等，立即return false
        //不用等号，等号肯定相等
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        //检测完毕，都相等，只有返回true
        return true;
    }
    
    private static String spaces(int count){
    	String str = "";
    	while(--count >= 0){
    		str += "                 ";
    	}
    	return str;
    }


    private static boolean isPalindrome44(String s) {
    	Set<String> set = new HashSet<String>();
    	set.add("eve");
    	set.add("ry");
    	return set.contains(s);
    }    


}
