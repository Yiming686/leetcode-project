package Leet.OA.Other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Min_Deletion_To_Make_Freq_unique {

	public static void main(String[] args) {
		String[] testcases = { "eeeeffff", "aabbffddeaee", "llll", "example", "aaaaaabbbbbccccddddeeeeee" };
//		String[] testcases = { "bbccaadd" };
		for (String testcase : testcases) {
			System.out.println(minDel(testcase));
		}
	}

	public static int minDel(String str) {
		Map<Character, Integer> map = new HashMap<>();//�ַ�-->������������ڵ���1��
		Set<Integer> set = new HashSet<>();
		int minDel = 0;

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		for (int val : map.values()) {//ÿ���ַ�ֻ�ܶ�Ӧunique��ֵ�����Է����ظ��ͱ�����٣�����������ظ��ͼ������٣�ֱ��0��
			while (set.contains(val) && val > 0) {//
				val--;
				minDel++;
			}
			set.add(val);
		}
		return minDel;
	}

}
