package Lintcode;

/*
Medium Sort Letters by Case

36% Accepted
Given a string which contains only letters. Sort it by lower case first and upper case second.

Have you met this question in a real interview? Yes
Example
For "abAcD", a reasonable answer is "acbAD"

Note
It's not necessary to keep the original order of lower-case letters and upper case letters.

Challenge
Do it in one-pass and in-place.

Tags Expand 
String Two Pointers LintCode Copyright Sort
 */

public class Sort_Colors_by_Case {

    public void sortLetters(char[] chars) {
        //write your code here
        if( chars == null || chars.length == 0)return;
        
        int i = 0;
        int j = chars.length -1;
        
        while(i<=j){
            while(i<=j && (chars[i] >= 'a' && chars[i] <= 'z')) i++;
            while(i<=j && (chars[j] >= 'A' && chars[j] <= 'Z')) j--;
            if(i<j){
                chars[i]^=chars[j];
                chars[j]^=chars[i];
                chars[i]^=chars[j];
            }
        }
    }

    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
