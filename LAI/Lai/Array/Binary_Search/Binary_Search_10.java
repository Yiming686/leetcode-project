package Lai.Array.Binary_Search;

import Lai.Midterm_I_II_III.Min_Cuts;
import Utils.ArrayUtils;
class Out{
	private static int d = 10;
	private int e = 22;

	public static void main(String[] args) {
		Binary_Search_10.ABC dd = new Binary_Search_10.ABC();
		int odd = dd.f;
		int odd2 = dd.g;
	}
}	
public class Binary_Search_10 {
	static class ABC{
		private static int d = 10;
		private int e = 22;
		static int f = 30;
		int g = 44;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("d:"+ABC.d);
		System.out.println("e:"+new  ABC().e);
		System.out.println(""+getValueByIndex(40));
		int start = 1;
		while(getValueByIndex(start) != null) {
			start = 2 * start;
 		}
		System.out.println("start:"+start);
		int end = start;
		start = 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			Integer midValue = getValueByIndex(mid);
			if(midValue == null) {
				end = mid;
			}else {
				start = mid;
			}
		}
		System.out.println("start:"+start);
//		if(getValueByIndex(start) != null) {
//			return start;
//		}
	}

	private static Integer getValueByIndex(int index) {
		int size = 453;
		int[] arr = ArrayUtils.buildIntArraySorted(size, 0, 3*size, false);
//		int[] arr = ArrayUtils.generateIntArraySorted(size, 0, 3*size);
		if(index < size) {
			return arr[index];
		}
		return null;
	}
}
