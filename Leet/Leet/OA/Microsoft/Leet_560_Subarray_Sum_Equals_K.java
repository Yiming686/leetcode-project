package Leet.OA.Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Leet_560_Subarray_Sum_Equals_K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1}; 
		int k = 2;	
		System.out.println(""+subarraySum(nums, k));
	}

	public static int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();//subarray sum to counter
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

}
