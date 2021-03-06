package Lintcode.Array.String.DP;

import Lintcode.Matrix.Matrix;

/**
 Interleaving String

Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Have you met this question in a real interview? Yes
Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
Challenge
O(n2) time or better

Tags Expand 
Longest Common Subsequence Dynamic Programming


Related Problems Expand 
Medium Distinct Subsequences
 *
 */
public class Interleaving_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[]{"db","b","cbb"};
		String s1 = arr[0];
		String s2 = arr[1];
		String s3 = arr[2];
		System.out.println(""+isInterleave(s1,s2,s3));
	}

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        boolean [][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for(int i = 1; i <= len1; i++){
            f[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= len2; i++){
            f[0][i] = s2.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                f[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && f[i-1][j] )||
                          (s2.charAt(j-1) == s3.charAt(i+j-1) && f[i][j-1]);
            }
        }
        System.out.println(""+Matrix.fromMatrixToString(f));
        return f[len1][len2];
    }

    public static boolean isInterleave11(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }
        
        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                interleaved[i][j] = true;
            }
        }
        
        return interleaved[s1.length()][s2.length()];
    }
/*
Interleaving String
state: f[i][j]表示s1的前i个字符和s2的前j个字符能否交替组成s3的前i+j
个字符
function: 
f[i][j] = (f[i-1][j] && (s1[i-1]==s3[i+j-1]) || f[i][j-1] && (s2[j-1]==s3[i+j-1)
initialize: f[i][0] = s1[0..i-1] = s3[0..i-1]
f[0][j] = s2[0..j-1] = s3[0..j-1]
answer: f[n][m]
n = sizeof(s1), m = sizeof(s2)

*/
}
