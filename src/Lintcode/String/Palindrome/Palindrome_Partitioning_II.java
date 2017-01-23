package Lintcode.String.Palindrome;

/**
Palindrome Partitioning II

 Description
 Notes
 Testcase
 Judge
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

Tags 
Dynamic Programming
Related Problems 
Medium Wiggle Sort II 25 %
Medium Palindrome Partitioning 25 %
Medium Longest Palindromic Substring 28 %

 *
 */
public class Palindrome_Partitioning_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //  i--, j++
    //  s.charAt(i) == s.charAt(j) 不是 s.charAt[i] == s.charAt[j]
    // 容易错: minCut[i] = Math.min(minCut[i], minCut[j+1] + 1);
    // 为什么是j+1不是j呢,明白了

	//version 1, Worked, Best concise，史上最佳的
    //基本同Longest Palindromic Substring， All Unique Palindromes
    // 给定一个string 可以求最大分割和最小分割
    // 关键是最大分割很直观，很容易求得，最小就比较麻烦了
    // 所有求最小分割最简洁的代码了，比九章的高明多了，关键是解释dp[]的含义
    // dp[i]从i位置到结尾的回文分割数
    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len+1];//len-1,len-2,len-3,...
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i <= len; i++) {
            dp[i] = len - i - 1;//初始化为最大cuts
        }

        for (int i = len - 1; i >= 0; i--) {
    		for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                    //当i=len-1时，j+1=len,所以dp的len为len+1
                    //当
                    // dp[i] = dp[j+1] + 1;
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }    		    
    		}
        }
        return dp[0];//从此位置到最后的最小分割数
        // return dp[len];
    }
}
