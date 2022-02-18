package Leet.String.Palindrome;

public class Leet_647_Palindromic_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "abc";
		System.out.println(""+countSubstrings(s));
	}

	private static boolean isPal() {
		// TODO Auto-generated method stub
		return true;
	}

	public static int countSubstrings(String s) {
		char[] arr = s.toCharArray();
		return countSubstrings(arr, 0, arr.length - 1);
	}

	private static int countSubstrings(char[] arr, int left, int right) {
		int len = arr.length;
		int count = 0;
		boolean[][] isPal = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			isPal[i][i] = true;
			count++;
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j] && (j - i + 1 <= 3 || isPal[i + 1][j - 1])) {
					isPal[i][j] = true;
					count++;
				}
			}
		}
		return count;
	}

}
