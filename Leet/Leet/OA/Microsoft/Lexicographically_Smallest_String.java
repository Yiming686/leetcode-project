package Leet.OA.Microsoft;

/**
 * Lexicographically smallest string formed by removing at most one character.
 * 
 * Example 1:
 * 
 * Input: "abczd" Output: "abcd"
 * 
 * Since you could only remove one char, you should remove the first char you
 * see that is greater than the next from left to right, i.e. peak char. If
 * there is no such string, I think you should just remove the last char, i.e.
 * if the string is sorted ascending.
 *
 * 
 * 
 */
public class Lexicographically_Smallest_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSmallestByRemovingOnlyOneChar("abcdz"));
		System.out.println(findSmallestByRemovingOnlyOneChar("adzabzczdz"));//adabzczdz
		System.out.println(findSmallestByRemovingOnlyOneChar("abcczccdz"));
//		abcd
//		abcdz
//		abccccdz

	}

//	因为字典里每一个字幕都是有大小顺序的，然后从左到右根据字符的大小顺序进行排序；
//	所以可以从左到右扫描，依次遇到字符越小越好，如果删除当前字符，右侧的字符就会递进都当前位置；
//	所以当右侧的字符比当前字符大的时候，就不能删除当前字符，必须继续；
//	当第一次发现右侧的字符比当前字符小的时候，就可以删除当前字符，让右侧比较小的字符，递进到当前位置，
//	那么全局看起来，字符串就变小了；然后就不在删除了， 只是把剩余的字符复制一下，即可。
	public static String findSmallestByRemovingOnlyOneChar(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		if(input.length() == 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		char[] arr = input.toCharArray();
		boolean foundOne = false;

		for (int i = 0; i < arr.length - 1; i++) {
			if (!foundOne && arr[i] > arr[i + 1]) {//第一次发现，并且后面的小，删除当前，把右侧字符左移一位
				foundOne = true;
			}else {//foundOne == true || arr[i] <= arr[i + 1]
				sb.append(arr[i]);
			}
		}

		if (foundOne) {
			sb.append(arr[arr.length - 1]);
		}

		return sb.toString();
	}

}
