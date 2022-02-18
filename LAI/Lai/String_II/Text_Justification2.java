package Lai.String_II;

import java.util.ArrayList;
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
 * Input: words: [��This��, ��is��, ��my��] L = 5
 * 
 * Output: [
 * 
 * ��This ��,
 * 
 * ��is my��
 * 
 * ]
 *
 * 
 */
public class Text_Justification2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int left = 0;

		while (left < words.length) {
			int right = findRight(left, words, maxWidth);
			result.add(justify(left, right, words, maxWidth));
			left = right + 1;
		}

		return result;
	}

//	װ�����ܶ�ĵ�maxWidth���ҵ����һ��right�����˵�һ�����ʣ� ÿһ������ǰ�涼���һ���ո�
//		Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//	The input array words contains at least one word.
//��һ�������룬�����Եĳ��ԣ��������һ���ո񣬲����һ���ո�����𣿻ش𣺲����ԣ���Ϊ�������
	private int findRight(int left, String[] words, int maxWidth) {
		int right = left;
		int sum = words[right++].length();

		while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
			sum += 1 + words[right++].length();

		return right - 1;//[������]����ĵ���̫��������maxWidth�� return ��ǰ��index�����ǵ�һ��return 0��
	}

//	ÿ�����һλ���������һ�����ʵ����һ���ַ��𣿵�Ȼ
	private String justify(int left, int right, String[] words, int maxWidth) {
		if (right - left == 0) {//���˰���,ֻ�ҵ�һ�����ʣ��ڶ����Ų��£����ǿ�����Ҫpad������룬
			return padResult(words[left], maxWidth);
		}

		boolean isLastLine = right == words.length - 1;
		int numSpaces = right - left;
		int totalSpace = maxWidth - wordsLength(left, right, words);

		String space = isLastLine ? " " : blank(totalSpace / numSpaces);
		int remainder = isLastLine ? 0 : totalSpace % numSpaces;

		StringBuilder result = new StringBuilder();
		for (int i = left; i <= right; i++) {
			result.append(words[i]).append(space).append(remainder > 0 ? " " : "");
			remainder--;
		}

		return padResult(result.toString().trim(), maxWidth);
	}

	private int wordsLength(int left, int right, String[] words) {
		int wordsLength = 0;
		for (int i = left; i <= right; i++) {
			wordsLength += words[i].length();
		}
		return wordsLength;
	}

	private String padResult(String result, int maxWidth) {
		return result + blank(maxWidth - result.length());
	}

	private String blank(int length) {
		return new String(new char[length]).replace('\0', ' ');
	}

}
