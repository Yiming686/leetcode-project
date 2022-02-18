package Lai.DFS_I;

import java.util.LinkedList;
import java.util.List;

public class Reverse_Words_In_A_Sentence_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<>();
		list.add(3, 0);
		
		String str = " I love Google ";
		System.out.println(""+str);
		System.out.println("" + reverseWords(str));

		str = "  Words are separated by single space  ";
		System.out.println(""+str);
		System.out.println("" + reverseWords(str));
	}

	public static String reverseWords(String input) {
		// Write your solution here
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		int start = 0, end = arr.length - 1;
		reverse(arr, start, end);
		System.out.println(""+String.valueOf(arr));
		for (int i = 0, j = 0; j < arr.length; j++) {
			if (j == arr.length - 1) {
				reverse(arr, i, j);
			}else if (arr[j] == ' ' || j == arr.length - 1) {
				reverse(arr, i, j - 1);
				i = j + 1;
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
