package LeetCode.JavaArray;

import java.util.Arrays;

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 ¡ú 2
 [1,3,5,6], 2 ¡ú 1
 [1,3,5,6], 7 ¡ú 4
 [1,3,5,6], 0 ¡ú 0

 Hide Tags Array Binary Search

 * 
 */
public class LC_035_Search_Insert_Position {

	// non-recursive solution
//	Accepted
	public int searchInsert(int[] nums, int target) {
		if (nums == null)
			return -1;
		int len = nums.length; 
		int start = 0;
		int end = len - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				end = mid -1;
			else
				start = mid + 1;
		}
		return start;
	}

	// recursive solution
	// Accepted
	public int searchInsert2(int[] nums, int target) {
		if (nums == null)
			return -1;
		int len = nums.length;
		int start = 0;
		int end = len - 1;
		return searchInsert(nums, start, end, target);
	}

	private int searchInsert(int[] nums, int start, int end, int target) {
		// TODO Auto-generated method stub
		int mid = (start + end) / 2;
		if (start == mid) {
			if (target <= nums[start])
				return start;
			else if (target > nums[end])
				return end + 1;
			else
				return end;
		}
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] > target)
			return searchInsert(nums, start, mid - 1, target);
		else
			return searchInsert(nums, mid + 1, end, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
