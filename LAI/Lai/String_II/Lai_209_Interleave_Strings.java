package Lai.String_II;

public class Lai_209_Interleave_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canMerge(String a, String b, String c) {
		// Write your solution here
		int lenA = a.length();
		int lenB = b.length();
		int lenC = c.length();
		if (lenC != lenA + lenB) {
			return false;
		}
		boolean[][] canMerge = new boolean[lenA + 1][lenB + 1];
		canMerge[0][0] = true;
		for (int j = 1; j <= lenB; j++) {
			// arr[0][j] = b.substring(0, j).equals(c.substring(0, j));
			canMerge[0][j] = canMerge[0][j - 1] && b.charAt(j - 1) == c.charAt(j - 1);
		}
		for (int i = 1; i <= lenA; i++) {
			// arr[i][0] = a.substring(0, i).equals(c.substring(0, i));
			canMerge[i][0] = canMerge[i - 1][0] && a.charAt(i - 1) == c.charAt(i - 1);
		}
		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				// ´íÎóÂß¼­
				// if(c.charAt(i + j - 1) == a.charAt(i-1)){
				//   arr[i][j] = arr[i-1][j];
				// }else if(c.charAt(i + j - 1) == b.charAt(j-1)){
				//   arr[i][j] = arr[i][j-1];
				// }else{
				//   arr[i][j] = false;
				// }        
				canMerge[i][j] = canMerge[i - 1][j] && c.charAt(i + j - 1) == a.charAt(i - 1)
						|| canMerge[i][j - 1] && c.charAt(i + j - 1) == b.charAt(j - 1);
			}
		}
		return canMerge[lenA][lenB];
	}

}
