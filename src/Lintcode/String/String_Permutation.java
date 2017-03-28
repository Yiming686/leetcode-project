package Lintcode.String;

import java.util.Arrays;

/**

String Permutation

Given two strings, write a method to decide if one is a permutation of the other.



 *
 */
public class String_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //  worked
    public static boolean stringPermutation11(String A, String B) {
        // Write your code here
        if(A== null || B == null) return false;
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        // return Arrays.toString(arrA).equals(Arrays.toString(arrB));
        return String.valueOf(arrA).equals(String.valueOf(arrB));
    }
    
    // worked
    public static boolean stringPermutation(String A, String B) {
        // Write your code here
        if(A.length() != B.length())
            return false;
        int[] cnt = new int[256];
        for (int i = 0; i < A.length(); ++i){
            cnt[(int)A.charAt(i)] ++;
            cnt[(int)B.charAt(i)] --;
        }
        // for (int i = 0; i < B.length(); ++i)
        for (int i = 0; i < 256; ++i){
        	if (cnt[i] != 0){
        		return false;
        	}
        }
        return true;
    }


}
