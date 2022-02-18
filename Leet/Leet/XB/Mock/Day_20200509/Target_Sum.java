package Leet.XB.Mock.Day_20200509;

public class Target_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println("" + findTargetSumWays(nums, target));
	}

//	int count = 0;

	public static int findTargetSumWays(int[] nums, int target) {
		int[] count = new int[] { 0 };
		calculate(nums, 0, 0, target, count);
		return count[0];
	}

	public static void calculate(int[] nums, int i, int sum, int target, int[] count) {
		if (i == nums.length) {
			if (sum == target)
				count[0]++;
		} else {
			calculate(nums, i + 1, sum + nums[i], target, count);
			calculate(nums, i + 1, sum - nums[i], target, count);
		}
	}

}
