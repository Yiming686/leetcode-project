package Lintcode;

import java.util.ArrayList;

/*
 * Medium Search for a Range

 20% Accepted
 Given a sorted array of n integers, find the starting and ending position of a given target value.

 If the target is not found in the array, return [-1, -1].

 Have you met this question in a real interview? Yes
 Example
 Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

 Challenge
 O(log n) time.

 Tags Expand 
 Binary Search Sorted Array Array
 */
public class Search_for_a_Range {

//	Accepted
//	��һ�����������ʵ�յ�����Ϊsize��������size-1
//	����while ѭ��Ψһ��ͬ���� ��ȵĲ��� 
//	��Ϊ���������ظ�ֵ�����Բ�����mid-1��mid�� mid+1�����֣���Ҫ��mid ��mid+1����,��һ��Ӧ�������г���Ҫ��ס
//	���� ���������յ㣬��midֵ���ڲ���ֵʱ�����Ա��벻һ��
//	�����ʱ���ƶ�end��mid�����յ�ʱ���ƶ�start�����
	
//	��һ������������Ԫ����û�У�û�з��� -1��-1
//	�ڶ����������򷵻���Ӧ�����±꣬�ȷ������±꣬�ٷ������±�
	public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
		// write your code here
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(-1);
		result.add(-1);
		if (A == null)
			return result;
		int size = A.size();
		if (size == 0)
			return result;
		if (A.get(0) > target || A.get(size - 1) < target)
			return result;
		int start = 0;
		int end = size;

		int mid = 0;
		// search for start point
		while (start < end) {
			mid = (start + end) / 2;
			if (A.get(mid) < target)
				start = mid + 1;
			if (A.get(mid) == target)
				end = mid;
			if (A.get(mid) > target)
				end = mid;
		}
		if (A.get(start) != target)
			return result;
		result.set(0, start);
		// search for end point
		end = size;
		while (start < end) {
			mid = (start + end) / 2;
			if (A.get(mid) < target)
				start = mid + 1;
			if (A.get(mid) == target)
				start = mid + 1;
			if (A.get(mid) > target)
				end = mid;
		}
//		����������ʵ�����ԣ���Ϊstart��end�������ȵ�
//		������˵����case ���������ģ�����˵ֻ������������һ��Ԫ������Ľ��۾ͳ���
		result.set(1, end - 1);
//		result.set(1, start - 1);
		return result;
	}

	// solutin from book
	// Accepted
	public ArrayList<Integer> searchRange2(ArrayList<Integer> A, int target) {
		// write your code here
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(-1);
		result.add(-1);
		if (A == null)
			return result;
		int size = A.size();
		if (size == 0)
			return result;
		if (A.get(0) > target || A.get(size - 1) < target)
			return result;
		int start = 0;
		// int end = size -1;
		int end = size;

		int mid = 0;
		// search for start point
		while (start < end) {
			mid = (start + end) / 2;
			if (A.get(mid) < target) {
				start = mid + 1;
			} else if (A.get(mid) == target) {
				end = mid;
			} else {
				end = mid;
			}
		}
		if (A.get(start) != target)
			return result;
		result.set(0, start);
		// search for end point
		end = size;
		while (start < end) {
			mid = (start + end) / 2;
			if (A.get(mid) < target) {
				start = mid + 1;
			} else if (A.get(mid) == target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		result.set(1, end - 1);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
