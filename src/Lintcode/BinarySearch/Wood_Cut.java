package Lintcode.BinarySearch;

public class Wood_Cut {

	// not worked,
	// when (numOfPieces == k),����˵�������������
	//����check(numOfPieces == k)
	public static int woodCut(int[] L, int k) {
		// write your code here
		if (L == null || L.length == 0 || k < 1) {
			return 0;
		}
		// cut wood�ĳ���ֵ����0��L��������ֵ����start��end
		long start = 1;
		long end = 1;
		long maxNumOfPieces = 0;
		for (int el : L) {
			maxNumOfPieces += el;
			if (el > end)
				end = el;
		}
		if (k > maxNumOfPieces)
			return 0;
		// ������Ϊend������Ϊ��Сֵ1��������Ϊ1������Ϊ���ֵ
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			// Ϊʲômid��Ϊ0��midΪ0����start==end==0
			// if (mid == 0) {
			// return 0;
			// }
			long numOfPieces = getPieces(L, mid);
			if (numOfPieces == k) {
				return (int) mid;
			} else if (numOfPieces > k) {

//			if (numOfPieces >= k) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (getPieces(L, end) >= k)
			return (int) end;
		else
			return (int) start;
	}

	// worked
	public static int woodCut2(int[] L, int k) {
		// write your code here
		if (L == null || L.length == 0 || k < 1) {
			return 0;
		}
		// cut wood�ĳ���ֵ����0��L��������ֵ����start��end
		long start = 1;
		long end = 1;
		long maxNumOfPieces = 0;
		for (int el : L) {
			maxNumOfPieces += el;
			if (el > end)
				end = el;
		}
		if (k > maxNumOfPieces)
			return 0;
		// ������Ϊend������Ϊ��Сֵ1��������Ϊ1������Ϊ���ֵ
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			// Ϊʲômid��Ϊ0��midΪ0����start==end==0
			// if (mid == 0) {
			// return 0;
			// }
			long numOfPieces = getPieces(L, mid);
			if (numOfPieces >= k) {
				start = mid;
			} else {
				end = mid - 1;
			}
		}
		if (getPieces(L, end) >= k)
			return (int) end;
		else
			return (int) start;
	}

	static long getPieces(int[] L, long len) {
		int count = 0;
		for (int el : L) {
			count += el / len;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2147483644, 2147483645, 2147483646, 2147483647 };
		int k = 4;
		System.out.println("" + woodCut2(arr, k));
	}

}
