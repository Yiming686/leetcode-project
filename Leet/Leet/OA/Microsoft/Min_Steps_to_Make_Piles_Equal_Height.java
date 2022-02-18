package Leet.OA.Microsoft;

import static Utils.ArrayUtils.toStr;

import java.util.Arrays;

public class Min_Steps_to_Make_Piles_Equal_Height {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = { 5, 5, 2,1,1,1, 2, 2, 1 };
//		int[] piles = {5,2,2,2,2,1};
		System.out.println("" + minSteps(piles));
	}

	public static int minSteps(int[] piles) {
		int len = piles.length;
		if (len <= 1) {
			return 0;
		}
		Arrays.sort(piles);//1,2,2,2,5,5
		System.out.println(""+toStr(piles, true));
		int res = 0, distinctNums = 0;//
		for (int i = 1; i < len; ++i) {
			if (piles[i] == piles[i - 1]) {
				res += distinctNums;
			} else {
				distinctNums++;
				res += distinctNums;
			}
			System.out.println("--> " + " distinctNums:res :: " + distinctNums + ":"+res);
		}
		return res;
	}
}
