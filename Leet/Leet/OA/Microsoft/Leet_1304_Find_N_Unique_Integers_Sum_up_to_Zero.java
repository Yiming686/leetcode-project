package Leet.OA.Microsoft;

/**
Given an integer n, return any array containing n unique integers 
such that they add up to 0.


 *
 */
public class Leet_1304_Find_N_Unique_Integers_Sum_up_to_Zero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] sumZero(int n) {
		int[] result = new int[n];
		if (n % 2 == 1) {
			result[0] = 0;
		}
		int j = 0;
		for (int i = 1; i <= n / 2; i = i + 1) {
			result[j] = i;
			result[j + 1] = -i;
			j = j + 2;
		}
		return result;
	}

}
