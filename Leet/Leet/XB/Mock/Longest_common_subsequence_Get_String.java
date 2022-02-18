package Leet.XB.Mock;

import Utils.MatrixUtils;

/**
 * d h a g s i d a h s g j LCS: dhs, dhg, dag, dhg, dag
 * 
 * adbcdhefgahijgklsmnl i abcdefghaijhhlmsnogpqr
 *
 * 
 */
public class Longest_common_subsequence_Get_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "d h a g s ";
		String str2 = "d a   h      s  g y f";
		str1 = str1.replace(" ", "");
		str2 = str2.replace(" ", "");
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
//		System.out.println(""+str1.replace(" ", "5"));
//		System.out.println(""+str1.replaceAll(" ", "5"));
		System.out.println("" + lcs_dp(str1, str2));
		;
//		System.out.println(""+lcs_dp(str1.replace(" ", "5"), str2.replaceAll(" ", "")));;
//		System.out.println(""+lcs_dp(str1.replace(" ", ""), str2.replace(" ", "")));;
	}
//	Recursion
//	This is not a particularly fast algorithm, but it gets the job done eventually. The speed is a result of many recursive function calls.

//	public static String lcs(String a, String b){
	public static String lcs(String a, String b) {
		int lenStr1 = a.length();
		int lenStr2 = b.length();
		if (lenStr1 == 0 || lenStr2 == 0) {
			return "";
		}
		if (a.charAt(lenStr1 - 1) == b.charAt(lenStr2 - 1)) {
			return lcs(a.substring(0, lenStr1 - 1), b.substring(0, lenStr2 - 1)) + a.charAt(lenStr1 - 1);
		}
		String x = lcs(a, b.substring(0, lenStr2 - 1));
		String y = lcs(a.substring(0, lenStr1 - 1), b);
		return (x.length() > y.length()) ? x : y;
	}

//	Dynamic Programming
//	public static String lcs(String a, String b) {
	public static String lcs_dp(String a, String b) {
		int[][] maxLen = new int[a.length() + 1][b.length() + 1];

		// row 0 and column 0 are initialized to 0 already
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++)
				if (a.charAt(i) == b.charAt(j)) {
					maxLen[i + 1][j + 1] = maxLen[i][j] + 1;
				} else {
					maxLen[i + 1][j + 1] = Math.max(maxLen[i + 1][j], maxLen[i][j + 1]);
				}
		}
		System.out.println("" + MatrixUtils.fromMatrixToString(maxLen));
		// read the substring out from the matrix
		StringBuffer sb = new StringBuffer();
		int x = a.length(), y = b.length();
		while (x > 0 && y > 0) {
			if (maxLen[x][y] == maxLen[x - 1][y]) {
				x--;
			} else if (maxLen[x][y] == maxLen[x][y - 1]) {
				y--;
			} else {
				assert a.charAt(x - 1) == b.charAt(y - 1);
				sb.append(a.charAt(x - 1));
				x--;
				y--;
			}
		}
		return sb.reverse().toString();
	}

}
