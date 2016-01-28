package Lintcode.String.Palindrome;

/**

Valid Palindrome Show result 

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Have you met this question in a real interview? Yes
Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Note
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Challenge
O(n) time without extra memory.

Tags Expand 
String Two Pointers Facebook Zenefits Uber


Related Problems Expand 
Medium Palindrome Linked List
 *
 */
public class Valid_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //best solution, my solution
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < end && !isValid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }
            while (front < end && ! isValid(s.charAt(end))) { // same here, need to check border of 
                end--;
            }
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                front++;
                end--;
            }
        }
        return true;
    }

    private boolean isValid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
