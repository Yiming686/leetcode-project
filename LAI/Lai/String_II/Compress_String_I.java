package Lai.String_II;

/**
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

Examples

“abbcccdeee” → “ab2c3de3”

 *
 */
public class Compress_String_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abbcccdeee";
		String str = "abcdef";
		System.out.println(""+compress(str));

	}

	public static String compress(String input) {
		char[] arr = input.toCharArray();
		int slow = 0;//pos to insert new char
		int fast = 0;//
		while (fast < arr.length) {
			int count = count(arr, fast);//
			slow = update(arr, slow, fast, count);
			fast += count;
		}
		return new String(arr, 0, slow);
	}

//			best of best, 
	public static int compress(char[] chars) {
		int slow = 0;//pos to insert new char
		int fast = 0;//
		while (fast < chars.length) {
			int count = count(chars, fast);//
			slow = update(chars, slow, fast, count);
			fast += count;
		}
		return slow;
	}

//			当知道当前位置fast的字符的个数后, 就可以不断复制值到slow，并且对slow进行更新
	private static int update(char[] chars, int slow, int fast, int count) {
		chars[slow++] = chars[fast];
		if (count != 1) {
			String countStr = Integer.toString(count);
			//System.arraycopy(countStr.toCharArray(), 0, chars, slow, countStr.length());
			//slow += countStr.length();
			char[] arr = countStr.toCharArray();
			for (char ch : arr) {
				chars[slow++] = ch;
			}
		}
		return slow;
	}

//			对当前位置fast的字符进行 个数统计，然后返回个数
	private static int count(char[] chars, int fast) {
		int count = 0;
		char curr = chars[fast];
		while (fast < chars.length && chars[fast] == curr) {
			count++;
			fast++;
		}
		return count;
	}

}
