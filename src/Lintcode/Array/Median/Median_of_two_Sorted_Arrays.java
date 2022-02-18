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
// ���������������ˣ�����solution ˵�������⵫��û����ȫ����

	// ��arr1��start1λ�ú�arr2��start2��λ�ÿ�ʼ�����Ҵ�С����ĵ�k��Ԫ�أ�Ҳ�͵�kС��Ԫ��
	// ��ô�ҵ�k���Ԫ���أ�
//	�����漰��2�����飬kһ�������ڵ���1����k=1ʱֻ���漰��1�����飬����һ������
	
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
// 		1.three corner cases����ʼindex�������lengthʧȥ���壬�����ȴ�������ɵߵ�
		if (start1 >= arr1.length) {
			return arr2[start2 + k - 1];
		}
		if (start2 >= arr2.length) {
			return arr1[start1 + k - 1];
		}
//		2.��֤�˴�start1��start2��Ϊindexһ������Ч���ˣ������kһ��Ҫ���ڵ���2����Ч�����������ɷ�������λ��
//		��������˵Ѱ�ҵ�kС�����kС��2������û�����壬����k=1��corner case����������
		if (k == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
// 		����������������ˣ�k�п��ܱȽϴ�����������ֱ�Ӵ���ֱ��ȥ��k/2��Ԫ��
		// ���´����k>=2����Ч������ǰ������

		if (start1 + k / 2 - 1 >= arr1.length) {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
		if (start2 + k / 2 - 1 >= arr2.length) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		}
//		�˴���֤�������鶼�е�k/2���㣬����ȽϺ�ɾ��������������
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

	// ��arr1��start1λ�ú�arr2��start2��λ�ÿ�ʼ�����Ҵ�С����ĵ�k��Ԫ�أ�Ҳ�͵�kС��Ԫ��
	// ��ô�ҵ�k���Ԫ���أ�
	public static int findKthSmallest12(int[] arr1, int start1, int[] arr2, int start2, int k) {
		if (start1 >= arr1.length) {
			return arr2[start2 + k - 1];
		}
		if (start2 >= arr2.length) {
			return arr1[start1 + k - 1];
		}
		// ���ܷ�����ǰ����Ϊ����ȷ���������Ƿ�Ϊ�ա�����AΪ�գ�BΪ[1]��
		// Ҳ����˵�˾��ǰ����������������һ��Ԫ�أ��Ų��ᱨ��
		// corner case: StackOverflowError
		if (k == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
		// ���´����k>=2����Ч������ǰ������
		// ȡ��һ������ĵ�k/2��Ԫ��
		int val1 = start1 + k / 2 - 1 < arr1.length ? arr1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
		int val2 = start2 + k / 2 - 1 < arr2.length ? arr2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

		if (val1 < val2) {
			return findKthSmallest(arr1, start1 + k / 2, arr2, start2, k - k / 2);
		} else {
			return findKthSmallest(arr1, start1, arr2, start2 + k / 2, k - k / 2);
		}
	}

}
