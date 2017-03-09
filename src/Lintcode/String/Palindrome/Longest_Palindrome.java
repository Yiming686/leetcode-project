package Lintcode.String.Palindrome;

/**
409. Longest Palindrome

   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 25571
Total Submissions: 57375
Difficulty: Easy
Contributors: Admin
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Subscribe to see which companies asked this question

Hide Tags Hash Table
Hide Similar Problems (E) Palindrome Permutation


 *
 *
 */
public class Longest_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dccaccd";
		str = "abcadefa";
		System.out.println(""+longestPalindrome(str));
	}
    public static int longestPalindrome(String s) {
        if(s == null) return 0;
        if(s.length() == 1){
            return 1;
        }
        int[] charStatArray = new int[256];
        int evenCount = 0;
        int oddCount = 0;
        int max = 0;
        for(char ch : s.toCharArray()){
            charStatArray[ch]++;
        }
        for(int count : charStatArray){
            if(count != 0){
                if(count %2 == 0){
                    evenCount += count;
                }else if(count == 1){
                    oddCount++;
                }else{
                    oddCount++; //oneTimeCountÏà¼Ó
                    evenCount += count - 1;//count - 1
                }
            }
        }
        max = oddCount > 0 ? 1 + evenCount : evenCount;
        return max;
    }
}
