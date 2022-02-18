package Lai.DB20.JQ_II;

import static Utils.ArrayUtils.printf;
import static Utils.TreeNodeUtils.toStr;

import Utils.ArrayUtils;
import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

public class Get_Count_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,3,2};
		System.out.println(""+(5 >= 4));
//		int[] arr = {5,3,1,4, 2,6};
		ArrayUtils.print(arr);
		ArrayUtils.printIntArray(arr);
		System.out.println(""+StringUtils.toStr(countArray(arr)));
	}

	public static int[] countArray(int[] array) {
		// The indexArray contains the indices in the original array,
		// and it will be sorted by the corresponding number in the
		// original array.
		// The countArray is the actual return array.
		// The helper array is to help the merge sort.
		int[] indexArray = initialIndexArray(array);
		int[] countArray = new int[array.length];
		int[] helper = new int[array.length];
		TP root = TP.build("", "011111","", null, StringUtils.toStr(array), StringUtils.toStr(indexArray), StringUtils.toStr(countArray), StringUtils.toStr(helper), 0, array.length - 1);
		mergeSort(array, indexArray, countArray, helper, 0, array.length - 1, root);
		root.print();
		return countArray;
	}

	// The indices are just a - (array.1ength - 1)
	private static int[] initialIndexArray(int[] array) {
		int[] indices = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	private static void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right,TP root) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, indexArray, countArray, helper, left, mid, TP.build(root, StringUtils.toStr(array), StringUtils.toStr(indexArray), StringUtils.toStr(countArray), StringUtils.toStr(helper), left, mid));
		mergeSort(array, indexArray, countArray, helper, mid + 1, right, TP.build(root, StringUtils.toStr(array), StringUtils.toStr(indexArray), StringUtils.toStr(countArray), StringUtils.toStr(helper), mid + 1, right));
		merge(array, indexArray, countArray, helper, left, mid, right);
		
		printf("left:right %s:%s", left, right);
		ArrayUtils.printConsecutiveChar('-', 100);
		
		ArrayUtils.printIntArray("indexArray",indexArray);
		ArrayUtils.printIntArray("countArray",countArray);
		ArrayUtils.printIntArray("helper",helper);
	}

	private static void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
//		ArrayUtils.printConsecutiveChar('-', 100);
//
//		ArrayUtils.printIntArray("indexArray",indexArray);
//		ArrayUtils.printIntArray("countArray",countArray);
//		ArrayUtils.printIntArray("helper",helper);

		copyArray(indexArray, helper, left, right);
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid) {
			// When sorting the indexArray, we use the corresponding value in the
			// original array.
			if (r > right || array[helper[l]] <= array[helper[r]]) {
				countArray[helper[l]] += (r - mid - 1);
				indexArray[cur++] = helper[l++];
			} else {
				indexArray[cur++] = helper[r++];
			}
		}
	}

	private static void copyArray(int[] indexArray, int[] helper, int left, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = indexArray[i];
		}
	}

}
