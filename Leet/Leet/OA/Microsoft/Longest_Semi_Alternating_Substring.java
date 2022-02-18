package Leet.OA.Microsoft;

import static Utils.ArrayUtils.print;

import Utils.ArrayUtils;

public class Longest_Semi_Alternating_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// expected: aabbaabbaabbaa
//		String str = "baaabbabbb";//aabbabb
//		expected:     abbaabbaa abbaa
//		String str = "babba";//babba
		String str = "abaaaa";//abaa
		//  expected: abbaabbaa
//		String str = ;
			
//		char[] arr = ArrayUtils.generateCharArrayWithDupHighly(12, 'a', 'b');
//		String str = String.valueOf(arr);
		print(str);
		System.out.println("longest Me 2: " + longestSemi(str));

	}

	private static int longestSemi(String str) {
		// TODO Auto-generated method stub
		if (str == null) {
			return 0;
		}
		char[] arr = str.toCharArray();
		if (arr.length <= 1) {
			return arr.length;
		}
		int left = 0;
		int right = 1;//from 0
		int countCurrChar = 1;//how many chars so far 
		int longest = 1;
		int start = 0;
		while (right < arr.length) {
			//get curr char
			char ch = arr[right];//current char
			//add ch virtually and count ch
			if (ch == arr[right - 1]) {//must > 1
				countCurrChar++;
			} else {
				countCurrChar = 1;
			}
			if (countCurrChar > 2) {
				left = right - 1;
			}
			//upadte longest and move right to next char
//			longest = Math.max(longest, right - left + 1);
			if (right - left + 1 > longest) {
				longest = right - left + 1;
				start = left;
//				System.out.println("--> longest Me 2: " + str.substring(start, start + longest) + ", start:end:longest :: " + start + ":"+(start+longest-1)+":"+longest);
			}
			System.out.println("--> longest Me 2: " + " left:right:length :: " + left + ":" + (right) + ":"
					+ (right - left + 1) + ", " + str.substring(left, right + 1));
			right++;
		}
		System.out.println("longest Me 2: " + str.substring(start, start + longest) + ", start:end:longest :: " + start
				+ ":" + (start + longest - 1) + ":" + longest);
		return longest;
	}

}
