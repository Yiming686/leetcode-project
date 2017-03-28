package Lintcode.String.Palindrome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
                if(arr[row] == arr[col] && (col - row <=2 || isPal[row+1][col-1])){
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

	
    //�״��: 
    // ��Ҫnew ArrayList, result.add(new ArrayList<String>(path));
    // ����i,������i-1�� helper(result, path, s, i);
    // substring(),������subString(),String str = s.substring(pos, i);
    // ʲôӦ�÷���? isPal(), if(str == null) throw new IllegalArgumentException();
	
    public static ArrayList<ArrayList<String>> partition11(String str) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (str == null) {
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        //��str��0λ�ÿ�ʼ�ָ����result
        //path��ͣ�任������resultһ��������path
        helper(result, path, str, 0);
        return result;
    }

    private static void helper(ArrayList<ArrayList<String>> result,  ArrayList<String> path, String str, int pos) {
        //û����pos��ʼ���ַ����ˣ����԰�path����result
        if (pos == str.length()) {
        	System.out.println(spaces(str.length() +1) + " Add: " + path);
            result.add(new ArrayList<String>(path));
            return;
        }
        //�ָ��pos��ʼ��i����
        for (int i = pos + 1; i <= str.length(); i++) {
            String subStr = str.substring(pos, i);
            //�����palindrom������path���ڴ�ǰ���£��������λ�õĿ���path������result��
            //����󣬼ǵ�ɾ����ǰpath�����palindrom��ȡ����ǰ��
            if (isPalindrome(subStr)) {
                //path������һ��
                path.add(subStr);
            	System.out.println("path:str  "+spaces(pos) + path + " : " + subStr);
                //����ݹ飬�����ָpath����һ����i��Ϊ�µĿ�ʼλ��
                helper(result, path, str, i );
                path.remove(path.size() - 1);
            }
        }
    }


    
    private static boolean isPalindrome(String s) {
        if(s == null) return true;
        //һ��ָ���һ����һ��ָ�����һ���ַ�
        int start = 0;
        int end = s.length() - 1;
        //һ��++��һ��--��ֻҪû�����棬��μ���ַ���һ�����ȣ�����return false
        //���õȺţ��Ⱥſ϶����
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        //�����ϣ�����ȣ�ֻ�з���true
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
