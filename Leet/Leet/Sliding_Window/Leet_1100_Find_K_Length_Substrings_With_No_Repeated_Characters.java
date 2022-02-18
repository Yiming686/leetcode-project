package Leet.Sliding_Window;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, return the number of substrings of length K with no
 * repeated characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "havefunonleetcode", K = 5 Output: 6 Explanation: There are 6
 * substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 * Example 2:
 * 
 * Input: S = "home", K = 5 Output: 0 Explanation: Notice K can be larger than
 * the length of S. In this case is not possible to find any substring.
 * 
 * 
 * Note:
 * 
 * 1 <= S.length <= 10^4 All characters of S are lowercase English letters. 1 <=
 * K <= 10^4
 *
 * 
 */
public class Leet_1100_Find_K_Length_Substrings_With_No_Repeated_Characters {

//	abcdedfghhh
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "havefunonleetcode";
		int k = 5;
		System.out.println("" + numKLenSubstrNoRepeats(str, k));

	}

//	set只是用来保证在加入arr[fast]之前,它里面是没有arr[fast]的，也就是slow跳跃到最近的arr[fast]字符之后的位置
//	衡量以fast结尾的所有substring，
	public static int numKLenSubstrNoRepeats(String str, int k) {
		int count = 0;
		char[] arr = str.toCharArray();
		int slow = 0;
		Set<Character> set = new HashSet<>();
		for (int fast = 0; fast < arr.length; fast++) {
			// while(i - slow + 1 > k || set.size() != i - slow + 1){
//            while(i - slow + 1 > k || set.contains(arr[i])){
			while (set.contains(arr[fast])) {
				set.remove(arr[slow]);
				slow++;
			}
			set.add(arr[fast]);
			System.out.println("" + String.valueOf(arr, slow, fast - slow + 1));
			if (fast - slow + 1 == k) {
				System.out.println("*****");
				count++;
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			set.add(arr[i]);
//			while (i - slow + 1 > k || set.size() != i - slow + 1) {
//                set.remove(arr[slow]);
//				slow++;
//			}
//			System.out.println(""+String.valueOf(arr, slow, i - slow + 1));
//			if (i - slow + 1 == k) {
//				System.out.println("*****");
//				count++;
//			}
//		}
		return count;
	}

}
