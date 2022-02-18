package Leet.String.Palindrome;

/**
Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.

After doing so, return the final string.  If there is no way to do so, return the empty string.

 

Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Example 2:

Input: palindrome = "a"
Output: ""
 

Constraints:

1 <= palindrome.length <= 1000
palindrome consists of only lowercase English letters.

 *
 */
public class Leet_1328_Break_a_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("palindrome");
		System.out.println("" + sb.toString());
	}

//  Best ever, Time: O(N), Space: O(1)
	public static String breakPalindrome(String palindrome) {
		if (palindrome == null || palindrome.length() <= 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder(palindrome);
		int len = palindrome.length();
		int left = 0;
		int right = len - 1;
		while (left < right) {
			char ch = palindrome.charAt(left);
			if (ch != 'a') {
				sb.setCharAt(left, 'a');
				return sb.toString();
			}
			left++;
			right--;
		}
		sb.setCharAt(len - 1, 'b');
		return sb.toString();
	}

//	not worked,
	public String breakPalindrome55(String palindrome) {
		if (palindrome == null || palindrome.length() == 0) {
			return "";
		}
		int len = palindrome.length();
		int mid = (len - 1) / 2;
		int pos = -1;
		boolean charFound = false;
		for (int i = 0; i <= mid; i++) {
			char ch = palindrome.charAt(i);
			if (ch != 'a') {
				charFound = true;
				pos = i;
				break;
			}
		}
		if (!charFound) {
			return "";
		}
		StringBuilder sb = new StringBuilder(palindrome);
		sb.replace(pos, pos, "a");
		return sb.toString();
	}

}
