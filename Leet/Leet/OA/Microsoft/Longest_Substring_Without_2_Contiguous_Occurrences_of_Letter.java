package Leet.OA.Microsoft;

import static Utils.ArrayUtils.print;

import Utils.ArrayUtils;
import sun.util.logging.resources.logging;

public class Longest_Substring_Without_2_Contiguous_Occurrences_of_Letter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "aabbaaaaabb";
		//  expected: aabbaa
//		String str = "aabbaabbaabbaa";
		 // expected: aabbaabbaabbaa
//		String str = "abbaabbaaabbaaa";
//		expected:     abbaabbaa abbaa
//		String str = "abbbaa";
		char[] arr = ArrayUtils.buildCharArrayWithDupHighly(12, 'a', 'b');
		String str = String.valueOf(arr);
		print(str);
//		String str = "abcd";
		//  expected: abbaabbaa
//		String str = ;
		System.out.println("longest Me : "+longestSubstring(str));
		System.out.println("longest Me 2: "+longestSubstring2(str));
	}
//	new version,
//	 如果是abcd组成的字符串呢，而且求不能超过连续2个字符的最长substring，请问只用一个count可以吗
	public static int longestSubstring2(String str) {
		if(str == null) {
			return 0;
		}
		char[] arr = str.toCharArray();
		if(arr.length <= 1) {
			return arr.length;
		}
		int left = 0;
		int right = 1;//from 0
		int countCurrChar = 1;//how many chars so far 
		int longest = 1;
		int start = 0;
		while(right < arr.length) {
			//get curr char
			char ch = arr[right];//current char
			//add ch virtually and count ch
			if(ch == arr[right - 1]) {//must > 1
				countCurrChar++;
			}else {
				countCurrChar = 1;
			}
			if(countCurrChar > 2 ) {
				left = right - 1;
			}
			//upadte longest and move right to next char
//			longest = Math.max(longest, right - left + 1);
			if(right - left + 1 > longest) {
				longest = right - left + 1;
				start = left;
//				System.out.println("--> longest Me 2: " + str.substring(start, start + longest) + ", start:end:longest :: " + start + ":"+(start+longest-1)+":"+longest);
			}
			System.out.println("--> longest Me 2: " + " left:right:length :: " + left + ":"+(right)+":"+(right - left + 1) + ", "+str.substring(left, right+1) );
			right++;
		}
		System.out.println("longest Me 2: " + str.substring(start, start + longest) + ", start:end:longest :: " + start + ":"+(start+longest-1)+":"+longest);
		return longest;
	}

	
//	original version
	public static int longestSubstring(String str) {
		char[] arr = str.toCharArray();
		int left = 0;
		int right = 0;//from 0
		int countA = 0;
		int countB = 0;
		int longest = 0;
		while(right < arr.length) {
			//get curr char
			char ch = arr[right];//current char
			//process first char
			if(right == 0) {
				countA = (ch == 'a') ? 1 : 0;
				countB = (ch == 'b') ? 1 : 0;
				
				longest = 1;
				right++;
				continue;
			}
			//process second to last char
			if(ch == arr[right - 1]) {
				if(ch == 'a') {//  aa 
					if(countA == 2) {//third a, previous coutn
						left = right - 1;
					}else {
						countA++;
					}
				}else {//bb
					if(countB == 2) {//third a
						left = right - 1;
					}else {
						countB++;
					}
				}
			}else {
				if(ch == 'a') {//ba
					countA = 1;
				}else {//ab
					countB = 1;
				}
			}
			//upadte longest and move right to next char
			longest = Math.max(longest, right - left + 1);
			right++;
		}
		return longest;
	}
}
