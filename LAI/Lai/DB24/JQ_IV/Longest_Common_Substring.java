package Lai.DB24.JQ_IV;

import java.util.Arrays;

import Utils.MatrixUtils;
import sun.security.x509.X500Name;

public class Longest_Common_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String source = "abcdefg"; 
//		String target = "bbcefgh";
//		String source = "abcde"; 
//		String target = "gcdf";
		
//		expected:<a[a]> but was:<a[]>
		String source = "aaaaaa"; 
		String target = "bbaaba";
		System.out.println(""+longestCommon(source , target));
		System.out.println(""+longestCommonSubstring(source , target));
	}
    public static String longestCommonSubstring(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
          return "";
        }
    		String common = "";
        int max = 0;
        int end = 0;
        int[][] longest = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    longest[i][j] = longest[i- 1][j - 1] + 1;
                } else {
                     longest[i][j] = 0;                     
                    //longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
                if(longest[i][j] > max) {
                		max =  longest[i][j];
                		end = i - 1;
//                		System.out.printf("max:end %d:%d\n",max, end);
                }
            }
        }
        return s.substring(end + 1 - max, end + 1);
    }
	

    public int longest(String s, String t) {
        int max = 0;
        int[][] longest = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    longest[i][j] = longest[i- 1][j - 1] + 1;
                } else {
                     longest[i][j] = 0;
                    //longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
                max = Math.max(max, longest[i][j]);
            }
        }
        // return longest[s.length()][t.length()];
        return max;

    }

    
//	worked
	public static String longestCommon(String source, String target) {
		// Write your solution here
		if (source == null || target == null) {
			return null;
		}
		if (source.length() == 0 || target.length() == 0) {
			return "";
		}
		String longest = "";
		String[][] common = new String[source.length() + 1][target.length() + 1];
		for (int i = 0; i < common.length; i++) {//i - 1: source index 
			for (int j = 0; j < common[0].length; j++) {//j - 1: target index
				if (i == 0 || j == 0) {
					common[i][j] = "";
					continue;
				}
				if (source.charAt(i - 1) == target.charAt(j - 1)) {
					common[i][j] = common[i - 1][j - 1] + source.charAt(i - 1);
				} else {
					common[i][j] = "";
//					if (common[i - 1][j].length() > common[i][j - 1].length()) {
//						common[i][j] = common[i - 1][j];
//					} else {
//						common[i][j] = common[i][j - 1];
//					}
					// longest[i][j] = Math.max(longest[i-1][j], longest[i][j-1]);
				}
				if (longest.length() < common[i][j].length()) {
					longest = common[i][j];
				}
			}
			
		}
		System.out.println(""+MatrixUtils.fromMatrixToString(common));
		// return longest[source.length()][target.length()];
		return longest;
	}
}

/*
 * M[i][j] 表示以i，j为结尾的两个单词的最长公共子串，所以最后一个字符，不等时，为0，相等时,等于M[i-1][j-1]+1
 * 要利用上M[i-1][j-1]， M[i-1][j-1]必须是以[i-1][j-1]结尾的最长公共子串，否则错误！！！
 * 要求全局的最长公共子串，必须有globalMax，
 * 
 * !!!! 问题：什么时候需要global变量，什么时候不需要呢？
 * 当我需要 M[i][j] = M[i-1][j-1] + 1时， 就表明了M[i-1][j-1]必须以[i-1][j-1]结尾的
 * 
 * Base Case: M[0][0] = 0; M[0][i] = 0; M[j][0] = 0;
 * 
 * Induction Rule: M[i][j] = M[i-1][j-1] + 1 if s[i-1] == t[j-1] =
 * Math.max(M[i-1][j], M[i][j-1]) otherwise
 * 
 */
