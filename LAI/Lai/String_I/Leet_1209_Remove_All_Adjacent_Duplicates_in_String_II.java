package Lai.String_I;

import java.util.ArrayDeque;
import java.util.Deque;

import Utils.SU;

/**
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
 *
 */
public class Leet_1209_Remove_All_Adjacent_Duplicates_in_String_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("50. Pow(x, n)");
	}

	// 2 <= k <= 10^4
	// 1 <= s.length <= 10^5
	public static String removeDuplicates(String s, int k) {
		if (s == null || s.length() == 0) {
			return s;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		char[] arr = s.toCharArray();
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			char ch = arr[right];
			if (left == 0 || ch != arr[left - 1]) {
				arr[left++] = ch;
				stack.offerFirst(1);
			} else {
				if (stack.peekFirst() == k - 1) {
					left -= k - 1;
					stack.pollFirst();
				} else {
					arr[left++] = ch;
					stack.offerFirst(stack.pollFirst() + 1);
				}
			}
		}
		return String.valueOf(arr, 0, left);
		// return new String(arr, 0, left);
	}

}
