package Lai.String_II;

/**
Given a string with only character 'a' and 'b', replace some of the characters 
such that the string becomes in the forms of all the 'b's are on the right side of all the 'a's.

Determine what is the minimum number of replacements needed.

Assumptions:

The given string is not null.
Examples:

"abaab", the minimum number of replacements needed is 1 (replace the first 'b' with 'a' 
so that the string becomes "aaaab").

 *
 */
public class Lai_350_Replacements_Of_A_And_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minReplacements(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		char[] arr = input.toCharArray();
		int[] left2Right2A = new int[arr.length];//i is exclusive
		int[] right2Left2B = new int[arr.length];//i is exclusive
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == 'a') {
				left2Right2A[i] = left2Right2A[i - 1];
			} else {
				left2Right2A[i] = left2Right2A[i - 1] + 1;
			}
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i + 1] == 'a') {
				right2Left2B[i] = right2Left2B[i + 1] + 1;
			} else {
				right2Left2B[i] = right2Left2B[i + 1];
			}
		}
		int global = arr.length;
		for (int i = 0; i < arr.length; i++) {
			global = Math.min(global, left2Right2A[i] + right2Left2B[i]);
		}
		return global;
	}

}
