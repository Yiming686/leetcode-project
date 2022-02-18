package Lai.DB16.DP_III;

public class LC_213_House_Robber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private static int rob(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int robMax = 0;//�Ե�ǰ��β�������ã�  ���õ������ֵ��������ò���δ֪
		int notRobMax = 0;//�Ե�ǰ��β�����Ҳ��ã����õ������ֵ, ������ò���δ֪
		for (int i = start; i <= end; i++) {
			int temp = robMax;
			robMax = notRobMax + nums[i];
			notRobMax = Math.max(notRobMax, temp);
		}
		return Math.max(robMax, notRobMax);
	}

}
