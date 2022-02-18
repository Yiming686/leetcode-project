package Lai.String_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * Input: words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Output:[
 * 
 * "This is an",
 * 
 * "example of text",
 * 
 * "justification. "
 * 
 * ]
 * 
 * 
 * 
 * Input: words: [¡°This¡±, ¡°is¡±, ¡°my¡±] L = 5
 * 
 * Output: [
 * 
 * ¡°This ¡±,
 * 
 * ¡°is my¡±
 * 
 * ]
 *
 * 
 */
public class Text_Justification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "I", "love", "the", "world " };
		System.out.println(""+ Arrays.asList(arr));
		System.out.println(""+fullJustify(arr, 6));
	}

// Solution from Leetcode
/*
 * 
 * We start with left being the first word.
 * 
 * findRight: Then we greedily try to go as far right as possible until we fill
 * our current line.
 * 
 * Then we justify one line at a time.
 * 
 * justify: In all cases we pad the right side with spaces until we reach max
 * width for the line;
 * 
 * If it's one word then it is easy, the result is just that word. If it's the
 * last line then the result is all words separated by a single space. Otherwise
 * we calculate the size of each space evenly and if there is a remainder we
 * distribute an extra space until it is gone.
 * 
 * 
 */

	public static ArrayList<String> fullJustify(String[] words, int maxWidth) {
		//Input your code here
		ArrayList<String> result = new ArrayList<>();
		int left = 0;
		while (left < words.length) {
			int right = findRight(left, words, maxWidth);
			System.out.println("right: "+ right);
			String str =justify(left, right, words, maxWidth);
			System.out.println("str:"+str);
			result.add(str);
			left = right + 1;
		}
		return result;
	}

	 static int findRight(int left, String[] words, int maxLen) {
		int right = left;
		int sum = words[right].length();
		right++;
		int len = words.length;
		while (right < len && sum + 1 + words[right].length() <= maxLen) {
			sum += 1 + words[right].length();
			right++;
		}
		return right - 1;
	}

	// Ã¿ÐÐ
	 static String justify(int left, int right, String[] words, int maxLen) {
		boolean isLastLine = right == words.length - 1 ? true : false;
		int numOfPlaces = right - left;//Might be zero, places to insert spaces
		int numOfChars = wordsLen(left, right, words);
		int numOfSpaces = maxLen - numOfChars;//

		int pos = left;
		StringBuilder sb = new StringBuilder(words[pos++]);
		if (left == right) {
			sb.append(createSpaces(maxLen - numOfChars - numOfPlaces));
			return sb.toString();
		}

		String spaces = isLastLine ? " " : createSpaces(numOfSpaces / numOfPlaces);
		int remainder = isLastLine ? 0 : numOfSpaces % numOfPlaces;
		while (pos <= right) {
			sb.append(spaces).append(remainder > 0 ? " " : "").append(words[pos++]);
			remainder--;
		}
		if (isLastLine) {
			sb.append(createSpaces(maxLen - numOfChars - numOfPlaces));
		}
		return sb.toString();
	}

	 static int wordsLen(int left, int right, String[] words) {
		int len = 0;
		for (int i = left; i <= right; i++) {
			len += words[i].length();
		}
		return len;
	}

	 static String createSpaces(int len) {
		String str = "";
		while (--len >= 0) {
			str += " ";
		}
		return str;
	}

}
