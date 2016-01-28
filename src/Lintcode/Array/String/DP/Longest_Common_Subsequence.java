package Lintcode.Array.String.DP;

/**
Longest Common Subsequence

Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Have you met this question in a real interview? Yes
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
Tags Expand 
LintCode Copyright Longest Common Subsequence Dynamic Programming


Related Problems Expand 
Medium Edit Distance 28 %
Medium Longest Common Substring

 *
 */
public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestCommonSubsequence5(String A, String B) {
        // write your code here
        int n = A.length();
	    int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    // f[i][j] = f[i - 1][j - 1] + 1;
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n][m];
    }
    //Jiuzhagn lolution, worked 
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int n = A.length();
	    int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    // f[i][j] = f[i - 1][j - 1] + 1;
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n][m];
    }
/*
Longest Common Subsequence

state: f[i][j]表示前i个字符配上前j个字符的LCS的长度
function:
f[i][j] = MAX(f[i-1][j], f[i][j-1], f[i-1][j-1] + 1) // a[i] == b[j]
f[i][j] = MAX(f[i-1][j], f[i][j-1])                  // a[i] != b[j]
intialize: f[i][0] = 0
f[0][j] = 0
answer: f[a.length()][b.length()]

*/

}
