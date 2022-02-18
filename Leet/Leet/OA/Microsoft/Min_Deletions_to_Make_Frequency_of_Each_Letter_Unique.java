package Leet.OA.Microsoft;

import static Utils.ArrayUtils.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string s consisting of n lowercase letters, you have to delete the
 * minimum number of characters from s so that every letter in s appears a
 * unique number of times. We only care about the occurrences of letters that
 * appear at least once in result.
 *
 * 
 * 
 */
public class Min_Deletions_to_Make_Frequency_of_Each_Letter_Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "eeeeffff";//Output: 1
		String str = "aabbffddeaee";//	Output: 6
///		String str = "llll";//Output: 0
//		String str = "example";//Output: 4

//		char[] arr = ArrayUtils.generateCharArrayWithDupHighly(12, 'a', 'b');
//		String str = String.valueOf(arr);
		print(str);
//		String str = "abcd";
		//  expected: abbaabbaa
//		String str = ;
//		System.out.println("longest Me : "+ minDeleteFreqUnique(str));
		System.out.println("longest Me : " + minDeleteFreqUnique2(str));

	}

	private static int minDeleteFreqUnique2(String str) {
		if (str == null || str.length() <= 1) {
			return 0;
		}
		Integer[] freq = new Integer[26];
		for (int i = 0; i < freq.length; i++) {
			freq[i] = 0;
		}
//		int[] freq = new int[26];
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i] - 'a']++;
		}
		int numDelete = 0;
		Arrays.sort(freq, Collections.reverseOrder());//sort in descending order
		for (int i = 1; i < freq.length; i++) {
			if (freq[i] == 0) {
				break;
			}
			if (freq[i] >= freq[i - 1]) {
				if (freq[i - 1] == 0) {
					numDelete += freq[i];
					freq[i] = 0;
				} else {
					numDelete += freq[i] - freq[i - 1] + 1;

					freq[i] = freq[i - 1] - 1;
				}
			}
		}
		System.out.println(numDelete);
		return numDelete;
	}

	private static int minDeleteFreqUnique(String str) {
		if (str == null || str.length() <= 1) {
			return 0;
		}
		char[] arr = str.toCharArray();
		Map<Character, Integer> char2CountMap = new HashMap<>();
		TreeMap<Integer, Integer> count2NumMap = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Integer prevCount = char2CountMap.get(ch);
			if (prevCount == null) {
				char2CountMap.put(ch, 1);
				count2NumMap.put(1, count2NumMap.getOrDefault(1, 0) + 1);
			} else {
				char2CountMap.put(ch, prevCount + 1);
				int num = count2NumMap.getOrDefault(prevCount, 0);
				if (num == 1) {
					count2NumMap.remove(prevCount);
				} else {
					count2NumMap.put(prevCount, count2NumMap.getOrDefault(prevCount, 0) - 1);
				}
				count2NumMap.put(prevCount + 1, count2NumMap.getOrDefault(prevCount + 1, 0) + 1);
			}
		}
		int result = 0;
		List<Integer> list = new ArrayList<>(count2NumMap.values());
		Iterator<Map.Entry<Integer, Integer>> it = count2NumMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			int key = entry.getKey();
			int val = entry.getValue();
			result += val - 1;
			count2NumMap.put(key, 1);
			count2NumMap.put(key - 1, count2NumMap.getOrDefault(key - 1, 0) + val - 1);
		}
		return result;
	}

}
