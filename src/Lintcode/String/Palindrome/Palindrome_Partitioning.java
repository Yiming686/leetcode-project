package Lintcode.String.Palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		String str = "goodgood";
//		String str = "ddddd";
		System.out.println(""+partition(str));
		
		
	}

    // worked, Best solution:
    public static List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        if(str == null || str.length() == 0) return result;
        int len = str.length();
        char[] arr = str.toCharArray();
        boolean[][] isPal = new boolean[len][len];//all false;
        for(int row = len - 1; row >= 0; row--){//from index: row
            for(int col = row; col < len; col++){//to index: col
                // if(str.charAt(row) == str.charAt(col) && (col - row < 2 || isPal[row+1][col-1])){ // worked
                if(arr[row] == arr[col] && (col - row <=2 || isPal[row+1][col-1])){//00,01,02
                    isPal[row][col] = true;
                }
            }
        }
        List<String> path = new ArrayList<>();
        int pos = 0;
        helper3(result, path, isPal, str, pos);
        return result;

    }
    
    private static void helper3(List<List<String>> result, List<String> path, boolean[][] isPal, String str, int pos){
        if(pos == str.length()){
            result.add(new ArrayList<String>(path));
        }
        for(int i = pos + 1; i <= str.length(); i++){
            String temp = str.substring(pos, i);
            if(isPal[pos][i-1]){
                path.add(temp);
                helper3(result, path, isPal, str, i);
                path.remove(path.size()-1);
            }
        }
    }

	
    //易错点: 
    // 需要new ArrayList, result.add(new ArrayList<String>(path));
    // 调用i,而不是i-1， helper(result, path, s, i);
    // substring(),而不是subString(),String str = s.substring(pos, i);
    // 什么应该返回? isPal(), if(str == null) throw new IllegalArgumentException();
	
    public static ArrayList<ArrayList<String>> partition11(String str) {
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
//----------------------------------
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, boolean[][]> word2IsPalMap = getWord2IsPalMap(words);//O(N * Len^2 )
        Map<String, String[][]> word2SubstrMap = getWord2SubstrMap(words);//O(N * len^3)
        // lls -> sll 
        Map<String, Integer> reverseMap = getReverseMap(words);//O(N * len)
        
        for (int i = 0; i < words.length; i++) {//O(N)
            String word = words[i];
            int l = word.length();
            String subStr = word;
            Integer revIndex = reverseMap.get(subStr);
            boolean[][] isPal = word2IsPalMap.get(word);
            String[][] substr = word2SubstrMap.get(word);
            
            // abc -> cba
            if (revIndex != null && revIndex != i) {
                ans.add(Arrays.asList(i, revIndex));
            }
            // abcdd ->looking for   cba 
            for (int j = 0; j < l; j++) {//O(len)
                subStr = substr[0][j];//O(len)
                revIndex = reverseMap.get(subStr);
                if (isPal[j][l-1] && revIndex != null) {//O(len)
                    ans.add(Arrays.asList(i, revIndex));
                }                
                subStr = j+1 < l ? substr[j+1][l-1] : "";
                // subStr = substr[j+1][l-1];
                revIndex = reverseMap.get(subStr);
                if (isPal[0][j] && revIndex != null) {
                    // ans.add(Arrays.asList(i, reverseMap.get(word.substring(j+1,l))));
                    ans.add(Arrays.asList(revIndex, i));
                }                
            }
        }
        return ans;
    }

    private Map<String, String[][]> getWord2SubstrMap(String[] words){    
        Map<String, String[][]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {//O(N)
            map.put(words[i], buildSubstr(words[i]));//(len^2)
        }
        return map;
    }
    private String[][]  buildSubstr(String str){//O(len^2)    
        int len = str.length();
        String[][] substr = new String[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
               substr[i][j] = str.substring(i, j+1); 
            }            
        }
        return substr;
    }
    private Map<String, boolean[][]> getWord2IsPalMap(String[] words){
        Map<String, boolean[][]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {//O(N)
            map.put(words[i], buildIsPal(words[i]));//(len^2)
        }
        return map;
    }
    private boolean[][] buildIsPal(String str){//O(len^2)
        int len = str.length();
        boolean[][] isPal = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            isPal[i][i] = true;
            for (int j = i+1; j < len; j++) {
                if(str.charAt(i) == str.charAt(j) && j-i+1 <= 3 || isPal[i+1][j-1]){
                    isPal[i][j] = true;
                }
            }
        }
        return isPal;
    }
    private Map<String, Integer> getReverseMap(String[] words) {//O(N * len)
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            map.put(sb.toString(), i);
        }
        return map;
    }


}
