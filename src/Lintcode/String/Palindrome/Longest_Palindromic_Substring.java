package Lintcode.String.Palindrome;

/**
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Have you met this question in a real interview? Yes
Example
Given the string = "abcdzdcab", return "cdzdc".

Challenge
O(n2) time is acceptable. Can you do it in O(n) time.

Tags Expand 
String


Related Problems Expand 
Easy Valid Palindrome 20 %
Medium Longest Palindromic Substring 23 %
Medium Palindrome Partitioning II *
 */
public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abbaba";
		String s = "abbaba";
//		String s = "abb";
//		String s = "abbahgiadf1234554321675654kjasbwedwq9876556789fasdkasbewodi23ba";
		longestPalindrome2(s);
	}

    //DP, TC is O(N^2)
//	第一个解决方案
    public static String longestPalindrome11(String s) {
		if (s == null) return null;
		int len = s.length();
		if(len == 0) return "";
		boolean[][] isPal = new boolean[len][len];
		String result = "";
		int maxLen = 0;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
					isPal[i][j] = true;
					
					if (maxLen < j - i + 1) {
						maxLen = j - i + 1;
						result = s.substring(i, j + 1);
					}
				}
			}
		}
		return result;
	}
	
	
	//for test
    public static String longestPalindrome2(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";
        //通过对sting预处理，降低时间复杂度
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        System.out.println(""+2*s.length());
        for(int i = 1; i <= 2 * length - 1; i++){
        	c1++;
        	System.out.println("==i:"+i);
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
            	c3++;
                count++;
                System.out.println("i :"+i+" , count :" + count);
            }
            c2 += 2*c3 + 1;
            c3 = 0;
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                System.out.println(" i: "+i+", "+" count: "+count+", "+"result: "+result);
                max = count;
            }
        }
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        return result;
    }
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";
        //长度从n变为2n+1了，最大index为2n
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }
        
        return result;
    }
    
    //每个原来元素前面加一个#，后面还有一个，奇数个总计
    private static char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i / 2);
    }
    
    
}
