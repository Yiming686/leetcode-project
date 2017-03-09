package Lintcode.String.Palindrome;

import java.util.HashMap;
import java.util.Map;

/*
214. Shortest Palindrome

   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 34095
Total Submissions: 147286
Difficulty: Hard
Contributors: Admin
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Thanks to @Freezen for additional test cases.

Subscribe to see which companies asked this question

Hide Tags String
Hide Similar Problems (M) Longest Palindromic Substring (E) Implement strStr() (H) Palindrome Pairs

 *  
 *  *
 */
public class Shortest_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap();
		System.out.println(""+map.get(null));
		map.put(null,null);
		map.put(null,888);
		System.out.println(""+map.get(null));
		System.out.println(""+map.get(null));
		
		System.out.println(""+Integer.MAX_VALUE);
		String str = "abcdefabc";
		
//		System.out.println(""+shortestPalindrome(str));
		System.out.println("==========");
		str = "abcd";//no pal, works
		str = "aabbcc";
		str = "aacecaaa";
		str = "abcba";
		str = "afcba";
		str = "abbafgh";
//		kcfbeadc+b+abcdaebfck
		System.out.println(""+shortestPalindrome(str));
		
	}

	//LTE, �ǳ�Ư���Ľⷨ��������ĸ������������˼·����
    public static String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int end = s.length() - 1;
        for(; end > 0; end --){
            int i = 0, j = end;
            while (i < j) {
                if (arr[i] == arr[j]) {
                    ++i; 
                    --j;
                }else{
                    break;
                } 
            }
            if(i >= j) {
                break;   
            }
        }    
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

	//worked, �ǳ�Ư���Ľⷨ
    public static String shortestPalindrome12(String s) {
        int end = s.length() - 1;
        int i = 0, j = end;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] == arr[j]) {
                ++i; 
                --j;
            } else {
                --end; 
                i = 0;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
    
//    TLE,
    public static String shortestPalindrome11(String s) {
    	System.out.println("--> "+s);

        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {//�ҵ���һ��ʹ�������ĵ�λ��

           if (s.charAt(i) == s.charAt(j)) { 
        	   System.out.println("j==i: "+ j +", "+i);
               j += 1; 

           }

           System.out.println("j: i: "+ j +", "+i);
        }
        if (j == s.length()) {  //�����ǻ���

            return s; 

        }
       

        String suffix = s.substring(j); // ��׺���ܹ�ƥ����ַ���

        String prefix = new StringBuilder(suffix).reverse().toString(); // ǰ�油��prefix������suffix����ƥ��

        String mid = shortestPalindrome(s.substring(0, j)); //�ݹ������ [0,j]Ҫ���ٿ��Բ�����ٸ��ַ���������

        String ans = prefix + mid  + suffix;
        System.out.println("prefix: "+ prefix);
        System.out.println("mid: "+ mid);
        System.out.println("suffix: "+ suffix);
        return  ans;

    }
	
	
}
