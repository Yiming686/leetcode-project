package Lintcode.Array.String.DP;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import Utils.MatrixUtils;

/**
Regular Expression Matching 

 Description
 Notes
 Testcase
 Judge
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)
Have you met this question in a real interview? Yes
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
Tags 
Backtracking Dynamic Programming String Facebook Google
Related Problems 
Hard Wildcard Matching

 *
 */
public class Regular_Expression_Matching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aa", "a*");
	}

    public static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }    
        if(s.length() == 0 && p.length() == 0){
            return true;
        }    
        if(p.length() == 0){
            return false;
        }    
        boolean[][] isMatch = new boolean[s.length()+1][p.length()+1];
        isMatch[0][0] = true;
        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) == '*'){
                if(j==0){
                    isMatch[0][1] = true;
                }else{
                    //如果当前i处为*，则查看i-1是否为true,默认要求i-1 >= 0
                    isMatch[0][j+1] = isMatch[0][j-1];
                }
            }
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    isMatch[i+1][j+1] = isMatch[i][j];
                }
                if(j!=0 && p.charAt(j) == '*'){
                    if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                        isMatch[i+1][j+1] = isMatch[i+1][j-1] || isMatch[i][j+1];
                    }else{
                        isMatch[i+1][j+1] = isMatch[i+1][j-1];        
                    }
                }
            }
        }
        System.out.println(""+MatrixUtils.fromMatrixToString(isMatch));
        return isMatch[s.length()][p.length()];
    }   
}
