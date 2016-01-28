package Lintcode.String.Palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Lintcode.Array.Matrix;

/**

Sub-palindrome


Given a string S, how many distinct continuous sub-strings of S are palindromes?
 
Input:
A string S consisting of lowercase ascii characters.
 
Output:
An integer that denotes the count of the distinct continuous sub-strings of S that are palindromes, including single-character strings.
 
Constraint:
|S| ¡Ü 5,000
 
Sample Input:
aabaa
 
Sample Output:
5
 
Explanation:
a, aa, aabaa, aba, b
The sub-string 'a' occurs 4 times, but we are looking for distinct sub-strings. Hence it is counted only once. Similarly, the string 'aa' occurs twice but counts as one distinct palindrome.

 *
 *
 */
public class All_Unique_Sub_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "aabaa";
		String str = "abacdbabefhiihg";
		System.out.println(""+palindrome(str));
	}
	
    //conkey: worked
	public static int palindrome(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int len = str.length();
		Boolean[][] isPalindromeMatrix = new Boolean[len][len];
		for(int i = 0; i < isPalindromeMatrix.length; i++){
			Arrays.fill(isPalindromeMatrix[i], Boolean.FALSE);
		}
		Set<String> set = new HashSet<String>();
		int c =0;
		for (int subLen = 1; subLen <= len; subLen++) {
			for (int i = 0; i < len; i++) {
				if (i + subLen > len) {
					continue;
				}
				String subStr1 = str.substring(i, i + subLen);
//				System.out.println("subStr1: "+(++c)+": "+subStr1);
				System.out.println("i: "+i+", subLen: "+subLen);
				if (subLen == 1 || str.charAt(i) == str.charAt(i + subLen - 1) && (subLen == 2 || isPalindromeMatrix[i + 1][i + subLen - 2])) {
					String subStr = str.substring(i, i + subLen);
					if (!set.contains(subStr)) {
						System.out.println("subStr: "+subStr);
						set.add(subStr);
					}
					isPalindromeMatrix[i][i + subLen - 1] = true;
					System.out.println(""+Matrix.fromRowOfMatrixToString(isPalindromeMatrix, i-1 > 0? i-1:0));
					System.out.println(""+Matrix.fromRowOfMatrixToString(isPalindromeMatrix, i));
				}
			}
		}
		return set.size();
	}

    //conkey: worked
	public static int palindrome8(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int len = str.length();
		boolean[][] isPalindromeMatrix = new boolean[len][len];
		Set<String> set = new HashSet<String>();
		for (int subLen = 1; subLen <= len; subLen++) {
			for (int i = 0; i < len; i++) {
				if (i + subLen > len) {
					continue;
				}
				if (subLen == 1 || str.charAt(i) == str.charAt(i + subLen - 1) && (subLen == 2 || isPalindromeMatrix[i + 1][i + subLen - 2])) {
					String subStr = str.substring(i, i + subLen);
					if (!set.contains(subStr)) {
						set.add(subStr);
					}
					isPalindromeMatrix[i][i + subLen - 1] = true;
				}
			}
		}
		return set.size();
	}

	//my improved, not worked
	public static int palindrome66(String str){
		if(str==null || str.length()==0){
			return 0;
		}
        int len = str.length();
		boolean[][] record = new boolean[len][len];
		Set<String> set = new HashSet<String>();
	   for(int i=0; i < len; i++){
            for(int j = 1; j <= len; j++){
				if( i+j > len){
					continue;
				}
                if( j==1 ||  str.charAt(i)==str.charAt(i+j-1) && (j==2 || record[i+1][i+j-2]) ){
                    String subStr = str.substring(i,i+j);
                    if(!set.contains(subStr)){
                       set.add(subStr);
                    }
                    record[i][i+j-1] = true;
				}
			}
		}
		return set.size();	
	}
	
    //two not pass
    public static int palindrome44(String str) {
        // write your code here
    	int c =0;
    	Set<String> set = new HashSet<String>();
    	for(int i = 0; i< str.length(); i++){
    		for(int j = i+1; j<= str.length(); j++){
				String subStr1 = str.substring(i, j);
				System.out.println("subStr1: "+(++c)+": "+subStr1);

    			String subStr = str.substring(i, j);
    			if(isPalindrome(subStr) && !set.contains(subStr)){
    				set.add(subStr);
    			}
    		}
    	}
        return set.size();
    }


    //five pass, five not pass
    static int palindrome2(String str) {
        // write your code here
        if (str == null) {
            return 0;
        }
        Set<String> set = new HashSet<String>();

        ArrayList<String> path = new ArrayList<String>();
        helper(str, path, 0, set);

        return set.size();

    }

    private static void helper(String str, ArrayList<String> path, int pos,
    		Set<String> set) {
        if (pos == str.length()) {
            return;
        }
        for (int i = pos + 1; i <= str.length(); i++) {
            String prefix = str.substring(pos, i);
            if (isPalindrome(prefix)) {
            	set.add(prefix);
                path.add(prefix);
                helper(str, path, i, set);
                path.remove(path.size() - 1);
            }
        }
    }

    //best, good
    private static boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }


}
