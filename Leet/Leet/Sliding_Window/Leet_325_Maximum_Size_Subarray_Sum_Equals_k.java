package Leet.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

import Utils.SU;

public class Leet_325_Maximum_Size_Subarray_Sum_Equals_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1, -1, 5, -2, 3};
		SU.leet("1040. Moving Stones Until Consecutive II");
		int[] arr = {-2, -1, 2, 1};
		int target = 1;
		System.out.println(""+maxSubArrayLen(arr, target));
		System.out.println(""+minSubArrayLen(arr, target));

	}

	public static int maxSubArrayLen(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int maxLen = 0;
		//sum2RightMostIndexMap
		Map<Integer, Integer> map = new HashMap<>();//sum to index, for i, latest unique sum and its index
		map.put(0, -1);
		int sum = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];//curr new sum
			Integer index = map.get(sum - target);
			if (index != null) {
//				maxLen = Math.max(maxLen, j - index);//j - index + 1 or j - index 
				if(j - index >= maxLen) {
					maxLen = j - index;
					System.out.println("rightMost index: "+index);
					System.out.println("rightMost     j: "+j);
				}
			}
			index = map.get(sum);
			if (index == null) {
				map.put(sum, j);//leftMost sum and its index                
			}
		}
		return maxLen;
	}
	
    public static int minSubArrayLen(int[] arr, int target) {
        if(arr == null || arr.length == 0){
            return 0;
        }
//        int minLen = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();//sum to index, for i, latest unique sum and its index
        map.put(0, -1);
        int sum = 0;
        for(int j = 0; j < arr.length; j++){
            sum += arr[j];//curr new sum
            Integer index = map.get(sum - target);
            if(index != null){
                minLen = Math.min(minLen, j - index );//j - index + 1 or j - index 
            }
            map.put(sum, j);//rightmost sum and its index            
        }
        return minLen;
    }


}
