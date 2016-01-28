package Lintcode.Array.BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array {
	// worked
	public static int findMin1(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			if (nums[start] < nums[end])
				return nums[start];
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid; // mid有可能是min，所以得保留
			} else {
				start = mid + 1; // mid肯定不是min，不必保留
				// start = mid; //也是正确的，都可以通过
			}
		}
		return nums[start] < nums[end] ? nums[start] : nums[end];
	}

	// worked, as well
	public static int findMin2(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0, end = nums.length - 1;
		while (start < end) {
			// 下面一行，精彩之笔
			if (nums[start] < nums[end])
				return nums[start];
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid; // mid有可能是min，所以得保留
			} else {
				start = mid + 1; // mid肯定不是min，不必保留
				// start = mid; //也是正确的，都可以通过
			}
		}
		return nums[start];
	}

	// recursive solution
	public static int findMin4(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return -1;
		return helper(nums, 0, nums.length - 1);
	}

	private static int helper1(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0)
			return -1;
		if (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				start = mid + 1;
			}
			return helper(nums, start, end);
		}
		return nums[start] < nums[end] ? nums[start] : nums[end];
	}

	private static int helper(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0)
			return -1;
		if (start + 1 >= end) {
			return nums[start] < nums[end] ? nums[start] : nums[end];
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] < nums[end]) {
			end = mid;
		} else {
			start = mid + 1;
		}
		return helper(nums, start, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
