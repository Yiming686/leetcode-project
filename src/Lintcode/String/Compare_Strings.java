package Lintcode.String;

import java.util.LinkedList;
import java.util.List;

/**
Compare Strings Show result 

15:00
 Start
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Have you met this question in a real interview? Yes
Example
For A = "ABCD", B = "ACD", return true.

For A = "ABCD", B = "AABC", return false.

Note
The characters of B in A are not necessary continuous or ordered.

Tags Expand 
Basic Implementation String LintCode Copyright


Related Problems Expand 
Easy Two Strings Are Anagrams

 *
 */
public class Compare_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//只要A中包含B中所有的字符即可，
    public static boolean compareStrings(String A, String B) {
        List<Character> list = new LinkedList<Character>();
        for(Character ch : A.toCharArray()){
            list.add(ch);
        }
        
        for(Character ch : B.toCharArray()){
            if(!list.contains(ch))
                return false;
            else
                list.remove(ch);
        }
        return true;
    } 
    
    //worked
    public static boolean compareStrings4(String A, String B) {
        // write your code here
        String s = A, t = B;
        //the following not worked
        // String s = B, t = A;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[ s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[ t.charAt(i)]--;
            if (count[ t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;

    }



}
