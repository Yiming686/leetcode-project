package LeetCode.JavaArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*

 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.

 Hide Tags Divide and Conquer Array Bit Manipulation

 * 
 */
public class LC_169_Majority_Element {

	public int majorityElement4(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

//	Accepted, best
	public int majorityElement3(int[] nums) {
		int candidate = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (candidate == nums[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					candidate = nums[i];
					count = 1;
				}
			}
		}
		return candidate;
	}

	public int majorityElement(int[] nums) {
		int candidate = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				candidate = nums[i];
				count++;
			} else {
				if (candidate == nums[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		return candidate;
	}

	public int majorityElement2(int[] nums) {
		int candidate = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				candidate = nums[i];
				count++;
			} else {
				if (candidate == nums[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		return candidate;
	}

	public class Solution {
		public int majorityElement(int[] num) {
			if (num == null || num.length == 0)
				return 0;
			int m = num[0];
			int count = 1;

			for (int i = 1; i < num.length; i++) {
				if (count <= 0) {
					m = num[i];
					count = 1;
				} else if (num[i] == m)
					count++;
				else
					count--;
			}
			return m;
		}
	}

	public class Solution2 {
		public int majorityElement(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int m = nums[0];
			int count = 1;

			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 1; i < nums.length; i++) {
				count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
				map.put(nums[i], count + 1);
				;
				if (map.size() == m) {
					while (map.size() == m) {
						Iterator<Map.Entry<Integer, Integer>> it = map
								.entrySet().iterator();
						while (it.hasNext()) {
							Entry<Integer, Integer> entry = it.next();
							if (entry.getValue() == 1)
								map.remove(entry);
							else
								entry.setValue(entry.getValue() - 1);
						}
					}
				}
			}
			for (int i = 1; i < nums.length; i++) {
			}
			return m;
		}
		// public static void main(String[] args) {
		// // TODO Auto-generated method stub
		// Integer.toBinaryString(5);
		// }

	}
}
