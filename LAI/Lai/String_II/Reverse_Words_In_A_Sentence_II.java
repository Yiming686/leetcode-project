package Lai.String_II;

public class Reverse_Words_In_A_Sentence_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	best ever,
	public static String reverseWords(String input) {
		// Write your solution here
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		reverse(arr, 0, arr.length - 1);
		int start = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
				start = i;
			}
			if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')) {
				reverse(arr, start, i);
			}
		}
		return new String(arr);
	}

	private static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}

	private static void swap(char[] arr, int start, int end) {
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
