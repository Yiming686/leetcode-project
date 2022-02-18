package Leet.OA.Microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Min_Swaps_to_Make_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "mamad";
//		String str = "asflkj";
//		String str = "aabb";
		String str = "ntiin";
		System.out.println(""+minSwaps(str));
//		System.out.println(""+minSwaps_2(str));
	}
//	public static int minSwaps_2(String str) {
//		char[] arr = str.toCharArray();
//		Set<Character> set = new HashSet<>();
//		Map<Character, TreeSet<Integer>> map = new HashMap<>();
////		for (char c : arr) {
//		int len = arr.length;
//		int result = -1;
//		for(int i = 0; i< len; i++) {//O(N)
//			char ch = arr[i];
//			if (set.contains(ch)) {
//				set.remove(ch);
//			} else {
//				set.add(ch);
//			}
////			TreeSet<Integer> treeSet = map.getOrDefault(ch, new TreeSet<Integer>());
////			treeSet.add(i);
////			map.put(ch, treeSet);
//		}
//		//if set.size() < 2, can form Palindrome
//		if(set.size() > 1) {
//			return result;
//		}
//		if(set.size() == 1) {
//			Character midCh = set.toArray(new Character[0])[0];
//			int pos = map.get(midCh).first();
//			int midPos = (len-1) / 2;
//			int diff = pos - midPos;
//			result += diff > 0 ? diff : -diff;
//			if(pos <= midPos) {
//				while(pos < midPos) {
//					swap(arr, pos, pos + 1);
//					pos++;
//				}
//
//			}else {
//				while(pos > midPos) {
//					swap(arr, pos, pos - 1);
//					pos--;
//				}
//			}
//		}
//		for(int i = 0; i< len; i++) {//O(N*logN)
//			char ch = arr[i];
//			TreeSet<Integer> treeSet = map.getOrDefault(ch, new TreeSet<Integer>());
//			treeSet.add(i);
//			map.put(ch, treeSet);
//		}
//
//		for(int i = 0; i< len; i++) {//O(N)
//			char ch = arr[i];
//			TreeSet<Integer> treeSet = map.getOrDefault(ch, new TreeSet<Integer>());
//			if(treeSet.size() > 1) {
//				int diff = treeSet.first() - treeSet.last();	
//			}
//		}
//
//	}

	public static int minSwaps(String str) {
		char[] arr = str.toCharArray();
		int result = 0;
		if (!canFormPalindrome(arr)) {
			return -1;
		}
		int i = 0;
		int j = arr.length - 1;
		int k = j;
		while (i < j) {
			k = j;
			while (arr[i] != arr[k] && k > i) {
				k--;
			}
			//k to find right most arr[i]
			if (arr[i] == arr[k] && i != k) {
				while (k < j) {
					swap(arr, k, k + 1);
					k++;
					result++;
				}
				i++;
				j--;
			} else {//s1[i] != s1[k] || i == k
				swap(arr, i, i + 1);
				result++;
			}

		}
		return result;
	}
	private static boolean canFormPalindrome(char[] s1) {
		HashSet<Character> hs = new HashSet<>();
		for (char c : s1) {
			if (hs.contains(c)) {
				hs.remove(c);
			} else {
				hs.add(c);
			}
		}
		return hs.size() < 2;
	}

	private static void swap(char[] s2, int i, int j) {
		char tmp = s2[i];
		s2[i] = s2[j];
		s2[j] = tmp;
	}

}
