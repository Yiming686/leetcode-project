package Lintcode.Array.Sum;

import java.util.Arrays;

public class Three_Sum_Closet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//思路：得排序吧？否则不好逐步来找最近的和
	//把所有的遍历完毕找出最下的	
	//核心三步逻辑：定义一个最近和，在循环中更新，退出循环后，返回最近和
    //worked, perfect implementation
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        int closestSum = nums[0] + nums[1] + nums[len-1];//最近的三数和
        for(int i = 0; i+2 < len; i++){
            if (i != 0 && nums[i] == nums[i - 1]) {
				continue; 
			}
            int left = i+1;
            int right = len-1;            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
                //核心逻辑：新的三数和比旧三数和距离target更近，替换之
                if(Math.abs(sum-target) < Math.abs(closestSum - target)){
                    closestSum = sum;        
                }
            }
        }
        return closestSum;
    }


}
