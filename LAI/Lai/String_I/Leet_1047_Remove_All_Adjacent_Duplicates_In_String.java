package Lai.String_I;

import Utils.SU;

/**
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 

Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
 *
 */
public class Leet_1047_Remove_All_Adjacent_Duplicates_In_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+((-2)/2));
	}

	public static String removeDuplicates(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			if (left == 0 || arr[right] != arr[left - 1]) {
				arr[left++] = arr[right];
			} else {
				left--;
				// while(i+ 1 < arr.length && arr[i] == arr[i+1]){
				// i++;
				// }
			}
		}
		return new String(arr, 0, left);
	}

}
