package Leet.OA.Microsoft;

import Utils.SU;

/**
 * @author yiming
 *
 */
public class Min_Deletions_To_Obtain_String_in_Right_Format {

	public static void main(String[] args) {
		String s1 = "BAAABAB";
		String s2 = "BBABAA";
		String s3 = "AABBBB";
		System.out.println(minDelete(s1));
		System.out.println(minDelete(s2));
		System.out.println(minDelete(s3));
		SU.ll("82. Remove Duplicates from Sorted List II\n" + 
				"");
	}

	private static int minDelete(String str) {
		int countA = 0, countB = 0, minCount = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'A') {
				countA++;
				if (countB > minCount) {
					minCount++;
				}
			} else {
				countB++;
				if (countA == 0) {
					minCount++;
				}
			}
		}
		return Math.min(countA, Math.min(countB, minCount));
	}
}
