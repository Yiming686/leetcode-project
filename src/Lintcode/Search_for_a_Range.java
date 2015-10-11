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
//	第一点特殊的是其实终点坐标为size，而不是size-1
//	两个while 循环唯一不同的是 相等的策略 
//	因为这里面有重复值，所以不能像mid-1，mid， mid+1来区分，而要用mid 和mid+1区分,这一点应该在所有场合要记住
//	但是 找起点和找终点，在mid值等于查找值时，策略必须不一样
//	找起点时，移动end到mid；找终点时，移动start到起点
	
//	第一步：搜索看看元素有没有，没有返回 -1，-1
//	第二步：若有则返回相应区间下标，先返回左下标，再返回右下标
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
//		以下两行其实都可以，以为start和end最后是相等的
//		并不是说所有case 都是这样的，而是说只有里面有至少一个元素上面的结论就成立
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
