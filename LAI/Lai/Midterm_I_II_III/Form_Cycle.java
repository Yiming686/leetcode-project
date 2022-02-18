package Lai.Midterm_I_II_III;

import static Utils.ArrayUtils.swap;

public class Form_Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] arr= {"aaa", "bbb", "baa", "aab"};//"aaa"  "aab" "bbb","baad",
//		String[] arr= {"eabcadadde"};
		String[] arr= {"kabc", "cdef", "fghijk"};
		System.out.println(""+canFormCycle(arr));
	}

	private static boolean canFormCycle(String[] arr) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		return canFormCycle(arr, 0);
	}

	private static boolean canFormCycle(String[] arr, int pos) {
		if(pos == arr.length) {
			return canChain(arr[arr.length - 1], arr[0]);
		}
		boolean result = false;
		for(int i = pos; i < arr.length; i++) {
			if(pos == 0 || canChain(arr[pos-1], arr[i])) {
				swap(arr, pos, i);
				result |= canFormCycle(arr, pos + 1);
				swap(arr, pos, i);
			}
		}
		return result;
	}
	
	private static boolean canChain(String str1, String str2) {
		if(str1 == null || str2 == null) {
			return false;
		}
		if(str1.length() == 0 || str2.length() == 0) {
			return false;
		}
		if(str1.charAt(str1.length() - 1) == str2.charAt(0)) {
			return true;
		}
		return false;
	}

}
