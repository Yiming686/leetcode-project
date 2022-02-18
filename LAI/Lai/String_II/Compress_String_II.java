package Lai.String_II;

/**
 * Given a string, replace adjacent, repeated characters with the character
 * followed by the number of repeated occurrences.
 * 
 * Assumptions
 * 
 * The string is not null
 * 
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * 
 * Examples
 * 
 * “abbcccdeee” → “a1b2c3d1e3”
 *
 * 
 */
public class Compress_String_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abbcccdeee";
		String str = "abcdef";
		System.out.println("" + compress(str));
	}

	public static String compress(String input) {
		int len = input.length();
		int newLen = calculateLen(input);
		char[] inputArr = input.toCharArray();
		char[] result = newLen > len ? new char[newLen] : inputArr;
		int count = 0;//
		int slow = 0;//pos to insert new char
		int fast = 0;//
		while (fast < inputArr.length) {
			count = count(inputArr, fast);//
			slow = update(result, slow, inputArr, fast, count);
			fast += count;
		}
		return new String(result, 0, slow);
	}

	private static int calculateLen(String input) {		
		int newLen = 0;
		for (int i = 1; i < input.length(); i++) {
			newLen++;			
			Integer count = count(input, input.charAt(i));
			newLen += String.valueOf(count).length();
		} 
		return newLen;
	}
	

//	当知道当前位置fast的字符的个数后, 就可以不断复制值到slow，并且对slow进行更新
	private static int update(char[] result, int slow, char[] arr, int fast, int count) {
		result[slow++] = arr[fast];
		// if (count != 1) {
		String countStr = Integer.toString(count);
		// System.arraycopy(countStr.toCharArray(), 0, chars, slow, countStr.length());
		// slow += countStr.length();
		char[] countChar = countStr.toCharArray();
		for (char ch : countChar) {
			result[slow++] = ch;
		}
		// }
		// else{
		// }
		return slow;
	}

//	对当前位置fast的字符进行 个数统计，然后返回个数
	private static int count(char[] chars, int fast) {
		if(fast < 0 || fast >= chars.length) {
			return -1;
		}
		int count = 0;
		char curr = chars[fast];
		while (fast < chars.length && chars[fast] == curr) {
			count++;//核心逻辑
			fast++;//循环变量
		}
		return count;
	}
	private static int count(String str, int fast) {
		if(fast < 0 || fast >= str.length()) {
			return -1;
		}
		char[] chars = str.toCharArray();
		int count = 0;
		char curr = chars[fast];
		while (fast < chars.length && chars[fast] == curr) {
			count++;//核心逻辑
			fast++;//循环变量
		}
		return count;
	}

}
