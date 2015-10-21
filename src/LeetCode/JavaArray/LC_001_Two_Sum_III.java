package LeetCode.JavaArray;

import java.util.Arrays;

import LeetCode.ArrayBuilder;
import LeetCode.ArrayPrinter;

/*
 * 给定一个整数数组，能否找出其中的两个数使得他们的和为一个给定的数。
 * 输入：整数数组，整数
 * 输出：true or false
 * 
 * 【问题to clarify】
 * 1. 数组是排好序的吗 Is this array sorted?
 * 不是有序的，怎么办？是有序的，怎么办？
 * 2.Does this array contain duplicate elements?
 * usually the answer should be no.
 * 
 * 【solutions】【注意事项，数组中数字可能有正有负】
 *1.暴力破解法：两个变量，两层循环，依次求和，找到就返回true退出，最好找不到，返回false。TC为O（n^2）
 *
 *2.提前排序法：为了提高效率，先排序，TC为O（nlogn）。
 * note: 可以排序，是因为结果不在乎顺序，如果结果在乎次序，不能排序，或者不能丢失排序信息。
 * 
 * 
 * 推而广之：如果要求找出三个数，使得他们的和为一个给定的整数呢。
 */
public class LC_001_Two_Sum_III {
	
	public void save(int input){
		
	}
	
	public boolean Test(int target){
		return false;
	}

	// Solution One: TC is O(n^2)
	public static boolean twoSum_ON2(int[] arr, int sum) {
		if (arr == null)
			return false;
		int len = arr.length;
		if (len < 2)
			return false;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] + arr[j] == sum)
					return true;
			}
		}
		return false;
	}

	// TC is O(nlogn)
	public static boolean twoSum(int[] arr, int sum) {
		ArrayPrinter.printIntegerArray(arr);
		Arrays.sort(arr);
		ArrayPrinter.printIntegerArray(arr);
		if (arr == null)
			return false;
		int len = arr.length;
		if (len < 2)
			return false;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			int sumOf2Elements = arr[left] + arr[right];
			if (sumOf2Elements == sum) {
				System.out.printf("%3s %3s %3s %3s \n", left, right, arr[left],
						arr[right]);
				return true;
			} else if (sumOf2Elements < sum) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayBuilder.createIntegerArray_WithDups(1, -18, 1);
		System.out.println(twoSum(arr, -13));
	}

}
