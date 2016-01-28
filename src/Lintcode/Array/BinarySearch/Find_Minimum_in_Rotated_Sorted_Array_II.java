package Lintcode.Array.BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array_II {

	// perfect solution
	public static int findMin(int[] num) {
		int start = 0, end = num.length - 1;
		while (start < end) {
			if (num[start] < num[end])
				return num[start];
			int mid = start + (end - start) / 2;
			if (num[mid] < num[end])
				end = mid;
			else if (num[mid] > num[end])
				start = mid + 1;
			else
				end--;
		}
		return num[start];
	}

	// perfect solution also
	public int findMin2(int[] num) {
		int start = 0, end = num.length - 1;
		while (start + 1 < end) {
			if (num[start] < num[end])
				return num[start];
			int mid = start + (end - start) / 2;
			if (num[mid] < num[end])
				end = mid;
			else if (num[mid] > num[end])
				start = mid + 1;
			else
				end--;
		}
		// return num[start];
		return num[start] < num[end] ? num[start] : num[end];
	}

	// worked, but not better
	public int findMin7(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0, end = nums.length - 1;

		while (start + 1 < end) {
			if (nums[start] < nums[end])
				return nums[start];
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[start]) {
				start = mid + 1; // mid有可能是min，所以得保留
			} else if (nums[mid] < nums[start]) {
				end = mid; // mid肯定不是min，不必保留
				// start = mid; //也是正确的，都可以通过
			} else {
				if (nums[mid] > nums[end]) {
					start = mid + 1;
				} else {
					int min = nums[start];
					for (int i = start + 1; i < end; i++) {
						min = Math.min(nums[i], min);
					}
					return min;
				}
			}

		}
		return nums[start] < nums[end] ? nums[start] : nums[end];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
