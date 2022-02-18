package Leet.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Leet_325_Minimum_Size_Subarray_Sum_Equals_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, -1, 5, -2, 3};
		System.out.println(""+minSubArrayLen(arr, 3));
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
    
	public static int maxSubArrayLen(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();//sum to index, for i, latest unique sum and its index
		map.put(0, -1);
		int sum = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];//curr new sum
			Integer index = map.get(sum - target);
			if (index != null) {
				maxLen = Math.max(maxLen, j - index);//j - index + 1 or j - index 
			}
			index = map.get(sum);
			if (index == null) {
				map.put(sum, j);//rightmost sum and its index                
			}
		}
		return maxLen;
	}


}
