package Lai.DB24.JQ_IV;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import Utils.ArrayUtils;

public class Maximum_Values_Of_Size_K_Sliding_Windows {

	public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

		// TODO Auto-generated method stub
//		int [] arr = {1, 2, 3, 2, 4, 2, 1,0};
		int m = 100000;
		while (--m >= 0) {
			int[] arr = ArrayUtils.buildIntArray(7, 0, 20, false);
			int k = 3;
//			printIntArray(arr);
			maxWindows(arr, k);
//			System.out.println(""+maxWindows(arr, k));
		}
	}

	public static List<Integer> maxWindows(int[] arr, int k) {
		// Assumptions: array is not null or not empty,
		// k >= 1 and k <= a.length.
		List<Integer> maxList = new ArrayList<Integer>();
		// use a descending deque to solve this problem,
		// we store the index instead of the actual value in the deque,
		// and we make sure:
		// 1. the deque only contains index in the current sliding window.
		// 2. for any index, the previous index with smaller value is
		// discarded from the deque.
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			// discard any index with smaller value than index i.
			while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
				deque.pollLast();
			}
			// it is possible the head element is out of the current
			// sliding window so we might need to discard it as well.
//			if(deque.size() > k) {
//				System.out.println("==================: size() >= k");
//			}
			if (!deque.isEmpty() && deque.peekFirst() < i - k) {
				System.out.println("==================: peekFirst() < i - k");
			}

			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				maxList.add(arr[deque.peekFirst()]);
			}
//			System.out.println("deque:"+deque);
//			printTree(null);
//			
//			fromMatrixToString(new char[3][3]);
//			ppprintf("", "");
//			printf("arr: %s\n", new Object() );

//			printf("arr: %s\n", Arrays.toString(arr));
//			print("deque: %s\n", deque);
		}
		return maxList;
	}

	public static List<Integer> maxWindows_44(int[] arr, int k) {
		// Assumptions: array is not null or not empty,
		// k >= 1 and k <= a.length.
		List<Integer> maxList = new ArrayList<Integer>();
		// use a descending deque to solve this problem,
		// we store the index instead of the actual value in the deque,
		// and we make sure:
		// 1. the deque only contains index in the current sliding window.
		// 2. for any index, the previous index with smaller value is
		// discarded from the deque.
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			// discard any index with smaller value than index i.
			while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
				deque.pollLast();
			}
			// it is possible the head element is out of the current
			// sliding window so we might need to discard it as well.

			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				maxList.add(arr[deque.peekFirst()]);
			}
		}
		return maxList;
	}

public boolean checkInclusion(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();    
	if (len1 > len2){
        return false;
    }			
	int[] count1 = new int[26];
	int[] count2 = new int[26];
	for (int i = 0; i < len1; i++) {
		count1[s1.charAt(i) - 'a']++;
	}
    for (int i = 0; i < len2; i++) {
        if(i >= len1){
		    count2[s2.charAt(i - len1) - 'a']--;                
        }
		count2[s2.charAt(i) - 'a']++;
		if (matches(count1, count2)){
            return true;
        }
	}
	return false;
}
private boolean matches(int[] count1, int[] count2) {
	for (int i = 0; i < 26; i++) {
		if (count1[i] != count2[i])
			return false;
	}
	return true;
}
}
