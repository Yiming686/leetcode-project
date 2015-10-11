package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/********************************************
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * Input: [3,2,4], 6 Output: [0,0] Expected: [2,3] //
 * if(map.containsKey(target-nums[i])){ if (map.containsKey(target - nums[i]) &&
 * target != 2*nums[i] ) {
 * 
 * 
 * Input: [0,4,3,0], 0 Output: [-1,-1] Expected: [1,4]
 */

public class LC_001_Two_Sum_II {

	// Solution One: TC is O(n^2), Accepted,480ms, too slow
	public int[] twoSum_ON2(int[] nums, int target) {
		int[] ret = { -1, -1 };

		if (nums == null)
			return ret;
		int len = nums.length;
		if (len < 2)
			return ret;

//		注意边界条件，i 从 0 到 len -1，j从 i + 1 到len - 1
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					ret[0] = i + 1;
					ret[1] = j + 1;
					return ret;
				}
			}
		}
		return ret;

	}

	public int[] twoSum_II_ONLOGN(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null) {
			return ret;
		}
		int len = nums.length;
		if (len < 2) {
			return ret;
		}

		int left = 0;
		int right = len - 1;
		while (left < right) {
			int sumOf2Elements = nums[left] + nums[right];
			if (sumOf2Elements == target) {

				ret[0] = left + 1;
				ret[1] = right + 1;
				return ret;
			} else if (sumOf2Elements < target) {
				left++;
			} else {
				right--;
			}
		}
		return ret;
	}

	// O(n) solution, but does not apply when there are duplicate elements
	public int[] twoSum_II_NoDup_ON(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null) {
			return ret;
		}
		int len = nums.length;
		if (len < 2) {
			return ret;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// because there are no duplicates, so creating map like this.
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < len; i++) {
			// the following condition is wrong, when [[3,2,4],6] or
			// [[9,2,16],18]
			// if(map.containsKey(target-nums[i])){
			// so have to add : target != 2 * nums[i]
			if (map.containsKey(target - nums[i]) && target != 2 * nums[i]) {
				ret[0] = i + 1;
				ret[1] = map.get(target - nums[i]) + 1;
				return ret;
			}
		}
		return ret;
	}

	// works on LeetCode, TC is O(N)
	// O(n) solution, and CAN handle duplicate elements
//Accepted, 320ms {300,320,450}
	public int[] twoSum_II_WithDups_ON(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null) {
			return ret;
		}
		int len = nums.length;
		if (len < 2) {
			return ret;
		}

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < len; i++) {
			int key = nums[i];
			if (map.containsKey(key)) {
				map.get(key).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(key, list);
			}
		}
		for (int i = 0; i < len; i++) {
			int key = nums[i];
			if (target == 2 * key){
			    if( map.get(nums[i]).size() >= 2) {
    				ret[0] = map.get(key).get(0) + 1;
    				ret[1] = map.get(key).get(1) + 1;
    				return ret;
			    }
			}else{ 
			    if (map.containsKey(target - key)) {
    				ret[0] = i + 1;
    				ret[1] = map.get(target - key).get(0) + 1;
    				return ret;
			    }
			}
		}
		return ret;
	}

	public int[] twoSum_II_WithDups_ON_2(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null) {
			return ret;
		}
		int len = nums.length;
		if (len < 2) {
			return ret;
		}

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums[i])) {
				map.get(nums[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		for (int i = 0; i < len; i++) {
			// the following condition is wrong, when [[3,2,4],6] or [[9,2,16],
			// 18]
			// if(map.containsKey(target-nums[i])){
			if (target == 2 * nums[i] && map.get(nums[i]).size() >= 2) {
				ret[0] = map.get(nums[i]).get(0) + 1;
				ret[1] = map.get(nums[i]).get(1) + 1;
				return ret;
			}
			if (map.containsKey(target - nums[i]) && target != 2 * nums[i]) {
				ret[0] = i + 1;
				ret[1] = map.get(target - nums[i]).get(0) + 1;
				return ret;
			}
		}
		return ret;
	}
}
