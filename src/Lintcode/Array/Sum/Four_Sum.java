package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
4Sum Show result 

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

Have you met this question in a real interview? Yes
Example
Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)
Note
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

Tags Expand 
Two Pointers Sort Hash Table Array


Related Problems Expand 
Medium 3Sum 18 %
Medium Two Sum

 *
 */
public class Four_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i+3 < len; i++){
            // if(nums[i] > 0) break; //因为left和right就是针对i找的，所以只能找一次
            //[容易忘记地方]对i的去重,就是当前和后面的对比
            if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			for(int j = i+1; j+2 < len; j++){
	             if (j != i+1 && nums[j] == nums[j - 1]) {
    				continue; // to skip duplicate numbers; e.g [0,0,0,0]
    			}
                int left = j+1;
                int right = len-1;            
                while(left < right){
                    int sum = nums[i] + nums[j] +nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;//[容易忘记地方]
                        right--;//[容易忘记地方]
                        while(left < right && nums[left] == nums[left-1]){//对left的去重,就是当前和后面的对比
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){//对right的去重,就是当前和后面的对比
                            right--;
                        }
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
			}
        }
        return result;
    }

}
