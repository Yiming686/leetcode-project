package Lintcode.Array.Median;

import java.util.Arrays;

/**
 * Median of two Sorted Arrays
 * 
 * Description Notes Testcase Judge There are two sorted arrays A and B of size
 * m and n respectively. Find the median of the two sorted arrays.
 * 
 * Have you met this question in a real interview? Yes Example Given
 * A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * 
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * 
 * Challenge The overall run time complexity should be O(log (m+n)).
 * 
 * Tags Sorted Array Divide and Conquer Array Zenefits Uber Google Related
 * Problems Hard Data Stream Median 24 % Easy Median 21 %
 *
 * 
 */
public class Median_of_two_Sorted_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = {2,2,2,3,4,5};
//		int[] arr2 = {};
//		System.out.println(""+findMedianSortedArrays( arr1, arr2));
//		System.out.println(""+findKthSmallest( arr1,0, arr2,0,1));
//		System.out.println(""+findKthSmallest( arr1,0, arr2,0,2));
//		System.out.println(""+findKthSmallest( arr1,0, arr2,0,3));
//		System.out.println(""+findKthSmallest( arr1,0, arr2,0,4));
//		System.out.println(""+findKthSmallest( arr1,0, arr2,0,5));
//		System.out.println(""+findKthSmallest( arr1,0, arr2,0,6));

//		return 3.5
		int arr1[] = { 4, 5, 6, 1, 2, 3 };
		int arr2[] = { 2, 3, 4, 5 };

//		return 2.5
//		int arr1[] = {1,2,3};
//		int arr2[] = {3,4};

		System.out.println("" + findMedianSortedArrays(arr1, arr2));

	}

// 	worked, much better than Jiuzhang, looks good
// 这是真正搞明白了，九章solution 说明会做题但是没有完全明白

	// 从arr1的start1位置和arr2的start2的位置开始，查找从小到大的第k个元素，也就第k小的元素
	// 那么找第k大的元素呢？
//	想想涉及到2个数组，k一般必须大于等于1，当k=1时只会涉及到1个数组，这是一个特例
	
	public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int len = arr1.length + arr2.length;
		if (len % 2 == 1) {
			return findKthSmallest(arr1, 0, arr2, 0, len / 2 + 1);
		} else {
			return (findKthSmallest(arr1, 0, arr2, 0, len / 2) + findKthSmallest(arr1, 0, arr2, 0, len / 2 + 1)) / 2.0;
		}
	}

	public static int findKthSmallest(int[] arr1, int start1, int[] arr2, int start2, int k) {
		if (start1 >= arr1.length) {
			return arr2[start2 + k - 1];
		}
		if (start2 >= arr2.length) {
			return arr1[start1 + k - 1];
		}
		if (k == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
		if (start1 + k / 2 - 1 >= arr1.length) {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
		if (start2 + k / 2 - 1 >= arr2.length) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		}
		if (arr1[start1 + k / 2 - 1] < arr2[start2 + k / 2 - 1]) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		} else {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
	}

	public static int findKthSmallest2(int[] arr1, int start1, int[] arr2, int start2, int k) {
// 		1.three corner cases，起始index如果大于length失去意义，所以先处理，次序可颠倒
		if (start1 >= arr1.length) {
			return arr2[start2 + k - 1];
		}
		if (start2 >= arr2.length) {
			return arr1[start1 + k - 1];
		}
//		2.保证此处start1和start2作为index一定是有效的了，后面的k一般要大于等于2才有效，此特例不可放在上面位置
//		两个数组说寻找第k小，如果k小于2，问题没有意义，所以k=1是corner case，单独处理
		if (k == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
// 		这才是真正搞明白了，k有可能比较大，两种特例：直接处理，直接去掉k/2个元素
		// 以下代码对k>=2才有效，这是前提条件

		if (start1 + k / 2 - 1 >= arr1.length) {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
		if (start2 + k / 2 - 1 >= arr2.length) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		}
//		此处保证两个数组都有第k/2个点，下面比较和删除，才有了意义
		if (arr1[start1 + k / 2 - 1] < arr2[start2 + k / 2 - 1]) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		} else {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
	}

	// worked, jiuzhang solution
	public static double findMedianSortedArrays12(int[] arr1, int[] arr2) {
		// write your code here

		int len = arr1.length + arr2.length;
		if (len % 2 == 1) {
			return findKthSmallest(arr1, 0, arr2, 0, len / 2 + 1);
		} else {
			return (findKthSmallest(arr1, 0, arr2, 0, len / 2) + findKthSmallest(arr1, 0, arr2, 0, len / 2 + 1)) / 2.0;
		}
	}

	// 从arr1的start1位置和arr2的start2的位置开始，查找从小到大的第k个元素，也就第k小的元素
	// 那么找第k大的元素呢？
	public static int findKthSmallest12(int[] arr1, int start1, int[] arr2, int start2, int k) {
		if (start1 >= arr1.length) {
			return arr2[start2 + k - 1];
		}
		if (start2 >= arr2.length) {
			return arr1[start1 + k - 1];
		}
		// 不能放在最前，因为不能确保两数组是否为空。例如A为空，B为[1]，
		// 也就是说此句的前提是两数组至少有一个元素，才不会报错
		// corner case: StackOverflowError
		if (k == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
		// 以下代码对k>=2才有效，这是前提条件
		// 取第一个数组的第k/2个元素
		int val1 = start1 + k / 2 - 1 < arr1.length ? arr1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
		int val2 = start2 + k / 2 - 1 < arr2.length ? arr2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

		if (val1 < val2) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		} else {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
	}

}
