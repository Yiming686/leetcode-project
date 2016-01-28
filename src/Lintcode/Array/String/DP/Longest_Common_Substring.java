package Lintcode.Array.String.DP;

/**
Longest Common Substring Show result 

Given two strings, find the longest common substring.

Return the length of it.

Have you met this question in a real interview? Yes
Example
Given A = "ABCD", B = "CBCE", return 2.

Note
The characters in substring should occur continuously in original string. This is different with subsequence.

Challenge
O(n x m) time and memory.

Tags Expand 
LintCode Copyright Longest Common Subsequence Dynamic Programming


Related Problems Expand 
Medium Longest Common Subsequence

 *
 */
public class Longest_Common_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //Jiuzhang solution, worked 
    public int longestCommonSubstring77(String A, String B) {
        // write your code here
        int maxlen = 0;
        int xlen = A.length();
        int ylen = B.length();
        for(int i = 0; i < xlen; ++i)
	    {
		    for(int j = 0; j < ylen; ++j)
		    {
			    int len = 0;
                while (i + len < xlen && j + len < ylen && 
                    A.charAt(i + len) == B.charAt(j + len))
                        len ++;
			    if(len > maxlen)
				    maxlen = len;
		    }
	    }
        return maxlen;
    }
    //Best solution, from geeks
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int n = A.length();
	    int m = B.length();
	    
        int f[][] = new int[n + 1][m + 1];
        int longest = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1] + 1;
                    // f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                    longest = Math.max(longest, f[i][j]);
                }else{
                    f[i][j] = 0;
                    // f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        // return f[n][m];
        return longest;
    }
/*
Longest Common Substring
state: f[i][j]表示前i个字符配上前j个字符的LCS‘的长度
(一定以第i个和第j个结尾的LCS’)
function: f[i][j] = f[i-1][j-1] + 1 // a[i] == b[j]
= 0 // a[i] != b[j]
intialize: f[i][0] = 0
f[0][j] = 0
answer: MAX(f[0..a.length()][0..b.length()])


*/

}
