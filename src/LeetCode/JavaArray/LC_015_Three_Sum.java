package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 Hide Tags Array Two Pointers

 * 
 */
public class LC_015_Three_Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null)
			return null;
		int len = nums.length;
		List<List<Integer>> LL = new ArrayList<List<Integer>>();
		if (len < 3)
			return LL;
		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {
//			����Ŀ���ʵ����������д��룬ȱһ���ɣ�ǰ��������
			// ��Ϊ�������
			if (nums[i] > 0)
				break;
			// �ӵڶ���Ԫ�ؿ�ʼ�����ظ���˵��ǰ��һ���Ѿ������ˣ�continue��ȥ���ظ�
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1;
			int end = len - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum < 0) {
					start++;
				} else if (sum > 0) {
					end--;
				} else {
					List<Integer> intList = new ArrayList<Integer>();
					intList.add(nums[i]);
					intList.add(nums[start]);
					intList.add(nums[end]);
					LL.add(intList);
//					����Ŀ��ξ��ʵ����������д���
					do {
						start++;
					} while (start < end && nums[start] == nums[start - 1]);
					do {
						end--;
					} while (start < end && nums[end] == nums[end - 1]);
				}
			}

		}
		System.out.println(LL.get(0));
		System.out.println(LL.get(1));
		return LL;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { -1, 0, 1, 2, -1, -4 };
		threeSum(S);
	}

}
