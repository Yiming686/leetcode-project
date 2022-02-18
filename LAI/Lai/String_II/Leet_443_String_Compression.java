package Lai.String_II;

public class Leet_443_String_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abbcccdeee";
//		String str = "abcdef";
		String str = "a";
//		String str = "aabbccc";
		System.out.println("" + compress(str.toCharArray()));

	}

//	best of best, 
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

//	当知道当前位置fast的字符的个数后, 就可以不断复制值到slow，并且对slow进行更新
	private static int update(char[] chars, int slow, int fast, int count) {
		chars[slow++] = chars[fast];
		if (count != 1) {
			String countStr = Integer.toString(count);
			System.arraycopy(countStr.toCharArray(), 0, chars, slow, countStr.length());
            slow += countStr.length();
		}
		return slow;
	}

//	对当前位置fast的字符进行 个数统计，然后返回个数
	private static int count(char[] chars, int fast) {
		int count = 0;
		char curr = chars[fast];
		while (fast < chars.length && chars[fast] == curr) {
			count++;
			fast++;
		}
		return count;
	}

	//worked, best
    public static int compress01(char[] chars) {
		int slow = 0;//pos to insert new char
		int fast = 0;//
		while (fast < chars.length) {
			char curr = chars[fast];
			int count = 0;
			while (fast < chars.length && chars[fast] == curr) {
				count++;
				fast++;
			}
			chars[slow++] = curr;
			if (count != 1) {
				String countStr = Integer.toString(count);
//				System.arraycopy(countStr.toCharArray(), 0, chars, slow, countStr.length());
//                slow += countStr.length();
			      char[] arr = countStr.toCharArray();
			      for(char ch : arr){
			        chars[slow++] = ch;
			      }

			}
		}
		return slow;
	}

//	443. String Compression, worked but not good
	public static int compress00(char[] arr) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = arr.length;
		Integer count = 1;
		count = 1;
		int slow = 0;//当前待插入位置
		int firstPos = 0;//当前字符的第一个位置
		for (int i = 1; i < len; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			} else {
				arr[slow++] = arr[firstPos];
				if (count > 1) {
					String countStr = String.valueOf(count);
					System.arraycopy(countStr.toCharArray(), 0, arr, slow, countStr.length());
					slow += countStr.length();
				}
				count = 1;
				firstPos = i;//更新当前字符的第一个位置
			}
		}
		arr[slow++] = arr[firstPos];
		if (count > 1) {
			String countStr = String.valueOf(count);
			System.arraycopy(countStr.toCharArray(), 0, arr, slow, countStr.length());
			slow += countStr.length();
		}
		return slow;
	}

//	
	public static String compress(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		if (input.length() == 1) {
			return input + "1";
		}
		char[] result = input.toCharArray();
		int len = input.length();
		Integer count = 1;
//		int newLen = 0;
//		for(int i = 1; i < len; i++) {
//			if(input.charAt(i) == input.charAt(i-1)) {
//				count++;
//			}else {
//				newLen++;
//				newLen += String.valueOf(count).length();
//				count = 1;
//			}
//		}//"ab"
//		newLen++;
//		newLen += String.valueOf(count).length();
//
//		if(newLen > len) {
//			result = new char[newLen];
//		}
		count = 1;
		int slow = 0;//当前待插入位置
		int firstPos = 0;//当前字符的第一个位置
		for (int i = 1; i < len; i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				count++;
			} else {
				result[slow++] = input.charAt(firstPos);
				if (count > 1) {
					String countStr = String.valueOf(count);
					System.arraycopy(countStr.toCharArray(), 0, result, slow, countStr.length());
					slow += countStr.length();
				}
				count = 1;
				firstPos = i;//更新当前字符的第一个位置
			}
		}
		result[slow++] = input.charAt(firstPos);
		if (count > 1) {
			String countStr = String.valueOf(count);
			System.arraycopy(countStr.toCharArray(), 0, result, slow, countStr.length());
			slow += countStr.length();
		}
//		result[slow++] = input.charAt(firstPos);		
//		String countStr = String.valueOf(count);
//		System.arraycopy(countStr.toCharArray(), 0, result, slow, countStr.length());
//		slow += countStr.length();
		return new String(result, 0, slow);
	}

}
