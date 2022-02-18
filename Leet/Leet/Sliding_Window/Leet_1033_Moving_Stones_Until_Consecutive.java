package Leet.Sliding_Window;

import static Utils.ArrayUtils.printIntArray;

import Utils.ArrayUtils;
import Utils.SU;

public class Leet_1033_Moving_Stones_Until_Consecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("730. Count Different Palindromic Subsequences\n" + 
				"");
		int[] arr = ArrayUtils.buildIntArraySorted(3, 0,20);
		printIntArray(arr, 3);
		
		printIntArray(numMovesStones(arr[0],arr[1],arr[2]), 3);;

	}

	private static int[] numMovesStones(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
